package com.salesforce.android.service.common.ui.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

public class SalesforceFloatingActionButton extends Button {
   private final int a;
   private final int b;
   private final int c;
   private final int d;
   private final Drawable e;
   private final SalesforceFloatingActionButtonImpl f;

   public SalesforceFloatingActionButton(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var5 = var1.getTheme().obtainStyledAttributes(var2, R.styleable.SalesforceFloatingActionButton, 0, 0);

      try {
         this.a = this.a(var5, R.styleable.SalesforceFloatingActionButton_salesforce_background_unselected, R.color.salesforce_contrast_primary);
         this.b = this.a(var5, R.styleable.SalesforceFloatingActionButton_salesforce_background_selected, R.color.salesforce_feedback_primary);
         this.c = this.a(var5, R.styleable.SalesforceFloatingActionButton_salesforce_src_color_unselected, R.color.salesforce_contrast_inverted);
         this.d = this.a(var5, R.styleable.SalesforceFloatingActionButton_salesforce_src_color_selected, R.color.salesforce_brand_primary_inverted);
         this.e = var5.getDrawable(R.styleable.SalesforceFloatingActionButton_salesforce_src);
      } finally {
         var5.recycle();
      }

      this.f = SalesforceFloatingActionButtonImpl.a(this).a(this.a).b(this.b).a(this.e).c(this.c).d(this.d).a();
   }

   private int a(TypedArray var1, int var2, int var3) {
      return var1.getColor(var2, ContextCompat.c(this.getContext(), var3));
   }

   protected void onDraw(Canvas var1) {
      this.f.a(var1);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.f.a(var1, var2);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if (var1.getAction() == 0) {
         Coordinate var3 = Coordinate.a((int)var1.getX(), (int)var1.getY());
         AnimatorSet var2 = new AnimatorSet();
         var2.playSequentially(new Animator[]{this.f.a(var3), this.f.b(var3)});
         var2.start();
      }

      return super.onTouchEvent(var1);
   }
}
