package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;

public abstract class zza {
   private int a;

   public zza(int var1) {
      this.a = var1;
   }

   private static Status b(RemoteException var0) {
      StringBuilder var1 = new StringBuilder();
      if (com.google.android.gms.common.util.zzq.a() && var0 instanceof TransactionTooLargeException) {
         var1.append("TransactionTooLargeException: ");
      }

      var1.append(var0.getLocalizedMessage());
      return new Status(8, var1.toString());
   }

   public abstract void a(Status var1);

   public abstract void a(zzae var1, boolean var2);

   public abstract void a(zzbo<?> var1) throws DeadObjectException;
}
