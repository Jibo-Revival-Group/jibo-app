package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zzbi implements zzcc, zzu {
   final Map<Api.zzc<?>, Api.zze> a;
   final Map<Api.zzc<?>, ConnectionResult> b = new HashMap<>();
   int c;
   final zzba d;
   final zzcd e;
   private final Lock f;
   private final Condition g;
   private final Context h;
   private final com.google.android.gms.common.zzf i;
   private final zzbk j;
   private com.google.android.gms.common.internal.zzr k;
   private Map<Api<?>, Boolean> l;
   private Api.zza<? extends zzcxd, zzcxe> m;
   private volatile zzbh n;
   private ConnectionResult o = null;

   public zzbi(
      Context var1,
      zzba var2,
      Lock var3,
      Looper var4,
      com.google.android.gms.common.zzf var5,
      Map<Api.zzc<?>, Api.zze> var6,
      com.google.android.gms.common.internal.zzr var7,
      Map<Api<?>, Boolean> var8,
      Api.zza<? extends zzcxd, zzcxe> var9,
      ArrayList<zzt> var10,
      zzcd var11
   ) {
      this.h = var1;
      this.f = var3;
      this.i = var5;
      this.a = var6;
      this.k = var7;
      this.l = var8;
      this.m = var9;
      this.d = var2;
      this.e = var11;
      ArrayList var15 = var10;
      int var13 = var15.size();
      int var12 = 0;

      while (var12 < var13) {
         Object var14 = var15.get(var12);
         var12++;
         ((zzt)var14).a(this);
      }

      this.j = new zzbk(this, var4);
      this.g = var3.newCondition();
      this.n = new zzaz(this);
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      var1.f();
      return this.n.a((T)var1);
   }

   @Override
   public final void a() {
      this.n.c();
   }

   @Override
   public final void a(int var1) {
      this.f.lock();

      try {
         this.n.a(var1);
      } finally {
         this.f.unlock();
      }
   }

   @Override
   public final void a(Bundle var1) {
      this.f.lock();

      try {
         this.n.a(var1);
      } finally {
         this.f.unlock();
      }
   }

   final void a(ConnectionResult var1) {
      this.f.lock();

      try {
         this.o = var1;
         zzaz var4 = new zzaz(this);
         this.n = var4;
         this.n.a();
         this.g.signalAll();
      } finally {
         this.f.unlock();
      }
   }

   @Override
   public final void a(ConnectionResult var1, Api<?> var2, boolean var3) {
      this.f.lock();

      try {
         this.n.a(var1, var2, var3);
      } finally {
         this.f.unlock();
      }
   }

   final void a(zzbj var1) {
      Message var2 = this.j.obtainMessage(1, var1);
      this.j.sendMessage(var2);
   }

   final void a(RuntimeException var1) {
      Message var2 = this.j.obtainMessage(2, var1);
      this.j.sendMessage(var2);
   }

   @Override
   public final void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      String var5 = String.valueOf(var1).concat("  ");
      var3.append(var1).append("mState=").println(this.n);

      for (Api var7 : this.l.keySet()) {
         var3.append(var1).append(var7.d()).println(":");
         this.a.get(var7.c()).a(var5, var2, var3, var4);
      }
   }

   @Override
   public final boolean a(zzcu var1) {
      return false;
   }

   @Override
   public final ConnectionResult b() {
      this.a();

      ConnectionResult var1;
      while (true) {
         if (!this.i()) {
            if (this.d()) {
               var1 = ConnectionResult.a;
            } else if (this.o != null) {
               var1 = this.o;
            } else {
               var1 = new ConnectionResult(13, null);
            }
            break;
         }

         try {
            this.g.await();
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
      var1.f();
      return this.n.b((T)var1);
   }

   @Override
   public final void c() {
      if (this.n.b()) {
         this.b.clear();
      }
   }

   @Override
   public final boolean d() {
      return this.n instanceof zzal;
   }

   final void e() {
      this.f.lock();

      try {
         zzao var1 = new zzao(this, this.k, this.l, this.i, this.m, this.f, this.h);
         this.n = var1;
         this.n.a();
         this.g.signalAll();
      } finally {
         this.f.unlock();
      }
   }

   @Override
   public final void f() {
   }

   @Override
   public final void g() {
      if (this.d()) {
         ((zzal)this.n).d();
      }
   }

   final void h() {
      this.f.lock();

      try {
         this.d.l();
         zzal var1 = new zzal(this);
         this.n = var1;
         this.n.a();
         this.g.signalAll();
      } finally {
         this.f.unlock();
      }
   }

   public final boolean i() {
      return this.n instanceof zzao;
   }
}
