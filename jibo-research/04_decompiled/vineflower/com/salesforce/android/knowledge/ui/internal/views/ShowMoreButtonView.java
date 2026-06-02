package com.salesforce.android.knowledge.ui.internal.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;

public class ShowMoreButtonView extends SalesforceTextView {
   public ShowMoreButtonView(Context var1) {
      super(var1);
   }

   public ShowMoreButtonView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public ShowMoreButtonView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if (var1.getAction() == 0) {
         this.animate().alpha(0.5F).setDuration(100L).start();
      } else if (var1.getAction() == 1 || var1.getAction() == 3) {
         this.animate().alpha(1.0F).setDuration(100L).start();
      }

      return super.onTouchEvent(var1);
   }
}
