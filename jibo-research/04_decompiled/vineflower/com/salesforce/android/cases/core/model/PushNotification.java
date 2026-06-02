package com.salesforce.android.cases.core.model;

import android.os.Bundle;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.Iterator;
import org.json.JSONObject;

public class PushNotification {
   private static final ServiceLogger a = ServiceLogging.a(PushNotification.class);
   private String b;
   private String c;

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public PushNotification(Bundle var1) {
      try {
         this.b = this.a(var1, "caseId");
         var5 = var1.getString("aps");
      } catch (Exception var4) {
         a.d("Unable to parse the push notification bundle", var4);
         return;
      }

      if (var5 != null) {
         try {
            JSONObject var2 = new JSONObject(var5);
            this.c = var2.getString("alert");
         } catch (Exception var3) {
            a.d("Unable to parse the push notification bundle", var3);
         }
      }
   }

   private String a(Bundle var1, String var2) {
      Iterator var3 = var1.keySet().iterator();

      while (true) {
         if (var3.hasNext()) {
            String var4 = (String)var3.next();
            if (!var2.equalsIgnoreCase(var4)) {
               continue;
            }

            var5 = var1.getString(var4);
            break;
         }

         var5 = null;
         break;
      }

      return var5;
   }

   public String a() {
      return this.b;
   }

   public String b() {
      return this.c;
   }
}
