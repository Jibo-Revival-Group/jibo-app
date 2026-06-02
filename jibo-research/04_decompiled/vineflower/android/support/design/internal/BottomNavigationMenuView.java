package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.design.R;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.util.Pools;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class BottomNavigationMenuView extends ViewGroup implements MenuView {
   private final TransitionSet a;
   private final int b;
   private final int c;
   private final int d;
   private final int e;
   private final OnClickListener f;
   private final Pools.Pool<BottomNavigationItemView> g = new Pools.SynchronizedPool<>(5);
   private boolean h = true;
   private BottomNavigationItemView[] i;
   private int j = 0;
   private int k = 0;
   private ColorStateList l;
   private ColorStateList m;
   private int n;
   private int[] o;
   private BottomNavigationPresenter p;
   private MenuBuilder q;

   public BottomNavigationMenuView(Context var1) {
      this(var1, null);
   }

   public BottomNavigationMenuView(Context var1, AttributeSet var2) {
      super(var1, var2);
      Resources var3 = this.getResources();
      this.b = var3.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
      this.c = var3.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
      this.d = var3.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
      this.e = var3.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
      this.a = new AutoTransition();
      this.a.a(0);
      this.a.c(115L);
      this.a.b(new FastOutSlowInInterpolator());
      this.a.b(new TextScale());
      this.f = new OnClickListener(this) {
         final BottomNavigationMenuView a;

         {
            this.a = var1;
         }

         public void onClick(View var1) {
            MenuItemImpl var2x = ((BottomNavigationItemView)var1).getItemData();
            if (!this.a.q.a(var2x, this.a.p, 0)) {
               var2x.setChecked(true);
            }
         }
      };
      this.o = new int[5];
   }

   private BottomNavigationItemView getNewItem() {
      BottomNavigationItemView var2 = this.g.a();
      BottomNavigationItemView var1 = var2;
      if (var2 == null) {
         var1 = new BottomNavigationItemView(this.getContext());
      }

      return var1;
   }

   public void a() {
      this.removeAllViews();
      if (this.i != null) {
         for (BottomNavigationItemView var5 : this.i) {
            this.g.a(var5);
         }
      }

      if (this.q.size() == 0) {
         this.j = 0;
         this.k = 0;
         this.i = null;
      } else {
         this.i = new BottomNavigationItemView[this.q.size()];
         boolean var3;
         if (this.q.size() > 3) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.h = var3;

         for (int var6 = 0; var6 < this.q.size(); var6++) {
            this.p.b(true);
            this.q.getItem(var6).setCheckable(true);
            this.p.b(false);
            BottomNavigationItemView var7 = this.getNewItem();
            this.i[var6] = var7;
            var7.setIconTintList(this.l);
            var7.setTextColor(this.m);
            var7.setItemBackground(this.n);
            var7.setShiftingMode(this.h);
            var7.a((MenuItemImpl)this.q.getItem(var6), 0);
            var7.setItemPosition(var6);
            var7.setOnClickListener(this.f);
            this.addView(var7);
         }

         this.k = Math.min(this.q.size() - 1, this.k);
         this.q.getItem(this.k).setChecked(true);
      }
   }

   void a(int var1) {
      int var3 = this.q.size();

      for (int var2 = 0; var2 < var3; var2++) {
         MenuItem var4 = this.q.getItem(var2);
         if (var1 == var4.getItemId()) {
            this.j = var1;
            this.k = var2;
            var4.setChecked(true);
            break;
         }
      }
   }

   @Override
   public void a(MenuBuilder var1) {
      this.q = var1;
   }

   public void b() {
      int var2 = this.q.size();
      if (var2 != this.i.length) {
         this.a();
      } else {
         int var3 = this.j;

         for (int var1 = 0; var1 < var2; var1++) {
            MenuItem var4 = this.q.getItem(var1);
            if (var4.isChecked()) {
               this.j = var4.getItemId();
               this.k = var1;
            }
         }

         if (var3 != this.j) {
            TransitionManager.a(this, this.a);
         }

         for (int var5 = 0; var5 < var2; var5++) {
            this.p.b(true);
            this.i[var5].a((MenuItemImpl)this.q.getItem(var5), 0);
            this.p.b(false);
         }
      }
   }

   public ColorStateList getIconTintList() {
      return this.l;
   }

   public int getItemBackgroundRes() {
      return this.n;
   }

   public ColorStateList getItemTextColor() {
      return this.m;
   }

   public int getSelectedItemId() {
      return this.j;
   }

   public int getWindowAnimations() {
      return 0;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getChildCount();
      var4 -= var2;
      var5 -= var3;
      var2 = 0;
      var3 = 0;

      while (var2 < var6) {
         View var7 = this.getChildAt(var2);
         if (var7.getVisibility() != 8) {
            if (ViewCompat.e(this) == 1) {
               var7.layout(var4 - var3 - var7.getMeasuredWidth(), 0, var4 - var3, var5);
            } else {
               var7.layout(var3, 0, var7.getMeasuredWidth() + var3, var5);
            }

            var3 += var7.getMeasuredWidth();
         }

         var2++;
      }
   }

   protected void onMeasure(int var1, int var2) {
      var2 = MeasureSpec.getSize(var1);
      int var4 = this.getChildCount();
      int var7 = MeasureSpec.makeMeasureSpec(this.e, 1073741824);
      if (this.h) {
         var1 = var4 - 1;
         int var5 = Math.min(var2 - this.c * var1, this.d);
         int var6 = Math.min((var2 - var5) / var1, this.b);
         var1 = var2 - var5 - var1 * var6;

         for (int var15 = 0; var15 < var4; var15++) {
            int[] var8 = this.o;
            int var3;
            if (var15 == this.k) {
               var3 = var5;
            } else {
               var3 = var6;
            }

            var8[var15] = var3;
            if (var1 > 0) {
               var8 = this.o;
               var8[var15]++;
               var1--;
            }
         }
      } else {
         if (var4 == 0) {
            var1 = 1;
         } else {
            var1 = var4;
         }

         int var19 = Math.min(var2 / var1, this.d);
         int var18 = var2 - var19 * var4;
         var1 = 0;

         while (var1 < var4) {
            this.o[var1] = var19;
            var2 = var18;
            if (var18 > 0) {
               int[] var21 = this.o;
               var21[var1]++;
               var2 = var18 - 1;
            }

            var1++;
            var18 = var2;
         }
      }

      var1 = 0;
      var2 = 0;

      while (var1 < var4) {
         View var22 = this.getChildAt(var1);
         if (var22.getVisibility() != 8) {
            var22.measure(MeasureSpec.makeMeasureSpec(this.o[var1], 1073741824), var7);
            var22.getLayoutParams().width = var22.getMeasuredWidth();
            var2 += var22.getMeasuredWidth();
         }

         var1++;
      }

      this.setMeasuredDimension(View.resolveSizeAndState(var2, MeasureSpec.makeMeasureSpec(var2, 1073741824), 0), View.resolveSizeAndState(this.e, var7, 0));
   }

   public void setIconTintList(ColorStateList var1) {
      this.l = var1;
      if (this.i != null) {
         BottomNavigationItemView[] var4 = this.i;
         int var3 = var4.length;

         for (int var2 = 0; var2 < var3; var2++) {
            var4[var2].setIconTintList(var1);
         }
      }
   }

   public void setItemBackgroundRes(int var1) {
      this.n = var1;
      if (this.i != null) {
         BottomNavigationItemView[] var4 = this.i;
         int var3 = var4.length;

         for (int var2 = 0; var2 < var3; var2++) {
            var4[var2].setItemBackground(var1);
         }
      }
   }

   public void setItemTextColor(ColorStateList var1) {
      this.m = var1;
      if (this.i != null) {
         BottomNavigationItemView[] var4 = this.i;
         int var3 = var4.length;

         for (int var2 = 0; var2 < var3; var2++) {
            var4[var2].setTextColor(var1);
         }
      }
   }

   public void setPresenter(BottomNavigationPresenter var1) {
      this.p = var1;
   }
}
