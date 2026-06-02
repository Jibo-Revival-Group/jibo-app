package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BottomNavigationView extends FrameLayout {
   private static final int[] a = new int[]{16842912};
   private static final int[] b = new int[]{-16842910};
   private final MenuBuilder c;
   private final BottomNavigationMenuView d;
   private final BottomNavigationPresenter e = new BottomNavigationPresenter();
   private MenuInflater f;
   private BottomNavigationView.OnNavigationItemSelectedListener g;
   private BottomNavigationView.OnNavigationItemReselectedListener h;

   public BottomNavigationView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public BottomNavigationView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      ThemeUtils.a(var1);
      this.c = new BottomNavigationMenu(var1);
      this.d = new BottomNavigationMenuView(var1);
      LayoutParams var4 = new LayoutParams(-2, -2);
      var4.gravity = 17;
      this.d.setLayoutParams(var4);
      this.e.a(this.d);
      this.e.a(1);
      this.d.setPresenter(this.e);
      this.c.a(this.e);
      this.e.a(this.getContext(), this.c);
      TintTypedArray var5 = TintTypedArray.a(var1, var2, R.styleable.BottomNavigationView, var3, R.style.Widget_Design_BottomNavigationView);
      if (var5.g(R.styleable.BottomNavigationView_itemIconTint)) {
         this.d.setIconTintList(var5.e(R.styleable.BottomNavigationView_itemIconTint));
      } else {
         this.d.setIconTintList(this.b(16842808));
      }

      if (var5.g(R.styleable.BottomNavigationView_itemTextColor)) {
         this.d.setItemTextColor(var5.e(R.styleable.BottomNavigationView_itemTextColor));
      } else {
         this.d.setItemTextColor(this.b(16842808));
      }

      if (var5.g(R.styleable.BottomNavigationView_elevation)) {
         ViewCompat.a(this, var5.e(R.styleable.BottomNavigationView_elevation, 0));
      }

      var3 = var5.g(R.styleable.BottomNavigationView_itemBackground, 0);
      this.d.setItemBackgroundRes(var3);
      if (var5.g(R.styleable.BottomNavigationView_menu)) {
         this.a(var5.g(R.styleable.BottomNavigationView_menu, 0));
      }

      var5.a();
      this.addView(this.d, var4);
      if (VERSION.SDK_INT < 21) {
         this.a(var1);
      }

      this.c.a(new MenuBuilder.Callback(this) {
         final BottomNavigationView a;

         {
            this.a = var1;
         }

         @Override
         public void a(MenuBuilder var1) {
         }

         @Override
         public boolean a(MenuBuilder var1, MenuItem var2x) {
            boolean var3x = true;
            if (this.a.h != null && var2x.getItemId() == this.a.getSelectedItemId()) {
               this.a.h.a(var2x);
            } else if (this.a.g == null || this.a.g.a(var2x)) {
               var3x = false;
            }

            return var3x;
         }
      });
   }

   private void a(Context var1) {
      View var2 = new View(var1);
      var2.setBackgroundColor(ContextCompat.c(var1, R.color.design_bottom_navigation_shadow_color));
      var2.setLayoutParams(new LayoutParams(-1, this.getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
      this.addView(var2);
   }

   private ColorStateList b(int var1) {
      ColorStateList var4 = null;
      TypedValue var6 = new TypedValue();
      if (this.getContext().getTheme().resolveAttribute(var1, var6, true)) {
         ColorStateList var5 = AppCompatResources.a(this.getContext(), var6.resourceId);
         if (this.getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorPrimary, var6, true)) {
            var1 = var6.data;
            int var3 = var5.getDefaultColor();
            int[] var10 = b;
            int[] var7 = a;
            int[] var9 = EMPTY_STATE_SET;
            int var2 = var5.getColorForState(b, var3);
            var4 = new ColorStateList(new int[][]{var10, var7, var9}, new int[]{var2, var1, var3});
         }
      }

      return var4;
   }

   private MenuInflater getMenuInflater() {
      if (this.f == null) {
         this.f = new SupportMenuInflater(this.getContext());
      }

      return this.f;
   }

   public void a(int var1) {
      this.e.b(true);
      this.getMenuInflater().inflate(var1, this.c);
      this.e.b(false);
      this.e.a(true);
   }

   public int getItemBackgroundResource() {
      return this.d.getItemBackgroundRes();
   }

   public ColorStateList getItemIconTintList() {
      return this.d.getIconTintList();
   }

   public ColorStateList getItemTextColor() {
      return this.d.getItemTextColor();
   }

   public int getMaxItemCount() {
      return 5;
   }

   public Menu getMenu() {
      return this.c;
   }

   public int getSelectedItemId() {
      return this.d.getSelectedItemId();
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof BottomNavigationView.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         this.c.b(var1.a);
      }
   }

   protected Parcelable onSaveInstanceState() {
      BottomNavigationView.SavedState var1 = new BottomNavigationView.SavedState(super.onSaveInstanceState());
      var1.a = new Bundle();
      this.c.a(var1.a);
      return var1;
   }

   public void setItemBackgroundResource(int var1) {
      this.d.setItemBackgroundRes(var1);
   }

   public void setItemIconTintList(ColorStateList var1) {
      this.d.setIconTintList(var1);
   }

   public void setItemTextColor(ColorStateList var1) {
      this.d.setItemTextColor(var1);
   }

   public void setOnNavigationItemReselectedListener(BottomNavigationView.OnNavigationItemReselectedListener var1) {
      this.h = var1;
   }

   public void setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener var1) {
      this.g = var1;
   }

   public void setSelectedItemId(int var1) {
      MenuItem var2 = this.c.findItem(var1);
      if (var2 != null && !this.c.a(var2, this.e, 0)) {
         var2.setChecked(true);
      }
   }

   public interface OnNavigationItemReselectedListener {
      void a(MenuItem var1);
   }

   public interface OnNavigationItemSelectedListener {
      boolean a(MenuItem var1);
   }

   static class SavedState extends AbsSavedState {
      public static final Creator<BottomNavigationView.SavedState> CREATOR = new ClassLoaderCreator<BottomNavigationView.SavedState>() {
         public BottomNavigationView.SavedState a(Parcel var1) {
            return new BottomNavigationView.SavedState(var1, null);
         }

         public BottomNavigationView.SavedState a(Parcel var1, ClassLoader var2) {
            return new BottomNavigationView.SavedState(var1, var2);
         }

         public BottomNavigationView.SavedState[] a(int var1) {
            return new BottomNavigationView.SavedState[var1];
         }
      };
      Bundle a;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         this.a(var1, var2);
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      private void a(Parcel var1, ClassLoader var2) {
         this.a = var1.readBundle(var2);
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeBundle(this.a);
      }
   }
}
