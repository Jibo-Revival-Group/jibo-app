package com.bumptech.glide.util;

public class MultiClassKey {
   private Class<?> a;
   private Class<?> b;

   public MultiClassKey() {
   }

   public MultiClassKey(Class<?> var1, Class<?> var2) {
      this.a(var1, var2);
   }

   public void a(Class<?> var1, Class<?> var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (!this.a.equals(var1.a)) {
               var2 = false;
            } else if (!this.b.equals(var1.b)) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode() * 31 + this.b.hashCode();
   }

   @Override
   public String toString() {
      return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
   }
}
