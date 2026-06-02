package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequestFactory;

/* JADX INFO: loaded from: classes2.dex */
public class CreateAppSpiCall extends AbstractAppSpiCall {
    @Override // io.fabric.sdk.android.services.settings.AbstractAppSpiCall
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo15426a(AppRequestData appRequestData) {
        return super.mo15426a(appRequestData);
    }

    public CreateAppSpiCall(Kit kit, String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(kit, str, str2, httpRequestFactory, HttpMethod.POST);
    }
}
