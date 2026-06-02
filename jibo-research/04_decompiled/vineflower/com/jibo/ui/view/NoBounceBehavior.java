package com.jibo.ui.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public final class NoBounceBehavior extends AppBarLayout.Behavior {
   private boolean b = false;
   private boolean c = false;
   private boolean d = true;

   public NoBounceBehavior() {
   }

   public NoBounceBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   @Override
   public void a(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4) {
      super.a(var1, var2, var3, var4);
      this.b = false;
      this.c = false;
   }

   @Override
   public void a(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int var6, int var7, int var8) {
      if (!this.c) {
         super.a(var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   @Override
   public void a(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int[] var6, int var7) {
      if (var7 == 1) {
         this.b = true;
      }

      if (!this.c) {
         super.a(var1, var2, var3, var4, var5, var6, var7);
      }
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public boolean a(CoordinatorLayout var1, AppBarLayout var2, MotionEvent var3) {
      if (this.b) {
         this.c = true;
      }

      return super.a(var1, var2, var3);
   }

   @Override
   public boolean a(CoordinatorLayout var1, AppBarLayout var2, View var3, View var4, int var5, int var6) {
      return this.d;
   }

   public boolean b(CoordinatorLayout var1, AppBarLayout var2, MotionEvent var3) {
      boolean var4;
      if (this.d) {
         var4 = super.b(var1, var2, var3);
      } else {
         var4 = false;
      }

      return var4;
   }
}
