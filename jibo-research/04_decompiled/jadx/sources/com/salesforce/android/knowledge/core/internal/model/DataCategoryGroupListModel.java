package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryGroupList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryGroupListModel implements DataCategoryGroupList {

    /* JADX INFO: renamed from: a */
    private final List<DataCategoryGroup> f12977a;

    DataCategoryGroupListModel(List<DataCategoryGroup> list) {
        this.f12977a = list;
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryGroupList m13234a(DataCategoryGroup... dataCategoryGroupArr) {
        return new DataCategoryGroupListModel(Arrays.asList(dataCategoryGroupArr));
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryGroupList m13232a(DataCategoryGroupsResponse dataCategoryGroupsResponse) {
        List<DataCategoryGroupsResponse.DataCategoryGroup> listM13188a = dataCategoryGroupsResponse.m13188a();
        ArrayList arrayList = new ArrayList(listM13188a.size());
        Iterator<DataCategoryGroupsResponse.DataCategoryGroup> it = listM13188a.iterator();
        while (it.hasNext()) {
            arrayList.add(DataCategoryGroupModel.m13236a(it.next()));
        }
        return new DataCategoryGroupListModel(arrayList);
    }

    /* JADX INFO: renamed from: a */
    public static DataCategoryGroupList m13233a(List<DataCategoryGroup> list) {
        return new DataCategoryGroupListModel(list);
    }

    @Override // com.salesforce.android.knowledge.core.model.DataCategoryGroupList
    /* JADX INFO: renamed from: a */
    public List<DataCategoryGroup> mo13235a() {
        return this.f12977a;
    }
}
