package com.jibo.utils.cache.pool;

import android.support.v4.util.Pools;
import android.util.Log;

public final class FactoryPools {
   private static final FactoryPools.Resetter<Object> a = new FactoryPools.Resetter<Object>() {
      @Override
      public void a(Object var1) {
      }
   };

   public static <T extends FactoryPools.Poolable> Pools.Pool<T> a(int var0, FactoryPools.Factory<T> var1) {
      return a(new Pools.SynchronizedPool<>(var0), var1);
   }

   private static <T extends FactoryPools.Poolable> Pools.Pool<T> a(Pools.Pool<T> var0, FactoryPools.Factory<T> var1) {
      return a(var0, var1, a());
   }

   private static <T> Pools.Pool<T> a(Pools.Pool<T> var0, FactoryPools.Factory<T> var1, FactoryPools.Resetter<T> var2) {
      return new FactoryPools.FactoryPool<>(var0, var1, var2);
   }

   private static <T> FactoryPools.Resetter<T> a() {
      return (FactoryPools.Resetter<T>)a;
   }

   public interface Factory<T> {
      T b();
   }

   private static final class FactoryPool<T> implements Pools.Pool<T> {
      private final FactoryPools.Factory<T> a;
      private final FactoryPools.Resetter<T> b;
      private final Pools.Pool<T> c;

      FactoryPool(Pools.Pool<T> var1, FactoryPools.Factory<T> var2, FactoryPools.Resetter<T> var3) {
         this.c = var1;
         this.a = var2;
         this.b = var3;
      }

      @Override
      public T a() {
         Object var2 = this.c.a();
         Object var1 = var2;
         if (var2 == null) {
            var2 = this.a.b();
            var1 = var2;
            if (Log.isLoggable("FactoryPools", 2)) {
               Log.v("FactoryPools", "Created new " + var2.getClass());
               var1 = var2;
            }
         }

         if (var1 instanceof FactoryPools.Poolable) {
            ((FactoryPools.Poolable)var1).a().a(false);
         }

         return (T)var1;
      }

      @Override
      public boolean a(T var1) {
         if (var1 instanceof FactoryPools.Poolable) {
            ((FactoryPools.Poolable)var1).a().a(true);
         }

         this.b.a((T)var1);
         return this.c.a((T)var1);
      }
   }

   public interface Poolable {
      StateVerifier a();
   }

   public interface Resetter<T> {
      void a(T var1);
   }
}
