package android.support.v7.widget;

import android.graphics.Outline;

class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
   public ActionBarBackgroundDrawableV21(ActionBarContainer var1) {
      super(var1);
   }

   public void getOutline(Outline var1) {
      if (this.a.d) {
         if (this.a.c != null) {
            this.a.c.getOutline(var1);
         }
      } else if (this.a.a != null) {
         this.a.a.getOutline(var1);
      }
   }
}
