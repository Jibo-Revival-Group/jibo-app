package com.salesforce.android.cases.core.internal.local;

import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.app.SmartStoreSDKManager;
import com.salesforce.androidsdk.smartstore.store.IndexSpec;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyValueSmartstore {
   private static final IndexSpec[] a = new IndexSpec[]{new IndexSpec("key", SmartStore.Type.string)};
   private final ServiceLogger b = ServiceLogging.a(KeyValueSmartstore.class);
   private final String c;
   private SmartStore d;

   public KeyValueSmartstore(String var1, UserAccount var2) {
      this.c = var1;
      if (DbUtils.a(var2)) {
         this.d = SmartStoreSDKManager.H().b(var2);
         this.d.a(this.c, a);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public String a(String var1) {
      JSONArray var6;
      try {
         QuerySpec var2 = QuerySpec.a(this.c, "key", var1, "key", QuerySpec.Order.descending, 1);
         var6 = this.d.a(var2, 0);
      } catch (JSONException var4) {
         this.b.e("JSONException: Error reading mapped value for {} due to {}.", var1, var4.getMessage());
         return null;
      }

      if (var6 != null) {
         try {
            if (var6.length() > 0) {
               return ((JSONObject)var6.get(0)).getString("value");
            }
         } catch (JSONException var3) {
            this.b.e("JSONException: Error reading mapped value for {} due to {}.", var1, var3.getMessage());
         }
      }

      return null;
   }

   public Map<String, String> a() {
      HashMap var2;
      JSONException var3;
      label31: {
         JSONArray var4;
         try {
            QuerySpec var7 = QuerySpec.a(this.c, "key", QuerySpec.Order.descending, Integer.MAX_VALUE);
            var4 = this.d.a(var7, 0);
            var2 = new HashMap(var4.length() + 1, 1.0F);
         } catch (JSONException var6) {
            var3 = var6;
            var2 = null;
            break label31;
         }

         int var1 = 0;

         while (true) {
            HashMap var8 = var2;

            try {
               if (var1 >= var4.length()) {
                  return var8;
               }

               var2.put(var4.getJSONObject(var1).getString("key"), var4.getJSONObject(var1).getString("value"));
            } catch (JSONException var5) {
               var3 = var5;
               break;
            }

            var1++;
         }
      }

      this.b.e("JSONException: Error reading all mapped values due to {}.", var3.getMessage());
      return var2;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public void a(String var1, String var2) {
      JSONObject var4;
      JSONArray var5;
      try {
         var4 = new JSONObject();
         var5 = this.d.a(this.c, this.d.a(this.c, "key", var1));
      } catch (JSONException var8) {
         this.b.e("JSONException writing to {}. {} ", this.c, var8.getMessage());
         return;
      }

      JSONObject var3 = var4;
      if (var5 != null) {
         var3 = var4;

         try {
            if (var5.length() != 0) {
               var3 = var5.getJSONObject(0);
            }
         } catch (JSONException var7) {
            this.b.e("JSONException writing to {}. {} ", this.c, var7.getMessage());
            return;
         }
      }

      try {
         var3.put("key", var1);
         var3.put("value", var2);
         this.d.a(this.c, var3);
      } catch (JSONException var6) {
         this.b.e("JSONException writing to {}. {} ", this.c, var6.getMessage());
      }
   }
}
