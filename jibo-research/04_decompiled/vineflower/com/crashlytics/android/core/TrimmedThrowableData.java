package com.crashlytics.android.core;

class TrimmedThrowableData {
   public final String a;
   public final String b;
   public final StackTraceElement[] c;
   public final TrimmedThrowableData d;

   public TrimmedThrowableData(Throwable var1, StackTraceTrimmingStrategy var2) {
      this.a = var1.getLocalizedMessage();
      this.b = var1.getClass().getName();
      this.c = var2.a(var1.getStackTrace());
      var1 = var1.getCause();
      TrimmedThrowableData var4;
      if (var1 != null) {
         var4 = new TrimmedThrowableData(var1, var2);
      } else {
         var4 = null;
      }

      this.d = var4;
   }
}
