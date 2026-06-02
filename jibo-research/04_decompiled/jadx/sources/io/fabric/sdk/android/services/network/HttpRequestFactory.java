package io.fabric.sdk.android.services.network;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpRequestFactory {
    /* JADX INFO: renamed from: a */
    HttpRequest mo15345a(HttpMethod httpMethod, String str, Map<String, String> map);

    /* JADX INFO: renamed from: a */
    void mo15346a(PinningInfoProvider pinningInfoProvider);
}
