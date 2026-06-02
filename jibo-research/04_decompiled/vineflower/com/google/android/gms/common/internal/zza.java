package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

public final class zza extends zzao {
   public static Account a(zzan var0) {
      Object var4 = null;
      Account var3 = (Account)var4;
      if (var0 != null) {
         long var1 = Binder.clearCallingIdentity();

         try {
            var3 = var0.a();
            return var3;
         } catch (RemoteException var7) {
            Log.w("AccountAccessor", "Remote account accessor probably died");
         } finally {
            Binder.restoreCallingIdentity(var1);
         }

         var3 = (Account)var4;
      }

      return var3;
   }

   @Override
   public final Account a() {
      throw new NoSuchMethodError();
   }

   @Override
   public final boolean equals(Object var1) {
      throw new NoSuchMethodError();
   }
}
