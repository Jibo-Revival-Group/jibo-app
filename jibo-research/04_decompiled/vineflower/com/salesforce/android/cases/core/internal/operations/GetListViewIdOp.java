package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.ListView;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.Iterator;
import java.util.List;

public class GetListViewIdOp extends CaseFetchSaveOperation<ListViewRequest, String> {
   public GetListViewIdOp(ListViewRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<String> a(LocalRepository var1, ListViewRequest var2) {
      return var1.a(var2);
   }

   protected Async<Void> a(LocalRepository var1, ListViewRequest var2, String var3) {
      return var1.a(var2, var3);
   }

   protected Async<String> a(RemoteRepository var1, ListViewRequest var2) {
      return var1.b().a(new Function<List<ListView>, String>(this, var2) {
         final ListViewRequest a;
         final GetListViewIdOp b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public String a(List<ListView> var1) {
            Iterator var3 = var1.iterator();

            while (true) {
               if (var3.hasNext()) {
                  ListView var2x = (ListView)var3.next();
                  if (!var2x.a().equals(this.a.a())) {
                     continue;
                  }

                  var4 = var2x.b();
                  break;
               }

               var4 = "";
               break;
            }

            return var4;
         }
      });
   }

   @Override
   protected String b() {
      return "Cannot Get List View Id, Offline";
   }
}
