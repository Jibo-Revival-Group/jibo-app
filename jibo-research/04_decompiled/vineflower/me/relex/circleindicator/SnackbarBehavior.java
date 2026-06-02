package me.relex.circleindicator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class SnackbarBehavior extends CoordinatorLayout.Behavior<CircleIndicator> {
   public SnackbarBehavior() {
   }

   public SnackbarBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private float a(CoordinatorLayout var1, CircleIndicator var2) {
      float var3 = 0.0F;
      List var6 = var1.c(var2);
      int var5 = var6.size();

      for (int var4 = 0; var4 < var5; var4++) {
         View var7 = (View)var6.get(var4);
         if (var7 instanceof Snackbar.SnackbarLayout && var1.a(var2, var7)) {
            var3 = Math.min(var3, ViewCompat.i(var7) - var7.getHeight());
         }
      }

      return var3;
   }

   public boolean a(CoordinatorLayout var1, CircleIndicator var2, View var3) {
      return var3 instanceof Snackbar.SnackbarLayout;
   }

   public boolean b(CoordinatorLayout var1, CircleIndicator var2, View var3) {
      var2.setTranslationY(this.a(var1, var2));
      return true;
   }
}
