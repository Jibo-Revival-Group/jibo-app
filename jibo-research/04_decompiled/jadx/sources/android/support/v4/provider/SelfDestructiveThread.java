package android.support.v4.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class SelfDestructiveThread {

    /* JADX INFO: renamed from: b */
    private HandlerThread f2146b;

    /* JADX INFO: renamed from: c */
    private Handler f2147c;

    /* JADX INFO: renamed from: f */
    private final int f2150f;

    /* JADX INFO: renamed from: g */
    private final int f2151g;

    /* JADX INFO: renamed from: h */
    private final String f2152h;

    /* JADX INFO: renamed from: a */
    private final Object f2145a = new Object();

    /* JADX INFO: renamed from: e */
    private Handler.Callback f2149e = new Handler.Callback() { // from class: android.support.v4.provider.SelfDestructiveThread.1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SelfDestructiveThread.this.m2355a();
                    return true;
                case 1:
                    SelfDestructiveThread.this.m2359b((Runnable) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    };

    /* JADX INFO: renamed from: d */
    private int f2148d = 0;

    public interface ReplyCallback<T> {
        /* JADX INFO: renamed from: a */
        void mo2346a(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        this.f2152h = str;
        this.f2151g = i;
        this.f2150f = i2;
    }

    /* JADX INFO: renamed from: a */
    private void m2358a(Runnable runnable) {
        synchronized (this.f2145a) {
            if (this.f2146b == null) {
                this.f2146b = new HandlerThread(this.f2152h, this.f2151g);
                this.f2146b.start();
                this.f2147c = new Handler(this.f2146b.getLooper(), this.f2149e);
                this.f2148d++;
            }
            this.f2147c.removeMessages(0);
            this.f2147c.sendMessage(this.f2147c.obtainMessage(1, runnable));
        }
    }

    /* JADX INFO: renamed from: a */
    public <T> void m2361a(final Callable<T> callable, final ReplyCallback<T> replyCallback) {
        final Handler handler = new Handler();
        m2358a(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2
            @Override // java.lang.Runnable
            public void run() {
                final Object objCall;
                try {
                    objCall = callable.call();
                } catch (Exception e) {
                    objCall = null;
                }
                handler.post(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        replyCallback.mo2346a(objCall);
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public <T> T m2360a(final Callable<T> callable, int i) throws InterruptedException {
        T t;
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition conditionNewCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        m2358a(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception e) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    conditionNewCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                t = (T) atomicReference.get();
            } else {
                long nanos = TimeUnit.MILLISECONDS.toNanos(i);
                do {
                    try {
                        nanos = conditionNewCondition.awaitNanos(nanos);
                    } catch (InterruptedException e) {
                    }
                    if (!atomicBoolean.get()) {
                        t = (T) atomicReference.get();
                    }
                } while (nanos > 0);
                throw new InterruptedException("timeout");
            }
            return t;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m2359b(Runnable runnable) {
        runnable.run();
        synchronized (this.f2145a) {
            this.f2147c.removeMessages(0);
            this.f2147c.sendMessageDelayed(this.f2147c.obtainMessage(0), this.f2150f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2355a() {
        synchronized (this.f2145a) {
            if (!this.f2147c.hasMessages(1)) {
                this.f2146b.quit();
                this.f2146b = null;
                this.f2147c = null;
            }
        }
    }
}
