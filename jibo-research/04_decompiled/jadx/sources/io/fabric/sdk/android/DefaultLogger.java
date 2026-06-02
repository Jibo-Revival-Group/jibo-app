package io.fabric.sdk.android;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultLogger implements Logger {

    /* JADX INFO: renamed from: a */
    private int f14496a;

    public DefaultLogger(int i) {
        this.f14496a = i;
    }

    public DefaultLogger() {
        this.f14496a = 4;
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: a */
    public boolean mo15065a(String str, int i) {
        return this.f14496a <= i;
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: a */
    public void mo15064a(String str, String str2, Throwable th) {
        if (mo15065a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m15067b(String str, String str2, Throwable th) {
        if (mo15065a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m15069c(String str, String str2, Throwable th) {
        if (mo15065a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: d */
    public void mo15071d(String str, String str2, Throwable th) {
        if (mo15065a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: e */
    public void mo15073e(String str, String str2, Throwable th) {
        if (mo15065a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: a */
    public void mo15063a(String str, String str2) {
        mo15064a(str, str2, (Throwable) null);
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: b */
    public void mo15066b(String str, String str2) {
        m15067b(str, str2, null);
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: c */
    public void mo15068c(String str, String str2) {
        m15069c(str, str2, null);
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: d */
    public void mo15070d(String str, String str2) {
        mo15071d(str, str2, null);
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: e */
    public void mo15072e(String str, String str2) {
        mo15073e(str, str2, null);
    }

    @Override // io.fabric.sdk.android.Logger
    /* JADX INFO: renamed from: a */
    public void mo15061a(int i, String str, String str2) {
        m15062a(i, str, str2, false);
    }

    /* JADX INFO: renamed from: a */
    public void m15062a(int i, String str, String str2, boolean z) {
        if (z || mo15065a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
