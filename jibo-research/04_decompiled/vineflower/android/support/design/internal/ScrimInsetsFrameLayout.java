package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {
   Drawable a;
   Rect b;
   private Rect c = new Rect();

   public ScrimInsetsFrameLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ScrimInsetsFrameLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      TypedArray var4 = var1.obtainStyledAttributes(var2, R.styleable.ScrimInsetsFrameLayout, var3, R.style.Widget_Design_ScrimInsetsFrameLayout);
      this.a = var4.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
      var4.recycle();
      this.setWillNotDraw(true);
      ViewCompat.a(this, new OnApplyWindowInsetsListener(this) {
         final ScrimInsetsFrameLayout a;

         {
            this.a = var1;
         }

         @Override
         public WindowInsetsCompat a(View var1, WindowInsetsCompat var2x) {
            if (this.a.b == null) {
               this.a.b = new Rect();
            }

            this.a.b.set(var2x.a(), var2x.b(), var2x.c(), var2x.d());
            this.a.a(var2x);
            ScrimInsetsFrameLayout var4x = this.a;
            boolean var3x;
            if (var2x.e() && this.a.a != null) {
               var3x = false;
            } else {
               var3x = true;
            }

            var4x.setWillNotDraw(var3x);
            ViewCompat.c(this.a);
            return var2x.g();
         }
      });
   }

   protected void a(WindowInsetsCompat var1) {
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      if (this.b != null && this.a != null) {
         int var4 = var1.save();
         var1.translate(this.getScrollX(), this.getScrollY());
         this.c.set(0, 0, var2, this.b.top);
         this.a.setBounds(this.c);
         this.a.draw(var1);
         this.c.set(0, var3 - this.b.bottom, var2, var3);
         this.a.setBounds(this.c);
         this.a.draw(var1);
         this.c.set(0, this.b.top, this.b.left, var3 - this.b.bottom);
         this.a.setBounds(this.c);
         this.a.draw(var1);
         this.c.set(var2 - this.b.right, this.b.top, var2, var3 - this.b.bottom);
         this.a.setBounds(this.c);
         this.a.draw(var1);
         var1.restoreToCount(var4);
      }
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.a != null) {
         this.a.setCallback(this);
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if (this.a != null) {
         this.a.setCallback(null);
      }
   }
}
