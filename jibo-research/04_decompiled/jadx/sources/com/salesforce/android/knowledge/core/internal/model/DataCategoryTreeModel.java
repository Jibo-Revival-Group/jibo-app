package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategorySummary;
import com.salesforce.android.knowledge.core.model.DataCategoryTree;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryTreeModel implements DataCategoryTree {

    /* JADX INFO: renamed from: a */
    private final DataCategorySummaryModel f12986a;

    /* JADX INFO: renamed from: b */
    private DataCategoryTreeModel f12987b;

    /* JADX INFO: renamed from: c */
    private final Set<DataCategoryTree> f12988c = new LinkedHashSet();

    /* JADX INFO: renamed from: d */
    private final Set<DataCategoryTree> f12989d = Collections.unmodifiableSet(this.f12988c);

    public DataCategoryTreeModel(DataCategorySummaryModel dataCategorySummaryModel) {
        this.f12986a = dataCategorySummaryModel;
    }

    /* JADX INFO: renamed from: a */
    public DataCategoryTreeModel m13251a(DataCategoryTreeModel dataCategoryTreeModel) {
        if (this.f12987b != null) {
            this.f12987b.f12988c.remove(this);
        }
        dataCategoryTreeModel.f12988c.add(this);
        this.f12987b = dataCategoryTreeModel;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryTreeModel m13249a(DataCategoryGroupsResponse.DataCategory dataCategory) {
        return m13250a(dataCategory, null);
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryTreeModel m13250a(DataCategoryGroupsResponse.DataCategory dataCategory, String str) {
        DataCategoryTreeModel dataCategoryTreeModel = new DataCategoryTreeModel(DataCategorySummaryModel.m13243a(dataCategory, str));
        Iterator<DataCategoryGroupsResponse.DataCategory> it = dataCategory.m13191c().iterator();
        while (it.hasNext()) {
            m13250a(it.next(), dataCategoryTreeModel.mo13254c().mo13245a()).m13251a(dataCategoryTreeModel);
        }
        return dataCategoryTreeModel;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryTree
    /* JADX INFO: renamed from: a */
    public DataCategoryTree mo13252a() {
        return this.f12987b;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryTree
    /* JADX INFO: renamed from: b */
    public Set<DataCategoryTree> mo13253b() {
        return this.f12989d;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryTree
    /* JADX INFO: renamed from: c */
    public DataCategorySummary mo13254c() {
        return this.f12986a;
    }
}
