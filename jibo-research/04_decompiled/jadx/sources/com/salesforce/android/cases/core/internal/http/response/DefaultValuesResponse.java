package com.salesforce.android.cases.core.internal.http.response;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultValuesResponse {

    /* JADX INFO: renamed from: a */
    private Map<String, String> f12324a;

    /* JADX INFO: renamed from: a */
    public Map<String, String> m12331a() {
        return this.f12324a == null ? Collections.emptyMap() : Collections.unmodifiableMap(this.f12324a);
    }

    /* JADX INFO: renamed from: a */
    public void m12332a(Map<String, String> map) {
        this.f12324a = map;
    }
}
