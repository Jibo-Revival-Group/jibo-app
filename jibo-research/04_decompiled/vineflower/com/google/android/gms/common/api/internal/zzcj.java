package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;

final class zzcj extends Handler {
   private zzci a;

   public final void handleMessage(Message var1) {
      boolean var2 = true;
      if (var1.what != 1) {
         var2 = false;
      }

      com.google.android.gms.common.internal.zzbq.b(var2);
      this.a.b((zzcl)var1.obj);
   }
}
