package com.salesforce.android.service.common.utilities.threading;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class PriorityThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: a */
    private final int f13952a;

    /* JADX INFO: renamed from: a */
    public static PriorityThreadFactory m14230a() {
        return new PriorityThreadFactory(10);
    }

    public PriorityThreadFactory(int i) {
        this.f13952a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(this.f13952a);
        return thread;
    }
}
