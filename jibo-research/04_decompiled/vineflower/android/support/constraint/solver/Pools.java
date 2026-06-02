package android.support.constraint.solver;

final class Pools {
   interface Pool<T> {
      T a();

      void a(T[] var1, int var2);

      boolean a(T var1);
   }

   static class SimplePool<T> implements Pools.Pool<T> {
      private final Object[] a;
      private int b;

      SimplePool(int var1) {
         if (var1 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
         }

         this.a = new Object[var1];
      }

      @Override
      public T a() {
         Object var2;
         if (this.b > 0) {
            int var1 = this.b - 1;
            var2 = this.a[var1];
            this.a[var1] = null;
            this.b--;
         } else {
            var2 = null;
         }

         return (T)var2;
      }

      @Override
      public void a(T[] var1, int var2) {
         int var3 = var2;
         if (var2 > var1.length) {
            var3 = var1.length;
         }

         for (int var5 = 0; var5 < var3; var5++) {
            Object var4 = var1[var5];
            if (this.b < this.a.length) {
               this.a[this.b] = var4;
               this.b++;
            }
         }
      }

      @Override
      public boolean a(T var1) {
         boolean var2;
         if (this.b < this.a.length) {
            this.a[this.b] = var1;
            this.b++;
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }
}
