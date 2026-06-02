package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewk;
import com.google.android.gms.internal.zzewn;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class AppStartTrace implements ActivityLifecycleCallbacks {
   private static final long a = TimeUnit.MINUTES.toMicros(1L);
   private static volatile AppStartTrace b;
   private boolean c = false;
   private zzevz d;
   private final zzewk e;
   private Context f;
   private WeakReference<Activity> g;
   private WeakReference<Activity> h;
   private boolean i = false;
   private zzewn j = null;
   private zzewn k = null;
   private zzewn l = null;
   private boolean m = false;

   private AppStartTrace(zzevz var1, zzewk var2) {
      this.d = null;
      this.e = var2;
   }

   public static AppStartTrace a() {
      AppStartTrace var0;
      if (b != null) {
         var0 = b;
      } else {
         var0 = a(null, new zzewk());
      }

      return var0;
   }

   private static AppStartTrace a(zzevz param0, zzewk param1) {
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
      // 00: getstatic com/google/firebase/perf/metrics/AppStartTrace.b Lcom/google/firebase/perf/metrics/AppStartTrace;
      // 03: ifnonnull 20
      // 06: ldc com/google/firebase/perf/metrics/AppStartTrace
      // 08: monitorenter
      // 09: getstatic com/google/firebase/perf/metrics/AppStartTrace.b Lcom/google/firebase/perf/metrics/AppStartTrace;
      // 0c: ifnonnull 1d
      // 0f: new com/google/firebase/perf/metrics/AppStartTrace
      // 12: astore 0
      // 13: aload 0
      // 14: aconst_null
      // 15: aload 1
      // 16: invokespecial com/google/firebase/perf/metrics/AppStartTrace.<init> (Lcom/google/android/gms/internal/zzevz;Lcom/google/android/gms/internal/zzewk;)V
      // 19: aload 0
      // 1a: putstatic com/google/firebase/perf/metrics/AppStartTrace.b Lcom/google/firebase/perf/metrics/AppStartTrace;
      // 1d: ldc com/google/firebase/perf/metrics/AppStartTrace
      // 1f: monitorexit
      // 20: getstatic com/google/firebase/perf/metrics/AppStartTrace.b Lcom/google/firebase/perf/metrics/AppStartTrace;
      // 23: areturn
      // 24: astore 0
      // 25: ldc com/google/firebase/perf/metrics/AppStartTrace
      // 27: monitorexit
      // 28: aload 0
      // 29: athrow
      // try (4 -> 14): 18 null
      // try (14 -> 16): 18 null
      // try (19 -> 21): 18 null
   }

   private final void b() {
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
      // 03: getfield com/google/firebase/perf/metrics/AppStartTrace.c Z
      // 06: istore 1
      // 07: iload 1
      // 08: ifne 0e
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: aload 0
      // 0f: getfield com/google/firebase/perf/metrics/AppStartTrace.f Landroid/content/Context;
      // 12: checkcast android/app/Application
      // 15: aload 0
      // 16: invokevirtual android/app/Application.unregisterActivityLifecycleCallbacks (Landroid/app/Application$ActivityLifecycleCallbacks;)V
      // 19: aload 0
      // 1a: bipush 0
      // 1b: putfield com/google/firebase/perf/metrics/AppStartTrace.c Z
      // 1e: goto 0b
      // 21: astore 2
      // 22: aload 0
      // 23: monitorexit
      // 24: aload 2
      // 25: athrow
      // try (2 -> 5): 19 null
      // try (10 -> 18): 19 null
   }

   @Keep
   public static void setLauncherActivityOnCreateTime(String var0) {
   }

   @Keep
   public static void setLauncherActivityOnResumeTime(String var0) {
   }

   @Keep
   public static void setLauncherActivityOnStartTime(String var0) {
   }

   public final void a(Context param1) {
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
      // 03: getfield com/google/firebase/perf/metrics/AppStartTrace.c Z
      // 06: istore 2
      // 07: iload 2
      // 08: ifeq 0e
      // 0b: aload 0
      // 0c: monitorexit
      // 0d: return
      // 0e: aload 1
      // 0f: invokevirtual android/content/Context.getApplicationContext ()Landroid/content/Context;
      // 12: astore 1
      // 13: aload 1
      // 14: instanceof android/app/Application
      // 17: ifeq 0b
      // 1a: aload 1
      // 1b: checkcast android/app/Application
      // 1e: aload 0
      // 1f: invokevirtual android/app/Application.registerActivityLifecycleCallbacks (Landroid/app/Application$ActivityLifecycleCallbacks;)V
      // 22: aload 0
      // 23: bipush 1
      // 24: putfield com/google/firebase/perf/metrics/AppStartTrace.c Z
      // 27: aload 0
      // 28: aload 1
      // 29: putfield com/google/firebase/perf/metrics/AppStartTrace.f Landroid/content/Context;
      // 2c: goto 0b
      // 2f: astore 1
      // 30: aload 0
      // 31: monitorexit
      // 32: aload 1
      // 33: athrow
      // try (2 -> 5): 27 null
      // try (10 -> 26): 27 null
   }

   public void onActivityCreated(Activity param1, Bundle param2) {
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
      // 03: getfield com/google/firebase/perf/metrics/AppStartTrace.m Z
      // 06: ifne 12
      // 09: aload 0
      // 0a: getfield com/google/firebase/perf/metrics/AppStartTrace.j Lcom/google/android/gms/internal/zzewn;
      // 0d: astore 2
      // 0e: aload 2
      // 0f: ifnull 15
      // 12: aload 0
      // 13: monitorexit
      // 14: return
      // 15: new java/lang/ref/WeakReference
      // 18: astore 2
      // 19: aload 2
      // 1a: aload 1
      // 1b: invokespecial java/lang/ref/WeakReference.<init> (Ljava/lang/Object;)V
      // 1e: aload 0
      // 1f: aload 2
      // 20: putfield com/google/firebase/perf/metrics/AppStartTrace.g Ljava/lang/ref/WeakReference;
      // 23: new com/google/android/gms/internal/zzewn
      // 26: astore 1
      // 27: aload 1
      // 28: invokespecial com/google/android/gms/internal/zzewn.<init> ()V
      // 2b: aload 0
      // 2c: aload 1
      // 2d: putfield com/google/firebase/perf/metrics/AppStartTrace.j Lcom/google/android/gms/internal/zzewn;
      // 30: invokestatic com/google/firebase/perf/provider/FirebasePerfProvider.zzckv ()Lcom/google/android/gms/internal/zzewn;
      // 33: aload 0
      // 34: getfield com/google/firebase/perf/metrics/AppStartTrace.j Lcom/google/android/gms/internal/zzewn;
      // 37: invokevirtual com/google/android/gms/internal/zzewn.a (Lcom/google/android/gms/internal/zzewn;)J
      // 3a: getstatic com/google/firebase/perf/metrics/AppStartTrace.a J
      // 3d: lcmp
      // 3e: ifle 12
      // 41: aload 0
      // 42: bipush 1
      // 43: putfield com/google/firebase/perf/metrics/AppStartTrace.i Z
      // 46: goto 12
      // 49: astore 1
      // 4a: aload 0
      // 4b: monitorexit
      // 4c: aload 1
      // 4d: athrow
      // try (2 -> 8): 39 null
      // try (13 -> 38): 39 null
   }

   public void onActivityDestroyed(Activity var1) {
   }

   public void onActivityPaused(Activity var1) {
   }

   public void onActivityResumed(Activity param1) {
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
      // 003: getfield com/google/firebase/perf/metrics/AppStartTrace.m Z
      // 006: ifne 019
      // 009: aload 0
      // 00a: getfield com/google/firebase/perf/metrics/AppStartTrace.l Lcom/google/android/gms/internal/zzewn;
      // 00d: ifnonnull 019
      // 010: aload 0
      // 011: getfield com/google/firebase/perf/metrics/AppStartTrace.i Z
      // 014: istore 3
      // 015: iload 3
      // 016: ifeq 01c
      // 019: aload 0
      // 01a: monitorexit
      // 01b: return
      // 01c: new java/lang/ref/WeakReference
      // 01f: astore 6
      // 021: aload 6
      // 023: aload 1
      // 024: invokespecial java/lang/ref/WeakReference.<init> (Ljava/lang/Object;)V
      // 027: aload 0
      // 028: aload 6
      // 02a: putfield com/google/firebase/perf/metrics/AppStartTrace.h Ljava/lang/ref/WeakReference;
      // 02d: new com/google/android/gms/internal/zzewn
      // 030: astore 6
      // 032: aload 6
      // 034: invokespecial com/google/android/gms/internal/zzewn.<init> ()V
      // 037: aload 0
      // 038: aload 6
      // 03a: putfield com/google/firebase/perf/metrics/AppStartTrace.l Lcom/google/android/gms/internal/zzewn;
      // 03d: invokestatic com/google/firebase/perf/provider/FirebasePerfProvider.zzckv ()Lcom/google/android/gms/internal/zzewn;
      // 040: astore 6
      // 042: aload 1
      // 043: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 046: invokevirtual java/lang/Class.getName ()Ljava/lang/String;
      // 049: astore 7
      // 04b: aload 6
      // 04d: aload 0
      // 04e: getfield com/google/firebase/perf/metrics/AppStartTrace.l Lcom/google/android/gms/internal/zzewn;
      // 051: invokevirtual com/google/android/gms/internal/zzewn.a (Lcom/google/android/gms/internal/zzewn;)J
      // 054: lstore 4
      // 056: aload 7
      // 058: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 05b: invokevirtual java/lang/String.length ()I
      // 05e: istore 2
      // 05f: new java/lang/StringBuilder
      // 062: astore 1
      // 063: aload 1
      // 064: iload 2
      // 065: bipush 30
      // 067: iadd
      // 068: invokespecial java/lang/StringBuilder.<init> (I)V
      // 06b: ldc "FirebasePerformance"
      // 06d: aload 1
      // 06e: ldc "onResume "
      // 070: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 073: aload 7
      // 075: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 078: ldc ":"
      // 07a: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 07d: lload 4
      // 07f: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 082: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 085: invokestatic android/util/Log.d (Ljava/lang/String;Ljava/lang/String;)I
      // 088: pop
      // 089: new com/google/android/gms/internal/zzewy
      // 08c: astore 1
      // 08d: aload 1
      // 08e: invokespecial com/google/android/gms/internal/zzewy.<init> ()V
      // 091: aload 1
      // 092: getstatic com/google/android/gms/internal/zzewm.zzoer Lcom/google/android/gms/internal/zzewm;
      // 095: invokevirtual com/google/android/gms/internal/zzewm.toString ()Ljava/lang/String;
      // 098: putfield com/google/android/gms/internal/zzewy.a Ljava/lang/String;
      // 09b: aload 1
      // 09c: aload 6
      // 09e: invokevirtual com/google/android/gms/internal/zzewn.b ()J
      // 0a1: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0a4: putfield com/google/android/gms/internal/zzewy.b Ljava/lang/Long;
      // 0a7: aload 1
      // 0a8: aload 6
      // 0aa: aload 0
      // 0ab: getfield com/google/firebase/perf/metrics/AppStartTrace.l Lcom/google/android/gms/internal/zzewn;
      // 0ae: invokevirtual com/google/android/gms/internal/zzewn.a (Lcom/google/android/gms/internal/zzewn;)J
      // 0b1: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0b4: putfield com/google/android/gms/internal/zzewy.c Ljava/lang/Long;
      // 0b7: new com/google/android/gms/internal/zzewy
      // 0ba: astore 7
      // 0bc: aload 7
      // 0be: invokespecial com/google/android/gms/internal/zzewy.<init> ()V
      // 0c1: aload 7
      // 0c3: getstatic com/google/android/gms/internal/zzewm.zzoes Lcom/google/android/gms/internal/zzewm;
      // 0c6: invokevirtual com/google/android/gms/internal/zzewm.toString ()Ljava/lang/String;
      // 0c9: putfield com/google/android/gms/internal/zzewy.a Ljava/lang/String;
      // 0cc: aload 7
      // 0ce: aload 6
      // 0d0: invokevirtual com/google/android/gms/internal/zzewn.b ()J
      // 0d3: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0d6: putfield com/google/android/gms/internal/zzewy.b Ljava/lang/Long;
      // 0d9: aload 7
      // 0db: aload 6
      // 0dd: aload 0
      // 0de: getfield com/google/firebase/perf/metrics/AppStartTrace.j Lcom/google/android/gms/internal/zzewn;
      // 0e1: invokevirtual com/google/android/gms/internal/zzewn.a (Lcom/google/android/gms/internal/zzewn;)J
      // 0e4: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0e7: putfield com/google/android/gms/internal/zzewy.c Ljava/lang/Long;
      // 0ea: new com/google/android/gms/internal/zzewy
      // 0ed: astore 6
      // 0ef: aload 6
      // 0f1: invokespecial com/google/android/gms/internal/zzewy.<init> ()V
      // 0f4: aload 6
      // 0f6: getstatic com/google/android/gms/internal/zzewm.zzoet Lcom/google/android/gms/internal/zzewm;
      // 0f9: invokevirtual com/google/android/gms/internal/zzewm.toString ()Ljava/lang/String;
      // 0fc: putfield com/google/android/gms/internal/zzewy.a Ljava/lang/String;
      // 0ff: aload 6
      // 101: aload 0
      // 102: getfield com/google/firebase/perf/metrics/AppStartTrace.j Lcom/google/android/gms/internal/zzewn;
      // 105: invokevirtual com/google/android/gms/internal/zzewn.b ()J
      // 108: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 10b: putfield com/google/android/gms/internal/zzewy.b Ljava/lang/Long;
      // 10e: aload 6
      // 110: aload 0
      // 111: getfield com/google/firebase/perf/metrics/AppStartTrace.j Lcom/google/android/gms/internal/zzewn;
      // 114: aload 0
      // 115: getfield com/google/firebase/perf/metrics/AppStartTrace.k Lcom/google/android/gms/internal/zzewn;
      // 118: invokevirtual com/google/android/gms/internal/zzewn.a (Lcom/google/android/gms/internal/zzewn;)J
      // 11b: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 11e: putfield com/google/android/gms/internal/zzewy.c Ljava/lang/Long;
      // 121: new com/google/android/gms/internal/zzewy
      // 124: astore 8
      // 126: aload 8
      // 128: invokespecial com/google/android/gms/internal/zzewy.<init> ()V
      // 12b: aload 8
      // 12d: getstatic com/google/android/gms/internal/zzewm.zzoeu Lcom/google/android/gms/internal/zzewm;
      // 130: invokevirtual com/google/android/gms/internal/zzewm.toString ()Ljava/lang/String;
      // 133: putfield com/google/android/gms/internal/zzewy.a Ljava/lang/String;
      // 136: aload 8
      // 138: aload 0
      // 139: getfield com/google/firebase/perf/metrics/AppStartTrace.k Lcom/google/android/gms/internal/zzewn;
      // 13c: invokevirtual com/google/android/gms/internal/zzewn.b ()J
      // 13f: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 142: putfield com/google/android/gms/internal/zzewy.b Ljava/lang/Long;
      // 145: aload 8
      // 147: aload 0
      // 148: getfield com/google/firebase/perf/metrics/AppStartTrace.k Lcom/google/android/gms/internal/zzewn;
      // 14b: aload 0
      // 14c: getfield com/google/firebase/perf/metrics/AppStartTrace.l Lcom/google/android/gms/internal/zzewn;
      // 14f: invokevirtual com/google/android/gms/internal/zzewn.a (Lcom/google/android/gms/internal/zzewn;)J
      // 152: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 155: putfield com/google/android/gms/internal/zzewy.c Ljava/lang/Long;
      // 158: aload 1
      // 159: bipush 3
      // 15a: anewarray 178
      // 15d: dup
      // 15e: bipush 0
      // 15f: aload 7
      // 161: aastore
      // 162: dup
      // 163: bipush 1
      // 164: aload 6
      // 166: aastore
      // 167: dup
      // 168: bipush 2
      // 169: aload 8
      // 16b: aastore
      // 16c: putfield com/google/android/gms/internal/zzewy.e [Lcom/google/android/gms/internal/zzewy;
      // 16f: aload 0
      // 170: getfield com/google/firebase/perf/metrics/AppStartTrace.d Lcom/google/android/gms/internal/zzevz;
      // 173: ifnonnull 17d
      // 176: aload 0
      // 177: invokestatic com/google/android/gms/internal/zzevz.a ()Lcom/google/android/gms/internal/zzevz;
      // 17a: putfield com/google/firebase/perf/metrics/AppStartTrace.d Lcom/google/android/gms/internal/zzevz;
      // 17d: aload 0
      // 17e: getfield com/google/firebase/perf/metrics/AppStartTrace.d Lcom/google/android/gms/internal/zzevz;
      // 181: ifnull 18d
      // 184: aload 0
      // 185: getfield com/google/firebase/perf/metrics/AppStartTrace.d Lcom/google/android/gms/internal/zzevz;
      // 188: aload 1
      // 189: bipush 3
      // 18a: invokevirtual com/google/android/gms/internal/zzevz.a (Lcom/google/android/gms/internal/zzewy;I)V
      // 18d: aload 0
      // 18e: getfield com/google/firebase/perf/metrics/AppStartTrace.c Z
      // 191: ifeq 019
      // 194: aload 0
      // 195: invokespecial com/google/firebase/perf/metrics/AppStartTrace.b ()V
      // 198: goto 019
      // 19b: astore 1
      // 19c: aload 0
      // 19d: monitorexit
      // 19e: aload 1
      // 19f: athrow
      // try (2 -> 11): 186 null
      // try (16 -> 172): 186 null
      // try (172 -> 180): 186 null
      // try (180 -> 185): 186 null
   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity param1) {
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
      // 03: getfield com/google/firebase/perf/metrics/AppStartTrace.m Z
      // 06: ifne 19
      // 09: aload 0
      // 0a: getfield com/google/firebase/perf/metrics/AppStartTrace.k Lcom/google/android/gms/internal/zzewn;
      // 0d: ifnonnull 19
      // 10: aload 0
      // 11: getfield com/google/firebase/perf/metrics/AppStartTrace.i Z
      // 14: istore 2
      // 15: iload 2
      // 16: ifeq 1c
      // 19: aload 0
      // 1a: monitorexit
      // 1b: return
      // 1c: new com/google/android/gms/internal/zzewn
      // 1f: astore 1
      // 20: aload 1
      // 21: invokespecial com/google/android/gms/internal/zzewn.<init> ()V
      // 24: aload 0
      // 25: aload 1
      // 26: putfield com/google/firebase/perf/metrics/AppStartTrace.k Lcom/google/android/gms/internal/zzewn;
      // 29: goto 19
      // 2c: astore 1
      // 2d: aload 0
      // 2e: monitorexit
      // 2f: aload 1
      // 30: athrow
      // try (2 -> 11): 24 null
      // try (16 -> 23): 24 null
   }

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void onActivityStopped(Activity var1) {
      synchronized (this){} // $VF: monitorenter 
      // $VF: monitorexit
   }

   public static final class zza implements Runnable {
      private final AppStartTrace a;

      public zza(AppStartTrace var1) {
         this.a = var1;
      }

      @Override
      public final void run() {
         if (this.a.j == null) {
            AppStartTrace.a(this.a, true);
         }
      }
   }
}
