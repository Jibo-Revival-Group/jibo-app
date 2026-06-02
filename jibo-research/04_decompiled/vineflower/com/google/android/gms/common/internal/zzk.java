package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class zzk extends zzax {
   private zzd a;
   private final int b;

   public zzk(zzd var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final void a(int var1, Bundle var2) {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
   }

   @Override
   public final void a(int var1, IBinder var2, Bundle var3) {
      zzbq.a(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
      this.a.a(var1, var2, var3, this.b);
      this.a = null;
   }
}
