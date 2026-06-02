package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnClickListener;

public class PagerTabStrip extends PagerTitleStrip {
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private final Paint m = new Paint();
   private final Rect n = new Rect();
   private int o = 255;
   private boolean p = false;
   private boolean q = false;
   private int r;
   private boolean s;
   private float t;
   private float u;
   private int v;

   public PagerTabStrip(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.g = this.f;
      this.m.setColor(this.g);
      float var3 = var1.getResources().getDisplayMetrics().density;
      this.h = (int)(3.0F * var3 + 0.5F);
      this.i = (int)(6.0F * var3 + 0.5F);
      this.j = (int)(64.0F * var3);
      this.l = (int)(16.0F * var3 + 0.5F);
      this.r = (int)(1.0F * var3 + 0.5F);
      this.k = (int)(var3 * 32.0F + 0.5F);
      this.v = ViewConfiguration.get(var1).getScaledTouchSlop();
      this.setPadding(this.getPaddingLeft(), this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
      this.setTextSpacing(this.getTextSpacing());
      this.setWillNotDraw(false);
      this.b.setFocusable(true);
      this.b.setOnClickListener(new OnClickListener(this) {
         final PagerTabStrip a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.a.setCurrentItem(this.a.a.getCurrentItem() - 1);
         }
      });
      this.d.setFocusable(true);
      this.d.setOnClickListener(new OnClickListener(this) {
         final PagerTabStrip a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            this.a.a.setCurrentItem(this.a.a.getCurrentItem() + 1);
         }
      });
      if (this.getBackground() == null) {
         this.p = true;
      }
   }

   @Override
   void a(int var1, float var2, boolean var3) {
      Rect var10 = this.n;
      int var9 = this.getHeight();
      int var5 = this.c.getLeft();
      int var8 = this.l;
      int var7 = this.c.getRight();
      int var6 = this.l;
      int var4 = var9 - this.h;
      var10.set(var5 - var8, var4, var7 + var6, var9);
      super.a(var1, var2, var3);
      this.o = (int)(Math.abs(var2 - 0.5F) * 2.0F * 255.0F);
      var10.union(this.c.getLeft() - this.l, var4, this.c.getRight() + this.l, var9);
      this.invalidate(var10);
   }

   public boolean getDrawFullUnderline() {
      return this.p;
   }

   @Override
   int getMinHeight() {
      return Math.max(super.getMinHeight(), this.k);
   }

   public int getTabIndicatorColor() {
      return this.g;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      int var5 = this.getHeight();
      int var3 = this.c.getLeft();
      int var6 = this.l;
      int var2 = this.c.getRight();
      int var7 = this.l;
      int var4 = this.h;
      this.m.setColor(this.o << 24 | this.g & 16777215);
      var1.drawRect(var3 - var6, var5 - var4, var2 + var7, var5, this.m);
      if (this.p) {
         this.m.setColor(0xFF000000 | this.g & 16777215);
         var1.drawRect(this.getPaddingLeft(), var5 - this.r, this.getWidth() - this.getPaddingRight(), var5, this.m);
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var5 = false;
      int var4 = var1.getAction();
      if (var4 == 0 || !this.s) {
         float var2 = var1.getX();
         float var3 = var1.getY();
         switch (var4) {
            case 0:
               this.t = var2;
               this.u = var3;
               this.s = false;
               break;
            case 1:
               if (var2 < this.c.getLeft() - this.l) {
                  this.a.setCurrentItem(this.a.getCurrentItem() - 1);
               } else if (var2 > this.c.getRight() + this.l) {
                  this.a.setCurrentItem(this.a.getCurrentItem() + 1);
               }
               break;
            case 2:
               if (Math.abs(var2 - this.t) > this.v || Math.abs(var3 - this.u) > this.v) {
                  this.s = true;
               }
         }

         var5 = true;
      }

      return var5;
   }

   public void setBackgroundColor(int var1) {
      super.setBackgroundColor(var1);
      if (!this.q) {
         boolean var2;
         if ((0xFF000000 & var1) == 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.p = var2;
      }
   }

   public void setBackgroundDrawable(Drawable var1) {
      super.setBackgroundDrawable(var1);
      if (!this.q) {
         boolean var2;
         if (var1 == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.p = var2;
      }
   }

   public void setBackgroundResource(int var1) {
      super.setBackgroundResource(var1);
      if (!this.q) {
         boolean var2;
         if (var1 == 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.p = var2;
      }
   }

   public void setDrawFullUnderline(boolean var1) {
      this.p = var1;
      this.q = true;
      this.invalidate();
   }

   public void setPadding(int var1, int var2, int var3, int var4) {
      int var5 = var4;
      if (var4 < this.i) {
         var5 = this.i;
      }

      super.setPadding(var1, var2, var3, var5);
   }

   public void setTabIndicatorColor(int var1) {
      this.g = var1;
      this.m.setColor(this.g);
      this.invalidate();
   }

   public void setTabIndicatorColorResource(int var1) {
      this.setTabIndicatorColor(ContextCompat.c(this.getContext(), var1));
   }

   @Override
   public void setTextSpacing(int var1) {
      int var2 = var1;
      if (var1 < this.j) {
         var2 = this.j;
      }

      super.setTextSpacing(var2);
   }
}
