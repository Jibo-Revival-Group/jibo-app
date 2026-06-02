package android.support.v4.util;

public class Pair<F, S> {
   public final F a;
   public final S b;

   public Pair(F var1, S var2) {
      this.a = (F)var1;
      this.b = (S)var2;
   }

   private static boolean a(Object var0, Object var1) {
      boolean var2;
      if (var0 != var1 && (var0 == null || !var0.equals(var1))) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (!(var1 instanceof Pair)) {
         var2 = var3;
      } else {
         var1 = var1;
         var2 = var3;
         if (a(var1.a, this.a)) {
            var2 = var3;
            if (a(var1.b, this.b)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.hashCode();
      }

      if (this.b != null) {
         var2 = this.b.hashCode();
      }

      return var1 ^ var2;
   }

   @Override
   public String toString() {
      return "Pair{" + String.valueOf(this.a) + " " + this.b + "}";
   }
}
