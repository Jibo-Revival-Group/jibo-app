package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class zzaz implements zzay {
   private final IBinder a;

   zzaz(IBinder var1) {
      this.a = var1;
   }

   @Override
   public final void a(zzaw var1, zzz var2) throws RemoteException {
      Parcel var4 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();

      try {
         var4.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
         var4.writeStrongBinder(var1.asBinder());
         var4.writeInt(1);
         var2.writeToParcel(var4, 0);
         this.a.transact(46, var4, var3, 0);
         var3.readException();
      } finally {
         var3.recycle();
         var4.recycle();
      }
   }

   public final IBinder asBinder() {
      return this.a;
   }
}
