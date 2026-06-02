package com.salesforce.android.cases.core.internal.operations;

import com.salesforce.android.cases.core.internal.local.LocalRepository;
import com.salesforce.android.cases.core.internal.remote.RemoteRepository;
import com.salesforce.android.cases.core.model.ListView;
import com.salesforce.android.cases.core.requests.ListViewRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.Iterator;
import java.util.List;

public class GetListViewLabelOp extends CaseFetchSaveOperation<ListViewRequest, String> {
   public GetListViewLabelOp(ListViewRequest var1, LocalRepository var2, RemoteRepository var3) {
      super(var1, var2, var3);
   }

   protected Async<String> a(LocalRepository var1, ListViewRequest var2) {
      return var1.b(var2);
   }

   protected Async<Void> a(LocalRepository var1, ListViewRequest var2, String var3) {
      return var1.b(var2, var3);
   }

   protected Async<String> a(RemoteRepository var1, ListViewRequest var2) {
      return var1.b().a(new Function<List<ListView>, String>(this, var2) {
         final ListViewRequest a;
         final GetListViewLabelOp b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public String a(List<ListView> var1) {
            Iterator var2x = var1.iterator();

            while (true) {
               if (var2x.hasNext()) {
                  ListView var4 = (ListView)var2x.next();
                  if (!var4.a().equals(this.a.a())) {
                     continue;
                  }

                  var3 = var4.c();
                  break;
               }

               var3 = "";
               break;
            }

            return var3;
         }
      });
   }

   @Override
   protected String b() {
      return "Cannot Get List View Label, Offline";
   }
}
