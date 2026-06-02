package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzg implements Callable<Long> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SharedPreferences f6750a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f6751b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ Long f6752c;

    zzg(SharedPreferences sharedPreferences, String str, Long l) {
        this.f6750a = sharedPreferences;
        this.f6751b = str;
        this.f6752c = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        return Long.valueOf(this.f6750a.getLong(this.f6751b, this.f6752c.longValue()));
    }
}
