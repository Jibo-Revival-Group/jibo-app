package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.zzev;

public interface IObjectWrapper extends IInterface {
   class zza extends zzev implements IObjectWrapper {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
      }

      public static IObjectWrapper a(IBinder var0) {
         IObjectWrapper var2;
         if (var0 == null) {
            var2 = null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (var1 instanceof IObjectWrapper) {
               var2 = (IObjectWrapper)var1;
            } else {
               var2 = new zzm(var0);
            }
         }

         return var2;
      }
   }
}
