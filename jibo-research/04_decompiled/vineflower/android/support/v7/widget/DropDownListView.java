package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

class DropDownListView extends ListView {
   private final Rect a = new Rect();
   private int b = 0;
   private int c = 0;
   private int d = 0;
   private int e = 0;
   private int f;
   private Field g;
   private DropDownListView.GateKeeperDrawable h;
   private boolean i;
   private boolean j;
   private boolean k;
   private ViewPropertyAnimatorCompat l;
   private ListViewAutoScrollHelper m;
   private DropDownListView.ResolveHoverRunnable n;

   DropDownListView(Context var1, boolean var2) {
      super(var1, null, R.attr.dropDownListViewStyle);
      this.j = var2;
      this.setCacheColorHint(0);

      try {
         this.g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
         this.g.setAccessible(true);
      } catch (NoSuchFieldException var3) {
         var3.printStackTrace();
      }
   }

   private void a() {
      Drawable var1 = this.getSelector();
      if (var1 != null && this.c() && this.isPressed()) {
         var1.setState(this.getDrawableState());
      }
   }

   private void a(int var1, View var2) {
      boolean var6 = true;
      Drawable var7 = this.getSelector();
      boolean var5;
      if (var7 != null && var1 != -1) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var5) {
         var7.setVisible(false, false);
      }

      this.b(var1, var2);
      if (var5) {
         Rect var8 = this.a;
         float var3 = var8.exactCenterX();
         float var4 = var8.exactCenterY();
         if (this.getVisibility() != 0) {
            var6 = false;
         }

         var7.setVisible(var6, false);
         DrawableCompat.a(var7, var3, var4);
      }
   }

   private void a(int var1, View var2, float var3, float var4) {
      this.a(var1, var2);
      Drawable var5 = this.getSelector();
      if (var5 != null && var1 != -1) {
         DrawableCompat.a(var5, var3, var4);
      }
   }

   private void a(Canvas var1) {
      if (!this.a.isEmpty()) {
         Drawable var2 = this.getSelector();
         if (var2 != null) {
            var2.setBounds(this.a);
            var2.draw(var1);
         }
      }
   }

   private void a(View var1, int var2) {
      this.performItemClick(var1, var2, this.getItemIdAtPosition(var2));
   }

   private void a(View var1, int var2, float var3, float var4) {
      this.k = true;
      if (VERSION.SDK_INT >= 21) {
         this.drawableHotspotChanged(var3, var4);
      }

      if (!this.isPressed()) {
         this.setPressed(true);
      }

      this.layoutChildren();
      if (this.f != -1) {
         View var7 = this.getChildAt(this.f - this.getFirstVisiblePosition());
         if (var7 != null && var7 != var1 && var7.isPressed()) {
            var7.setPressed(false);
         }
      }

      this.f = var2;
      float var5 = var1.getLeft();
      float var6 = var1.getTop();
      if (VERSION.SDK_INT >= 21) {
         var1.drawableHotspotChanged(var3 - var5, var4 - var6);
      }

      if (!var1.isPressed()) {
         var1.setPressed(true);
      }

      this.a(var2, var1, var3, var4);
      this.setSelectorEnabled(false);
      this.refreshDrawableState();
   }

   private void b() {
      this.k = false;
      this.setPressed(false);
      this.drawableStateChanged();
      View var1 = this.getChildAt(this.f - this.getFirstVisiblePosition());
      if (var1 != null) {
         var1.setPressed(false);
      }

      if (this.l != null) {
         this.l.b();
         this.l = null;
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void b(int var1, View var2) {
      Rect var4 = this.a;
      var4.set(var2.getLeft(), var2.getTop(), var2.getRight(), var2.getBottom());
      var4.left = var4.left - this.b;
      var4.top = var4.top - this.c;
      var4.right = var4.right + this.d;
      var4.bottom = var4.bottom + this.e;

      boolean var3;
      try {
         var3 = this.g.getBoolean(this);
         if (var2.isEnabled() == var3) {
            return;
         }

         var8 = this.g;
      } catch (IllegalAccessException var7) {
         var7.printStackTrace();
         return;
      }

      if (!var3) {
         var3 = true;
      } else {
         var3 = false;
      }

      try {
         var8.set(this, var3);
      } catch (IllegalAccessException var6) {
         var6.printStackTrace();
         return;
      }

      if (var1 != -1) {
         try {
            this.refreshDrawableState();
         } catch (IllegalAccessException var5) {
            var5.printStackTrace();
         }
      }
   }

   private boolean c() {
      return this.k;
   }

   private void setSelectorEnabled(boolean var1) {
      if (this.h != null) {
         this.h.a(var1);
      }
   }

   public int a(int var1, int var2, int var3, int var4, int var5) {
      var3 = this.getListPaddingTop();
      var2 = this.getListPaddingBottom();
      this.getListPaddingLeft();
      this.getListPaddingRight();
      int var6 = this.getDividerHeight();
      Drawable var11 = this.getDivider();
      ListAdapter var14 = this.getAdapter();
      if (var14 == null) {
         var1 = var3 + var2;
      } else {
         var2 += var3;
         if (var6 <= 0 || var11 == null) {
            var6 = 0;
         }

         var3 = 0;
         View var22 = null;
         int var8 = 0;
         int var10 = var14.getCount();
         int var7 = 0;

         while (var7 < var10) {
            int var9 = var14.getItemViewType(var7);
            if (var9 != var8) {
               var22 = null;
               var8 = var9;
            }

            View var12 = var14.getView(var7, var22, this);
            LayoutParams var13 = var12.getLayoutParams();
            LayoutParams var23 = var13;
            if (var13 == null) {
               var23 = this.generateDefaultLayoutParams();
               var12.setLayoutParams(var23);
            }

            if (var23.height > 0) {
               var9 = MeasureSpec.makeMeasureSpec(var23.height, 1073741824);
            } else {
               var9 = MeasureSpec.makeMeasureSpec(0, 0);
            }

            var12.measure(var1, var9);
            var12.forceLayout();
            if (var7 > 0) {
               var2 += var6;
            }

            var2 += var12.getMeasuredHeight();
            if (var2 >= var4) {
               var1 = var4;
               if (var5 >= 0) {
                  var1 = var4;
                  if (var7 > var5) {
                     var1 = var4;
                     if (var3 > 0) {
                        var1 = var4;
                        if (var2 != var4) {
                           var1 = var3;
                           return var1;
                        }
                     }

                     return var1;
                  }
               }

               return var1;
            }

            var9 = var3;
            if (var5 >= 0) {
               var9 = var3;
               if (var7 >= var5) {
                  var9 = var2;
               }
            }

            var7++;
            var3 = var9;
            var22 = var12;
         }

         var1 = var2;
      }

      return var1;
   }

   public boolean a(MotionEvent var1, int var2) {
      boolean var6;
      label45: {
         label48: {
            int var3 = var1.getActionMasked();
            switch (var3) {
               case 1:
                  var6 = false;
                  break;
               case 2:
                  var6 = true;
                  break;
               case 3:
                  var8 = false;
                  var6 = false;
                  break label45;
               default:
                  break label48;
            }

            int var4 = var1.findPointerIndex(var2);
            if (var4 < 0) {
               var8 = false;
               var6 = false;
               break label45;
            }

            var2 = (int)var1.getX(var4);
            int var5 = (int)var1.getY(var4);
            var4 = this.pointToPosition(var2, var5);
            if (var4 == -1) {
               var8 = true;
               break label45;
            }

            View var7 = this.getChildAt(var4 - this.getFirstVisiblePosition());
            this.a(var7, var4, var2, var5);
            if (var3 == 1) {
               this.a(var7, var4);
            }
         }

         var8 = false;
         var6 = true;
      }

      if (!var6 || var8) {
         this.b();
      }

      if (var6) {
         if (this.m == null) {
            this.m = new ListViewAutoScrollHelper(this);
         }

         this.m.a(true);
         this.m.onTouch(this, var1);
      } else if (this.m != null) {
         this.m.a(false);
      }

      return var6;
   }

   protected void dispatchDraw(Canvas var1) {
      this.a(var1);
      super.dispatchDraw(var1);
   }

   protected void drawableStateChanged() {
      if (this.n == null) {
         super.drawableStateChanged();
         this.setSelectorEnabled(true);
         this.a();
      }
   }

   public boolean hasFocus() {
      boolean var1;
      if (!this.j && !super.hasFocus()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean hasWindowFocus() {
      boolean var1;
      if (!this.j && !super.hasWindowFocus()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean isFocused() {
      boolean var1;
      if (!this.j && !super.isFocused()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean isInTouchMode() {
      boolean var1;
      if ((!this.j || !this.i) && !super.isInTouchMode()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   protected void onDetachedFromWindow() {
      this.n = null;
      super.onDetachedFromWindow();
   }

   public boolean onHoverEvent(MotionEvent var1) {
      boolean var3;
      if (VERSION.SDK_INT < 26) {
         var3 = super.onHoverEvent(var1);
      } else {
         int var2 = var1.getActionMasked();
         if (var2 == 10 && this.n == null) {
            this.n = new DropDownListView.ResolveHoverRunnable(this);
            this.n.b();
         }

         boolean var4 = super.onHoverEvent(var1);
         if (var2 != 9 && var2 != 7) {
            this.setSelection(-1);
            var3 = var4;
         } else {
            var2 = this.pointToPosition((int)var1.getX(), (int)var1.getY());
            var3 = var4;
            if (var2 != -1) {
               var3 = var4;
               if (var2 != this.getSelectedItemPosition()) {
                  View var5 = this.getChildAt(var2 - this.getFirstVisiblePosition());
                  if (var5.isEnabled()) {
                     this.setSelectionFromTop(var2, var5.getTop() - this.getTop());
                  }

                  this.a();
                  var3 = var4;
               }
            }
         }
      }

      return var3;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      switch (var1.getAction()) {
         case 0:
            this.f = this.pointToPosition((int)var1.getX(), (int)var1.getY());
         default:
            if (this.n != null) {
               this.n.a();
            }

            return super.onTouchEvent(var1);
      }
   }

   void setListSelectionHidden(boolean var1) {
      this.i = var1;
   }

   public void setSelector(Drawable var1) {
      DropDownListView.GateKeeperDrawable var2;
      if (var1 != null) {
         var2 = new DropDownListView.GateKeeperDrawable(var1);
      } else {
         var2 = null;
      }

      this.h = var2;
      super.setSelector(this.h);
      Rect var3 = new Rect();
      if (var1 != null) {
         var1.getPadding(var3);
      }

      this.b = var3.left;
      this.c = var3.top;
      this.d = var3.right;
      this.e = var3.bottom;
   }

   private static class GateKeeperDrawable extends DrawableWrapper {
      private boolean a = true;

      GateKeeperDrawable(Drawable var1) {
         super(var1);
      }

      void a(boolean var1) {
         this.a = var1;
      }

      @Override
      public void draw(Canvas var1) {
         if (this.a) {
            super.draw(var1);
         }
      }

      @Override
      public void setHotspot(float var1, float var2) {
         if (this.a) {
            super.setHotspot(var1, var2);
         }
      }

      @Override
      public void setHotspotBounds(int var1, int var2, int var3, int var4) {
         if (this.a) {
            super.setHotspotBounds(var1, var2, var3, var4);
         }
      }

      @Override
      public boolean setState(int[] var1) {
         boolean var2;
         if (this.a) {
            var2 = super.setState(var1);
         } else {
            var2 = false;
         }

         return var2;
      }

      @Override
      public boolean setVisible(boolean var1, boolean var2) {
         if (this.a) {
            var1 = super.setVisible(var1, var2);
         } else {
            var1 = false;
         }

         return var1;
      }
   }

   private class ResolveHoverRunnable implements Runnable {
      final DropDownListView a;

      private ResolveHoverRunnable(DropDownListView var1) {
         this.a = var1;
      }

      public void a() {
         this.a.n = null;
         this.a.removeCallbacks(this);
      }

      public void b() {
         this.a.post(this);
      }

      @Override
      public void run() {
         this.a.n = null;
         this.a.drawableStateChanged();
      }
   }
}
