package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.model.CreateCaseRecordResult;
import com.salesforce.android.cases.core.model.DefaultValues;
import com.salesforce.android.cases.core.model.ListViewDescribe;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.cases.core.requests.CommentPostRequest;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.CreateCaseRecordRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.cases.core.requests.ListViewDescribeRequest;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.cases.core.requests.SetCaseHiddenRequest;
import com.salesforce.android.cases.core.requests.SetCaseLastReadDateRequest;
import com.salesforce.android.service.common.fetchsave.internal.operations.Operation;
import com.salesforce.androidsdk.accounts.UserAccount;
import java.util.List;

public class OperationFactory {
   public Operation<CaseDetailRecord> a(CaseDetailRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetCaseDetailOp(var1, var2, var3);
   }

   public Operation<CaseFeed> a(CaseFeedRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetCaseFeedOp(var1, var2, var3);
   }

   public Operation<List<CaseListRecord>> a(CaseListRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetCaseListOp(var1, var2, var3);
   }

   public Operation<CommentPost> a(CommentPostRequest var1, RemoteRepository var2) {
      return new PostCommentOp(var1, var2);
   }

   public Operation<List<Community>> a(CommunitiesListRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetCommunitiesListOp(var1, var2, var3);
   }

   public Operation<CompleteCaseFeed> a(CompleteCaseFeedRequest var1, LocalRepository var2, RemoteRepository var3, UserAccount var4) {
      return new GetCompleteCaseFeedOp(var1, var2, var3, this, var4);
   }

   public Operation<CaseLayoutData> a(CreateCaseQuickActionRequest var1, LocalRepository var2, RemoteRepository var3, UserAccount var4) {
      return new GetCreateCaseLayoutDataOp(var1, var2, var3, var4);
   }

   public Operation<CreateCaseRecordResult> a(CreateCaseRecordRequest var1, RemoteRepository var2) {
      return new CreateCaseRecordOp(var1, var2);
   }

   public Operation<DefaultValues> a(DefaultValuesRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetDefaultValuesOp(var1, var2, var3);
   }

   public Operation<ListViewDescribe> a(ListViewDescribeRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetListViewDescribeOp(var1, var2, var3);
   }

   public Operation<String> a(ListViewRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetListViewIdOp(var1, var2, var3);
   }

   public Operation<Void> a(SetCaseHiddenRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new SetCaseHiddenOp(var1, var2, var3);
   }

   public Operation<Void> a(SetCaseLastReadDateRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new SetCaseLastReadDateOp(var1, var2, var3);
   }

   public Operation<String> b(ListViewRequest var1, LocalRepository var2, RemoteRepository var3) {
      return new GetListViewLabelOp(var1, var2, var3);
   }
}
