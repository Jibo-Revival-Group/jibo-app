package com.jibo.utils.cache;

import com.bumptech.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
final class DiskCacheWriteLocker {

    /* JADX INFO: renamed from: a */
    private final Map<Key, WriteLock> f11697a = new HashMap();

    /* JADX INFO: renamed from: b */
    private final WriteLockPool f11698b = new WriteLockPool();

    DiskCacheWriteLocker() {
    }

    /* JADX INFO: renamed from: a */
    void m11502a(Key key) {
        WriteLock writeLockM11504a;
        synchronized (this) {
            writeLockM11504a = this.f11697a.get(key);
            if (writeLockM11504a == null) {
                writeLockM11504a = this.f11698b.m11504a();
                this.f11697a.put(key, writeLockM11504a);
            }
            writeLockM11504a.f11700b++;
        }
        writeLockM11504a.f11699a.lock();
    }

    /* JADX INFO: renamed from: b */
    void m11503b(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.m11510a(this.f11697a.get(key));
            if (writeLock.f11700b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, key: " + key + ", interestedThreads: " + writeLock.f11700b);
            }
            writeLock.f11700b--;
            if (writeLock.f11700b == 0) {
                WriteLock writeLockRemove = this.f11697a.remove(key);
                if (!writeLockRemove.equals(writeLock)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLockRemove + ", key: " + key);
                }
                this.f11698b.m11505a(writeLockRemove);
            }
        }
        writeLock.f11699a.unlock();
    }

    private static class WriteLock {

        /* JADX INFO: renamed from: a */
        final Lock f11699a;

        /* JADX INFO: renamed from: b */
        int f11700b;

        private WriteLock() {
            this.f11699a = new ReentrantLock();
        }
    }

    private static class WriteLockPool {

        /* JADX INFO: renamed from: a */
        private final Queue<WriteLock> f11701a;

        private WriteLockPool() {
            this.f11701a = new ArrayDeque();
        }

        /* JADX INFO: renamed from: a */
        WriteLock m11504a() {
            WriteLock writeLockPoll;
            synchronized (this.f11701a) {
                writeLockPoll = this.f11701a.poll();
            }
            if (writeLockPoll == null) {
                return new WriteLock();
            }
            return writeLockPoll;
        }

        /* JADX INFO: renamed from: a */
        void m11505a(WriteLock writeLock) {
            synchronized (this.f11701a) {
                if (this.f11701a.size() < 10) {
                    this.f11701a.offer(writeLock);
                }
            }
        }
    }
}
