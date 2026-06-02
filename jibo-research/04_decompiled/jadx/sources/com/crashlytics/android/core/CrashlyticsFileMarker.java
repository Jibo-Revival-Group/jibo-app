package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class CrashlyticsFileMarker {

    /* JADX INFO: renamed from: a */
    private final String f5244a;

    /* JADX INFO: renamed from: b */
    private final FileStore f5245b;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.f5244a = str;
        this.f5245b = fileStore;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5889a() {
        try {
            return m5888d().createNewFile();
        } catch (IOException e) {
            Fabric.m15085h().mo15073e("CrashlyticsCore", "Error creating marker: " + this.f5244a, e);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m5890b() {
        return m5888d().exists();
    }

    /* JADX INFO: renamed from: c */
    public boolean m5891c() {
        return m5888d().delete();
    }

    /* JADX INFO: renamed from: d */
    private File m5888d() {
        return new File(this.f5245b.mo15418a(), this.f5244a);
    }
}
