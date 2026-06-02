package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ScrollingTabContainerView extends HorizontalScrollView implements OnItemSelectedListener {
   private static final Interpolator l = new DecelerateInterpolator();
   Runnable a;
   LinearLayoutCompat b;
   int c;
   int d;
   protected ViewPropertyAnimator e;
   protected final ScrollingTabContainerView.VisibilityAnimListener f = new ScrollingTabContainerView.VisibilityAnimListener(this);
   private ScrollingTabContainerView.TabClickListener g;
   private Spinner h;
   private boolean i;
   private int j;
   private int k;

   public ScrollingTabContainerView(Context var1) {
      super(var1);
      this.setHorizontalScrollBarEnabled(false);
      ActionBarPolicy var2 = ActionBarPolicy.a(var1);
      this.setContentHeight(var2.e());
      this.d = var2.g();
      this.b = this.e();
      this.addView(this.b, new LayoutParams(-2, -1));
   }

   private boolean b() {
      boolean var1;
      if (this.h != null && this.h.getParent() == this) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void c() {
      if (!this.b()) {
         if (this.h == null) {
            this.h = this.f();
         }

         this.removeView(this.b);
         this.addView(this.h, new LayoutParams(-2, -1));
         if (this.h.getAdapter() == null) {
            this.h.setAdapter(new ScrollingTabContainerView.TabAdapter(this));
         }

         if (this.a != null) {
            this.removeCallbacks(this.a);
            this.a = null;
         }

         this.h.setSelection(this.k);
      }
   }

   private boolean d() {
      if (this.b()) {
         this.removeView(this.h);
         this.addView(this.b, new LayoutParams(-2, -1));
         this.setTabSelected(this.h.getSelectedItemPosition());
      }

      return false;
   }

   private LinearLayoutCompat e() {
      LinearLayoutCompat var1 = new LinearLayoutCompat(this.getContext(), null, R.attr.actionBarTabBarStyle);
      var1.setMeasureWithLargestChildEnabled(true);
      var1.setGravity(17);
      var1.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
      return var1;
   }

   private Spinner f() {
      AppCompatSpinner var1 = new AppCompatSpinner(this.getContext(), null, R.attr.actionDropDownStyle);
      var1.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
      var1.setOnItemSelectedListener(this);
      return var1;
   }

   ScrollingTabContainerView.TabView a(ActionBar.Tab var1, boolean var2) {
      ScrollingTabContainerView.TabView var3 = new ScrollingTabContainerView.TabView(this, this.getContext(), var1, var2);
      if (var2) {
         var3.setBackgroundDrawable(null);
         var3.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, this.j));
      } else {
         var3.setFocusable(true);
         if (this.g == null) {
            this.g = new ScrollingTabContainerView.TabClickListener(this);
         }

         var3.setOnClickListener(this.g);
      }

      return var3;
   }

   public void a() {
      this.b.removeAllViews();
      if (this.h != null) {
         ((ScrollingTabContainerView.TabAdapter)this.h.getAdapter()).notifyDataSetChanged();
      }

      if (this.i) {
         this.requestLayout();
      }
   }

   public void a(int var1) {
      View var2 = this.b.getChildAt(var1);
      if (this.a != null) {
         this.removeCallbacks(this.a);
      }

      this.a = new Runnable(this, var2) {
         final View a;
         final ScrollingTabContainerView b;

         {
            this.b = var1;
            this.a = var2x;
         }

         @Override
         public void run() {
            int var1x = this.a.getLeft();
            int var2x = (this.b.getWidth() - this.a.getWidth()) / 2;
            this.b.smoothScrollTo(var1x - var2x, 0);
            this.b.a = null;
         }
      };
      this.post(this.a);
   }

   public void a(ActionBar.Tab var1, int var2, boolean var3) {
      ScrollingTabContainerView.TabView var4 = this.a(var1, false);
      this.b.addView(var4, var2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
      if (this.h != null) {
         ((ScrollingTabContainerView.TabAdapter)this.h.getAdapter()).notifyDataSetChanged();
      }

      if (var3) {
         var4.setSelected(true);
      }

      if (this.i) {
         this.requestLayout();
      }
   }

   public void b(int var1) {
      this.b.removeViewAt(var1);
      if (this.h != null) {
         ((ScrollingTabContainerView.TabAdapter)this.h.getAdapter()).notifyDataSetChanged();
      }

      if (this.i) {
         this.requestLayout();
      }
   }

   public void b(ActionBar.Tab var1, boolean var2) {
      ScrollingTabContainerView.TabView var3 = this.a(var1, false);
      this.b.addView(var3, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
      if (this.h != null) {
         ((ScrollingTabContainerView.TabAdapter)this.h.getAdapter()).notifyDataSetChanged();
      }

      if (var2) {
         var3.setSelected(true);
      }

      if (this.i) {
         this.requestLayout();
      }
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.a != null) {
         this.post(this.a);
      }
   }

   protected void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      ActionBarPolicy var2 = ActionBarPolicy.a(this.getContext());
      this.setContentHeight(var2.e());
      this.d = var2.g();
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.a != null) {
         this.removeCallbacks(this.a);
      }
   }

   public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
      ((ScrollingTabContainerView.TabView)var2).b().e();
   }

   public void onMeasure(int var1, int var2) {
      int var7 = 1;
      int var4 = MeasureSpec.getMode(var1);
      boolean var5;
      if (var4 == 1073741824) {
         var5 = true;
      } else {
         var5 = false;
      }

      this.setFillViewport(var5);
      int var3 = this.b.getChildCount();
      if (var3 > 1 && (var4 == 1073741824 || var4 == Integer.MIN_VALUE)) {
         if (var3 > 2) {
            this.c = (int)(MeasureSpec.getSize(var1) * 0.4F);
         } else {
            this.c = MeasureSpec.getSize(var1) / 2;
         }

         this.c = Math.min(this.c, this.d);
      } else {
         this.c = -1;
      }

      var3 = MeasureSpec.makeMeasureSpec(this.j, 1073741824);
      if (var5 || !this.i) {
         var7 = 0;
      }

      if (var7) {
         this.b.measure(0, var3);
         if (this.b.getMeasuredWidth() > MeasureSpec.getSize(var1)) {
            this.c();
         } else {
            this.d();
         }
      } else {
         this.d();
      }

      var7 = this.getMeasuredWidth();
      super.onMeasure(var1, var3);
      var1 = this.getMeasuredWidth();
      if (var5 && var7 != var1) {
         this.setTabSelected(this.k);
      }
   }

   public void onNothingSelected(AdapterView<?> var1) {
   }

   public void setAllowCollapse(boolean var1) {
      this.i = var1;
   }

   public void setContentHeight(int var1) {
      this.j = var1;
      this.requestLayout();
   }

   public void setTabSelected(int var1) {
      this.k = var1;
      int var3 = this.b.getChildCount();

      for (int var2 = 0; var2 < var3; var2++) {
         View var5 = this.b.getChildAt(var2);
         boolean var4;
         if (var2 == var1) {
            var4 = true;
         } else {
            var4 = false;
         }

         var5.setSelected(var4);
         if (var4) {
            this.a(var1);
         }
      }

      if (this.h != null && var1 >= 0) {
         this.h.setSelection(var1);
      }
   }

   private class TabAdapter extends BaseAdapter {
      final ScrollingTabContainerView a;

      TabAdapter(ScrollingTabContainerView var1) {
         this.a = var1;
      }

      public int getCount() {
         return this.a.b.getChildCount();
      }

      public Object getItem(int var1) {
         return ((ScrollingTabContainerView.TabView)this.a.b.getChildAt(var1)).b();
      }

      public long getItemId(int var1) {
         return var1;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         if (var2 == null) {
            var2 = this.a.a((ActionBar.Tab)this.getItem(var1), true);
         } else {
            ((ScrollingTabContainerView.TabView)var2).a((ActionBar.Tab)this.getItem(var1));
         }

         return (View)var2;
      }
   }

   private class TabClickListener implements OnClickListener {
      final ScrollingTabContainerView a;

      TabClickListener(ScrollingTabContainerView var1) {
         this.a = var1;
      }

      public void onClick(View var1) {
         ((ScrollingTabContainerView.TabView)var1).b().e();
         int var3 = this.a.b.getChildCount();

         for (int var2 = 0; var2 < var3; var2++) {
            View var5 = this.a.b.getChildAt(var2);
            boolean var4;
            if (var5 == var1) {
               var4 = true;
            } else {
               var4 = false;
            }

            var5.setSelected(var4);
         }
      }
   }

   private class TabView extends LinearLayout {
      final ScrollingTabContainerView a;
      private final int[] b;
      private ActionBar.Tab c;
      private TextView d;
      private ImageView e;
      private View f;

      public TabView(ScrollingTabContainerView var1, Context var2, ActionBar.Tab var3, boolean var4) {
         super(var2, null, R.attr.actionBarTabStyle);
         this.a = var1;
         this.b = new int[]{16842964};
         this.c = var3;
         TintTypedArray var5 = TintTypedArray.a(var2, null, this.b, R.attr.actionBarTabStyle, 0);
         if (var5.g(0)) {
            this.setBackgroundDrawable(var5.a(0));
         }

         var5.a();
         if (var4) {
            this.setGravity(8388627);
         }

         this.a();
      }

      public void a() {
         ActionBar.Tab var2 = this.c;
         View var3 = var2.d();
         if (var3 != null) {
            ViewParent var7 = var3.getParent();
            if (var7 != this) {
               if (var7 != null) {
                  ((ViewGroup)var7).removeView(var3);
               }

               this.addView(var3);
            }

            this.f = var3;
            if (this.d != null) {
               this.d.setVisibility(8);
            }

            if (this.e != null) {
               this.e.setVisibility(8);
               this.e.setImageDrawable(null);
            }
         } else {
            if (this.f != null) {
               this.removeView(this.f);
               this.f = null;
            }

            Drawable var5 = var2.b();
            CharSequence var9 = var2.c();
            if (var5 != null) {
               if (this.e == null) {
                  AppCompatImageView var6 = new AppCompatImageView(this.getContext());
                  android.widget.LinearLayout.LayoutParams var4 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                  var4.gravity = 16;
                  var6.setLayoutParams(var4);
                  this.addView(var6, 0);
                  this.e = var6;
               }

               this.e.setImageDrawable(var5);
               this.e.setVisibility(0);
            } else if (this.e != null) {
               this.e.setVisibility(8);
               this.e.setImageDrawable(null);
            }

            boolean var1;
            if (!TextUtils.isEmpty(var9)) {
               var1 = true;
            } else {
               var1 = false;
            }

            if (var1) {
               if (this.d == null) {
                  AppCompatTextView var10 = new AppCompatTextView(this.getContext(), null, R.attr.actionBarTabTextStyle);
                  var10.setEllipsize(TruncateAt.END);
                  android.widget.LinearLayout.LayoutParams var11 = new android.widget.LinearLayout.LayoutParams(-2, -2);
                  var11.gravity = 16;
                  var10.setLayoutParams(var11);
                  this.addView(var10);
                  this.d = var10;
               }

               this.d.setText(var9);
               this.d.setVisibility(0);
            } else if (this.d != null) {
               this.d.setVisibility(8);
               this.d.setText(null);
            }

            if (this.e != null) {
               this.e.setContentDescription(var2.f());
            }

            CharSequence var8;
            if (var1) {
               var8 = null;
            } else {
               var8 = var2.f();
            }

            TooltipCompat.a(this, var8);
         }
      }

      public void a(ActionBar.Tab var1) {
         this.c = var1;
         this.a();
      }

      public ActionBar.Tab b() {
         return this.c;
      }

      public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
         super.onInitializeAccessibilityEvent(var1);
         var1.setClassName(ActionBar.Tab.class.getName());
      }

      public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
         super.onInitializeAccessibilityNodeInfo(var1);
         var1.setClassName(ActionBar.Tab.class.getName());
      }

      public void onMeasure(int var1, int var2) {
         super.onMeasure(var1, var2);
         if (this.a.c > 0 && this.getMeasuredWidth() > this.a.c) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.a.c, 1073741824), var2);
         }
      }

      public void setSelected(boolean var1) {
         boolean var2;
         if (this.isSelected() != var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         super.setSelected(var1);
         if (var2 && var1) {
            this.sendAccessibilityEvent(4);
         }
      }
   }

   protected class VisibilityAnimListener extends AnimatorListenerAdapter {
      final ScrollingTabContainerView a;
      private boolean b;
      private int c;

      protected VisibilityAnimListener(ScrollingTabContainerView var1) {
         this.a = var1;
         this.b = false;
      }

      public void onAnimationCancel(Animator var1) {
         this.b = true;
      }

      public void onAnimationEnd(Animator var1) {
         if (!this.b) {
            this.a.e = null;
            this.a.setVisibility(this.c);
         }
      }

      public void onAnimationStart(Animator var1) {
         this.a.setVisibility(0);
         this.b = false;
      }
   }
}
