package com.salesforce.android.cases.core.internal.model;

import com.salesforce.android.cases.core.internal.http.response.CommunitiesListResponse;
import com.salesforce.android.cases.core.model.Community;

/* JADX INFO: loaded from: classes.dex */
public class CommunityModel implements Community {

    /* JADX INFO: renamed from: a */
    private String f12495a;

    /* JADX INFO: renamed from: b */
    private String f12496b;

    private CommunityModel(CommunitiesListResponse.Community community) {
        this.f12495a = community.m12325a();
        this.f12496b = community.m12326b();
    }

    @Override // com.salesforce.android.cases.core.model.Community
    /* JADX INFO: renamed from: a */
    public String mo12477a() {
        return this.f12495a;
    }

    @Override // com.salesforce.android.cases.core.model.Community
    /* JADX INFO: renamed from: b */
    public String mo12478b() {
        return this.f12496b;
    }

    /* JADX INFO: renamed from: a */
    public static CommunityModel m12476a(CommunitiesListResponse.Community community) {
        return new CommunityModel(community);
    }
}
