package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class VisibilityAwareImageButton extends ImageButton {
   private int a = this.getVisibility();

   public VisibilityAwareImageButton(Context var1) {
      this(var1, null);
   }

   public VisibilityAwareImageButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public VisibilityAwareImageButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   final void a(int var1, boolean var2) {
      super.setVisibility(var1);
      if (var2) {
         this.a = var1;
      }
   }

   final int getUserSetVisibility() {
      return this.a;
   }

   public void setVisibility(int var1) {
      this.a(var1, true);
   }
}
