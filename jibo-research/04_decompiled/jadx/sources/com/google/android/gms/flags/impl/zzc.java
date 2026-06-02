package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzc implements Callable<Boolean> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SharedPreferences f6744a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f6745b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ Boolean f6746c;

    zzc(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f6744a = sharedPreferences;
        this.f6745b = str;
        this.f6746c = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf(this.f6744a.getBoolean(this.f6745b, this.f6746c.booleanValue()));
    }
}
