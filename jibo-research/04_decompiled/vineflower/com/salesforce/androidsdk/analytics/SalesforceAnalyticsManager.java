package com.salesforce.androidsdk.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.analytics.manager.AnalyticsManager;
import com.salesforce.androidsdk.analytics.model.DeviceAppAttributes;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import com.salesforce.androidsdk.analytics.store.EventStoreManager;
import com.salesforce.androidsdk.analytics.transform.AILTNTransform;
import com.salesforce.androidsdk.analytics.transform.Transform;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.config.AdminSettingsManager;
import com.salesforce.androidsdk.config.BootConfig;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SalesforceAnalyticsManager {
   private static Map<String, SalesforceAnalyticsManager> a;
   private static boolean b;
   private static ScheduledFuture c;
   private static int d = 8;
   private AnalyticsManager e;
   private EventStoreManager f;
   private UserAccount g;
   private boolean h;
   private Map<Class<? extends Transform>, Class<? extends AnalyticsPublisher>> i;

   private SalesforceAnalyticsManager(UserAccount var1, String var2) {
      this.g = var1;
      DeviceAppAttributes var3 = this.d();
      SalesforceSDKManager var4 = SalesforceSDKManager.a();
      this.e = new AnalyticsManager(var1.v(), var4.k(), var4.c(var4.t()), var3);
      this.f = this.e.d();
      this.i = new HashMap<>();
      this.i.put(AILTNTransform.class, AILTNPublisher.class);
      this.e();
      this.a(this.h);
   }

   public static SalesforceAnalyticsManager a(UserAccount var0) {
      synchronized (SalesforceAnalyticsManager.class) {
         return a(var0, null);
      }
   }

   public static SalesforceAnalyticsManager a(UserAccount param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 3
      // 02: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 04: monitorenter
      // 05: aload 0
      // 06: astore 2
      // 07: aload 0
      // 08: ifnonnull 15
      // 0b: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 0e: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.o ()Lcom/salesforce/androidsdk/accounts/UserAccountManager;
      // 11: invokevirtual com/salesforce/androidsdk/accounts/UserAccountManager.b ()Lcom/salesforce/androidsdk/accounts/UserAccount;
      // 14: astore 2
      // 15: aload 2
      // 16: ifnonnull 20
      // 19: aload 3
      // 1a: astore 1
      // 1b: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 1d: monitorexit
      // 1e: aload 1
      // 1f: areturn
      // 20: aload 2
      // 21: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.g ()Ljava/lang/String;
      // 24: astore 0
      // 25: aload 1
      // 26: astore 3
      // 27: ldc "000000000000000AAA"
      // 29: aload 1
      // 2a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2d: ifeq 32
      // 30: aconst_null
      // 31: astore 3
      // 32: aload 0
      // 33: astore 4
      // 35: aload 3
      // 36: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 39: ifne 52
      // 3c: new java/lang/StringBuilder
      // 3f: astore 1
      // 40: aload 1
      // 41: invokespecial java/lang/StringBuilder.<init> ()V
      // 44: aload 1
      // 45: aload 0
      // 46: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 49: aload 3
      // 4a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4d: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 50: astore 4
      // 52: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 55: ifnonnull b3
      // 58: new java/util/HashMap
      // 5b: astore 0
      // 5c: aload 0
      // 5d: invokespecial java/util/HashMap.<init> ()V
      // 60: aload 0
      // 61: putstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 64: new com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 67: astore 1
      // 68: aload 1
      // 69: aload 2
      // 6a: aload 3
      // 6b: invokespecial com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.<init> (Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
      // 6e: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 71: aload 4
      // 73: aload 1
      // 74: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 79: pop
      // 7a: aload 1
      // 7b: astore 0
      // 7c: aload 1
      // 7d: ifnonnull 96
      // 80: new com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 83: astore 0
      // 84: aload 0
      // 85: aload 2
      // 86: aload 3
      // 87: invokespecial com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.<init> (Lcom/salesforce/androidsdk/accounts/UserAccount;Ljava/lang/String;)V
      // 8a: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 8d: aload 4
      // 8f: aload 0
      // 90: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 95: pop
      // 96: aload 0
      // 97: astore 1
      // 98: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.b Z
      // 9b: ifne 1b
      // 9e: invokestatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.g ()Ljava/util/concurrent/ScheduledFuture;
      // a1: putstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.c Ljava/util/concurrent/ScheduledFuture;
      // a4: bipush 1
      // a5: putstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.b Z
      // a8: aload 0
      // a9: astore 1
      // aa: goto 1b
      // ad: astore 0
      // ae: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // b0: monitorexit
      // b1: aload 0
      // b2: athrow
      // b3: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // b6: aload 4
      // b8: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // bd: checkcast com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // c0: astore 1
      // c1: goto 7a
      // try (8 -> 12): 92 null
      // try (20 -> 23): 92 null
      // try (25 -> 29): 92 null
      // try (33 -> 47): 92 null
      // try (47 -> 66): 92 null
      // try (70 -> 81): 92 null
      // try (83 -> 89): 92 null
      // try (97 -> 102): 92 null
   }

   public static void a(String param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 02: monitorenter
      // 03: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 06: astore 2
      // 07: aload 2
      // 08: aload 0
      // 09: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.c (Ljava/lang/String;)Ljava/lang/String;
      // 0c: astore 0
      // 0d: aload 2
      // 0e: aload 1
      // 0f: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.c (Ljava/lang/String;)Ljava/lang/String;
      // 12: astore 1
      // 13: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 16: ifnull 63
      // 19: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 1c: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 21: astore 2
      // 22: aload 2
      // 23: ifnull 63
      // 26: aload 2
      // 27: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 2c: astore 2
      // 2d: aload 2
      // 2e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 33: ifeq 63
      // 36: aload 2
      // 37: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3c: checkcast java/lang/String
      // 3f: astore 3
      // 40: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 43: aload 3
      // 44: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 49: checkcast com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 4c: astore 3
      // 4d: aload 3
      // 4e: ifnull 2d
      // 51: aload 3
      // 52: getfield com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.e Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;
      // 55: aload 0
      // 56: aload 1
      // 57: invokevirtual com/salesforce/androidsdk/analytics/manager/AnalyticsManager.a (Ljava/lang/String;Ljava/lang/String;)V
      // 5a: goto 2d
      // 5d: astore 0
      // 5e: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 60: monitorexit
      // 61: aload 0
      // 62: athrow
      // 63: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 65: monitorexit
      // 66: return
      // try (2 -> 17): 42 null
      // try (19 -> 22): 42 null
      // try (22 -> 34): 42 null
      // try (36 -> 41): 42 null
   }

   public static void b(UserAccount var0) {
      synchronized (SalesforceAnalyticsManager.class) {
         b(var0, null);
      }
   }

   public static void b(UserAccount param0, String param1) {
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
      // 00: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 02: monitorenter
      // 03: aload 0
      // 04: astore 2
      // 05: aload 0
      // 06: ifnonnull 13
      // 09: invokestatic com/salesforce/androidsdk/app/SalesforceSDKManager.a ()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;
      // 0c: invokevirtual com/salesforce/androidsdk/app/SalesforceSDKManager.o ()Lcom/salesforce/androidsdk/accounts/UserAccountManager;
      // 0f: invokevirtual com/salesforce/androidsdk/accounts/UserAccountManager.b ()Lcom/salesforce/androidsdk/accounts/UserAccount;
      // 12: astore 2
      // 13: aload 2
      // 14: ifnull 71
      // 17: aload 2
      // 18: invokevirtual com/salesforce/androidsdk/accounts/UserAccount.g ()Ljava/lang/String;
      // 1b: astore 2
      // 1c: aload 1
      // 1d: astore 0
      // 1e: ldc "000000000000000AAA"
      // 20: aload 1
      // 21: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 24: ifeq 29
      // 27: aconst_null
      // 28: astore 0
      // 29: aload 0
      // 2a: invokestatic android/text/TextUtils.isEmpty (Ljava/lang/CharSequence;)Z
      // 2d: ifne 7b
      // 30: new java/lang/StringBuilder
      // 33: astore 1
      // 34: aload 1
      // 35: invokespecial java/lang/StringBuilder.<init> ()V
      // 38: aload 1
      // 39: aload 2
      // 3a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3d: aload 0
      // 3e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 41: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 44: astore 0
      // 45: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 48: ifnull 71
      // 4b: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 4e: aload 0
      // 4f: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 54: checkcast com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 57: astore 1
      // 58: aload 1
      // 59: ifnull 67
      // 5c: aload 1
      // 5d: getfield com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.e Lcom/salesforce/androidsdk/analytics/manager/AnalyticsManager;
      // 60: invokevirtual com/salesforce/androidsdk/analytics/manager/AnalyticsManager.a ()V
      // 63: aload 1
      // 64: invokespecial com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.f ()V
      // 67: getstatic com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.a Ljava/util/Map;
      // 6a: aload 0
      // 6b: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 70: pop
      // 71: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 73: monitorexit
      // 74: return
      // 75: astore 0
      // 76: ldc com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager
      // 78: monitorexit
      // 79: aload 0
      // 7a: athrow
      // 7b: aload 2
      // 7c: astore 0
      // 7d: goto 45
      // try (6 -> 10): 58 null
      // try (12 -> 15): 58 null
      // try (17 -> 21): 58 null
      // try (23 -> 37): 58 null
      // try (37 -> 44): 58 null
      // try (46 -> 51): 58 null
      // try (51 -> 55): 58 null
   }

   private void b(boolean var1) {
      synchronized (this) {
         Context var3 = SalesforceSDKManager.a().k();
         StringBuilder var2 = new StringBuilder();
         Editor var6 = var3.getSharedPreferences(var2.append("ailtn_policy").append(this.g.u()).toString(), 0).edit();
         var6.putBoolean("ailtn_enabled", var1);
         var6.commit();
         this.h = var1;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private DeviceAppAttributes d() {
      SalesforceSDKManager var7 = SalesforceSDKManager.a();
      Context var6 = var7.k();
      String var3 = "";
      String var4 = "";
      String var1 = var3;

      String var2;
      try {
         var2 = var6.getPackageManager().getPackageInfo(var6.getPackageName(), 0).versionName;
      } catch (NameNotFoundException var10) {
         SalesforceSDKLogger.b("AnalyticsManager", "Could not read package info", var10);
         var3 = var4;
         return new DeviceAppAttributes(var1, var3, VERSION.RELEASE, "android", var7.z(), "5.3.0", Build.MODEL, var7.g(), BootConfig.a(var6).a());
      } catch (NotFoundException var11) {
         SalesforceSDKLogger.b("AnalyticsManager", "Could not read package info", var11);
         var1 = var3;
         var3 = var4;
         return new DeviceAppAttributes(var1, var3, VERSION.RELEASE, "android", var7.z(), "5.3.0", Build.MODEL, var7.g(), BootConfig.a(var6).a());
      }

      var1 = var2;
      var3 = var2;

      String var5;
      try {
         var5 = SalesforceSDKManager.c();
      } catch (NameNotFoundException var8) {
         SalesforceSDKLogger.b("AnalyticsManager", "Could not read package info", var8);
         var3 = var4;
         return new DeviceAppAttributes(var1, var3, VERSION.RELEASE, "android", var7.z(), "5.3.0", Build.MODEL, var7.g(), BootConfig.a(var6).a());
      } catch (NotFoundException var9) {
         SalesforceSDKLogger.b("AnalyticsManager", "Could not read package info", var9);
         var1 = var3;
         var3 = var4;
         return new DeviceAppAttributes(var1, var3, VERSION.RELEASE, "android", var7.z(), "5.3.0", Build.MODEL, var7.g(), BootConfig.a(var6).a());
      }

      var3 = var5;
      var1 = var2;
      return new DeviceAppAttributes(var1, var3, VERSION.RELEASE, "android", var7.z(), "5.3.0", Build.MODEL, var7.g(), BootConfig.a(var6).a());
   }

   private void e() {
      SharedPreferences var1 = SalesforceSDKManager.a().k().getSharedPreferences("ailtn_policy" + this.g.u(), 0);
      if (!var1.contains("ailtn_enabled")) {
         this.b(true);
      }

      this.h = var1.getBoolean("ailtn_enabled", true);
   }

   private void f() {
      Editor var1 = SalesforceSDKManager.a().k().getSharedPreferences("ailtn_policy" + this.g.u(), 0).edit();
      var1.clear();
      var1.commit();
   }

   private static ScheduledFuture g() {
      return Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
         @Override
         public void run() {
            AnalyticsPublisherService.a(SalesforceSDKManager.a().k());
         }
      }, 0L, d, TimeUnit.HOURS);
   }

   public AnalyticsManager a() {
      return this.e;
   }

   public void a(List<InstrumentationEvent> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: monitorenter
      // 002: aload 1
      // 003: ifnull 011
      // 006: aload 1
      // 007: invokeinterface java/util/List.size ()I 1
      // 00c: istore 2
      // 00d: iload 2
      // 00e: ifne 014
      // 011: aload 0
      // 012: monitorexit
      // 013: return
      // 014: new java/util/ArrayList
      // 017: astore 7
      // 019: aload 7
      // 01b: invokespecial java/util/ArrayList.<init> ()V
      // 01e: bipush 1
      // 01f: istore 3
      // 020: aload 0
      // 021: getfield com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.i Ljava/util/Map;
      // 024: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 029: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 02e: astore 6
      // 030: aload 6
      // 032: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 037: ifeq 100
      // 03a: aload 6
      // 03c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 041: checkcast java/lang/Class
      // 044: astore 9
      // 046: aload 9
      // 048: invokevirtual java/lang/Class.newInstance ()Ljava/lang/Object;
      // 04b: checkcast com/salesforce/androidsdk/analytics/transform/Transform
      // 04e: astore 5
      // 050: aload 5
      // 052: ifnull 110
      // 055: new org/json/JSONArray
      // 058: astore 8
      // 05a: aload 8
      // 05c: invokespecial org/json/JSONArray.<init> ()V
      // 05f: aload 1
      // 060: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 065: astore 10
      // 067: aload 10
      // 069: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 06e: ifeq 0bd
      // 071: aload 10
      // 073: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 078: checkcast com/salesforce/androidsdk/analytics/model/InstrumentationEvent
      // 07b: astore 11
      // 07d: aload 7
      // 07f: aload 11
      // 081: invokevirtual com/salesforce/androidsdk/analytics/model/InstrumentationEvent.a ()Ljava/lang/String;
      // 084: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 089: pop
      // 08a: aload 5
      // 08c: aload 11
      // 08e: invokeinterface com/salesforce/androidsdk/analytics/transform/Transform.a (Lcom/salesforce/androidsdk/analytics/model/InstrumentationEvent;)Lorg/json/JSONObject; 2
      // 093: astore 11
      // 095: aload 11
      // 097: ifnull 067
      // 09a: aload 8
      // 09c: aload 11
      // 09e: invokevirtual org/json/JSONArray.put (Ljava/lang/Object;)Lorg/json/JSONArray;
      // 0a1: pop
      // 0a2: goto 067
      // 0a5: astore 1
      // 0a6: aload 0
      // 0a7: monitorexit
      // 0a8: aload 1
      // 0a9: athrow
      // 0aa: astore 5
      // 0ac: ldc_w "AnalyticsManager"
      // 0af: ldc_w "Exception thrown while instantiating class"
      // 0b2: aload 5
      // 0b4: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0b7: aconst_null
      // 0b8: astore 5
      // 0ba: goto 050
      // 0bd: aload 0
      // 0be: getfield com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.i Ljava/util/Map;
      // 0c1: aload 9
      // 0c3: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c8: checkcast java/lang/Class
      // 0cb: invokevirtual java/lang/Class.newInstance ()Ljava/lang/Object;
      // 0ce: checkcast com/salesforce/androidsdk/analytics/AnalyticsPublisher
      // 0d1: astore 5
      // 0d3: aload 5
      // 0d5: ifnull 110
      // 0d8: aload 5
      // 0da: aload 8
      // 0dc: invokeinterface com/salesforce/androidsdk/analytics/AnalyticsPublisher.a (Lorg/json/JSONArray;)Z 2
      // 0e1: istore 4
      // 0e3: iload 3
      // 0e4: ifeq 110
      // 0e7: iload 4
      // 0e9: istore 3
      // 0ea: goto 030
      // 0ed: astore 5
      // 0ef: ldc_w "AnalyticsManager"
      // 0f2: ldc_w "Exception thrown while instantiating class"
      // 0f5: aload 5
      // 0f7: invokestatic com/salesforce/androidsdk/util/SalesforceSDKLogger.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0fa: aconst_null
      // 0fb: astore 5
      // 0fd: goto 0d3
      // 100: iload 3
      // 101: ifeq 011
      // 104: aload 0
      // 105: getfield com/salesforce/androidsdk/analytics/SalesforceAnalyticsManager.f Lcom/salesforce/androidsdk/analytics/store/EventStoreManager;
      // 108: aload 7
      // 10a: invokevirtual com/salesforce/androidsdk/analytics/store/EventStoreManager.b (Ljava/util/List;)V
      // 10d: goto 011
      // 110: goto 0ea
      // try (4 -> 7): 66 null
      // try (12 -> 16): 66 null
      // try (18 -> 23): 66 null
      // try (23 -> 30): 66 null
      // try (30 -> 34): 71 java/lang/Exception
      // try (30 -> 34): 66 null
      // try (36 -> 43): 66 null
      // try (43 -> 59): 66 null
      // try (61 -> 65): 66 null
      // try (72 -> 76): 66 null
      // try (79 -> 87): 98 java/lang/Exception
      // try (79 -> 87): 66 null
      // try (89 -> 93): 66 null
      // try (99 -> 103): 66 null
      // try (108 -> 112): 66 null
   }

   public void a(boolean var1) {
      if (var1) {
         SalesforceSDKManager.a().e("AI");
      } else {
         SalesforceSDKManager.a().f("AI");
      }

      this.b(var1);
      this.f.a(var1);
   }

   public void b() {
      String var1 = new AdminSettingsManager().a("ailtn_enabled", this.g);
      if (!TextUtils.isEmpty(var1)) {
         if (!Boolean.parseBoolean(var1)) {
            this.a(false);
         } else {
            this.a(true);
         }
      }
   }

   public void c() {
      synchronized (this) {
         this.a(this.f.a());
      }
   }
}
