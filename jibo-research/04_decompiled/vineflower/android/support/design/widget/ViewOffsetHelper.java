package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

class ViewOffsetHelper {
   private final View a;
   private int b;
   private int c;
   private int d;
   private int e;

   public ViewOffsetHelper(View var1) {
      this.a = var1;
   }

   private void d() {
      ViewCompat.c(this.a, this.d - (this.a.getTop() - this.b));
      ViewCompat.d(this.a, this.e - (this.a.getLeft() - this.c));
   }

   public void a() {
      this.b = this.a.getTop();
      this.c = this.a.getLeft();
      this.d();
   }

   public boolean a(int var1) {
      boolean var2;
      if (this.d != var1) {
         this.d = var1;
         this.d();
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int b() {
      return this.d;
   }

   public boolean b(int var1) {
      boolean var2;
      if (this.e != var1) {
         this.e = var1;
         this.d();
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public int c() {
      return this.b;
   }
}
