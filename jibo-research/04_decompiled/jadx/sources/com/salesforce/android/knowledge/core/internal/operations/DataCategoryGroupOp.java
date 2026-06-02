package com.salesforce.android.knowledge.core.internal.operations;

import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.http.response.DataCategoryGroupsResponse;
import com.salesforce.android.knowledge.core.internal.model.DataCategoryGroupListModel;
import com.salesforce.android.knowledge.core.internal.p021db.DbService;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryGroupList;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;

/* JADX INFO: loaded from: classes.dex */
public class DataCategoryGroupOp extends KnowledgeFetchSaveOp<DataCategoryGroupRequest, DataCategoryGroup> {

    /* JADX INFO: renamed from: a */
    final String f12997a;

    public DataCategoryGroupOp(DataCategoryGroupRequest dataCategoryGroupRequest, DbService dbService, HttpService httpService) {
        super(dataCategoryGroupRequest, dbService, httpService);
        this.f12997a = dataCategoryGroupRequest.m13335a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<DataCategoryGroup> mo13258a(DbService dbService, DataCategoryGroupRequest dataCategoryGroupRequest) {
        return dbService.m13131a().mo14076a(new Function<DataCategoryGroupList, DataCategoryGroup>() { // from class: com.salesforce.android.knowledge.core.internal.operations.DataCategoryGroupOp.1
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public DataCategoryGroup mo12236a(DataCategoryGroupList dataCategoryGroupList) {
                for (DataCategoryGroup dataCategoryGroup : dataCategoryGroupList.mo13235a()) {
                    if (dataCategoryGroup.mo13238a().equals(DataCategoryGroupOp.this.f12997a)) {
                        return dataCategoryGroup;
                    }
                }
                throw new DataCategoryGroupNotFoundException(DataCategoryGroupOp.this.f12997a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<DataCategoryGroup> mo13261a(HttpService httpService, DataCategoryGroupRequest dataCategoryGroupRequest) {
        return httpService.m13148a().mo14076a(new Function<DataCategoryGroupsResponse, DataCategoryGroup>() { // from class: com.salesforce.android.knowledge.core.internal.operations.DataCategoryGroupOp.2
            @Override // com.salesforce.android.service.common.utilities.functional.Function
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public DataCategoryGroup mo12236a(DataCategoryGroupsResponse dataCategoryGroupsResponse) {
                for (DataCategoryGroup dataCategoryGroup : DataCategoryGroupListModel.m13232a(dataCategoryGroupsResponse).mo13235a()) {
                    if (dataCategoryGroup.mo13238a().equals(DataCategoryGroupOp.this.f12997a)) {
                        return dataCategoryGroup;
                    }
                }
                throw new DataCategoryGroupNotFoundException(DataCategoryGroupOp.this.f12997a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Async<Void> mo13259a(DbService dbService, DataCategoryGroupRequest dataCategoryGroupRequest, DataCategoryGroup dataCategoryGroup) {
        return dbService.m13133a(dataCategoryGroup);
    }

    @Override // com.salesforce.android.knowledge.core.internal.operations.KnowledgeFetchSaveOp
    /* JADX INFO: renamed from: b */
    protected String mo13262b() {
        return "Could not fetch DataCategoryGroup";
    }

    public static class DataCategoryGroupNotFoundException extends RuntimeException {
        public DataCategoryGroupNotFoundException(String str) {
            super("Data category with the name \"" + str + "\" does not exist.");
        }
    }
}
