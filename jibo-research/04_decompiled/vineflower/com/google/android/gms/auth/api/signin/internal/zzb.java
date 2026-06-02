package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcu;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzb extends AsyncTaskLoader<Void> implements zzcu {
   private Semaphore f = new Semaphore(0);
   private Set<GoogleApiClient> g;

   public zzb(Context var1, Set<GoogleApiClient> var2) {
      super(var1);
      this.g = var2;
   }

   private final Void C() {
      Iterator var2 = this.g.iterator();
      int var1 = 0;

      while (var2.hasNext()) {
         if (((GoogleApiClient)var2.next()).a(this)) {
            var1++;
         }
      }

      try {
         this.f.tryAcquire(var1, 5L, TimeUnit.SECONDS);
      } catch (InterruptedException var3) {
         Log.i("GACSignInLoader", "Unexpected InterruptedException", var3);
         Thread.currentThread().interrupt();
      }

      return null;
   }

   @Override
   public final void h() {
      this.f.release();
   }

   @Override
   protected final void i() {
      this.f.drainPermits();
      this.t();
   }
}
