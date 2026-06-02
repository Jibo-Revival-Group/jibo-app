package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.Dependency;
import io.fabric.sdk.android.services.concurrency.PriorityProvider;
import io.fabric.sdk.android.services.concurrency.Task;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class DependencyPriorityBlockingQueue<E extends Dependency & Task & PriorityProvider> extends PriorityBlockingQueue<E> {

    /* JADX INFO: renamed from: a */
    final Queue<E> f14645a = new LinkedList();

    /* JADX INFO: renamed from: b */
    private final ReentrantLock f14646b = new ReentrantLock();

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public E take() throws InterruptedException {
        return (E) m15294b(0, null, null);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public E peek() {
        try {
            return (E) m15294b(1, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return (E) m15294b(3, Long.valueOf(j), timeUnit);
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.Queue
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public E poll() {
        try {
            return (E) m15294b(2, null, null);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        try {
            this.f14646b.lock();
            return this.f14645a.size() + super.size();
        } finally {
            this.f14646b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        try {
            this.f14646b.lock();
            return (T[]) m15292a(super.toArray(tArr), this.f14645a.toArray(tArr));
        } finally {
            this.f14646b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        try {
            this.f14646b.lock();
            return m15292a(super.toArray(), this.f14645a.toArray());
        } finally {
            this.f14646b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        try {
            this.f14646b.lock();
            int iDrainTo = super.drainTo(collection) + this.f14645a.size();
            while (!this.f14645a.isEmpty()) {
                collection.add(this.f14645a.poll());
            }
            return iDrainTo;
        } finally {
            this.f14646b.unlock();
        }
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f14646b.lock();
            int iDrainTo = super.drainTo(collection, i);
            while (!this.f14645a.isEmpty() && iDrainTo <= i) {
                collection.add(this.f14645a.poll());
                iDrainTo++;
            }
            return iDrainTo;
        } finally {
            this.f14646b.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean contains(java.lang.Object r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r2.f14646b     // Catch: java.lang.Throwable -> L1c
            r0.lock()     // Catch: java.lang.Throwable -> L1c
            boolean r0 = super.contains(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L13
            java.util.Queue<E extends io.fabric.sdk.android.services.concurrency.Dependency & io.fabric.sdk.android.services.concurrency.Task & io.fabric.sdk.android.services.concurrency.PriorityProvider> r0 = r2.f14645a     // Catch: java.lang.Throwable -> L1c
            boolean r0 = r0.contains(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1a
        L13:
            r0 = 1
        L14:
            java.util.concurrent.locks.ReentrantLock r1 = r2.f14646b
            r1.unlock()
            return r0
        L1a:
            r0 = 0
            goto L14
        L1c:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r2.f14646b
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue.contains(java.lang.Object):boolean");
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        try {
            this.f14646b.lock();
            this.f14645a.clear();
            super.clear();
        } finally {
            this.f14646b.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean remove(java.lang.Object r3) {
        /*
            r2 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r2.f14646b     // Catch: java.lang.Throwable -> L1c
            r0.lock()     // Catch: java.lang.Throwable -> L1c
            boolean r0 = super.remove(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 != 0) goto L13
            java.util.Queue<E extends io.fabric.sdk.android.services.concurrency.Dependency & io.fabric.sdk.android.services.concurrency.Task & io.fabric.sdk.android.services.concurrency.PriorityProvider> r0 = r2.f14645a     // Catch: java.lang.Throwable -> L1c
            boolean r0 = r0.remove(r3)     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L1a
        L13:
            r0 = 1
        L14:
            java.util.concurrent.locks.ReentrantLock r1 = r2.f14646b
            r1.unlock()
            return r0
        L1a:
            r0 = 0
            goto L14
        L1c:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r2.f14646b
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue.remove(java.lang.Object):boolean");
    }

    @Override // java.util.concurrent.PriorityBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        try {
            this.f14646b.lock();
            return super.removeAll(collection) | this.f14645a.removeAll(collection);
        } finally {
            this.f14646b.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    E m15288a(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        switch (i) {
            case 0:
                return (E) ((Dependency) super.take());
            case 1:
                return (E) ((Dependency) super.peek());
            case 2:
                return (E) ((Dependency) super.poll());
            case 3:
                return (E) ((Dependency) super.poll(l.longValue(), timeUnit));
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m15290a(int i, E e) {
        try {
            this.f14646b.lock();
            if (i == 1) {
                super.remove(e);
            }
            return this.f14645a.offer(e);
        } finally {
            this.f14646b.unlock();
        }
    }

    /* JADX INFO: renamed from: b */
    E m15294b(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        E e;
        while (true) {
            e = (E) m15288a(i, l, timeUnit);
            if (e == null || m15291a(e)) {
                break;
            }
            m15290a(i, e);
        }
        return e;
    }

    /* JADX INFO: renamed from: a */
    boolean m15291a(E e) {
        return e.mo15286d();
    }

    /* JADX INFO: renamed from: d */
    public void m15296d() {
        try {
            this.f14646b.lock();
            Iterator<E> it = this.f14645a.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (m15291a(next)) {
                    super.offer(next);
                    it.remove();
                }
            }
        } finally {
            this.f14646b.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    <T> T[] m15292a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2));
        System.arraycopy(tArr, 0, tArr3, 0, length);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        return tArr3;
    }
}
