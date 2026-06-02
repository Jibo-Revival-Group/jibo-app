package android.support.v7.widget;

class RtlSpacingHelper {
   private int a = 0;
   private int b = 0;
   private int c = Integer.MIN_VALUE;
   private int d = Integer.MIN_VALUE;
   private int e = 0;
   private int f = 0;
   private boolean g = false;
   private boolean h = false;

   public int a() {
      return this.a;
   }

   public void a(int var1, int var2) {
      this.c = var1;
      this.d = var2;
      this.h = true;
      if (this.g) {
         if (var2 != Integer.MIN_VALUE) {
            this.a = var2;
         }

         if (var1 != Integer.MIN_VALUE) {
            this.b = var1;
         }
      } else {
         if (var1 != Integer.MIN_VALUE) {
            this.a = var1;
         }

         if (var2 != Integer.MIN_VALUE) {
            this.b = var2;
         }
      }
   }

   public void a(boolean var1) {
      if (var1 != this.g) {
         this.g = var1;
         if (this.h) {
            if (var1) {
               int var2;
               if (this.d != Integer.MIN_VALUE) {
                  var2 = this.d;
               } else {
                  var2 = this.e;
               }

               this.a = var2;
               if (this.c != Integer.MIN_VALUE) {
                  var2 = this.c;
               } else {
                  var2 = this.f;
               }

               this.b = var2;
            } else {
               int var4;
               if (this.c != Integer.MIN_VALUE) {
                  var4 = this.c;
               } else {
                  var4 = this.e;
               }

               this.a = var4;
               if (this.d != Integer.MIN_VALUE) {
                  var4 = this.d;
               } else {
                  var4 = this.f;
               }

               this.b = var4;
            }
         } else {
            this.a = this.e;
            this.b = this.f;
         }
      }
   }

   public int b() {
      return this.b;
   }

   public void b(int var1, int var2) {
      this.h = false;
      if (var1 != Integer.MIN_VALUE) {
         this.e = var1;
         this.a = var1;
      }

      if (var2 != Integer.MIN_VALUE) {
         this.f = var2;
         this.b = var2;
      }
   }

   public int c() {
      int var1;
      if (this.g) {
         var1 = this.b;
      } else {
         var1 = this.a;
      }

      return var1;
   }

   public int d() {
      int var1;
      if (this.g) {
         var1 = this.a;
      } else {
         var1 = this.b;
      }

      return var1;
   }
}
