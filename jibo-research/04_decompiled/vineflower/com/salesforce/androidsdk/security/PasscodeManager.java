package com.salesforce.androidsdk.security;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.app.UUIDManager;
import com.salesforce.androidsdk.util.EventsObservable;
import java.io.File;
import java.io.FilenameFilter;

public class PasscodeManager {
   boolean a;
   private String b;
   private PasscodeManager.HashConfig c;
   private PasscodeManager.HashConfig d;
   private Activity e;
   private Handler f;
   private long g;
   private int h;
   private int i = 4;
   private PasscodeManager.LockChecker j;

   public PasscodeManager(Context var1) {
      this(
         var1,
         new PasscodeManager.HashConfig(UUIDManager.a("vprefix"), UUIDManager.a("vsuffix"), UUIDManager.a("vkey")),
         new PasscodeManager.HashConfig(UUIDManager.a("eprefix"), UUIDManager.a("esuffix"), UUIDManager.a("ekey"))
      );
   }

   public PasscodeManager(Context var1, PasscodeManager.HashConfig var2, PasscodeManager.HashConfig var3) {
      this.g = this.k();
      this.c = var2;
      this.d = var3;
      this.e(var1);
      this.a = true;
      this.j = new PasscodeManager.LockChecker(this);
   }

   private String a(String var1, PasscodeManager.HashConfig var2) {
      return Encryptor.d(var2.a + var1 + var2.b, var2.c);
   }

   private void b(int var1) {
      Editor var2 = SalesforceSDKManager.a().k().getSharedPreferences("user", 0).edit();
      var2.putInt("failed_attempts", var1);
      var2.commit();
   }

   private String d(String var1) {
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.length();
      }

      String var3 = var1;
      if (var2 > 0) {
         var3 = var1;
         if (var1.endsWith("\n")) {
            var3 = var1.substring(0, var2 - 1);
         }
      }

      return var3;
   }

   private void d(Context var1) {
      if (var1 != null) {
         Editor var2 = var1.getSharedPreferences("mobile_policy", 0).edit();
         var2.putInt("access_timeout", this.h);
         var2.putInt("passcode_length", this.i);
         var2.commit();
      }
   }

   private void e(Context var1) {
      if (var1 != null) {
         SharedPreferences var2 = var1.getSharedPreferences("mobile_policy", 0);
         if (var2.contains("access_timeout") && var2.contains("passcode_length")) {
            this.h = var2.getInt("access_timeout", 0);
            this.i = var2.getInt("passcode_length", 4);
         } else {
            this.h = 0;
            this.i = 4;
            this.d(var1);
         }
      }
   }

   private void l() {
      this.g = this.k();
   }

   public void a(int var1) {
      if (this.h != var1) {
         if (this.h != 0 && (this.h <= 0 || var1 <= 0)) {
            this.h = var1;
            SalesforceSDKManager.a().b(this.b, null);
            this.a(SalesforceSDKManager.a().k());
         } else {
            this.h = var1;
            this.d(SalesforceSDKManager.a().k());
         }
      }
   }

   public void a(Activity var1) {
      this.a(false);
   }

   public void a(Context var1) {
      File var6 = new File(var1.getApplicationInfo().dataDir + "/shared_prefs");
      PasscodeManager.PasscodeFileFilter var7 = new PasscodeManager.PasscodeFileFilter();

      for (File var4 : var6.listFiles()) {
         if (var4 != null && var7.accept(var6, var4.getName())) {
            var4.delete();
         }
      }

      this.g = this.k();
      this.a = true;
      this.b = null;
      Editor var8 = var1.getSharedPreferences("user", 0).edit();
      var8.remove("passcode");
      var8.remove("failed_attempts");
      var8.commit();
      this.h = 0;
      this.i = 4;
      this.d(var1);
      this.f = null;
   }

   public void a(Context var1, boolean var2) {
      this.a = true;
      if (var1 != null) {
         Intent var3 = new Intent(var1, SalesforceSDKManager.a().i());
         var3.addFlags(536870912);
         var3.addFlags(1073741824);
         var3.addFlags(131072);
         if (var1 == SalesforceSDKManager.a().k()) {
            var3.addFlags(268435456);
         }

         var3.putExtra("change_passcode", var2);
         if (var1 instanceof Activity) {
            ((Activity)var1).startActivityForResult(var3, 777);
         } else {
            var1.startActivity(var3);
         }
      }

      EventsObservable.a().a(EventsObservable.EventType.AppLocked);
   }

   public void a(UserAccount var1, int var2, int var3) {
      if (var1 != null) {
         Editor var4 = SalesforceSDKManager.a().k().getSharedPreferences("mobile_policy" + var1.t(), 0).edit();
         var4.putInt("access_timeout", var2);
         var4.putInt("passcode_length", var3);
         var4.commit();
      }
   }

   public void a(String var1) {
      this.b = this.c(var1);
      this.j();
   }

   public void a(boolean var1) {
      if (var1) {
         this.f = new Handler();
         this.f.postDelayed(this.j, 20000L);
      } else {
         if (this.f != null) {
            this.f.removeCallbacks(this.j);
         }

         this.f = null;
      }
   }

   public boolean a() {
      boolean var1;
      if (this.f != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean a(Activity var1, boolean var2) {
      if (var1 != null) {
         this.e = var1;
      }

      if (!this.a() || !this.e() && !this.i()) {
         if (var2) {
            this.l();
         }

         var2 = false;
      } else {
         this.c(this.e);
         var2 = true;
      }

      return var2;
   }

   public boolean a(Context var1, int var2) {
      boolean var3;
      label12: {
         var3 = true;
         if (var2 > this.i) {
            this.i = var2;
            if (this.b(var1)) {
               this.a(var1, true);
               break label12;
            }
         }

         var3 = false;
      }

      this.i = var2;
      this.d(var1);
      return var3;
   }

   public boolean a(Context var1, String var2) {
      String var4 = this.d(var1.getSharedPreferences("user", 0).getString("passcode", null));
      boolean var3;
      if (var4 != null) {
         var3 = var4.equals(this.b(var2));
      } else {
         var3 = true;
      }

      return var3;
   }

   public int b() {
      int var1 = this.c() + 1;
      this.b(var1);
      return var1;
   }

   public String b(String var1) {
      return this.a(var1, this.c);
   }

   public void b(Context var1, String var2) {
      Editor var3 = var1.getSharedPreferences("user", 0).edit();
      var3.putString("passcode", this.b(var2));
      var3.commit();
   }

   public boolean b(Activity var1) {
      boolean var2 = true;
      this.a(true);
      this.a(var1, true);
      if (this.e()) {
         var2 = false;
      }

      return var2;
   }

   public boolean b(Context var1) {
      return var1.getSharedPreferences("user", 0).contains("passcode");
   }

   public int c() {
      return SalesforceSDKManager.a().k().getSharedPreferences("user", 0).getInt("failed_attempts", 0);
   }

   public String c(String var1) {
      return this.a(var1, this.d);
   }

   public void c(Context var1) {
      this.a(var1, false);
   }

   public String d() {
      return this.b;
   }

   public boolean e() {
      boolean var1;
      if (this.h > 0 && this.a) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void f() {
      this.l();
   }

   public int g() {
      return this.h;
   }

   public int h() {
      return this.i;
   }

   public boolean i() {
      boolean var1;
      if (this.h > 0 && this.k() >= this.g + this.h) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void j() {
      EventBuilderHelper.a("passcodeUnlock", null, "PasscodeManager", null);
      this.a = false;
      this.b(0);
      this.l();
      EventsObservable.a().a(EventsObservable.EventType.AppUnlocked);
   }

   protected long k() {
      return System.currentTimeMillis();
   }

   public static class HashConfig {
      public final String a;
      public final String b;
      public final String c;

      public HashConfig(String var1, String var2, String var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }

   private class LockChecker implements Runnable {
      final PasscodeManager a;

      private LockChecker(PasscodeManager var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         try {
            if (!this.a.a) {
               this.a.a((Activity)null, false);
            }
         } finally {
            if (this.a.f != null) {
               this.a.f.postDelayed(this, 20000L);
            }
         }
      }
   }

   private static class PasscodeFileFilter implements FilenameFilter {
      private PasscodeFileFilter() {
      }

      @Override
      public boolean accept(File var1, String var2) {
         boolean var3;
         if (var2 != null && var2.startsWith("mobile_policy_")) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }
}
