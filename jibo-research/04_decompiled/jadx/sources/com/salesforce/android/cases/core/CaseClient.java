package com.salesforce.android.cases.core;

import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListViewDescribe;
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
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.androidsdk.push.PushNotificationInterface;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CaseClient extends PushNotificationInterface {
    /* JADX INFO: renamed from: a */
    CaseClientCallbacks mo12164a();

    /* JADX INFO: renamed from: a */
    Async<List<CaseListRecord>> mo12165a(CaseListRequest caseListRequest);

    /* JADX INFO: renamed from: a */
    Async<CommentPost> mo12166a(CommentPostRequest commentPostRequest);

    /* JADX INFO: renamed from: a */
    Async<CompleteCaseFeed> mo12167a(CompleteCaseFeedRequest completeCaseFeedRequest);

    /* JADX INFO: renamed from: a */
    Async<CaseLayoutData> mo12168a(CreateCaseQuickActionRequest createCaseQuickActionRequest);

    /* JADX INFO: renamed from: a */
    Async<CreateCaseRecordResult> mo12169a(CreateCaseRecordRequest createCaseRecordRequest);

    /* JADX INFO: renamed from: a */
    Async<DefaultValues> mo12170a(DefaultValuesRequest defaultValuesRequest);

    /* JADX INFO: renamed from: a */
    Async<ListViewDescribe> mo12171a(ListViewDescribeRequest listViewDescribeRequest);

    /* JADX INFO: renamed from: a */
    Async<String> mo12172a(ListViewRequest listViewRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12173a(SetCaseHiddenRequest setCaseHiddenRequest);

    /* JADX INFO: renamed from: a */
    Async<Void> mo12174a(SetCaseLastReadDateRequest setCaseLastReadDateRequest);

    /* JADX INFO: renamed from: b */
    Async<String> mo12175b(ListViewRequest listViewRequest);
}
