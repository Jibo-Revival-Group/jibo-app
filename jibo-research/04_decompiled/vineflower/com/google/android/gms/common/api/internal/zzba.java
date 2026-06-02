package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbft;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzba extends GoogleApiClient implements zzcd {
   final Queue<zzm<?, ?>> a;
   final Map<Api.zzc<?>, Api.zze> b;
   Set<Scope> c;
   Set<zzdg> d;
   final zzdj e;
   private final Lock f;
   private boolean g;
   private final com.google.android.gms.common.internal.zzae h;
   private zzcc i = null;
   private final int j;
   private final Context k;
   private final Looper l;
   private volatile boolean m;
   private long n;
   private long o;
   private final zzbf p;
   private final GoogleApiAvailability q;
   private zzbx r;
   private com.google.android.gms.common.internal.zzr s;
   private Map<Api<?>, Boolean> t;
   private Api.zza<? extends zzcxd, zzcxe> u;
   private final zzcm v;
   private final ArrayList<zzt> w;
   private Integer x;
   private final com.google.android.gms.common.internal.zzaf y;

   public zzba(
      Context var1,
      Lock var2,
      Looper var3,
      com.google.android.gms.common.internal.zzr var4,
      GoogleApiAvailability var5,
      Api.zza<? extends zzcxd, zzcxe> var6,
      Map<Api<?>, Boolean> var7,
      List<GoogleApiClient.ConnectionCallbacks> var8,
      List<GoogleApiClient.OnConnectionFailedListener> var9,
      Map<Api.zzc<?>, Api.zze> var10,
      int var11,
      int var12,
      ArrayList<zzt> var13,
      boolean var14
   ) {
      this.a = new LinkedList<>();
      this.n = 120000L;
      this.o = 5000L;
      this.c = new HashSet<>();
      this.v = new zzcm();
      this.x = null;
      this.d = null;
      this.y = new zzbb(this);
      this.k = var1;
      this.f = var2;
      this.g = false;
      this.h = new com.google.android.gms.common.internal.zzae(var3, this.y);
      this.l = var3;
      this.p = new zzbf(this, var3);
      this.q = var5;
      this.j = var11;
      if (this.j >= 0) {
         this.x = var12;
      }

      this.t = var7;
      this.b = var10;
      this.w = var13;
      this.e = new zzdj(this.b);

      for (GoogleApiClient.ConnectionCallbacks var17 : var8) {
         this.h.a(var17);
      }

      for (GoogleApiClient.OnConnectionFailedListener var18 : var9) {
         this.h.a(var18);
      }

      this.s = var4;
      this.u = var6;
   }

   public static int a(Iterable<Api.zze> var0, boolean var1) {
      byte var4 = 1;
      Iterator var6 = var0.iterator();
      boolean var2 = false;
      byte var3 = 0;

      while (var6.hasNext()) {
         Api.zze var5 = (Api.zze)var6.next();
         if (var5.i()) {
            var3 = 1;
         }

         if (var5.c()) {
            var2 = true;
         }
      }

      if (var3) {
         var3 = var4;
         if (var2) {
            var3 = var4;
            if (var1) {
               var3 = 2;
            }
         }
      } else {
         var3 = 3;
      }

      return var3;
   }

   private final void a(GoogleApiClient var1, zzda var2, boolean var3) {
      zzbft.c.a(var1).a(new zzbe(this, var2, var3, var1));
   }

   private final void b(int var1) {
      if (this.x == null) {
         this.x = var1;
      } else if (this.x != var1) {
         String var7 = c(var1);
         String var6 = c(this.x);
         throw new IllegalStateException(
            new StringBuilder(String.valueOf(var7).length() + 51 + String.valueOf(var6).length())
               .append("Cannot use sign-in mode: ")
               .append(var7)
               .append(". Mode was already set to ")
               .append(var6)
               .toString()
         );
      }

      if (this.i == null) {
         Iterator var3 = this.b.values().iterator();
         boolean var5 = false;
         boolean var2 = false;

         while (var3.hasNext()) {
            Api.zze var4 = (Api.zze)var3.next();
            if (var4.i()) {
               var2 = true;
            }

            if (var4.c()) {
               var5 = true;
            }
         }

         switch (this.x) {
            case 1:
               if (!var2) {
                  throw new IllegalStateException(
                     "SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead."
                  );
               }

               if (var5) {
                  throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
               }
               break;
            case 2:
               if (var2) {
                  if (this.g) {
                     this.i = new zzaa(this.k, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this, true);
                  } else {
                     this.i = zzv.a(this.k, this, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w);
                  }

                  return;
               }
            case 3:
         }

         if (this.g && !var5) {
            this.i = new zzaa(this.k, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this, false);
         } else {
            this.i = new zzbi(this.k, this, this.f, this.l, this.q, this.b, this.s, this.t, this.u, this.w, this);
         }
      }
   }

   private static String c(int var0) {
      String var1;
      switch (var0) {
         case 1:
            var1 = "SIGN_IN_MODE_REQUIRED";
            break;
         case 2:
            var1 = "SIGN_IN_MODE_OPTIONAL";
            break;
         case 3:
            var1 = "SIGN_IN_MODE_NONE";
            break;
         default:
            var1 = "UNKNOWN";
      }

      return var1;
   }

   private final void o() {
      this.h.b();
      this.i.a();
   }

   private final void p() {
      this.f.lock();

      try {
         if (this.m) {
            this.o();
         }
      } finally {
         this.f.unlock();
      }
   }

   private final void q() {
      this.f.lock();

      try {
         if (this.l()) {
            this.o();
         }
      } finally {
         this.f.unlock();
      }
   }

   @Override
   public final <C extends Api.zze> C a(Api.zzc<C> var1) {
      Api.zze var2 = this.b.get(var1);
      com.google.android.gms.common.internal.zzbq.a(var2, "Appropriate Api was not requested.");
      return (C)var2;
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      boolean var2;
      if (var1.g() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      com.google.android.gms.common.internal.zzbq.b(var2, "This task can not be enqueued (it's probably a Batch or malformed)");
      var2 = this.b.containsKey(var1.g());
      String var3;
      if (var1.h() != null) {
         var3 = var1.h().d();
      } else {
         var3 = "the API";
      }

      com.google.android.gms.common.internal.zzbq.b(
         var2,
         new StringBuilder(String.valueOf(var3).length() + 65)
            .append("GoogleApiClient is not configured to use ")
            .append(var3)
            .append(" required for this call.")
            .toString()
      );
      this.f.lock();

      try {
         if (this.i == null) {
            this.a.add(var1);
         } else {
            var1 = this.i.a(var1);
         }
      } finally {
         this.f.unlock();
      }

      return (T)var1;
   }

   @Override
   public final void a(int var1) {
      boolean var3 = true;
      this.f.lock();
      boolean var2 = var3;
      if (var1 != 3) {
         var2 = var3;
         if (var1 != 1) {
            if (var1 == 2) {
               var2 = var3;
            } else {
               var2 = false;
            }
         }
      }

      try {
         StringBuilder var4 = new StringBuilder(33);
         com.google.android.gms.common.internal.zzbq.b(var2, var4.append("Illegal sign-in mode: ").append(var1).toString());
         this.b(var1);
         this.o();
      } finally {
         this.f.unlock();
      }
   }

   @Override
   public final void a(int var1, boolean var2) {
      if (var1 == 1 && !var2 && !this.m) {
         this.m = true;
         if (this.r == null) {
            this.r = GoogleApiAvailability.a(this.k.getApplicationContext(), new zzbg(this));
         }

         this.p.sendMessageDelayed(this.p.obtainMessage(1), this.n);
         this.p.sendMessageDelayed(this.p.obtainMessage(2), this.o);
      }

      this.e.b();
      this.h.a(var1);
      this.h.a();
      if (var1 == 2) {
         this.o();
      }
   }

   @Override
   public final void a(Bundle var1) {
      while (!this.a.isEmpty()) {
         this.b(this.a.remove());
      }

      this.h.a(var1);
   }

   @Override
   public final void a(ConnectionResult var1) {
      if (!com.google.android.gms.common.zzf.b(this.k, var1.c())) {
         this.l();
      }

      if (!this.m) {
         this.h.a(var1);
         this.h.a();
      }
   }

   @Override
   public final void a(GoogleApiClient.OnConnectionFailedListener var1) {
      this.h.a(var1);
   }

   @Override
   public final void a(zzdg var1) {
      this.f.lock();

      try {
         if (this.d == null) {
            HashSet var2 = new HashSet();
            this.d = var2;
         }

         this.d.add(var1);
      } finally {
         this.f.unlock();
      }
   }

   @Override
   public final void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.append(var1).append("mContext=").println(this.k);
      var3.append(var1).append("mResuming=").print(this.m);
      var3.append(" mWorkQueue.size()=").print(this.a.size());
      zzdj var5 = this.e;
      var3.append(" mUnconsumedApiCalls.size()=").println(var5.b.size());
      if (this.i != null) {
         this.i.a(var1, var2, var3, var4);
      }
   }

   @Override
   public final boolean a(zzcu var1) {
      boolean var2;
      if (this.i != null && this.i.a(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public final Context b() {
      return this.k;
   }

   @Override
   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T param1) {
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
      // 00: aload 1
      // 01: invokevirtual com/google/android/gms/common/api/internal/zzm.g ()Lcom/google/android/gms/common/api/Api$zzc;
      // 04: ifnull 7e
      // 07: bipush 1
      // 08: istore 2
      // 09: iload 2
      // 0a: ldc_w "This task can not be executed (it's probably a Batch or malformed)"
      // 0d: invokestatic com/google/android/gms/common/internal/zzbq.b (ZLjava/lang/Object;)V
      // 10: aload 0
      // 11: getfield com/google/android/gms/common/api/internal/zzba.b Ljava/util/Map;
      // 14: aload 1
      // 15: invokevirtual com/google/android/gms/common/api/internal/zzm.g ()Lcom/google/android/gms/common/api/Api$zzc;
      // 18: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 1d: istore 2
      // 1e: aload 1
      // 1f: invokevirtual com/google/android/gms/common/api/internal/zzm.h ()Lcom/google/android/gms/common/api/Api;
      // 22: ifnull 83
      // 25: aload 1
      // 26: invokevirtual com/google/android/gms/common/api/internal/zzm.h ()Lcom/google/android/gms/common/api/Api;
      // 29: invokevirtual com/google/android/gms/common/api/Api.d ()Ljava/lang/String;
      // 2c: astore 3
      // 2d: iload 2
      // 2e: new java/lang/StringBuilder
      // 31: dup
      // 32: aload 3
      // 33: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 36: invokevirtual java/lang/String.length ()I
      // 39: bipush 65
      // 3b: iadd
      // 3c: invokespecial java/lang/StringBuilder.<init> (I)V
      // 3f: ldc_w "GoogleApiClient is not configured to use "
      // 42: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 45: aload 3
      // 46: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 49: ldc_w " required for this call."
      // 4c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 52: invokestatic com/google/android/gms/common/internal/zzbq.b (ZLjava/lang/Object;)V
      // 55: aload 0
      // 56: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 59: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 5e: aload 0
      // 5f: getfield com/google/android/gms/common/api/internal/zzba.i Lcom/google/android/gms/common/api/internal/zzcc;
      // 62: ifnonnull 8a
      // 65: new java/lang/IllegalStateException
      // 68: astore 1
      // 69: aload 1
      // 6a: ldc_w "GoogleApiClient is not connected yet."
      // 6d: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 70: aload 1
      // 71: athrow
      // 72: astore 1
      // 73: aload 0
      // 74: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 77: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 7c: aload 1
      // 7d: athrow
      // 7e: bipush 0
      // 7f: istore 2
      // 80: goto 09
      // 83: ldc_w "the API"
      // 86: astore 3
      // 87: goto 2d
      // 8a: aload 0
      // 8b: getfield com/google/android/gms/common/api/internal/zzba.m Z
      // 8e: ifeq d2
      // 91: aload 0
      // 92: getfield com/google/android/gms/common/api/internal/zzba.a Ljava/util/Queue;
      // 95: aload 1
      // 96: invokeinterface java/util/Queue.add (Ljava/lang/Object;)Z 2
      // 9b: pop
      // 9c: aload 0
      // 9d: getfield com/google/android/gms/common/api/internal/zzba.a Ljava/util/Queue;
      // a0: invokeinterface java/util/Queue.isEmpty ()Z 1
      // a5: ifne c7
      // a8: aload 0
      // a9: getfield com/google/android/gms/common/api/internal/zzba.a Ljava/util/Queue;
      // ac: invokeinterface java/util/Queue.remove ()Ljava/lang/Object; 1
      // b1: checkcast com/google/android/gms/common/api/internal/zzm
      // b4: astore 3
      // b5: aload 0
      // b6: getfield com/google/android/gms/common/api/internal/zzba.e Lcom/google/android/gms/common/api/internal/zzdj;
      // b9: aload 3
      // ba: invokevirtual com/google/android/gms/common/api/internal/zzdj.a (Lcom/google/android/gms/common/api/internal/BasePendingResult;)V
      // bd: aload 3
      // be: getstatic com/google/android/gms/common/api/Status.c Lcom/google/android/gms/common/api/Status;
      // c1: invokevirtual com/google/android/gms/common/api/internal/zzm.c (Lcom/google/android/gms/common/api/Status;)V
      // c4: goto 9c
      // c7: aload 0
      // c8: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // cb: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // d0: aload 1
      // d1: areturn
      // d2: aload 0
      // d3: getfield com/google/android/gms/common/api/internal/zzba.i Lcom/google/android/gms/common/api/internal/zzcc;
      // d6: aload 1
      // d7: invokeinterface com/google/android/gms/common/api/internal/zzcc.b (Lcom/google/android/gms/common/api/internal/zzm;)Lcom/google/android/gms/common/api/internal/zzm; 2
      // dc: astore 1
      // dd: aload 0
      // de: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // e1: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // e6: goto d0
      // try (41 -> 51): 51 null
      // try (63 -> 71): 51 null
      // try (71 -> 87): 51 null
      // try (93 -> 98): 51 null
   }

   @Override
   public final void b(GoogleApiClient.OnConnectionFailedListener var1) {
      this.h.b(var1);
   }

   @Override
   public final void b(zzdg var1) {
      this.f.lock();

      try {
         if (this.d == null) {
            Exception var4 = new Exception();
            Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", var4);
         } else if (!this.d.remove(var1)) {
            Exception var5 = new Exception();
            Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", var5);
         } else if (!this.m()) {
            this.i.g();
         }
      } finally {
         this.f.unlock();
      }
   }

   @Override
   public final Looper c() {
      return this.l;
   }

   @Override
   public final void d() {
      if (this.i != null) {
         this.i.f();
      }
   }

   @Override
   public final void e() {
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
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 06: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 0b: aload 0
      // 0c: getfield com/google/android/gms/common/api/internal/zzba.j I
      // 0f: iflt 37
      // 12: aload 0
      // 13: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 16: ifnull 1b
      // 19: bipush 1
      // 1a: istore 1
      // 1b: iload 1
      // 1c: ldc_w "Sign-in mode should have been set explicitly by auto-manage."
      // 1f: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 22: aload 0
      // 23: aload 0
      // 24: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 27: invokevirtual java/lang/Integer.intValue ()I
      // 2a: invokevirtual com/google/android/gms/common/api/GoogleApiClient.a (I)V
      // 2d: aload 0
      // 2e: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 31: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 36: return
      // 37: aload 0
      // 38: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 3b: ifnonnull 61
      // 3e: aload 0
      // 3f: aload 0
      // 40: getfield com/google/android/gms/common/api/internal/zzba.b Ljava/util/Map;
      // 43: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 48: bipush 0
      // 49: invokestatic com/google/android/gms/common/api/internal/zzba.a (Ljava/lang/Iterable;Z)I
      // 4c: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 4f: putfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 52: goto 22
      // 55: astore 2
      // 56: aload 0
      // 57: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 5a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 5f: aload 2
      // 60: athrow
      // 61: aload 0
      // 62: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 65: invokevirtual java/lang/Integer.intValue ()I
      // 68: bipush 2
      // 69: if_icmpne 22
      // 6c: new java/lang/IllegalStateException
      // 6f: astore 2
      // 70: aload 2
      // 71: ldc_w "Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead."
      // 74: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 77: aload 2
      // 78: athrow
      // try (5 -> 8): 37 null
      // try (8 -> 11): 37 null
      // try (13 -> 16): 37 null
      // try (16 -> 21): 37 null
      // try (25 -> 36): 37 null
      // try (43 -> 55): 37 null
   }

   @Override
   public final ConnectionResult f() {
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
      // 00: bipush 1
      // 01: istore 2
      // 02: invokestatic android/os/Looper.myLooper ()Landroid/os/Looper;
      // 05: invokestatic android/os/Looper.getMainLooper ()Landroid/os/Looper;
      // 08: if_acmpeq 5b
      // 0b: bipush 1
      // 0c: istore 1
      // 0d: iload 1
      // 0e: ldc_w "blockingConnect must not be called on the UI thread"
      // 11: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 14: aload 0
      // 15: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 18: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 1d: aload 0
      // 1e: getfield com/google/android/gms/common/api/internal/zzba.j I
      // 21: iflt 65
      // 24: aload 0
      // 25: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 28: ifnull 60
      // 2b: iload 2
      // 2c: istore 1
      // 2d: iload 1
      // 2e: ldc_w "Sign-in mode should have been set explicitly by auto-manage."
      // 31: invokestatic com/google/android/gms/common/internal/zzbq.a (ZLjava/lang/Object;)V
      // 34: aload 0
      // 35: aload 0
      // 36: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 39: invokevirtual java/lang/Integer.intValue ()I
      // 3c: invokespecial com/google/android/gms/common/api/internal/zzba.b (I)V
      // 3f: aload 0
      // 40: getfield com/google/android/gms/common/api/internal/zzba.h Lcom/google/android/gms/common/internal/zzae;
      // 43: invokevirtual com/google/android/gms/common/internal/zzae.b ()V
      // 46: aload 0
      // 47: getfield com/google/android/gms/common/api/internal/zzba.i Lcom/google/android/gms/common/api/internal/zzcc;
      // 4a: invokeinterface com/google/android/gms/common/api/internal/zzcc.b ()Lcom/google/android/gms/common/ConnectionResult; 1
      // 4f: astore 3
      // 50: aload 0
      // 51: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 54: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 59: aload 3
      // 5a: areturn
      // 5b: bipush 0
      // 5c: istore 1
      // 5d: goto 0d
      // 60: bipush 0
      // 61: istore 1
      // 62: goto 2d
      // 65: aload 0
      // 66: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 69: ifnonnull 8f
      // 6c: aload 0
      // 6d: aload 0
      // 6e: getfield com/google/android/gms/common/api/internal/zzba.b Ljava/util/Map;
      // 71: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 76: bipush 0
      // 77: invokestatic com/google/android/gms/common/api/internal/zzba.a (Ljava/lang/Iterable;Z)I
      // 7a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 7d: putfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 80: goto 34
      // 83: astore 3
      // 84: aload 0
      // 85: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 88: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 8d: aload 3
      // 8e: athrow
      // 8f: aload 0
      // 90: getfield com/google/android/gms/common/api/internal/zzba.x Ljava/lang/Integer;
      // 93: invokevirtual java/lang/Integer.intValue ()I
      // 96: bipush 2
      // 97: if_icmpne 34
      // 9a: new java/lang/IllegalStateException
      // 9d: astore 3
      // 9e: aload 3
      // 9f: ldc_w "Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead."
      // a2: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // a5: aload 3
      // a6: athrow
      // try (13 -> 19): 59 null
      // try (21 -> 24): 59 null
      // try (24 -> 36): 59 null
      // try (47 -> 58): 59 null
      // try (65 -> 77): 59 null
   }

   @Override
   public final void g() {
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
      // 01: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 04: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 09: aload 0
      // 0a: getfield com/google/android/gms/common/api/internal/zzba.e Lcom/google/android/gms/common/api/internal/zzdj;
      // 0d: invokevirtual com/google/android/gms/common/api/internal/zzdj.a ()V
      // 10: aload 0
      // 11: getfield com/google/android/gms/common/api/internal/zzba.i Lcom/google/android/gms/common/api/internal/zzcc;
      // 14: ifnull 20
      // 17: aload 0
      // 18: getfield com/google/android/gms/common/api/internal/zzba.i Lcom/google/android/gms/common/api/internal/zzcc;
      // 1b: invokeinterface com/google/android/gms/common/api/internal/zzcc.c ()V 1
      // 20: aload 0
      // 21: getfield com/google/android/gms/common/api/internal/zzba.v Lcom/google/android/gms/common/api/internal/zzcm;
      // 24: invokevirtual com/google/android/gms/common/api/internal/zzcm.a ()V
      // 27: aload 0
      // 28: getfield com/google/android/gms/common/api/internal/zzba.a Ljava/util/Queue;
      // 2b: invokeinterface java/util/Queue.iterator ()Ljava/util/Iterator; 1
      // 30: astore 1
      // 31: aload 1
      // 32: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 37: ifeq 5c
      // 3a: aload 1
      // 3b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 40: checkcast com/google/android/gms/common/api/internal/zzm
      // 43: astore 2
      // 44: aload 2
      // 45: aconst_null
      // 46: invokevirtual com/google/android/gms/common/api/internal/BasePendingResult.a (Lcom/google/android/gms/common/api/internal/zzdm;)V
      // 49: aload 2
      // 4a: invokevirtual com/google/android/gms/common/api/PendingResult.a ()V
      // 4d: goto 31
      // 50: astore 1
      // 51: aload 0
      // 52: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 55: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 5a: aload 1
      // 5b: athrow
      // 5c: aload 0
      // 5d: getfield com/google/android/gms/common/api/internal/zzba.a Ljava/util/Queue;
      // 60: invokeinterface java/util/Queue.clear ()V 1
      // 65: aload 0
      // 66: getfield com/google/android/gms/common/api/internal/zzba.i Lcom/google/android/gms/common/api/internal/zzcc;
      // 69: astore 1
      // 6a: aload 1
      // 6b: ifnonnull 78
      // 6e: aload 0
      // 6f: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 72: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 77: return
      // 78: aload 0
      // 79: invokevirtual com/google/android/gms/common/api/internal/zzba.l ()Z
      // 7c: pop
      // 7d: aload 0
      // 7e: getfield com/google/android/gms/common/api/internal/zzba.h Lcom/google/android/gms/common/internal/zzae;
      // 81: invokevirtual com/google/android/gms/common/internal/zzae.a ()V
      // 84: aload 0
      // 85: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 88: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 8d: goto 77
      // try (3 -> 12): 32 null
      // try (12 -> 19): 32 null
      // try (19 -> 31): 32 null
      // try (38 -> 44): 32 null
      // try (50 -> 56): 32 null
   }

   @Override
   public final void h() {
      this.g();
      this.e();
   }

   @Override
   public final PendingResult<Status> i() {
      com.google.android.gms.common.internal.zzbq.a(this.j(), "GoogleApiClient is not connected yet.");
      boolean var1;
      if (this.x != 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      com.google.android.gms.common.internal.zzbq.a(var1, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      zzda var2 = new zzda(this);
      if (this.b.containsKey(zzbft.a)) {
         this.a(this, var2, false);
      } else {
         AtomicReference var3 = new AtomicReference();
         zzbc var5 = new zzbc(this, var3, var2);
         zzbd var4 = new zzbd(this, var2);
         GoogleApiClient var6 = new GoogleApiClient.Builder(this.k).a(zzbft.b).a(var5).a(var4).a(this.p).b();
         var3.set(var6);
         var6.e();
      }

      return var2;
   }

   @Override
   public final boolean j() {
      boolean var1;
      if (this.i != null && this.i.d()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   final boolean l() {
      boolean var1 = false;
      if (this.m) {
         this.m = false;
         this.p.removeMessages(2);
         this.p.removeMessages(1);
         if (this.r != null) {
            this.r.a();
            this.r = null;
         }

         var1 = true;
      }

      return var1;
   }

   final boolean m() {
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
      // 00: bipush 0
      // 01: istore 1
      // 02: bipush 0
      // 03: istore 2
      // 04: aload 0
      // 05: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 08: invokeinterface java/util/concurrent/locks/Lock.lock ()V 1
      // 0d: aload 0
      // 0e: getfield com/google/android/gms/common/api/internal/zzba.d Ljava/util/Set;
      // 11: astore 3
      // 12: aload 3
      // 13: ifnonnull 23
      // 16: aload 0
      // 17: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 1a: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 1f: iload 2
      // 20: istore 1
      // 21: iload 1
      // 22: ireturn
      // 23: aload 0
      // 24: getfield com/google/android/gms/common/api/internal/zzba.d Ljava/util/Set;
      // 27: invokeinterface java/util/Set.isEmpty ()Z 1
      // 2c: istore 2
      // 2d: iload 2
      // 2e: ifne 33
      // 31: bipush 1
      // 32: istore 1
      // 33: aload 0
      // 34: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 37: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 3c: goto 21
      // 3f: astore 3
      // 40: aload 0
      // 41: getfield com/google/android/gms/common/api/internal/zzba.f Ljava/util/concurrent/locks/Lock;
      // 44: invokeinterface java/util/concurrent/locks/Lock.unlock ()V 1
      // 49: aload 3
      // 4a: athrow
      // try (7 -> 10): 31 null
      // try (19 -> 23): 31 null
   }

   final String n() {
      StringWriter var1 = new StringWriter();
      this.a("", null, new PrintWriter(var1), null);
      return var1.toString();
   }
}
