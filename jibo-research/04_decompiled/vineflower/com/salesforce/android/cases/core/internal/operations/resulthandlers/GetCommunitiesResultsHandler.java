package com.salesforce.android.cases.core.internal.operations.resulthandlers;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.model.CompleteCaseFeedModel;
import com.salesforce.android.cases.core.internal.operations.MultipartOperationObserver;
import com.salesforce.android.cases.core.internal.operations.OperationFactory;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.Community;
import com.salesforce.android.cases.core.requests.CaseFeedRequest;
import com.salesforce.android.cases.core.requests.CompleteCaseFeedRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.Iterator;
import java.util.List;

public class GetCommunitiesResultsHandler extends AbstractMultipartRequestHandler<List<Community>> {
   private Async<CaseFeed> b;
   private final CompleteCaseFeedModel c;
   private final OperationFactory d;
   private final LocalRepository e;
   private final RemoteRepository f;
   private final CompleteCaseFeedRequest g;

   public GetCommunitiesResultsHandler(
      MultipartOperationObserver var1,
      CompleteCaseFeedRequest var2,
      CompleteCaseFeedModel var3,
      OperationFactory var4,
      LocalRepository var5,
      RemoteRepository var6
   ) {
      super(var1);
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var2;
   }

   private String a(List<Community> var1, String var2) {
      Iterator var3 = var1.iterator();

      while (true) {
         if (var3.hasNext()) {
            Community var5 = (Community)var3.next();
            if (!var5.b().equals(var2)) {
               continue;
            }

            var4 = var5.a();
            break;
         }

         var4 = null;
         break;
      }

      return var4;
   }

   private boolean a(String var1) {
      boolean var2;
      if (var1 != null && !var1.equals(this.c.c())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private void b(String var1) {
      Async var2 = this.d.a(new CaseFeedRequest.CaseFeedRequestBuilder(var1, this.g.a()).c(this.g.l()).d(this.g.m()).e(this.g.n()).b(), this.e, this.f).e().f();
      var2.b(new GetCaseFeedHandler(this.a, this.c));
      this.a.c(var2);
      if (this.b != null) {
         this.a.b(this.b);
      }

      this.b = var2;
   }

   public void a(Async<?> var1, List<Community> var2) {
      String var3 = this.a(var2, this.g.c());
      if (this.a(var3)) {
         this.c.a(var3);
         this.a.g();
         this.b(var3);
      }
   }
}
