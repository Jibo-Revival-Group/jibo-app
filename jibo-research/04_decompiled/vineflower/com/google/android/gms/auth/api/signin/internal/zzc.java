package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzc implements GoogleSignInApi {
   @Override
   public final PendingResult<Status> a(GoogleApiClient var1) {
      return zze.a(var1, var1.b(), false);
   }
}
