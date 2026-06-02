package com.salesforce.android.cases.core;

import com.salesforce.android.cases.core.SaveRequestBuilder;

/* JADX INFO: loaded from: classes.dex */
public abstract class SaveRequestBuilder<T extends SaveRequestBuilder<T>> {

    /* JADX INFO: renamed from: a */
    private boolean f12270a;

    /* JADX INFO: renamed from: b */
    private boolean f12271b;

    /* JADX INFO: renamed from: c */
    protected abstract T mo12195c();

    /* JADX INFO: renamed from: a */
    public T m12191a(boolean z) {
        this.f12270a = z;
        return (T) mo12195c();
    }

    /* JADX INFO: renamed from: b */
    public T m12193b(boolean z) {
        this.f12271b = z;
        return (T) mo12195c();
    }

    /* JADX INFO: renamed from: a */
    public boolean m12192a() {
        return this.f12270a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m12194b() {
        return this.f12271b;
    }
}
