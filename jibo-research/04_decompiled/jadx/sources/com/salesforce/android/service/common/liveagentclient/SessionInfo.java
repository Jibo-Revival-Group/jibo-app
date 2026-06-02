package com.salesforce.android.service.common.liveagentclient;

/* JADX INFO: loaded from: classes.dex */
public class SessionInfo {

    /* JADX INFO: renamed from: a */
    private final String f13508a;

    /* JADX INFO: renamed from: b */
    private final String f13509b;

    /* JADX INFO: renamed from: c */
    private final String f13510c;

    /* JADX INFO: renamed from: d */
    private final long f13511d;

    public SessionInfo(String str, String str2, String str3, long j) {
        this.f13508a = str;
        this.f13509b = str2;
        this.f13510c = str3;
        this.f13511d = j;
    }

    /* JADX INFO: renamed from: a */
    public String m13815a() {
        return this.f13508a;
    }

    /* JADX INFO: renamed from: b */
    public String m13816b() {
        return this.f13509b;
    }

    /* JADX INFO: renamed from: c */
    public String m13817c() {
        return this.f13510c;
    }

    /* JADX INFO: renamed from: d */
    public long m13818d() {
        return this.f13511d;
    }

    public String toString() {
        return String.format("SessionInfo[id=%s, key=%s, affinityToken=%s, pollingTimeoutMs=%s]", this.f13508a, this.f13509b, this.f13510c, Long.valueOf(this.f13511d));
    }
}
