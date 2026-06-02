package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxi;
import com.google.android.gms.internal.zzcxq;
import java.util.Set;

public final class zzcv extends zzcxi implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   private static Api.zza<? extends zzcxd, zzcxe> a = zzcxa.a;
   private final Context b;
   private final Handler c;
   private final Api.zza<? extends zzcxd, zzcxe> d;
   private Set<Scope> e;
   private com.google.android.gms.common.internal.zzr f;
   private zzcxd g;
   private zzcy h;

   public zzcv(Context var1, Handler var2, com.google.android.gms.common.internal.zzr var3) {
      this(var1, var2, var3, a);
   }

   public zzcv(Context var1, Handler var2, com.google.android.gms.common.internal.zzr var3, Api.zza<? extends zzcxd, zzcxe> var4) {
      this.b = var1;
      this.c = var2;
      this.f = com.google.android.gms.common.internal.zzbq.a(var3, "ClientSettings must not be null");
      this.e = var3.d();
      this.d = var4;
   }

   private final void b(zzcxq var1) {
      ConnectionResult var2 = var1.a();
      if (var2.b()) {
         com.google.android.gms.common.internal.zzbt var4 = var1.b();
         ConnectionResult var3 = var4.b();
         if (!var3.b()) {
            String var5 = String.valueOf(var3);
            Log.wtf(
               "SignInCoordinator",
               new StringBuilder(String.valueOf(var5).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(var5).toString(),
               new Exception()
            );
            this.h.b(var3);
            this.g.f();
            return;
         }

         this.h.a(var4.a(), this.e);
      } else {
         this.h.b(var2);
      }

      this.g.f();
   }

   public final zzcxd a() {
      return this.g;
   }

   @Override
   public final void a(int var1) {
      this.g.f();
   }

   @Override
   public final void a(Bundle var1) {
      this.g.a(this);
   }

   @Override
   public final void a(ConnectionResult var1) {
      this.h.b(var1);
   }

   public final void a(zzcy var1) {
      if (this.g != null) {
         this.g.f();
      }

      this.f.a(System.identityHashCode(this));
      this.g = this.d.a(this.b, this.c.getLooper(), this.f, this.f.i(), this, this);
      this.h = var1;
      if (this.e != null && !this.e.isEmpty()) {
         this.g.m();
      } else {
         this.c.post(new zzcw(this));
      }
   }

   @Override
   public final void a(zzcxq var1) {
      this.c.post(new zzcx(this, var1));
   }

   public final void b() {
      if (this.g != null) {
         this.g.f();
      }
   }
}
