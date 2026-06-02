package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzbhb;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcs {

    /* JADX INFO: renamed from: a */
    private static final ExecutorService f6358a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzbhb("GAC_Transform"));

    /* JADX INFO: renamed from: a */
    public static ExecutorService m7177a() {
        return f6358a;
    }
}
