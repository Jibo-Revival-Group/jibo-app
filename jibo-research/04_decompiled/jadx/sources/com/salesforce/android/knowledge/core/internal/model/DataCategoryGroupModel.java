package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryGroupModel implements DataCategoryGroup {

    /* JADX INFO: renamed from: a */
    private final String f12978a;

    /* JADX INFO: renamed from: b */
    private final String f12979b;

    /* JADX INFO: renamed from: c */
    private final List<DataCategoryTree> f12980c;

    DataCategoryGroupModel(String str, String str2, List<DataCategoryTree> list) {
        this.f12978a = str;
        this.f12979b = str2;
        this.f12980c = list;
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryGroupModel m13236a(DataCategoryGroupsResponse.DataCategoryGroup dataCategoryGroup) {
        ArrayList arrayList = new ArrayList(dataCategoryGroup.m13194c().size());
        Iterator<DataCategoryGroupsResponse.DataCategory> it = dataCategoryGroup.m13194c().iterator();
        while (it.hasNext()) {
            arrayList.add(DataCategoryTreeModel.m13249a(it.next()));
        }
        return new DataCategoryGroupModel(dataCategoryGroup.m13193b(), dataCategoryGroup.m13192a(), arrayList);
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryGroupModel m13237a(String str, String str2, List<DataCategoryTree> list) {
        return new DataCategoryGroupModel(str, str2, list);
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryGroup
    /* JADX INFO: renamed from: a */
    public String mo13238a() {
        return this.f12978a;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryGroup
    /* JADX INFO: renamed from: b */
    public String mo13239b() {
        return this.f12979b;
    }

    public String toString() {
        return this.f12979b;
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryGroup
    /* JADX INFO: renamed from: c */
    public List<DataCategoryTree> mo13240c() {
        return Collections.unmodifiableList(this.f12980c);
    }
}
