package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.DefaultValuesResponse;
import com.salesforce.android.cases.core.model.DefaultValues;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultValuesModel implements DefaultValues {

    /* JADX INFO: renamed from: a */
    private Map<String, String> f12507a;

    /* JADX INFO: renamed from: a */
    public static DefaultValues m12496a(DefaultValuesResponse defaultValuesResponse) {
        return new DefaultValuesModel(defaultValuesResponse);
    }

    private DefaultValuesModel(DefaultValuesResponse defaultValuesResponse) {
        if (defaultValuesResponse == null) {
            throw new IllegalArgumentException("DefaultValuesResponse cannot be null");
        }
        this.f12507a = new HashMap(defaultValuesResponse.m12331a());
    }

    @Override // com.salesforce.android.cases.core.model.DefaultValues
    /* JADX INFO: renamed from: a */
    public Map<String, String> mo12497a() {
        return this.f12507a;
    }
}
