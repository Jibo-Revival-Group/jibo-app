package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14 implements ViewOverlayImpl {
   protected ViewOverlayApi14.OverlayViewGroup a;

   ViewOverlayApi14(Context var1, ViewGroup var2, View var3) {
      this.a = new ViewOverlayApi14.OverlayViewGroup(var1, var2, var3, this);
   }

   static ViewGroup c(View var0) {
      while (true) {
         if (var0 == null) {
            var1 = null;
            break;
         }

         if (var0.getId() == 16908290 && var0 instanceof ViewGroup) {
            var1 = (ViewGroup)var0;
            break;
         }

         if (var0.getParent() instanceof ViewGroup) {
            var0 = (ViewGroup)var0.getParent();
         }
      }

      return var1;
   }

   static ViewOverlayApi14 d(View var0) {
      ViewGroup var3 = c(var0);
      ViewOverlayApi14 var5;
      if (var3 != null) {
         int var2 = var3.getChildCount();
         int var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var5 = new ViewGroupOverlayApi14(var3.getContext(), var3, var0);
               break;
            }

            View var4 = var3.getChildAt(var1);
            if (var4 instanceof ViewOverlayApi14.OverlayViewGroup) {
               var5 = ((ViewOverlayApi14.OverlayViewGroup)var4).e;
               break;
            }

            var1++;
         }
      } else {
         var5 = null;
      }

      return var5;
   }

   @Override
   public void a(Drawable var1) {
      this.a.a(var1);
   }

   @Override
   public void b(Drawable var1) {
      this.a.b(var1);
   }

   static class OverlayViewGroup extends ViewGroup {
      static Method a;
      ViewGroup b;
      View c;
      ArrayList<Drawable> d = null;
      ViewOverlayApi14 e;

      static {
         try {
            a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", int.class, int.class, Rect.class);
         } catch (NoSuchMethodException var1) {
         }
      }

      OverlayViewGroup(Context var1, ViewGroup var2, View var3, ViewOverlayApi14 var4) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.setRight(var2.getWidth());
         this.setBottom(var2.getHeight());
         var2.addView(this);
         this.e = var4;
      }

      private void a(int[] var1) {
         int[] var3 = new int[2];
         int[] var2 = new int[2];
         this.b.getLocationOnScreen(var3);
         this.c.getLocationOnScreen(var2);
         var1[0] = var2[0] - var3[0];
         var1[1] = var2[1] - var3[1];
      }

      public void a(Drawable var1) {
         if (this.d == null) {
            this.d = new ArrayList<>();
         }

         if (!this.d.contains(var1)) {
            this.d.add(var1);
            this.invalidate(var1.getBounds());
            var1.setCallback(this);
         }
      }

      public void a(View var1) {
         if (var1.getParent() instanceof ViewGroup) {
            ViewGroup var3 = (ViewGroup)var1.getParent();
            if (var3 != this.b && var3.getParent() != null && ViewCompat.B(var3)) {
               int[] var2 = new int[2];
               int[] var4 = new int[2];
               var3.getLocationOnScreen(var2);
               this.b.getLocationOnScreen(var4);
               ViewCompat.d(var1, var2[0] - var4[0]);
               ViewCompat.c(var1, var2[1] - var4[1]);
            }

            var3.removeView(var1);
            if (var1.getParent() != null) {
               var3.removeView(var1);
            }
         }

         super.addView(var1, this.getChildCount() - 1);
      }

      boolean a() {
         boolean var1;
         if (this.getChildCount() != 0 || this.d != null && this.d.size() != 0) {
            var1 = false;
         } else {
            var1 = true;
         }

         return var1;
      }

      public void b(Drawable var1) {
         if (this.d != null) {
            this.d.remove(var1);
            this.invalidate(var1.getBounds());
            var1.setCallback(null);
         }
      }

      public void b(View var1) {
         super.removeView(var1);
         if (this.a()) {
            this.b.removeView(this);
         }
      }

      protected void dispatchDraw(Canvas var1) {
         int[] var5 = new int[2];
         int[] var4 = new int[2];
         this.b.getLocationOnScreen(var5);
         this.c.getLocationOnScreen(var4);
         var1.translate(var4[0] - var5[0], var4[1] - var5[1]);
         var1.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
         super.dispatchDraw(var1);
         int var2;
         if (this.d == null) {
            var2 = 0;
         } else {
            var2 = this.d.size();
         }

         for (int var3 = 0; var3 < var2; var3++) {
            this.d.get(var3).draw(var1);
         }
      }

      public boolean dispatchTouchEvent(MotionEvent var1) {
         return false;
      }

      public ViewParent invalidateChildInParent(int[] var1, Rect var2) {
         if (this.b != null) {
            var2.offset(var1[0], var1[1]);
            if (this.b instanceof ViewGroup) {
               var1[0] = 0;
               var1[1] = 0;
               int[] var3 = new int[2];
               this.a(var3);
               var2.offset(var3[0], var3[1]);
               return super.invalidateChildInParent(var1, var2);
            }

            this.invalidate(var2);
         }

         return null;
      }

      public void invalidateDrawable(Drawable var1) {
         this.invalidate(var1.getBounds());
      }

      protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      }

      protected boolean verifyDrawable(Drawable var1) {
         boolean var2;
         if (!super.verifyDrawable(var1) && (this.d == null || !this.d.contains(var1))) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }
   }
}
