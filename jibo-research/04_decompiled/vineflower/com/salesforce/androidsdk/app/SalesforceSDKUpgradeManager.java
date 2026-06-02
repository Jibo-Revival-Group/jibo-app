package com.salesforce.androidsdk.app;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.SharedPreferences.Editor;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.security.PasscodeManager;
import java.io.File;
import java.util.Map;

public class SalesforceSDKUpgradeManager {
   private static SalesforceSDKUpgradeManager a = null;

   public static SalesforceSDKUpgradeManager a() {
      synchronized (SalesforceSDKUpgradeManager.class) {
         if (a == null) {
            SalesforceSDKUpgradeManager var0 = new SalesforceSDKUpgradeManager();
            a = var0;
         }

         return a;
      }
   }

   protected String a(String var1) {
      return SalesforceSDKManager.a().k().getSharedPreferences("version_info", 0).getString(var1, "");
   }

   protected void a(String var1, String var2) {
      synchronized (this) {
         SalesforceSDKManager.a().k().getSharedPreferences("version_info", 0).edit().putString(var1, var2).commit();
      }
   }

   public void b() {
      this.c();
   }

   protected void c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKUpgradeManager.d ()Ljava/lang/String;
      // 06: astore 3
      // 07: aload 3
      // 08: ldc "5.3.0"
      // 0a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d: istore 1
      // 0e: iload 1
      // 0f: ifeq 15
      // 12: aload 0
      // 13: monitorexit
      // 14: return
      // 15: aload 0
      // 16: ldc "acc_mgr_version"
      // 18: ldc "5.3.0"
      // 1a: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKUpgradeManager.a (Ljava/lang/String;Ljava/lang/String;)V
      // 1d: aload 3
      // 1e: astore 2
      // 1f: aload 3
      // 20: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 23: ifeq 2b
      // 26: aload 0
      // 27: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKUpgradeManager.d ()Ljava/lang/String;
      // 2a: astore 2
      // 2b: aload 2
      // 2c: bipush 0
      // 2d: bipush 3
      // 2e: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 31: invokestatic java/lang/Double.parseDouble (Ljava/lang/String;)D
      // 34: ldc2_w 2.2
      // 37: dcmpg
      // 38: ifge 12
      // 3b: aload 0
      // 3c: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKUpgradeManager.e ()V
      // 3f: goto 12
      // 42: astore 2
      // 43: ldc "SalesforceSDKUpgradeManager"
      // 45: ldc "Failed to parse installed version"
      // 47: aload 2
      // 48: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 4b: goto 12
      // 4e: astore 2
      // 4f: aload 0
      // 50: monitorexit
      // 51: aload 2
      // 52: athrow
      // try (2 -> 9): 43 null
      // try (14 -> 18): 43 null
      // try (20 -> 26): 43 null
      // try (26 -> 36): 37 java/lang/NumberFormatException
      // try (26 -> 36): 43 null
      // try (38 -> 42): 43 null
   }

   public String d() {
      return this.a("acc_mgr_version");
   }

   protected void e() {
      AccountManager var4 = AccountManager.get(SalesforceSDKManager.a().k());
      Account[] var3 = var4.getAccountsByType(SalesforceSDKManager.a().B());
      if (var3 != null && var3.length > 0) {
         Account var6 = var3[0];
         String var5 = SalesforceSDKManager.e(var4.getUserData(var6, "orgId"), SalesforceSDKManager.a().t());
         String var10 = SalesforceSDKManager.e(var4.getUserData(var6, "userId"), SalesforceSDKManager.a().t());
         SalesforceSDKManager.a().o().a(var10, var5);
         var5 = SalesforceSDKManager.a().k().getApplicationInfo().dataDir + "/shared_prefs";
         File var11 = new File(var5, "gcm_prefs.xml");
         if (var11.exists()) {
            var11.renameTo(new File(var5, "gcm_prefs" + SalesforceSDKManager.a().o().a(var6).u() + ".xml"));
         }

         Map var12 = SalesforceSDKManager.a().p().a(null);
         SalesforceSDKManager.a().p().a(var12, SalesforceSDKManager.a().o().a(var6));
         Editor var7 = SalesforceSDKManager.a().k().getSharedPreferences("admin_prefs", 0).edit();
         var7.clear();
         var7.commit();
         PasscodeManager var8 = SalesforceSDKManager.a().n();
         UserAccountManager var13 = SalesforceSDKManager.a().o();
         int var1 = var8.g();
         int var2 = var8.h();
         var8.a(var13.b(), var1, var2);
      }

      Editor var9 = SalesforceSDKManager.a().k().getSharedPreferences("server_url_prefs", 0).edit();
      var9.clear();
      var9.commit();
   }
}
