package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract class zzm<R extends Result, A extends Api.zzb> extends BasePendingResult<R> implements zzn<R> {
   private final Api.zzc<A> b;
   private final Api<?> c;

   protected zzm(Api<?> var1, GoogleApiClient var2) {
      super(com.google.android.gms.common.internal.zzbq.a(var2, "GoogleApiClient must not be null"));
      com.google.android.gms.common.internal.zzbq.a(var1, "Api must not be null");
      this.b = (Api.zzc<A>)var1.c();
      this.c = var1;
   }

   private final void a(RemoteException var1) {
      this.c(new Status(8, var1.getLocalizedMessage(), null));
   }

   protected abstract void a(A var1) throws RemoteException;

   public final void b(A var1) throws DeadObjectException {
      Api.zzb var2 = var1;
      if (var1 instanceof com.google.android.gms.common.internal.zzbz) {
         var2 = com.google.android.gms.common.internal.zzbz.e();
      }

      try {
         this.a((A)var2);
      } catch (DeadObjectException var3) {
         this.a(var3);
         throw var3;
      } catch (RemoteException var4) {
         this.a(var4);
      }
   }

   public final void c(Status var1) {
      boolean var2;
      if (!var1.c()) {
         var2 = true;
      } else {
         var2 = false;
      }

      com.google.android.gms.common.internal.zzbq.b(var2, "Failed result must not be success");
      this.a(this.a(var1));
   }

   public final Api.zzc<A> g() {
      return this.b;
   }

   public final Api<?> h() {
      return this.c;
   }
}
