package com.firebase.jobdispatcher;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class GooglePlayJobCallback implements JobCallback {
   private final IBinder a;

   public GooglePlayJobCallback(IBinder var1) {
      this.a = var1;
   }

   @Override
   public void a(int var1) {
      Parcel var3 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var3.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
         var3.writeInt(var1);
         this.a.transact(2, var3, var2, 0);
         var2.readException();
      } catch (RemoteException var8) {
         RuntimeException var4 = new RuntimeException(var8);
         throw var4;
      } finally {
         var3.recycle();
         var2.recycle();
      }
   }
}
