package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbha;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzaa implements zzcc {
   private final Map<Api.zzc<?>, zzz<?>> a = new HashMap<>();
   private final Map<Api.zzc<?>, zzz<?>> b = new HashMap<>();
   private final Map<Api<?>, Boolean> c;
   private final zzbm d;
   private final zzba e;
   private final Lock f;
   private final Looper g;
   private final com.google.android.gms.common.zzf h;
   private final Condition i;
   private final com.google.android.gms.common.internal.zzr j;
   private final boolean k;
   private final boolean l;
   private final Queue<zzm<?, ?>> m = new LinkedList<>();
   private boolean n;
   private Map<zzh<?>, ConnectionResult> o;
   private Map<zzh<?>, ConnectionResult> p;
   private zzad q;
   private ConnectionResult r;

   public zzaa(
      Context var1,
      Lock var2,
      Looper var3,
      com.google.android.gms.common.zzf var4,
      Map<Api.zzc<?>, Api.zze> var5,
      com.google.android.gms.common.internal.zzr var6,
      Map<Api<?>, Boolean> var7,
      Api.zza<? extends zzcxd, zzcxe> var8,
      ArrayList<zzt> var9,
      zzba var10,
      boolean var11
   ) {
      this.f = var2;
      this.g = var3;
      this.i = var2.newCondition();
      this.h = var4;
      this.e = var10;
      this.c = var7;
      this.j = var6;
      this.k = var11;
      HashMap var16 = new HashMap();

      for (Api var17 : var7.keySet()) {
         var16.put(var17.c(), var17);
      }

      HashMap var18 = new HashMap();
      ArrayList var21 = var9;
      int var13 = var21.size();
      int var12 = 0;

      while (var12 < var13) {
         Object var23 = var21.get(var12);
         var12++;
         zzt var24 = (zzt)var23;
         var18.put(var24.a, var24);
      }

      Iterator var22 = var5.entrySet().iterator();
      boolean var31 = true;
      boolean var29 = false;
      boolean var14 = false;

      while (var22.hasNext()) {
         Entry var19 = (Entry)var22.next();
         Api var26 = (Api)var16.get(var19.getKey());
         Api.zze var25 = (Api.zze)var19.getValue();
         if (var25.j()) {
            var14 = true;
            if (!this.c.get(var26)) {
               var29 = var31;
               var31 = true;
            } else {
               boolean var15 = var31;
               var31 = var29;
               var29 = var15;
            }
         } else {
            boolean var33 = false;
            var31 = var29;
            var29 = var33;
         }

         zzz var27 = new zzz(var1, var26, var3, var25, (zzt)var18.get(var26), var6, var8);
         this.a.put((Api.zzc<?>)var19.getKey(), var27);
         if (var25.i()) {
            this.b.put((Api.zzc<?>)var19.getKey(), var27);
         }

         boolean var34 = var31;
         var31 = var29;
         var29 = var34;
      }

      if (var14 && !var31 && !var29) {
         var11 = true;
      } else {
         var11 = false;
      }

      this.l = var11;
      this.d = zzbm.a();
   }

   private final ConnectionResult a(Api.zzc<?> param1) {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield com/google/android/gms/common/api/internal/zzaa.a Ljava/util/Map;
      // 0d: aload 1
      // 0e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 13: checkcast com/google/android/gms/common/api/internal/zzz
      // 16: astore 1
      // 17: aload 0
      // 18: getfield com/google/android/gms/common/api/internal/zzaa.o Ljava/util/Map;
      // 1b: ifnull 3e
      // 1e: aload 1
      // 1f: ifnull 3e
      // 22: aload 0
      // 23: getfield com/google/android/gms/common/api/internal/zzaa.o Ljava/util/Map;
      // 26: aload 1
      // 27: invokevirtual com/google/android/gms/common/api/GoogleApi.b ()Lcom/google/android/gms/common/api/internal/zzh;
      // 2a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 2f: checkcast com/google/android/gms/common/ConnectionResult
      // 32: astore 1
      // 33: aload 0
      // 34: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 37: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 3c: aload 1
      // 3d: areturn
      // 3e: aload 0
      // 3f: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 42: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 47: aconst_null
      // 48: astore 1
      // 49: goto 3c
      // 4c: astore 1
      // 4d: aload 0
      // 4e: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 51: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 56: aload 1
      // 57: athrow
      // try (3 -> 12): 32 null
      // try (14 -> 21): 32 null
   }

   private final boolean a(zzz<?> var1, ConnectionResult var2) {
      boolean var3;
      if (!var2.b() && !var2.a() && this.c.get(var1.a()) && var1.g().j() && this.h.a(var2.c())) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private final <T extends zzm<? extends Result, ? extends Api.zzb>> boolean c(T var1) {
      Api.zzc var3 = var1.g();
      ConnectionResult var4 = this.a(var3);
      boolean var2;
      if (var4 != null && var4.c() == 4) {
         var1.c(new Status(4, null, this.d.a(this.a.get(var3).b(), System.identityHashCode(this.e))));
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private final boolean h() {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield com/google/android/gms/common/api/internal/zzaa.n Z
      // 0d: ifeq 19
      // 10: aload 0
      // 11: getfield com/google/android/gms/common/api/internal/zzaa.k Z
      // 14: istore 1
      // 15: iload 1
      // 16: ifne 26
      // 19: aload 0
      // 1a: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 1d: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 22: bipush 0
      // 23: istore 1
      // 24: iload 1
      // 25: ireturn
      // 26: aload 0
      // 27: getfield com/google/android/gms/common/api/internal/zzaa.b Ljava/util/Map;
      // 2a: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 2f: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 34: astore 3
      // 35: aload 3
      // 36: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3b: ifeq 67
      // 3e: aload 0
      // 3f: aload 3
      // 40: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 45: checkcast com/google/android/gms/common/api/Api$zzc
      // 48: invokespecial com/google/android/gms/common/api/internal/zzaa.a (Lcom/google/android/gms/common/api/Api$zzc;)Lcom/google/android/gms/common/ConnectionResult;
      // 4b: astore 2
      // 4c: aload 2
      // 4d: ifnull 59
      // 50: aload 2
      // 51: invokevirtual com/google/android/gms/common/ConnectionResult.b ()Z
      // 54: istore 1
      // 55: iload 1
      // 56: ifne 35
      // 59: aload 0
      // 5a: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 5d: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 62: bipush 0
      // 63: istore 1
      // 64: goto 24
      // 67: aload 0
      // 68: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 6b: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 70: bipush 1
      // 71: istore 1
      // 72: goto 24
      // 75: astore 2
      // 76: aload 0
      // 77: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 7a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 7f: aload 2
      // 80: athrow
      // try (3 -> 9): 51 null
      // try (18 -> 23): 51 null
      // try (23 -> 32): 51 null
      // try (34 -> 37): 51 null
   }

   private final void i() {
      if (this.j == null) {
         this.e.c = Collections.emptySet();
      } else {
         HashSet var4 = new HashSet<>(this.j.d());
         Map var5 = this.j.f();

         for (Api var2 : var5.keySet()) {
            ConnectionResult var1 = this.a(var2);
            if (var1 != null && var1.b()) {
               var4.addAll(((com.google.android.gms.common.internal.zzt)var5.get(var2)).a);
            }
         }

         this.e.c = var4;
      }
   }

   private final void j() {
      while (!this.m.isEmpty()) {
         this.b(this.m.remove());
      }

      this.e.a((Bundle)null);
   }

   private final ConnectionResult k() {
      Iterator var7 = this.a.values().iterator();
      int var2 = 0;
      ConnectionResult var5 = null;
      int var1 = 0;
      ConnectionResult var4 = null;

      while (var7.hasNext()) {
         zzz var6 = (zzz)var7.next();
         Api var8 = var6.a();
         zzh var10 = var6.b();
         ConnectionResult var11 = this.o.get(var10);
         if (!var11.b() && (!this.c.get(var8) || var11.a() || this.h.a(var11.c()))) {
            if (var11.c() == 4 && this.k) {
               int var9 = var8.a().a();
               if (var5 == null || var2 > var9) {
                  var2 = var9;
                  var5 = var11;
               }
            } else {
               int var3 = var8.a().a();
               if (var4 == null || var1 > var3) {
                  var4 = var11;
                  var1 = var3;
               }
            }
         }
      }

      if (var4 == null || var5 == null || var1 <= var2) {
         var5 = var4;
      }

      return var5;
   }

   public final ConnectionResult a(Api<?> var1) {
      return this.a(var1.c());
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      if (!this.k || !this.c((T)var1)) {
         if (!this.d()) {
            this.m.add(var1);
         } else {
            this.e.e.a(var1);
            var1 = this.a.get(var1.g()).a(var1);
         }
      }

      return (T)var1;
   }

   @Override
   public final void a() {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield com/google/android/gms/common/api/internal/zzaa.n Z
      // 0d: istore 1
      // 0e: iload 1
      // 0f: ifeq 1c
      // 12: aload 0
      // 13: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 16: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 1b: return
      // 1c: aload 0
      // 1d: bipush 1
      // 1e: putfield com/google/android/gms/common/api/internal/zzaa.n Z
      // 21: aload 0
      // 22: aconst_null
      // 23: putfield com/google/android/gms/common/api/internal/zzaa.o Ljava/util/Map;
      // 26: aload 0
      // 27: aconst_null
      // 28: putfield com/google/android/gms/common/api/internal/zzaa.p Ljava/util/Map;
      // 2b: aload 0
      // 2c: aconst_null
      // 2d: putfield com/google/android/gms/common/api/internal/zzaa.q Lcom/google/android/gms/common/api/internal/zzad;
      // 30: aload 0
      // 31: aconst_null
      // 32: putfield com/google/android/gms/common/api/internal/zzaa.r Lcom/google/android/gms/common/ConnectionResult;
      // 35: aload 0
      // 36: getfield com/google/android/gms/common/api/internal/zzaa.d Lcom/google/android/gms/common/api/internal/zzbm;
      // 39: invokevirtual com/google/android/gms/common/api/internal/zzbm.d ()V
      // 3c: aload 0
      // 3d: getfield com/google/android/gms/common/api/internal/zzaa.d Lcom/google/android/gms/common/api/internal/zzbm;
      // 40: aload 0
      // 41: getfield com/google/android/gms/common/api/internal/zzaa.a Ljava/util/Map;
      // 44: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 49: invokevirtual com/google/android/gms/common/api/internal/zzbm.a (Ljava/lang/Iterable;)Lcom/google/android/gms/tasks/Task;
      // 4c: astore 2
      // 4d: new com/google/android/gms/internal/zzbha
      // 50: astore 3
      // 51: aload 3
      // 52: aload 0
      // 53: getfield com/google/android/gms/common/api/internal/zzaa.g Landroid/os/Looper;
      // 56: invokespecial com/google/android/gms/internal/zzbha.<init> (Landroid/os/Looper;)V
      // 59: new com/google/android/gms/common/api/internal/zzac
      // 5c: astore 4
      // 5e: aload 4
      // 60: aload 0
      // 61: aconst_null
      // 62: invokespecial com/google/android/gms/common/api/internal/zzac.<init> (Lcom/google/android/gms/common/api/internal/zzaa;Lcom/google/android/gms/common/api/internal/zzab;)V
      // 65: aload 2
      // 66: aload 3
      // 67: aload 4
      // 69: invokevirtual com/google/android/gms/tasks/Task.a (Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/OnCompleteListener;)Lcom/google/android/gms/tasks/Task;
      // 6c: pop
      // 6d: aload 0
      // 6e: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 71: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 76: goto 1b
      // 79: astore 2
      // 7a: aload 0
      // 7b: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 7e: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 83: aload 2
      // 84: athrow
      // try (3 -> 6): 58 null
      // try (12 -> 54): 58 null
   }

   @Override
   public final void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
   }

   @Override
   public final boolean a(zzcu var1) {
      this.f.lock();

      try {
         if (!this.n || this.h()) {
            return false;
         }

         this.d.d();
         zzad var3 = new zzad(this, var1);
         this.q = var3;
         Task var7 = this.d.a(this.b.values());
         zzbha var6 = new zzbha(this.g);
         var7.a(var6, this.q);
      } finally {
         this.f.unlock();
      }

      return true;
   }

   @Override
   public final ConnectionResult b() {
      this.a();

      ConnectionResult var1;
      while (true) {
         if (!this.e()) {
            if (this.d()) {
               var1 = ConnectionResult.a;
            } else if (this.r != null) {
               var1 = this.r;
            } else {
               var1 = new ConnectionResult(13, null);
            }
            break;
         }

         try {
            this.i.await();
         } catch (InterruptedException var2) {
            Thread.currentThread().interrupt();
            var1 = new ConnectionResult(15, null);
            break;
         }
      }

      return var1;
   }

   @Override
   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      Api.zzc var2 = var1.g();
      if (!this.k || !this.c((T)var1)) {
         this.e.e.a(var1);
         var1 = this.a.get(var2).b(var1);
      }

      return (T)var1;
   }

   @Override
   public final void c() {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: bipush 0
      // 0b: putfield com/google/android/gms/common/api/internal/zzaa.n Z
      // 0e: aload 0
      // 0f: aconst_null
      // 10: putfield com/google/android/gms/common/api/internal/zzaa.o Ljava/util/Map;
      // 13: aload 0
      // 14: aconst_null
      // 15: putfield com/google/android/gms/common/api/internal/zzaa.p Ljava/util/Map;
      // 18: aload 0
      // 19: getfield com/google/android/gms/common/api/internal/zzaa.q Lcom/google/android/gms/common/api/internal/zzad;
      // 1c: ifnull 2b
      // 1f: aload 0
      // 20: getfield com/google/android/gms/common/api/internal/zzaa.q Lcom/google/android/gms/common/api/internal/zzad;
      // 23: invokevirtual com/google/android/gms/common/api/internal/zzad.a ()V
      // 26: aload 0
      // 27: aconst_null
      // 28: putfield com/google/android/gms/common/api/internal/zzaa.q Lcom/google/android/gms/common/api/internal/zzad;
      // 2b: aload 0
      // 2c: aconst_null
      // 2d: putfield com/google/android/gms/common/api/internal/zzaa.r Lcom/google/android/gms/common/ConnectionResult;
      // 30: aload 0
      // 31: getfield com/google/android/gms/common/api/internal/zzaa.m Ljava/util/Queue;
      // 34: invokeinterface java/util/Queue.isEmpty ()Z 1
      // 39: ifne 61
      // 3c: aload 0
      // 3d: getfield com/google/android/gms/common/api/internal/zzaa.m Ljava/util/Queue;
      // 40: invokeinterface java/util/Queue.remove ()Ljava/lang/Object; 1
      // 45: checkcast com/google/android/gms/common/api/internal/zzm
      // 48: astore 1
      // 49: aload 1
      // 4a: aconst_null
      // 4b: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.a (Lcom/google/android/gms/common/api/internal/zzdm;)V
      // 4e: aload 1
      // 4f: invokevirtual com/google/android/gms/common/api/PendingResult.a ()V
      // 52: goto 30
      // 55: astore 1
      // 56: aload 0
      // 57: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 5a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 5f: aload 1
      // 60: athrow
      // 61: aload 0
      // 62: getfield com/google/android/gms/common/api/internal/zzaa.i Ljava/util/concurrent/locks/Condition;
      // 65: invokeinterface java/util/concurrent/locks/Condition.signalAll ()V 1
      // 6a: aload 0
      // 6b: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 6e: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 73: return
      // try (3 -> 21): 39 null
      // try (21 -> 24): 39 null
      // try (24 -> 38): 39 null
      // try (45 -> 48): 39 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public final boolean d() {
      this.f.lock();
      boolean var4 = false /* VF: Semaphore variable */;

      boolean var1;
      label37: {
         label36: {
            ConnectionResult var2;
            try {
               var4 = true;
               if (this.o == null) {
                  var4 = false;
                  break label36;
               }

               var2 = this.r;
               var4 = false;
            } finally {
               if (var4) {
                  this.f.unlock();
               }
            }

            if (var2 == null) {
               var1 = true;
               break label37;
            }
         }

         var1 = false;
      }

      this.f.unlock();
      return var1;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public final boolean e() {
      this.f.lock();
      boolean var4 = false /* VF: Semaphore variable */;

      boolean var6;
      label37: {
         label36: {
            try {
               var4 = true;
               if (this.o != null) {
                  var4 = false;
                  break label36;
               }

               var6 = this.n;
               var4 = false;
            } finally {
               if (var4) {
                  this.f.unlock();
               }
            }

            if (var6) {
               var6 = true;
               break label37;
            }
         }

         var6 = false;
      }

      this.f.unlock();
      return var6;
   }

   @Override
   public final void f() {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield com/google/android/gms/common/api/internal/zzaa.d Lcom/google/android/gms/common/api/internal/zzbm;
      // 0d: invokevirtual com/google/android/gms/common/api/internal/zzbm.e ()V
      // 10: aload 0
      // 11: getfield com/google/android/gms/common/api/internal/zzaa.q Lcom/google/android/gms/common/api/internal/zzad;
      // 14: ifnull 23
      // 17: aload 0
      // 18: getfield com/google/android/gms/common/api/internal/zzaa.q Lcom/google/android/gms/common/api/internal/zzad;
      // 1b: invokevirtual com/google/android/gms/common/api/internal/zzad.a ()V
      // 1e: aload 0
      // 1f: aconst_null
      // 20: putfield com/google/android/gms/common/api/internal/zzaa.q Lcom/google/android/gms/common/api/internal/zzad;
      // 23: aload 0
      // 24: getfield com/google/android/gms/common/api/internal/zzaa.p Ljava/util/Map;
      // 27: ifnonnull 40
      // 2a: new android/support/v4/util/ArrayMap
      // 2d: astore 1
      // 2e: aload 1
      // 2f: aload 0
      // 30: getfield com/google/android/gms/common/api/internal/zzaa.b Ljava/util/Map;
      // 33: invokeinterface java/util/Map.size ()I 1
      // 38: invokespecial android/support/v4/util/ArrayMap.<init> (I)V
      // 3b: aload 0
      // 3c: aload 1
      // 3d: putfield com/google/android/gms/common/api/internal/zzaa.p Ljava/util/Map;
      // 40: new com/google/android/gms/common/ConnectionResult
      // 43: astore 2
      // 44: aload 2
      // 45: bipush 4
      // 46: invokespecial com/google/android/gms/common/ConnectionResult.<init> (I)V
      // 49: aload 0
      // 4a: getfield com/google/android/gms/common/api/internal/zzaa.b Ljava/util/Map;
      // 4d: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 52: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 57: astore 3
      // 58: aload 3
      // 59: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 5e: ifeq 89
      // 61: aload 3
      // 62: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 67: checkcast com/google/android/gms/common/api/internal/zzz
      // 6a: astore 1
      // 6b: aload 0
      // 6c: getfield com/google/android/gms/common/api/internal/zzaa.p Ljava/util/Map;
      // 6f: aload 1
      // 70: invokevirtual com/google/android/gms/common/api/GoogleApi.b ()Lcom/google/android/gms/common/api/internal/zzh;
      // 73: aload 2
      // 74: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 79: pop
      // 7a: goto 58
      // 7d: astore 1
      // 7e: aload 0
      // 7f: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // 82: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 87: aload 1
      // 88: athrow
      // 89: aload 0
      // 8a: getfield com/google/android/gms/common/api/internal/zzaa.o Ljava/util/Map;
      // 8d: ifnull 9d
      // 90: aload 0
      // 91: getfield com/google/android/gms/common/api/internal/zzaa.o Ljava/util/Map;
      // 94: aload 0
      // 95: getfield com/google/android/gms/common/api/internal/zzaa.p Ljava/util/Map;
      // 98: invokeinterface java/util/Map.putAll (Ljava/util/Map;)V 2
      // 9d: aload 0
      // 9e: getfield com/google/android/gms/common/api/internal/zzaa.f Ljava/util/concurrent/locks/Lock;
      // a1: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // a6: return
      // try (3 -> 15): 53 null
      // try (15 -> 28): 53 null
      // try (28 -> 38): 53 null
      // try (38 -> 52): 53 null
      // try (59 -> 67): 53 null
   }

   @Override
   public final void g() {
   }
}
