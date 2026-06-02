package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzcq<A extends Api.zzb, L> {
   private final zzci<L> a;

   public final void a() {
      this.a.a();
   }

   protected abstract void a(A var1, TaskCompletionSource<Void> var2) throws RemoteException;
}
