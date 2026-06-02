package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.p021db.DbService;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;

/* JADX INFO: loaded from: classes.dex */
class DataCategoriesOp implements Operation<DataCategoryList> {

    /* JADX INFO: renamed from: a */
    private final DataCategoriesRequest f12994a;

    /* JADX INFO: renamed from: b */
    private final DbService f12995b;

    /* JADX INFO: renamed from: c */
    private BasicAsync<DataCategoryList> f12996c = BasicAsync.m14086g();

    DataCategoriesOp(DataCategoriesRequest dataCategoriesRequest, DbService dbService, HttpService httpService) {
        this.f12994a = dataCategoriesRequest;
        this.f12995b = dbService;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: e */
    public Operation<DataCategoryList> mo12556e() {
        this.f12995b.m13137a(this.f12994a).mo14075a(this.f12996c);
        return this;
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.operations.Operation
    /* JADX INFO: renamed from: f */
    public Async<DataCategoryList> mo12557f() {
        return this.f12996c;
    }
}
