package com.salesforce.androidsdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.ui.SalesforceR;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class LoginServerManager {
   private Context a;
   private LoginServerManager.LoginServer b;
   private SharedPreferences c;
   private SharedPreferences d;

   public LoginServerManager(Context var1) {
      this.a = var1;
      this.c = var1.getSharedPreferences("server_url_file", 0);
      this.d = var1.getSharedPreferences("runtime_prefs_file", 0);
      this.h();
      this.b = this.a();
   }

   private List<LoginServerManager.LoginServer> a(SharedPreferences var1) {
      ArrayList var5 = null;
      int var3 = var1.getInt("number_of_entries", 0);
      ArrayList var8;
      if (var3 == 0) {
         var8 = var5;
      } else {
         var5 = new ArrayList();

         for (int var2 = 0; var2 < var3; var2++) {
            String var7 = var1.getString(String.format("server_name_%d", var2), null);
            String var6 = var1.getString(String.format("server_url_%d", var2), null);
            boolean var4 = var1.getBoolean(String.format("is_custom_%d", var2), false);
            if (var7 != null && var6 != null) {
               var5.add(new LoginServerManager.LoginServer(var7, var6, var4));
            }
         }

         if (var5.size() > 0) {
            var8 = var5;
         } else {
            var8 = null;
         }
      }

      return var8;
   }

   private void a(String var1, String var2, boolean var3, SharedPreferences var4) {
      if (var1 != null && var2 != null) {
         int var5 = var4.getInt("number_of_entries", 0);
         Editor var6 = var4.edit();
         var6.putString(String.format("server_name_%d", var5), var1);
         var6.putString(String.format("server_url_%d", var5), var2);
         var6.putBoolean(String.format("is_custom_%d", var5), var3);
         var6.putInt("number_of_entries", var5 + 1);
         var6.commit();
      }
   }

   private List<LoginServerManager.LoginServer> f() {
      SalesforceR var1 = SalesforceSDKManager.a().e();
      ArrayList var2 = new ArrayList();
      var2.add(new LoginServerManager.LoginServer(this.a.getString(var1.Y()), "https://login.salesforce.com", false));
      var2.add(new LoginServerManager.LoginServer(this.a.getString(var1.Z()), "https://test.salesforce.com", false));
      return var2;
   }

   private List<LoginServerManager.LoginServer> g() {
      int var1 = this.a.getResources().getIdentifier("servers", "xml", this.a.getPackageName());
      ArrayList var3;
      if (var1 != 0) {
         ArrayList var4 = new ArrayList();
         XmlResourceParser var5 = this.a.getResources().getXml(var1);
         var1 = -1;

         while (true) {
            var3 = var4;
            if (var1 == 1) {
               break;
            }

            if (var1 == 2 && var5.getName().equals("server")) {
               var4.add(new LoginServerManager.LoginServer(var5.getAttributeValue(null, "name"), var5.getAttributeValue(null, "url"), false));
            }

            int var2;
            try {
               var2 = var5.next();
            } catch (XmlPullParserException var6) {
               SalesforceSDKLogger.b("LoginServerManager", "Exception thrown while parsing XML", var6);
               continue;
            } catch (IOException var7) {
               SalesforceSDKLogger.b("LoginServerManager", "Exception thrown while parsing XML", var7);
               continue;
            }

            var1 = var2;
         }
      } else {
         var3 = null;
      }

      return var3;
   }

   private void h() {
      Map var3 = this.c.getAll();
      if (var3 == null || var3.isEmpty()) {
         List var6 = this.g();
         if (var6 == null || var6.isEmpty()) {
            var6 = this.f();
         }

         int var2 = var6.size();
         Editor var4 = this.c.edit();

         for (int var1 = 0; var1 < var2; var1++) {
            LoginServerManager.LoginServer var5 = (LoginServerManager.LoginServer)var6.get(var1);
            var4.putString(String.format("server_name_%d", var1), var5.a);
            var4.putString(String.format("server_url_%d", var1), var5.b);
            var4.putBoolean(String.format("is_custom_%d", var1), var5.c);
            if (var1 == 0) {
               this.a(var5);
            }
         }

         var4.putInt("number_of_entries", var2);
         var4.commit();
      }
   }

   public LoginServerManager.LoginServer a() {
      SharedPreferences var3 = this.a.getSharedPreferences("server_selection_file", 0);
      String var4 = var3.getString("server_name_%d", null);
      String var2 = var3.getString("server_url_%d", null);
      boolean var1 = var3.getBoolean("is_custom_%d", false);
      if (var4 != null && var2 != null) {
         this.b = new LoginServerManager.LoginServer(var4, var2, var1);
      } else {
         List var5 = this.c();
         if (var5 != null) {
            LoginServerManager.LoginServer var6 = (LoginServerManager.LoginServer)var5.get(0);
            if (var6 != null) {
               this.b = var6;
            }
         }

         if (this.b == null) {
            this.b = new LoginServerManager.LoginServer("Production", "https://login.salesforce.com", false);
         }

         this.a(this.b);
      }

      return this.b;
   }

   public void a(LoginServerManager.LoginServer var1) {
      if (var1 != null) {
         Editor var2 = this.a.getSharedPreferences("server_selection_file", 0).edit();
         var2.clear();
         var2.putString("server_name_%d", var1.a);
         var2.putString("server_url_%d", var1.b);
         var2.putBoolean("is_custom_%d", var1.c);
         var2.commit();
         this.b = var1;
      }
   }

   public void a(String var1, String var2) {
      if (this.d() == null) {
         this.a(var1, var2, true, this.c);
      } else {
         this.a(var1, var2, true, this.d);
      }

      this.a(new LoginServerManager.LoginServer(var1, var2, true));
   }

   public void b() {
      Editor var1 = this.c.edit();
      var1.clear();
      var1.commit();
      var1 = this.d.edit();
      var1.clear();
      var1.commit();
      var1 = this.a.getSharedPreferences("server_selection_file", 0).edit();
      var1.clear();
      var1.commit();
      this.h();
   }

   public List<LoginServerManager.LoginServer> c() {
      List var1;
      if (this.d() == null) {
         var1 = this.e();
      } else {
         var1 = this.a(this.d);
      }

      return var1;
   }

   public List<LoginServerManager.LoginServer> d() {
      RuntimeConfig var6 = RuntimeConfig.a(this.a);

      String[] var3;
      try {
         var3 = var6.b(RuntimeConfig.ConfigKey.AppServiceHosts);
      } catch (Exception var10) {
         SalesforceSDKLogger.b("LoginServerManager", "Exception thrown while attempting to read array, attempting to read string value instead", var10);
         var3 = null;
      }

      String[] var2 = var3;
      if (var3 == null) {
         String var4 = var6.a(RuntimeConfig.ConfigKey.AppServiceHosts);
         var2 = var3;
         if (!TextUtils.isEmpty(var4)) {
            var2 = new String[]{var4};
         }
      }

      ArrayList var5 = new ArrayList();
      if (var2 != null) {
         String[] var14;
         try {
            var14 = var6.b(RuntimeConfig.ConfigKey.AppServiceHostLabels);
         } catch (Exception var9) {
            SalesforceSDKLogger.b("LoginServerManager", "Exception thrown while attempting to read array, attempting to read string value instead", var9);
            var14 = null;
         }

         var3 = var14;
         if (var14 == null) {
            String var16 = var6.a(RuntimeConfig.ConfigKey.AppServiceHostLabels);
            var3 = var14;
            if (!TextUtils.isEmpty(var16)) {
               var3 = new String[]{var16};
            }
         }

         label57: {
            if (var3 != null) {
               var14 = var3;
               if (var3.length == var2.length) {
                  break label57;
               }
            }

            SalesforceSDKLogger.b(
               "LoginServerManager", "No login servers labels provided or wrong number of login servers labels provided - Using URLs for the labels"
            );
            var14 = var2;
         }

         List var13 = this.a(this.d);

         for (int var1 = 0; var1 < var2.length; var1++) {
            String var7 = var14[var1];
            String var8 = var2[var1];
            LoginServerManager.LoginServer var17 = new LoginServerManager.LoginServer(var7, var8, false);
            if (var13 == null || !var13.contains(var17)) {
               this.a(var7, var8, false, this.d);
            }

            var5.add(var17);
         }
      }

      ArrayList var11;
      if (var5.size() > 0) {
         var11 = var5;
      } else {
         var11 = null;
      }

      return var11;
   }

   public List<LoginServerManager.LoginServer> e() {
      return this.a(this.c);
   }

   public static class LoginServer {
      public final String a;
      public final String b;
      public final boolean c;

      public LoginServer(String var1, String var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 != null) {
            if (var1.getClass() != this.getClass()) {
               var2 = var3;
            } else {
               var1 = var1;
               var2 = var3;
               if (this.a.trim().equals(var1.a.trim())) {
                  var2 = var3;
                  if (this.b.trim().equals(var1.b.trim())) {
                     var2 = var3;
                     if (this.c == var1.c) {
                        var2 = true;
                     }
                  }
               }
            }
         }

         return var2;
      }

      @Override
      public String toString() {
         return "Name: " + this.a + ", URL: " + this.b + ", Custom URL: " + this.c;
      }
   }
}
