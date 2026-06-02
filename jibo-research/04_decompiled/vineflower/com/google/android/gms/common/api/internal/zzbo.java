package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class zzbo<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzu {
   final zzbm a;
   private final Queue<zza> b;
   private final Api.zze c;
   private final Api.zzb d;
   private final zzh<O> e;
   private final zzae f;
   private final Set<zzj> g;
   private final Map<zzck<?>, zzcr> h;
   private final int i;
   private final zzcv j;
   private boolean k;
   private ConnectionResult l;

   public zzbo(zzbm var1, GoogleApi var2) {
      this.a = var1;
      this.b = new LinkedList<>();
      this.g = new HashSet<>();
      this.h = new HashMap<>();
      this.l = null;
      this.c = var2.a(zzbm.a(var1).getLooper(), this);
      if (this.c instanceof com.google.android.gms.common.internal.zzbz) {
         this.d = com.google.android.gms.common.internal.zzbz.e();
      } else {
         this.d = this.c;
      }

      this.e = var2.b();
      this.f = new zzae();
      this.i = var2.c();
      if (this.c.i()) {
         this.j = var2.a(zzbm.b(var1), zzbm.a(var1));
      } else {
         this.j = null;
      }
   }

   private final void b(zza var1) {
      var1.a(this.f, this.k());

      try {
         var1.a(this);
      } catch (DeadObjectException var2) {
         this.a(1);
         this.c.f();
      }
   }

   private final void c(ConnectionResult var1) {
      for (zzj var4 : this.g) {
         String var2 = null;
         if (var1 == ConnectionResult.a) {
            var2 = this.c.l();
         }

         var4.a(this.e, var1, var2);
      }

      this.g.clear();
   }

   private final void n() {
      this.d();
      this.c(ConnectionResult.a);
      this.p();

      for (zzcr var2 : this.h.values()) {
         try {
            zzcq var3 = var2.a;
            Api.zzb var4 = this.d;
            TaskCompletionSource var7 = new TaskCompletionSource();
            var3.a(var4, var7);
         } catch (DeadObjectException var5) {
            this.a(1);
            this.c.f();
            break;
         } catch (RemoteException var6) {
         }
      }

      while (this.c.g() && !this.b.isEmpty()) {
         this.b(this.b.remove());
      }

      this.q();
   }

   private final void o() {
      this.d();
      this.k = true;
      this.f.c();
      zzbm.a(this.a).sendMessageDelayed(Message.obtain(zzbm.a(this.a), 9, this.e), zzbm.c(this.a));
      zzbm.a(this.a).sendMessageDelayed(Message.obtain(zzbm.a(this.a), 11, this.e), zzbm.d(this.a));
      zzbm.a(this.a, -1);
   }

   private final void p() {
      if (this.k) {
         zzbm.a(this.a).removeMessages(11, this.e);
         zzbm.a(this.a).removeMessages(9, this.e);
         this.k = false;
      }
   }

   private final void q() {
      zzbm.a(this.a).removeMessages(12, this.e);
      zzbm.a(this.a).sendMessageDelayed(zzbm.a(this.a).obtainMessage(12, this.e), zzbm.h(this.a));
   }

   public final void a() {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      this.a(zzbm.a);
      this.f.b();
      zzck[] var3 = this.h.keySet().toArray(new zzck[this.h.size()]);
      int var2 = var3.length;

      for (int var1 = 0; var1 < var2; var1++) {
         this.a(new zzf(var3[var1], new TaskCompletionSource<>()));
      }

      this.c(new ConnectionResult(4));
      if (this.c.g()) {
         this.c.a(new zzbs(this));
      }
   }

   @Override
   public final void a(int var1) {
      if (Looper.myLooper() == zzbm.a(this.a).getLooper()) {
         this.o();
      } else {
         zzbm.a(this.a).post(new zzbq(this));
      }
   }

   @Override
   public final void a(Bundle var1) {
      if (Looper.myLooper() == zzbm.a(this.a).getLooper()) {
         this.n();
      } else {
         zzbm.a(this.a).post(new zzbp(this));
      }
   }

   @Override
   public final void a(ConnectionResult param1) {
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
      // 000: aload 0
      // 001: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 004: invokestatic com/google/android/gms/common/api/internal/zzbm.a (Lcom/google/android/gms/common/api/internal/zzbm;)Landroid/os/Handler;
      // 007: invokestatic com/google/android/gms/common/internal/zzbq.a (Landroid/os/Handler;)V
      // 00a: aload 0
      // 00b: getfield com/google/android/gms/common/api/internal/zzbo.j Lcom/google/android/gms/common/api/internal/zzcv;
      // 00e: ifnull 018
      // 011: aload 0
      // 012: getfield com/google/android/gms/common/api/internal/zzbo.j Lcom/google/android/gms/common/api/internal/zzcv;
      // 015: invokevirtual com/google/android/gms/common/api/internal/zzcv.b ()V
      // 018: aload 0
      // 019: invokevirtual com/google/android/gms/common/api/internal/zzbo.d ()V
      // 01c: aload 0
      // 01d: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 020: bipush -1
      // 021: invokestatic com/google/android/gms/common/api/internal/zzbm.a (Lcom/google/android/gms/common/api/internal/zzbm;I)I
      // 024: pop
      // 025: aload 0
      // 026: aload 1
      // 027: invokespecial com/google/android/gms/common/api/internal/zzbo.c (Lcom/google/android/gms/common/ConnectionResult;)V
      // 02a: aload 1
      // 02b: invokevirtual com/google/android/gms/common/ConnectionResult.c ()I
      // 02e: bipush 4
      // 02f: if_icmpne 03a
      // 032: aload 0
      // 033: invokestatic com/google/android/gms/common/api/internal/zzbm.f ()Lcom/google/android/gms/common/api/Status;
      // 036: invokevirtual com/google/android/gms/common/api/internal/zzbo.a (Lcom/google/android/gms/common/api/Status;)V
      // 039: return
      // 03a: aload 0
      // 03b: getfield com/google/android/gms/common/api/internal/zzbo.b Ljava/util/Queue;
      // 03e: invokeinterface java/util/Queue.isEmpty ()Z 1
      // 043: ifeq 04e
      // 046: aload 0
      // 047: aload 1
      // 048: putfield com/google/android/gms/common/api/internal/zzbo.l Lcom/google/android/gms/common/ConnectionResult;
      // 04b: goto 039
      // 04e: invokestatic com/google/android/gms/common/api/internal/zzbm.g ()Ljava/lang/Object;
      // 051: astore 2
      // 052: aload 2
      // 053: monitorenter
      // 054: aload 0
      // 055: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 058: invokestatic com/google/android/gms/common/api/internal/zzbm.e (Lcom/google/android/gms/common/api/internal/zzbm;)Lcom/google/android/gms/common/api/internal/zzah;
      // 05b: ifnull 08a
      // 05e: aload 0
      // 05f: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 062: invokestatic com/google/android/gms/common/api/internal/zzbm.f (Lcom/google/android/gms/common/api/internal/zzbm;)Ljava/util/Set;
      // 065: aload 0
      // 066: getfield com/google/android/gms/common/api/internal/zzbo.e Lcom/google/android/gms/common/api/internal/zzh;
      // 069: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 06e: ifeq 08a
      // 071: aload 0
      // 072: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 075: invokestatic com/google/android/gms/common/api/internal/zzbm.e (Lcom/google/android/gms/common/api/internal/zzbm;)Lcom/google/android/gms/common/api/internal/zzah;
      // 078: aload 1
      // 079: aload 0
      // 07a: getfield com/google/android/gms/common/api/internal/zzbo.i I
      // 07d: invokevirtual com/google/android/gms/common/api/internal/zzo.b (Lcom/google/android/gms/common/ConnectionResult;I)V
      // 080: aload 2
      // 081: monitorexit
      // 082: goto 039
      // 085: astore 1
      // 086: aload 2
      // 087: monitorexit
      // 088: aload 1
      // 089: athrow
      // 08a: aload 2
      // 08b: monitorexit
      // 08c: aload 0
      // 08d: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 090: aload 1
      // 091: aload 0
      // 092: getfield com/google/android/gms/common/api/internal/zzbo.i I
      // 095: invokevirtual com/google/android/gms/common/api/internal/zzbm.a (Lcom/google/android/gms/common/ConnectionResult;I)Z
      // 098: ifne 039
      // 09b: aload 1
      // 09c: invokevirtual com/google/android/gms/common/ConnectionResult.c ()I
      // 09f: bipush 18
      // 0a1: if_icmpne 0a9
      // 0a4: aload 0
      // 0a5: bipush 1
      // 0a6: putfield com/google/android/gms/common/api/internal/zzbo.k Z
      // 0a9: aload 0
      // 0aa: getfield com/google/android/gms/common/api/internal/zzbo.k Z
      // 0ad: ifeq 0d5
      // 0b0: aload 0
      // 0b1: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 0b4: invokestatic com/google/android/gms/common/api/internal/zzbm.a (Lcom/google/android/gms/common/api/internal/zzbm;)Landroid/os/Handler;
      // 0b7: aload 0
      // 0b8: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 0bb: invokestatic com/google/android/gms/common/api/internal/zzbm.a (Lcom/google/android/gms/common/api/internal/zzbm;)Landroid/os/Handler;
      // 0be: bipush 9
      // 0c0: aload 0
      // 0c1: getfield com/google/android/gms/common/api/internal/zzbo.e Lcom/google/android/gms/common/api/internal/zzh;
      // 0c4: invokestatic android/os/Message.obtain (Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
      // 0c7: aload 0
      // 0c8: getfield com/google/android/gms/common/api/internal/zzbo.a Lcom/google/android/gms/common/api/internal/zzbm;
      // 0cb: invokestatic com/google/android/gms/common/api/internal/zzbm.c (Lcom/google/android/gms/common/api/internal/zzbm;)J
      // 0ce: invokevirtual android/os/Handler.sendMessageDelayed (Landroid/os/Message;J)Z
      // 0d1: pop
      // 0d2: goto 039
      // 0d5: aload 0
      // 0d6: getfield com/google/android/gms/common/api/internal/zzbo.e Lcom/google/android/gms/common/api/internal/zzh;
      // 0d9: invokevirtual com/google/android/gms/common/api/internal/zzh.a ()Ljava/lang/String;
      // 0dc: astore 1
      // 0dd: aload 0
      // 0de: new com/google/android/gms/common/api/Status
      // 0e1: dup
      // 0e2: bipush 17
      // 0e4: new java/lang/StringBuilder
      // 0e7: dup
      // 0e8: aload 1
      // 0e9: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 0ec: invokevirtual java/lang/String.length ()I
      // 0ef: bipush 38
      // 0f1: iadd
      // 0f2: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0f5: ldc_w "API: "
      // 0f8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0fb: aload 1
      // 0fc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ff: ldc_w " is not available on this device."
      // 102: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 105: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 108: invokespecial com/google/android/gms/common/api/Status.<init> (ILjava/lang/String;)V
      // 10b: invokevirtual com/google/android/gms/common/api/internal/zzbo.a (Lcom/google/android/gms/common/api/Status;)V
      // 10e: goto 039
      // try (40 -> 60): 61 null
      // try (62 -> 64): 61 null
      // try (66 -> 68): 61 null
   }

   @Override
   public final void a(ConnectionResult var1, Api<?> var2, boolean var3) {
      if (Looper.myLooper() == zzbm.a(this.a).getLooper()) {
         this.a(var1);
      } else {
         zzbm.a(this.a).post(new zzbr(this, var1));
      }
   }

   public final void a(Status var1) {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      Iterator var2 = this.b.iterator();

      while (var2.hasNext()) {
         ((zza)var2.next()).a(var1);
      }

      this.b.clear();
   }

   public final void a(zza var1) {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      if (this.c.g()) {
         this.b(var1);
         this.q();
      } else {
         this.b.add(var1);
         if (this.l != null && this.l.a()) {
            this.a(this.l);
         } else {
            this.i();
         }
      }
   }

   public final void a(zzj var1) {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      this.g.add(var1);
   }

   public final Api.zze b() {
      return this.c;
   }

   public final void b(ConnectionResult var1) {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      this.c.f();
      this.a(var1);
   }

   public final Map<zzck<?>, zzcr> c() {
      return this.h;
   }

   public final void d() {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      this.l = null;
   }

   public final ConnectionResult e() {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      return this.l;
   }

   public final void f() {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      if (this.k) {
         this.i();
      }
   }

   public final void g() {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      if (this.k) {
         this.p();
         Status var1;
         if (zzbm.g(this.a).a(zzbm.b(this.a)) == 18) {
            var1 = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
         } else {
            var1 = new Status(8, "API failed to connect while resuming due to an unknown error.");
         }

         this.a(var1);
         this.c.f();
      }
   }

   public final void h() {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      if (this.c.g() && this.h.size() == 0) {
         if (this.f.a()) {
            this.q();
         } else {
            this.c.f();
         }
      }
   }

   public final void i() {
      com.google.android.gms.common.internal.zzbq.a(zzbm.a(this.a));
      if (!this.c.g() && !this.c.h()) {
         if (this.c.j() && zzbm.i(this.a) != 0) {
            zzbm.a(this.a, zzbm.g(this.a).a(zzbm.b(this.a)));
            if (zzbm.i(this.a) != 0) {
               this.a(new ConnectionResult(zzbm.i(this.a), null));
               return;
            }
         }

         zzbu var1 = new zzbu(this.a, this.c, this.e);
         if (this.c.i()) {
            this.j.a(var1);
         }

         this.c.a(var1);
      }
   }

   final boolean j() {
      return this.c.g();
   }

   public final boolean k() {
      return this.c.i();
   }

   public final int l() {
      return this.i;
   }

   final zzcxd m() {
      zzcxd var1;
      if (this.j == null) {
         var1 = null;
      } else {
         var1 = this.j.a();
      }

      return var1;
   }
}
