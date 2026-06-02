package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;

/* JADX INFO: loaded from: classes.dex */
public class DataCategorySummaryModel implements DataCategorySummary {

    /* JADX INFO: renamed from: a */
    private final String f12982a;

    /* JADX INFO: renamed from: b */
    private final String f12983b;

    /* JADX INFO: renamed from: c */
    private final int f12984c;

    /* JADX INFO: renamed from: d */
    private final String f12985d;

    DataCategorySummaryModel(String str, String str2, int i, String str3) {
        this.f12982a = str;
        this.f12983b = str2;
        this.f12984c = i;
        this.f12985d = str3;
    }

    /* JADX INFO: renamed from: a */
    public static DataCategorySummaryModel m13243a(DataCategoryGroupsResponse.DataCategory dataCategory, String str) {
        return m13244a(dataCategory.m13190b(), dataCategory.m13189a(), dataCategory.m13191c().size(), str);
    }

    /* JADX INFO: renamed from: a */
    public static DataCategorySummaryModel m13244a(String str, String str2, int i, String str3) {
        return new DataCategorySummaryModel(str, str2, i, str3);
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategorySummary
    /* JADX INFO: renamed from: a */
    public String mo13245a() {
        return this.f12982a;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategorySummary
    /* JADX INFO: renamed from: b */
    public String mo13246b() {
        return this.f12983b;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategorySummary
    /* JADX INFO: renamed from: c */
    public int mo13247c() {
        return this.f12984c;
    }

    public String toString() {
        return this.f12983b;
    }

    /* JADX INFO: renamed from: d */
    public String m13248d() {
        return this.f12985d;
    }
}
