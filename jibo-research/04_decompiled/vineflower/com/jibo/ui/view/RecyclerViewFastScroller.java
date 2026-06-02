package com.jibo.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecyclerViewFastScroller extends LinearLayout {
   private TextView a;
   private View b;
   private RecyclerView c;
   private int d;
   private boolean e = false;
   private ObjectAnimator f = null;
   private final RecyclerView.OnScrollListener g = new RecyclerView.OnScrollListener(this) {
      final RecyclerViewFastScroller a;

      {
         this.a = var1;
      }

      @Override
      public void a(RecyclerView var1, int var2, int var3) {
         this.a.a();
      }
   };

   public RecyclerViewFastScroller(Context var1) {
      super(var1);
      this.a(var1);
   }

   public RecyclerViewFastScroller(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1);
   }

   public RecyclerViewFastScroller(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1);
   }

   private void a() {
      if (this.a != null && !this.b.isSelected()) {
         int var1 = this.c.computeVerticalScrollOffset();
         int var2 = this.c.computeVerticalScrollRange();
         this.setBubbleAndHandlePosition(var1 / ((float)var2 - this.d) * this.d);
      }
   }

   private int b(int var1, int var2, int var3) {
      return Math.min(Math.max(var1, var3), var2);
   }

   private void b() {
      if (this.a != null) {
         this.a.setVisibility(0);
         if (this.f != null) {
            this.f.cancel();
         }

         this.f = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{0.0F, 1.0F}).setDuration(100L);
         this.f.start();
      }
   }

   private void c() {
      if (this.a != null) {
         if (this.f != null) {
            this.f.cancel();
         }

         this.f = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0F, 0.0F}).setDuration(100L);
         this.f.addListener(new AnimatorListenerAdapter(this) {
            final RecyclerViewFastScroller a;

            {
               this.a = var1;
            }

            public void onAnimationCancel(Animator var1) {
               super.onAnimationCancel(var1);
               this.a.a.setVisibility(4);
               this.a.f = null;
            }

            public void onAnimationEnd(Animator var1) {
               super.onAnimationEnd(var1);
               this.a.a.setVisibility(4);
               this.a.f = null;
            }
         });
         this.f.start();
      }
   }

   private void setBubbleAndHandlePosition(float var1) {
      int var3 = this.b.getHeight();
      this.b.setY(this.b(0, this.d - var3, (int)(var1 - var3 / 2)));
      if (this.a != null) {
         int var2 = this.a.getHeight();
         this.a.setY(this.b(0, this.d - var2 - var3 / 2, (int)(var1 - var2)));
      }
   }

   private void setRecyclerViewPosition(float var1) {
      float var2 = 0.0F;
      if (this.c != null) {
         int var3 = this.c.getAdapter().getItemCount();
         if (this.b.getY() == 0.0F) {
            var1 = var2;
         } else if (this.b.getY() + this.b.getHeight() >= this.d - 5) {
            var1 = 1.0F;
         } else {
            var1 /= this.d;
         }

         var3 = this.b(0, var3 - 1, (int)(var1 * var3));
         ((LinearLayoutManager)this.c.getLayoutManager()).b(var3, 0);
         String var4 = ((RecyclerViewFastScroller.BubbleTextGetter)this.c.getAdapter()).c(var3);
         if (this.a != null && !TextUtils.isEmpty(var4)) {
            this.a.setText(var4);
            this.a.setVisibility(0);
         } else {
            this.a.setVisibility(8);
         }
      }
   }

   public void a(int var1, int var2, int var3) {
      LayoutInflater.from(this.getContext()).inflate(var1, this, true);
      this.a = (TextView)this.findViewById(var2);
      if (this.a != null) {
         this.a.setVisibility(4);
      }

      this.b = this.findViewById(var3);
   }

   protected void a(Context var1) {
      if (!this.e) {
         this.e = true;
         this.setOrientation(0);
         this.setClipChildren(false);
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.c != null) {
         this.c.removeOnScrollListener(this.g);
         this.c = null;
      }
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.d = var2;
      this.a();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var3 = false;
      switch (var1.getAction()) {
         case 0:
            if (var1.getX() < this.b.getX() - ViewCompat.g(this.b)) {
               break;
            }

            if (this.f != null) {
               this.f.cancel();
            }

            if (this.a != null && this.a.getVisibility() == 4) {
               this.b();
            }

            this.b.setSelected(true);
         case 2:
            float var2 = var1.getY();
            this.setBubbleAndHandlePosition(var2);
            this.setRecyclerViewPosition(var2);
            var3 = true;
            break;
         case 1:
         case 3:
            this.b.setSelected(false);
            this.c();
            var3 = true;
            break;
         default:
            var3 = super.onTouchEvent(var1);
      }

      return var3;
   }

   public void setRecyclerView(RecyclerView var1) {
      if (this.c != var1) {
         if (this.c != null) {
            this.c.removeOnScrollListener(this.g);
         }

         this.c = var1;
         if (this.c != null) {
            var1.addOnScrollListener(this.g);
         }
      }
   }

   public interface BubbleTextGetter {
      String c(int var1);
   }
}
