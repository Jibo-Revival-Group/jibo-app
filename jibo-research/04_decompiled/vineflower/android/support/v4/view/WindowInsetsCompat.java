package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public class WindowInsetsCompat {
   private final Object a;

   private WindowInsetsCompat(Object var1) {
      this.a = var1;
   }

   static WindowInsetsCompat a(Object var0) {
      if (var0 == null) {
         var0 = null;
      } else {
         var0 = new WindowInsetsCompat(var0);
      }

      return var0;
   }

   static Object a(WindowInsetsCompat var0) {
      Object var1;
      if (var0 == null) {
         var1 = null;
      } else {
         var1 = var0.a;
      }

      return var1;
   }

   public int a() {
      int var1;
      if (VERSION.SDK_INT >= 20) {
         var1 = ((WindowInsets)this.a).getSystemWindowInsetLeft();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public WindowInsetsCompat a(int var1, int var2, int var3, int var4) {
      WindowInsetsCompat var5;
      if (VERSION.SDK_INT >= 20) {
         var5 = new WindowInsetsCompat(((WindowInsets)this.a).replaceSystemWindowInsets(var1, var2, var3, var4));
      } else {
         var5 = null;
      }

      return var5;
   }

   public int b() {
      int var1;
      if (VERSION.SDK_INT >= 20) {
         var1 = ((WindowInsets)this.a).getSystemWindowInsetTop();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int c() {
      int var1;
      if (VERSION.SDK_INT >= 20) {
         var1 = ((WindowInsets)this.a).getSystemWindowInsetRight();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public int d() {
      int var1;
      if (VERSION.SDK_INT >= 20) {
         var1 = ((WindowInsets)this.a).getSystemWindowInsetBottom();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public boolean e() {
      boolean var1;
      if (VERSION.SDK_INT >= 20) {
         var1 = ((WindowInsets)this.a).hasSystemWindowInsets();
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.a == null) {
               if (var1.a != null) {
                  var2 = false;
               }
            } else {
               var2 = this.a.equals(var1.a);
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   public boolean f() {
      boolean var1;
      if (VERSION.SDK_INT >= 21) {
         var1 = ((WindowInsets)this.a).isConsumed();
      } else {
         var1 = false;
      }

      return var1;
   }

   public WindowInsetsCompat g() {
      WindowInsetsCompat var1;
      if (VERSION.SDK_INT >= 20) {
         var1 = new WindowInsetsCompat(((WindowInsets)this.a).consumeSystemWindowInsets());
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.a == null) {
         var1 = 0;
      } else {
         var1 = this.a.hashCode();
      }

      return var1;
   }
}
