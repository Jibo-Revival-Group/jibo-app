package com.salesforce.androidsdk.app;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.EventBuilderHelper;
import com.salesforce.androidsdk.analytics.SalesforceAnalyticsManager;
import com.salesforce.androidsdk.analytics.security.Encryptor;
import com.salesforce.androidsdk.auth.HttpAccess;
import com.salesforce.androidsdk.auth.OAuth2;
import com.salesforce.androidsdk.config.AdminPermsManager;
import com.salesforce.androidsdk.config.AdminSettingsManager;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.config.LoginServerManager;
import com.salesforce.androidsdk.push.PushMessaging;
import com.salesforce.androidsdk.push.PushNotificationInterface;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.security.PasscodeManager;
import com.salesforce.androidsdk.ui.AccountSwitcherActivity;
import com.salesforce.androidsdk.ui.LoginActivity;
import com.salesforce.androidsdk.ui.PasscodeActivity;
import com.salesforce.androidsdk.ui.SalesforceR;
import com.salesforce.androidsdk.util.EventsObservable;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.net.URI;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

public class SalesforceSDKManager {
   protected static String a;
   protected static SalesforceSDKManager b;
   private static final String k = UUID.randomUUID().toString();
   protected Context c;
   protected SalesforceSDKManager.KeyInterface d;
   protected ClientManager.LoginOptions e;
   protected Class<? extends Activity> f;
   protected Class<? extends Activity> g = LoginActivity.class;
   protected Class<? extends PasscodeActivity> h = PasscodeActivity.class;
   protected Class<? extends AccountSwitcherActivity> i = AccountSwitcherActivity.class;
   private SalesforceSDKManager.CleanupReceiver j;
   private String l;
   private SalesforceR m = new SalesforceR();
   private PasscodeManager n;
   private LoginServerManager o;
   private boolean p = false;
   private boolean q = false;
   private AdminSettingsManager r;
   private AdminPermsManager s;
   private PushNotificationInterface t;
   private String u;
   private volatile boolean v = false;
   private SortedSet<String> w;
   private List<String> x;
   private String y;
   private Object z = new Object();

   protected SalesforceSDKManager(Context var1, SalesforceSDKManager.KeyInterface var2, Class<? extends Activity> var3, Class<? extends Activity> var4) {
      this.u = Secure.getString(var1.getContentResolver(), "android_id");
      this.c = var1;
      this.d = var2;
      this.f = var3;
      if (var4 != null) {
         this.g = var4;
      }

      this.w = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
      if (TextUtils.isEmpty(c())) {
         try {
            var6 = var1.getString(var1.getPackageManager().getPackageInfo(var1.getPackageName(), 0).applicationInfo.labelRes);
         } catch (NameNotFoundException var5) {
            SalesforceSDKLogger.a("SalesforceSDKManager", "Package not found", var5);
            var6 = null;
         }

         if (!TextUtils.isEmpty(var6)) {
            a(var6);
         }
      }

      this.j = new SalesforceSDKManager.CleanupReceiver(this);
      var1.registerReceiver(this.j, new IntentFilter("com.salesforce.CLEANUP"));
   }

   private void H() {
      Intent var1 = new Intent("com.salesforce.LOGOUT_COMPLETE");
      var1.setPackage(this.c.getPackageName());
      this.c.sendBroadcast(var1);
   }

   public static SalesforceSDKManager a() {
      if (b != null) {
         return b;
      } else {
         throw new RuntimeException("Applications need to call SalesforceSDKManager.init() first.");
      }
   }

   private void a(Activity var1, Account var2) {
      UserAccount var3 = UserAccountManager.a().a(var2);
      this.a(var3);
      this.b(var3);
      List var4 = this.o().d();
      if (var1 != null && (var4 == null || var4.size() <= 1)) {
         var1.finish();
      }

      if (var4 == null || var4.size() <= 1) {
         this.p().c();
         this.q().c();
         this.r = null;
         this.s = null;
         this.n().a(this.c);
         this.n = null;
         this.l = null;
         UUIDManager.a();
      }
   }

   private void a(BroadcastReceiver param1, ClientManager param2, boolean param3, String param4, String param5, String param6, Account param7, Activity param8) {
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
      // 03: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.v Z
      // 06: istore 9
      // 08: iload 9
      // 0a: ifne 25
      // 0d: aload 0
      // 0e: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.c Landroid/content/Context;
      // 11: aload 1
      // 12: invokevirtual android/content/Context.unregisterReceiver (Landroid/content/BroadcastReceiver;)V
      // 15: aload 0
      // 16: aload 2
      // 17: iload 3
      // 18: aload 4
      // 1a: aload 5
      // 1c: aload 6
      // 1e: aload 7
      // 20: aload 8
      // 22: invokespecial com/salesforce/androidsdk/app/SalesforceSDKManager.b (Lcom/salesforce/androidsdk/rest/ClientManager;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/accounts/Account;Landroid/app/Activity;)V
      // 25: aload 0
      // 26: monitorexit
      // 27: return
      // 28: astore 1
      // 29: ldc "SalesforceSDKManager"
      // 2b: ldc_w "Exception occurred while unregistering"
      // 2e: aload 1
      // 2f: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 32: goto 15
      // 35: astore 1
      // 36: aload 0
      // 37: monitorexit
      // 38: aload 1
      // 39: athrow
      // try (2 -> 5): 29 null
      // try (7 -> 11): 23 java/lang/Exception
      // try (7 -> 11): 29 null
      // try (11 -> 20): 29 null
      // try (24 -> 28): 29 null
   }

   public static void a(Context var0) {
      Encryptor.a(var0);
      HttpAccess.a(var0, b.y());
      SalesforceSDKUpgradeManager.a().b();
   }

   private void a(ClientManager var1, boolean var2, String var3, String var4, String var5, Account var6, Activity var7) {
      IntentFilter var9 = new IntentFilter("com.salesfore.mobilesdk.c2dm.UNREGISTERED");
      BroadcastReceiver var8 = new BroadcastReceiver(this, var1, var2, var3, var4, var5, var6, var7) {
         final ClientManager a;
         final boolean b;
         final String c;
         final String d;
         final String e;
         final Account f;
         final Activity g;
         final SalesforceSDKManager h;

         {
            this.h = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
            this.f = var7x;
            this.g = var8x;
         }

         public void onReceive(Context var1, Intent var2x) {
            if (var2x.getAction().equals("com.salesfore.mobilesdk.c2dm.UNREGISTERED")) {
               this.h.a(this, this.a, this.b, this.c, this.d, this.e, this.f, this.g);
            }
         }
      };
      this.k().registerReceiver(var8, var9);
      UserAccount var10 = this.o().a(var6);
      PushMessaging.b(this.c, var10);
      (new Thread(this, var8, var1, var2, var3, var4, var5, var6, var7) {
         final BroadcastReceiver a;
         final ClientManager b;
         final boolean c;
         final String d;
         final String e;
         final String f;
         final Account g;
         final Activity h;
         final SalesforceSDKManager i;

         {
            this.i = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
            this.f = var7x;
            this.g = var8x;
            this.h = var9x;
         }

         @Override
         public void run() {
            long var1x = System.currentTimeMillis();

            while (System.currentTimeMillis() - var1x < 30000L && !this.i.v) {
               SystemClock.sleep(500L);
            }

            this.i.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
         }
      }).start();
   }

   public static void a(String var0) {
      if (!TextUtils.isEmpty(var0)) {
         a = var0;
      }
   }

   private void a(boolean var1) {
      EventsObservable.a().a(EventsObservable.EventType.LogoutComplete);
      this.H();
      if (var1) {
         this.x();
      }
   }

   private void b(UserAccount var1) {
      Intent var2 = new Intent("com.salesforce.CLEANUP");
      var2.setPackage(this.c.getPackageName());
      var2.putExtra("processId", k);
      if (var1 != null) {
         var2.putExtra("userAccount", var1.w());
      }

      this.c.sendBroadcast(var2);
   }

   private void b(ClientManager var1, boolean var2, String var3, String var4, String var5, Account var6, Activity var7) {
      this.v = true;
      this.a(var7, var6);
      if (var6 == null) {
         AccountManager var9 = AccountManager.get(this.c);
         if (var9 != null) {
            Account[] var10 = var9.getAccountsByType(this.B());
            if (var10.length > 0) {
               for (int var8 = 0; var8 < var10.length - 1; var8++) {
                  var1.a(var10);
               }

               var1.a(var10[var10.length - 1], new AccountManagerCallback<Boolean>(this, var2) {
                  final boolean a;
                  final SalesforceSDKManager b;

                  {
                     this.b = var1;
                     this.a = var2x;
                  }

                  public void run(AccountManagerFuture<Boolean> var1) {
                     this.b.a(this.a);
                  }
               });
            } else {
               this.a(var2);
            }
         } else {
            this.a(var2);
         }
      } else {
         var1.a(var6, new AccountManagerCallback<Boolean>(this, var2) {
            final boolean a;
            final SalesforceSDKManager b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void run(AccountManagerFuture<Boolean> var1) {
               this.b.a(this.a);
            }
         });
      }

      this.q = false;
      if (this.j() && var6 != null && var3 != null) {
         new SalesforceSDKManager.RevokeTokenTask(this, var3, var4, var5).execute(new Void[0]);
      }
   }

   public static boolean b() {
      boolean var0;
      if (b != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   public static String c() {
      return a;
   }

   public static String d(String var0, String var1) {
      return Encryptor.b(var0, b.c(var1));
   }

   public static String e(String var0, String var1) {
      return Encryptor.a(var0, b.c(var1));
   }

   public boolean A() {
      return false;
   }

   public String B() {
      return this.c.getString(this.e().a());
   }

   public boolean C() {
      return b.p;
   }

   public boolean D() {
      return this.q;
   }

   public ClientManager E() {
      return new ClientManager(this.k(), this.B(), this.h(), true);
   }

   @TargetApi(21)
   public void F() {
      if (VERSION.SDK_INT >= 21) {
         CookieManager.getInstance().removeAllCookies(null);
      } else {
         CookieSyncManager.createInstance(this.c);
         CookieManager.getInstance().removeAllCookie();
      }
   }

   public ClientManager.LoginOptions a(String var1, String var2) {
      if (this.e == null) {
         BootConfig var3 = BootConfig.a(this.c);
         if (TextUtils.isEmpty(var1)) {
            this.e = new ClientManager.LoginOptions(var2, this.t(), var3.b(), var3.a(), var3.c(), null);
         } else {
            this.e = new ClientManager.LoginOptions(var2, this.t(), var3.b(), var3.a(), var3.c(), null, var1);
         }
      } else {
         this.e.a(var1);
         this.e.b(var2);
      }

      return this.e;
   }

   public void a(Account var1, Activity var2) {
      this.a(var1, var2, true);
   }

   public void a(Account var1, Activity var2, boolean var3) {
      String var5 = null;
      EventBuilderHelper.a("userLogout", null, "SalesforceSDKManager", null);
      ClientManager var7 = new ClientManager(this.c, this.B(), null, this.j());
      this.q = true;
      AccountManager var8 = AccountManager.get(this.c);
      String var4;
      String var6;
      if (var1 != null) {
         var5 = this.t();
         var4 = e(var8.getPassword(var1), var5);
         var6 = e(var8.getUserData(var1, "clientId"), var5);
         var5 = e(var8.getUserData(var1, "instanceUrl"), var5);
      } else {
         var6 = null;
         var4 = null;
      }

      UserAccount var10 = this.o().a(var1);
      if (PushMessaging.f(this.c, var10) && var4 != null) {
         this.v = false;
         this.a(var7, var3, var4, var6, var5, var1, var2);
      } else {
         this.b(var7, var3, var4, var6, var5, var1, var2);
      }
   }

   public void a(Activity var1) {
      this.a(var1, true);
   }

   public void a(Activity var1, boolean var2) {
      this.a(new ClientManager(this.c, this.B(), null, this.j()).c(), var1, var2);
   }

   protected void a(UserAccount var1) {
      SalesforceAnalyticsManager.b(var1);
      RestClient.a(var1);
   }

   public void a(PushNotificationInterface var1) {
      synchronized (this) {
         this.t = var1;
      }
   }

   public String b(String var1) {
      String var2 = null;
      if (this.d != null) {
         var2 = this.d.a(var1);
      }

      return var2;
   }

   public void b(String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: aload 1
      // 04: aload 2
      // 05: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.c (Ljava/lang/String;Ljava/lang/String;)Z
      // 08: istore 3
      // 09: iload 3
      // 0a: ifne 10
      // 0d: aload 0
      // 0e: monitorexit
      // 0f: return
      // 10: aload 0
      // 11: aconst_null
      // 12: putfield com/salesforce/androidsdk/app/SalesforceSDKManager.l Ljava/lang/String;
      // 15: aload 1
      // 16: aload 2
      // 17: invokestatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a (Ljava/lang/String;Ljava/lang/String;)V
      // 1a: aload 1
      // 1b: aload 2
      // 1c: invokestatic com/salesforce/androidsdk/rest/ClientManager.a (Ljava/lang/String;Ljava/lang/String;)V
      // 1f: goto 0d
      // 22: astore 1
      // 23: aload 0
      // 24: monitorexit
      // 25: aload 1
      // 26: athrow
      // try (2 -> 7): 22 null
      // try (12 -> 21): 22 null
   }

   public String c(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 1
      // 03: ifnull 19
      // 06: aload 1
      // 07: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0a: ldc_w ""
      // 0d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 10: istore 2
      // 11: iload 2
      // 12: ifne 19
      // 15: aload 0
      // 16: monitorexit
      // 17: aload 1
      // 18: areturn
      // 19: aload 0
      // 1a: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.l Ljava/lang/String;
      // 1d: ifnonnull 2e
      // 20: aload 0
      // 21: aload 0
      // 22: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.n ()Lcom/salesforce/androidsdk/security/PasscodeManager;
      // 25: ldc_w ""
      // 28: invokevirtual com/salesforce/androidsdk/security/PasscodeManager.c (Ljava/lang/String;)Ljava/lang/String;
      // 2b: putfield com/salesforce/androidsdk/app/SalesforceSDKManager.l Ljava/lang/String;
      // 2e: aload 0
      // 2f: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.l Ljava/lang/String;
      // 32: astore 1
      // 33: goto 15
      // 36: astore 1
      // 37: aload 0
      // 38: monitorexit
      // 39: aload 1
      // 3a: athrow
      // try (4 -> 9): 28 null
      // try (15 -> 24): 28 null
      // try (24 -> 27): 28 null
   }

   protected boolean c(String var1, String var2) {
      boolean var3;
      if (var1 == null && var2 == null || var1 != null && var2 != null && var1.trim().equals(var2.trim())) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   public Class<? extends Activity> d() {
      return this.f;
   }

   public String d(String var1) {
      String var4 = "";

      String var2;
      PackageInfo var12;
      label27: {
         label26: {
            label25: {
               try {
                  var12 = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0);
                  var2 = this.c.getString(var12.applicationInfo.labelRes);
               } catch (NameNotFoundException var7) {
                  var12 = var7;
                  var2 = "";
                  break label26;
               } catch (NotFoundException var8) {
                  var12 = var8;
                  var2 = "";
                  break label25;
               }

               try {
                  var12 = var12.versionName;
                  break label27;
               } catch (NameNotFoundException var5) {
                  var12 = var5;
                  break label26;
               } catch (NotFoundException var6) {
                  var12 = var6;
               }
            }

            SalesforceSDKLogger.b("SalesforceSDKManager", "Package info could not be retrieved", var12);
            var12 = var4;
            break label27;
         }

         SalesforceSDKLogger.b("SalesforceSDKManager", "Package info could not be retrieved", var12);
         var12 = var4;
      }

      var1 = this.z() + var1;
      return String.format(
         "SalesforceMobileSDK/%s android mobile/%s (%s) %s/%s %s uid_%s ftr_%s",
         "5.3.0",
         VERSION.RELEASE,
         Build.MODEL,
         var2,
         var12,
         var1,
         this.u,
         TextUtils.join(".", this.w)
      );
   }

   public SalesforceR e() {
      return this.m;
   }

   public void e(String var1) {
      this.w.add(var1);
   }

   public Class<? extends Activity> f() {
      return this.g;
   }

   public void f(String var1) {
      this.w.remove(var1);
   }

   public String g() {
      return this.u;
   }

   public ClientManager.LoginOptions h() {
      return this.a((String)null, (String)null);
   }

   public Class<? extends PasscodeActivity> i() {
      return this.h;
   }

   public boolean j() {
      return true;
   }

   public Context k() {
      return this.c;
   }

   public LoginServerManager l() {
      synchronized (this) {
         if (this.o == null) {
            LoginServerManager var1 = new LoginServerManager(this.c);
            this.o = var1;
         }

         return this.o;
      }
   }

   public PushNotificationInterface m() {
      synchronized (this) {
         return this.t;
      }
   }

   public PasscodeManager n() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.z Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.n Lcom/salesforce/androidsdk/security/PasscodeManager;
      // 0b: ifnonnull 1f
      // 0e: new com/salesforce/androidsdk/security/PasscodeManager
      // 11: astore 2
      // 12: aload 2
      // 13: aload 0
      // 14: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.c Landroid/content/Context;
      // 17: invokespecial com/salesforce/androidsdk/security/PasscodeManager.<init> (Landroid/content/Context;)V
      // 1a: aload 0
      // 1b: aload 2
      // 1c: putfield com/salesforce/androidsdk/app/SalesforceSDKManager.n Lcom/salesforce/androidsdk/security/PasscodeManager;
      // 1f: aload 0
      // 20: getfield com/salesforce/androidsdk/app/SalesforceSDKManager.n Lcom/salesforce/androidsdk/security/PasscodeManager;
      // 23: astore 2
      // 24: aload 1
      // 25: monitorexit
      // 26: aload 2
      // 27: areturn
      // 28: astore 2
      // 29: aload 1
      // 2a: monitorexit
      // 2b: aload 2
      // 2c: athrow
      // try (5 -> 17): 24 null
      // try (17 -> 22): 24 null
      // try (25 -> 27): 24 null
   }

   public UserAccountManager o() {
      return UserAccountManager.a();
   }

   public AdminSettingsManager p() {
      synchronized (this) {
         if (this.r == null) {
            AdminSettingsManager var1 = new AdminSettingsManager();
            this.r = var1;
         }

         return this.r;
      }
   }

   public AdminPermsManager q() {
      synchronized (this) {
         if (this.s == null) {
            AdminPermsManager var1 = new AdminPermsManager();
            this.s = var1;
         }

         return this.s;
      }
   }

   public String r() {
      return this.y;
   }

   public String s() {
      return "Salesforce";
   }

   public String t() {
      return this.n().d();
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass())
         .append(": {\n")
         .append("   accountType: ")
         .append(this.B())
         .append("\n")
         .append("   userAgent: ")
         .append(this.y())
         .append("\n")
         .append("   mainActivityClass: ")
         .append(this.d())
         .append("\n")
         .append("   isFileSystemEncrypted: ")
         .append(Encryptor.b())
         .append("\n");
      if (this.n != null) {
         var1.append("   hasStoredPasscode: ").append(this.n.b(this.c)).append("\n");
      }

      var1.append("}\n");
      return var1.toString();
   }

   public String u() {
      return this.c.getPackageManager().getApplicationLabel(this.c.getApplicationInfo()).toString();
   }

   public List<String> v() {
      return this.x;
   }

   protected void w() {
      this.F();
      Intent var1 = new Intent(this.c, this.d());
      var1.setPackage(this.k().getPackageName());
      var1.setFlags(268435456);
      this.c.startActivity(var1);
   }

   public void x() {
      this.F();
      UserAccountManager var1 = this.o();
      List var2 = var1.d();
      if (var2 != null && var2.size() != 0) {
         if (var2.size() == 1) {
            var1.a((UserAccount)var2.get(0), 2, null);
         } else {
            Intent var3 = new Intent(this.c, this.i);
            var3.setFlags(268435456);
            this.c.startActivity(var3);
         }
      } else {
         this.w();
      }
   }

   public final String y() {
      return this.d("");
   }

   public String z() {
      return "Native";
   }

   private class CleanupReceiver extends BroadcastReceiver {
      final SalesforceSDKManager a;

      private CleanupReceiver(SalesforceSDKManager var1) {
         this.a = var1;
      }

      public void onReceive(Context var1, Intent var2) {
         if (var2 != null && var2.getAction().equals("com.salesforce.CLEANUP") && !var2.getStringExtra("processId").equals(SalesforceSDKManager.k)) {
            UserAccount var3 = null;
            if (var2.hasExtra("userAccount")) {
               var3 = new UserAccount(var2.getBundleExtra("userAccount"));
            }

            this.a.a(var3);
         }
      }
   }

   public interface KeyInterface {
      String a(String var1);
   }

   private class RevokeTokenTask extends AsyncTask<Void, Void, Void> {
      final SalesforceSDKManager a;
      private String b;
      private String c;
      private String d;

      public RevokeTokenTask(SalesforceSDKManager var1, String var2, String var3, String var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      protected Void a(Void... var1) {
         try {
            HttpAccess var4 = HttpAccess.a;
            URI var2 = new URI(this.d);
            OAuth2.a(var4, var2, this.b);
         } catch (Exception var3) {
            SalesforceSDKLogger.b("SalesforceSDKManager", "Revoking token failed", var3);
         }

         return null;
      }
   }
}
