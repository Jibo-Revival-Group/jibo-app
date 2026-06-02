package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzavy extends zzab<zzawd> {
   private final Auth.AuthCredentialsOptions d;

   public zzavy(
      Context var1,
      Looper var2,
      zzr var3,
      Auth.AuthCredentialsOptions var4,
      GoogleApiClient.ConnectionCallbacks var5,
      GoogleApiClient.OnConnectionFailedListener var6
   ) {
      super(var1, var2, 68, var3, var5, var6);
      this.d = var4;
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.gms.auth.api.credentials.service.START";
   }

   @Override
   protected final Bundle t() {
      Bundle var1;
      if (this.d == null) {
         var1 = new Bundle();
      } else {
         var1 = this.d.a();
      }

      return var1;
   }
}
