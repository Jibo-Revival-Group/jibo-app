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

public interface LocalRepository {
   Async<Map<String, Date>> a();

   Async<CaseDetailRecord> a(CaseDetailRequest var1);

   Async<Void> a(CaseDetailRequest var1, CaseDetailRecord var2);

   Async<CaseFeed> a(CaseFeedRequest var1);

   Async<Void> a(CaseFeedRequest var1, CaseFeed var2);

   Async<List<CaseListRecord>> a(CaseListRequest var1);

   Async<Void> a(CaseListRequest var1, List<CaseListRecord> var2);

   Async<Void> a(CommunitiesListRequest var1, List<Community> var2);

   Async<CaseLayoutData> a(CreateCaseQuickActionRequest var1);

   Async<Void> a(CreateCaseQuickActionRequest var1, CaseLayoutData var2);

   Async<DefaultValues> a(DefaultValuesRequest var1);

   Async<Void> a(DefaultValuesRequest var1, DefaultValues var2);

   Async<ListViewDescribe> a(ListViewDescribeRequest var1);

   Async<Void> a(ListViewDescribeRequest var1, ListViewDescribe var2);

   Async<String> a(ListViewRequest var1);

   Async<Void> a(ListViewRequest var1, String var2);

   Async<Void> a(String var1, Date var2);

   Async<Void> a(String var1, boolean var2);

   Async<Map<String, Boolean>> b();

   Async<String> b(ListViewRequest var1);

   Async<Void> b(ListViewRequest var1, String var2);

   Async<List<Community>> c();
}
