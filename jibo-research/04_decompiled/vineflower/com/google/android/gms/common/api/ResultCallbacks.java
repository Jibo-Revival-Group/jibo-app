package com.google.android.gms.common.api;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
   public abstract void a(Status var1);

   public abstract void b(R var1);
}
