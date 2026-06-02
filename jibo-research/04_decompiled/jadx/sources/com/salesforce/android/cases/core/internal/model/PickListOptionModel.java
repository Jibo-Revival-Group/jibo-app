package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.QuickActionResponse;
import com.salesforce.android.cases.core.model.PickListOption;

/* JADX INFO: loaded from: classes.dex */
public class PickListOptionModel implements PickListOption {

    /* JADX INFO: renamed from: a */
    private String f12514a;

    /* JADX INFO: renamed from: b */
    private String f12515b;

    public PickListOptionModel(QuickActionResponse.PickListOption pickListOption) {
        if (pickListOption == null) {
            throw new IllegalStateException("PickListOption cannot be null.");
        }
        this.f12514a = pickListOption.m12358a();
        this.f12515b = pickListOption.m12359b();
    }

    /* JADX INFO: renamed from: a */
    public String m12505a() {
        return this.f12514a;
    }

    @Override // com.salesforce.android.cases.core.model.PickListOption
    /* JADX INFO: renamed from: b */
    public String mo12506b() {
        return this.f12515b;
    }

    public String toString() {
        return m12505a();
    }
}
