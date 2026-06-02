package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

public abstract class Task<TResult> {
   public Task<TResult> a(Executor var1, OnCompleteListener<TResult> var2) {
      throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
   }

   public abstract Task<TResult> a(Executor var1, OnFailureListener var2);

   public abstract Task<TResult> a(Executor var1, OnSuccessListener<? super TResult> var2);

   public abstract boolean a();

   public abstract boolean b();

   public abstract TResult c();

   public abstract Exception d();
}
