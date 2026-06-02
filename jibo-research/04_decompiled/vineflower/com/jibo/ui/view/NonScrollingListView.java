package com.jibo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class NonScrollingListView extends ListView {
   public NonScrollingListView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public NonScrollingListView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public void onMeasure(int var1, int var2) {
      super.onMeasure(var1, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
      this.getLayoutParams().height = this.getMeasuredHeight();
   }
}
