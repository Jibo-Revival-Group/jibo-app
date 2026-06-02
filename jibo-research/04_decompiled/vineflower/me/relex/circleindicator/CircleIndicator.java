package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class CircleIndicator extends LinearLayout {
   private ViewPager a;
   private int b = -1;
   private int c = -1;
   private int d = -1;
   private int e = R.animator.scale_with_alpha;
   private int f = 0;
   private int g = R.drawable.white_radius;
   private int h = R.drawable.white_radius;
   private Animator i;
   private Animator j;
   private Animator k;
   private Animator l;
   private int m = -1;
   private final ViewPager.OnPageChangeListener n = new ViewPager.OnPageChangeListener(this) {
      final CircleIndicator a;

      {
         this.a = var1;
      }

      @Override
      public void a(int var1) {
      }

      @Override
      public void a(int var1, float var2, int var3) {
      }

      @Override
      public void b(int var1) {
         if (this.a.a.getAdapter() != null && this.a.a.getAdapter().b() > 0) {
            if (this.a.j.isRunning()) {
               this.a.j.end();
               this.a.j.cancel();
            }

            if (this.a.i.isRunning()) {
               this.a.i.end();
               this.a.i.cancel();
            }

            if (this.a.m >= 0) {
               View var2 = this.a.getChildAt(this.a.m);
               if (var2 != null) {
                  var2.setBackgroundResource(this.a.h);
                  this.a.j.setTarget(var2);
                  this.a.j.start();
               }
            }

            View var3 = this.a.getChildAt(var1);
            if (var3 != null) {
               var3.setBackgroundResource(this.a.g);
               this.a.i.setTarget(var3);
               this.a.i.start();
            }

            this.a.m = var1;
         }
      }
   };
   private DataSetObserver o = new DataSetObserver(this) {
      final CircleIndicator a;

      {
         this.a = var1;
      }

      public void onChanged() {
         super.onChanged();
         if (this.a.a != null) {
            int var1 = this.a.a.getAdapter().b();
            if (var1 != this.a.getChildCount()) {
               if (this.a.m < var1) {
                  this.a.m = this.a.a.getCurrentItem();
               } else {
                  this.a.m = -1;
               }

               this.a.a();
            }
         }
      }
   };

   public CircleIndicator(Context var1) {
      super(var1);
      this.a(var1, null);
   }

   public CircleIndicator(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2);
   }

   public CircleIndicator(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2);
   }

   @TargetApi(21)
   public CircleIndicator(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.a(var1, var2);
   }

   private void a() {
      this.removeAllViews();
      int var3 = this.a.getAdapter().b();
      if (var3 > 0) {
         int var2 = this.a.getCurrentItem();
         int var4 = this.getOrientation();

         for (int var1 = 0; var1 < var3; var1++) {
            if (var2 == var1) {
               this.a(var4, this.g, this.k);
            } else {
               this.a(var4, this.h, this.l);
            }
         }
      }
   }

   private void a(int var1, int var2, Animator var3) {
      if (var3.isRunning()) {
         var3.end();
         var3.cancel();
      }

      View var5 = new View(this.getContext());
      var5.setBackgroundResource(var2);
      this.addView(var5, this.c, this.d);
      LayoutParams var4 = (LayoutParams)var5.getLayoutParams();
      if (var1 == 0) {
         var4.leftMargin = this.b;
         var4.rightMargin = this.b;
      } else {
         var4.topMargin = this.b;
         var4.bottomMargin = this.b;
      }

      var5.setLayoutParams(var4);
      var3.setTarget(var5);
      var3.start();
   }

   private void a(Context var1) {
      int var2;
      if (this.c < 0) {
         var2 = this.a(5.0F);
      } else {
         var2 = this.c;
      }

      this.c = var2;
      if (this.d < 0) {
         var2 = this.a(5.0F);
      } else {
         var2 = this.d;
      }

      this.d = var2;
      if (this.b < 0) {
         var2 = this.a(5.0F);
      } else {
         var2 = this.b;
      }

      this.b = var2;
      if (this.e == 0) {
         var2 = R.animator.scale_with_alpha;
      } else {
         var2 = this.e;
      }

      this.e = var2;
      this.i = this.b(var1);
      this.k = this.b(var1);
      this.k.setDuration(0L);
      this.j = this.c(var1);
      this.l = this.c(var1);
      this.l.setDuration(0L);
      if (this.g == 0) {
         var2 = R.drawable.white_radius;
      } else {
         var2 = this.g;
      }

      this.g = var2;
      if (this.h == 0) {
         var2 = this.g;
      } else {
         var2 = this.h;
      }

      this.h = var2;
   }

   private void a(Context var1, AttributeSet var2) {
      this.b(var1, var2);
      this.a(var1);
   }

   private Animator b(Context var1) {
      return AnimatorInflater.loadAnimator(var1, this.e);
   }

   private void b(Context var1, AttributeSet var2) {
      int var3 = 1;
      if (var2 != null) {
         TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.CircleIndicator);
         this.c = var4.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
         this.d = var4.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
         this.b = var4.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, -1);
         this.e = var4.getResourceId(R.styleable.CircleIndicator_ci_animator, R.animator.scale_with_alpha);
         this.f = var4.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
         this.g = var4.getResourceId(R.styleable.CircleIndicator_ci_drawable, R.drawable.white_radius);
         this.h = var4.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected, this.g);
         if (var4.getInt(R.styleable.CircleIndicator_ci_orientation, -1) != 1) {
            var3 = 0;
         }

         this.setOrientation(var3);
         var3 = var4.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
         if (var3 < 0) {
            var3 = 17;
         }

         this.setGravity(var3);
         var4.recycle();
      }
   }

   private Animator c(Context var1) {
      Animator var2;
      if (this.f == 0) {
         var2 = AnimatorInflater.loadAnimator(var1, this.e);
         var2.setInterpolator(new CircleIndicator.ReverseInterpolator(this));
      } else {
         var2 = AnimatorInflater.loadAnimator(var1, this.f);
      }

      return var2;
   }

   public int a(float var1) {
      return (int)(this.getResources().getDisplayMetrics().density * var1 + 0.5F);
   }

   public DataSetObserver getDataSetObserver() {
      return this.o;
   }

   @Deprecated
   public void setOnPageChangeListener(ViewPager.OnPageChangeListener var1) {
      if (this.a == null) {
         throw new NullPointerException("can not find Viewpager , setViewPager first");
      }

      this.a.b(var1);
      this.a.a(var1);
   }

   public void setViewPager(ViewPager var1) {
      this.a = var1;
      if (this.a != null && this.a.getAdapter() != null) {
         this.m = -1;
         this.a();
         this.a.b(this.n);
         this.a.a(this.n);
         this.n.b(this.a.getCurrentItem());
      }
   }

   private class ReverseInterpolator implements Interpolator {
      final CircleIndicator a;

      private ReverseInterpolator(CircleIndicator var1) {
         this.a = var1;
      }

      public float getInterpolation(float var1) {
         return Math.abs(1.0F - var1);
      }
   }
}
