package com.google.android.gms.internal;

import android.content.Context;

public final class zzbhd {
   private static Context a;
   private static Boolean b;

   public static boolean a(Context param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/google/android/gms/internal/zzbhd
      // 02: monitorenter
      // 03: aload 0
      // 04: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 07: astore 2
      // 08: getstatic com/google/android/gms/internal/zzbhd.a Landroid/content/Context;
      // 0b: ifnull 27
      // 0e: getstatic com/google/android/gms/internal/zzbhd.b Ljava/lang/Boolean;
      // 11: ifnull 27
      // 14: getstatic com/google/android/gms/internal/zzbhd.a Landroid/content/Context;
      // 17: aload 2
      // 18: if_acmpne 27
      // 1b: getstatic com/google/android/gms/internal/zzbhd.b Ljava/lang/Boolean;
      // 1e: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 21: istore 1
      // 22: ldc com/google/android/gms/internal/zzbhd
      // 24: monitorexit
      // 25: iload 1
      // 26: ireturn
      // 27: aconst_null
      // 28: putstatic com/google/android/gms/internal/zzbhd.b Ljava/lang/Boolean;
      // 2b: invokestatic com/google/android/gms/common/util/zzq.h ()Z
      // 2e: ifeq 4c
      // 31: aload 2
      // 32: invokevirtual android/content/Context.getPackageManager ()Landroid/content/pm/PackageManager;
      // 35: invokevirtual android/content/pm/PackageManager.isInstantApp ()Z
      // 38: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 3b: putstatic com/google/android/gms/internal/zzbhd.b Ljava/lang/Boolean;
      // 3e: aload 2
      // 3f: putstatic com/google/android/gms/internal/zzbhd.a Landroid/content/Context;
      // 42: getstatic com/google/android/gms/internal/zzbhd.b Ljava/lang/Boolean;
      // 45: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 48: istore 1
      // 49: goto 22
      // 4c: aload 0
      // 4d: invokevirtual android/content/Context.getClassLoader ()Ljava/lang/ClassLoader;
      // 50: ldc "com.google.android.instantapps.supervisor.InstantAppsRuntime"
      // 52: invokevirtual java/lang/ClassLoader.loadClass (Ljava/lang/String;)Ljava/lang/Class;
      // 55: pop
      // 56: bipush 1
      // 57: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 5a: putstatic com/google/android/gms/internal/zzbhd.b Ljava/lang/Boolean;
      // 5d: goto 3e
      // 60: astore 0
      // 61: bipush 0
      // 62: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 65: putstatic com/google/android/gms/internal/zzbhd.b Ljava/lang/Boolean;
      // 68: goto 3e
      // 6b: astore 0
      // 6c: ldc com/google/android/gms/internal/zzbhd
      // 6e: monitorexit
      // 6f: aload 0
      // 70: athrow
      // try (2 -> 15): 48 null
      // try (19 -> 28): 48 null
      // try (28 -> 33): 48 null
      // try (34 -> 42): 43 java/lang/ClassNotFoundException
      // try (34 -> 42): 48 null
      // try (44 -> 47): 48 null
   }
}
