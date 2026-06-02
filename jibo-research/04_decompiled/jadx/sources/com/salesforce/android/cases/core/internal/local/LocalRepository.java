package com.salesforce.android.cases.core.internal.local;

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
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface LocalRepository {
    /* JADX INFO: renamed from: a */
    Async<Map<String, Date>> mo12374a();

    /* JADX INFO: renamed from: a */
    Async<CaseDetailRecord> mo12375a(CaseDetailRequest caseDetailRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12376a(CaseDetailRequest caseDetailRequest, CaseDetailRecord caseDetailRecord);

    /* JADX INFO: renamed from: a */
    Async<CaseFeed> mo12377a(CaseFeedRequest caseFeedRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12378a(CaseFeedRequest caseFeedRequest, CaseFeed caseFeed);

    /* JADX INFO: renamed from: a */
    Async<List<CaseListRecord>> mo12379a(CaseListRequest caseListRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12380a(CaseListRequest caseListRequest, List<CaseListRecord> list);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12381a(CommunitiesListRequest communitiesListRequest, List<Community> list);

    /* JADX INFO: renamed from: a */
    Async<CaseLayoutData> mo12382a(CreateCaseQuickActionRequest createCaseQuickActionRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12383a(CreateCaseQuickActionRequest createCaseQuickActionRequest, CaseLayoutData caseLayoutData);

    /* JADX INFO: renamed from: a */
    Async<DefaultValues> mo12384a(DefaultValuesRequest defaultValuesRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12385a(DefaultValuesRequest defaultValuesRequest, DefaultValues defaultValues);

    /* JADX INFO: renamed from: a */
    Async<ListViewDescribe> mo12386a(ListViewDescribeRequest listViewDescribeRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12387a(ListViewDescribeRequest listViewDescribeRequest, ListViewDescribe listViewDescribe);

    /* JADX INFO: renamed from: a */
    Async<String> mo12388a(ListViewRequest listViewRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12389a(ListViewRequest listViewRequest, String str);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12390a(String str, Date date);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12391a(String str, boolean z);

    /* JADX INFO: renamed from: b */
    Async<Map<String, Boolean>> mo12392b();

    /* JADX INFO: renamed from: b */
    Async<String> mo12393b(ListViewRequest listViewRequest);

    /* JADX INFO: renamed from: b */
    Async<Void> mo12394b(ListViewRequest listViewRequest, String str);

    /* JADX INFO: renamed from: c */
    Async<List<Community>> mo12395c();
}
