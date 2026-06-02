package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ItemTouchUIUtilImpl {
   static class Api21Impl extends ItemTouchUIUtilImpl.BaseImpl {
      private float a(RecyclerView var1, View var2) {
         int var7 = var1.getChildCount();
         int var6 = 0;
         float var3 = 0.0F;

         while (var6 < var7) {
            View var8 = var1.getChildAt(var6);
            float var4;
            if (var8 == var2) {
               var4 = var3;
            } else {
               float var5 = ViewCompat.m(var8);
               var4 = var3;
               if (var5 > var3) {
                  var4 = var5;
               }
            }

            var6++;
            var3 = var4;
         }

         return var3;
      }

      @Override
      public void a(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
         if (var7 && var3.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            float var8 = ViewCompat.m(var3);
            ViewCompat.a(var3, 1.0F + this.a(var2, var3));
            var3.setTag(R.id.item_touch_helper_previous_elevation, var8);
         }

         super.a(var1, var2, var3, var4, var5, var6, var7);
      }

      @Override
      public void a(View var1) {
         Object var2 = var1.getTag(R.id.item_touch_helper_previous_elevation);
         if (var2 != null && var2 instanceof Float) {
            ViewCompat.a(var1, (Float)var2);
         }

         var1.setTag(R.id.item_touch_helper_previous_elevation, null);
         super.a(var1);
      }
   }

   static class BaseImpl implements ItemTouchUIUtil {
      @Override
      public void a(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
         var3.setTranslationX(var4);
         var3.setTranslationY(var5);
      }

      @Override
      public void a(View var1) {
         var1.setTranslationX(0.0F);
         var1.setTranslationY(0.0F);
      }

      @Override
      public void b(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
      }

      @Override
      public void b(View var1) {
      }
   }
}
