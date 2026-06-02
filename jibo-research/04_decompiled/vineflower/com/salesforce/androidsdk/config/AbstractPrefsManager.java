package com.salesforce.androidsdk.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class AbstractPrefsManager {
   private SharedPreferences b(UserAccount var1) {
      String var2 = this.a();
      if (var1 != null) {
         StringBuilder var4 = new StringBuilder().append(this.a());
         String var3;
         if (this.b()) {
            var3 = var1.t();
         } else {
            var3 = var1.u();
         }

         var2 = var4.append(var3).toString();
      }

      return SalesforceSDKManager.a().k().getSharedPreferences(var2, 0);
   }

   protected abstract String a();

   public String a(String var1, UserAccount var2) {
      Map var4 = this.b(var2).getAll();
      if (var4 != null) {
         var1 = (String)var4.get(var1);
      } else {
         var1 = null;
      }

      return var1;
   }

   public Map<String, String> a(UserAccount var1) {
      return this.b(var1).getAll();
   }

   public void a(Map<String, String> var1, UserAccount var2) {
      this.a(new JSONObject(var1), var2);
   }

   public void a(JSONObject var1, UserAccount var2) {
      if (var1 != null) {
         Editor var4 = this.b(var2).edit();
         Iterator var5 = var1.keys();

         while (var5.hasNext()) {
            String var3 = (String)var5.next();
            var4.putString(var3, var1.optString(var3));
         }

         var4.commit();
      }
   }

   protected abstract boolean b();

   public void c() {
      File var5 = new File(SalesforceSDKManager.a().k().getApplicationInfo().dataDir + "/shared_prefs");
      FilenameFilter var3 = new FilenameFilter(this) {
         final AbstractPrefsManager a;

         {
            this.a = var1;
         }

         @Override
         public boolean accept(File var1, String var2) {
            boolean var3x;
            if (var2 != null && var2.startsWith(this.a.a())) {
               var3x = true;
            } else {
               var3x = false;
            }

            return var3x;
         }
      };

      for (File var6 : var5.listFiles()) {
         if (var6 != null && var3.accept(var5, var6.getName())) {
            var6.delete();
         }
      }
   }
}
