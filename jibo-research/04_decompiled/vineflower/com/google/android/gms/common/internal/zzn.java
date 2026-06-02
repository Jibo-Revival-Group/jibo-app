package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class zzn extends zze {
   private IBinder a;
   private zzd b;

   public zzn(zzd var1, int var2, IBinder var3, Bundle var4) {
      this.b = var1;
      super(var1, var2, var4);
      this.a = var3;
   }

   @Override
   protected final void a(ConnectionResult var1) {
      if (zzd.g(this.b) != null) {
         zzd.g(this.b).a(var1);
      }

      this.b.a(var1);
   }

   @Override
   protected final boolean a() {
      boolean var2 = false;

      String var4;
      try {
         var4 = this.a.getInterfaceDescriptor();
      } catch (RemoteException var5) {
         Log.w("GmsClient", "service probably died");
         return var2;
      }

      boolean var1;
      if (!this.b.b().equals(var4)) {
         String var3 = this.b.b();
         Log.e(
            "GmsClient",
            new StringBuilder(String.valueOf(var3).length() + 34 + String.valueOf(var4).length())
               .append("service descriptor mismatch: ")
               .append(var3)
               .append(" vs. ")
               .append(var4)
               .toString()
         );
         var1 = var2;
      } else {
         IInterface var6 = this.b.a(this.a);
         var1 = var2;
         if (var6 != null) {
            if (!zzd.a(this.b, 2, 4, var6)) {
               var1 = var2;
               if (!zzd.a(this.b, 3, 4, var6)) {
                  return var1;
               }
            }

            zzd.a(this.b, (ConnectionResult)null);
            Bundle var7 = this.b.a();
            if (zzd.e(this.b) != null) {
               zzd.e(this.b).a(var7);
            }

            var1 = true;
         }
      }

      return var1;
   }
}
