package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
final class zzcil extends Thread {

    /* JADX INFO: renamed from: a */
    private final Object f7330a;

    /* JADX INFO: renamed from: b */
    private final BlockingQueue<zzcik<?>> f7331b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcih f7332c;

    public zzcil(zzcih zzcihVar, String str, BlockingQueue<zzcik<?>> blockingQueue) {
        this.f7332c = zzcihVar;
        zzbq.m7373a(str);
        zzbq.m7373a(blockingQueue);
        this.f7330a = new Object();
        this.f7331b = blockingQueue;
        setName(str);
    }

    /* JADX INFO: renamed from: a */
    private final void m8177a(InterruptedException interruptedException) {
        this.f7332c.mo7872t().m8097A().m8109a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* JADX INFO: renamed from: a */
    public final void m8178a() {
        synchronized (this.f7330a) {
            this.f7330a.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.f7332c.f7322i.acquire();
                z = true;
            } catch (InterruptedException e) {
                m8177a(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzcik<?> zzcikVarPoll = this.f7331b.poll();
                if (zzcikVarPoll == null) {
                    synchronized (this.f7330a) {
                        if (this.f7331b.peek() == null && !this.f7332c.f7323j) {
                            try {
                                this.f7330a.wait(30000L);
                            } catch (InterruptedException e2) {
                                m8177a(e2);
                            }
                        }
                    }
                    synchronized (this.f7332c.f7321h) {
                        if (this.f7331b.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(zzcikVarPoll.f7326a ? threadPriority : 10);
                    zzcikVarPoll.run();
                }
            }
            synchronized (this.f7332c.f7321h) {
                this.f7332c.f7322i.release();
                this.f7332c.f7321h.notifyAll();
                if (this == this.f7332c.f7315b) {
                    zzcih.m8162a(this.f7332c, null);
                } else if (this == this.f7332c.f7316c) {
                    zzcih.m8165b(this.f7332c, null);
                } else {
                    this.f7332c.mo7872t().m8106y().m8108a("Current scheduler thread is neither worker nor network");
                }
            }
        } catch (Throwable th) {
            synchronized (this.f7332c.f7321h) {
                this.f7332c.f7322i.release();
                this.f7332c.f7321h.notifyAll();
                if (this == this.f7332c.f7315b) {
                    zzcih.m8162a(this.f7332c, null);
                } else if (this == this.f7332c.f7316c) {
                    zzcih.m8165b(this.f7332c, null);
                } else {
                    this.f7332c.mo7872t().m8106y().m8108a("Current scheduler thread is neither worker nor network");
                }
                throw th;
            }
        }
    }
}
