package com.salesforce.android.knowledge.ui.internal.views;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class InsetRelativeLayout extends RelativeLayout {
   public InsetRelativeLayout(Context var1) {
      super(var1);
   }

   public InsetRelativeLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public InsetRelativeLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (ViewCompat.r(this)) {
         ViewCompat.q(this);
      }
   }
}
