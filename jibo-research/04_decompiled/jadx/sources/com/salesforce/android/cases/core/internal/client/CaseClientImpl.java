package com.salesforce.android.cases.core.internal.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.salesforce.android.cases.core.CaseClient;
import com.salesforce.android.cases.core.CaseClientCallbacks;
import com.salesforce.android.cases.core.CaseConfiguration;
import com.salesforce.android.cases.core.NotificationHandler;
import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.local.SmartStoreRepository;
import com.salesforce.android.cases.core.internal.operations.OperationFactory;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import java.security.GeneralSecurityException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseClientImpl implements CaseClient {

    /* JADX INFO: renamed from: a */
    Context f12272a;

    /* JADX INFO: renamed from: b */
    ActivityTracker f12273b;

    /* JADX INFO: renamed from: c */
    private final RemoteRepository f12274c;

    /* JADX INFO: renamed from: d */
    private final OperationFactory f12275d;

    /* JADX INFO: renamed from: e */
    private final CaseClientCallbacks f12276e;

    /* JADX INFO: renamed from: f */
    private final LocalRepository f12277f;

    /* JADX INFO: renamed from: g */
    private final UserAccount f12278g;

    /* JADX INFO: renamed from: h */
    private NotificationHandler f12279h;

    CaseClientImpl(Builder builder) {
        this.f12274c = builder.m12203c();
        this.f12275d = builder.m12204d();
        this.f12276e = builder.m12202b();
        this.f12277f = builder.m12205e();
        this.f12272a = builder.m12208h();
        this.f12278g = builder.m12207g().m12184i();
        if (this.f12274c == null) {
            throw new IllegalStateException("RemoteRepository cannot be null.");
        }
        if (this.f12275d == null) {
            throw new IllegalStateException("OperationFactory cannot be null.");
        }
        if (this.f12277f == null) {
            throw new IllegalStateException("LocalRepository cannot be null.");
        }
        if (this.f12272a == null) {
            throw new IllegalStateException("Context cannot be null.");
        }
        if (builder.m12206f()) {
            SalesforceSDKManager.m14403a().m14431a(this);
            this.f12273b = new ActivityTracker();
            this.f12273b.m14064a(this.f12272a.getApplicationContext());
        }
    }

    /* JADX INFO: renamed from: a */
    public static Builder m12196a(CaseConfiguration caseConfiguration) {
        return new Builder(caseConfiguration);
    }

    /* JADX INFO: renamed from: a */
    public void m12199a(NotificationHandler notificationHandler) {
        this.f12279h = notificationHandler;
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<CaseLayoutData> mo12168a(CreateCaseQuickActionRequest createCaseQuickActionRequest) {
        return this.f12275d.m12565a(createCaseQuickActionRequest, this.f12277f, this.f12274c, this.f12278g).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<CreateCaseRecordResult> mo12169a(CreateCaseRecordRequest createCaseRecordRequest) {
        return this.f12275d.m12566a(createCaseRecordRequest, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<String> mo12172a(ListViewRequest listViewRequest) {
        return this.f12275d.m12569a(listViewRequest, this.f12277f, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: b */
    public Async<String> mo12175b(ListViewRequest listViewRequest) {
        return this.f12275d.m12572b(listViewRequest, this.f12277f, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<ListViewDescribe> mo12171a(ListViewDescribeRequest listViewDescribeRequest) {
        return this.f12275d.m12568a(listViewDescribeRequest, this.f12277f, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<List<CaseListRecord>> mo12165a(CaseListRequest caseListRequest) {
        return this.f12275d.m12561a(caseListRequest, this.f12277f, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<DefaultValues> mo12170a(DefaultValuesRequest defaultValuesRequest) {
        return this.f12275d.m12567a(defaultValuesRequest, this.f12277f, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12174a(SetCaseLastReadDateRequest setCaseLastReadDateRequest) {
        return this.f12275d.m12571a(setCaseLastReadDateRequest, this.f12277f, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12173a(SetCaseHiddenRequest setCaseHiddenRequest) {
        return this.f12275d.m12570a(setCaseHiddenRequest, this.f12277f, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<CompleteCaseFeed> mo12167a(CompleteCaseFeedRequest completeCaseFeedRequest) {
        return this.f12275d.m12564a(completeCaseFeedRequest, this.f12277f, this.f12274c, this.f12278g).mo12556e().mo12557f();
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public CaseClientCallbacks mo12164a() {
        return this.f12276e;
    }

    @Override // com.salesforce.android.cases.core.CaseClient
    /* JADX INFO: renamed from: a */
    public Async<CommentPost> mo12166a(CommentPostRequest commentPostRequest) {
        return this.f12275d.m12562a(commentPostRequest, this.f12274c).mo12556e().mo12557f();
    }

    @Override // com.salesforce.androidsdk.push.PushNotificationInterface
    /* JADX INFO: renamed from: a */
    public void mo12198a(Bundle bundle) {
        boolean zMo9873a = false;
        if (this.f12276e != null) {
            if (m12197b()) {
                zMo9873a = this.f12276e.mo9874b(bundle);
            } else {
                zMo9873a = this.f12276e.mo9873a(bundle);
            }
        }
        PushNotification pushNotification = new PushNotification(bundle);
        if (this.f12279h != null) {
            this.f12279h.mo12190a(pushNotification);
        }
        if (this.f12279h != null && !zMo9873a && !m12197b()) {
            this.f12279h.mo12189a(this.f12272a, pushNotification);
        }
        if (this.f12272a != null) {
            LocalBroadcastManager.m1878a(this.f12272a).m1883a(new Intent("Body").putExtras(bundle));
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m12197b() {
        return this.f12273b.m14065b() != null;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private final CaseConfiguration f12280a;

        /* JADX INFO: renamed from: b */
        private RemoteRepository f12281b;

        /* JADX INFO: renamed from: c */
        private OperationFactory f12282c;

        /* JADX INFO: renamed from: d */
        private LocalRepository f12283d;

        /* JADX INFO: renamed from: e */
        private Context f12284e;

        public Builder(CaseConfiguration caseConfiguration) {
            this.f12280a = caseConfiguration;
        }

        /* JADX INFO: renamed from: a */
        public CaseClientImpl m12201a() throws GeneralSecurityException {
            if (this.f12284e == null) {
                throw new IllegalStateException("Must set valid context for CaseClient");
            }
            if (!SalesforceSDKManager.m14415b() || !(SalesforceSDKManager.m14403a() instanceof SmartStoreSDKManager)) {
                throw new IllegalStateException("SmartstoreSdkManager must be initialized using SmartStoreSDKManager.initNative before launching CaseClient");
            }
            if (this.f12282c == null) {
                this.f12282c = new OperationFactory();
            }
            if (this.f12281b == null) {
                this.f12281b = RemoteRepository.m12592a(this.f12284e.getApplicationContext(), this.f12280a).m12606b();
            }
            if (this.f12283d == null) {
                this.f12283d = new SmartStoreRepository.Builder().m12401a(this.f12280a.m12184i()).m12405e();
            }
            Arguments.m14237a(this.f12284e);
            return new CaseClientImpl(this);
        }

        /* JADX INFO: renamed from: b */
        CaseClientCallbacks m12202b() {
            return this.f12280a.m12183h();
        }

        /* JADX INFO: renamed from: c */
        public RemoteRepository m12203c() {
            return this.f12281b;
        }

        /* JADX INFO: renamed from: d */
        public OperationFactory m12204d() {
            return this.f12282c;
        }

        /* JADX INFO: renamed from: e */
        public LocalRepository m12205e() {
            return this.f12283d;
        }

        /* JADX INFO: renamed from: f */
        public boolean m12206f() {
            return this.f12280a.m12181f();
        }

        /* JADX INFO: renamed from: a */
        public Builder m12200a(Context context) {
            this.f12284e = context;
            return this;
        }

        /* JADX INFO: renamed from: g */
        public CaseConfiguration m12207g() {
            return this.f12280a;
        }

        /* JADX INFO: renamed from: h */
        public Context m12208h() {
            return this.f12284e;
        }
    }
}
