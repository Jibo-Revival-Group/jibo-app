package com.salesforce.android.cases.core.requests;

import com.salesforce.android.cases.core.SaveRequestBuilder;

/* JADX INFO: loaded from: classes.dex */
public abstract class SaveRequest {

    /* JADX INFO: renamed from: a */
    private final boolean f12599a;

    /* JADX INFO: renamed from: b */
    private final boolean f12600b;

    SaveRequest(SaveRequestBuilder saveRequestBuilder) {
        this.f12599a = saveRequestBuilder.m12192a();
        this.f12600b = saveRequestBuilder.m12194b();
    }

    /* JADX INFO: renamed from: a */
    public boolean m12689a() {
        return this.f12599a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m12690b() {
        return this.f12600b;
    }
}
