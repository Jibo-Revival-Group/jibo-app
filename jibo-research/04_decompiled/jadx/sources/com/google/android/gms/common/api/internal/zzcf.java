package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public interface zzcf {
    /* JADX INFO: renamed from: a */
    Activity mo7163a();

    /* JADX INFO: renamed from: a */
    <T extends LifecycleCallback> T mo7164a(String str, Class<T> cls);

    /* JADX INFO: renamed from: a */
    void mo7165a(String str, LifecycleCallback lifecycleCallback);

    void startActivityForResult(Intent intent, int i);
}
