package okio;

final class Segment {
   final byte[] a;
   int b;
   int c;
   boolean d;
   boolean e;
   Segment f;
   Segment g;

   Segment() {
      this.a = new byte[8192];
      this.e = true;
      this.d = false;
   }

   Segment(Segment var1) {
      this(var1.a, var1.b, var1.c);
      var1.d = true;
   }

   Segment(byte[] var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.e = false;
      this.d = true;
   }

   public Segment a() {
      Segment var1;
      if (this.f != this) {
         var1 = this.f;
      } else {
         var1 = null;
      }

      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return var1;
   }

   public Segment a(int var1) {
      if (var1 > 0 && var1 <= this.c - this.b) {
         Segment var2;
         if (var1 >= 1024) {
            var2 = new Segment(this);
         } else {
            var2 = SegmentPool.a();
            System.arraycopy(this.a, this.b, var2.a, 0, var1);
         }

         var2.c = var2.b + var1;
         this.b += var1;
         this.g.a(var2);
         return var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public Segment a(Segment var1) {
      var1.g = this;
      var1.f = this.f;
      this.f.g = var1;
      this.f = var1;
      return var1;
   }

   public void a(Segment var1, int var2) {
      if (!var1.e) {
         throw new IllegalArgumentException();
      }

      if (var1.c + var2 > 8192) {
         if (var1.d) {
            throw new IllegalArgumentException();
         }

         if (var1.c + var2 - var1.b > 8192) {
            throw new IllegalArgumentException();
         }

         System.arraycopy(var1.a, var1.b, var1.a, 0, var1.c - var1.b);
         var1.c = var1.c - var1.b;
         var1.b = 0;
      }

      System.arraycopy(this.a, this.b, var1.a, var1.c, var2);
      var1.c += var2;
      this.b += var2;
   }

   public void b() {
      if (this.g == this) {
         throw new IllegalStateException();
      }

      if (this.g.e) {
         int var3 = this.c - this.b;
         int var2 = this.g.c;
         int var1;
         if (this.g.d) {
            var1 = 0;
         } else {
            var1 = this.g.b;
         }

         if (var3 <= var1 + (8192 - var2)) {
            this.a(this.g, var3);
            this.a();
            SegmentPool.a(this);
         }
      }
   }
}
