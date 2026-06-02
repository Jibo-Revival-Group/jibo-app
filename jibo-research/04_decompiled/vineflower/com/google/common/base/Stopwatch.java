package com.google.common.base;

import java.util.concurrent.TimeUnit;

public final class Stopwatch {
   private final Ticker a = Ticker.b();
   private boolean b;
   private long c;
   private long d;

   Stopwatch() {
   }

   public static Stopwatch a() {
      return new Stopwatch().b();
   }

   private static TimeUnit a(long var0) {
      TimeUnit var2;
      if (TimeUnit.DAYS.convert(var0, TimeUnit.NANOSECONDS) > 0L) {
         var2 = TimeUnit.DAYS;
      } else if (TimeUnit.HOURS.convert(var0, TimeUnit.NANOSECONDS) > 0L) {
         var2 = TimeUnit.HOURS;
      } else if (TimeUnit.MINUTES.convert(var0, TimeUnit.NANOSECONDS) > 0L) {
         var2 = TimeUnit.MINUTES;
      } else if (TimeUnit.SECONDS.convert(var0, TimeUnit.NANOSECONDS) > 0L) {
         var2 = TimeUnit.SECONDS;
      } else if (TimeUnit.MILLISECONDS.convert(var0, TimeUnit.NANOSECONDS) > 0L) {
         var2 = TimeUnit.MILLISECONDS;
      } else if (TimeUnit.MICROSECONDS.convert(var0, TimeUnit.NANOSECONDS) > 0L) {
         var2 = TimeUnit.MICROSECONDS;
      } else {
         var2 = TimeUnit.NANOSECONDS;
      }

      return var2;
   }

   private static String b(TimeUnit var0) {
      String var1;
      switch (<unrepresentable>.a[var0.ordinal()]) {
         case 1:
            var1 = "ns";
            break;
         case 2:
            var1 = "μs";
            break;
         case 3:
            var1 = "ms";
            break;
         case 4:
            var1 = "s";
            break;
         case 5:
            var1 = "min";
            break;
         case 6:
            var1 = "h";
            break;
         case 7:
            var1 = "d";
            break;
         default:
            throw new AssertionError();
      }

      return var1;
   }

   private long c() {
      long var1;
      if (this.b) {
         var1 = this.a.a() - this.d + this.c;
      } else {
         var1 = this.c;
      }

      return var1;
   }

   public long a(TimeUnit var1) {
      return var1.convert(this.c(), TimeUnit.NANOSECONDS);
   }

   public Stopwatch b() {
      boolean var1;
      if (!this.b) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.b(var1, "This stopwatch is already running.");
      this.b = true;
      this.d = this.a.a();
      return this;
   }

   @Override
   public String toString() {
      long var3 = this.c();
      TimeUnit var5 = a(var3);
      double var1 = (double)var3 / TimeUnit.NANOSECONDS.convert(1L, var5);
      return Platform.a(var1) + " " + b(var5);
   }
}
