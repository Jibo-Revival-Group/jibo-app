package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

abstract class SmoothRateLimiter extends RateLimiter {
   double a;
   double b;
   double c;
   private long d = 0L;

   private SmoothRateLimiter(RateLimiter.SleepingStopwatch var1) {
      super(var1);
   }

   abstract void a(double var1, double var3);

   @Override
   final void a(double var1, long var3) {
      this.a(var3);
      double var5 = TimeUnit.SECONDS.toMicros(1L) / var1;
      this.c = var5;
      this.a(var1, var5);
   }

   void a(long var1) {
      if (var1 > this.d) {
         double var3 = (var1 - this.d) / this.d();
         this.a = Math.min(this.b, var3 + this.a);
         this.d = var1;
      }
   }

   @Override
   final double b() {
      return TimeUnit.SECONDS.toMicros(1L) / this.c;
   }

   abstract long b(double var1, double var3);

   @Override
   final long b(int var1, long var2) {
      this.a(var2);
      var2 = this.d;
      double var6 = Math.min(var1, this.a);
      double var4 = var1;
      long var8 = this.b(this.a, var6);
      long var10 = (long)((var4 - var6) * this.c);
      this.d = LongMath.a(this.d, var10 + var8);
      this.a -= var6;
      return var2;
   }

   abstract double d();

   static final class SmoothWarmingUp extends SmoothRateLimiter {
      private final long d;
      private double e;
      private double f;
      private double g;

      SmoothWarmingUp(RateLimiter.SleepingStopwatch var1, long var2, TimeUnit var4, double var5) {
         super(var1);
         this.d = var4.toMicros(var2);
         this.g = var5;
      }

      private double b(double var1) {
         return this.c + this.e * var1;
      }

      @Override
      void a(double var1, double var3) {
         double var5 = this.b;
         var1 = this.g * var3;
         this.f = 0.5 * this.d / var3;
         this.b = this.f + 2.0 * this.d / (var3 + var1);
         this.e = (var1 - var3) / (this.b - this.f);
         if (var5 == Double.POSITIVE_INFINITY) {
            this.a = 0.0;
         } else {
            if (var5 == 0.0) {
               var1 = this.b;
            } else {
               var1 = this.a * this.b / var5;
            }

            this.a = var1;
         }
      }

      @Override
      long b(double var1, double var3) {
         double var5 = var1 - this.f;
         long var7 = 0L;
         var1 = var3;
         if (var5 > 0.0) {
            var1 = Math.min(var5, var3);
            var7 = (long)((this.b(var5) + this.b(var5 - var1)) * var1 / 2.0);
            var1 = var3 - var1;
         }

         return (long)(var7 + this.c * var1);
      }

      @Override
      double d() {
         return this.d / this.b;
      }
   }
}
