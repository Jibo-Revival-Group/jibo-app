package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public final class zzce {

    /* JADX INFO: renamed from: a */
    private final Object f6338a;

    /* JADX INFO: renamed from: a */
    public final boolean m7159a() {
        return this.f6338a instanceof FragmentActivity;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m7160b() {
        return this.f6338a instanceof Activity;
    }

    /* JADX INFO: renamed from: c */
    public final Activity m7161c() {
        return (Activity) this.f6338a;
    }

    /* JADX INFO: renamed from: d */
    public final FragmentActivity m7162d() {
        return (FragmentActivity) this.f6338a;
    }
}
