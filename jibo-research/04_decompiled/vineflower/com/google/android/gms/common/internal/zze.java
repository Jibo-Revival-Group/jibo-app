package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class zze extends zzi<Boolean> {
   private int a;
   private Bundle b;
   private zzd c;

   protected zze(zzd var1, int var2, Bundle var3) {
      this.c = var1;
      super(var1, true);
      this.a = var2;
      this.b = var3;
   }

   protected abstract void a(ConnectionResult var1);

   protected abstract boolean a();
}
