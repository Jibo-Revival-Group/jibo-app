package com.crashlytics.android.core;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
class ManifestUnityVersionProvider implements UnityVersionProvider {

    /* JADX INFO: renamed from: a */
    private final Context f5271a;

    /* JADX INFO: renamed from: b */
    private final String f5272b;

    public ManifestUnityVersionProvider(Context context, String str) {
        this.f5271a = context;
        this.f5272b = str;
    }

    @Override // com.crashlytics.android.core.UnityVersionProvider
    /* JADX INFO: renamed from: a */
    public String mo5927a() {
        try {
            Bundle bundle = this.f5271a.getPackageManager().getApplicationInfo(this.f5272b, 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("io.fabric.unity.crashlytics.version");
        } catch (Exception e) {
            return null;
        }
    }
}
