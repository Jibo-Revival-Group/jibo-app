package com.salesforce.android.service.common.liveagentlogging.event;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseEvent {

    /* JADX INFO: renamed from: a */
    private final transient Date f13592a = new Date();

    /* JADX INFO: renamed from: b */
    private final transient String f13593b;

    /* JADX INFO: renamed from: c */
    private final transient String f13594c;

    /* JADX INFO: renamed from: d */
    private transient String f13595d;

    public BaseEvent(String str, String str2) {
        this.f13595d = "00D000000000000";
        this.f13593b = str;
        this.f13594c = str2;
        this.f13595d = "00D000000000000";
    }

    /* JADX INFO: renamed from: a */
    public Date m13892a() {
        return this.f13592a;
    }

    /* JADX INFO: renamed from: b */
    public String m13894b() {
        return this.f13593b;
    }

    /* JADX INFO: renamed from: c */
    public String m13895c() {
        return this.f13594c;
    }

    /* JADX INFO: renamed from: d */
    public String m13896d() {
        return this.f13595d;
    }

    /* JADX INFO: renamed from: a */
    public void m13893a(String str) {
        this.f13595d = str;
    }
}
