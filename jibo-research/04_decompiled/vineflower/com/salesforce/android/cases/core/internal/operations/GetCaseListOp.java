package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.http.util.CaseConstants;
import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseListFeedRecord;
import com.salesforce.android.cases.core.model.CaseListRecord;
import com.salesforce.android.cases.core.requests.CaseListRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.functional.Function;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GetCaseListOp extends CaseFetchSaveOperation<CaseListRequest, List<CaseListRecord>> {
   GetCaseListOp(CaseListRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<List<CaseListRecord>> a(LocalRepository var1, CaseListRequest var2) {
      return var1.a(var2).b(new GetCaseListOp.SetUnreadStatusFunction(this)).b(new GetCaseListOp.SetHiddenStatusFunction(this));
   }

   protected Async<Void> a(LocalRepository var1, CaseListRequest var2, List<CaseListRecord> var3) {
      return var1.a(var2, var3);
   }

   protected Async<List<CaseListRecord>> a(RemoteRepository var1, CaseListRequest var2) {
      return var1.a(var2).b(new GetCaseListOp.SetUnreadStatusFunction(this)).b(new GetCaseListOp.SetHiddenStatusFunction(this));
   }

   @Override
   protected String b() {
      return "Cannot Get Case List, Offline";
   }

   private class SetHiddenStatusFunction implements Function<List<CaseListRecord>, Async<List<CaseListRecord>>> {
      final GetCaseListOp a;

      private SetHiddenStatusFunction(GetCaseListOp var1) {
         this.a = var1;
      }

      private Async<List<CaseListRecord>> b(List<CaseListRecord> var1) {
         Async var2;
         if (this.a.a == null) {
            var2 = BasicAsync.h();
         } else {
            var2 = this.a.a.b().b(new Function<Map<String, Boolean>, Async<List<CaseListRecord>>>(this, var1) {
               final List a;
               final GetCaseListOp.SetHiddenStatusFunction b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public Async<List<CaseListRecord>> a(Map<String, Boolean> var1) {
                  for (CaseListRecord var4 : this.a) {
                     String var2x = var4.b();
                     if (var1.containsKey(var2x)) {
                        if ((Boolean)var1.get(var2x)) {
                           if (var4.e()) {
                              if (StringUtils.b(var4.b())) {
                                 this.b.a.a.a(var4.b(), false);
                              }
                           } else {
                              var4.b(true);
                           }
                        } else {
                           var4.b(false);
                        }
                     }
                  }

                  return BasicAsync.c(this.a);
               }
            });
         }

         return var2;
      }

      public Async<List<CaseListRecord>> a(List<CaseListRecord> var1) {
         return this.b(var1);
      }
   }

   private class SetUnreadStatusFunction implements Function<List<CaseListRecord>, Async<List<CaseListRecord>>> {
      final GetCaseListOp a;

      private SetUnreadStatusFunction(GetCaseListOp var1) {
         this.a = var1;
      }

      private boolean a(CaseListRecord var1, Date var2, List<UserAccount> var3) {
         CaseListFeedRecord var6 = var1.g();
         if (var6 != null) {
            Date var5 = var6.c();
            if (var5 != null) {
               if (!var5.after(var2)) {
                  return false;
               }

               String var7 = var6.b();
               boolean var4;
               if (var7 != null && !var7.isEmpty()) {
                  Iterator var8 = var3.iterator();

                  while (var8.hasNext()) {
                     if (((UserAccount)var8.next()).g().equals(var7)) {
                        return false;
                     }
                  }

                  var4 = true;
               } else {
                  var4 = false;
               }

               return var4;
            }
         }

         return false;
      }

      private Async<List<CaseListRecord>> b(List<CaseListRecord> var1) {
         Async var2;
         if (this.a.a == null) {
            var2 = BasicAsync.h();
         } else {
            var2 = this.a.a.a().b(new Function<Map<String, Date>, Async<List<CaseListRecord>>>(this, var1) {
               final List a;
               final GetCaseListOp.SetUnreadStatusFunction b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public Async<List<CaseListRecord>> a(Map<String, Date> var1) {
                  List var5 = SalesforceSDKManager.a().o().d();

                  for (CaseListRecord var3 : this.a) {
                     String var2x = var3.b();
                     if (var1.containsKey(var2x)) {
                        var3.a(this.b.a(var3, (Date)var1.get(var2x), var5));
                     } else {
                        var3.a(this.b.a(var3, CaseConstants.a, var5));
                     }
                  }

                  return BasicAsync.c(this.a);
               }
            });
         }

         return var2;
      }

      public Async<List<CaseListRecord>> a(List<CaseListRecord> var1) {
         return this.b(var1);
      }
   }
}
