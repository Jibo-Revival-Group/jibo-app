package com.firebase.jobdispatcher;

public final class FirebaseJobDispatcher {
   private final Driver a;
   private final ValidationEnforcer b;
   private final RetryStrategy.Builder c;

   public FirebaseJobDispatcher(Driver var1) {
      this.a = var1;
      this.b = new ValidationEnforcer(var1.a());
      this.c = new RetryStrategy.Builder(this.b);
   }

   public int a(Job var1) {
      int var2;
      if (!this.a.b()) {
         var2 = 2;
      } else {
         var2 = this.a.a(var1);
      }

      return var2;
   }

   public int a(String var1) {
      int var2;
      if (!this.a.b()) {
         var2 = 2;
      } else {
         var2 = this.a.a(var1);
      }

      return var2;
   }

   public Job.Builder a() {
      return new Job.Builder(this.b);
   }
}
