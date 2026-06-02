package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.OfflineMode;
import java.security.GeneralSecurityException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class MPConfig {
   private static MPConfig D;
   private static final Object E = new Object();
   public static boolean a = false;
   private final String A;
   private SSLSocketFactory B;
   private OfflineMode C;
   private final int b;
   private final int c;
   private final int d;
   private final int e;
   private final boolean f;
   private final boolean g;
   private final boolean h;
   private final boolean i;
   private final boolean j;
   private final String[] k;
   private final String l;
   private final String m;
   private final String n;
   private final boolean o;
   private final String p;
   private final String q;
   private final boolean r;
   private final int s;
   private final boolean t;
   private final int u;
   private final int v;
   private final int w;
   private final boolean x;
   private final int y;
   private final String z;

   MPConfig(Bundle var1, Context var2) {
      SSLSocketFactory var4 = null;
      super();

      label55: {
         SSLSocketFactory var14;
         try {
            SSLContext var5 = SSLContext.getInstance("TLS");
            var5.init(null, null, null);
            var14 = var5.getSocketFactory();
         } catch (GeneralSecurityException var6) {
            MPLog.c("MixpanelAPI.Conf", "System has no SSL support. Built-in events editor will not be available", var6);
            break label55;
         }

         var4 = var14;
      }

      this.B = var4;
      a = var1.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
      if (a) {
         MPLog.a(2);
      }

      if (var1.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval")) {
         MPLog.d(
            "MixpanelAPI.Conf",
            "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml."
         );
      }

      this.b = var1.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
      this.c = var1.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
      this.d = var1.getInt("com.mixpanel.android.MPConfig.DataExpiration", 432000000);
      this.e = var1.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
      this.q = var1.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
      this.g = var1.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
      this.h = var1.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
      this.i = var1.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
      this.j = var1.getBoolean("com.mixpanel.android.MPConfig.DisableViewCrawler", false);
      this.r = var1.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
      this.s = var1.getInt("com.mixpanel.android.MPConfig.ImageCacheMaxMemoryFactor", 10);
      this.t = var1.getBoolean("com.mixpanel.android.MPConfig.IgnoreInvisibleViewsVisualEditor", false);
      this.o = var1.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
      this.u = var1.getInt("com.mixpanel.android.MPConfig.NotificationDefaults", 0);
      this.v = var1.getInt("com.mixpanel.android.MPConfig.MinimumSessionDuration", 10000);
      this.w = var1.getInt("com.mixpanel.android.MPConfig.SessionTimeoutDuration", Integer.MAX_VALUE);
      this.x = var1.getBoolean("com.mixpanel.android.MPConfig.UseIpAddressForGeolocation", true);
      this.f = var1.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
      this.y = var1.getInt("com.mixpanel.android.MPConfig.NotificationChannelImportance", 3);
      String var15 = var1.getString("com.mixpanel.android.MPConfig.NotificationChannelId");
      String var7 = var15;
      if (var15 == null) {
         var7 = "mp";
      }

      this.z = var7;
      var15 = var1.getString("com.mixpanel.android.MPConfig.NotificationChannelName");
      String var8 = var15;
      if (var15 == null) {
         var8 = SystemInformation.a(var2).c();
      }

      this.A = var8;
      var15 = var1.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
      String var9 = var15;
      if (var15 == null) {
         StringBuilder var18 = new StringBuilder().append("https://api.mixpanel.com/track?ip=");
         String var10;
         if (this.x) {
            var10 = "1";
         } else {
            var10 = "0";
         }

         var9 = var18.append(var10).toString();
      }

      this.l = var9;
      var15 = var1.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
      String var11 = var15;
      if (var15 == null) {
         var11 = "https://api.mixpanel.com/engage";
      }

      this.m = var11;
      var15 = var1.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
      String var12 = var15;
      if (var15 == null) {
         var12 = "https://decide.mixpanel.com/decide";
      }

      this.n = var12;
      var15 = var1.getString("com.mixpanel.android.MPConfig.EditorUrl");
      String var13 = var15;
      if (var15 == null) {
         var13 = "wss://switchboard.mixpanel.com/connect/";
      }

      this.p = var13;
      int var3 = var1.getInt("com.mixpanel.android.MPConfig.DisableViewCrawlerForProjects", -1);
      if (var3 != -1) {
         this.k = var2.getResources().getStringArray(var3);
      } else {
         this.k = new String[0];
      }

      MPLog.a(
         "MixpanelAPI.Conf",
         "Mixpanel (5.2.1) configured with:\n    AutoShowMixpanelUpdates "
            + this.n()
            + "\n    BulkUploadLimit "
            + this.a()
            + "\n    FlushInterval "
            + this.b()
            + "\n    DataExpiration "
            + this.c()
            + "\n    MinimumDatabaseLimit "
            + this.d()
            + "\n    DisableAppOpenEvent "
            + this.g()
            + "\n    DisableViewCrawler "
            + this.h()
            + "\n    DisableGestureBindingUI "
            + this.e()
            + "\n    DisableEmulatorBindingUI "
            + this.f()
            + "\n    EnableDebugLogging "
            + a
            + "\n    TestMode "
            + this.j()
            + "\n    EventsEndpoint "
            + this.k()
            + "\n    PeopleEndpoint "
            + this.l()
            + "\n    DecideEndpoint "
            + this.m()
            + "\n    EditorUrl "
            + this.o()
            + "\n    ImageCacheMaxMemoryFactor "
            + this.A()
            + "\n    DisableDecideChecker "
            + this.p()
            + "\n    IgnoreInvisibleViewsEditor "
            + this.q()
            + "\n    NotificationDefaults "
            + this.r()
            + "\n    MinimumSessionDuration: "
            + this.s()
            + "\n    SessionTimeoutDuration: "
            + this.t()
            + "\n    NotificationChannelId: "
            + this.u()
            + "\n    NotificationChannelName: "
            + this.v()
            + "\n    NotificationChannelImportance: "
            + this.w()
      );
   }

   public static MPConfig a(Context param0) {
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
      // 00: getstatic com/mixpanel/android/mpmetrics/MPConfig.E Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/mixpanel/android/mpmetrics/MPConfig.D Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 09: ifnonnull 16
      // 0c: aload 0
      // 0d: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 10: invokestatic com/mixpanel/android/mpmetrics/MPConfig.b (Landroid/content/Context;)Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 13: putstatic com/mixpanel/android/mpmetrics/MPConfig.D Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 16: aload 1
      // 17: monitorexit
      // 18: getstatic com/mixpanel/android/mpmetrics/MPConfig.D Lcom/mixpanel/android/mpmetrics/MPConfig;
      // 1b: areturn
      // 1c: astore 0
      // 1d: aload 1
      // 1e: monitorexit
      // 1f: aload 0
      // 20: athrow
      // try (4 -> 10): 14 null
      // try (10 -> 12): 14 null
      // try (15 -> 17): 14 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static MPConfig b(Context var0) {
      String var3 = var0.getPackageName();

      Bundle var2;
      try {
         var2 = var0.getPackageManager().getApplicationInfo(var3, 128).metaData;
      } catch (NameNotFoundException var6) {
         throw new RuntimeException("Can't configure Mixpanel with package name " + var3, var6);
      }

      Bundle var1 = var2;
      if (var2 == null) {
         try {
            var1 = new Bundle();
         } catch (NameNotFoundException var5) {
            throw new RuntimeException("Can't configure Mixpanel with package name " + var3, var5);
         }
      }

      try {
         return new MPConfig(var1, var0);
      } catch (NameNotFoundException var4) {
         throw new RuntimeException("Can't configure Mixpanel with package name " + var3, var4);
      }
   }

   public int A() {
      return this.s;
   }

   public int a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public int d() {
      return this.e;
   }

   public boolean e() {
      return this.g;
   }

   public boolean f() {
      return this.h;
   }

   public boolean g() {
      return this.i;
   }

   public boolean h() {
      return this.j;
   }

   public String[] i() {
      return this.k;
   }

   public boolean j() {
      return this.f;
   }

   public String k() {
      return this.l;
   }

   public String l() {
      return this.m;
   }

   public String m() {
      return this.n;
   }

   public boolean n() {
      return this.o;
   }

   public String o() {
      return this.p;
   }

   public boolean p() {
      return this.r;
   }

   public boolean q() {
      return this.t;
   }

   public int r() {
      return this.u;
   }

   public int s() {
      return this.v;
   }

   public int t() {
      return this.w;
   }

   public String u() {
      return this.z;
   }

   public String v() {
      return this.A;
   }

   public int w() {
      return this.y;
   }

   public String x() {
      return this.q;
   }

   public SSLSocketFactory y() {
      synchronized (this) {
         return this.B;
      }
   }

   public OfflineMode z() {
      synchronized (this) {
         return this.C;
      }
   }
}
