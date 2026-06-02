package com.google.android.gms.common.internal;

import android.content.Context;

public final class zzbf {
   private static Object a = new Object();
   private static boolean b;
   private static String c;
   private static int d;

   public static String a(Context var0) {
      c(var0);
      return c;
   }

   public static int b(Context var0) {
      c(var0);
      return d;
   }

   private static void c(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: getstatic com/google/android/gms/common/internal/zzbf.a Ljava/lang/Object;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/internal/zzbf.b Z
      // 09: ifeq 0f
      // 0c: aload 1
      // 0d: monitorexit
      // 0e: return
      // 0f: bipush 1
      // 10: putstatic com/google/android/gms/common/internal/zzbf.b Z
      // 13: aload 0
      // 14: invokevirtual android/content/Context.getPackageName ()Ljava/lang/String;
      // 17: astore 2
      // 18: aload 0
      // 19: invokestatic com/google/android/gms/internal/zzbhf.a (Landroid/content/Context;)Lcom/google/android/gms/internal/zzbhe;
      // 1c: astore 0
      // 1d: aload 0
      // 1e: aload 2
      // 1f: sipush 128
      // 22: invokevirtual com/google/android/gms/internal/zzbhe.a (Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
      // 25: getfield android/content/pm/ApplicationInfo.metaData Landroid/os/Bundle;
      // 28: astore 0
      // 29: aload 0
      // 2a: ifnonnull 37
      // 2d: aload 1
      // 2e: monitorexit
      // 2f: goto 0e
      // 32: astore 0
      // 33: aload 1
      // 34: monitorexit
      // 35: aload 0
      // 36: athrow
      // 37: aload 0
      // 38: ldc "com.google.app.id"
      // 3a: invokevirtual android/os/Bundle.getString (Ljava/lang/String;)Ljava/lang/String;
      // 3d: putstatic com/google/android/gms/common/internal/zzbf.c Ljava/lang/String;
      // 40: aload 0
      // 41: ldc "com.google.android.gms.version"
      // 43: invokevirtual android/os/Bundle.getInt (Ljava/lang/String;)I
      // 46: putstatic com/google/android/gms/common/internal/zzbf.d I
      // 49: aload 1
      // 4a: monitorexit
      // 4b: goto 0e
      // 4e: astore 0
      // 4f: ldc "MetadataValueReader"
      // 51: ldc "This should never happen."
      // 53: aload 0
      // 54: invokestatic android/util/Log.wtf (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 57: pop
      // 58: goto 49
      // try (4 -> 8): 28 null
      // try (9 -> 17): 28 null
      // try (17 -> 23): 44 android/content/pm/PackageManager$NameNotFoundException
      // try (17 -> 23): 28 null
      // try (25 -> 27): 28 null
      // try (29 -> 31): 28 null
      // try (33 -> 41): 44 android/content/pm/PackageManager$NameNotFoundException
      // try (33 -> 41): 28 null
      // try (41 -> 43): 28 null
      // try (45 -> 50): 28 null
   }
}
