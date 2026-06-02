package com.google.api.client.testing.util;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
public class MockBackOff implements BackOff {
   private long backOffMillis;
   private int maxTries = 10;
   private int numTries;

   public final int getMaxTries() {
      return this.numTries;
   }

   public final int getNumberOfTries() {
      return this.numTries;
   }

   @Override
   public long nextBackOffMillis() throws IOException {
      long var3 = -1L;
      long var1 = var3;
      if (this.numTries < this.maxTries) {
         if (this.backOffMillis == -1L) {
            var1 = var3;
         } else {
            this.numTries++;
            var1 = this.backOffMillis;
         }
      }

      return var1;
   }

   @Override
   public void reset() throws IOException {
      this.numTries = 0;
   }

   public MockBackOff setBackOffMillis(long var1) {
      boolean var3;
      if (var1 != -1L && var1 < 0L) {
         var3 = false;
      } else {
         var3 = true;
      }

      Preconditions.checkArgument(var3);
      this.backOffMillis = var1;
      return this;
   }

   public MockBackOff setMaxTries(int var1) {
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.maxTries = var1;
      return this;
   }
}
