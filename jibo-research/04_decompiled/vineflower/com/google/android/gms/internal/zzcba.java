package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcba extends zzeu implements zzcay {
   zzcba(IBinder var1) {
      super(var1, "com.google.android.gms.flags.IFlagProvider");
   }

   @Override
   public final boolean getBooleanFlagValue(String var1, boolean var2, int var3) throws RemoteException {
      Parcel var4 = this.c();
      var4.writeString(var1);
      zzew.a(var4, var2);
      var4.writeInt(var3);
      Parcel var5 = this.a(2, var4);
      var2 = zzew.a(var5);
      var5.recycle();
      return var2;
   }

   @Override
   public final int getIntFlagValue(String var1, int var2, int var3) throws RemoteException {
      Parcel var4 = this.c();
      var4.writeString(var1);
      var4.writeInt(var2);
      var4.writeInt(var3);
      Parcel var5 = this.a(3, var4);
      var2 = var5.readInt();
      var5.recycle();
      return var2;
   }

   @Override
   public final long getLongFlagValue(String var1, long var2, int var4) throws RemoteException {
      Parcel var5 = this.c();
      var5.writeString(var1);
      var5.writeLong(var2);
      var5.writeInt(var4);
      Parcel var6 = this.a(4, var5);
      var2 = var6.readLong();
      var6.recycle();
      return var2;
   }

   @Override
   public final String getStringFlagValue(String var1, String var2, int var3) throws RemoteException {
      Parcel var4 = this.c();
      var4.writeString(var1);
      var4.writeString(var2);
      var4.writeInt(var3);
      Parcel var6 = this.a(5, var4);
      var1 = var6.readString();
      var6.recycle();
      return var1;
   }

   @Override
   public final void init(IObjectWrapper var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(1, var2);
   }
}
