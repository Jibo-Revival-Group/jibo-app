package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzcaz extends zzev implements zzcay {
   public zzcaz() {
      this.attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
   }

   public static zzcay asInterface(IBinder var0) {
      zzcay var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
         if (var1 instanceof zzcay) {
            var2 = (zzcay)var1;
         } else {
            var2 = new zzcba(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5 = true;
      if (!this.a(var1, var2, var3, var4)) {
         switch (var1) {
            case 1:
               this.init(IObjectWrapper.zza.a(var2.readStrongBinder()));
               var3.writeNoException();
               break;
            case 2:
               boolean var6 = this.getBooleanFlagValue(var2.readString(), zzew.a(var2), var2.readInt());
               var3.writeNoException();
               zzew.a(var3, var6);
               break;
            case 3:
               var1 = this.getIntFlagValue(var2.readString(), var2.readInt(), var2.readInt());
               var3.writeNoException();
               var3.writeInt(var1);
               break;
            case 4:
               long var7 = this.getLongFlagValue(var2.readString(), var2.readLong(), var2.readInt());
               var3.writeNoException();
               var3.writeLong(var7);
               break;
            case 5:
               String var10 = this.getStringFlagValue(var2.readString(), var2.readString(), var2.readInt());
               var3.writeNoException();
               var3.writeString(var10);
               break;
            default:
               var5 = false;
         }
      }

      return var5;
   }
}
