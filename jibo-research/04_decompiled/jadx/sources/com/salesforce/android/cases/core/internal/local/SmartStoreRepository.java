package com.salesforce.android.cases.core.internal.local;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.salesforce.android.cases.core.internal.http.serializer.DateTypeAdapter;
import com.salesforce.android.cases.core.internal.http.util.CaseConstants;
import com.salesforce.android.cases.core.internal.model.CaseDetailRecordModel;
import com.salesforce.android.cases.core.internal.model.CaseFeedModel;
import com.salesforce.android.cases.core.internal.model.CaseLayoutDataModel;
import com.salesforce.android.cases.core.internal.model.CaseListRecordModel;
import com.salesforce.android.cases.core.internal.model.CommunityModel;
import com.salesforce.android.cases.core.internal.model.DefaultValuesModel;
import com.salesforce.android.cases.core.internal.model.ListViewDescribeModel;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import com.salesforce.android.service.common.utilities.threading.PriorityThreadFactory;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.IndexSpec;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class SmartStoreRepository implements LocalRepository {

    /* JADX INFO: renamed from: a */
    private static final IndexSpec[] f12344a = {new IndexSpec(ShareConstants.WEB_DIALOG_PARAM_ID, SmartStore.Type.string)};

    /* JADX INFO: renamed from: b */
    private KeyValueSmartstore f12345b;

    /* JADX INFO: renamed from: c */
    private KeyValueSmartstore f12346c;

    /* JADX INFO: renamed from: d */
    private KeyValueSmartstore f12347d;

    /* JADX INFO: renamed from: e */
    private KeyValueSmartstore f12348e;

    /* JADX INFO: renamed from: f */
    private KeyValueSmartstore f12349f;

    /* JADX INFO: renamed from: g */
    private KeyValueSmartstore f12350g;

    /* JADX INFO: renamed from: h */
    private KeyValueSmartstore f12351h;

    /* JADX INFO: renamed from: i */
    private KeyValueSmartstore f12352i;

    /* JADX INFO: renamed from: j */
    private KeyValueSmartstore f12353j;

    /* JADX INFO: renamed from: k */
    private KeyValueSmartstore f12354k;

    /* JADX INFO: renamed from: l */
    private KeyValueSmartstore f12355l;

    /* JADX INFO: renamed from: m */
    private final KeyValueSmartstoreFactory f12356m;

    /* JADX INFO: renamed from: n */
    private final Gson f12357n;

    /* JADX INFO: renamed from: o */
    private final UserAccount f12358o;

    /* JADX INFO: renamed from: p */
    private final JobQueue f12359p;

    /* JADX INFO: renamed from: q */
    private SmartStore f12360q;

    /* JADX INFO: renamed from: r */
    private final ServiceLogger f12361r = ServiceLogging.m14203a((Class<?>) SmartStoreRepository.class);

    SmartStoreRepository(Builder builder) {
        this.f12357n = builder.m12402b();
        this.f12359p = builder.m12403c();
        this.f12356m = builder.m12400a();
        this.f12358o = builder.m12404d();
        m12397d();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<String> mo12388a(ListViewRequest listViewRequest) {
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot retrieve list view id: Not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getListViewId");
        basicAsyncM14086g.mo12614b(this.f12345b.m12370a(listViewRequest.m12679a()));
        this.f12361r.mo14188b("Ending Local getListViewId");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12389a(ListViewRequest listViewRequest, String str) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot store list view id: Not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local storeListViewId");
        this.f12345b.m12372a(listViewRequest.m12679a(), str);
        this.f12361r.mo14188b("Ending Local storeListViewId");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: b */
    public Async<String> mo12393b(ListViewRequest listViewRequest) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Retrieve List View Label: Not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getListViewLabel");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        basicAsyncM14086g.mo12614b(this.f12346c.m12370a(listViewRequest.m12679a()));
        this.f12361r.mo14188b("Finished Local getListViewLabel");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: b */
    public Async<Void> mo12394b(ListViewRequest listViewRequest, String str) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Save List View Label: Not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local storeListViewLabel");
        this.f12346c.m12372a(listViewRequest.m12679a(), str);
        this.f12361r.mo14188b("Finished Local storeListViewLabel");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Map<String, Date>> mo12374a() {
        Date dateM12608a;
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Retrieve Last Read Dates: Not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getCaseLastReadDates");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        Map<String, String> mapM12371a = this.f12347d.m12371a();
        HashMap map = new HashMap(mapM12371a.size() + 1, 1.0f);
        for (String str : mapM12371a.keySet()) {
            String str2 = mapM12371a.get(str);
            if (!StringUtils.m12617b(str2)) {
                dateM12608a = null;
            } else {
                dateM12608a = DateUtils.m12608a(str2);
            }
            if (dateM12608a == null) {
                dateM12608a = CaseConstants.f12329a;
            }
            map.put(str, dateM12608a);
        }
        this.f12361r.mo14188b("Finished Local getCaseLastReadDates");
        return basicAsyncM14086g.mo12614b(map).mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12390a(String str, Date date) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Last Read Dates: Not authenticated"));
        }
        this.f12361r.mo14188b("Starting setCaseLastReadDate");
        this.f12347d.m12372a(str, DateUtils.m12607a(date));
        this.f12361r.mo14188b("Finished local setCaseLastReadDate");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: b */
    public Async<Map<String, Boolean>> mo12392b() {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get Hidden Status: Not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getCaseHiddenStatus");
        Map<String, String> mapM12371a = this.f12348e.m12371a();
        HashMap map = new HashMap(mapM12371a.size() + 1, 1.0f);
        for (String str : mapM12371a.keySet()) {
            map.put(str, Boolean.valueOf(Boolean.parseBoolean(mapM12371a.get(str))));
        }
        this.f12361r.mo14188b("Finished Local getCaseHiddenStatus");
        return BasicAsync.m14084c(map);
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12391a(String str, boolean z) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Hidden Status, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local setCaseHidden");
        this.f12348e.m12372a(str, String.valueOf(z));
        this.f12361r.mo14188b("Finished Local setCaseHidden");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<List<CaseListRecord>> mo12379a(CaseListRequest caseListRequest) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get Hidden Status, not authenticated"));
        }
        return this.f12359p.m14223a(ReadJob.m12396a(this.f12360q, QuerySpec.m14745a("CaseList", ShareConstants.WEB_DIALOG_PARAM_ID, QuerySpec.Order.descending, Integer.MAX_VALUE), 0, this.f12358o)).mo14078b(new WriteCaseListFunction(this.f12357n));
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12380a(CaseListRequest caseListRequest, List<CaseListRecord> list) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Case List, not authenticated"));
        }
        this.f12361r.mo14189b("Scheduling write asysc for {}", "CaseList");
        try {
            JSONArray jSONArray = new JSONArray(this.f12357n.m9362b(list));
            this.f12361r.mo14189b("Write schedule complete for {}", "CaseList");
            return this.f12359p.m14223a(WriteJob.m12406a(this.f12360q, "CaseList", jSONArray, this.f12358o));
        } catch (JSONException e) {
            this.f12361r.mo14195e("JSONException: Error storing CaseListRecords to local db, {}", e.getMessage());
            return BasicAsync.m14085c((Throwable) e);
        }
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<ListViewDescribe> mo12386a(ListViewDescribeRequest listViewDescribeRequest) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get List View, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getListViewDescribe");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        String strM12370a = this.f12349f.m12370a(listViewDescribeRequest.m12674a());
        ListViewDescribe listViewDescribe = null;
        if (strM12370a != null) {
            listViewDescribe = (ListViewDescribe) this.f12357n.m9355a(strM12370a, ListViewDescribeModel.class);
        }
        if (listViewDescribe != null) {
            basicAsyncM14086g.mo12614b(listViewDescribe);
        }
        this.f12361r.mo14188b("Finished Local getListViewDescribe");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12387a(ListViewDescribeRequest listViewDescribeRequest, ListViewDescribe listViewDescribe) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set List View, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local setListViewDescribe");
        this.f12349f.m12372a(listViewDescribeRequest.m12674a(), this.f12357n.m9362b(listViewDescribe));
        this.f12361r.mo14188b("Ending Local setListViewDescribe");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<CaseFeed> mo12377a(CaseFeedRequest caseFeedRequest) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get Case Feed, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getCaseFeed");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        String strM12370a = this.f12350g.m12370a(caseFeedRequest.m12629b());
        CaseFeed caseFeed = null;
        if (strM12370a != null) {
            caseFeed = (CaseFeed) this.f12357n.m9355a(strM12370a, CaseFeedModel.class);
        }
        if (caseFeed != null) {
            basicAsyncM14086g.mo12614b(caseFeed);
        }
        this.f12361r.mo14188b("Finished Local getCaseFeed");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12378a(CaseFeedRequest caseFeedRequest, CaseFeed caseFeed) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Case Feed, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local setCaseFeed");
        this.f12350g.m12372a(caseFeedRequest.m12629b(), this.f12357n.m9362b(caseFeed));
        this.f12361r.mo14188b("Ending Local setCaseFeed");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12376a(CaseDetailRequest caseDetailRequest, CaseDetailRecord caseDetailRecord) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Case Detail, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local setCaseDetail");
        this.f12351h.m12372a(caseDetailRequest.m12623a(), this.f12357n.m9362b(caseDetailRecord));
        this.f12361r.mo14188b("Ending Local setCaseFeed");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<CaseDetailRecord> mo12375a(CaseDetailRequest caseDetailRequest) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get Case Detail, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getCaseDetail");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        String strM12370a = this.f12351h.m12370a(caseDetailRequest.m12623a());
        CaseDetailRecord caseDetailRecord = null;
        if (strM12370a != null) {
            caseDetailRecord = (CaseDetailRecord) this.f12357n.m9355a(strM12370a, CaseDetailRecordModel.class);
        }
        if (caseDetailRecord != null) {
            basicAsyncM14086g.mo12614b(caseDetailRecord);
        }
        this.f12361r.mo14188b("Finished Local getCaseDetail");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12385a(DefaultValuesRequest defaultValuesRequest, DefaultValues defaultValues) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Default Values, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local setDefaultValues");
        this.f12352i.m12372a(defaultValuesRequest.m12669a(), this.f12357n.m9362b(defaultValues));
        this.f12361r.mo14188b("Ending Local setDefaultValues");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<DefaultValues> mo12384a(DefaultValuesRequest defaultValuesRequest) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get Default Values, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getDefaultValues");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        String strM12370a = this.f12352i.m12370a(defaultValuesRequest.m12669a());
        DefaultValues defaultValues = null;
        if (strM12370a != null) {
            defaultValues = (DefaultValues) this.f12357n.m9355a(strM12370a, DefaultValuesModel.class);
        }
        if (defaultValues != null) {
            basicAsyncM14086g.mo12614b(defaultValues);
        }
        this.f12361r.mo14188b("Finished Local getDefaultValues");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<CaseLayoutData> mo12382a(CreateCaseQuickActionRequest createCaseQuickActionRequest) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get Case Layout Data, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getDefaultValues");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        String strM12370a = this.f12353j.m12370a(createCaseQuickActionRequest.m12658a());
        CaseLayoutData caseLayoutData = null;
        if (strM12370a != null) {
            caseLayoutData = (CaseLayoutData) this.f12357n.m9355a(strM12370a, CaseLayoutDataModel.class);
        }
        if (caseLayoutData != null) {
            basicAsyncM14086g.mo12614b(caseLayoutData);
        }
        this.f12361r.mo14188b("Finished Local getDefaultValues");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12383a(CreateCaseQuickActionRequest createCaseQuickActionRequest, CaseLayoutData caseLayoutData) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Case Layout Data, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local setDefaultValues");
        this.f12353j.m12372a(createCaseQuickActionRequest.m12658a(), this.f12357n.m9362b(caseLayoutData));
        this.f12361r.mo14188b("Ending Local setDefaultValues");
        return BasicAsync.m14087h();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: c */
    public Async<List<Community>> mo12395c() {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Get Communities, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local getCommunities");
        BasicAsync basicAsyncM14086g = BasicAsync.m14086g();
        String strM12370a = this.f12354k.m12370a("Instance");
        List list = null;
        if (strM12370a != null) {
            list = (List) this.f12357n.m9356a(strM12370a, new TypeToken<ArrayList<CommunityModel>>() { // from class: com.salesforce.android.cases.core.internal.local.SmartStoreRepository.1
            }.getType());
        }
        if (list != null) {
            basicAsyncM14086g.mo12614b(list);
        }
        this.f12361r.mo14188b("Finished Local getCommunities");
        return basicAsyncM14086g.mo12613b();
    }

    @Override // com.salesforce.android.cases.core.internal.local.LocalRepository
    /* JADX INFO: renamed from: a */
    public Async<Void> mo12381a(CommunitiesListRequest communitiesListRequest, List<Community> list) {
        if (!DbUtils.m12369a(this.f12358o)) {
            return BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot Set Communities, not authenticated"));
        }
        this.f12361r.mo14188b("Starting Local setCommunities");
        this.f12354k.m12372a("Instance", this.f12357n.m9362b(list));
        this.f12361r.mo14188b("Ending Local setCommunities");
        return BasicAsync.m14087h();
    }

    /* JADX INFO: renamed from: d */
    private void m12397d() {
        if (DbUtils.m12369a(this.f12358o)) {
            try {
                m12398e();
            } catch (Exception e) {
                this.f12361r.mo14193d("{} encountered trying to initialize Smarstore, deleting database. Cause: {}", e.getClass().getSimpleName(), e.getLocalizedMessage());
                m12399f();
                m12398e();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m12398e() {
        this.f12360q = SmartStoreSDKManager.m14661H().m14667b(this.f12358o);
        this.f12360q.m14795a("CaseList", f12344a);
        this.f12346c = this.f12356m.m12373a("ListLabel");
        this.f12345b = this.f12356m.m12373a("ListId");
        this.f12347d = this.f12356m.m12373a("CaseReadDate");
        this.f12348e = this.f12356m.m12373a("CasesHidden");
        this.f12349f = this.f12356m.m12373a("ListViewDescribe");
        this.f12350g = this.f12356m.m12373a("CaseFeed");
        this.f12351h = this.f12356m.m12373a("CaseDetail");
        this.f12352i = this.f12356m.m12373a("DefaultValues");
        this.f12353j = this.f12356m.m12373a("CaseLayout");
        this.f12354k = this.f12356m.m12373a("Communities");
        this.f12355l = this.f12356m.m12373a("CommunityId");
    }

    /* JADX INFO: renamed from: f */
    private void m12399f() {
        if (DbUtils.m12369a(this.f12358o)) {
            SmartStoreSDKManager.m14661H().m14664I();
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private KeyValueSmartstoreFactory f12363a;

        /* JADX INFO: renamed from: b */
        private Gson f12364b;

        /* JADX INFO: renamed from: c */
        private JobQueue f12365c;

        /* JADX INFO: renamed from: d */
        private UserAccount f12366d;

        /* JADX INFO: renamed from: a */
        public KeyValueSmartstoreFactory m12400a() {
            return this.f12363a;
        }

        /* JADX INFO: renamed from: b */
        public Gson m12402b() {
            return this.f12364b;
        }

        /* JADX INFO: renamed from: c */
        public JobQueue m12403c() {
            return this.f12365c;
        }

        /* JADX INFO: renamed from: d */
        public UserAccount m12404d() {
            return this.f12366d;
        }

        /* JADX INFO: renamed from: a */
        public Builder m12401a(UserAccount userAccount) {
            this.f12366d = userAccount;
            return this;
        }

        /* JADX INFO: renamed from: e */
        public LocalRepository m12405e() {
            if (this.f12363a == null) {
                this.f12363a = new KeyValueSmartstoreFactory(this.f12366d);
            }
            if (this.f12364b == null) {
                this.f12364b = new GsonBuilder().m9380a((Type) Date.class, (Object) new DateTypeAdapter(Date.class)).m9379a("yyyy-MM-dd'T'HH:mm:ss.SSSZ").m9376a();
            }
            if (this.f12365c == null) {
                this.f12365c = new JobQueue(Executors.newSingleThreadExecutor(PriorityThreadFactory.m14230a()));
            }
            return new SmartStoreRepository(this);
        }
    }

    static class WriteCaseListFunction implements Function<JSONArray, Async<List<CaseListRecord>>> {

        /* JADX INFO: renamed from: a */
        private final Gson f12367a;

        WriteCaseListFunction(Gson gson) {
            this.f12367a = gson;
        }

        @Override // com.salesforce.android.service.common.utilities.functional.Function
        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Async<List<CaseListRecord>> mo12236a(JSONArray jSONArray) {
            List list = (List) this.f12367a.m9356a(jSONArray.toString(), new TypeToken<ArrayList<CaseListRecordModel>>() { // from class: com.salesforce.android.cases.core.internal.local.SmartStoreRepository.WriteCaseListFunction.1
            }.getType());
            return (list == null || list.isEmpty()) ? BasicAsync.m14085c((Throwable) new IllegalStateException("Cannot retrieve case list, List empty")) : BasicAsync.m14084c(list);
        }
    }
}
