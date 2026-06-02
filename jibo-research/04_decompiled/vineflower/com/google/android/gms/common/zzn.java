package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzn extends zzbfm {
   public static final Creator<zzn> CREATOR = new zzo();
   private final String a;
   private final zzh b;
   private final boolean c;

   zzn(String var1, IBinder var2, boolean var3) {
      this.a = var1;
      this.b = a(var2);
      this.c = var3;
   }

   zzn(String var1, zzh var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private static zzh a(IBinder var0) {
      Object var1 = null;
      zzi var3;
      if (var0 == null) {
         var3 = (zzi)var1;
      } else {
         try {
            var4 = zzau.a(var0).a();
         } catch (RemoteException var2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", var2);
            Object var6 = var1;
            return (zzh)var6;
         }

         byte[] var5;
         if (var4 == null) {
            var5 = null;
         } else {
            var5 = com.google.android.gms.dynamic.zzn.a(var4);
         }

         if (var5 != null) {
            var3 = new zzi(var5);
         } else {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            var3 = null;
         }
      }

      return var3;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var2 = zzbfp.a(var1);
      zzbfp.a(var1, 1, this.a, false);
      IBinder var3;
      if (this.b == null) {
         Log.w("GoogleCertificatesQuery", "certificate binder is null");
         var3 = null;
      } else {
         var3 = this.b.asBinder();
      }

      zzbfp.a(var1, 2, var3, false);
      zzbfp.a(var1, 3, this.c);
      zzbfp.a(var1, var2);
   }
}
