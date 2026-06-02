package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

public final class zzd extends zzab<zzu> {
   private final GoogleSignInOptions d;

   public zzd(
      Context var1,
      Looper var2,
      com.google.android.gms.common.internal.zzr var3,
      GoogleSignInOptions var4,
      GoogleApiClient.ConnectionCallbacks var5,
      GoogleApiClient.OnConnectionFailedListener var6
   ) {
      super(var1, var2, 91, var3, var5, var6);
      if (var4 == null) {
         var4 = new GoogleSignInOptions.Builder().c();
      }

      GoogleSignInOptions var7 = var4;
      if (!var3.e().isEmpty()) {
         GoogleSignInOptions.Builder var8 = new GoogleSignInOptions.Builder(var4);
         Iterator var9 = var3.e().iterator();

         while (var9.hasNext()) {
            var8.a((Scope)var9.next());
         }

         var7 = var8.c();
      }

      this.d = var7;
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.auth.api.signin.internal.ISignInService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.gms.auth.api.signin.service.START";
   }

   @Override
   public final boolean c() {
      return true;
   }

   @Override
   public final Intent d() {
      return zze.a(this.s(), this.d);
   }

   public final GoogleSignInOptions e() {
      return this.d;
   }
}
