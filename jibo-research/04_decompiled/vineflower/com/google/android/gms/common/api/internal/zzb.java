package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzb<T> extends zza {
   protected final TaskCompletionSource<T> a;

   public zzb(int var1, TaskCompletionSource<T> var2) {
      super(var1);
      this.a = var2;
   }

   @Override
   public void a(Status var1) {
      this.a.b(new ApiException(var1));
   }

   @Override
   public void a(zzae var1, boolean var2) {
   }

   @Override
   public final void a(zzbo<?> var1) throws DeadObjectException {
      try {
         this.b(var1);
      } catch (DeadObjectException var2) {
         this.a(zza.a(var2));
         throw var2;
      } catch (RemoteException var3) {
         this.a(zza.a(var3));
      }
   }

   protected abstract void b(zzbo<?> var1) throws RemoteException;
}
