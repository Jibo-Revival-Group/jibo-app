package com.google.api.client.util;

import java.io.IOException;

public class ExponentialBackOff implements BackOff {
   public static final int DEFAULT_INITIAL_INTERVAL_MILLIS = 500;
   public static final int DEFAULT_MAX_ELAPSED_TIME_MILLIS = 900000;
   public static final int DEFAULT_MAX_INTERVAL_MILLIS = 60000;
   public static final double DEFAULT_MULTIPLIER = 1.5;
   public static final double DEFAULT_RANDOMIZATION_FACTOR = 0.5;
   private int currentIntervalMillis;
   private final int initialIntervalMillis;
   private final int maxElapsedTimeMillis;
   private final int maxIntervalMillis;
   private final double multiplier;
   private final NanoClock nanoClock;
   private final double randomizationFactor;
   long startTimeNanos;

   public ExponentialBackOff() {
      this(new ExponentialBackOff.Builder());
   }

   protected ExponentialBackOff(ExponentialBackOff.Builder var1) {
      boolean var3 = true;
      super();
      this.initialIntervalMillis = var1.initialIntervalMillis;
      this.randomizationFactor = var1.randomizationFactor;
      this.multiplier = var1.multiplier;
      this.maxIntervalMillis = var1.maxIntervalMillis;
      this.maxElapsedTimeMillis = var1.maxElapsedTimeMillis;
      this.nanoClock = var1.nanoClock;
      boolean var2;
      if (this.initialIntervalMillis > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      if (0.0 <= this.randomizationFactor && this.randomizationFactor < 1.0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      if (this.multiplier >= 1.0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      if (this.maxIntervalMillis >= this.initialIntervalMillis) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      if (this.maxElapsedTimeMillis > 0) {
         var2 = var3;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.reset();
   }

   static int getRandomValueFromInterval(double var0, double var2, int var4) {
      var0 = var4 * var0;
      double var5 = var4 - var0;
      return (int)((var0 + var4 - var5 + 1.0) * var2 + var5);
   }

   private void incrementCurrentInterval() {
      if (this.currentIntervalMillis >= this.maxIntervalMillis / this.multiplier) {
         this.currentIntervalMillis = this.maxIntervalMillis;
      } else {
         this.currentIntervalMillis = (int)(this.currentIntervalMillis * this.multiplier);
      }
   }

   public final int getCurrentIntervalMillis() {
      return this.currentIntervalMillis;
   }

   public final long getElapsedTimeMillis() {
      return (this.nanoClock.nanoTime() - this.startTimeNanos) / 1000000L;
   }

   public final int getInitialIntervalMillis() {
      return this.initialIntervalMillis;
   }

   public final int getMaxElapsedTimeMillis() {
      return this.maxElapsedTimeMillis;
   }

   public final int getMaxIntervalMillis() {
      return this.maxIntervalMillis;
   }

   public final double getMultiplier() {
      return this.multiplier;
   }

   public final double getRandomizationFactor() {
      return this.randomizationFactor;
   }

   @Override
   public long nextBackOffMillis() throws IOException {
      long var2;
      if (this.getElapsedTimeMillis() > this.maxElapsedTimeMillis) {
         var2 = -1L;
      } else {
         int var1 = getRandomValueFromInterval(this.randomizationFactor, Math.random(), this.currentIntervalMillis);
         this.incrementCurrentInterval();
         var2 = var1;
      }

      return var2;
   }

   @Override
   public final void reset() {
      this.currentIntervalMillis = this.initialIntervalMillis;
      this.startTimeNanos = this.nanoClock.nanoTime();
   }

   public static class Builder {
      int initialIntervalMillis = 500;
      int maxElapsedTimeMillis;
      int maxIntervalMillis;
      double multiplier;
      NanoClock nanoClock;
      double randomizationFactor = 0.5;

      public Builder() {
         this.multiplier = 1.5;
         this.maxIntervalMillis = 60000;
         this.maxElapsedTimeMillis = 900000;
         this.nanoClock = NanoClock.SYSTEM;
      }

      public ExponentialBackOff build() {
         return new ExponentialBackOff(this);
      }

      public final int getInitialIntervalMillis() {
         return this.initialIntervalMillis;
      }

      public final int getMaxElapsedTimeMillis() {
         return this.maxElapsedTimeMillis;
      }

      public final int getMaxIntervalMillis() {
         return this.maxIntervalMillis;
      }

      public final double getMultiplier() {
         return this.multiplier;
      }

      public final NanoClock getNanoClock() {
         return this.nanoClock;
      }

      public final double getRandomizationFactor() {
         return this.randomizationFactor;
      }

      public ExponentialBackOff.Builder setInitialIntervalMillis(int var1) {
         this.initialIntervalMillis = var1;
         return this;
      }

      public ExponentialBackOff.Builder setMaxElapsedTimeMillis(int var1) {
         this.maxElapsedTimeMillis = var1;
         return this;
      }

      public ExponentialBackOff.Builder setMaxIntervalMillis(int var1) {
         this.maxIntervalMillis = var1;
         return this;
      }

      public ExponentialBackOff.Builder setMultiplier(double var1) {
         this.multiplier = var1;
         return this;
      }

      public ExponentialBackOff.Builder setNanoClock(NanoClock var1) {
         this.nanoClock = Preconditions.checkNotNull(var1);
         return this;
      }

      public ExponentialBackOff.Builder setRandomizationFactor(double var1) {
         this.randomizationFactor = var1;
         return this;
      }
   }
}
