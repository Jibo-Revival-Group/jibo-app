package android.support.design.widget;

import android.graphics.Outline;

class CircularBorderDrawableLollipop extends CircularBorderDrawable {
   public void getOutline(Outline var1) {
      this.copyBounds(this.b);
      var1.setOval(this.b);
   }
}
