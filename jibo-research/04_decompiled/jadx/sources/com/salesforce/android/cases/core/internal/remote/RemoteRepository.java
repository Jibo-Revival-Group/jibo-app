package com.salesforce.android.cases.core.internal.remote;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.salesforce.android.cases.core.CaseConfiguration;
import com.salesforce.android.cases.core.internal.http.HttpService;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListView;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.service.common.fetchsave.internal.http.HttpService;
import com.salesforce.android.service.common.utilities.control.Async;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RemoteRepository implements HttpService {

    /* JADX INFO: renamed from: a */
    private com.salesforce.android.cases.core.internal.http.HttpService f12557a;

    /* JADX INFO: renamed from: b */
    private final Context f12558b;

    public RemoteRepository(Builder builder) {
        this.f12557a = builder.m12605a();
        if (this.f12557a == null) {
            throw new IllegalStateException("HttpService cannot be null.");
        }
        this.f12558b = builder.f12559a;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m12592a(Context context, CaseConfiguration caseConfiguration) {
        return new Builder(context, caseConfiguration);
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseLayoutData> m12598a(CreateCaseQuickActionRequest createCaseQuickActionRequest) {
        return this.f12557a.m12223a(createCaseQuickActionRequest);
    }

    /* JADX INFO: renamed from: a */
    public Async<CreateCaseRecordResult> m12599a(CreateCaseRecordRequest createCaseRecordRequest) {
        return this.f12557a.m12224a(createCaseRecordRequest);
    }

    /* JADX INFO: renamed from: a */
    public Async<List<Community>> m12593a() {
        return this.f12557a.m12218a();
    }

    /* JADX INFO: renamed from: b */
    public Async<List<ListView>> m12602b() {
        return this.f12557a.m12229b();
    }

    /* JADX INFO: renamed from: a */
    public Async<ListViewDescribe> m12601a(ListViewDescribeRequest listViewDescribeRequest) {
        return this.f12557a.m12226a(listViewDescribeRequest);
    }

    /* JADX INFO: renamed from: a */
    public Async<List<CaseListRecord>> m12596a(CaseListRequest caseListRequest) {
        return this.f12557a.m12221a(caseListRequest);
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseFeed> m12595a(CaseFeedRequest caseFeedRequest) {
        return this.f12557a.m12220a(caseFeedRequest);
    }

    /* JADX INFO: renamed from: a */
    public Async<CaseDetailRecord> m12594a(CaseDetailRequest caseDetailRequest) {
        return this.f12557a.m12219a(caseDetailRequest);
    }

    /* JADX INFO: renamed from: a */
    public Async<CommentPost> m12597a(CommentPostRequest commentPostRequest) {
        return this.f12557a.m12222a(commentPostRequest);
    }

    /* JADX INFO: renamed from: a */
    public Async<DefaultValues> m12600a(DefaultValuesRequest defaultValuesRequest) {
        return this.f12557a.m12225a(defaultValuesRequest);
    }

    @Override // com.salesforce.android.service.common.fetchsave.internal.http.HttpService
    /* JADX INFO: renamed from: c */
    public boolean mo12603c() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f12558b.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final Context f12559a;

        /* JADX INFO: renamed from: b */
        private final CaseConfiguration f12560b;

        /* JADX INFO: renamed from: c */
        private com.salesforce.android.cases.core.internal.http.HttpService f12561c;

        Builder(Context context, CaseConfiguration caseConfiguration) {
            this.f12559a = context;
            this.f12560b = caseConfiguration;
        }

        /* JADX INFO: renamed from: a */
        com.salesforce.android.cases.core.internal.http.HttpService m12605a() {
            return this.f12561c;
        }

        /* JADX INFO: renamed from: b */
        public RemoteRepository m12606b() throws NoSuchAlgorithmException, KeyManagementException {
            if (this.f12561c == null) {
                this.f12561c = new HttpService.Builder(this.f12559a, this.f12560b).m12237a();
            }
            return new RemoteRepository(this);
        }
    }
}
