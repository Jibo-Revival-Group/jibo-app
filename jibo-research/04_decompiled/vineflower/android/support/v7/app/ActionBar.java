package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.SpinnerAdapter;

public abstract class ActionBar {
   public static final int DISPLAY_HOME_AS_UP = 4;
   public static final int DISPLAY_SHOW_CUSTOM = 16;
   public static final int DISPLAY_SHOW_HOME = 2;
   public static final int DISPLAY_SHOW_TITLE = 8;
   public static final int DISPLAY_USE_LOGO = 1;
   @Deprecated
   public static final int NAVIGATION_MODE_LIST = 1;
   @Deprecated
   public static final int NAVIGATION_MODE_STANDARD = 0;
   @Deprecated
   public static final int NAVIGATION_MODE_TABS = 2;

   public abstract void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1);

   @Deprecated
   public abstract void addTab(ActionBar.Tab var1);

   @Deprecated
   public abstract void addTab(ActionBar.Tab var1, int var2);

   @Deprecated
   public abstract void addTab(ActionBar.Tab var1, int var2, boolean var3);

   @Deprecated
   public abstract void addTab(ActionBar.Tab var1, boolean var2);

   public boolean closeOptionsMenu() {
      return false;
   }

   public boolean collapseActionView() {
      return false;
   }

   public void dispatchMenuVisibilityChanged(boolean var1) {
   }

   public abstract View getCustomView();

   public abstract int getDisplayOptions();

   public float getElevation() {
      return 0.0F;
   }

   public abstract int getHeight();

   public int getHideOffset() {
      return 0;
   }

   @Deprecated
   public abstract int getNavigationItemCount();

   @Deprecated
   public abstract int getNavigationMode();

   @Deprecated
   public abstract int getSelectedNavigationIndex();

   @Deprecated
   public abstract ActionBar.Tab getSelectedTab();

   public abstract CharSequence getSubtitle();

   @Deprecated
   public abstract ActionBar.Tab getTabAt(int var1);

   @Deprecated
   public abstract int getTabCount();

   public Context getThemedContext() {
      return null;
   }

   public abstract CharSequence getTitle();

   public abstract void hide();

   public boolean invalidateOptionsMenu() {
      return false;
   }

   public boolean isHideOnContentScrollEnabled() {
      return false;
   }

   public abstract boolean isShowing();

   public boolean isTitleTruncated() {
      return false;
   }

   @Deprecated
   public abstract ActionBar.Tab newTab();

   public void onConfigurationChanged(Configuration var1) {
   }

   void onDestroy() {
   }

   public boolean onKeyShortcut(int var1, KeyEvent var2) {
      return false;
   }

   public boolean onMenuKeyEvent(KeyEvent var1) {
      return false;
   }

   public boolean openOptionsMenu() {
      return false;
   }

   @Deprecated
   public abstract void removeAllTabs();

   public abstract void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1);

   @Deprecated
   public abstract void removeTab(ActionBar.Tab var1);

   @Deprecated
   public abstract void removeTabAt(int var1);

   boolean requestFocus() {
      return false;
   }

   @Deprecated
   public abstract void selectTab(ActionBar.Tab var1);

   public abstract void setBackgroundDrawable(Drawable var1);

   public abstract void setCustomView(int var1);

   public abstract void setCustomView(View var1);

   public abstract void setCustomView(View var1, ActionBar.LayoutParams var2);

   public void setDefaultDisplayHomeAsUpEnabled(boolean var1) {
   }

   public abstract void setDisplayHomeAsUpEnabled(boolean var1);

   public abstract void setDisplayOptions(int var1);

   public abstract void setDisplayOptions(int var1, int var2);

   public abstract void setDisplayShowCustomEnabled(boolean var1);

   public abstract void setDisplayShowHomeEnabled(boolean var1);

   public abstract void setDisplayShowTitleEnabled(boolean var1);

   public abstract void setDisplayUseLogoEnabled(boolean var1);

   public void setElevation(float var1) {
      if (var1 != 0.0F) {
         throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
      }
   }

   public void setHideOffset(int var1) {
      if (var1 != 0) {
         throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
      }
   }

   public void setHideOnContentScrollEnabled(boolean var1) {
      if (var1) {
         throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
      }
   }

   public void setHomeActionContentDescription(int var1) {
   }

   public void setHomeActionContentDescription(CharSequence var1) {
   }

   public void setHomeAsUpIndicator(int var1) {
   }

   public void setHomeAsUpIndicator(Drawable var1) {
   }

   public void setHomeButtonEnabled(boolean var1) {
   }

   public abstract void setIcon(int var1);

   public abstract void setIcon(Drawable var1);

   @Deprecated
   public abstract void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar.OnNavigationListener var2);

   public abstract void setLogo(int var1);

   public abstract void setLogo(Drawable var1);

   @Deprecated
   public abstract void setNavigationMode(int var1);

   @Deprecated
   public abstract void setSelectedNavigationItem(int var1);

   public void setShowHideAnimationEnabled(boolean var1) {
   }

   public void setSplitBackgroundDrawable(Drawable var1) {
   }

   public void setStackedBackgroundDrawable(Drawable var1) {
   }

   public abstract void setSubtitle(int var1);

   public abstract void setSubtitle(CharSequence var1);

   public abstract void setTitle(int var1);

   public abstract void setTitle(CharSequence var1);

   public void setWindowTitle(CharSequence var1) {
   }

   public abstract void show();

   public ActionMode startActionMode(ActionMode.Callback var1) {
      return null;
   }

   public static class LayoutParams extends MarginLayoutParams {
      public int a = 0;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.a = 8388627;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.ActionBarLayout);
         this.a = var3.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
         var3.recycle();
      }

      public LayoutParams(ActionBar.LayoutParams var1) {
         super(var1);
         this.a = var1.a;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }
   }

   public interface OnMenuVisibilityListener {
      void a(boolean var1);
   }

   @Deprecated
   public interface OnNavigationListener {
      boolean a(int var1, long var2);
   }

   @Deprecated
   public abstract static class Tab {
      public abstract int a();

      public abstract Drawable b();

      public abstract CharSequence c();

      public abstract View d();

      public abstract void e();

      public abstract CharSequence f();
   }

   @Deprecated
   public interface TabListener {
      void a(ActionBar.Tab var1, FragmentTransaction var2);

      void b(ActionBar.Tab var1, FragmentTransaction var2);

      void c(ActionBar.Tab var1, FragmentTransaction var2);
   }
}
