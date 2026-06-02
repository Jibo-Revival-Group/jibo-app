package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
public class PagerTitleStrip extends ViewGroup {
   private static final int[] n = new int[]{16842804, 16842901, 16842904, 16842927};
   private static final int[] o = new int[]{16843660};
   ViewPager a;
   TextView b;
   TextView c;
   TextView d;
   float e;
   int f;
   private int g;
   private int h;
   private int i;
   private boolean j;
   private boolean k;
   private final PagerTitleStrip.PageListener l;
   private WeakReference<PagerAdapter> m;
   private int p;

   public PagerTitleStrip(Context var1, AttributeSet var2) {
      boolean var5 = false;
      super(var1, var2);
      this.g = -1;
      this.e = -1.0F;
      this.l = new PagerTitleStrip.PageListener(this);
      TextView var6 = new TextView(var1);
      this.b = var6;
      this.addView(var6);
      var6 = new TextView(var1);
      this.c = var6;
      this.addView(var6);
      var6 = new TextView(var1);
      this.d = var6;
      this.addView(var6);
      TypedArray var7 = var1.obtainStyledAttributes(var2, n);
      int var3 = var7.getResourceId(0, 0);
      if (var3 != 0) {
         TextViewCompat.a(this.b, var3);
         TextViewCompat.a(this.c, var3);
         TextViewCompat.a(this.d, var3);
      }

      int var4 = var7.getDimensionPixelSize(1, 0);
      if (var4 != 0) {
         this.a(0, var4);
      }

      if (var7.hasValue(2)) {
         var4 = var7.getColor(2, 0);
         this.b.setTextColor(var4);
         this.c.setTextColor(var4);
         this.d.setTextColor(var4);
      }

      this.i = var7.getInteger(3, 80);
      var7.recycle();
      this.f = this.c.getTextColors().getDefaultColor();
      this.setNonPrimaryAlpha(0.6F);
      this.b.setEllipsize(TruncateAt.END);
      this.c.setEllipsize(TruncateAt.END);
      this.d.setEllipsize(TruncateAt.END);
      if (var3 != 0) {
         TypedArray var8 = var1.obtainStyledAttributes(var3, o);
         var5 = var8.getBoolean(0, false);
         var8.recycle();
      }

      if (var5) {
         setSingleLineAllCaps(this.b);
         setSingleLineAllCaps(this.c);
         setSingleLineAllCaps(this.d);
      } else {
         this.b.setSingleLine();
         this.c.setSingleLine();
         this.d.setSingleLine();
      }

      this.h = (int)(var1.getResources().getDisplayMetrics().density * 16.0F);
   }

   private static void setSingleLineAllCaps(TextView var0) {
      var0.setTransformationMethod(new PagerTitleStrip.SingleLineAllCapsTransform(var0.getContext()));
   }

   public void a(int var1, float var2) {
      this.b.setTextSize(var1, var2);
      this.c.setTextSize(var1, var2);
      this.d.setTextSize(var1, var2);
   }

   void a(int var1, float var2, boolean var3) {
      if (var1 != this.g) {
         this.a(var1, this.a.getAdapter());
      } else if (!var3 && var2 == this.e) {
         return;
      }

      this.k = true;
      int var10 = this.b.getMeasuredWidth();
      int var7 = this.c.getMeasuredWidth();
      int var8 = this.d.getMeasuredWidth();
      int var14 = var7 / 2;
      int var9 = this.getWidth();
      int var6 = this.getHeight();
      int var12 = this.getPaddingLeft();
      int var11 = this.getPaddingRight();
      var1 = this.getPaddingTop();
      int var16 = this.getPaddingBottom();
      int var13 = var11 + var14;
      float var5 = 0.5F + var2;
      float var4 = var5;
      if (var5 > 1.0F) {
         var4 = var5 - 1.0F;
      }

      var14 = var9 - var13 - (int)(var4 * (var9 - (var12 + var14) - var13)) - var7 / 2;
      var13 = var14 + var7;
      int var17 = this.b.getBaseline();
      var7 = this.c.getBaseline();
      int var18 = this.d.getBaseline();
      int var15 = Math.max(Math.max(var17, var7), var18);
      var17 = var15 - var17;
      var7 = var15 - var7;
      var15 -= var18;
      int var19 = this.b.getMeasuredHeight();
      int var20 = this.c.getMeasuredHeight();
      var18 = this.d.getMeasuredHeight();
      var18 = Math.max(Math.max(var19 + var17, var20 + var7), var18 + var15);
      switch (this.i & 112) {
         case 16:
            var1 = (var6 - var1 - var16 - var18) / 2;
            var6 = var1 + var17;
            var7 += var1;
            var1 += var15;
            break;
         case 80:
            var1 = var6 - var16 - var18;
            var6 = var1 + var17;
            var7 += var1;
            var1 += var15;
            break;
         default:
            var6 = var1 + var17;
            var7 += var1;
            var1 += var15;
      }

      this.c.layout(var14, var7, var13, this.c.getMeasuredHeight() + var7);
      var7 = Math.min(var12, var14 - this.h - var10);
      this.b.layout(var7, var6, var10 + var7, this.b.getMeasuredHeight() + var6);
      var6 = Math.max(var9 - var11 - var8, this.h + var13);
      this.d.layout(var6, var1, var6 + var8, this.d.getMeasuredHeight() + var1);
      this.e = var2;
      this.k = false;
   }

   void a(int var1, PagerAdapter var2) {
      Object var6 = null;
      int var3;
      if (var2 != null) {
         var3 = var2.b();
      } else {
         var3 = 0;
      }

      this.j = true;
      CharSequence var5;
      if (var1 >= 1 && var2 != null) {
         var5 = var2.c(var1 - 1);
      } else {
         var5 = null;
      }

      this.b.setText(var5);
      TextView var7 = this.c;
      if (var2 != null && var1 < var3) {
         var5 = var2.c(var1);
      } else {
         var5 = null;
      }

      var7.setText(var5);
      var5 = (CharSequence)var6;
      if (var1 + 1 < var3) {
         var5 = (CharSequence)var6;
         if (var2 != null) {
            var5 = var2.c(var1 + 1);
         }
      }

      this.d.setText(var5);
      int var4 = MeasureSpec.makeMeasureSpec(Math.max(0, (int)((this.getWidth() - this.getPaddingLeft() - this.getPaddingRight()) * 0.8F)), Integer.MIN_VALUE);
      var3 = MeasureSpec.makeMeasureSpec(Math.max(0, this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()), Integer.MIN_VALUE);
      this.b.measure(var4, var3);
      this.c.measure(var4, var3);
      this.d.measure(var4, var3);
      this.g = var1;
      if (!this.k) {
         this.a(var1, this.e, false);
      }

      this.j = false;
   }

   void a(PagerAdapter var1, PagerAdapter var2) {
      if (var1 != null) {
         var1.b(this.l);
         this.m = null;
      }

      if (var2 != null) {
         var2.a(this.l);
         this.m = new WeakReference<>(var2);
      }

      if (this.a != null) {
         this.g = -1;
         this.e = -1.0F;
         this.a(this.a.getCurrentItem(), var2);
         this.requestLayout();
      }
   }

   int getMinHeight() {
      int var1 = 0;
      Drawable var2 = this.getBackground();
      if (var2 != null) {
         var1 = var2.getIntrinsicHeight();
      }

      return var1;
   }

   public int getTextSpacing() {
      return this.h;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ViewParent var1 = this.getParent();
      if (!(var1 instanceof ViewPager)) {
         throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
      }

      ViewPager var3 = (ViewPager)var1;
      PagerAdapter var2 = var3.getAdapter();
      var3.c(this.l);
      var3.a(this.l);
      this.a = var3;
      PagerAdapter var4;
      if (this.m != null) {
         var4 = this.m.get();
      } else {
         var4 = null;
      }

      this.a(var4, var2);
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.a != null) {
         this.a(this.a.getAdapter(), null);
         this.a.c(null);
         this.a.b(this.l);
         this.a = null;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      float var6 = 0.0F;
      if (this.a != null) {
         if (this.e >= 0.0F) {
            var6 = this.e;
         }

         this.a(this.g, var6, true);
      }
   }

   protected void onMeasure(int var1, int var2) {
      if (MeasureSpec.getMode(var1) != 1073741824) {
         throw new IllegalStateException("Must measure with an exact width");
      }

      int var4 = this.getPaddingTop() + this.getPaddingBottom();
      int var5 = getChildMeasureSpec(var2, var4, -2);
      int var3 = MeasureSpec.getSize(var1);
      var1 = getChildMeasureSpec(var1, (int)(var3 * 0.2F), -2);
      this.b.measure(var1, var5);
      this.c.measure(var1, var5);
      this.d.measure(var1, var5);
      if (MeasureSpec.getMode(var2) == 1073741824) {
         var1 = MeasureSpec.getSize(var2);
      } else {
         var1 = this.c.getMeasuredHeight();
         var1 = Math.max(this.getMinHeight(), var4 + var1);
      }

      this.setMeasuredDimension(var3, View.resolveSizeAndState(var1, var2, this.c.getMeasuredState() << 16));
   }

   public void requestLayout() {
      if (!this.j) {
         super.requestLayout();
      }
   }

   public void setGravity(int var1) {
      this.i = var1;
      this.requestLayout();
   }

   public void setNonPrimaryAlpha(float var1) {
      this.p = (int)(255.0F * var1) & 0xFF;
      int var2 = this.p << 24 | this.f & 16777215;
      this.b.setTextColor(var2);
      this.d.setTextColor(var2);
   }

   public void setTextColor(int var1) {
      this.f = var1;
      this.c.setTextColor(var1);
      var1 = this.p << 24 | this.f & 16777215;
      this.b.setTextColor(var1);
      this.d.setTextColor(var1);
   }

   public void setTextSpacing(int var1) {
      this.h = var1;
      this.requestLayout();
   }

   private class PageListener extends DataSetObserver implements ViewPager.OnAdapterChangeListener, ViewPager.OnPageChangeListener {
      final PagerTitleStrip a;
      private int b;

      PageListener(PagerTitleStrip var1) {
         this.a = var1;
      }

      @Override
      public void a(int var1) {
         this.b = var1;
      }

      @Override
      public void a(int var1, float var2, int var3) {
         var3 = var1;
         if (var2 > 0.5F) {
            var3 = var1 + 1;
         }

         this.a.a(var3, var2, false);
      }

      @Override
      public void a(ViewPager var1, PagerAdapter var2, PagerAdapter var3) {
         this.a.a(var2, var3);
      }

      @Override
      public void b(int var1) {
         float var2 = 0.0F;
         if (this.b == 0) {
            this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
            if (this.a.e >= 0.0F) {
               var2 = this.a.e;
            }

            this.a.a(this.a.a.getCurrentItem(), var2, true);
         }
      }

      public void onChanged() {
         float var1 = 0.0F;
         this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
         if (this.a.e >= 0.0F) {
            var1 = this.a.e;
         }

         this.a.a(this.a.a.getCurrentItem(), var1, true);
      }
   }

   private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
      private Locale a;

      SingleLineAllCapsTransform(Context var1) {
         this.a = var1.getResources().getConfiguration().locale;
      }

      public CharSequence getTransformation(CharSequence var1, View var2) {
         var1 = super.getTransformation(var1, var2);
         if (var1 != null) {
            var1 = var1.toString().toUpperCase(this.a);
         } else {
            var1 = null;
         }

         return var1;
      }
   }
}
