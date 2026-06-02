package okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings {
   private int a;
   private final int[] b = new int[10];

   Settings a(int var1, int var2) {
      if (var1 < this.b.length) {
         this.a |= 1 << var1;
         this.b[var1] = var2;
      }

      return this;
   }

   void a() {
      this.a = 0;
      Arrays.fill(this.b, 0);
   }

   void a(Settings var1) {
      for (int var2 = 0; var2 < 10; var2++) {
         if (var1.a(var2)) {
            this.a(var2, var1.b(var2));
         }
      }
   }

   boolean a(int var1) {
      boolean var2 = true;
      if ((1 << var1 & this.a) == 0) {
         var2 = false;
      }

      return var2;
   }

   int b() {
      return Integer.bitCount(this.a);
   }

   int b(int var1) {
      return this.b[var1];
   }

   int c() {
      int var1;
      if ((2 & this.a) != 0) {
         var1 = this.b[1];
      } else {
         var1 = -1;
      }

      return var1;
   }

   int c(int var1) {
      if ((16 & this.a) != 0) {
         var1 = this.b[4];
      }

      return var1;
   }

   int d() {
      int var1;
      if ((128 & this.a) != 0) {
         var1 = this.b[7];
      } else {
         var1 = 65535;
      }

      return var1;
   }

   int d(int var1) {
      if ((32 & this.a) != 0) {
         var1 = this.b[5];
      }

      return var1;
   }
}
