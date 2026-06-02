package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

final class zzbfy extends zzbfs {
   private final zzn<Status> a;

   public zzbfy(zzn<Status> var1) {
      this.a = var1;
   }

   @Override
   public final void a(int var1) throws RemoteException {
      this.a.a(new Status(var1));
   }
}
