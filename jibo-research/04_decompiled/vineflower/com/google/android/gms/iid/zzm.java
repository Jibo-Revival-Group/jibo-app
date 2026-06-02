package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzm extends Handler {
   private zzl a;

   zzm(zzl var1, Looper var2) {
      this.a = var1;
      super(var2);
   }

   public final void handleMessage(Message var1) {
      this.a.a(var1);
   }
}
