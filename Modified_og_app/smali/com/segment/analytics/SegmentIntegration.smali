.class Lcom/segment/analytics/SegmentIntegration;
.super Lcom/segment/analytics/integrations/Integration;
.source "SegmentIntegration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/segment/analytics/SegmentIntegration$SegmentDispatcherHandler;,
        Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;,
        Lcom/segment/analytics/SegmentIntegration$PayloadWriter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/segment/analytics/integrations/Integration",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# static fields
.field static final FACTORY:Lcom/segment/analytics/integrations/Integration$Factory;

.field static final MAX_BATCH_SIZE:I = 0x73f78

.field static final MAX_PAYLOAD_SIZE:I = 0x3a98

.field static final MAX_QUEUE_SIZE:I = 0x3e8

.field static final SEGMENT_KEY:Ljava/lang/String; = "Segment.io"

.field private static final SEGMENT_THREAD_NAME:Ljava/lang/String; = "Segment-SegmentDispatcher"

.field static final UTF_8:Ljava/nio/charset/Charset;


# instance fields
.field private final bundledIntegrations:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private final cartographer:Lcom/segment/analytics/Cartographer;

.field private final client:Lcom/segment/analytics/Client;

.field private final context:Landroid/content/Context;

.field private final crypto:Lcom/segment/analytics/Crypto;

.field final flushLock:Ljava/lang/Object;

.field private final flushQueueSize:I

.field private final flushScheduler:Ljava/util/concurrent/ScheduledExecutorService;

.field private final handler:Landroid/os/Handler;

.field private final logger:Lcom/segment/analytics/integrations/Logger;

.field private final networkExecutor:Ljava/util/concurrent/ExecutorService;

.field private final payloadQueue:Lcom/segment/analytics/PayloadQueue;

.field private final segmentThread:Landroid/os/HandlerThread;

.field private final stats:Lcom/segment/analytics/Stats;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    new-instance v0, Lcom/segment/analytics/SegmentIntegration$1;

    invoke-direct {v0}, Lcom/segment/analytics/SegmentIntegration$1;-><init>()V

    sput-object v0, Lcom/segment/analytics/SegmentIntegration;->FACTORY:Lcom/segment/analytics/integrations/Integration$Factory;

    .line 86
    const-string v0, "UTF-8"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lcom/segment/analytics/SegmentIntegration;->UTF_8:Ljava/nio/charset/Charset;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lcom/segment/analytics/Client;Lcom/segment/analytics/Cartographer;Ljava/util/concurrent/ExecutorService;Lcom/segment/analytics/PayloadQueue;Lcom/segment/analytics/Stats;Ljava/util/Map;JILcom/segment/analytics/integrations/Logger;Lcom/segment/analytics/Crypto;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/segment/analytics/Client;",
            "Lcom/segment/analytics/Cartographer;",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/segment/analytics/PayloadQueue;",
            "Lcom/segment/analytics/Stats;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;JI",
            "Lcom/segment/analytics/integrations/Logger;",
            "Lcom/segment/analytics/Crypto;",
            ")V"
        }
    .end annotation

    .prologue
    .line 191
    invoke-direct {p0}, Lcom/segment/analytics/integrations/Integration;-><init>()V

    .line 121
    new-instance v2, Ljava/lang/Object;

    invoke-direct {v2}, Ljava/lang/Object;-><init>()V

    iput-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->flushLock:Ljava/lang/Object;

    .line 192
    iput-object p1, p0, Lcom/segment/analytics/SegmentIntegration;->context:Landroid/content/Context;

    .line 193
    iput-object p2, p0, Lcom/segment/analytics/SegmentIntegration;->client:Lcom/segment/analytics/Client;

    .line 194
    iput-object p4, p0, Lcom/segment/analytics/SegmentIntegration;->networkExecutor:Ljava/util/concurrent/ExecutorService;

    .line 195
    iput-object p5, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    .line 196
    move-object/from16 v0, p6

    iput-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->stats:Lcom/segment/analytics/Stats;

    .line 197
    move-object/from16 v0, p11

    iput-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    .line 198
    move-object/from16 v0, p7

    iput-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->bundledIntegrations:Ljava/util/Map;

    .line 199
    iput-object p3, p0, Lcom/segment/analytics/SegmentIntegration;->cartographer:Lcom/segment/analytics/Cartographer;

    .line 200
    move/from16 v0, p10

    iput v0, p0, Lcom/segment/analytics/SegmentIntegration;->flushQueueSize:I

    .line 201
    const/4 v2, 0x1

    new-instance v3, Lcom/segment/analytics/internal/Utils$AnalyticsThreadFactory;

    invoke-direct {v3}, Lcom/segment/analytics/internal/Utils$AnalyticsThreadFactory;-><init>()V

    invoke-static {v2, v3}, Ljava/util/concurrent/Executors;->newScheduledThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v2

    iput-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->flushScheduler:Ljava/util/concurrent/ScheduledExecutorService;

    .line 202
    move-object/from16 v0, p12

    iput-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->crypto:Lcom/segment/analytics/Crypto;

    .line 204
    new-instance v2, Landroid/os/HandlerThread;

    const-string v3, "Segment-SegmentDispatcher"

    const/16 v4, 0xa

    invoke-direct {v2, v3, v4}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    iput-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->segmentThread:Landroid/os/HandlerThread;

    .line 205
    iget-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->segmentThread:Landroid/os/HandlerThread;

    invoke-virtual {v2}, Landroid/os/HandlerThread;->start()V

    .line 206
    new-instance v2, Lcom/segment/analytics/SegmentIntegration$SegmentDispatcherHandler;

    iget-object v3, p0, Lcom/segment/analytics/SegmentIntegration;->segmentThread:Landroid/os/HandlerThread;

    invoke-virtual {v3}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, v3, p0}, Lcom/segment/analytics/SegmentIntegration$SegmentDispatcherHandler;-><init>(Landroid/os/Looper;Lcom/segment/analytics/SegmentIntegration;)V

    iput-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->handler:Landroid/os/Handler;

    .line 208
    invoke-virtual {p5}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v2

    move/from16 v0, p10

    if-lt v2, v0, :cond_0

    const-wide/16 v4, 0x0

    .line 209
    :goto_0
    iget-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->flushScheduler:Ljava/util/concurrent/ScheduledExecutorService;

    new-instance v3, Lcom/segment/analytics/SegmentIntegration$2;

    invoke-direct {v3, p0}, Lcom/segment/analytics/SegmentIntegration$2;-><init>(Lcom/segment/analytics/SegmentIntegration;)V

    sget-object v8, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    move-wide/from16 v6, p8

    invoke-interface/range {v2 .. v8}, Ljava/util/concurrent/ScheduledExecutorService;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 219
    return-void

    :cond_0
    move-wide/from16 v4, p8

    .line 208
    goto :goto_0
.end method

.method static declared-synchronized create(Landroid/content/Context;Lcom/segment/analytics/Client;Lcom/segment/analytics/Cartographer;Ljava/util/concurrent/ExecutorService;Lcom/segment/analytics/Stats;Ljava/util/Map;Ljava/lang/String;JILcom/segment/analytics/integrations/Logger;Lcom/segment/analytics/Crypto;)Lcom/segment/analytics/SegmentIntegration;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/segment/analytics/Client;",
            "Lcom/segment/analytics/Cartographer;",
            "Ljava/util/concurrent/ExecutorService;",
            "Lcom/segment/analytics/Stats;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;",
            "Ljava/lang/String;",
            "JI",
            "Lcom/segment/analytics/integrations/Logger;",
            "Lcom/segment/analytics/Crypto;",
            ")",
            "Lcom/segment/analytics/SegmentIntegration;"
        }
    .end annotation

    .prologue
    .line 159
    const-class v15, Lcom/segment/analytics/SegmentIntegration;

    monitor-enter v15

    :try_start_0
    const-string v2, "segment-disk-queue"

    const/4 v3, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v3}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v2

    .line 160
    move-object/from16 v0, p6

    invoke-static {v2, v0}, Lcom/segment/analytics/SegmentIntegration;->createQueueFile(Ljava/io/File;Ljava/lang/String;)Lcom/segment/analytics/QueueFile;

    move-result-object v2

    .line 161
    new-instance v7, Lcom/segment/analytics/PayloadQueue$PersistentQueue;

    invoke-direct {v7, v2}, Lcom/segment/analytics/PayloadQueue$PersistentQueue;-><init>(Lcom/segment/analytics/QueueFile;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 166
    :goto_0
    :try_start_1
    new-instance v2, Lcom/segment/analytics/SegmentIntegration;

    move-object/from16 v3, p0

    move-object/from16 v4, p1

    move-object/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v8, p4

    move-object/from16 v9, p5

    move-wide/from16 v10, p7

    move/from16 v12, p9

    move-object/from16 v13, p10

    move-object/from16 v14, p11

    invoke-direct/range {v2 .. v14}, Lcom/segment/analytics/SegmentIntegration;-><init>(Landroid/content/Context;Lcom/segment/analytics/Client;Lcom/segment/analytics/Cartographer;Ljava/util/concurrent/ExecutorService;Lcom/segment/analytics/PayloadQueue;Lcom/segment/analytics/Stats;Ljava/util/Map;JILcom/segment/analytics/integrations/Logger;Lcom/segment/analytics/Crypto;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit v15

    return-object v2

    .line 162
    :catch_0
    move-exception v2

    .line 163
    :try_start_2
    const-string v3, "Could not create disk queue. Falling back to memory queue."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    move-object/from16 v0, p10

    invoke-virtual {v0, v2, v3, v4}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 164
    new-instance v7, Lcom/segment/analytics/PayloadQueue$MemoryQueue;

    invoke-direct {v7}, Lcom/segment/analytics/PayloadQueue$MemoryQueue;-><init>()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 159
    :catchall_0
    move-exception v2

    monitor-exit v15

    throw v2
.end method

.method static createQueueFile(Ljava/io/File;Ljava/lang/String;)Lcom/segment/analytics/QueueFile;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 131
    invoke-static {p0}, Lcom/segment/analytics/internal/Utils;->createDirectory(Ljava/io/File;)V

    .line 132
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p0, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 134
    :try_start_0
    new-instance v0, Lcom/segment/analytics/QueueFile;

    invoke-direct {v0, v1}, Lcom/segment/analytics/QueueFile;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 138
    :goto_0
    return-object v0

    .line 135
    :catch_0
    move-exception v0

    .line 137
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 138
    new-instance v0, Lcom/segment/analytics/QueueFile;

    invoke-direct {v0, v1}, Lcom/segment/analytics/QueueFile;-><init>(Ljava/io/File;)V

    goto :goto_0

    .line 140
    :cond_0
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not create queue file ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") in "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private dispatchEnqueue(Lcom/segment/analytics/integrations/BasePayload;)V
    .locals 3

    .prologue
    .line 247
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration;->handler:Landroid/os/Handler;

    const/4 v2, 0x0

    invoke-virtual {v1, v2, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 248
    return-void
.end method

.method private shouldFlush()Z
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v0}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->context:Landroid/content/Context;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->isConnected(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public alias(Lcom/segment/analytics/integrations/AliasPayload;)V
    .locals 0

    .prologue
    .line 238
    invoke-direct {p0, p1}, Lcom/segment/analytics/SegmentIntegration;->dispatchEnqueue(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 239
    return-void
.end method

.method public flush()V
    .locals 3

    .prologue
    .line 305
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration;->handler:Landroid/os/Handler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 306
    return-void
.end method

.method public group(Lcom/segment/analytics/integrations/GroupPayload;)V
    .locals 0

    .prologue
    .line 228
    invoke-direct {p0, p1}, Lcom/segment/analytics/SegmentIntegration;->dispatchEnqueue(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 229
    return-void
.end method

.method public identify(Lcom/segment/analytics/integrations/IdentifyPayload;)V
    .locals 0

    .prologue
    .line 223
    invoke-direct {p0, p1}, Lcom/segment/analytics/SegmentIntegration;->dispatchEnqueue(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 224
    return-void
.end method

.method performEnqueue(Lcom/segment/analytics/integrations/BasePayload;)V
    .locals 10

    .prologue
    const/16 v4, 0x3e8

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 254
    invoke-virtual {p1}, Lcom/segment/analytics/integrations/BasePayload;->integrations()Lcom/segment/analytics/ValueMap;

    move-result-object v0

    .line 255
    new-instance v1, Ljava/util/LinkedHashMap;

    .line 256
    invoke-virtual {v0}, Lcom/segment/analytics/ValueMap;->size()I

    move-result v2

    iget-object v3, p0, Lcom/segment/analytics/SegmentIntegration;->bundledIntegrations:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->size()I

    move-result v3

    add-int/2addr v2, v3

    invoke-direct {v1, v2}, Ljava/util/LinkedHashMap;-><init>(I)V

    .line 257
    invoke-virtual {v1, v0}, Ljava/util/LinkedHashMap;->putAll(Ljava/util/Map;)V

    .line 258
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->bundledIntegrations:Ljava/util/Map;

    invoke-virtual {v1, v0}, Ljava/util/LinkedHashMap;->putAll(Ljava/util/Map;)V

    .line 259
    const-string v0, "Segment.io"

    invoke-virtual {v1, v0}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 261
    new-instance v2, Lcom/segment/analytics/ValueMap;

    invoke-direct {v2}, Lcom/segment/analytics/ValueMap;-><init>()V

    .line 262
    invoke-virtual {v2, p1}, Lcom/segment/analytics/ValueMap;->putAll(Ljava/util/Map;)V

    .line 263
    const-string v0, "integrations"

    invoke-virtual {v2, v0, v1}, Lcom/segment/analytics/ValueMap;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 265
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v0}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v0

    if-lt v0, v4, :cond_1

    .line 266
    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration;->flushLock:Ljava/lang/Object;

    monitor-enter v1

    .line 269
    :try_start_0
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v0}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v0

    if-lt v0, v4, :cond_0

    .line 270
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v3, "Queue is at max capacity (%s), removing oldest payload."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    .line 271
    invoke-virtual {v6}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    .line 270
    invoke-virtual {v0, v3, v4}, Lcom/segment/analytics/integrations/Logger;->info(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 273
    :try_start_1
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Lcom/segment/analytics/PayloadQueue;->remove(I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 279
    :cond_0
    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 283
    :cond_1
    :try_start_3
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 284
    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration;->crypto:Lcom/segment/analytics/Crypto;

    invoke-virtual {v1, v0}, Lcom/segment/analytics/Crypto;->encrypt(Ljava/io/OutputStream;)Ljava/io/OutputStream;

    move-result-object v1

    .line 285
    iget-object v3, p0, Lcom/segment/analytics/SegmentIntegration;->cartographer:Lcom/segment/analytics/Cartographer;

    new-instance v4, Ljava/io/OutputStreamWriter;

    invoke-direct {v4, v1}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    invoke-virtual {v3, v2, v4}, Lcom/segment/analytics/Cartographer;->toJson(Ljava/util/Map;Ljava/io/Writer;)V

    .line 286
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    .line 287
    if-eqz v0, :cond_2

    array-length v1, v0

    if-eqz v1, :cond_2

    array-length v1, v0

    const/16 v3, 0x3a98

    if-le v1, v3, :cond_4

    .line 288
    :cond_2
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not serialize payload "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 291
    :catch_0
    move-exception v0

    .line 292
    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v3, "Could not add payload %s to queue: %s."

    new-array v4, v9, [Ljava/lang/Object;

    aput-object v2, v4, v7

    iget-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    aput-object v2, v4, v8

    invoke-virtual {v1, v0, v3, v4}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 300
    :cond_3
    :goto_0
    return-void

    .line 274
    :catch_1
    move-exception v0

    .line 275
    :try_start_4
    iget-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v3, "Unable to remove oldest payload from queue."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v2, v0, v3, v4}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 276
    monitor-exit v1

    goto :goto_0

    .line 279
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    throw v0

    .line 290
    :cond_4
    :try_start_5
    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v1, v0}, Lcom/segment/analytics/PayloadQueue;->add([B)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    .line 296
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v1, "Enqueued %s payload. %s elements in the queue."

    new-array v2, v9, [Ljava/lang/Object;

    aput-object p1, v2, v7

    iget-object v3, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v3}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v8

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 297
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v0}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v0

    iget v1, p0, Lcom/segment/analytics/SegmentIntegration;->flushQueueSize:I

    if-lt v0, v1, :cond_3

    .line 298
    invoke-virtual {p0}, Lcom/segment/analytics/SegmentIntegration;->submitFlush()V

    goto :goto_0
.end method

.method performFlush()V
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 332
    invoke-direct {p0}, Lcom/segment/analytics/SegmentIntegration;->shouldFlush()Z

    move-result v0

    if-nez v0, :cond_1

    .line 390
    :cond_0
    :goto_0
    return-void

    .line 336
    :cond_1
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v1, "Uploading payloads in queue to Segment."

    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 338
    const/4 v1, 0x0

    .line 341
    :try_start_0
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->client:Lcom/segment/analytics/Client;

    invoke-virtual {v0}, Lcom/segment/analytics/Client;->upload()Lcom/segment/analytics/Client$Connection;

    move-result-object v1

    .line 344
    new-instance v0, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    iget-object v2, v1, Lcom/segment/analytics/Client$Connection;->os:Ljava/io/OutputStream;

    invoke-direct {v0, v2}, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;-><init>(Ljava/io/OutputStream;)V

    .line 346
    invoke-virtual {v0}, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;->beginObject()Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    move-result-object v0

    .line 347
    invoke-virtual {v0}, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;->beginBatchArray()Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    move-result-object v0

    .line 348
    new-instance v2, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;

    iget-object v4, p0, Lcom/segment/analytics/SegmentIntegration;->crypto:Lcom/segment/analytics/Crypto;

    invoke-direct {v2, v0, v4}, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;-><init>(Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;Lcom/segment/analytics/Crypto;)V

    .line 349
    iget-object v4, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v4, v2}, Lcom/segment/analytics/PayloadQueue;->forEach(Lcom/segment/analytics/PayloadQueue$ElementVisitor;)V

    .line 350
    invoke-virtual {v0}, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;->endBatchArray()Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;->endObject()Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/segment/analytics/SegmentIntegration$BatchPayloadWriter;->close()V

    .line 352
    iget v2, v2, Lcom/segment/analytics/SegmentIntegration$PayloadWriter;->payloadCount:I
    :try_end_0
    .catch Lcom/segment/analytics/Client$HTTPException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 355
    :try_start_1
    invoke-virtual {v1}, Lcom/segment/analytics/Client$Connection;->close()V
    :try_end_1
    .catch Lcom/segment/analytics/Client$HTTPException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 374
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->closeQuietly(Ljava/io/Closeable;)V

    .line 378
    :try_start_2
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v0, v2}, Lcom/segment/analytics/PayloadQueue;->remove(I)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3

    .line 384
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v1, "Uploaded %s payloads. %s remain in the queue."

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    .line 385
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v3

    const/4 v3, 0x1

    iget-object v5, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v5}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v3

    .line 384
    invoke-virtual {v0, v1, v4}, Lcom/segment/analytics/integrations/Logger;->verbose(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 386
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->stats:Lcom/segment/analytics/Stats;

    invoke-virtual {v0, v2}, Lcom/segment/analytics/Stats;->dispatchFlush(I)V

    .line 387
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v0}, Lcom/segment/analytics/PayloadQueue;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 388
    invoke-virtual {p0}, Lcom/segment/analytics/SegmentIntegration;->performFlush()V

    goto :goto_0

    .line 356
    :catch_0
    move-exception v0

    move v2, v3

    .line 357
    :goto_1
    :try_start_3
    iget v3, v0, Lcom/segment/analytics/Client$HTTPException;->responseCode:I

    const/16 v4, 0x190

    if-lt v3, v4, :cond_2

    iget v3, v0, Lcom/segment/analytics/Client$HTTPException;->responseCode:I

    const/16 v4, 0x1f4

    if-ge v3, v4, :cond_2

    .line 359
    iget-object v3, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v4, "Payloads were rejected by server. Marked for removal."

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v3, v0, v4, v5}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 361
    :try_start_4
    iget-object v3, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-virtual {v3, v2}, Lcom/segment/analytics/PayloadQueue;->remove(I)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 374
    :goto_2
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->closeQuietly(Ljava/io/Closeable;)V

    goto/16 :goto_0

    .line 362
    :catch_1
    move-exception v3

    .line 363
    :try_start_5
    iget-object v3, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to remove "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " payload(s) from queue."

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v3, v0, v2, v4}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 374
    :catchall_0
    move-exception v0

    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->closeQuietly(Ljava/io/Closeable;)V

    throw v0

    .line 367
    :cond_2
    :try_start_6
    iget-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v3, "Error while uploading payloads"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v2, v0, v3, v4}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 374
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->closeQuietly(Ljava/io/Closeable;)V

    goto/16 :goto_0

    .line 370
    :catch_2
    move-exception v0

    .line 371
    :try_start_7
    iget-object v2, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    const-string v3, "Error while uploading payloads"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v2, v0, v3, v4}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 374
    invoke-static {v1}, Lcom/segment/analytics/internal/Utils;->closeQuietly(Ljava/io/Closeable;)V

    goto/16 :goto_0

    .line 379
    :catch_3
    move-exception v0

    .line 380
    iget-object v1, p0, Lcom/segment/analytics/SegmentIntegration;->logger:Lcom/segment/analytics/integrations/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to remove "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " payload(s) from queue."

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v1, v0, v2, v3}, Lcom/segment/analytics/integrations/Logger;->error(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 356
    :catch_4
    move-exception v0

    goto/16 :goto_1
.end method

.method public screen(Lcom/segment/analytics/integrations/ScreenPayload;)V
    .locals 0

    .prologue
    .line 243
    invoke-direct {p0, p1}, Lcom/segment/analytics/SegmentIntegration;->dispatchEnqueue(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 244
    return-void
.end method

.method shutdown()V
    .locals 1

    .prologue
    .line 393
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->flushScheduler:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 394
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->segmentThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    .line 395
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->payloadQueue:Lcom/segment/analytics/PayloadQueue;

    invoke-static {v0}, Lcom/segment/analytics/internal/Utils;->closeQuietly(Ljava/io/Closeable;)V

    .line 396
    return-void
.end method

.method submitFlush()V
    .locals 2

    .prologue
    .line 310
    invoke-direct {p0}, Lcom/segment/analytics/SegmentIntegration;->shouldFlush()Z

    move-result v0

    if-nez v0, :cond_0

    .line 323
    :goto_0
    return-void

    .line 314
    :cond_0
    iget-object v0, p0, Lcom/segment/analytics/SegmentIntegration;->networkExecutor:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/segment/analytics/SegmentIntegration$3;

    invoke-direct {v1, p0}, Lcom/segment/analytics/SegmentIntegration$3;-><init>(Lcom/segment/analytics/SegmentIntegration;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    goto :goto_0
.end method

.method public track(Lcom/segment/analytics/integrations/TrackPayload;)V
    .locals 0

    .prologue
    .line 233
    invoke-direct {p0, p1}, Lcom/segment/analytics/SegmentIntegration;->dispatchEnqueue(Lcom/segment/analytics/integrations/BasePayload;)V

    .line 234
    return-void
.end method
