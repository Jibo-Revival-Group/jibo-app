package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzaut extends zzab<zzauu> {
   public zzaut(Context var1, Looper var2, zzr var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5) {
      super(var1, var2, 74, var3, var4, var5);
   }

   @Override
   protected final String b() {
      return "com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService";
   }

   @Override
   protected final String b_() {
      return "com.google.android.gms.auth.api.accountactivationstate.START";
   }
}
