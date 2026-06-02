package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleCallback {

    /* JADX INFO: renamed from: a */
    protected final zzcf f6157a;

    protected LifecycleCallback(zzcf zzcfVar) {
        this.f6157a = zzcfVar;
    }

    /* JADX INFO: renamed from: a */
    protected static zzcf m6949a(zzce zzceVar) {
        if (zzceVar.m7159a()) {
            return zzdb.m7186a(zzceVar.m7162d());
        }
        if (zzceVar.m7160b()) {
            return zzcg.m7167a(zzceVar.m7161c());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static zzcf getChimeraLifecycleFragmentImpl(zzce zzceVar) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* JADX INFO: renamed from: a */
    public final Activity m6950a() {
        return this.f6157a.mo7163a();
    }

    /* JADX INFO: renamed from: a */
    public void mo6951a(int i, int i2, Intent intent) {
    }

    /* JADX INFO: renamed from: a */
    public void mo6952a(Bundle bundle) {
    }

    /* JADX INFO: renamed from: a */
    public void mo6953a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* JADX INFO: renamed from: b */
    public void mo6954b() {
    }

    /* JADX INFO: renamed from: b */
    public void mo6955b(Bundle bundle) {
    }

    /* JADX INFO: renamed from: c */
    public void mo6956c() {
    }

    /* JADX INFO: renamed from: d */
    public void mo6957d() {
    }

    /* JADX INFO: renamed from: e */
    public void m6958e() {
    }
}
