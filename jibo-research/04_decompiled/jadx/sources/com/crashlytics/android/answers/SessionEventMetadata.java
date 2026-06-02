package com.crashlytics.android.answers;

/* JADX INFO: loaded from: classes.dex */
final class SessionEventMetadata {

    /* JADX INFO: renamed from: a */
    public final String f5091a;

    /* JADX INFO: renamed from: b */
    public final String f5092b;

    /* JADX INFO: renamed from: c */
    public final String f5093c;

    /* JADX INFO: renamed from: d */
    public final String f5094d;

    /* JADX INFO: renamed from: e */
    public final String f5095e;

    /* JADX INFO: renamed from: f */
    public final Boolean f5096f;

    /* JADX INFO: renamed from: g */
    public final String f5097g;

    /* JADX INFO: renamed from: h */
    public final String f5098h;

    /* JADX INFO: renamed from: i */
    public final String f5099i;

    /* JADX INFO: renamed from: j */
    public final String f5100j;

    /* JADX INFO: renamed from: k */
    public final String f5101k;

    /* JADX INFO: renamed from: l */
    public final String f5102l;

    /* JADX INFO: renamed from: m */
    private String f5103m;

    public SessionEventMetadata(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f5091a = str;
        this.f5092b = str2;
        this.f5093c = str3;
        this.f5094d = str4;
        this.f5095e = str5;
        this.f5096f = bool;
        this.f5097g = str6;
        this.f5098h = str7;
        this.f5099i = str8;
        this.f5100j = str9;
        this.f5101k = str10;
        this.f5102l = str11;
    }

    public String toString() {
        if (this.f5103m == null) {
            this.f5103m = "appBundleId=" + this.f5091a + ", executionId=" + this.f5092b + ", installationId=" + this.f5093c + ", androidId=" + this.f5094d + ", advertisingId=" + this.f5095e + ", limitAdTrackingEnabled=" + this.f5096f + ", betaDeviceToken=" + this.f5097g + ", buildId=" + this.f5098h + ", osVersion=" + this.f5099i + ", deviceModel=" + this.f5100j + ", appVersionCode=" + this.f5101k + ", appVersionName=" + this.f5102l;
        }
        return this.f5103m;
    }
}
