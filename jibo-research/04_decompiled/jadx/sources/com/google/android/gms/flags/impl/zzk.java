package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzk implements Callable<SharedPreferences> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Context f6757a;

    zzk(Context context) {
        this.f6757a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() throws Exception {
        return this.f6757a.getSharedPreferences("google_sdk_flags", 0);
    }
}
