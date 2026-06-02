package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzbhb;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class zzbl {

    /* JADX INFO: renamed from: a */
    private static final ExecutorService f6283a = Executors.newFixedThreadPool(2, new zzbhb("GAC_Executor"));

    /* JADX INFO: renamed from: a */
    public static ExecutorService m7088a() {
        return f6283a;
    }
}
