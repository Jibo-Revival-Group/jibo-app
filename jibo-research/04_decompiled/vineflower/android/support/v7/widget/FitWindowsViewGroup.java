package android.support.v7.widget;

import android.graphics.Rect;

public interface FitWindowsViewGroup {
   void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener var1);

   interface OnFitSystemWindowsListener {
      void a(Rect var1);
   }
}
