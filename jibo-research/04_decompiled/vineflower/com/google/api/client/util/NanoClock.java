package com.google.api.client.util;

public interface NanoClock {
   NanoClock SYSTEM = new NanoClock() {
      @Override
      public long nanoTime() {
         return System.nanoTime();
      }
   };

   long nanoTime();
}
