package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.zzc;
import java.util.Collections;
import java.util.List;

public final class zza {
   private static final Object a = new Object();
   private static volatile zza b;
   private static boolean c = false;
   private final List<String> d = Collections.EMPTY_LIST;
   private final List<String> e = Collections.EMPTY_LIST;
   private final List<String> f = Collections.EMPTY_LIST;
   private final List<String> g = Collections.EMPTY_LIST;

   private zza() {
   }

   public static zza a() {
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
      // 00: getstatic com/google/android/gms/common/stats/zza.b Lcom/google/android/gms/common/stats/zza;
      // 03: ifnonnull 20
      // 06: getstatic com/google/android/gms/common/stats/zza.a Ljava/lang/Object;
      // 09: astore 0
      // 0a: aload 0
      // 0b: monitorenter
      // 0c: getstatic com/google/android/gms/common/stats/zza.b Lcom/google/android/gms/common/stats/zza;
      // 0f: ifnonnull 1e
      // 12: new com/google/android/gms/common/stats/zza
      // 15: astore 1
      // 16: aload 1
      // 17: invokespecial com/google/android/gms/common/stats/zza.<init> ()V
      // 1a: aload 1
      // 1b: putstatic com/google/android/gms/common/stats/zza.b Lcom/google/android/gms/common/stats/zza;
      // 1e: aload 0
      // 1f: monitorexit
      // 20: getstatic com/google/android/gms/common/stats/zza.b Lcom/google/android/gms/common/stats/zza;
      // 23: areturn
      // 24: astore 1
      // 25: aload 0
      // 26: monitorexit
      // 27: aload 1
      // 28: athrow
      // try (6 -> 14): 18 null
      // try (14 -> 16): 18 null
      // try (19 -> 21): 18 null
   }

   public final boolean a(Context var1, Intent var2, ServiceConnection var3, int var4) {
      return this.a(var1, var1.getClass().getName(), var2, var3, var4);
   }

   public final boolean a(Context var1, String var2, Intent var3, ServiceConnection var4, int var5) {
      boolean var7 = false;
      ComponentName var8 = var3.getComponent();
      boolean var6;
      if (var8 == null) {
         var6 = false;
      } else {
         var6 = zzc.a(var1, var8.getPackageName());
      }

      if (var6) {
         Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
         var6 = var7;
      } else {
         var6 = var1.bindService(var3, var4, var5);
      }

      return var6;
   }
}
