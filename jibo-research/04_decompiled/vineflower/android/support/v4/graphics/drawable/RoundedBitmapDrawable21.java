package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
   protected RoundedBitmapDrawable21(Resources var1, Bitmap var2) {
      super(var1, var2);
   }

   @Override
   void a(int var1, int var2, int var3, Rect var4, Rect var5) {
      Gravity.apply(var1, var2, var3, var4, var5, 0);
   }

   public void getOutline(Outline var1) {
      this.a();
      var1.setRoundRect(this.b, this.b());
   }
}
