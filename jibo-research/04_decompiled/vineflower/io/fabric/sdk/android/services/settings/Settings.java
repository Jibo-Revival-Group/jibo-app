package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Settings {
   private final AtomicReference<SettingsData> a = new AtomicReference<>();
   private final CountDownLatch b = new CountDownLatch(1);
   private SettingsController c;
   private boolean d = false;

   private Settings() {
   }

   public static Settings a() {
      return Settings.LazyHolder.a;
   }

   private void a(SettingsData var1) {
      this.a.set(var1);
      this.b.countDown();
   }

   public Settings a(Kit param1, IdManager param2, HttpRequestFactory param3, String param4, String param5, String param6) {
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
      // 000: aload 0
      // 001: monitorenter
      // 002: aload 0
      // 003: getfield io/fabric/sdk/android/services/settings/Settings.d Z
      // 006: istore 8
      // 008: iload 8
      // 00a: ifeq 011
      // 00d: aload 0
      // 00e: monitorexit
      // 00f: aload 0
      // 010: areturn
      // 011: aload 0
      // 012: getfield io/fabric/sdk/android/services/settings/Settings.c Lio/fabric/sdk/android/services/settings/SettingsController;
      // 015: ifnonnull 0fb
      // 018: aload 1
      // 019: invokevirtual io/fabric/sdk/android/Kit.r ()Landroid/content/Context;
      // 01c: astore 16
      // 01e: aload 2
      // 01f: invokevirtual io/fabric/sdk/android/services/common/IdManager.c ()Ljava/lang/String;
      // 022: astore 14
      // 024: new io/fabric/sdk/android/services/common/ApiKey
      // 027: astore 9
      // 029: aload 9
      // 02b: invokespecial io/fabric/sdk/android/services/common/ApiKey.<init> ()V
      // 02e: aload 9
      // 030: aload 16
      // 032: invokevirtual io/fabric/sdk/android/services/common/ApiKey.a (Landroid/content/Context;)Ljava/lang/String;
      // 035: astore 13
      // 037: aload 2
      // 038: invokevirtual io/fabric/sdk/android/services/common/IdManager.j ()Ljava/lang/String;
      // 03b: astore 15
      // 03d: new io/fabric/sdk/android/services/common/SystemCurrentTimeProvider
      // 040: astore 11
      // 042: aload 11
      // 044: invokespecial io/fabric/sdk/android/services/common/SystemCurrentTimeProvider.<init> ()V
      // 047: new io/fabric/sdk/android/services/settings/DefaultSettingsJsonTransform
      // 04a: astore 10
      // 04c: aload 10
      // 04e: invokespecial io/fabric/sdk/android/services/settings/DefaultSettingsJsonTransform.<init> ()V
      // 051: new io/fabric/sdk/android/services/settings/DefaultCachedSettingsIo
      // 054: astore 9
      // 056: aload 9
      // 058: aload 1
      // 059: invokespecial io/fabric/sdk/android/services/settings/DefaultCachedSettingsIo.<init> (Lio/fabric/sdk/android/Kit;)V
      // 05c: aload 16
      // 05e: invokestatic io/fabric/sdk/android/services/common/CommonUtils.k (Landroid/content/Context;)Ljava/lang/String;
      // 061: astore 12
      // 063: getstatic java/util/Locale.US Ljava/util/Locale;
      // 066: ldc "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings"
      // 068: bipush 1
      // 069: anewarray 4
      // 06c: dup
      // 06d: bipush 0
      // 06e: aload 14
      // 070: aastore
      // 071: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 074: astore 17
      // 076: new io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall
      // 079: astore 14
      // 07b: aload 14
      // 07d: aload 1
      // 07e: aload 6
      // 080: aload 17
      // 082: aload 3
      // 083: invokespecial io/fabric/sdk/android/services/settings/DefaultSettingsSpiCall.<init> (Lio/fabric/sdk/android/Kit;Ljava/lang/String;Ljava/lang/String;Lio/fabric/sdk/android/services/network/HttpRequestFactory;)V
      // 086: aload 2
      // 087: invokevirtual io/fabric/sdk/android/services/common/IdManager.g ()Ljava/lang/String;
      // 08a: astore 6
      // 08c: aload 2
      // 08d: invokevirtual io/fabric/sdk/android/services/common/IdManager.f ()Ljava/lang/String;
      // 090: astore 3
      // 091: aload 2
      // 092: invokevirtual io/fabric/sdk/android/services/common/IdManager.e ()Ljava/lang/String;
      // 095: astore 17
      // 097: aload 2
      // 098: invokevirtual io/fabric/sdk/android/services/common/IdManager.m ()Ljava/lang/String;
      // 09b: astore 18
      // 09d: aload 2
      // 09e: invokevirtual io/fabric/sdk/android/services/common/IdManager.b ()Ljava/lang/String;
      // 0a1: astore 19
      // 0a3: aload 2
      // 0a4: invokevirtual io/fabric/sdk/android/services/common/IdManager.n ()Ljava/lang/String;
      // 0a7: astore 2
      // 0a8: bipush 1
      // 0a9: anewarray 99
      // 0ac: dup
      // 0ad: bipush 0
      // 0ae: aload 16
      // 0b0: invokestatic io/fabric/sdk/android/services/common/CommonUtils.m (Landroid/content/Context;)Ljava/lang/String;
      // 0b3: aastore
      // 0b4: invokestatic io/fabric/sdk/android/services/common/CommonUtils.a ([Ljava/lang/String;)Ljava/lang/String;
      // 0b7: astore 16
      // 0b9: aload 15
      // 0bb: invokestatic io/fabric/sdk/android/services/common/DeliveryMechanism.determineFrom (Ljava/lang/String;)Lio/fabric/sdk/android/services/common/DeliveryMechanism;
      // 0be: invokevirtual io/fabric/sdk/android/services/common/DeliveryMechanism.getId ()I
      // 0c1: istore 7
      // 0c3: new io/fabric/sdk/android/services/settings/SettingsRequest
      // 0c6: astore 15
      // 0c8: aload 15
      // 0ca: aload 13
      // 0cc: aload 6
      // 0ce: aload 3
      // 0cf: aload 17
      // 0d1: aload 18
      // 0d3: aload 19
      // 0d5: aload 2
      // 0d6: aload 16
      // 0d8: aload 5
      // 0da: aload 4
      // 0dc: iload 7
      // 0de: aload 12
      // 0e0: invokespecial io/fabric/sdk/android/services/settings/SettingsRequest.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
      // 0e3: new io/fabric/sdk/android/services/settings/DefaultSettingsController
      // 0e6: astore 2
      // 0e7: aload 2
      // 0e8: aload 1
      // 0e9: aload 15
      // 0eb: aload 11
      // 0ed: aload 10
      // 0ef: aload 9
      // 0f1: aload 14
      // 0f3: invokespecial io/fabric/sdk/android/services/settings/DefaultSettingsController.<init> (Lio/fabric/sdk/android/Kit;Lio/fabric/sdk/android/services/settings/SettingsRequest;Lio/fabric/sdk/android/services/common/CurrentTimeProvider;Lio/fabric/sdk/android/services/settings/SettingsJsonTransform;Lio/fabric/sdk/android/services/settings/CachedSettingsIo;Lio/fabric/sdk/android/services/settings/SettingsSpiCall;)V
      // 0f6: aload 0
      // 0f7: aload 2
      // 0f8: putfield io/fabric/sdk/android/services/settings/Settings.c Lio/fabric/sdk/android/services/settings/SettingsController;
      // 0fb: aload 0
      // 0fc: bipush 1
      // 0fd: putfield io/fabric/sdk/android/services/settings/Settings.d Z
      // 100: goto 00d
      // 103: astore 1
      // 104: aload 0
      // 105: monitorexit
      // 106: aload 1
      // 107: athrow
      // try (2 -> 5): 129 null
      // try (11 -> 125): 129 null
      // try (125 -> 128): 129 null
   }

   public SettingsData b() {
      SettingsData var1;
      try {
         this.b.await();
         var1 = this.a.get();
      } catch (InterruptedException var2) {
         Fabric.h().e("Fabric", "Interrupted while waiting for settings data.");
         var1 = null;
      }

      return var1;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean c() {
      synchronized (this){} // $VF: monitorenter 
      boolean var4 = false /* VF: Semaphore variable */;

      SettingsData var2;
      try {
         var4 = true;
         var2 = this.c.a();
         this.a(var2);
         var4 = false;
      } finally {
         if (var4) {
            // $VF: monitorexit
         }
      }

      boolean var1;
      if (var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      // $VF: monitorexit
      return var1;
   }

   public boolean d() {
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
      // 00: aload 0
      // 01: monitorenter
      // 02: aload 0
      // 03: getfield io/fabric/sdk/android/services/settings/Settings.c Lio/fabric/sdk/android/services/settings/SettingsController;
      // 06: getstatic io/fabric/sdk/android/services/settings/SettingsCacheBehavior.SKIP_CACHE_LOOKUP Lio/fabric/sdk/android/services/settings/SettingsCacheBehavior;
      // 09: invokeinterface io/fabric/sdk/android/services/settings/SettingsController.a (Lio/fabric/sdk/android/services/settings/SettingsCacheBehavior;)Lio/fabric/sdk/android/services/settings/SettingsData; 2
      // 0e: astore 2
      // 0f: aload 0
      // 10: aload 2
      // 11: invokespecial io/fabric/sdk/android/services/settings/Settings.a (Lio/fabric/sdk/android/services/settings/SettingsData;)V
      // 14: aload 2
      // 15: ifnonnull 25
      // 18: invokestatic io/fabric/sdk/android/Fabric.h ()Lio/fabric/sdk/android/Logger;
      // 1b: ldc "Fabric"
      // 1d: ldc "Failed to force reload of settings from Crashlytics."
      // 1f: aconst_null
      // 20: invokeinterface io/fabric/sdk/android/Logger.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V 4
      // 25: aload 2
      // 26: ifnull 2f
      // 29: bipush 1
      // 2a: istore 1
      // 2b: aload 0
      // 2c: monitorexit
      // 2d: iload 1
      // 2e: ireturn
      // 2f: bipush 0
      // 30: istore 1
      // 31: goto 2b
      // 34: astore 2
      // 35: aload 0
      // 36: monitorexit
      // 37: aload 2
      // 38: athrow
      // try (2 -> 10): 28 null
      // try (12 -> 17): 28 null
   }

   static class LazyHolder {
      private static final Settings a = new Settings();
   }
}
