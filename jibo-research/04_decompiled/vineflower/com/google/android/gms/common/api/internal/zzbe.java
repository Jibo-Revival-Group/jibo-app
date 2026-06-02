package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzbe implements ResultCallback<Status> {
   private zzda a;
   private boolean b;
   private GoogleApiClient c;
   private zzba d;

   zzbe(zzba var1, zzda var2, boolean var3, GoogleApiClient var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      super();
   }
}
