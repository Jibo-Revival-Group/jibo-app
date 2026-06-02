package android.support.v7.widget;

import android.view.View;

class ViewBoundsCheck {
   final ViewBoundsCheck.Callback a;
   ViewBoundsCheck.BoundFlags b;

   ViewBoundsCheck(ViewBoundsCheck.Callback var1) {
      this.a = var1;
      this.b = new ViewBoundsCheck.BoundFlags();
   }

   View a(int var1, int var2, int var3, int var4) {
      int var7 = this.a.a();
      int var6 = this.a.b();
      byte var5;
      if (var2 > var1) {
         var5 = 1;
      } else {
         var5 = -1;
      }

      View var10 = null;

      while (var1 != var2) {
         View var11 = this.a.a(var1);
         int var8 = this.a.a(var11);
         int var9 = this.a.b(var11);
         this.b.a(var7, var6, var8, var9);
         if (var3 != 0) {
            this.b.a();
            this.b.a(var3);
            if (this.b.b()) {
               var10 = var11;
               break;
            }
         }

         if (var4 != 0) {
            this.b.a();
            this.b.a(var4);
            if (this.b.b()) {
               var10 = var11;
            }
         }

         var1 += var5;
      }

      return var10;
   }

   boolean a(View var1, int var2) {
      this.b.a(this.a.a(), this.a.b(), this.a.a(var1), this.a.b(var1));
      boolean var3;
      if (var2 != 0) {
         this.b.a();
         this.b.a(var2);
         var3 = this.b.b();
      } else {
         var3 = false;
      }

      return var3;
   }

   static class BoundFlags {
      int a = 0;
      int b;
      int c;
      int d;
      int e;

      int a(int var1, int var2) {
         byte var3;
         if (var1 > var2) {
            var3 = 1;
         } else if (var1 == var2) {
            var3 = 2;
         } else {
            var3 = 4;
         }

         return var3;
      }

      void a() {
         this.a = 0;
      }

      void a(int var1) {
         this.a |= var1;
      }

      void a(int var1, int var2, int var3, int var4) {
         this.b = var1;
         this.c = var2;
         this.d = var3;
         this.e = var4;
      }

      boolean b() {
         boolean var2 = false;
         boolean var5;
         if ((this.a & 7) != 0 && (this.a & this.a(this.d, this.b) << 0) == 0) {
            var5 = var2;
         } else {
            if ((this.a & 112) != 0) {
               var5 = var2;
               if ((this.a & this.a(this.d, this.c) << 4) == 0) {
                  return var5;
               }
            }

            if ((this.a & 1792) != 0) {
               var5 = var2;
               if ((this.a & this.a(this.e, this.b) << 8) == 0) {
                  return var5;
               }
            }

            if ((this.a & 28672) != 0) {
               var5 = var2;
               if ((this.a & this.a(this.e, this.c) << 12) == 0) {
                  return var5;
               }
            }

            var5 = true;
         }

         return var5;
      }
   }

   interface Callback {
      int a();

      int a(View var1);

      View a(int var1);

      int b();

      int b(View var1);
   }
}
