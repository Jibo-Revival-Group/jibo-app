package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
   private ViewParent a;
   private ViewParent b;
   private final View c;
   private boolean d;
   private int[] e;

   public NestedScrollingChildHelper(View var1) {
      this.c = var1;
   }

   private void a(int var1, ViewParent var2) {
      switch (var1) {
         case 0:
            this.a = var2;
            break;
         case 1:
            this.b = var2;
      }
   }

   private ViewParent d(int var1) {
      ViewParent var2;
      switch (var1) {
         case 0:
            var2 = this.a;
            break;
         case 1:
            var2 = this.b;
            break;
         default:
            var2 = null;
      }

      return var2;
   }

   public void a(boolean var1) {
      if (this.d) {
         ViewCompat.x(this.c);
      }

      this.d = var1;
   }

   public boolean a() {
      return this.d;
   }

   public boolean a(float var1, float var2) {
      boolean var4 = false;
      boolean var3 = var4;
      if (this.a()) {
         ViewParent var5 = this.d(0);
         var3 = var4;
         if (var5 != null) {
            var3 = ViewParentCompat.a(var5, this.c, var1, var2);
         }
      }

      return var3;
   }

   public boolean a(float var1, float var2, boolean var3) {
      boolean var5 = false;
      boolean var4 = var5;
      if (this.a()) {
         ViewParent var6 = this.d(0);
         var4 = var5;
         if (var6 != null) {
            var4 = ViewParentCompat.a(var6, this.c, var1, var2, var3);
         }
      }

      return var4;
   }

   public boolean a(int var1) {
      boolean var2;
      if (this.d(var1) != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean a(int var1, int var2) {
      boolean var3;
      if (this.a(var2)) {
         var3 = true;
      } else {
         if (this.a()) {
            ViewParent var4 = this.c.getParent();
            View var5 = this.c;

            while (var4 != null) {
               if (ViewParentCompat.a(var4, var5, this.c, var1, var2)) {
                  this.a(var2, var4);
                  ViewParentCompat.b(var4, var5, this.c, var1, var2);
                  var3 = true;
                  return var3;
               }

               if (var4 instanceof View) {
                  var5 = (View)var4;
               }

               var4 = var4.getParent();
            }
         }

         var3 = false;
      }

      return var3;
   }

   public boolean a(int var1, int var2, int var3, int var4, int[] var5) {
      return this.a(var1, var2, var3, var4, var5, 0);
   }

   public boolean a(int var1, int var2, int var3, int var4, int[] var5, int var6) {
      if (this.a()) {
         ViewParent var10 = this.d(var6);
         if (var10 == null) {
            return false;
         }

         if (var1 != 0 || var2 != 0 || var3 != 0 || var4 != 0) {
            int var7;
            int var8;
            if (var5 != null) {
               this.c.getLocationInWindow(var5);
               var8 = var5[0];
               var7 = var5[1];
            } else {
               var7 = 0;
               var8 = 0;
            }

            ViewParentCompat.a(var10, this.c, var1, var2, var3, var4, var6);
            if (var5 != null) {
               this.c.getLocationInWindow(var5);
               var5[0] -= var8;
               var5[1] -= var7;
            }

            return true;
         }

         if (var5 != null) {
            var5[0] = 0;
            var5[1] = 0;
         }
      }

      return false;
   }

   public boolean a(int var1, int var2, int[] var3, int[] var4) {
      return this.a(var1, var2, var3, var4, 0);
   }

   public boolean a(int var1, int var2, int[] var3, int[] var4, int var5) {
      boolean var9 = false;
      boolean var8 = var9;
      if (this.a()) {
         ViewParent var10 = this.d(var5);
         if (var10 == null) {
            var8 = var9;
         } else if (var1 == 0 && var2 == 0) {
            var8 = var9;
            if (var4 != null) {
               var4[0] = 0;
               var4[1] = 0;
               var8 = var9;
            }
         } else {
            int var6;
            int var7;
            if (var4 != null) {
               this.c.getLocationInWindow(var4);
               var6 = var4[0];
               var7 = var4[1];
            } else {
               var7 = 0;
               var6 = 0;
            }

            if (var3 == null) {
               if (this.e == null) {
                  this.e = new int[2];
               }

               var3 = this.e;
            }

            var3[0] = 0;
            var3[1] = 0;
            ViewParentCompat.a(var10, this.c, var1, var2, var3, var5);
            if (var4 != null) {
               this.c.getLocationInWindow(var4);
               var4[0] -= var6;
               var4[1] -= var7;
            }

            if (var3[0] == 0 && var3[1] == 0) {
               var8 = false;
            } else {
               var8 = true;
            }
         }
      }

      return var8;
   }

   public boolean b() {
      return this.a(0);
   }

   public boolean b(int var1) {
      return this.a(var1, 0);
   }

   public void c() {
      this.c(0);
   }

   public void c(int var1) {
      ViewParent var2 = this.d(var1);
      if (var2 != null) {
         ViewParentCompat.a(var2, this.c, var1);
         this.a(var1, null);
      }
   }
}
