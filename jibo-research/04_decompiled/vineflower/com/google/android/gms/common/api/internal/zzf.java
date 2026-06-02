package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzf extends zzb<Boolean> {
   private zzck<?> b;

   public zzf(zzck<?> var1, TaskCompletionSource<Boolean> var2) {
      super(4, var2);
      this.b = var1;
   }

   @Override
   public final void b(zzbo<?> var1) throws RemoteException {
      zzcr var2 = var1.c().remove(this.b);
      if (var2 != null) {
         var2.b.a(var1.b(), this.a);
         var2.a.a();
      } else {
         this.a.b(false);
      }
   }
}
