package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzba;
import com.google.android.gms.common.internal.zzbq;

final class zzg {
   private static zzba a;
   private static final Object b = new Object();
   private static Context c;

   static void a(Context param0) {
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
      // 00: ldc com/google/android/gms/common/zzg
      // 02: monitorenter
      // 03: getstatic com/google/android/gms/common/zzg.c Landroid/content/Context;
      // 06: ifnonnull 18
      // 09: aload 0
      // 0a: ifnull 14
      // 0d: aload 0
      // 0e: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 11: putstatic com/google/android/gms/common/zzg.c Landroid/content/Context;
      // 14: ldc com/google/android/gms/common/zzg
      // 16: monitorexit
      // 17: return
      // 18: ldc "GoogleCertificates"
      // 1a: ldc "GoogleCertificates has been initialized already"
      // 1c: invokestatic android/util/Log.w (Ljava/lang/String;Ljava/lang/String;)I
      // 1f: pop
      // 20: goto 14
      // 23: astore 0
      // 24: ldc com/google/android/gms/common/zzg
      // 26: monitorexit
      // 27: aload 0
      // 28: athrow
      // try (2 -> 4): 17 null
      // try (6 -> 9): 17 null
      // try (12 -> 16): 17 null
   }

   private static boolean a() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: bipush 1
      // 01: istore 0
      // 02: getstatic com/google/android/gms/common/zzg.a Lcom/google/android/gms/common/internal/zzba;
      // 05: ifnull 0a
      // 08: iload 0
      // 09: ireturn
      // 0a: getstatic com/google/android/gms/common/zzg.c Landroid/content/Context;
      // 0d: invokestatic com/google/android/gms/common/internal/zzbq.a (Ljava/lang/Object;)Ljava/lang/Object;
      // 10: pop
      // 11: getstatic com/google/android/gms/common/zzg.b Ljava/lang/Object;
      // 14: astore 1
      // 15: aload 1
      // 16: monitorenter
      // 17: getstatic com/google/android/gms/common/zzg.a Lcom/google/android/gms/common/internal/zzba;
      // 1a: astore 2
      // 1b: aload 2
      // 1c: ifnonnull 35
      // 1f: getstatic com/google/android/gms/common/zzg.c Landroid/content/Context;
      // 22: getstatic com/google/android/gms/dynamite/DynamiteModule.c Lcom/google/android/gms/dynamite/DynamiteModule$zzd;
      // 25: ldc "com.google.android.gms.googlecertificates"
      // 27: invokestatic com/google/android/gms/dynamite/DynamiteModule.a (Landroid/content/Context;Lcom/google/android/gms/dynamite/DynamiteModule$zzd;Ljava/lang/String;)Lcom/google/android/gms/dynamite/DynamiteModule;
      // 2a: ldc "com.google.android.gms.common.GoogleCertificatesImpl"
      // 2c: invokevirtual com/google/android/gms/dynamite/DynamiteModule.a (Ljava/lang/String;)Landroid/os/IBinder;
      // 2f: invokestatic com/google/android/gms/common/internal/zzbb.a (Landroid/os/IBinder;)Lcom/google/android/gms/common/internal/zzba;
      // 32: putstatic com/google/android/gms/common/zzg.a Lcom/google/android/gms/common/internal/zzba;
      // 35: aload 1
      // 36: monitorexit
      // 37: goto 08
      // 3a: astore 2
      // 3b: aload 1
      // 3c: monitorexit
      // 3d: aload 2
      // 3e: athrow
      // 3f: astore 2
      // 40: ldc "GoogleCertificates"
      // 42: ldc "Failed to load com.google.android.gms.googlecertificates"
      // 44: aload 2
      // 45: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 48: pop
      // 49: bipush 0
      // 4a: istore 0
      // 4b: aload 1
      // 4c: monitorexit
      // 4d: goto 08
      // try (13 -> 15): 28 null
      // try (17 -> 25): 33 com/google/android/gms/dynamite/DynamiteModule$zzc
      // try (17 -> 25): 28 null
      // try (25 -> 27): 28 null
      // try (29 -> 31): 28 null
      // try (34 -> 39): 28 null
      // try (41 -> 43): 28 null
   }

   static boolean a(String var0, zzh var1) {
      return a(var0, var1, false);
   }

   private static boolean a(String var0, zzh var1, boolean var2) {
      boolean var3 = false;
      if (!a()) {
         var2 = var3;
      } else {
         zzbq.a(c);

         try {
            zzn var4 = new zzn(var0, var1, var2);
            var2 = a.a(var4, com.google.android.gms.dynamic.zzn.a(c.getPackageManager()));
         } catch (RemoteException var5) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", var5);
            var2 = var3;
         }
      }

      return var2;
   }

   static boolean b(String var0, zzh var1) {
      return a(var0, var1, true);
   }
}
