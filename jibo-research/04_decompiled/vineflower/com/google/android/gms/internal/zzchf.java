package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract class zzchf extends zzev implements zzche {
   public zzchf() {
      this.attachInterface(this, "com.google.android.gms.measurement.internal.IMeasurementService");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else {
         switch (var1) {
            case 1:
               this.a(zzew.a(var2, zzcha.CREATOR), zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               break;
            case 2:
               this.a(zzew.a(var2, zzcln.CREATOR), zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               break;
            case 3:
            case 8:
            default:
               var5 = false;
               return var5;
            case 4:
               this.a(zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               break;
            case 5:
               this.a(zzew.a(var2, zzcha.CREATOR), var2.readString(), var2.readString());
               var3.writeNoException();
               break;
            case 6:
               this.b(zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               break;
            case 7:
               List var12 = this.a(zzew.a(var2, zzcgi.CREATOR), zzew.a(var2));
               var3.writeNoException();
               var3.writeTypedList(var12);
               break;
            case 9:
               byte[] var11 = this.a(zzew.a(var2, zzcha.CREATOR), var2.readString());
               var3.writeNoException();
               var3.writeByteArray(var11);
               break;
            case 10:
               this.a(var2.readLong(), var2.readString(), var2.readString(), var2.readString());
               var3.writeNoException();
               break;
            case 11:
               String var10 = this.c(zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               var3.writeString(var10);
               break;
            case 12:
               this.a(zzew.a(var2, zzcgl.CREATOR), zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               break;
            case 13:
               this.a(zzew.a(var2, zzcgl.CREATOR));
               var3.writeNoException();
               break;
            case 14:
               List var9 = this.a(var2.readString(), var2.readString(), zzew.a(var2), zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               var3.writeTypedList(var9);
               break;
            case 15:
               List var8 = this.a(var2.readString(), var2.readString(), var2.readString(), zzew.a(var2));
               var3.writeNoException();
               var3.writeTypedList(var8);
               break;
            case 16:
               List var7 = this.a(var2.readString(), var2.readString(), zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
               var3.writeTypedList(var7);
               break;
            case 17:
               List var6 = this.a(var2.readString(), var2.readString(), var2.readString());
               var3.writeNoException();
               var3.writeTypedList(var6);
               break;
            case 18:
               this.d(zzew.a(var2, zzcgi.CREATOR));
               var3.writeNoException();
         }

         var5 = true;
      }

      return var5;
   }
}
