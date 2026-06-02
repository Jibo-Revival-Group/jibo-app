package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryListModel implements DataCategoryList {

    /* JADX INFO: renamed from: a */
    private final List<DataCategorySummary> f12981a;

    DataCategoryListModel(List<DataCategorySummaryModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        this.f12981a = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryListModel m13241a(List<DataCategorySummaryModel> list) {
        return new DataCategoryListModel(list);
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryList
    /* JADX INFO: renamed from: a */
    public List<DataCategorySummary> mo13242a() {
        return this.f12981a;
    }
}
