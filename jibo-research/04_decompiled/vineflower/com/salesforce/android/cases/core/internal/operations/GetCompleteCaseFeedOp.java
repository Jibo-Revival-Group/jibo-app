package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.CreateCaseQuickActionHandler;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.DefaultValuesHandler;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.GetCaseDetailHandler;
import com.salesforce.android.cases.core.internal.operations.resulthandlers.GetCommunitiesResultsHandler;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CompleteCaseFeed;
import com.salesforce.android.cases.core.requests.CaseDetailRequest;
import com.salesforce.android.cases.core.requests.CommunitiesListRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.cases.core.requests.CreateCaseQuickActionRequest;
import com.salesforce.android.cases.core.requests.DefaultValuesRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.androidsdk.accounts.UserAccount;

public class GetCompleteCaseFeedOp extends MultipartOperation<CompleteCaseFeed> {
   private final CompleteCaseFeedRequest a;
   private final OperationFactory b;
   private final CompleteCaseFeedModel c;
   private final RemoteRepository d;
   private final LocalRepository e;
   private final UserAccount f;

   public GetCompleteCaseFeedOp(CompleteCaseFeedRequest var1, LocalRepository var2, RemoteRepository var3, OperationFactory var4, UserAccount var5) {
      this.a = var1;
      this.b = var4;
      this.c = new CompleteCaseFeedModel();
      this.e = var2;
      this.d = var3;
      this.f = var5;
   }

   @Override
   public void a() {
      boolean var2 = this.a.l();
      boolean var3 = this.a.m();
      boolean var1 = this.a.n();
      Async var4 = this.b.a(new CommunitiesListRequest.CommunitiesListRequestBuilder().c(var2).d(var3).e(var1).b(), this.e, this.d).e().f();
      var4.b(new GetCommunitiesResultsHandler(this, this.a, this.c, this.b, this.e, this.d));
      this.c(var4);
      var4 = this.b.a(new CaseDetailRequest.CaseDetailRequestBuilder(this.a.a()).c(var2).d(var3).e(var1).b(), this.e, this.d).e().f();
      var4.b(new GetCaseDetailHandler(this, this.c));
      this.c(var4);
      var4 = this.b.a(new DefaultValuesRequest.DefaultValuesRequestBuilder(this.a.b()).c(var2).d(var3).e(var1).b(), this.e, this.d).e().f();
      var4.b(new DefaultValuesHandler(this, this.c));
      this.c(var4);
      var4 = this.b
         .a(new CreateCaseQuickActionRequest.CreateCaseQuickActionRequestBuilder(this.a.b()).c(var2).d(var3).e(var1).b(), this.e, this.d, this.f)
         .e()
         .f();
      var4.b(new CreateCaseQuickActionHandler(this, this.c));
      this.c(var4);
   }

   @Override
   boolean b() {
      return this.c.a();
   }

   CompleteCaseFeed c() {
      return this.c.b();
   }
}
