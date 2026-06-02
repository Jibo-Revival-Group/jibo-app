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

public interface CaseClient extends PushNotificationInterface {
   CaseClientCallbacks a();

   Async<List<CaseListRecord>> a(CaseListRequest var1);

   Async<CommentPost> a(CommentPostRequest var1);

   Async<CompleteCaseFeed> a(CompleteCaseFeedRequest var1);

   Async<CaseLayoutData> a(CreateCaseQuickActionRequest var1);

   Async<CreateCaseRecordResult> a(CreateCaseRecordRequest var1);

   Async<DefaultValues> a(DefaultValuesRequest var1);

   Async<ListViewDescribe> a(ListViewDescribeRequest var1);

   Async<String> a(ListViewRequest var1);

   Async<Void> a(SetCaseHiddenRequest var1);

   Async<Void> a(SetCaseLastReadDateRequest var1);

   Async<String> b(ListViewRequest var1);
}
