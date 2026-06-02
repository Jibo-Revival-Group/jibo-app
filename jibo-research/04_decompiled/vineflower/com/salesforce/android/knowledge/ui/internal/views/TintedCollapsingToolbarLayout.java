package com.salesforce.android.knowledge.ui.internal.views;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.service.common.ui.internal.text.SalesforceStyleHelper;

public class TintedCollapsingToolbarLayout extends CollapsingToolbarLayout {
   private Toolbar e;
   private ValueAnimator f;
   private int g = 16777215;

   public TintedCollapsingToolbarLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public TintedCollapsingToolbarLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      SalesforceStyleHelper var4 = SalesforceStyleHelper.a(var1, var2);
      this.setExpandedTitleTypeface(var4.b());
      this.setCollapsedTitleTypeface(var4.b());
      this.setTitle(var4.a(this.getTitle()));
   }

   private void a(int var1) {
      if (this.f == null) {
         this.f = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{this.g, var1});
         this.f.setDuration(600L);
         this.f.addUpdateListener(new AnimatorUpdateListener(this) {
            final TintedCollapsingToolbarLayout a;

            {
               this.a = var1;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               this.a.setToolbarTint((Integer)var1.getAnimatedValue());
            }
         });
      } else if (this.f.isRunning()) {
         this.f.cancel();
      }

      this.f.setIntValues(new int[]{this.g, var1});
      this.f.start();
   }

   private void c() {
      if (this.e == null) {
         int var2 = this.getChildCount();
         int var1 = 0;

         Toolbar var4;
         while (true) {
            if (var1 >= var2) {
               var4 = null;
               break;
            }

            View var3 = this.getChildAt(var1);
            if (var3 instanceof Toolbar) {
               var4 = (Toolbar)var3;
               break;
            }

            var1++;
         }

         this.e = var4;
      }
   }

   @Override
   public void a(boolean var1, boolean var2) {
      super.a(var1, var2);
      Context var4 = this.getContext();
      int var3;
      if (var1) {
         var3 = R.color.salesforce_toolbar_inverted;
      } else {
         var3 = R.color.salesforce_brand_primary_inverted;
      }

      var3 = ContextCompat.c(var4, var3);
      if (var2) {
         this.a(var3);
      } else {
         this.setToolbarTint(var3);
      }
   }

   protected void onDraw(Canvas var1) {
      this.c();
      super.onDraw(var1);
   }

   @Override
   protected void onMeasure(int var1, int var2) {
      this.c();
      super.onMeasure(var1, var2);
   }

   void setToolbarTint(int var1) {
      if (this.e != null) {
         this.g = var1;
         ViewUtil.a(this.e, var1);
      }
   }
}
