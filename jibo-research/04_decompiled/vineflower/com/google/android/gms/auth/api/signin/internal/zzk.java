package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class zzk extends zza {
   private zzj a;

   zzk(zzj var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void b(Status var1) throws RemoteException {
      this.a.a(var1);
   }
}
