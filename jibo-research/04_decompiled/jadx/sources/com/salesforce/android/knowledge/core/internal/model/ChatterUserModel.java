package com.salesforce.android.knowledge.core.internal.model;

import com.salesforce.android.knowledge.core.internal.http.response.ArticleDetailsResponse;
import com.salesforce.android.knowledge.core.model.ChatterUser;

/* JADX INFO: loaded from: classes.dex */
public class ChatterUserModel implements ChatterUser {

    /* JADX INFO: renamed from: a */
    private final String f12972a;

    /* JADX INFO: renamed from: b */
    private final String f12973b;

    /* JADX INFO: renamed from: c */
    private final String f12974c;

    /* JADX INFO: renamed from: d */
    private final String f12975d;

    /* JADX INFO: renamed from: e */
    private final String f12976e;

    ChatterUserModel(String str, String str2, String str3, String str4, String str5) {
        this.f12972a = str;
        this.f12973b = str2;
        this.f12974c = str3;
        this.f12975d = str4;
        this.f12976e = str5;
    }

    /* JADX INFO: renamed from: a */
    public static ChatterUserModel m13225a(ArticleDetailsResponse.User user) {
        return new ChatterUserModel(user.m13174b(), user.m13176d(), user.m13173a(), user.m13177e(), user.m13175c());
    }

    /* JADX INFO: renamed from: a */
    public static ChatterUserModel m13226a(String str, String str2, String str3, String str4, String str5) {
        return new ChatterUserModel(str, str2, str3, str4, str5);
    }

    @Override // com.salesforce.android.knowledge.core.model.ChatterUser
    /* JADX INFO: renamed from: a */
    public String mo13227a() {
        return this.f12974c;
    }

    @Override // com.salesforce.android.knowledge.core.model.ChatterUser
    /* JADX INFO: renamed from: b */
    public String mo13228b() {
        return this.f12972a;
    }

    @Override // com.salesforce.android.knowledge.core.model.ChatterUser
    /* JADX INFO: renamed from: c */
    public String mo13229c() {
        return this.f12976e;
    }

    @Override // com.salesforce.android.knowledge.core.model.ChatterUser
    /* JADX INFO: renamed from: d */
    public String mo13230d() {
        return this.f12973b;
    }

    @Override // com.salesforce.android.knowledge.core.model.ChatterUser
    /* JADX INFO: renamed from: e */
    public String mo13231e() {
        return this.f12975d;
    }
}
