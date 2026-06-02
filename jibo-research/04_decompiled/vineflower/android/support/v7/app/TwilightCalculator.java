package android.support.v7.app;

class TwilightCalculator {
   private static TwilightCalculator d;
   public long a;
   public long b;
   public int c;

   static TwilightCalculator a() {
      if (d == null) {
         d = new TwilightCalculator();
      }

      return d;
   }

   public void a(long var1, double var3, double var5) {
      float var16 = (float)(var1 - 946728000000L) / 8.64E7F;
      float var15 = 6.24006F + 0.01720197F * var16;
      double var7 = var15 + 0.0334196F * Math.sin(var15) + 3.49066E-4F * Math.sin(2.0F * var15) + 5.236E-6F * Math.sin(3.0F * var15) + 1.796593063 + Math.PI;
      var5 = -var5 / 360.0;
      double var9 = (float)Math.round(var16 - 9.0E-4F - var5) + 9.0E-4F;
      var5 = Math.sin(var15) * 0.0053 + (var5 + var9) + -0.0069 * Math.sin(2.0 * var7);
      var7 = Math.asin(Math.sin(var7) * Math.sin(0.4092797F));
      double var13 = (float) (Math.PI / 180.0) * var3;
      double var11 = Math.sin(-0.10471976F);
      var9 = Math.sin(var13);
      var3 = Math.sin(var7);
      var13 = Math.cos(var13);
      var3 = (var11 - var9 * var3) / (Math.cos(var7) * var13);
      if (var3 >= 1.0) {
         this.c = 1;
         this.a = -1L;
         this.b = -1L;
      } else if (var3 <= -1.0) {
         this.c = 0;
         this.a = -1L;
         this.b = -1L;
      } else {
         var15 = (float)(Math.acos(var3) / (Math.PI * 2));
         this.a = Math.round((var15 + var5) * 8.64E7) + 946728000000L;
         this.b = Math.round((var5 - var15) * 8.64E7) + 946728000000L;
         if (this.b < var1 && this.a > var1) {
            this.c = 0;
         } else {
            this.c = 1;
         }
      }
   }
}
