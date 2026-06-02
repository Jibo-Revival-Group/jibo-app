package com.salesforce.android.knowledge.core.internal.client;

import android.content.Context;
import com.salesforce.android.knowledge.core.KnowledgeClient;
import com.salesforce.android.knowledge.core.KnowledgeConfiguration;
import com.salesforce.android.knowledge.core.LogoutListener;
import com.salesforce.android.knowledge.core.internal.http.HttpService;
import com.salesforce.android.knowledge.core.internal.operations.OperationFactory;
import com.salesforce.android.knowledge.core.internal.p021db.DbService;
import com.salesforce.android.knowledge.core.internal.utils.UserLogoutBroadcastReceiver;
import com.salesforce.android.knowledge.core.model.ArticleDetails;
import com.salesforce.android.knowledge.core.model.ArticleList;
import com.salesforce.android.knowledge.core.model.DataCategoryGroup;
import com.salesforce.android.knowledge.core.model.DataCategoryList;
import com.salesforce.android.knowledge.core.offline.OfflineResourceCacher;
import com.salesforce.android.knowledge.core.requests.ArticleDetailRequest;
import com.salesforce.android.knowledge.core.requests.ArticleListRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoriesRequest;
import com.salesforce.android.knowledge.core.requests.DataCategoryGroupRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public class KnowledgeClientImpl implements KnowledgeClient {

    /* JADX INFO: renamed from: a */
    private final HttpService f12887a;

    /* JADX INFO: renamed from: b */
    private final DbService f12888b;

    /* JADX INFO: renamed from: c */
    private final OperationFactory f12889c;

    /* JADX INFO: renamed from: d */
    private final OfflineResourceCacher f12890d;

    /* JADX INFO: renamed from: e */
    private final KnowledgeConfiguration f12891e;

    /* JADX INFO: renamed from: f */
    private final UserLogoutBroadcastReceiver f12892f;

    /* JADX INFO: renamed from: a */
    public static Builder m13085a(KnowledgeConfiguration knowledgeConfiguration) {
        return new Builder(knowledgeConfiguration);
    }

    KnowledgeClientImpl(Builder builder) {
        this.f12891e = builder.f12897e;
        this.f12887a = builder.f12893a;
        this.f12888b = builder.f12894b;
        this.f12889c = builder.f12895c;
        this.f12890d = builder.f12896d;
        this.f12892f = builder.f12898f;
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: a */
    public String mo13069a() {
        return this.f12891e.m13075a();
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: a */
    public Async<DataCategoryGroup> mo13068a(DataCategoryGroupRequest dataCategoryGroupRequest) {
        return this.f12889c.m13272a(dataCategoryGroupRequest, this.f12888b, this.f12887a).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: b */
    public OfflineResourceCacher mo13071b() {
        return this.f12890d;
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: c */
    public void mo13072c() {
        this.f12892f.m13280a(SalesforceSDKManager.m14403a().m14446k());
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: a */
    public void mo13070a(LogoutListener logoutListener) {
        this.f12892f.mo13274a(logoutListener);
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: a */
    public Async<ArticleList> mo13066a(ArticleListRequest articleListRequest) {
        return this.f12889c.m13270a(articleListRequest, this.f12888b, this.f12887a).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: a */
    public Async<ArticleDetails> mo13065a(ArticleDetailRequest articleDetailRequest) {
        return this.f12889c.m13269a(articleDetailRequest, this.f12888b, this.f12887a, this.f12890d).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.knowledge.core.KnowledgeClient
    /* JADX INFO: renamed from: a */
    public Async<DataCategoryList> mo13067a(DataCategoriesRequest dataCategoriesRequest) {
        return this.f12889c.m13271a(dataCategoriesRequest, this.f12888b, this.f12887a).mo12556e().mo12557f();
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        HttpService f12893a;

        /* JADX INFO: renamed from: b */
        DbService f12894b;

        /* JADX INFO: renamed from: c */
        OperationFactory f12895c;

        /* JADX INFO: renamed from: d */
        OfflineResourceCacher f12896d;

        /* JADX INFO: renamed from: e */
        final KnowledgeConfiguration f12897e;

        /* JADX INFO: renamed from: f */
        UserLogoutBroadcastReceiver f12898f;

        Builder(KnowledgeConfiguration knowledgeConfiguration) {
            this.f12897e = knowledgeConfiguration;
        }

        /* JADX INFO: renamed from: a */
        public KnowledgeClientImpl m13086a(Context context) throws GeneralSecurityException {
            if (this.f12898f == null) {
                this.f12898f = new UserLogoutBroadcastReceiver.Builder(context.getApplicationContext(), this.f12897e.m13079e()).m13284d();
            }
            if (this.f12895c == null) {
                this.f12895c = new OperationFactory();
            }
            if (this.f12893a == null) {
                this.f12893a = HttpService.m13145a(context.getApplicationContext(), this.f12897e.m13075a(), this.f12897e.m13077c(), this.f12897e.m13078d(), this.f12898f).m13151a();
            }
            if (this.f12894b == null) {
                this.f12894b = DbService.m13130a(this.f12897e.m13078d(), this.f12898f).m13138a();
            }
            if (this.f12896d == null) {
                this.f12896d = OfflineResourceCacher.m13293a(this.f12897e, this.f12898f);
            }
            return new KnowledgeClientImpl(this);
        }
    }
}
