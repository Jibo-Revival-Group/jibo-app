package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.ListViewsResponse;
import com.salesforce.android.cases.core.model.ListView;

/* JADX INFO: loaded from: classes.dex */
public class ListViewModel implements ListView {

    /* JADX INFO: renamed from: a */
    private String f12511a;

    /* JADX INFO: renamed from: b */
    private String f12512b;

    /* JADX INFO: renamed from: c */
    private String f12513c;

    private ListViewModel(ListViewsResponse.ListView listView) {
        this.f12511a = listView.m12337a();
        this.f12512b = listView.m12338b();
        this.f12513c = listView.m12339c();
    }

    /* JADX INFO: renamed from: a */
    public static ListViewModel m12501a(ListViewsResponse.ListView listView) {
        return new ListViewModel(listView);
    }

    @Override // com.salesforce.android.cases.core.model.ListView
    /* JADX INFO: renamed from: a */
    public String mo12502a() {
        return this.f12511a;
    }

    @Override // com.salesforce.android.cases.core.model.ListView
    /* JADX INFO: renamed from: b */
    public String mo12503b() {
        return this.f12512b;
    }

    @Override // com.salesforce.android.cases.core.model.ListView
    /* JADX INFO: renamed from: c */
    public String mo12504c() {
        return this.f12513c;
    }
}
