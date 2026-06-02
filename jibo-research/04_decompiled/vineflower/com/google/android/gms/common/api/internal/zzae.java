package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzae {
   private final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap<>());
   private final Map<TaskCompletionSource<?>, Boolean> b = Collections.synchronizedMap(new WeakHashMap<>());

   private final void a(boolean param1, Status param2) {
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
      // 00: aload 0
      // 01: getfield com/google/android/gms/common/api/internal/zzae.a Ljava/util/Map;
      // 04: astore 3
      // 05: aload 3
      // 06: monitorenter
      // 07: new java/util/HashMap
      // 0a: astore 5
      // 0c: aload 5
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/common/api/internal/zzae.a Ljava/util/Map;
      // 12: invokespecial java/util/HashMap.<init> (Ljava/util/Map;)V
      // 15: aload 3
      // 16: monitorexit
      // 17: aload 0
      // 18: getfield com/google/android/gms/common/api/internal/zzae.b Ljava/util/Map;
      // 1b: astore 4
      // 1d: aload 4
      // 1f: monitorenter
      // 20: new java/util/HashMap
      // 23: astore 3
      // 24: aload 3
      // 25: aload 0
      // 26: getfield com/google/android/gms/common/api/internal/zzae.b Ljava/util/Map;
      // 29: invokespecial java/util/HashMap.<init> (Ljava/util/Map;)V
      // 2c: aload 4
      // 2e: monitorexit
      // 2f: aload 5
      // 31: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 36: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 3b: astore 5
      // 3d: aload 5
      // 3f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 44: ifeq 83
      // 47: aload 5
      // 49: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4e: checkcast java/util/Map$Entry
      // 51: astore 4
      // 53: iload 1
      // 54: ifne 67
      // 57: aload 4
      // 59: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 5e: checkcast java/lang/Boolean
      // 61: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 64: ifeq 3d
      // 67: aload 4
      // 69: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 6e: checkcast com/google/android/gms/common/api/internal/BasePendingResult
      // 71: aload 2
      // 72: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.b (Lcom/google/android/gms/common/api/Status;)V
      // 75: goto 3d
      // 78: astore 2
      // 79: aload 3
      // 7a: monitorexit
      // 7b: aload 2
      // 7c: athrow
      // 7d: astore 2
      // 7e: aload 4
      // 80: monitorexit
      // 81: aload 2
      // 82: athrow
      // 83: aload 3
      // 84: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 89: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 8e: astore 4
      // 90: aload 4
      // 92: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 97: ifeq d0
      // 9a: aload 4
      // 9c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // a1: checkcast java/util/Map$Entry
      // a4: astore 3
      // a5: iload 1
      // a6: ifne b8
      // a9: aload 3
      // aa: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // af: checkcast java/lang/Boolean
      // b2: invokevirtual java/lang/Boolean.booleanValue ()Z
      // b5: ifeq 90
      // b8: aload 3
      // b9: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // be: checkcast com/google/android/gms/tasks/TaskCompletionSource
      // c1: new com/google/android/gms/common/api/ApiException
      // c4: dup
      // c5: aload 2
      // c6: invokespecial com/google/android/gms/common/api/ApiException.<init> (Lcom/google/android/gms/common/api/Status;)V
      // c9: invokevirtual com/google/android/gms/tasks/TaskCompletionSource.b (Ljava/lang/Exception;)Z
      // cc: pop
      // cd: goto 90
      // d0: return
      // try (5 -> 13): 50 null
      // try (18 -> 26): 55 null
      // try (51 -> 53): 50 null
      // try (56 -> 58): 55 null
   }

   final void a(BasePendingResult<? extends Result> var1, boolean var2) {
      this.a.put(var1, var2);
      var1.a(new zzaf(this, var1));
   }

   final boolean a() {
      boolean var1;
      if (this.a.isEmpty() && this.b.isEmpty()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public final void b() {
      this.a(false, zzbm.a);
   }

   public final void c() {
      this.a(true, zzdj.a);
   }
}
