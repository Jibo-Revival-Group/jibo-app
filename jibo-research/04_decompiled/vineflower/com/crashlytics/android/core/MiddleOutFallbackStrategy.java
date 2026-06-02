package com.crashlytics.android.core;

class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {
   private final int a;
   private final StackTraceTrimmingStrategy[] b;
   private final MiddleOutStrategy c;

   public MiddleOutFallbackStrategy(int var1, StackTraceTrimmingStrategy... var2) {
      this.a = var1;
      this.b = var2;
      this.c = new MiddleOutStrategy(var1);
   }

   @Override
   public StackTraceElement[] a(StackTraceElement[] var1) {
      if (var1.length > this.a) {
         StackTraceTrimmingStrategy[] var5 = this.b;
         int var3 = var5.length;
         int var2 = 0;
         StackTraceElement[] var4 = var1;

         while (var2 < var3) {
            StackTraceTrimmingStrategy var6 = var5[var2];
            if (var4.length <= this.a) {
               break;
            }

            var4 = var6.a(var1);
            var2++;
         }

         var1 = var4;
         if (var4.length > this.a) {
            var1 = this.c.a(var4);
         }
      }

      return var1;
   }
}
