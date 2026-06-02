package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzi implements Callable<String> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ SharedPreferences f6753a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f6754b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f6755c;

    zzi(SharedPreferences sharedPreferences, String str, String str2) {
        this.f6753a = sharedPreferences;
        this.f6754b = str;
        this.f6755c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f6753a.getString(this.f6754b, this.f6755c);
    }
}
