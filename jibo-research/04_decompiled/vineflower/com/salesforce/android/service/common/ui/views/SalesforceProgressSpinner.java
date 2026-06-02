package com.salesforce.android.service.common.ui.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.utils.ShapeFactory;

public class SalesforceProgressSpinner extends View implements AnimatorUpdateListener {
   private final SalesforceProgressSpinner.ProgressSpinner a;

   public SalesforceProgressSpinner(Context var1) {
      this(var1, null);
   }

   public SalesforceProgressSpinner(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.salesforceProgressSpinnerStyle);
   }

   public SalesforceProgressSpinner(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var6 = var1.getTheme().obtainStyledAttributes(var2, R.styleable.SalesforceProgressSpinner, var3, 0);
      SalesforceProgressSpinner.ProgressSpinnerProperties var7 = new SalesforceProgressSpinner.ProgressSpinnerProperties();

      try {
         var7.d = this.a(var6, R.styleable.SalesforceProgressSpinner_salesforce_highlight_color, R.color.salesforce_brand_secondary);
         var7.c = this.a(var6, R.styleable.SalesforceProgressSpinner_salesforce_shadow_color, R.color.salesforce_contrast_tertiary);
         var7.b = this.a(this.a(var6, R.styleable.SalesforceProgressSpinner_salesforce_highlight_arc_degrees));
         var7.a = this.c(var6, R.styleable.SalesforceProgressSpinner_salesforce_thickness);
         var7.e = this.b(var6, R.styleable.SalesforceProgressSpinner_salesforce_rotations_per_second);
      } finally {
         var6.recycle();
      }

      this.a = new SalesforceProgressSpinner.ProgressSpinner(var7);
   }

   private int a(TypedArray var1, int var2, int var3) {
      return var1.getColor(var2, ContextCompat.c(this.getContext(), var3));
   }

   private int a(String var1) {
      int var2;
      try {
         var2 = Integer.parseInt(var1);
      } catch (NumberFormatException var3) {
         var2 = 0;
      }

      return var2;
   }

   private String a(TypedArray var1, int var2) {
      return var1.getString(var2);
   }

   private float b(TypedArray var1, int var2) {
      return var1.getFloat(var2, 0.0F);
   }

   private int c(TypedArray var1, int var2) {
      return var1.getDimensionPixelSize(var2, 0);
   }

   public void onAnimationUpdate(ValueAnimator var1) {
      this.setRotation((Float)var1.getAnimatedValue());
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.getVisibility() == 0) {
         this.a.a(this);
         this.a.a();
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.a.b();
      this.a.b(this);
   }

   protected void onDraw(Canvas var1) {
      this.a.a(var1);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      this.a.a(var1, var2);
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      if (var1 == 0) {
         this.a.b();
         this.a.a();
      } else {
         this.a.b();
      }
   }

   static class ProgressSpinner {
      final GradientDrawable a;
      final GradientDrawable b;
      private final SalesforceProgressSpinner.ProgressSpinnerProperties c;
      private final ValueAnimator d;

      ProgressSpinner(SalesforceProgressSpinner.ProgressSpinnerProperties var1) {
         this.c = var1;
         this.d = this.b(this.c.e);
         this.a = this.c();
         this.a.setStroke(this.c.a, this.c.c);
         this.b = this.c();
      }

      void a() {
         this.d.start();
      }

      void a(float var1) {
         float var2 = this.c.b / 360.0F * var1;
         this.b.setStroke(this.c.a, this.c.d, var2, var1 - var2);
      }

      void a(int var1, int var2) {
         int var5 = Math.min(var1, var2);
         float var3 = var5;
         int var4 = (var1 - var5) / 2;
         var5 = (var2 - var5) / 2;
         this.a.setBounds(var4, var5, var1 - var4, var2 - var5);
         this.b.setBounds(var4, var5, var1 - var4, var2 - var5);
         this.a((float) Math.PI * var3);
      }

      void a(AnimatorUpdateListener var1) {
         this.d.addUpdateListener(var1);
      }

      void a(Canvas var1) {
         this.a.draw(var1);
         this.b.draw(var1);
      }

      ValueAnimator b(float var1) {
         ValueAnimator var2 = ValueAnimator.ofFloat(new float[]{0.0F, 360.0F});
         var2.setRepeatCount(-1);
         var2.setDuration((long)(1000.0F / var1));
         var2.setInterpolator(new LinearInterpolator());
         return var2;
      }

      void b() {
         this.d.cancel();
      }

      void b(AnimatorUpdateListener var1) {
         this.d.removeUpdateListener(var1);
      }

      GradientDrawable c() {
         GradientDrawable var1 = ShapeFactory.a();
         var1.setColor(0);
         var1.setShape(1);
         return var1;
      }
   }

   static class ProgressSpinnerProperties {
      int a;
      int b;
      int c;
      int d;
      float e;
   }
}
