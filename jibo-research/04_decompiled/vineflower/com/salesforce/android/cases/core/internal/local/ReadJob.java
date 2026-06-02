package com.salesforce.android.cases.core.internal.local;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import org.json.JSONArray;
import org.json.JSONException;

public class ReadJob implements Job<JSONArray> {
   private static final ServiceLogger a = ServiceLogging.a(ReadJob.class);
   private SmartStore b;
   private QuerySpec c;
   private int d;
   private UserAccount e;

   private ReadJob(SmartStore var1, QuerySpec var2, int var3, UserAccount var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   public static ReadJob a(SmartStore var0, QuerySpec var1, int var2, UserAccount var3) {
      return new ReadJob(var0, var1, var2, var3);
   }

   @Override
   public void a(ResultReceiver<JSONArray> var1) {
      try {
         if (!DbUtils.a(this.e)) {
            IllegalStateException var2 = new IllegalStateException("Cannot read from db, not authenticated");
            var1.b(var2);
            var1.b();
            return;
         }

         var1.b(this.b.a(this.c, this.d));
      } catch (JSONException var3) {
         var1.b(var3);
         var1.b();
         return;
      }

      var1.b();
   }
}
