package com.salesforce.android.cases.core.internal.local;

import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import org.json.JSONArray;
import org.json.JSONException;

public class WriteJob implements Job<Void> {
   private static final ServiceLogger a = ServiceLogging.a(WriteJob.class);
   private SmartStore b;
   private String c;
   private JSONArray d;
   private final UserAccount e;

   private WriteJob(SmartStore var1, String var2, JSONArray var3, UserAccount var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   public static WriteJob a(SmartStore var0, String var1, JSONArray var2, UserAccount var3) {
      return new WriteJob(var0, var1, var2, var3);
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public void a(ResultReceiver<Void> var1) {
      try {
         if (!DbUtils.a(this.e)) {
            IllegalStateException var3 = new IllegalStateException("Cannot write to db, not authenticated");
            var1.b(var3);
            var1.b();
            return;
         }
      } catch (JSONException var6) {
         var1.b(var6);
         var1.b();
         return;
      }

      try {
         this.b.b(this.c);
         a.b("Starting Write to {}", this.c);
      } catch (JSONException var5) {
         var1.b(var5);
         var1.b();
         return;
      }

      int var2 = 0;

      while (true) {
         try {
            if (var2 >= this.d.length()) {
               break;
            }

            this.b.a(this.c, this.d.getJSONObject(var2));
         } catch (JSONException var4) {
            var1.b(var4);
            var1.b();
            return;
         }

         var2++;
      }

      a.b("Write to {} complete", this.c);
      var1.b();
   }
}
