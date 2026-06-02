package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzbf extends Handler {
   private zzba a;

   zzbf(zzba var1, Looper var2) {
      this.a = var1;
      super(var2);
   }

   public final void handleMessage(Message var1) {
      switch (var1.what) {
         case 1:
            zzba.b(this.a);
            break;
         case 2:
            zzba.a(this.a);
            break;
         default:
            int var2 = var1.what;
            Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(var2).toString());
      }
   }
}
