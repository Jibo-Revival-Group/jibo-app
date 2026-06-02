package com.segment.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import com.segment.analytics.Client;
import com.segment.analytics.PayloadQueue;
import com.segment.analytics.integrations.AliasPayload;
import com.segment.analytics.integrations.BasePayload;
import com.segment.analytics.integrations.GroupPayload;
import com.segment.analytics.integrations.IdentifyPayload;
import com.segment.analytics.integrations.Integration;
import com.segment.analytics.integrations.Logger;
import com.segment.analytics.integrations.ScreenPayload;
import com.segment.analytics.integrations.TrackPayload;
import com.segment.analytics.internal.Utils;
import com.yalantis.ucrop.util.FileUtils;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
class SegmentIntegration extends Integration<Void> {
    static final int MAX_BATCH_SIZE = 475000;
    static final int MAX_PAYLOAD_SIZE = 15000;
    static final int MAX_QUEUE_SIZE = 1000;
    static final String SEGMENT_KEY = "Segment.io";
    private static final String SEGMENT_THREAD_NAME = "Segment-SegmentDispatcher";
    private final Map<String, Boolean> bundledIntegrations;
    private final Cartographer cartographer;
    private final Client client;
    private final Context context;
    private final Crypto crypto;
    private final int flushQueueSize;
    private final Handler handler;
    private final Logger logger;
    private final ExecutorService networkExecutor;
    private final PayloadQueue payloadQueue;
    private final Stats stats;
    static final Integration.Factory FACTORY = new Integration.Factory() { // from class: com.segment.analytics.SegmentIntegration.1
        @Override // com.segment.analytics.integrations.Integration.Factory
        public Integration<?> create(ValueMap valueMap, Analytics analytics) {
            return SegmentIntegration.create(analytics.getApplication(), analytics.client, analytics.cartographer, analytics.networkExecutor, analytics.stats, Collections.unmodifiableMap(analytics.bundledIntegrations), analytics.tag, analytics.flushIntervalInMillis, analytics.flushQueueSize, analytics.getLogger(), analytics.crypto);
        }

        @Override // com.segment.analytics.integrations.Integration.Factory
        public String key() {
            return SegmentIntegration.SEGMENT_KEY;
        }
    };
    static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    final Object flushLock = new Object();
    private final ScheduledExecutorService flushScheduler = Executors.newScheduledThreadPool(1, new Utils.AnalyticsThreadFactory());
    private final HandlerThread segmentThread = new HandlerThread(SEGMENT_THREAD_NAME, 10);

    static QueueFile createQueueFile(File file, String str) throws IOException {
        Utils.createDirectory(file);
        File file2 = new File(file, str);
        try {
            return new QueueFile(file2);
        } catch (IOException e) {
            if (file2.delete()) {
                return new QueueFile(file2);
            }
            throw new IOException("Could not create queue file (" + str + ") in " + file + FileUtils.HIDDEN_PREFIX);
        }
    }

    static synchronized SegmentIntegration create(Context context, Client client, Cartographer cartographer, ExecutorService executorService, Stats stats, Map<String, Boolean> map, String str, long j, int i, Logger logger, Crypto crypto) {
        PayloadQueue memoryQueue;
        try {
            memoryQueue = new PayloadQueue.PersistentQueue(createQueueFile(context.getDir("segment-disk-queue", 0), str));
        } catch (IOException e) {
            logger.error(e, "Could not create disk queue. Falling back to memory queue.", new Object[0]);
            memoryQueue = new PayloadQueue.MemoryQueue();
        }
        return new SegmentIntegration(context, client, cartographer, executorService, memoryQueue, stats, map, j, i, logger, crypto);
    }

    SegmentIntegration(Context context, Client client, Cartographer cartographer, ExecutorService executorService, PayloadQueue payloadQueue, Stats stats, Map<String, Boolean> map, long j, int i, Logger logger, Crypto crypto) {
        this.context = context;
        this.client = client;
        this.networkExecutor = executorService;
        this.payloadQueue = payloadQueue;
        this.stats = stats;
        this.logger = logger;
        this.bundledIntegrations = map;
        this.cartographer = cartographer;
        this.flushQueueSize = i;
        this.crypto = crypto;
        this.segmentThread.start();
        this.handler = new SegmentDispatcherHandler(this.segmentThread.getLooper(), this);
        this.flushScheduler.scheduleAtFixedRate(new Runnable() { // from class: com.segment.analytics.SegmentIntegration.2
            @Override // java.lang.Runnable
            public void run() {
                SegmentIntegration.this.flush();
            }
        }, payloadQueue.size() >= i ? 0L : j, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.segment.analytics.integrations.Integration
    public void identify(IdentifyPayload identifyPayload) {
        dispatchEnqueue(identifyPayload);
    }

    @Override // com.segment.analytics.integrations.Integration
    public void group(GroupPayload groupPayload) {
        dispatchEnqueue(groupPayload);
    }

    @Override // com.segment.analytics.integrations.Integration
    public void track(TrackPayload trackPayload) {
        dispatchEnqueue(trackPayload);
    }

    @Override // com.segment.analytics.integrations.Integration
    public void alias(AliasPayload aliasPayload) {
        dispatchEnqueue(aliasPayload);
    }

    @Override // com.segment.analytics.integrations.Integration
    public void screen(ScreenPayload screenPayload) {
        dispatchEnqueue(screenPayload);
    }

    private void dispatchEnqueue(BasePayload basePayload) {
        this.handler.sendMessage(this.handler.obtainMessage(0, basePayload));
    }

    void performEnqueue(BasePayload basePayload) {
        ValueMap valueMapIntegrations = basePayload.integrations();
        LinkedHashMap linkedHashMap = new LinkedHashMap(valueMapIntegrations.size() + this.bundledIntegrations.size());
        linkedHashMap.putAll(valueMapIntegrations);
        linkedHashMap.putAll(this.bundledIntegrations);
        linkedHashMap.remove(SEGMENT_KEY);
        ValueMap valueMap = new ValueMap();
        valueMap.putAll(basePayload);
        valueMap.put("integrations", (Object) linkedHashMap);
        if (this.payloadQueue.size() >= MAX_QUEUE_SIZE) {
            synchronized (this.flushLock) {
                if (this.payloadQueue.size() >= MAX_QUEUE_SIZE) {
                    this.logger.info("Queue is at max capacity (%s), removing oldest payload.", Integer.valueOf(this.payloadQueue.size()));
                    try {
                        this.payloadQueue.remove(1);
                    } catch (IOException e) {
                        this.logger.error(e, "Unable to remove oldest payload from queue.", new Object[0]);
                        return;
                    }
                }
            }
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.cartographer.toJson(valueMap, new OutputStreamWriter(this.crypto.encrypt(byteArrayOutputStream)));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null || byteArray.length == 0 || byteArray.length > MAX_PAYLOAD_SIZE) {
                throw new IOException("Could not serialize payload " + valueMap);
            }
            this.payloadQueue.add(byteArray);
            this.logger.verbose("Enqueued %s payload. %s elements in the queue.", basePayload, Integer.valueOf(this.payloadQueue.size()));
            if (this.payloadQueue.size() >= this.flushQueueSize) {
                submitFlush();
            }
        } catch (IOException e2) {
            this.logger.error(e2, "Could not add payload %s to queue: %s.", valueMap, this.payloadQueue);
        }
    }

    @Override // com.segment.analytics.integrations.Integration
    public void flush() {
        this.handler.sendMessage(this.handler.obtainMessage(1));
    }

    void submitFlush() {
        if (shouldFlush()) {
            this.networkExecutor.submit(new Runnable() { // from class: com.segment.analytics.SegmentIntegration.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (SegmentIntegration.this.flushLock) {
                        SegmentIntegration.this.performFlush();
                    }
                }
            });
        }
    }

    private boolean shouldFlush() {
        return this.payloadQueue.size() > 0 && Utils.isConnected(this.context);
    }

    void performFlush() {
        int i;
        if (shouldFlush()) {
            this.logger.verbose("Uploading payloads in queue to Segment.", new Object[0]);
            Client.Connection connectionUpload = null;
            try {
                try {
                    try {
                        connectionUpload = this.client.upload();
                        BatchPayloadWriter batchPayloadWriterBeginBatchArray = new BatchPayloadWriter(connectionUpload.f14466os).beginObject().beginBatchArray();
                        PayloadWriter payloadWriter = new PayloadWriter(batchPayloadWriterBeginBatchArray, this.crypto);
                        this.payloadQueue.forEach(payloadWriter);
                        batchPayloadWriterBeginBatchArray.endBatchArray().endObject().close();
                        i = payloadWriter.payloadCount;
                    } catch (Client.HTTPException e) {
                        e = e;
                        i = 0;
                    }
                    try {
                        connectionUpload.close();
                        Utils.closeQuietly(connectionUpload);
                        try {
                            this.payloadQueue.remove(i);
                            this.logger.verbose("Uploaded %s payloads. %s remain in the queue.", Integer.valueOf(i), Integer.valueOf(this.payloadQueue.size()));
                            this.stats.dispatchFlush(i);
                            if (this.payloadQueue.size() > 0) {
                                performFlush();
                            }
                        } catch (IOException e2) {
                            this.logger.error(e2, "Unable to remove " + i + " payload(s) from queue.", new Object[0]);
                        }
                    } catch (Client.HTTPException e3) {
                        e = e3;
                        if (e.responseCode < 400 || e.responseCode >= 500) {
                            this.logger.error(e, "Error while uploading payloads", new Object[0]);
                            Utils.closeQuietly(connectionUpload);
                        } else {
                            this.logger.error(e, "Payloads were rejected by server. Marked for removal.", new Object[0]);
                            try {
                                this.payloadQueue.remove(i);
                            } catch (IOException e4) {
                                this.logger.error(e, "Unable to remove " + i + " payload(s) from queue.", new Object[0]);
                            }
                            Utils.closeQuietly(connectionUpload);
                        }
                    }
                } catch (IOException e5) {
                    this.logger.error(e5, "Error while uploading payloads", new Object[0]);
                    Utils.closeQuietly(connectionUpload);
                }
            } catch (Throwable th) {
                Utils.closeQuietly(connectionUpload);
                throw th;
            }
        }
    }

    void shutdown() {
        this.flushScheduler.shutdownNow();
        this.segmentThread.quit();
        Utils.closeQuietly(this.payloadQueue);
    }

    static class PayloadWriter implements PayloadQueue.ElementVisitor {
        final Crypto crypto;
        int payloadCount;
        int size;
        final BatchPayloadWriter writer;

        PayloadWriter(BatchPayloadWriter batchPayloadWriter, Crypto crypto) {
            this.writer = batchPayloadWriter;
            this.crypto = crypto;
        }

        @Override // com.segment.analytics.PayloadQueue.ElementVisitor
        public boolean read(InputStream inputStream, int i) throws IOException {
            InputStream inputStreamDecrypt = this.crypto.decrypt(inputStream);
            int i2 = this.size + i;
            if (i2 > SegmentIntegration.MAX_BATCH_SIZE) {
                return false;
            }
            this.size = i2;
            byte[] bArr = new byte[i];
            inputStreamDecrypt.read(bArr, 0, i);
            this.writer.emitPayloadObject(new String(bArr, SegmentIntegration.UTF_8));
            this.payloadCount++;
            return true;
        }
    }

    static class BatchPayloadWriter implements Closeable {
        private final BufferedWriter bufferedWriter;
        private final JsonWriter jsonWriter;
        private boolean needsComma = false;

        BatchPayloadWriter(OutputStream outputStream) {
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            this.jsonWriter = new JsonWriter(this.bufferedWriter);
        }

        BatchPayloadWriter beginObject() throws IOException {
            this.jsonWriter.beginObject();
            return this;
        }

        BatchPayloadWriter beginBatchArray() throws IOException {
            this.jsonWriter.name("batch").beginArray();
            this.needsComma = false;
            return this;
        }

        BatchPayloadWriter emitPayloadObject(String str) throws IOException {
            if (this.needsComma) {
                this.bufferedWriter.write(44);
            } else {
                this.needsComma = true;
            }
            this.bufferedWriter.write(str);
            return this;
        }

        BatchPayloadWriter endBatchArray() throws IOException {
            if (!this.needsComma) {
                throw new IOException("At least one payload must be provided.");
            }
            this.jsonWriter.endArray();
            return this;
        }

        BatchPayloadWriter endObject() throws IOException {
            this.jsonWriter.name("sentAt").value(Utils.toISO8601Date(new Date())).endObject();
            return this;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.jsonWriter.close();
        }
    }

    static class SegmentDispatcherHandler extends Handler {
        static final int REQUEST_ENQUEUE = 0;
        static final int REQUEST_FLUSH = 1;
        private final SegmentIntegration segmentIntegration;

        SegmentDispatcherHandler(Looper looper, SegmentIntegration segmentIntegration) {
            super(looper);
            this.segmentIntegration = segmentIntegration;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.segmentIntegration.performEnqueue((BasePayload) message.obj);
                    return;
                case 1:
                    this.segmentIntegration.submitFlush();
                    return;
                default:
                    throw new AssertionError("Unknown dispatcher message: " + message.what);
            }
        }
    }
}
