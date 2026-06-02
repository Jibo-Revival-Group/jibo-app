package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhb implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    private final String f6978a;

    /* JADX INFO: renamed from: b */
    private final int f6979b;

    /* JADX INFO: renamed from: c */
    private final AtomicInteger f6980c;

    /* JADX INFO: renamed from: d */
    private final ThreadFactory f6981d;

    public zzbhb(String str) {
        this(str, 0);
    }

    private zzbhb(String str, int i) {
        this.f6980c = new AtomicInteger();
        this.f6981d = Executors.defaultThreadFactory();
        this.f6978a = (String) zzbq.m7374a(str, (Object) "Name must not be null");
        this.f6979b = 0;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f6981d.newThread(new zzbhc(runnable, 0));
        String str = this.f6978a;
        threadNewThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f6980c.getAndIncrement()).append("]").toString());
        return threadNewThread;
    }
}
