package com.google.common.base;

public abstract class Ticker {
   private static final Ticker a = new Ticker() {
      @Override
      public long a() {
         return Platform.a();
      }
   };

   protected Ticker() {
   }

   public static Ticker b() {
      return a;
   }

   public abstract long a();
}
