package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {
   public abstract R a(long var1, TimeUnit var3);

   public abstract void a();

   public void a(PendingResult.zza var1) {
      throw new UnsupportedOperationException();
   }

   public abstract void a(ResultCallback<? super R> var1);

   public abstract boolean b();

   public Integer c() {
      throw new UnsupportedOperationException();
   }

   public interface zza {
      void a(Status var1);
   }
}
