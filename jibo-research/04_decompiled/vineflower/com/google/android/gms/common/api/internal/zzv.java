package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;

final class zzv implements zzcc {
   private final Context a;
   private final zzba b;
   private final Looper c;
   private final zzbi d;
   private final zzbi e;
   private final Map<Api.zzc<?>, zzbi> f;
   private final Set<zzcu> g = Collections.newSetFromMap(new WeakHashMap<>());
   private final Api.zze h;
   private Bundle i;
   private ConnectionResult j = null;
   private ConnectionResult k = null;
   private boolean l = false;
   private final Lock m;
   private int n = 0;

   private zzv(
      Context var1,
      zzba var2,
      Lock var3,
      Looper var4,
      com.google.android.gms.common.zzf var5,
      Map<Api.zzc<?>, Api.zze> var6,
      Map<Api.zzc<?>, Api.zze> var7,
      com.google.android.gms.common.internal.zzr var8,
      Api.zza<? extends zzcxd, zzcxe> var9,
      Api.zze var10,
      ArrayList<zzt> var11,
      ArrayList<zzt> var12,
      Map<Api<?>, Boolean> var13,
      Map<Api<?>, Boolean> var14
   ) {
      this.a = var1;
      this.b = var2;
      this.m = var3;
      this.c = var4;
      this.h = var10;
      this.d = new zzbi(var1, this.b, var3, var4, var5, var7, null, var14, null, var12, new zzx(this, null));
      this.e = new zzbi(var1, this.b, var3, var4, var5, var6, var8, var13, var9, var11, new zzy(this, null));
      ArrayMap var15 = new ArrayMap();
      Iterator var16 = var7.keySet().iterator();

      while (var16.hasNext()) {
         var15.put((Api.zzc)var16.next(), this.d);
      }

      Iterator var17 = var6.keySet().iterator();

      while (var17.hasNext()) {
         var15.put((Api.zzc)var17.next(), this.e);
      }

      this.f = Collections.unmodifiableMap(var15);
   }

   public static zzv a(
      Context var0,
      zzba var1,
      Lock var2,
      Looper var3,
      com.google.android.gms.common.zzf var4,
      Map<Api.zzc<?>, Api.zze> var5,
      com.google.android.gms.common.internal.zzr var6,
      Map<Api<?>, Boolean> var7,
      Api.zza<? extends zzcxd, zzcxe> var8,
      ArrayList<zzt> var9
   ) {
      Api.zze var13 = null;
      ArrayMap var15 = new ArrayMap();
      ArrayMap var14 = new ArrayMap();
      Iterator var16 = var5.entrySet().iterator();
      Api.zze var20 = var13;

      while (var16.hasNext()) {
         Entry var17 = (Entry)var16.next();
         var13 = (Api.zze)var17.getValue();
         if (var13.c()) {
            var20 = var13;
         }

         if (var13.i()) {
            var15.put((Api.zzc)var17.getKey(), var13);
         } else {
            var14.put((Api.zzc)var17.getKey(), var13);
         }
      }

      boolean var12;
      if (!var15.isEmpty()) {
         var12 = true;
      } else {
         var12 = false;
      }

      com.google.android.gms.common.internal.zzbq.a(var12, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      ArrayMap var25 = new ArrayMap();
      ArrayMap var24 = new ArrayMap();

      for (Api var18 : var7.keySet()) {
         Api.zzc var19 = var18.c();
         if (var15.containsKey(var19)) {
            var25.put(var18, (Boolean)var7.get(var18));
         } else {
            if (!var14.containsKey(var19)) {
               throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }

            var24.put(var18, (Boolean)var7.get(var18));
         }
      }

      ArrayList var27 = new ArrayList();
      ArrayList var21 = new ArrayList();
      var9 = var9;
      int var11 = var9.size();
      int var10 = 0;

      while (var10 < var11) {
         Object var28 = var9.get(var10);
         var10++;
         zzt var29 = (zzt)var28;
         if (var25.containsKey(var29.a)) {
            var27.add(var29);
         } else {
            if (!var24.containsKey(var29.a)) {
               throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }

            var21.add(var29);
         }
      }

      return new zzv(var0, var1, var2, var3, var4, var15, var14, var6, var8, var20, var27, var21, var25, var24);
   }

   private final void a(int var1, boolean var2) {
      this.b.a(var1, var2);
      this.k = null;
      this.j = null;
   }

   private final void a(Bundle var1) {
      if (this.i == null) {
         this.i = var1;
      } else if (var1 != null) {
         this.i.putAll(var1);
      }
   }

   private final void a(ConnectionResult var1) {
      switch (this.n) {
         case 2:
            this.b.a(var1);
         case 1:
            this.i();
            break;
         default:
            Log.wtf(
               "CompositeGAC",
               "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor",
               new Exception()
            );
      }

      this.n = 0;
   }

   private static boolean b(ConnectionResult var0) {
      boolean var1;
      if (var0 != null && var0.b()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private final boolean c(zzm<? extends Result, ? extends Api.zzb> var1) {
      Api.zzc var2 = var1.g();
      com.google.android.gms.common.internal.zzbq.b(this.f.containsKey(var2), "GoogleApiClient is not configured to use the API required for this call.");
      return this.f.get(var2).equals(this.e);
   }

   private final void h() {
      if (b(this.j)) {
         if (b(this.k) || this.j()) {
            switch (this.n) {
               case 2:
                  this.b.a(this.i);
               case 1:
                  this.i();
                  break;
               default:
                  Log.wtf(
                     "CompositeGAC",
                     "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor",
                     new AssertionError()
                  );
            }

            this.n = 0;
         } else if (this.k != null) {
            if (this.n == 1) {
               this.i();
            } else {
               this.a(this.k);
               this.d.c();
            }
         }
      } else if (this.j != null && b(this.k)) {
         this.e.c();
         this.a(this.j);
      } else if (this.j != null && this.k != null) {
         ConnectionResult var1 = this.j;
         if (this.e.c < this.d.c) {
            var1 = this.k;
         }

         this.a(var1);
      }
   }

   private final void i() {
      Iterator var1 = this.g.iterator();

      while (var1.hasNext()) {
         ((zzcu)var1.next()).h();
      }

      this.g.clear();
   }

   private final boolean j() {
      boolean var1;
      if (this.k != null && this.k.c() == 4) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private final PendingIntent k() {
      PendingIntent var1;
      if (this.h == null) {
         var1 = null;
      } else {
         var1 = PendingIntent.getActivity(this.a, System.identityHashCode(this.b), this.h.d(), 134217728);
      }

      return var1;
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      if (this.c(var1)) {
         if (this.j()) {
            var1.c(new Status(4, null, this.k()));
         } else {
            var1 = this.e.a(var1);
         }
      } else {
         var1 = this.d.a(var1);
      }

      return (T)var1;
   }

   @Override
   public final void a() {
      this.n = 2;
      this.l = false;
      this.k = null;
      this.j = null;
      this.d.a();
      this.e.a();
   }

   @Override
   public final void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.append(var1).append("authClient").println(":");
      this.e.a(String.valueOf(var1).concat("  "), var2, var3, var4);
      var3.append(var1).append("anonClient").println(":");
      this.d.a(String.valueOf(var1).concat("  "), var2, var3, var4);
   }

   @Override
   public final boolean a(zzcu var1) {
      boolean var2 = true;
      this.m.lock();

      try {
         if ((this.e() || this.d()) && !this.e.d()) {
            this.g.add(var1);
            if (this.n == 0) {
               this.n = 1;
            }

            this.k = null;
            this.e.a();
            return var2;
         }
      } finally {
         this.m.unlock();
      }

      return false;
   }

   @Override
   public final ConnectionResult b() {
      throw new UnsupportedOperationException();
   }

   @Override
   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      if (this.c(var1)) {
         if (this.j()) {
            var1.c(new Status(4, null, this.k()));
         } else {
            var1 = this.e.b(var1);
         }
      } else {
         var1 = this.d.b(var1);
      }

      return (T)var1;
   }

   @Override
   public final void c() {
      this.k = null;
      this.j = null;
      this.n = 0;
      this.d.c();
      this.e.c();
      this.i();
   }

   @Override
   public final boolean d() {
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
      // 00: bipush 1
      // 01: istore 3
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/api/internal/zzv.m Ljava/util/concurrent/locks/Lock;
      // 06: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 0b: aload 0
      // 0c: getfield com/google/android/gms/common/api/internal/zzv.d Lcom/google/android/gms/common/api/internal/zzbi;
      // 0f: invokevirtual com/google/android/gms/common/api/internal/zzbi.d ()Z
      // 12: ifeq 41
      // 15: iload 3
      // 16: istore 2
      // 17: aload 0
      // 18: getfield com/google/android/gms/common/api/internal/zzv.e Lcom/google/android/gms/common/api/internal/zzbi;
      // 1b: invokevirtual com/google/android/gms/common/api/internal/zzbi.d ()Z
      // 1e: ifne 36
      // 21: iload 3
      // 22: istore 2
      // 23: aload 0
      // 24: invokespecial com/google/android/gms/common/api/internal/zzv.j ()Z
      // 27: ifne 36
      // 2a: aload 0
      // 2b: getfield com/google/android/gms/common/api/internal/zzv.n I
      // 2e: istore 1
      // 2f: iload 1
      // 30: bipush 1
      // 31: if_icmpne 41
      // 34: iload 3
      // 35: istore 2
      // 36: aload 0
      // 37: getfield com/google/android/gms/common/api/internal/zzv.m Ljava/util/concurrent/locks/Lock;
      // 3a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 3f: iload 2
      // 40: ireturn
      // 41: bipush 0
      // 42: istore 2
      // 43: goto 36
      // 46: astore 4
      // 48: aload 0
      // 49: getfield com/google/android/gms/common/api/internal/zzv.m Ljava/util/concurrent/locks/Lock;
      // 4c: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 51: aload 4
      // 53: athrow
      // try (5 -> 9): 36 null
      // try (11 -> 15): 36 null
      // try (17 -> 23): 36 null
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public final boolean e() {
      this.m.lock();
      boolean var5 = false /* VF: Semaphore variable */;

      int var1;
      try {
         var5 = true;
         var1 = this.n;
         var5 = false;
      } finally {
         if (var5) {
            this.m.unlock();
         }
      }

      boolean var2;
      if (var1 == 2) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.m.unlock();
      return var2;
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
      // 01: getfield com/google/android/gms/common/api/internal/zzv.m Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: invokevirtual com/google/android/gms/common/api/internal/zzv.e ()Z
      // 0d: istore 1
      // 0e: aload 0
      // 0f: getfield com/google/android/gms/common/api/internal/zzv.e Lcom/google/android/gms/common/api/internal/zzbi;
      // 12: invokevirtual com/google/android/gms/common/api/internal/zzbi.c ()V
      // 15: new com/google/android/gms/common/ConnectionResult
      // 18: astore 2
      // 19: aload 2
      // 1a: bipush 4
      // 1b: invokespecial com/google/android/gms/common/ConnectionResult.<init> (I)V
      // 1e: aload 0
      // 1f: aload 2
      // 20: putfield com/google/android/gms/common/api/internal/zzv.k Lcom/google/android/gms/common/ConnectionResult;
      // 23: iload 1
      // 24: ifeq 4c
      // 27: new android/os/Handler
      // 2a: astore 3
      // 2b: aload 3
      // 2c: aload 0
      // 2d: getfield com/google/android/gms/common/api/internal/zzv.c Landroid/os/Looper;
      // 30: invokespecial android/os/Handler.<init> (Landroid/os/Looper;)V
      // 33: new com/google/android/gms/common/api/internal/zzw
      // 36: astore 2
      // 37: aload 2
      // 38: aload 0
      // 39: invokespecial com/google/android/gms/common/api/internal/zzw.<init> (Lcom/google/android/gms/common/api/internal/zzv;)V
      // 3c: aload 3
      // 3d: aload 2
      // 3e: invokevirtual android/os/Handler.post (Ljava/lang/Runnable;)Z
      // 41: pop
      // 42: aload 0
      // 43: getfield com/google/android/gms/common/api/internal/zzv.m Ljava/util/concurrent/locks/Lock;
      // 46: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 4b: return
      // 4c: aload 0
      // 4d: invokespecial com/google/android/gms/common/api/internal/zzv.i ()V
      // 50: goto 42
      // 53: astore 2
      // 54: aload 0
      // 55: getfield com/google/android/gms/common/api/internal/zzv.m Ljava/util/concurrent/locks/Lock;
      // 58: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 5d: aload 2
      // 5e: athrow
      // try (3 -> 17): 41 null
      // try (19 -> 34): 41 null
      // try (38 -> 40): 41 null
   }

   @Override
   public final void g() {
      this.d.g();
      this.e.g();
   }
}
