package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult> {
   private final zzn<TResult> a = new zzn<>();

   public Task<TResult> a() {
      return this.a;
   }

   public void a(Exception var1) {
      this.a.a(var1);
   }

   public void a(TResult var1) {
      this.a.a((TResult)var1);
   }

   public boolean b(Exception var1) {
      return this.a.b(var1);
   }

   public boolean b(TResult var1) {
      return this.a.b((TResult)var1);
   }
}
