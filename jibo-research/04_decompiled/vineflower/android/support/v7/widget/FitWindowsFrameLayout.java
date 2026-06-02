package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
   private FitWindowsViewGroup.OnFitSystemWindowsListener a;

   public FitWindowsFrameLayout(Context var1) {
      super(var1);
   }

   public FitWindowsFrameLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   protected boolean fitSystemWindows(Rect var1) {
      if (this.a != null) {
         this.a.a(var1);
      }

      return super.fitSystemWindows(var1);
   }

   @Override
   public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener var1) {
      this.a = var1;
   }
}
