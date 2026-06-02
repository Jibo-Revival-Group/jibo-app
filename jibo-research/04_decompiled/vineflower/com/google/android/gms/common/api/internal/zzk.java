package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzk implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
   private static final zzk a = new zzk();
   private final AtomicBoolean b = new AtomicBoolean();
   private final AtomicBoolean c = new AtomicBoolean();
   private final ArrayList<zzl> d = new ArrayList<>();
   private boolean e = false;

   private zzk() {
   }

   public static zzk a() {
      return a;
   }

   public static void a(Application param0) {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzk.a Lcom/google/android/gms/common/api/internal/zzk;
      // 03: astore 1
      // 04: aload 1
      // 05: monitorenter
      // 06: getstatic com/google/android/gms/common/api/internal/zzk.a Lcom/google/android/gms/common/api/internal/zzk;
      // 09: getfield com/google/android/gms/common/api/internal/zzk.e Z
      // 0c: ifne 24
      // 0f: aload 0
      // 10: getstatic com/google/android/gms/common/api/internal/zzk.a Lcom/google/android/gms/common/api/internal/zzk;
      // 13: invokevirtual android/app/Application.registerActivityLifecycleCallbacks (Landroid/app/Application$ActivityLifecycleCallbacks;)V
      // 16: aload 0
      // 17: getstatic com/google/android/gms/common/api/internal/zzk.a Lcom/google/android/gms/common/api/internal/zzk;
      // 1a: invokevirtual android/app/Application.registerComponentCallbacks (Landroid/content/ComponentCallbacks;)V
      // 1d: getstatic com/google/android/gms/common/api/internal/zzk.a Lcom/google/android/gms/common/api/internal/zzk;
      // 20: bipush 1
      // 21: putfield com/google/android/gms/common/api/internal/zzk.e Z
      // 24: aload 1
      // 25: monitorexit
      // 26: return
      // 27: astore 0
      // 28: aload 1
      // 29: monitorexit
      // 2a: aload 0
      // 2b: athrow
      // try (4 -> 16): 19 null
      // try (16 -> 18): 19 null
      // try (20 -> 22): 19 null
   }

   private final void b(boolean param1) {
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
      // 00: getstatic com/google/android/gms/common/api/internal/zzk.a Lcom/google/android/gms/common/api/internal/zzk;
      // 03: astore 4
      // 05: aload 4
      // 07: monitorenter
      // 08: aload 0
      // 09: getfield com/google/android/gms/common/api/internal/zzk.d Ljava/util/ArrayList;
      // 0c: checkcast java/util/ArrayList
      // 0f: astore 5
      // 11: aload 5
      // 13: invokevirtual java/util/ArrayList.size ()I
      // 16: istore 3
      // 17: bipush 0
      // 18: istore 2
      // 19: iload 2
      // 1a: iload 3
      // 1b: if_icmpge 3f
      // 1e: aload 5
      // 20: iload 2
      // 21: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 24: astore 6
      // 26: iinc 2 1
      // 29: aload 6
      // 2b: checkcast com/google/android/gms/common/api/internal/zzl
      // 2e: iload 1
      // 2f: invokeinterface com/google/android/gms/common/api/internal/zzl.a (Z)V 2
      // 34: goto 19
      // 37: astore 5
      // 39: aload 4
      // 3b: monitorexit
      // 3c: aload 5
      // 3e: athrow
      // 3f: aload 4
      // 41: monitorexit
      // 42: return
      // try (4 -> 11): 26 null
      // try (16 -> 20): 26 null
      // try (21 -> 25): 26 null
      // try (27 -> 29): 26 null
      // try (31 -> 33): 26 null
   }

   public final void a(zzl param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: getstatic com/google/android/gms/common/api/internal/zzk.a Lcom/google/android/gms/common/api/internal/zzk;
      // 03: astore 2
      // 04: aload 2
      // 05: monitorenter
      // 06: aload 0
      // 07: getfield com/google/android/gms/common/api/internal/zzk.d Ljava/util/ArrayList;
      // 0a: aload 1
      // 0b: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 0e: pop
      // 0f: aload 2
      // 10: monitorexit
      // 11: return
      // 12: astore 1
      // 13: aload 2
      // 14: monitorexit
      // 15: aload 1
      // 16: athrow
      // try (4 -> 11): 12 null
      // try (13 -> 15): 12 null
   }

   @TargetApi(16)
   public final boolean a(boolean var1) {
      var1 = true;
      if (!this.c.get()) {
         if (!com.google.android.gms.common.util.zzq.b()) {
            return var1;
         }

         RunningAppProcessInfo var2 = new RunningAppProcessInfo();
         ActivityManager.getMyMemoryState(var2);
         if (!this.c.getAndSet(true) && var2.importance > 100) {
            this.b.set(true);
         }
      }

      return this.b.get();
   }

   public final void onActivityCreated(Activity var1, Bundle var2) {
      boolean var3 = this.b.compareAndSet(true, false);
      this.c.set(true);
      if (var3) {
         this.b(false);
      }
   }

   public final void onActivityDestroyed(Activity var1) {
   }

   public final void onActivityPaused(Activity var1) {
   }

   public final void onActivityResumed(Activity var1) {
      boolean var2 = this.b.compareAndSet(true, false);
      this.c.set(true);
      if (var2) {
         this.b(false);
      }
   }

   public final void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public final void onActivityStarted(Activity var1) {
   }

   public final void onActivityStopped(Activity var1) {
   }

   public final void onConfigurationChanged(Configuration var1) {
   }

   public final void onLowMemory() {
   }

   public final void onTrimMemory(int var1) {
      if (var1 == 20 && this.b.compareAndSet(false, true)) {
         this.c.set(true);
         this.b(true);
      }
   }
}
