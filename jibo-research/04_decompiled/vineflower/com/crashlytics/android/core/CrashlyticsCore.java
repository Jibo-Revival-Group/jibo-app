package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@DependsOn(a = CrashEventDataProvider.class)
public class CrashlyticsCore extends Kit<Void> {
   private final long a;
   private final ConcurrentHashMap<String, String> b;
   private CrashlyticsFileMarker c;
   private CrashlyticsFileMarker d;
   private CrashlyticsListener k;
   private CrashlyticsController l;
   private String m = null;
   private String n = null;
   private String o = null;
   private float p;
   private boolean q;
   private final PinningInfoProvider r;
   private HttpRequestFactory s;
   private CrashlyticsBackgroundWorker t;
   private CrashEventDataProvider u;

   public CrashlyticsCore() {
      this(1.0F, null, null, false);
   }

   CrashlyticsCore(float var1, CrashlyticsListener var2, PinningInfoProvider var3, boolean var4) {
      this(var1, var2, var3, var4, ExecutorUtils.a("Crashlytics Exception Handler"));
   }

   CrashlyticsCore(float var1, CrashlyticsListener var2, PinningInfoProvider var3, boolean var4, ExecutorService var5) {
      this.p = var1;
      if (var2 == null) {
         var2 = new CrashlyticsCore.NoOpListener();
      }

      this.k = var2;
      this.r = var3;
      this.q = var4;
      this.t = new CrashlyticsBackgroundWorker(var5);
      this.b = new ConcurrentHashMap<>();
      this.a = System.currentTimeMillis();
   }

   private static boolean a(String var0) {
      CrashlyticsCore var2 = e();
      boolean var1;
      if (var2 != null && var2.l != null) {
         var1 = true;
      } else {
         Fabric.h().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + var0, null);
         var1 = false;
      }

      return var1;
   }

   static boolean a(String var0, boolean var1) {
      boolean var2 = true;
      if (!var1) {
         Fabric.h().a("CrashlyticsCore", "Configured not to require a build ID.");
         var1 = var2;
      } else {
         var1 = var2;
         if (CommonUtils.c(var0)) {
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e(
               "CrashlyticsCore",
               "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization."
            );
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            var1 = false;
         }
      }

      return var1;
   }

   public static CrashlyticsCore e() {
      return Fabric.a(CrashlyticsCore.class);
   }

   private void w() {
      PriorityCallable var1 = new PriorityCallable<Void>(this) {
         final CrashlyticsCore a;

         {
            this.a = var1;
         }

         public Void a() throws Exception {
            return this.a.d();
         }

         @Override
         public Priority b() {
            return Priority.IMMEDIATE;
         }
      };
      Iterator var2 = this.v().iterator();

      while (var2.hasNext()) {
         var1.a((Task)var2.next());
      }

      Future var6 = this.s().f().submit(var1);
      Fabric.h().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");

      try {
         var6.get(4L, TimeUnit.SECONDS);
      } catch (InterruptedException var3) {
         Fabric.h().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", var3);
      } catch (ExecutionException var4) {
         Fabric.h().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", var4);
      } catch (TimeoutException var5) {
         Fabric.h().e("CrashlyticsCore", "Crashlytics timed out during initialization.", var5);
      }
   }

   private void x() {
      Boolean var1 = this.t.a(new CrashlyticsCore.CrashMarkerCheck(this.d));
      if (Boolean.TRUE.equals(var1)) {
         try {
            this.k.a();
         } catch (Exception var2) {
            Fabric.h().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", var2);
         }
      }
   }

   @Override
   public String a() {
      return "2.3.17.dev";
   }

   public void a(Throwable var1) {
      if (!this.q && a("prior to logging exceptions.")) {
         if (var1 == null) {
            Fabric.h().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
         } else {
            this.l.b(Thread.currentThread(), var1);
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   boolean a(Context var1) {
      boolean var2;
      if (this.q) {
         var2 = false;
      } else {
         String var7 = new ApiKey().a(var1);
         if (var7 == null) {
            var2 = false;
         } else {
            String var6 = CommonUtils.m(var1);
            if (!a(var6, CommonUtils.a(var1, "com.crashlytics.RequireBuildId", true))) {
               throw new UnmetDependencyException(
                  "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization."
               );
            }

            PreferenceManager var5;
            CrashlyticsPinningInfoProvider var17;
            FileStoreImpl var19;
            label44: {
               try {
                  Logger var4 = Fabric.h();
                  StringBuilder var3 = new StringBuilder();
                  var4.c("CrashlyticsCore", var3.append("Initializing Crashlytics ").append(this.a()).toString());
                  var19 = new FileStoreImpl(this);
                  CrashlyticsFileMarker var14 = new CrashlyticsFileMarker("crash_marker", var19);
                  this.d = var14;
                  CrashlyticsFileMarker var15 = new CrashlyticsFileMarker("initialization_marker", var19);
                  this.c = var15;
                  PreferenceStoreImpl var16 = new PreferenceStoreImpl(this.r(), "com.crashlytics.android.core.CrashlyticsCore");
                  var5 = PreferenceManager.a(var16, this);
                  if (this.r != null) {
                     var17 = new CrashlyticsPinningInfoProvider(this.r);
                     break label44;
                  }
               } catch (Exception var12) {
                  Fabric.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", var12);
                  this.l = null;
                  var2 = false;
                  return var2;
               }

               var17 = null;
            }

            try {
               DefaultHttpRequestFactory var8 = new DefaultHttpRequestFactory(Fabric.h());
               this.s = var8;
               this.s.a(var17);
               IdManager var18 = this.q();
               AppData var20 = AppData.a(var1, var18, var7, var6);
               ManifestUnityVersionProvider var21 = new ManifestUnityVersionProvider(var1, var20.d);
               Logger var22 = Fabric.h();
               StringBuilder var9 = new StringBuilder();
               var22.a("CrashlyticsCore", var9.append("Installer package name is: ").append(var20.c).toString());
               CrashlyticsController var23 = new CrashlyticsController(this, this.t, this.s, var18, var5, var19, var20, var21);
               this.l = var23;
               var2 = this.m();
               this.x();
               this.l.a(Thread.getDefaultUncaughtExceptionHandler());
            } catch (Exception var11) {
               Fabric.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", var11);
               this.l = null;
               var2 = false;
               return var2;
            }

            label59: {
               if (var2) {
                  try {
                     if (CommonUtils.n(var1)) {
                        Fabric.h().a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                        this.w();
                        break label59;
                     }
                  } catch (Exception var10) {
                     Fabric.h().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", var10);
                     this.l = null;
                     var2 = false;
                     return var2;
                  }
               }

               Fabric.h().a("CrashlyticsCore", "Exception handling initialization successful");
               var2 = true;
               return var2;
            }

            var2 = false;
         }
      }

      return var2;
   }

   @Override
   protected boolean a_() {
      return this.a(super.r());
   }

   @Override
   public String b() {
      return "com.crashlytics.sdk.android.crashlytics-core";
   }

   protected Void d() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual com/crashlytics/android/core/CrashlyticsCore.k ()V
      // 04: aload 0
      // 05: invokevirtual com/crashlytics/android/core/CrashlyticsCore.n ()Lcom/crashlytics/android/core/internal/models/SessionEventData;
      // 08: astore 1
      // 09: aload 1
      // 0a: ifnull 15
      // 0d: aload 0
      // 0e: getfield com/crashlytics/android/core/CrashlyticsCore.l Lcom/crashlytics/android/core/CrashlyticsController;
      // 11: aload 1
      // 12: invokevirtual com/crashlytics/android/core/CrashlyticsController.a (Lcom/crashlytics/android/core/internal/models/SessionEventData;)V
      // 15: aload 0
      // 16: getfield com/crashlytics/android/core/CrashlyticsCore.l Lcom/crashlytics/android/core/CrashlyticsController;
      // 19: invokevirtual com/crashlytics/android/core/CrashlyticsController.d ()V
      // 1c: invokestatic io/fabric/sdk/android/services/settings/Settings.a ()Lio/fabric/sdk/android/services/settings/Settings;
      // 1f: invokevirtual io/fabric/sdk/android/services/settings/Settings.b ()Lio/fabric/sdk/android/services/settings/SettingsData;
      // 22: astore 1
      // 23: aload 1
      // 24: ifnonnull 3a
      // 27: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 2a: ldc "CrashlyticsCore"
      // 2c: ldc_w "Received null settings, skipping report submission!"
      // 2f: invokeinterface io/fabric/sdk/android/Logger.d (Ljava/lang/String;Ljava/lang/String;)V 3
      // 34: aload 0
      // 35: invokevirtual com/crashlytics/android/core/CrashlyticsCore.l ()V
      // 38: aconst_null
      // 39: areturn
      // 3a: aload 1
      // 3b: getfield io/fabric/sdk/android/services/settings/SettingsData.d Lio/fabric/sdk/android/services/settings/FeaturesSettingsData;
      // 3e: getfield io/fabric/sdk/android/services/settings/FeaturesSettingsData.c Z
      // 41: ifne 58
      // 44: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 47: ldc "CrashlyticsCore"
      // 49: ldc_w "Collection of crash reports disabled in Crashlytics settings."
      // 4c: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 51: aload 0
      // 52: invokevirtual com/crashlytics/android/core/CrashlyticsCore.l ()V
      // 55: goto 38
      // 58: aload 0
      // 59: getfield com/crashlytics/android/core/CrashlyticsCore.l Lcom/crashlytics/android/core/CrashlyticsController;
      // 5c: aload 1
      // 5d: getfield io/fabric/sdk/android/services/settings/SettingsData.b Lio/fabric/sdk/android/services/settings/SessionSettingsData;
      // 60: invokevirtual com/crashlytics/android/core/CrashlyticsController.a (Lio/fabric/sdk/android/services/settings/SessionSettingsData;)Z
      // 63: ifne 73
      // 66: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 69: ldc "CrashlyticsCore"
      // 6b: ldc_w "Could not finalize previous sessions."
      // 6e: invokeinterface io/fabric/sdk/android/Logger.a (Ljava/lang/String;Ljava/lang/String;)V 3
      // 73: aload 0
      // 74: getfield com/crashlytics/android/core/CrashlyticsCore.l Lcom/crashlytics/android/core/CrashlyticsController;
      // 77: aload 0
      // 78: getfield com/crashlytics/android/core/CrashlyticsCore.p F
      // 7b: aload 1
      // 7c: invokevirtual com/crashlytics/android/core/CrashlyticsController.a (FLio/fabric/sdk/android/services/settings/SettingsData;)V
      // 7f: aload 0
      // 80: invokevirtual com/crashlytics/android/core/CrashlyticsCore.l ()V
      // 83: goto 38
      // 86: astore 1
      // 87: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 8a: ldc "CrashlyticsCore"
      // 8c: ldc_w "Crashlytics encountered a problem during asynchronous initialization."
      // 8f: aload 1
      // 90: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 95: aload 0
      // 96: invokevirtual com/crashlytics/android/core/CrashlyticsCore.l ()V
      // 99: goto 38
      // 9c: astore 1
      // 9d: aload 0
      // 9e: invokevirtual com/crashlytics/android/core/CrashlyticsCore.l ()V
      // a1: aload 1
      // a2: athrow
      // try (14 -> 17): 57 java/lang/Exception
      // try (14 -> 17): 66 null
      // try (19 -> 23): 57 java/lang/Exception
      // try (19 -> 23): 66 null
      // try (27 -> 35): 57 java/lang/Exception
      // try (27 -> 35): 66 null
      // try (38 -> 48): 57 java/lang/Exception
      // try (38 -> 48): 66 null
      // try (48 -> 54): 57 java/lang/Exception
      // try (48 -> 54): 66 null
      // try (58 -> 63): 66 null
   }

   Map<String, String> g() {
      return Collections.unmodifiableMap(this.b);
   }

   String h() {
      String var1;
      if (this.q().a()) {
         var1 = this.m;
      } else {
         var1 = null;
      }

      return var1;
   }

   String i() {
      String var1;
      if (this.q().a()) {
         var1 = this.n;
      } else {
         var1 = null;
      }

      return var1;
   }

   String j() {
      String var1;
      if (this.q().a()) {
         var1 = this.o;
      } else {
         var1 = null;
      }

      return var1;
   }

   void k() {
      this.t.a(new Callable<Void>(this) {
         final CrashlyticsCore a;

         {
            this.a = var1;
         }

         public Void a() throws Exception {
            this.a.c.a();
            Fabric.h().a("CrashlyticsCore", "Initialization marker file created.");
            return null;
         }
      });
   }

   void l() {
      this.t.b(new Callable<Boolean>(this) {
         final CrashlyticsCore a;

         {
            this.a = var1;
         }

         public Boolean a() throws Exception {
            boolean var1;
            try {
               var1 = this.a.c.c();
               Logger var3 = Fabric.h();
               StringBuilder var5 = new StringBuilder();
               var3.a("CrashlyticsCore", var5.append("Initialization marker file removed: ").append(var1).toString());
            } catch (Exception var4) {
               Fabric.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", var4);
               return false;
            }

            return var1;
         }
      });
   }

   boolean m() {
      return this.t.a(new Callable<Boolean>(this) {
         final CrashlyticsCore a;

         {
            this.a = var1;
         }

         public Boolean a() throws Exception {
            return this.a.c.b();
         }
      });
   }

   SessionEventData n() {
      SessionEventData var1 = null;
      if (this.u != null) {
         var1 = this.u.a();
      }

      return var1;
   }

   void o() {
      this.d.a();
   }

   private static final class CrashMarkerCheck implements Callable<Boolean> {
      private final CrashlyticsFileMarker a;

      public CrashMarkerCheck(CrashlyticsFileMarker var1) {
         this.a = var1;
      }

      public Boolean a() throws Exception {
         Boolean var1;
         if (!this.a.b()) {
            var1 = Boolean.FALSE;
         } else {
            Fabric.h().a("CrashlyticsCore", "Found previous crash marker.");
            this.a.c();
            var1 = Boolean.TRUE;
         }

         return var1;
      }
   }

   private static final class NoOpListener implements CrashlyticsListener {
      private NoOpListener() {
      }

      @Override
      public void a() {
      }
   }
}
