package com.jibo.utils.cache.pool;

public abstract class StateVerifier {
   private StateVerifier() {
   }

   public static StateVerifier a() {
      return new StateVerifier.DefaultStateVerifier();
   }

   abstract void a(boolean var1);

   private static class DefaultStateVerifier extends StateVerifier {
      private volatile boolean a;

      private DefaultStateVerifier() {
      }

      @Override
      public void a(boolean var1) {
         this.a = var1;
      }
   }
}
