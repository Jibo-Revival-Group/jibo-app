package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewApi17Impl extends CardViewBaseImpl {
   @Override
   public void a() {
      RoundRectDrawableWithShadow.a = new RoundRectDrawableWithShadow.RoundRectHelper(this) {
         final CardViewApi17Impl a;

         {
            this.a = var1;
         }

         @Override
         public void a(Canvas var1, RectF var2, float var3, Paint var4) {
            var1.drawRoundRect(var2, var3, var3, var4);
         }
      };
   }
}
