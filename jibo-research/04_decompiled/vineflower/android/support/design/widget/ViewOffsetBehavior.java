package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
   private ViewOffsetHelper a;
   private int b = 0;
   private int c = 0;

   public ViewOffsetBehavior() {
   }

   public ViewOffsetBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public boolean a(int var1) {
      boolean var2;
      if (this.a != null) {
         var2 = this.a.a(var1);
      } else {
         this.b = var1;
         var2 = false;
      }

      return var2;
   }

   @Override
   public boolean a(CoordinatorLayout var1, V var2, int var3) {
      this.b(var1, (V)var2, var3);
      if (this.a == null) {
         this.a = new ViewOffsetHelper(var2);
      }

      this.a.a();
      if (this.b != 0) {
         this.a.a(this.b);
         this.b = 0;
      }

      if (this.c != 0) {
         this.a.b(this.c);
         this.c = 0;
      }

      return true;
   }

   public int b() {
      int var1;
      if (this.a != null) {
         var1 = this.a.b();
      } else {
         var1 = 0;
      }

      return var1;
   }

   protected void b(CoordinatorLayout var1, V var2, int var3) {
      var1.a(var2, var3);
   }
}
