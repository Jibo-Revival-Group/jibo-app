package com.google.android.gms.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhf {

    /* JADX INFO: renamed from: b */
    private static zzbhf f6987b = new zzbhf();

    /* JADX INFO: renamed from: a */
    private zzbhe f6988a = null;

    /* JADX INFO: renamed from: a */
    public static zzbhe m7816a(Context context) {
        return f6987b.m7817b(context);
    }

    /* JADX INFO: renamed from: b */
    private final synchronized zzbhe m7817b(Context context) {
        if (this.f6988a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f6988a = new zzbhe(context);
        }
        return this.f6988a;
    }
}
