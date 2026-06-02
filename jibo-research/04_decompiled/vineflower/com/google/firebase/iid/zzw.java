package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzw extends Handler {
   private zzv a;

   zzw(zzv var1, Looper var2) {
      this.a = var1;
      super(var2);
   }

   public final void handleMessage(Message var1) {
      zzv.a(this.a, var1);
   }
}
