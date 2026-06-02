package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class zzo extends zze {
   private zzd a;

   public zzo(zzd var1, int var2, Bundle var3) {
      this.a = var1;
      super(var1, var2, null);
   }

   @Override
   protected final void a(ConnectionResult var1) {
      this.a.b.a(var1);
      this.a.a(var1);
   }

   @Override
   protected final boolean a() {
      this.a.b.a(ConnectionResult.a);
      return true;
   }
}
