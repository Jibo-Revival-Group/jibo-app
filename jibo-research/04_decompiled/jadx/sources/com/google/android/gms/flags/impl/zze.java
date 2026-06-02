package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zze implements Callable<Integer> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SharedPreferences f6747a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f6748b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ Integer f6749c;

    zze(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f6747a = sharedPreferences;
        this.f6748b = str;
        this.f6749c = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() throws Exception {
        return Integer.valueOf(this.f6747a.getInt(this.f6748b, this.f6749c.intValue()));
    }
}
