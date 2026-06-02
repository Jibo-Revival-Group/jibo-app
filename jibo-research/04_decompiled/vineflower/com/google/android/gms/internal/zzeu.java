package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzeu implements IInterface {
   private final IBinder a;
   private final String b;

   protected zzeu(IBinder var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   protected final Parcel a(int var1, Parcel var2) throws RemoteException {
      Parcel var3 = Parcel.obtain();

      try {
         this.a.transact(var1, var2, var3, 0);
         var3.readException();
      } catch (RuntimeException var7) {
         var3.recycle();
         throw var7;
      } finally {
         var2.recycle();
      }

      return var3;
   }

   public IBinder asBinder() {
      return this.a;
   }

   protected final void b(int var1, Parcel var2) throws RemoteException {
      Parcel var4 = Parcel.obtain();

      try {
         this.a.transact(var1, var2, var4, 0);
         var4.readException();
      } finally {
         var2.recycle();
         var4.recycle();
      }
   }

   protected final Parcel c() {
      Parcel var1 = Parcel.obtain();
      var1.writeInterfaceToken(this.b);
      return var1;
   }

   protected final void c(int var1, Parcel var2) throws RemoteException {
      try {
         this.a.transact(var1, var2, null, 1);
      } finally {
         var2.recycle();
      }
   }
}
