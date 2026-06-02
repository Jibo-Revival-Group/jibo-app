package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

public final class zzal implements zzbh {
   private final zzbi a;
   private boolean b = false;

   public zzal(zzbi var1) {
      this.a = var1;
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      return this.b((T)var1);
   }

   @Override
   public final void a() {
   }

   @Override
   public final void a(int var1) {
      this.a.a((ConnectionResult)null);
      this.a.e.a(var1, this.b);
   }

   @Override
   public final void a(Bundle var1) {
   }

   @Override
   public final void a(ConnectionResult var1, Api<?> var2, boolean var3) {
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      Api.zze var9;
      try {
         this.a.d.e.a(var1);
         zzba var2 = this.a.d;
         Api.zzc var3 = var1.g();
         var9 = var2.b.get(var3);
         com.google.android.gms.common.internal.zzbq.a(var9, "Appropriate Api was not requested.");
         if (!var9.g() && this.a.b.containsKey(var1.g())) {
            Status var8 = new Status(17);
            var1.c(var8);
            return (T)var1;
         }
      } catch (DeadObjectException var6) {
         this.a.a(new zzam(this, this));
         return (T)var1;
      }

      Api.zzb var7 = var9;

      try {
         if (var9 instanceof com.google.android.gms.common.internal.zzbz) {
            var7 = com.google.android.gms.common.internal.zzbz.e();
         }
      } catch (DeadObjectException var5) {
         this.a.a(new zzam(this, this));
         return (T)var1;
      }

      try {
         var1.b(var7);
      } catch (DeadObjectException var4) {
         this.a.a(new zzam(this, this));
      }

      return (T)var1;
   }

   @Override
   public final boolean b() {
      boolean var1 = true;
      if (this.b) {
         var1 = false;
      } else if (this.a.d.m()) {
         this.b = true;
         Iterator var2 = this.a.d.d.iterator();

         while (var2.hasNext()) {
            ((zzdg)var2.next()).a();
         }

         var1 = false;
      } else {
         this.a.a((ConnectionResult)null);
      }

      return var1;
   }

   @Override
   public final void c() {
      if (this.b) {
         this.b = false;
         this.a.a(new zzan(this, this));
      }
   }

   final void d() {
      if (this.b) {
         this.b = false;
         this.a.d.e.a();
         this.b();
      }
   }
}
