package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzh extends zzau {
   private int a;

   protected zzh(byte[] var1) {
      boolean var3 = false;
      super();
      byte[] var4 = var1;
      if (var1.length != 25) {
         int var2 = var1.length;
         String var6 = com.google.android.gms.common.util.zzl.a(var1, 0, var1.length, false);
         Log.wtf(
            "GoogleCertificates",
            new StringBuilder(String.valueOf(var6).length() + 51)
               .append("Cert hash data has incorrect length (")
               .append(var2)
               .append("):\n")
               .append(var6)
               .toString(),
            new Exception()
         );
         var4 = Arrays.copyOfRange(var1, 0, 25);
         if (var4.length == 25) {
            var3 = true;
         }

         var2 = var4.length;
         zzbq.b(var3, new StringBuilder(55).append("cert hash data has incorrect length. length=").append(var2).toString());
      }

      this.a = Arrays.hashCode(var4);
   }

   protected static byte[] a(String var0) {
      try {
         return var0.getBytes("ISO-8859-1");
      } catch (UnsupportedEncodingException var1) {
         throw new AssertionError(var1);
      }
   }

   @Override
   public final IObjectWrapper a() {
      return com.google.android.gms.dynamic.zzn.a(this.c());
   }

   @Override
   public final int b() {
      return this.hashCode();
   }

   abstract byte[] c();

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 != null && var1 instanceof zzat) {
         label46: {
            try {
               var1 = var1;
               if (var1.b() != this.hashCode()) {
                  break label46;
               }
            } catch (RemoteException var5) {
               Log.e("GoogleCertificates", "Failed to get Google certificates from remote", var5);
               return false;
            }

            try {
               var7 = var1.a();
            } catch (RemoteException var4) {
               Log.e("GoogleCertificates", "Failed to get Google certificates from remote", var4);
               return false;
            }

            if (var7 == null) {
               return false;
            }

            try {
               byte[] var8 = com.google.android.gms.dynamic.zzn.a(var7);
               var2 = Arrays.equals(this.c(), var8);
            } catch (RemoteException var3) {
               Log.e("GoogleCertificates", "Failed to get Google certificates from remote", var3);
               var2 = false;
            }

            return var2;
         }

         var2 = false;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a;
   }
}
