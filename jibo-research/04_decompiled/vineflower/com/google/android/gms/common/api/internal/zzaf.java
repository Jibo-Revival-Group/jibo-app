package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zzaf implements PendingResult.zza {
   private BasePendingResult a;
   private zzae b;

   zzaf(zzae var1, BasePendingResult var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void a(Status var1) {
      zzae.a(this.b).remove(this.a);
   }
}
