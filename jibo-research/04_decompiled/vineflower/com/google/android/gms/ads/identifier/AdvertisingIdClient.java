package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.zzf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzfo;
import com.google.android.gms.internal.zzfp;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
   private final Context mContext;
   private com.google.android.gms.common.zza zzamu;
   private zzfo zzamv;
   private boolean zzamw;
   private Object zzamx = new Object();
   private AdvertisingIdClient.zza zzamy;
   private boolean zzamz;
   private long zzana;

   public AdvertisingIdClient(Context var1) {
      this(var1, 30000L, false, false);
   }

   public AdvertisingIdClient(Context var1, long var2, boolean var4, boolean var5) {
      zzbq.a(var1);
      if (var4) {
         Context var6 = var1.getApplicationContext();
         if (var6 != null) {
            var1 = var6;
         }

         this.mContext = var1;
      } else {
         this.mContext = var1;
      }

      this.zzamw = false;
      this.zzana = var2;
      this.zzamz = var5;
   }

   public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context var0) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      zzb var6 = new zzb(var0);
      boolean var2 = var6.a("gads:ad_id_app_context:enabled", false);
      float var1 = var6.a("gads:ad_id_app_context:ping_ratio", 0.0F);
      String var5 = var6.a("gads:ad_id_use_shared_preference:experiment_id", "");
      AdvertisingIdClient var11 = new AdvertisingIdClient(var0, -1L, var2, var6.a("gads:ad_id_use_persistent_service:enabled", false));

      try {
         long var3 = SystemClock.elapsedRealtime();
         var11.start(false);
         var12 = var11.getInfo();
         var11.zza(var12, var2, var1, SystemClock.elapsedRealtime() - var3, var5, null);
      } catch (Throwable var9) {
         var11.zza(null, var2, var1, -1L, var5, var9);
         throw var9;
      } finally {
         var11.finish();
      }

      return var12;
   }

   public static boolean getIsAdIdFakeForDebugLogging(Context var0) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      zzb var2 = new zzb(var0);
      AdvertisingIdClient var5 = new AdvertisingIdClient(
         var0, -1L, var2.a("gads:ad_id_app_context:enabled", false), var2.a("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false)
      );

      try {
         var5.start(false);
         return var5.getIsAdIdFakeForDebugLogging();
      } finally {
         var5.finish();
      }
   }

   public static void setShouldSkipGmsCoreVersionCheck(boolean var0) {
   }

   private final void start(boolean param1) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
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
      // 00: ldc "Calling this from your main thread can lead to deadlock"
      // 02: invokestatic com/google/android/gms/common/internal/zzbq.c (Ljava/lang/String;)V
      // 05: aload 0
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 0b: ifeq 12
      // 0e: aload 0
      // 0f: invokevirtual com/google/android/gms/ads/identifier/AdvertisingIdClient.finish ()V
      // 12: aload 0
      // 13: aload 0
      // 14: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.mContext Landroid/content/Context;
      // 17: aload 0
      // 18: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamz Z
      // 1b: invokestatic com/google/android/gms/ads/identifier/AdvertisingIdClient.zzc (Landroid/content/Context;Z)Lcom/google/android/gms/common/zza;
      // 1e: putfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamu Lcom/google/android/gms/common/zza;
      // 21: aload 0
      // 22: aload 0
      // 23: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.mContext Landroid/content/Context;
      // 26: aload 0
      // 27: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamu Lcom/google/android/gms/common/zza;
      // 2a: invokestatic com/google/android/gms/ads/identifier/AdvertisingIdClient.zza (Landroid/content/Context;Lcom/google/android/gms/common/zza;)Lcom/google/android/gms/internal/zzfo;
      // 2d: putfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamv Lcom/google/android/gms/internal/zzfo;
      // 30: aload 0
      // 31: bipush 1
      // 32: putfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 35: iload 1
      // 36: ifeq 3d
      // 39: aload 0
      // 3a: invokespecial com/google/android/gms/ads/identifier/AdvertisingIdClient.zzbo ()V
      // 3d: aload 0
      // 3e: monitorexit
      // 3f: return
      // 40: astore 2
      // 41: aload 0
      // 42: monitorexit
      // 43: aload 2
      // 44: athrow
      // try (4 -> 9): 33 null
      // try (9 -> 26): 33 null
      // try (28 -> 30): 33 null
      // try (30 -> 32): 33 null
      // try (34 -> 36): 33 null
   }

   private static zzfo zza(Context var0, com.google.android.gms.common.zza var1) throws IOException {
      try {
         return zzfp.a(var1.a(10000L, TimeUnit.MILLISECONDS));
      } catch (InterruptedException var2) {
         throw new IOException("Interrupted exception");
      } catch (Throwable var3) {
         throw new IOException(var3);
      }
   }

   private final boolean zza(AdvertisingIdClient.Info var1, boolean var2, float var3, long var4, String var6, Throwable var7) {
      if (Math.random() > var3) {
         var2 = false;
      } else {
         HashMap var9 = new HashMap();
         String var8;
         if (var2) {
            var8 = "1";
         } else {
            var8 = "0";
         }

         var9.put("app_context", var8);
         if (var1 != null) {
            if (var1.isLimitAdTrackingEnabled()) {
               var8 = "1";
            } else {
               var8 = "0";
            }

            var9.put("limit_ad_tracking", var8);
         }

         if (var1 != null && var1.getId() != null) {
            var9.put("ad_id_size", Integer.toString(var1.getId().length()));
         }

         if (var7 != null) {
            var9.put("error", var7.getClass().getName());
         }

         if (var6 != null && !var6.isEmpty()) {
            var9.put("experiment_id", var6);
         }

         var9.put("tag", "AdvertisingIdClient");
         var9.put("time_spent", Long.toString(var4));
         new com.google.android.gms.ads.identifier.zza(this, var9).start();
         var2 = true;
      }

      return var2;
   }

   private final void zzbo() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamx Ljava/lang/Object;
      // 04: astore 1
      // 05: aload 1
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 0b: ifnull 1f
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 12: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.a Ljava/util/concurrent/CountDownLatch;
      // 15: invokevirtual java/util/concurrent/CountDownLatch.countDown ()V
      // 18: aload 0
      // 19: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 1c: invokevirtual com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.join ()V
      // 1f: aload 0
      // 20: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzana J
      // 23: lconst_0
      // 24: lcmp
      // 25: ifle 3a
      // 28: new com/google/android/gms/ads/identifier/AdvertisingIdClient$zza
      // 2b: astore 2
      // 2c: aload 2
      // 2d: aload 0
      // 2e: aload 0
      // 2f: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzana J
      // 32: invokespecial com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.<init> (Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;J)V
      // 35: aload 0
      // 36: aload 2
      // 37: putfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 3a: aload 1
      // 3b: monitorexit
      // 3c: return
      // 3d: astore 2
      // 3e: aload 1
      // 3f: monitorexit
      // 40: aload 2
      // 41: athrow
      // 42: astore 2
      // 43: goto 1f
      // try (5 -> 12): 33 null
      // try (12 -> 15): 38 java/lang/InterruptedException
      // try (12 -> 15): 33 null
      // try (15 -> 30): 33 null
      // try (30 -> 32): 33 null
      // try (34 -> 36): 33 null
   }

   private static com.google.android.gms.common.zza zzc(Context var0, boolean var1) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      try {
         var0.getPackageManager().getPackageInfo("com.android.vending", 0);
      } catch (NameNotFoundException var5) {
         throw new GooglePlayServicesNotAvailableException(9);
      }

      switch (zzf.b().a(var0)) {
         case 0:
         case 2:
            String var2;
            if (var1) {
               var2 = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
            } else {
               var2 = "com.google.android.gms.ads.identifier.service.START";
            }

            com.google.android.gms.common.zza var3 = new com.google.android.gms.common.zza();
            Intent var7 = new Intent(var2);
            var7.setPackage("com.google.android.gms");

            try {
               var1 = com.google.android.gms.common.stats.zza.a().a(var0, var7, var3, 1);
            } catch (Throwable var4) {
               throw new IOException(var4);
            }

            if (var1) {
               return var3;
            }

            throw new IOException("Connection failure");
         case 1:
         default:
            throw new IOException("Google Play services not available");
      }
   }

   @Override
   protected void finalize() throws Throwable {
      this.finish();
      super.finalize();
   }

   public void finish() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc "Calling this from your main thread can lead to deadlock"
      // 02: invokestatic com/google/android/gms/common/internal/zzbq.c (Ljava/lang/String;)V
      // 05: aload 0
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.mContext Landroid/content/Context;
      // 0b: ifnull 15
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamu Lcom/google/android/gms/common/zza;
      // 12: ifnonnull 18
      // 15: aload 0
      // 16: monitorexit
      // 17: return
      // 18: aload 0
      // 19: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 1c: ifeq 2e
      // 1f: invokestatic com/google/android/gms/common/stats/zza.a ()Lcom/google/android/gms/common/stats/zza;
      // 22: pop
      // 23: aload 0
      // 24: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.mContext Landroid/content/Context;
      // 27: aload 0
      // 28: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamu Lcom/google/android/gms/common/zza;
      // 2b: invokevirtual android/content/Context.unbindService (Landroid/content/ServiceConnection;)V
      // 2e: aload 0
      // 2f: bipush 0
      // 30: putfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 33: aload 0
      // 34: aconst_null
      // 35: putfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamv Lcom/google/android/gms/internal/zzfo;
      // 38: aload 0
      // 39: aconst_null
      // 3a: putfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamu Lcom/google/android/gms/common/zza;
      // 3d: aload 0
      // 3e: monitorexit
      // 3f: goto 17
      // 42: astore 1
      // 43: aload 0
      // 44: monitorexit
      // 45: aload 1
      // 46: athrow
      // 47: astore 1
      // 48: ldc "AdvertisingIdClient"
      // 4a: ldc_w "AdvertisingIdClient unbindService failed."
      // 4d: aload 1
      // 4e: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 51: pop
      // 52: goto 2e
      // try (4 -> 10): 35 null
      // try (10 -> 12): 35 null
      // try (13 -> 23): 40 java/lang/Throwable
      // try (13 -> 23): 35 null
      // try (23 -> 34): 35 null
      // try (36 -> 38): 35 null
      // try (41 -> 46): 35 null
   }

   public AdvertisingIdClient.Info getInfo() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc "Calling this from your main thread can lead to deadlock"
      // 02: invokestatic com/google/android/gms/common/internal/zzbq.c (Ljava/lang/String;)V
      // 05: aload 0
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 0b: ifne 67
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamx Ljava/lang/Object;
      // 12: astore 1
      // 13: aload 1
      // 14: monitorenter
      // 15: aload 0
      // 16: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 19: ifnull 26
      // 1c: aload 0
      // 1d: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 20: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.b Z
      // 23: ifne 3d
      // 26: new java/io/IOException
      // 29: astore 2
      // 2a: aload 2
      // 2b: ldc_w "AdvertisingIdClient is not connected."
      // 2e: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 31: aload 2
      // 32: athrow
      // 33: astore 2
      // 34: aload 1
      // 35: monitorexit
      // 36: aload 2
      // 37: athrow
      // 38: astore 1
      // 39: aload 0
      // 3a: monitorexit
      // 3b: aload 1
      // 3c: athrow
      // 3d: aload 1
      // 3e: monitorexit
      // 3f: aload 0
      // 40: bipush 0
      // 41: invokespecial com/google/android/gms/ads/identifier/AdvertisingIdClient.start (Z)V
      // 44: aload 0
      // 45: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 48: ifne 67
      // 4b: new java/io/IOException
      // 4e: astore 1
      // 4f: aload 1
      // 50: ldc_w "AdvertisingIdClient cannot reconnect."
      // 53: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 56: aload 1
      // 57: athrow
      // 58: astore 1
      // 59: new java/io/IOException
      // 5c: astore 2
      // 5d: aload 2
      // 5e: ldc_w "AdvertisingIdClient cannot reconnect."
      // 61: aload 1
      // 62: invokespecial java/io/IOException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 65: aload 2
      // 66: athrow
      // 67: aload 0
      // 68: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamu Lcom/google/android/gms/common/zza;
      // 6b: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 6e: pop
      // 6f: aload 0
      // 70: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamv Lcom/google/android/gms/internal/zzfo;
      // 73: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 76: pop
      // 77: new com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
      // 7a: astore 1
      // 7b: aload 1
      // 7c: aload 0
      // 7d: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamv Lcom/google/android/gms/internal/zzfo;
      // 80: invokeinterface com/google/android/gms/internal/zzfo.a ()Ljava/lang/String; 1
      // 85: aload 0
      // 86: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamv Lcom/google/android/gms/internal/zzfo;
      // 89: bipush 1
      // 8a: invokeinterface com/google/android/gms/internal/zzfo.a (Z)Z 2
      // 8f: invokespecial com/google/android/gms/ads/identifier/AdvertisingIdClient$Info.<init> (Ljava/lang/String;Z)V
      // 92: aload 0
      // 93: monitorexit
      // 94: aload 0
      // 95: invokespecial com/google/android/gms/ads/identifier/AdvertisingIdClient.zzbo ()V
      // 98: aload 1
      // 99: areturn
      // 9a: astore 1
      // 9b: ldc "AdvertisingIdClient"
      // 9d: ldc_w "GMS remote exception "
      // a0: aload 1
      // a1: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // a4: pop
      // a5: new java/io/IOException
      // a8: astore 1
      // a9: aload 1
      // aa: ldc_w "Remote exception"
      // ad: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // b0: aload 1
      // b1: athrow
      // try (4 -> 12): 31 null
      // try (12 -> 19): 26 null
      // try (19 -> 26): 26 null
      // try (27 -> 29): 26 null
      // try (29 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 38): 26 null
      // try (38 -> 41): 51 java/lang/Exception
      // try (38 -> 41): 31 null
      // try (41 -> 51): 31 null
      // try (52 -> 60): 31 null
      // try (60 -> 68): 31 null
      // try (68 -> 79): 85 android/os/RemoteException
      // try (68 -> 79): 31 null
      // try (79 -> 81): 31 null
      // try (86 -> 98): 31 null
   }

   public boolean getIsAdIdFakeForDebugLogging() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc "Calling this from your main thread can lead to deadlock"
      // 02: invokestatic com/google/android/gms/common/internal/zzbq.c (Ljava/lang/String;)V
      // 05: aload 0
      // 06: monitorenter
      // 07: aload 0
      // 08: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 0b: ifne 67
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamx Ljava/lang/Object;
      // 12: astore 2
      // 13: aload 2
      // 14: monitorenter
      // 15: aload 0
      // 16: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 19: ifnull 26
      // 1c: aload 0
      // 1d: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamy Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
      // 20: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient$zza.b Z
      // 23: ifne 3d
      // 26: new java/io/IOException
      // 29: astore 3
      // 2a: aload 3
      // 2b: ldc_w "AdvertisingIdClient is not connected."
      // 2e: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 31: aload 3
      // 32: athrow
      // 33: astore 3
      // 34: aload 2
      // 35: monitorexit
      // 36: aload 3
      // 37: athrow
      // 38: astore 2
      // 39: aload 0
      // 3a: monitorexit
      // 3b: aload 2
      // 3c: athrow
      // 3d: aload 2
      // 3e: monitorexit
      // 3f: aload 0
      // 40: bipush 0
      // 41: invokespecial com/google/android/gms/ads/identifier/AdvertisingIdClient.start (Z)V
      // 44: aload 0
      // 45: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamw Z
      // 48: ifne 67
      // 4b: new java/io/IOException
      // 4e: astore 2
      // 4f: aload 2
      // 50: ldc_w "AdvertisingIdClient cannot reconnect."
      // 53: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 56: aload 2
      // 57: athrow
      // 58: astore 3
      // 59: new java/io/IOException
      // 5c: astore 2
      // 5d: aload 2
      // 5e: ldc_w "AdvertisingIdClient cannot reconnect."
      // 61: aload 3
      // 62: invokespecial java/io/IOException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 65: aload 2
      // 66: athrow
      // 67: aload 0
      // 68: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamu Lcom/google/android/gms/common/zza;
      // 6b: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 6e: pop
      // 6f: aload 0
      // 70: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamv Lcom/google/android/gms/internal/zzfo;
      // 73: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 76: pop
      // 77: aload 0
      // 78: getfield com/google/android/gms/ads/identifier/AdvertisingIdClient.zzamv Lcom/google/android/gms/internal/zzfo;
      // 7b: invokeinterface com/google/android/gms/internal/zzfo.b ()Z 1
      // 80: istore 1
      // 81: aload 0
      // 82: monitorexit
      // 83: aload 0
      // 84: invokespecial com/google/android/gms/ads/identifier/AdvertisingIdClient.zzbo ()V
      // 87: iload 1
      // 88: ireturn
      // 89: astore 2
      // 8a: ldc "AdvertisingIdClient"
      // 8c: ldc_w "GMS remote exception "
      // 8f: aload 2
      // 90: invokestatic android/util/Log.i (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 93: pop
      // 94: new java/io/IOException
      // 97: astore 2
      // 98: aload 2
      // 99: ldc_w "Remote exception"
      // 9c: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 9f: aload 2
      // a0: athrow
      // try (4 -> 12): 31 null
      // try (12 -> 19): 26 null
      // try (19 -> 26): 26 null
      // try (27 -> 29): 26 null
      // try (29 -> 31): 31 null
      // try (32 -> 34): 31 null
      // try (36 -> 38): 26 null
      // try (38 -> 41): 51 java/lang/Exception
      // try (38 -> 41): 31 null
      // try (41 -> 51): 31 null
      // try (52 -> 60): 31 null
      // try (60 -> 68): 31 null
      // try (68 -> 72): 78 android/os/RemoteException
      // try (68 -> 72): 31 null
      // try (72 -> 74): 31 null
      // try (79 -> 91): 31 null
   }

   public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      this.start(true);
   }

   public static final class Info {
      private final String zzang;
      private final boolean zzanh;

      public Info(String var1, boolean var2) {
         this.zzang = var1;
         this.zzanh = var2;
      }

      public final String getId() {
         return this.zzang;
      }

      public final boolean isLimitAdTrackingEnabled() {
         return this.zzanh;
      }

      @Override
      public final String toString() {
         String var2 = this.zzang;
         boolean var1 = this.zzanh;
         return new StringBuilder(String.valueOf(var2).length() + 7).append("{").append(var2).append("}").append(var1).toString();
      }
   }

   static final class zza extends Thread {
      CountDownLatch a;
      boolean b;
      private WeakReference<AdvertisingIdClient> c;
      private long d;

      public zza(AdvertisingIdClient var1, long var2) {
         this.c = new WeakReference<>(var1);
         this.d = var2;
         this.a = new CountDownLatch(1);
         this.b = false;
         this.start();
      }

      private final void a() {
         AdvertisingIdClient var1 = this.c.get();
         if (var1 != null) {
            var1.finish();
            this.b = true;
         }
      }

      @Override
      public final void run() {
         try {
            if (!this.a.await(this.d, TimeUnit.MILLISECONDS)) {
               this.a();
            }
         } catch (InterruptedException var2) {
            this.a();
         }
      }
   }
}
