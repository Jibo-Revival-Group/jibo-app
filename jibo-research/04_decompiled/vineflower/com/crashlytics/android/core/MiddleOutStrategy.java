package com.crashlytics.android.core;

class MiddleOutStrategy implements StackTraceTrimmingStrategy {
   private final int a;

   public MiddleOutStrategy(int var1) {
      this.a = var1;
   }

   @Override
   public StackTraceElement[] a(StackTraceElement[] var1) {
      if (var1.length > this.a) {
         int var3 = this.a / 2;
         int var2 = this.a - var3;
         StackTraceElement[] var4 = new StackTraceElement[this.a];
         System.arraycopy(var1, 0, var4, 0, var2);
         System.arraycopy(var1, var1.length - var3, var4, var2, var3);
         var1 = var4;
      }

      return var1;
   }
}
