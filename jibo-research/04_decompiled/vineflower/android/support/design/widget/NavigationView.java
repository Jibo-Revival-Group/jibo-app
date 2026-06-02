package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;

public class NavigationView extends ScrimInsetsFrameLayout {
   private static final int[] d = new int[]{16842912};
   private static final int[] e = new int[]{-16842910};
   NavigationView.OnNavigationItemSelectedListener c;
   private final NavigationMenu f;
   private final NavigationMenuPresenter g = new NavigationMenuPresenter();
   private int h;
   private MenuInflater i;

   public NavigationView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NavigationView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      ThemeUtils.a(var1);
      this.f = new NavigationMenu(var1);
      TintTypedArray var7 = TintTypedArray.a(var1, var2, R.styleable.NavigationView, var3, R.style.Widget_Design_NavigationView);
      ViewCompat.a(this, var7.a(R.styleable.NavigationView_android_background));
      if (var7.g(R.styleable.NavigationView_elevation)) {
         ViewCompat.a(this, var7.e(R.styleable.NavigationView_elevation, 0));
      }

      ViewCompat.b(this, var7.a(R.styleable.NavigationView_android_fitsSystemWindows, false));
      this.h = var7.e(R.styleable.NavigationView_android_maxWidth, 0);
      ColorStateList var5;
      if (var7.g(R.styleable.NavigationView_itemIconTint)) {
         var5 = var7.e(R.styleable.NavigationView_itemIconTint);
      } else {
         var5 = this.c(16842808);
      }

      int var4;
      boolean var10;
      if (var7.g(R.styleable.NavigationView_itemTextAppearance)) {
         var4 = var7.g(R.styleable.NavigationView_itemTextAppearance, 0);
         var10 = true;
      } else {
         var4 = 0;
         var10 = false;
      }

      ColorStateList var8 = null;
      if (var7.g(R.styleable.NavigationView_itemTextColor)) {
         var8 = var7.e(R.styleable.NavigationView_itemTextColor);
      }

      ColorStateList var6 = var8;
      if (!var10) {
         var6 = var8;
         if (var8 == null) {
            var6 = this.c(16842806);
         }
      }

      Drawable var9 = var7.a(R.styleable.NavigationView_itemBackground);
      this.f.a(new MenuBuilder.Callback(this) {
         final NavigationView a;

         {
            this.a = var1;
         }

         @Override
         public void a(MenuBuilder var1) {
         }

         @Override
         public boolean a(MenuBuilder var1, MenuItem var2x) {
            boolean var3x;
            if (this.a.c != null && this.a.c.a(var2x)) {
               var3x = true;
            } else {
               var3x = false;
            }

            return var3x;
         }
      });
      this.g.a(1);
      this.g.a(var1, this.f);
      this.g.a(var5);
      if (var10) {
         this.g.c(var4);
      }

      this.g.b(var6);
      this.g.a(var9);
      this.f.a(this.g);
      this.addView((View)this.g.a(this));
      if (var7.g(R.styleable.NavigationView_menu)) {
         this.a(var7.g(R.styleable.NavigationView_menu, 0));
      }

      if (var7.g(R.styleable.NavigationView_headerLayout)) {
         this.b(var7.g(R.styleable.NavigationView_headerLayout, 0));
      }

      var7.a();
   }

   private ColorStateList c(int var1) {
      ColorStateList var4 = null;
      TypedValue var6 = new TypedValue();
      if (this.getContext().getTheme().resolveAttribute(var1, var6, true)) {
         ColorStateList var5 = AppCompatResources.a(this.getContext(), var6.resourceId);
         if (this.getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorPrimary, var6, true)) {
            var1 = var6.data;
            int var3 = var5.getDefaultColor();
            int[] var9 = e;
            int[] var7 = d;
            int[] var10 = EMPTY_STATE_SET;
            int var2 = var5.getColorForState(e, var3);
            var4 = new ColorStateList(new int[][]{var9, var7, var10}, new int[]{var2, var1, var3});
         }
      }

      return var4;
   }

   private MenuInflater getMenuInflater() {
      if (this.i == null) {
         this.i = new SupportMenuInflater(this.getContext());
      }

      return this.i;
   }

   public void a(int var1) {
      this.g.b(true);
      this.getMenuInflater().inflate(var1, this.f);
      this.g.b(false);
      this.g.a(false);
   }

   @Override
   protected void a(WindowInsetsCompat var1) {
      this.g.a(var1);
   }

   public View b(int var1) {
      return this.g.b(var1);
   }

   public int getHeaderCount() {
      return this.g.d();
   }

   public Drawable getItemBackground() {
      return this.g.g();
   }

   public ColorStateList getItemIconTintList() {
      return this.g.e();
   }

   public ColorStateList getItemTextColor() {
      return this.g.f();
   }

   public Menu getMenu() {
      return this.f;
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = var1;
      switch (MeasureSpec.getMode(var1)) {
         case Integer.MIN_VALUE:
            var3 = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(var1), this.h), 1073741824);
            break;
         case 0:
            var3 = MeasureSpec.makeMeasureSpec(this.h, 1073741824);
         case 1073741824:
            break;
         default:
            var3 = var1;
      }

      super.onMeasure(var3, var2);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof NavigationView.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         this.f.b(var1.a);
      }
   }

   protected Parcelable onSaveInstanceState() {
      NavigationView.SavedState var1 = new NavigationView.SavedState(super.onSaveInstanceState());
      var1.a = new Bundle();
      this.f.a(var1.a);
      return var1;
   }

   public void setCheckedItem(int var1) {
      MenuItem var2 = this.f.findItem(var1);
      if (var2 != null) {
         this.g.a((MenuItemImpl)var2);
      }
   }

   public void setItemBackground(Drawable var1) {
      this.g.a(var1);
   }

   public void setItemBackgroundResource(int var1) {
      this.setItemBackground(ContextCompat.a(this.getContext(), var1));
   }

   public void setItemIconTintList(ColorStateList var1) {
      this.g.a(var1);
   }

   public void setItemTextAppearance(int var1) {
      this.g.c(var1);
   }

   public void setItemTextColor(ColorStateList var1) {
      this.g.b(var1);
   }

   public void setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener var1) {
      this.c = var1;
   }

   public interface OnNavigationItemSelectedListener {
      boolean a(MenuItem var1);
   }

   public static class SavedState extends AbsSavedState {
      public static final Creator<NavigationView.SavedState> CREATOR = new ClassLoaderCreator<NavigationView.SavedState>() {
         public NavigationView.SavedState a(Parcel var1) {
            return new NavigationView.SavedState(var1, null);
         }

         public NavigationView.SavedState a(Parcel var1, ClassLoader var2) {
            return new NavigationView.SavedState(var1, var2);
         }

         public NavigationView.SavedState[] a(int var1) {
            return new NavigationView.SavedState[var1];
         }
      };
      public Bundle a;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         this.a = var1.readBundle(var2);
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeBundle(this.a);
      }
   }
}
