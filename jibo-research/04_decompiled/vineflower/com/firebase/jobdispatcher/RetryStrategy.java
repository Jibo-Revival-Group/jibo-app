package com.firebase.jobdispatcher;

public final class RetryStrategy {
   public static final RetryStrategy a = new RetryStrategy(1, 30, 3600);
   public static final RetryStrategy b = new RetryStrategy(2, 30, 3600);
   private final int c;
   private final int d;
   private final int e;

   RetryStrategy(int var1, int var2, int var3) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
   }

   public int a() {
      return this.c;
   }

   public int b() {
      return this.d;
   }

   public int c() {
      return this.e;
   }

   static final class Builder {
      private final ValidationEnforcer a;

      Builder(ValidationEnforcer var1) {
         this.a = var1;
      }
   }
}
