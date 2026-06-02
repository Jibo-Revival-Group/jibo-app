package com.google.android.gms.common.api;

public abstract class ResultTransform<R extends Result, S extends Result> {
   public abstract PendingResult<S> a(R var1);

   public Status a(Status var1) {
      return var1;
   }
}
