package android.support.v4.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ViewGroupUtils {
   private static final ThreadLocal<Matrix> a = new ThreadLocal<>();
   private static final ThreadLocal<RectF> b = new ThreadLocal<>();

   static void a(ViewGroup var0, View var1, Rect var2) {
      Matrix var3 = a.get();
      if (var3 == null) {
         var3 = new Matrix();
         a.set(var3);
      } else {
         var3.reset();
      }

      a(var0, var1, var3);
      RectF var5 = b.get();
      RectF var4 = var5;
      if (var5 == null) {
         var4 = new RectF();
         b.set(var4);
      }

      var4.set(var2);
      var3.mapRect(var4);
      var2.set((int)(var4.left + 0.5F), (int)(var4.top + 0.5F), (int)(var4.right + 0.5F), (int)(var4.bottom + 0.5F));
   }

   private static void a(ViewParent var0, View var1, Matrix var2) {
      ViewParent var3 = var1.getParent();
      if (var3 instanceof View && var3 != var0) {
         View var4 = (View)var3;
         a(var0, var4, var2);
         var2.preTranslate(-var4.getScrollX(), -var4.getScrollY());
      }

      var2.preTranslate(var1.getLeft(), var1.getTop());
      if (!var1.getMatrix().isIdentity()) {
         var2.preConcat(var1.getMatrix());
      }
   }

   public static void b(ViewGroup var0, View var1, Rect var2) {
      var2.set(0, 0, var1.getWidth(), var1.getHeight());
      a(var0, var1, var2);
   }
}
