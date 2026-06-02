package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzawi extends zzab<zzawl> {
   private final Bundle d;

   public zzawi(Context var1, Looper var2, zzr var3, zzf var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      super(var1, var2, 16, var3, var5, var6);
      if (var4 == null) {
         this.d = new Bundle();
      } else {
         throw new NoSuchMethodError();
      }
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.auth.api.internal.IAuthService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.gms.auth.service.START";
   }

   @Override
   public final boolean i() {
      zzr var2 = this.n();
      boolean var1;
      if (!TextUtils.isEmpty(var2.a()) && !var2.a(zzd.a).isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   protected final Bundle t() {
      return this.d;
   }
}
