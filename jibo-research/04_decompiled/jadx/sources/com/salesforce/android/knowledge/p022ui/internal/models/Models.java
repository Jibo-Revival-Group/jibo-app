package com.salesforce.android.knowledge.p022ui.internal.models;

import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.p022ui.KnowledgeImageProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Models {
    /* JADX INFO: renamed from: a */
    public static List<DataCategoryInfo> m13624a(Collection<? extends DataCategorySummary> collection, ColorSelector colorSelector, KnowledgeImageProvider knowledgeImageProvider) {
        ArrayList arrayList = new ArrayList(collection.size());
        int i = 0;
        for (DataCategorySummary dataCategorySummary : collection) {
            arrayList.add(DataCategoryInfo.m13620a(dataCategorySummary, colorSelector.mo13555a(dataCategorySummary, i), knowledgeImageProvider));
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static ColorSelector m13623a(final int i) {
        return new ColorSelector() { // from class: com.salesforce.android.knowledge.ui.internal.models.Models.1
            @Override // com.salesforce.android.knowledge.p022ui.internal.models.ColorSelector
            /* JADX INFO: renamed from: a */
            public int mo13555a(DataCategorySummary dataCategorySummary, int i2) {
                return i;
            }
        };
    }
}
