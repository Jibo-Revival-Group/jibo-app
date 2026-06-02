package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zza implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private boolean f6699a = false;

    /* JADX INFO: renamed from: b */
    private final BlockingQueue<IBinder> f6700b = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: a */
    public final IBinder m7526a() throws InterruptedException {
        zzbq.m7385c("BlockingServiceConnection.getService() called on main thread");
        if (this.f6699a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f6699a = true;
        return this.f6700b.take();
    }

    /* JADX INFO: renamed from: a */
    public final IBinder m7527a(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        zzbq.m7385c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f6699a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f6699a = true;
        IBinder iBinderPoll = this.f6700b.poll(10000L, timeUnit);
        if (iBinderPoll == null) {
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        return iBinderPoll;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f6700b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
