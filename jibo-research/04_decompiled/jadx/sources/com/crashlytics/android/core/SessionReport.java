package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class SessionReport implements Report {

    /* JADX INFO: renamed from: a */
    private final File f5334a;

    /* JADX INFO: renamed from: b */
    private final File[] f5335b;

    /* JADX INFO: renamed from: c */
    private final Map<String, String> f5336c;

    public SessionReport(File file) {
        this(file, Collections.emptyMap());
    }

    public SessionReport(File file, Map<String, String> map) {
        this.f5334a = file;
        this.f5335b = new File[]{file};
        this.f5336c = new HashMap(map);
        if (this.f5334a.length() == 0) {
            this.f5336c.putAll(ReportUploader.f5321a);
        }
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: c */
    public File mo5916c() {
        return this.f5334a;
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: d */
    public File[] mo5917d() {
        return this.f5335b;
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: a */
    public String mo5914a() {
        return mo5916c().getName();
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: b */
    public String mo5915b() {
        String strMo5914a = mo5914a();
        return strMo5914a.substring(0, strMo5914a.lastIndexOf(46));
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: e */
    public Map<String, String> mo5918e() {
        return Collections.unmodifiableMap(this.f5336c);
    }

    @Override // com.crashlytics.android.core.Report
    /* JADX INFO: renamed from: f */
    public void mo5919f() {
        Fabric.m15085h().mo15063a("CrashlyticsCore", "Removing report at " + this.f5334a.getPath());
        this.f5334a.delete();
    }
}
