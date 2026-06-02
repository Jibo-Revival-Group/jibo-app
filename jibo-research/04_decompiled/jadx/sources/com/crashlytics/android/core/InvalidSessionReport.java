package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class InvalidSessionReport implements Report {

    /* JADX INFO: renamed from: a */
    private final File[] f5264a;

    /* JADX INFO: renamed from: b */
    private final Map<String, String> f5265b = new HashMap(ReportUploader.f5321a);

    /* JADX INFO: renamed from: c */
    private final String f5266c;

    public InvalidSessionReport(String str, File[] fileArr) {
        this.f5264a = fileArr;
        this.f5266c = str;
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: a */
    public String mo5914a() {
        return this.f5264a[0].getName();
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: b */
    public String mo5915b() {
        return this.f5266c;
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: c */
    public File mo5916c() {
        return this.f5264a[0];
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: d */
    public File[] mo5917d() {
        return this.f5264a;
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: e */
    public Map<String, String> mo5918e() {
        return Collections.unmodifiableMap(this.f5265b);
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: f */
    public void mo5919f() {
        for (File file : this.f5264a) {
            Fabric.m15085h().mo15063a("CrashlyticsCore", "Removing invalid report file at " + file.getPath());
            file.delete();
        }
    }
}
