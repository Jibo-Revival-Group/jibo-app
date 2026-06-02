package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable {
   public static final Creator<MessengerCompat> CREATOR = new zzk();
   private Messenger a;
   private zzi b;

   public MessengerCompat(IBinder var1) {
      if (VERSION.SDK_INT >= 21) {
         this.a = new Messenger(var1);
      } else {
         zzi var3;
         if (var1 == null) {
            var3 = null;
         } else {
            IInterface var2 = var1.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            if (var2 instanceof zzi) {
               var3 = (zzi)var2;
            } else {
               var3 = new zzj(var1);
            }
         }

         this.b = var3;
      }
   }

   private final IBinder a() {
      IBinder var1;
      if (this.a != null) {
         var1 = this.a.getBinder();
      } else {
         var1 = this.b.asBinder();
      }

      return var1;
   }

   public final void a(Message var1) throws RemoteException {
      if (this.a != null) {
         this.a.send(var1);
      } else {
         this.b.a(var1);
      }
   }

   public int describeContents() {
      return 0;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = false;
      if (var1 != null) {
         boolean var3;
         try {
            var3 = this.a().equals(((MessengerCompat)var1).a());
         } catch (ClassCastException var4) {
            return var2;
         }

         var2 = var3;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a().hashCode();
   }

   public void writeToParcel(Parcel var1, int var2) {
      if (this.a != null) {
         var1.writeStrongBinder(this.a.getBinder());
      } else {
         var1.writeStrongBinder(this.b.asBinder());
      }
   }
}
