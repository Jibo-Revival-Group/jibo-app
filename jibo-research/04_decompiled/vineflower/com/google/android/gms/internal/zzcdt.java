package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public class zzcdt extends zzab<zzcez> {
   protected final zzcfu<zzcez> d = new zzcdu(this);
   private final String e;

   public zzcdt(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, zzr var6) {
      super(var1, var2, 23, var6, var3, var4);
      this.e = var5;
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.location.internal.GoogleLocationManagerService.START";
   }

   @Override
   protected final Bundle t() {
      Bundle var1 = new Bundle();
      var1.putString("client_name", this.e);
      return var1;
   }
}
