package com.segment.analytics;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
abstract class PayloadQueue implements Closeable {

    interface ElementVisitor {
        boolean read(InputStream inputStream, int i) throws IOException;
    }

    abstract void add(byte[] bArr) throws IOException;

    abstract void forEach(ElementVisitor elementVisitor) throws IOException;

    abstract void remove(int i) throws IOException;

    abstract int size();

    PayloadQueue() {
    }

    static class PersistentQueue extends PayloadQueue {
        final QueueFile queueFile;

        PersistentQueue(QueueFile queueFile) {
            this.queueFile = queueFile;
        }

        @Override // com.segment.analytics.PayloadQueue
        int size() {
            return this.queueFile.size();
        }

        @Override // com.segment.analytics.PayloadQueue
        void remove(int i) throws IOException {
            try {
                this.queueFile.remove(i);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IOException(e);
            }
        }

        @Override // com.segment.analytics.PayloadQueue
        void add(byte[] bArr) throws IOException {
            this.queueFile.add(bArr);
        }

        @Override // com.segment.analytics.PayloadQueue
        void forEach(ElementVisitor elementVisitor) throws IOException {
            this.queueFile.forEach(elementVisitor);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.queueFile.close();
        }
    }

    static class MemoryQueue extends PayloadQueue {
        final LinkedList<byte[]> queue = new LinkedList<>();

        MemoryQueue() {
        }

        @Override // com.segment.analytics.PayloadQueue
        int size() {
            return this.queue.size();
        }

        @Override // com.segment.analytics.PayloadQueue
        void remove(int i) throws IOException {
            for (int i2 = 0; i2 < i; i2++) {
                this.queue.remove();
            }
        }

        @Override // com.segment.analytics.PayloadQueue
        void add(byte[] bArr) throws IOException {
            this.queue.add(bArr);
        }

        @Override // com.segment.analytics.PayloadQueue
        void forEach(ElementVisitor elementVisitor) throws IOException {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.queue.size()) {
                    byte[] bArr = this.queue.get(i2);
                    if (elementVisitor.read(new ByteArrayInputStream(bArr), bArr.length)) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
