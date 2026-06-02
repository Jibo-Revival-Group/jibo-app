package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.TrackingDebug;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import com.mixpanel.android.viewcrawler.ViewCrawler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MixpanelAPI {
   private static final Map<String, Map<Context, MixpanelAPI>> n = new HashMap<>();
   private static final SharedPreferencesLoader o = new SharedPreferencesLoader();
   private static final Tweaks p = new Tweaks();
   private static Future<SharedPreferences> q;
   private final Context a;
   private final AnalyticsMessages b;
   private final MPConfig c;
   private final String d;
   private final MixpanelAPI.PeopleImpl e;
   private final UpdatesFromMixpanel f;
   private final PersistentIdentity g;
   private final MixpanelAPI.UpdatesListener h;
   private final TrackingDebug i;
   private final DecideMessages j;
   private final Map<String, String> k;
   private final Map<String, Long> l;
   private MixpanelActivityLifecycleCallbacks m;

   MixpanelAPI(Context var1, Future<SharedPreferences> var2, String var3) {
      this(var1, var2, var3, MPConfig.a(var1));
   }

   MixpanelAPI(Context var1, Future<SharedPreferences> var2, String var3, MPConfig var4) {
      this.a = var1;
      this.d = var3;
      this.e = new MixpanelAPI.PeopleImpl(this);
      this.c = var4;
      HashMap var5 = new HashMap();
      var5.put("$android_lib_version", "5.2.1");
      var5.put("$android_os", "Android");
      String var16;
      if (VERSION.RELEASE == null) {
         var16 = "UNKNOWN";
      } else {
         var16 = VERSION.RELEASE;
      }

      var5.put("$android_os_version", var16);
      String var17;
      if (Build.MANUFACTURER == null) {
         var17 = "UNKNOWN";
      } else {
         var17 = Build.MANUFACTURER;
      }

      var5.put("$android_manufacturer", var17);
      String var18;
      if (Build.BRAND == null) {
         var18 = "UNKNOWN";
      } else {
         var18 = Build.BRAND;
      }

      var5.put("$android_brand", var18);
      String var19;
      if (Build.MODEL == null) {
         var19 = "UNKNOWN";
      } else {
         var19 = Build.MODEL;
      }

      var5.put("$android_model", var19);

      try {
         PackageInfo var20 = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
         var5.put("$android_app_version", var20.versionName);
         var5.put("$android_app_version_code", Integer.toString(var20.versionCode));
      } catch (NameNotFoundException var8) {
         MPLog.e("MixpanelAPI.API", "Exception getting app version name", var8);
      }

      this.k = Collections.unmodifiableMap(var5);
      this.f = this.b(var1, var3);
      this.i = this.k();
      this.g = this.a(var1, var2, var3);
      this.l = this.g.g();
      this.h = this.j();
      this.j = this.a(var3, this.h, this.f);
      String var13 = this.g.c();
      String var9 = var13;
      if (var13 == null) {
         var9 = this.g.b();
      }

      this.j.a(var9);
      this.b = this.i();
      if (this.g.a(MPDbAdapter.a(this.a).b().exists())) {
         this.a("$ae_first_open", null, true);
         this.g.h();
      }

      if (!this.c.p()) {
         this.b.a(this.j);
      }

      this.f();
      if (this.l()) {
         this.a("$app_open", (JSONObject)null);
      }

      if (!this.g.e(this.d)) {
         try {
            JSONObject var10 = new JSONObject();
            var10.put("mp_lib", "Android");
            var10.put("lib", "Android");
            var10.put("distinct_id", var3);
            AnalyticsMessages.EventDescription var14 = new AnalyticsMessages.EventDescription("Integration", var10, "85053bf24bba75239b16a601d9387e17", false);
            this.b.a(var14);
            AnalyticsMessages var11 = this.b;
            AnalyticsMessages.FlushDescription var15 = new AnalyticsMessages.FlushDescription("85053bf24bba75239b16a601d9387e17", false);
            var11.a(var15);
            this.g.f(this.d);
         } catch (JSONException var7) {
         }
      }

      if (this.g.g((String)var5.get("$android_app_version_code"))) {
         try {
            JSONObject var12 = new JSONObject();
            var12.put("$ae_updated_version", var5.get("$android_app_version"));
            this.a("$ae_updated", var12, true);
         } catch (JSONException var6) {
         }
      }

      this.f.a();
      ExceptionHandler.a();
   }

   public static MixpanelAPI a(Context param0, String param1) {
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
      // 00: aconst_null
      // 01: astore 3
      // 02: aload 3
      // 03: astore 2
      // 04: aload 1
      // 05: ifnull 0e
      // 08: aload 0
      // 09: ifnonnull 10
      // 0c: aload 3
      // 0d: astore 2
      // 0e: aload 2
      // 0f: areturn
      // 10: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.n Ljava/util/Map;
      // 13: astore 5
      // 15: aload 5
      // 17: monitorenter
      // 18: aload 0
      // 19: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 1c: astore 6
      // 1e: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.q Ljava/util/concurrent/Future;
      // 21: ifnonnull 32
      // 24: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.o Lcom/mixpanel/android/mpmetrics/SharedPreferencesLoader;
      // 27: aload 0
      // 28: ldc_w "com.mixpanel.android.mpmetrics.ReferralInfo"
      // 2b: aconst_null
      // 2c: invokevirtual com/mixpanel/android/mpmetrics/SharedPreferencesLoader.a (Landroid/content/Context;Ljava/lang/String;Lcom/mixpanel/android/mpmetrics/SharedPreferencesLoader$OnPrefsLoadedListener;)Ljava/util/concurrent/Future;
      // 2f: putstatic com/mixpanel/android/mpmetrics/MixpanelAPI.q Ljava/util/concurrent/Future;
      // 32: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.n Ljava/util/Map;
      // 35: aload 1
      // 36: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 3b: checkcast java/util/Map
      // 3e: astore 3
      // 3f: aload 3
      // 40: ifnonnull a3
      // 43: new java/util/HashMap
      // 46: astore 3
      // 47: aload 3
      // 48: invokespecial java/util/HashMap.<init> ()V
      // 4b: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.n Ljava/util/Map;
      // 4e: aload 1
      // 4f: aload 3
      // 50: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 55: pop
      // 56: aload 3
      // 57: aload 6
      // 59: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 5e: checkcast com/mixpanel/android/mpmetrics/MixpanelAPI
      // 61: astore 4
      // 63: aload 4
      // 65: astore 2
      // 66: aload 4
      // 68: ifnonnull 93
      // 6b: aload 4
      // 6d: astore 2
      // 6e: aload 6
      // 70: invokestatic com/mixpanel/android/mpmetrics/ConfigurationChecker.a (Landroid/content/Context;)Z
      // 73: ifeq 93
      // 76: new com/mixpanel/android/mpmetrics/MixpanelAPI
      // 79: astore 2
      // 7a: aload 2
      // 7b: aload 6
      // 7d: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.q Ljava/util/concurrent/Future;
      // 80: aload 1
      // 81: invokespecial com/mixpanel/android/mpmetrics/MixpanelAPI.<init> (Landroid/content/Context;Ljava/util/concurrent/Future;Ljava/lang/String;)V
      // 84: aload 0
      // 85: aload 2
      // 86: invokestatic com/mixpanel/android/mpmetrics/MixpanelAPI.a (Landroid/content/Context;Lcom/mixpanel/android/mpmetrics/MixpanelAPI;)V
      // 89: aload 3
      // 8a: aload 6
      // 8c: aload 2
      // 8d: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 92: pop
      // 93: aload 0
      // 94: invokestatic com/mixpanel/android/mpmetrics/MixpanelAPI.a (Landroid/content/Context;)V
      // 97: aload 5
      // 99: monitorexit
      // 9a: goto 0e
      // 9d: astore 0
      // 9e: aload 5
      // a0: monitorexit
      // a1: aload 0
      // a2: athrow
      // a3: goto 56
      // try (16 -> 27): 77 null
      // try (27 -> 32): 77 null
      // try (34 -> 43): 77 null
      // try (43 -> 48): 77 null
      // try (54 -> 72): 77 null
      // try (72 -> 76): 77 null
      // try (78 -> 80): 77 null
   }

   private static void a(Context var0) {
      if (var0 instanceof Activity) {
         try {
            Class var1 = Class.forName("bolts.AppLinks");
            Intent var2 = ((Activity)var0).getIntent();
            var1.getMethod("getTargetUrlFromInboundIntent", Context.class, Intent.class).invoke(null, var0, var2);
         } catch (InvocationTargetException var3) {
            MPLog.b("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", var3);
         } catch (ClassNotFoundException var4) {
            MPLog.b("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + var4.getMessage());
         } catch (NoSuchMethodException var5) {
            MPLog.b("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + var5.getMessage());
         } catch (IllegalAccessException var6) {
            MPLog.b("MixpanelAPI.AL", "Unable to detect inbound App Links: " + var6.getMessage());
         }
      } else {
         MPLog.b("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
      }
   }

   private static void a(Context var0, MixpanelAPI var1) {
      try {
         Class var2 = Class.forName("android.support.v4.content.LocalBroadcastManager");
         Method var3 = var2.getMethod("getInstance", Context.class);
         Method var10 = var2.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class);
         Object var11 = var3.invoke(null, var0);
         BroadcastReceiver var8 = new BroadcastReceiver(var1) {
            final MixpanelAPI a;

            {
               this.a = var1;
            }

            public void onReceive(Context var1, Intent var2x) {
               JSONObject var3x = new JSONObject();
               Bundle var4 = var2x.getBundleExtra("event_args");
               if (var4 != null) {
                  for (String var5 : var4.keySet()) {
                     try {
                        var3x.put(var5, var4.get(var5));
                     } catch (JSONException var7) {
                        MPLog.e("MixpanelAPI.AL", "failed to add key \"" + var5 + "\" to properties for tracking bolts event", var7);
                     }
                  }
               }

               this.a.a("$" + var2x.getStringExtra("event_name"), var3x);
            }
         };
         IntentFilter var9 = new IntentFilter("com.parse.bolts.measurement_event");
         var10.invoke(var11, var8, var9);
      } catch (InvocationTargetException var4) {
         MPLog.b(
            "MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", var4
         );
      } catch (ClassNotFoundException var5) {
         MPLog.b("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + var5.getMessage());
      } catch (NoSuchMethodException var6) {
         MPLog.b("MixpanelAPI.AL", "To enable App Links tracking android.support.v4 must be installed: " + var6.getMessage());
      } catch (IllegalAccessException var7) {
         MPLog.b("MixpanelAPI.AL", "App Links tracking will not be enabled due to this exception: " + var7.getMessage());
      }
   }

   static void a(MixpanelAPI.InstanceProcessor param0) {
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
      // 00: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.n Ljava/util/Map;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/mixpanel/android/mpmetrics/MixpanelAPI.n Ljava/util/Map;
      // 09: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 0e: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 13: astore 2
      // 14: aload 2
      // 15: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1a: ifeq 51
      // 1d: aload 2
      // 1e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 23: checkcast java/util/Map
      // 26: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 2b: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 30: astore 3
      // 31: aload 3
      // 32: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 37: ifeq 14
      // 3a: aload 0
      // 3b: aload 3
      // 3c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 41: checkcast com/mixpanel/android/mpmetrics/MixpanelAPI
      // 44: invokeinterface com/mixpanel/android/mpmetrics/MixpanelAPI$InstanceProcessor.a (Lcom/mixpanel/android/mpmetrics/MixpanelAPI;)V 2
      // 49: goto 31
      // 4c: astore 0
      // 4d: aload 1
      // 4e: monitorexit
      // 4f: aload 0
      // 50: athrow
      // 51: aload 1
      // 52: monitorexit
      // 53: return
      // try (4 -> 8): 26 null
      // try (8 -> 17): 26 null
      // try (17 -> 25): 26 null
      // try (27 -> 29): 26 null
      // try (31 -> 33): 26 null
   }

   private void a(JSONArray var1) {
      for (int var2 = 0; var2 < var1.length(); var2++) {
         try {
            JSONObject var4 = var1.getJSONObject(var2);
            AnalyticsMessages var3 = this.b;
            AnalyticsMessages.PeopleDescription var5 = new AnalyticsMessages.PeopleDescription(var4, this.d);
            var3.a(var5);
         } catch (JSONException var6) {
            MPLog.e("MixpanelAPI.API", "Malformed people record stored pending identity, will not send it.", var6);
         }
      }
   }

   private void b(JSONObject var1) {
      if (var1.has("$distinct_id")) {
         this.b.a(new AnalyticsMessages.PeopleDescription(var1, this.d));
      } else {
         this.g.b(var1);
      }
   }

   private void n() {
      JSONArray var1 = this.g.d();
      if (var1 != null) {
         this.a(var1);
      }
   }

   DecideMessages a(String var1, DecideMessages.OnNewResultsListener var2, UpdatesFromMixpanel var3) {
      return new DecideMessages(this.a, var1, var2, var3, this.g.i());
   }

   PersistentIdentity a(Context var1, Future<SharedPreferences> var2, String var3) {
      SharedPreferencesLoader.OnPrefsLoadedListener var5 = new SharedPreferencesLoader.OnPrefsLoadedListener(this) {
         final MixpanelAPI a;

         {
            this.a = var1;
         }

         @Override
         public void a(SharedPreferences var1) {
            JSONArray var2x = PersistentIdentity.a(var1);
            if (var2x != null) {
               this.a.a(var2x);
            }
         }
      };
      String var4 = "com.mixpanel.android.mpmetrics.MixpanelAPI_" + var3;
      Future var7 = o.a(var1, var4, var5);
      var3 = "com.mixpanel.android.mpmetrics.MixpanelAPI.TimeEvents_" + var3;
      return new PersistentIdentity(var2, var7, o.a(var1, var3, null), o.a(var1, "com.mixpanel.android.mpmetrics.Mixpanel", null));
   }

   public void a() {
      this.b.a(new AnalyticsMessages.FlushDescription(this.d));
   }

   public void a(SuperPropertyUpdate var1) {
      this.g.a(var1);
   }

   public void a(String param1) {
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
      // 01: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.g Lcom/mixpanel/android/mpmetrics/PersistentIdentity;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.g Lcom/mixpanel/android/mpmetrics/PersistentIdentity;
      // 0b: aload 1
      // 0c: invokevirtual com/mixpanel/android/mpmetrics/PersistentIdentity.a (Ljava/lang/String;)V
      // 0f: aload 0
      // 10: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.g Lcom/mixpanel/android/mpmetrics/PersistentIdentity;
      // 13: invokevirtual com/mixpanel/android/mpmetrics/PersistentIdentity.c ()Ljava/lang/String;
      // 16: astore 2
      // 17: aload 2
      // 18: astore 1
      // 19: aload 2
      // 1a: ifnonnull 25
      // 1d: aload 0
      // 1e: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.g Lcom/mixpanel/android/mpmetrics/PersistentIdentity;
      // 21: invokevirtual com/mixpanel/android/mpmetrics/PersistentIdentity.b ()Ljava/lang/String;
      // 24: astore 1
      // 25: aload 0
      // 26: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.j Lcom/mixpanel/android/mpmetrics/DecideMessages;
      // 29: aload 1
      // 2a: invokevirtual com/mixpanel/android/mpmetrics/DecideMessages.a (Ljava/lang/String;)V
      // 2d: aload 3
      // 2e: monitorexit
      // 2f: return
      // 30: astore 1
      // 31: aload 3
      // 32: monitorexit
      // 33: aload 1
      // 34: athrow
      // try (5 -> 13): 28 null
      // try (17 -> 21): 28 null
      // try (21 -> 27): 28 null
      // try (29 -> 31): 28 null
   }

   public void a(String var1, String var2) {
      String var3 = var2;
      if (var2 == null) {
         var3 = this.b();
      }

      if (var1.equals(var3)) {
         MPLog.d("MixpanelAPI.API", "Attempted to alias identical distinct_ids " + var1 + ". Alias message will not be sent.");
      } else {
         try {
            JSONObject var5 = new JSONObject();
            var5.put("alias", var1);
            var5.put("original", var3);
            this.a("$create_alias", var5);
         } catch (JSONException var4) {
            MPLog.e("MixpanelAPI.API", "Failed to alias", var4);
         }

         this.a();
      }
   }

   public void a(String var1, JSONObject var2) {
      this.a(var1, var2, false);
   }

   protected void a(String param1, JSONObject param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: iload 3
      // 001: ifeq 00f
      // 004: aload 0
      // 005: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.j Lcom/mixpanel/android/mpmetrics/DecideMessages;
      // 008: invokevirtual com/mixpanel/android/mpmetrics/DecideMessages.e ()Z
      // 00b: ifne 00f
      // 00e: return
      // 00f: aload 0
      // 010: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.l Ljava/util/Map;
      // 013: astore 6
      // 015: aload 6
      // 017: monitorenter
      // 018: aload 0
      // 019: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.l Ljava/util/Map;
      // 01c: aload 1
      // 01d: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 022: checkcast java/lang/Long
      // 025: astore 7
      // 027: aload 0
      // 028: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.l Ljava/util/Map;
      // 02b: aload 1
      // 02c: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 031: pop
      // 032: aload 0
      // 033: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.g Lcom/mixpanel/android/mpmetrics/PersistentIdentity;
      // 036: aload 1
      // 037: invokevirtual com/mixpanel/android/mpmetrics/PersistentIdentity.d (Ljava/lang/String;)V
      // 03a: aload 6
      // 03c: monitorexit
      // 03d: new org/json/JSONObject
      // 040: astore 6
      // 042: aload 6
      // 044: invokespecial org/json/JSONObject.<init> ()V
      // 047: aload 0
      // 048: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.g Lcom/mixpanel/android/mpmetrics/PersistentIdentity;
      // 04b: invokevirtual com/mixpanel/android/mpmetrics/PersistentIdentity.a ()Ljava/util/Map;
      // 04e: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 053: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 058: astore 9
      // 05a: aload 9
      // 05c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 061: ifeq 0b2
      // 064: aload 9
      // 066: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 06b: checkcast java/util/Map$Entry
      // 06e: astore 8
      // 070: aload 6
      // 072: aload 8
      // 074: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 079: checkcast java/lang/String
      // 07c: aload 8
      // 07e: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 083: checkcast java/lang/String
      // 086: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 089: pop
      // 08a: goto 05a
      // 08d: astore 2
      // 08e: ldc_w "MixpanelAPI.API"
      // 091: new java/lang/StringBuilder
      // 094: dup
      // 095: invokespecial java/lang/StringBuilder.<init> ()V
      // 098: ldc_w "Exception tracking event "
      // 09b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 09e: aload 1
      // 09f: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a2: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0a5: aload 2
      // 0a6: invokestatic com/mixpanel/android/util/MPLog.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0a9: goto 00e
      // 0ac: astore 1
      // 0ad: aload 6
      // 0af: monitorexit
      // 0b0: aload 1
      // 0b1: athrow
      // 0b2: aload 0
      // 0b3: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.g Lcom/mixpanel/android/mpmetrics/PersistentIdentity;
      // 0b6: aload 6
      // 0b8: invokevirtual com/mixpanel/android/mpmetrics/PersistentIdentity.a (Lorg/json/JSONObject;)V
      // 0bb: invokestatic java/lang/System.currentTimeMillis ()J
      // 0be: l2d
      // 0bf: ldc2_w 1000.0
      // 0c2: ddiv
      // 0c3: dstore 4
      // 0c5: aload 6
      // 0c7: ldc_w "time"
      // 0ca: dload 4
      // 0cc: d2l
      // 0cd: invokevirtual org/json/JSONObject.put (Ljava/lang/String;J)Lorg/json/JSONObject;
      // 0d0: pop
      // 0d1: aload 6
      // 0d3: ldc_w "distinct_id"
      // 0d6: aload 0
      // 0d7: invokevirtual com/mixpanel/android/mpmetrics/MixpanelAPI.b ()Ljava/lang/String;
      // 0da: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 0dd: pop
      // 0de: aload 7
      // 0e0: ifnull 0f9
      // 0e3: aload 6
      // 0e5: ldc_w "$duration"
      // 0e8: dload 4
      // 0ea: aload 7
      // 0ec: invokevirtual java/lang/Long.longValue ()J
      // 0ef: l2d
      // 0f0: ldc2_w 1000.0
      // 0f3: ddiv
      // 0f4: dsub
      // 0f5: invokevirtual org/json/JSONObject.put (Ljava/lang/String;D)Lorg/json/JSONObject;
      // 0f8: pop
      // 0f9: aload 2
      // 0fa: ifnull 12a
      // 0fd: aload 2
      // 0fe: invokevirtual org/json/JSONObject.keys ()Ljava/util/Iterator;
      // 101: astore 7
      // 103: aload 7
      // 105: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 10a: ifeq 12a
      // 10d: aload 7
      // 10f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 114: checkcast java/lang/String
      // 117: astore 8
      // 119: aload 6
      // 11b: aload 8
      // 11d: aload 2
      // 11e: aload 8
      // 120: invokevirtual org/json/JSONObject.get (Ljava/lang/String;)Ljava/lang/Object;
      // 123: invokevirtual org/json/JSONObject.put (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      // 126: pop
      // 127: goto 103
      // 12a: new com/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription
      // 12d: astore 2
      // 12e: aload 2
      // 12f: aload 1
      // 130: aload 6
      // 132: aload 0
      // 133: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.d Ljava/lang/String;
      // 136: iload 3
      // 137: invokespecial com/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription.<init> (Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Z)V
      // 13a: aload 0
      // 13b: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.b Lcom/mixpanel/android/mpmetrics/AnalyticsMessages;
      // 13e: aload 2
      // 13f: invokevirtual com/mixpanel/android/mpmetrics/AnalyticsMessages.a (Lcom/mixpanel/android/mpmetrics/AnalyticsMessages$EventDescription;)V
      // 142: aload 0
      // 143: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.i Lcom/mixpanel/android/viewcrawler/TrackingDebug;
      // 146: ifnull 00e
      // 149: aload 0
      // 14a: getfield com/mixpanel/android/mpmetrics/MixpanelAPI.i Lcom/mixpanel/android/viewcrawler/TrackingDebug;
      // 14d: aload 1
      // 14e: invokeinterface com/mixpanel/android/viewcrawler/TrackingDebug.a (Ljava/lang/String;)V 2
      // 153: goto 00e
      // try (12 -> 29): 69 null
      // try (29 -> 39): 56 org/json/JSONException
      // try (39 -> 55): 56 org/json/JSONException
      // try (70 -> 72): 69 null
      // try (74 -> 95): 56 org/json/JSONException
      // try (97 -> 108): 56 org/json/JSONException
      // try (110 -> 113): 56 org/json/JSONException
      // try (113 -> 127): 56 org/json/JSONException
      // try (128 -> 148): 56 org/json/JSONException
   }

   public void a(JSONObject var1) {
      this.g.c(var1);
   }

   UpdatesFromMixpanel b(Context var1, String var2) {
      UpdatesFromMixpanel var3;
      if (VERSION.SDK_INT < 16) {
         MPLog.c("MixpanelAPI.API", "SDK version is lower than 16. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
         var3 = new MixpanelAPI.NoOpUpdatesFromMixpanel(this, p);
      } else if (!this.c.h() && !Arrays.asList(this.c.i()).contains(var2)) {
         var3 = new ViewCrawler(this.a, this.d, this, p);
      } else {
         MPLog.c("MixpanelAPI.API", "DisableViewCrawler is set to true. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
         var3 = new MixpanelAPI.NoOpUpdatesFromMixpanel(this, p);
      }

      return var3;
   }

   public String b() {
      return this.g.b();
   }

   public void b(String var1) {
      this.a(var1, (JSONObject)null);
   }

   public MixpanelAPI.People c() {
      return this.e;
   }

   public void d() {
      this.g.e();
      this.a(this.b());
      this.a();
   }

   public Map<String, String> e() {
      return this.k;
   }

   @TargetApi(14)
   void f() {
      if (VERSION.SDK_INT >= 14) {
         if (this.a.getApplicationContext() instanceof Application) {
            Application var1 = (Application)this.a.getApplicationContext();
            this.m = new MixpanelActivityLifecycleCallbacks(this, this.c);
            var1.registerActivityLifecycleCallbacks(this.m);
         } else {
            MPLog.c(
               "MixpanelAPI.API",
               "Context is not an Application, Mixpanel will not automatically show in-app notifications or A/B test experiments. We won't be able to automatically flush on an app background."
            );
         }
      }
   }

   public boolean g() {
      if (VERSION.SDK_INT >= 14) {
         if (this.m != null) {
            return this.m.a();
         }
      } else {
         MPLog.e("MixpanelAPI.API", "Your build version is below 14. This method will always return false.");
      }

      return false;
   }

   void h() {
      this.a();
      this.f.b();
   }

   AnalyticsMessages i() {
      return AnalyticsMessages.a(this.a);
   }

   MixpanelAPI.UpdatesListener j() {
      MixpanelAPI.UpdatesListener var1;
      if (VERSION.SDK_INT < 16) {
         MPLog.c("MixpanelAPI.API", "Notifications are not supported on this Android OS Version");
         var1 = new MixpanelAPI.UnsupportedUpdatesListener(this);
      } else {
         var1 = new MixpanelAPI.SupportedUpdatesListener(this);
      }

      return var1;
   }

   TrackingDebug k() {
      TrackingDebug var1;
      if (this.f instanceof ViewCrawler) {
         var1 = (TrackingDebug)this.f;
      } else {
         var1 = null;
      }

      return var1;
   }

   boolean l() {
      boolean var1;
      if (!this.c.g()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected void m() {
      this.b.a(new AnalyticsMessages.FlushDescription(this.d, false));
   }

   interface InstanceProcessor {
      void a(MixpanelAPI var1);
   }

   class NoOpUpdatesFromMixpanel implements UpdatesFromMixpanel {
      final MixpanelAPI a;
      private final Tweaks b;

      public NoOpUpdatesFromMixpanel(MixpanelAPI var1, Tweaks var2) {
         this.a = var1;
         this.b = var2;
      }

      @Override
      public void a() {
      }

      @Override
      public void a(JSONArray var1) {
      }

      @Override
      public void b() {
      }

      @Override
      public void b(JSONArray var1) {
      }

      @Override
      public void c(JSONArray var1) {
      }
   }

   public interface People {
      void a();

      void a(double var1, JSONObject var3);

      void a(Activity var1);

      void a(String var1);

      void a(String var1, double var2);

      void a(String var1, InAppNotification var2, JSONObject var3);

      void a(String var1, Object var2);

      void a(String var1, JSONObject var2);

      void a(JSONObject var1);

      void b();

      void b(String var1);

      void b(String var1, Object var2);

      MixpanelAPI.People c(String var1);
   }

// $VF: Couldn't be decompiled
// Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
// java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.modules.decompiler.stats.Statement.getVarDefinitions()" because "stat" is null
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1592)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingExprent(VarDefinitionHelper.java:1891)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingExprent(VarDefinitionHelper.java:2029)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1619)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1739)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1739)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.iterateClashingNames(VarDefinitionHelper.java:1739)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarDefinitionHelper.remapClashingNames(VarDefinitionHelper.java:1584)
//   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarProcessor.rerunClashing(VarProcessor.java:99)
//   at org.jetbrains.java.decompiler.main.ClassWriter.invokeProcessors(ClassWriter.java:145)
//   at org.jetbrains.java.decompiler.main.ClassWriter.writeClass(ClassWriter.java:379)
//   at org.jetbrains.java.decompiler.main.ClassWriter.writeClass(ClassWriter.java:520)
//   at org.jetbrains.java.decompiler.main.ClassesProcessor.writeClass(ClassesProcessor.java:521)
//   at org.jetbrains.java.decompiler.main.Fernflower.getClassContent(Fernflower.java:200)
//   at org.jetbrains.java.decompiler.struct.ContextUnit.lambda$save$3(ContextUnit.java:221)

   private class SupportedUpdatesListener implements MixpanelAPI.UpdatesListener, Runnable {
      final MixpanelAPI a;
      private final Set<OnMixpanelUpdatesReceivedListener> b;
      private final Executor c;

      private SupportedUpdatesListener(MixpanelAPI var1) {
         this.a = var1;
         this.b = Collections.newSetFromMap(new ConcurrentHashMap<>());
         this.c = Executors.newSingleThreadExecutor();
      }

      @Override
      public void a() {
         this.c.execute(this);
      }

      @Override
      public void run() {
         Iterator var1 = this.b.iterator();

         while (var1.hasNext()) {
            ((OnMixpanelUpdatesReceivedListener)var1.next()).a();
         }
      }
   }

   private class UnsupportedUpdatesListener implements MixpanelAPI.UpdatesListener {
      final MixpanelAPI a;

      private UnsupportedUpdatesListener(MixpanelAPI var1) {
         this.a = var1;
      }

      @Override
      public void a() {
      }
   }

   private interface UpdatesListener extends DecideMessages.OnNewResultsListener {
   }
}
