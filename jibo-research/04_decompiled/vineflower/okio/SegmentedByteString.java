package okio;

import java.util.Arrays;

final class SegmentedByteString extends ByteString {
   final transient byte[][] f;
   final transient int[] g;

   SegmentedByteString(Buffer var1, int var2) {
      int var5 = 0;
      super(null);
      Util.a(var1.b, 0L, var2);
      Segment var6 = var1.a;
      int var4 = 0;

      for (int var3 = 0; var3 < var2; var6 = var6.f) {
         if (var6.c == var6.b) {
            throw new AssertionError("s.limit == s.pos");
         }

         var3 += var6.c - var6.b;
         var4++;
      }

      this.f = new byte[var4][];
      this.g = new int[var4 * 2];
      Segment var7 = var1.a;
      var4 = 0;

      for (int var8 = var5; var8 < var2; var7 = var7.f) {
         this.f[var4] = var7.a;
         var5 = var7.c - var7.b + var8;
         var8 = var5;
         if (var5 > var2) {
            var8 = var2;
         }

         this.g[var4] = var8;
         this.g[this.f.length + var4] = var7.b;
         var7.d = true;
         var4++;
      }
   }

   private int b(int var1) {
      var1 = Arrays.binarySearch(this.g, 0, this.f.length, var1 + 1);
      if (var1 < 0) {
         var1 = ~var1;
      }

      return var1;
   }

   private ByteString j() {
      return new ByteString(this.i());
   }

   private Object writeReplace() {
      return this.j();
   }

   @Override
   public byte a(int var1) {
      Util.a(this.g[this.f.length - 1], var1, 1L);
      int var3 = this.b(var1);
      int var2;
      if (var3 == 0) {
         var2 = 0;
      } else {
         var2 = this.g[var3 - 1];
      }

      int var4 = this.g[this.f.length + var3];
      return this.f[var3][var1 - var2 + var4];
   }

   @Override
   public String a() {
      return this.j().a();
   }

   @Override
   public ByteString a(int var1, int var2) {
      return this.j().a(var1, var2);
   }

   @Override
   void a(Buffer var1) {
      int var2 = 0;
      int var5 = this.f.length;
      int var3 = 0;

      while (var2 < var5) {
         int var6 = this.g[var5 + var2];
         int var4 = this.g[var2];
         Segment var9 = new Segment(this.f[var2], var6, var6 + var4 - var3);
         if (var1.a == null) {
            var9.g = var9;
            var9.f = var9;
            var1.a = var9;
         } else {
            var1.a.g.a(var9);
         }

         var2++;
         var3 = var4;
      }

      long var7 = var1.b;
      var1.b = var3 + var7;
   }

   @Override
   public boolean a(int var1, ByteString var2, int var3, int var4) {
      boolean var10 = false;
      boolean var9 = var10;
      if (var1 >= 0) {
         if (var1 > this.h() - var4) {
            var9 = var10;
         } else {
            for (int var5 = this.b(var1); var4 > 0; var5++) {
               int var6;
               if (var5 == 0) {
                  var6 = 0;
               } else {
                  var6 = this.g[var5 - 1];
               }

               int var7 = Math.min(var4, this.g[var5] - var6 + var6 - var1);
               int var8 = this.g[this.f.length + var5];
               var9 = var10;
               if (!var2.a(var3, this.f[var5], var1 - var6 + var8, var7)) {
                  return var9;
               }

               var1 += var7;
               var3 += var7;
               var4 -= var7;
            }

            var9 = true;
         }
      }

      return var9;
   }

   @Override
   public boolean a(int var1, byte[] var2, int var3, int var4) {
      boolean var10 = false;
      boolean var9 = var10;
      if (var1 >= 0) {
         var9 = var10;
         if (var1 <= this.h() - var4) {
            var9 = var10;
            if (var3 >= 0) {
               if (var3 > var2.length - var4) {
                  var9 = var10;
               } else {
                  for (int var5 = this.b(var1); var4 > 0; var5++) {
                     int var6;
                     if (var5 == 0) {
                        var6 = 0;
                     } else {
                        var6 = this.g[var5 - 1];
                     }

                     int var7 = Math.min(var4, this.g[var5] - var6 + var6 - var1);
                     int var8 = this.g[this.f.length + var5];
                     var9 = var10;
                     if (!Util.a(this.f[var5], var1 - var6 + var8, var2, var3, var7)) {
                        return var9;
                     }

                     var1 += var7;
                     var3 += var7;
                     var4 -= var7;
                  }

                  var9 = true;
               }
            }
         }
      }

      return var9;
   }

   @Override
   public String b() {
      return this.j().b();
   }

   @Override
   public ByteString c() {
      return this.j().c();
   }

   @Override
   public ByteString d() {
      return this.j().d();
   }

   @Override
   public ByteString e() {
      return this.j().e();
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (var1 instanceof ByteString && ((ByteString)var1).h() == this.h() && this.a(0, (ByteString)var1, 0, this.h())) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public String f() {
      return this.j().f();
   }

   @Override
   public ByteString g() {
      return this.j().g();
   }

   @Override
   public int h() {
      return this.g[this.f.length - 1];
   }

   @Override
   public int hashCode() {
      int var1 = this.d;
      if (var1 == 0) {
         var1 = 1;
         int var7 = this.f.length;
         int var2 = 0;
         int var3 = 0;

         while (var2 < var7) {
            byte[] var8 = this.f[var2];
            int var6 = this.g[var7 + var2];
            int var5 = this.g[var2];

            for (int var4 = var6; var4 < var5 - var3 + var6; var4++) {
               var1 = var1 * 31 + var8[var4];
            }

            var2++;
            var3 = var5;
         }

         this.d = var1;
      }

      return var1;
   }

   @Override
   public byte[] i() {
      int var2 = 0;
      byte[] var6 = new byte[this.g[this.f.length - 1]];
      int var4 = this.f.length;
      int var1 = 0;

      while (var2 < var4) {
         int var5 = this.g[var4 + var2];
         int var3 = this.g[var2];
         System.arraycopy(this.f[var2], var5, var6, var1, var3 - var1);
         var2++;
         var1 = var3;
      }

      return var6;
   }

   @Override
   public String toString() {
      return this.j().toString();
   }
}
