package com.crashlytics.android.core;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class CrashlyticsPinningInfoProvider implements io.fabric.sdk.android.services.network.PinningInfoProvider {

    /* JADX INFO: renamed from: a */
    private final PinningInfoProvider f5246a;

    public CrashlyticsPinningInfoProvider(PinningInfoProvider pinningInfoProvider) {
        this.f5246a = pinningInfoProvider;
    }

    @Override // io.fabric.sdk.android.services.network.PinningInfoProvider
    /* JADX INFO: renamed from: a */
    public InputStream mo5892a() {
        return this.f5246a.m5951a();
    }

    @Override // io.fabric.sdk.android.services.network.PinningInfoProvider
    /* JADX INFO: renamed from: b */
    public String mo5893b() {
        return this.f5246a.m5952b();
    }

    @Override // io.fabric.sdk.android.services.network.PinningInfoProvider
    /* JADX INFO: renamed from: c */
    public String[] mo5894c() {
        return this.f5246a.m5953c();
    }

    @Override // io.fabric.sdk.android.services.network.PinningInfoProvider
    /* JADX INFO: renamed from: d */
    public long mo5895d() {
        return -1L;
    }
}
