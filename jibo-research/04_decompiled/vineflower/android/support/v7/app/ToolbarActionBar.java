package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.WindowCallbackWrapper;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {
   DecorToolbar mDecorToolbar;
   private boolean mLastMenuVisibility;
   private boolean mMenuCallbackSet;
   private final Toolbar.OnMenuItemClickListener mMenuClicker;
   private final Runnable mMenuInvalidator;
   private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList<>();
   boolean mToolbarMenuPrepared;
   Callback mWindowCallback;

   ToolbarActionBar(Toolbar var1, CharSequence var2, Callback var3) {
      this.mMenuInvalidator = new Runnable(this) {
         final ToolbarActionBar a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.populateOptionsMenu();
         }
      };
      this.mMenuClicker = new Toolbar.OnMenuItemClickListener(this) {
         final ToolbarActionBar a;

         {
            this.a = var1;
         }

         @Override
         public boolean a(MenuItem var1) {
            return this.a.mWindowCallback.onMenuItemSelected(0, var1);
         }
      };
      this.mDecorToolbar = new ToolbarWidgetWrapper(var1, false);
      this.mWindowCallback = new ToolbarActionBar.ToolbarCallbackWrapper(this, var3);
      this.mDecorToolbar.a(this.mWindowCallback);
      var1.setOnMenuItemClickListener(this.mMenuClicker);
      this.mDecorToolbar.a(var2);
   }

   private Menu getMenu() {
      if (!this.mMenuCallbackSet) {
         this.mDecorToolbar.a(new ToolbarActionBar.ActionMenuPresenterCallback(this), new ToolbarActionBar.MenuBuilderCallback(this));
         this.mMenuCallbackSet = true;
      }

      return this.mDecorToolbar.x();
   }

   @Override
   public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      this.mMenuVisibilityListeners.add(var1);
   }

   @Override
   public void addTab(ActionBar.Tab var1) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public void addTab(ActionBar.Tab var1, int var2) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public void addTab(ActionBar.Tab var1, int var2, boolean var3) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public void addTab(ActionBar.Tab var1, boolean var2) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public boolean closeOptionsMenu() {
      return this.mDecorToolbar.m();
   }

   @Override
   public boolean collapseActionView() {
      boolean var1;
      if (this.mDecorToolbar.c()) {
         this.mDecorToolbar.d();
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void dispatchMenuVisibilityChanged(boolean var1) {
      if (var1 != this.mLastMenuVisibility) {
         this.mLastMenuVisibility = var1;
         int var3 = this.mMenuVisibilityListeners.size();

         for (int var2 = 0; var2 < var3; var2++) {
            this.mMenuVisibilityListeners.get(var2).a(var1);
         }
      }
   }

   @Override
   public View getCustomView() {
      return this.mDecorToolbar.u();
   }

   @Override
   public int getDisplayOptions() {
      return this.mDecorToolbar.p();
   }

   @Override
   public float getElevation() {
      return ViewCompat.m(this.mDecorToolbar.a());
   }

   @Override
   public int getHeight() {
      return this.mDecorToolbar.v();
   }

   @Override
   public int getNavigationItemCount() {
      return 0;
   }

   @Override
   public int getNavigationMode() {
      return 0;
   }

   @Override
   public int getSelectedNavigationIndex() {
      return -1;
   }

   @Override
   public ActionBar.Tab getSelectedTab() {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public CharSequence getSubtitle() {
      return this.mDecorToolbar.f();
   }

   @Override
   public ActionBar.Tab getTabAt(int var1) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public int getTabCount() {
      return 0;
   }

   @Override
   public Context getThemedContext() {
      return this.mDecorToolbar.b();
   }

   @Override
   public CharSequence getTitle() {
      return this.mDecorToolbar.e();
   }

   public Callback getWrappedWindowCallback() {
      return this.mWindowCallback;
   }

   @Override
   public void hide() {
      this.mDecorToolbar.h(8);
   }

   @Override
   public boolean invalidateOptionsMenu() {
      this.mDecorToolbar.a().removeCallbacks(this.mMenuInvalidator);
      ViewCompat.a(this.mDecorToolbar.a(), this.mMenuInvalidator);
      return true;
   }

   @Override
   public boolean isShowing() {
      boolean var1;
      if (this.mDecorToolbar.w() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public boolean isTitleTruncated() {
      return super.isTitleTruncated();
   }

   @Override
   public ActionBar.Tab newTab() {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
   }

   @Override
   void onDestroy() {
      this.mDecorToolbar.a().removeCallbacks(this.mMenuInvalidator);
   }

   @Override
   public boolean onKeyShortcut(int var1, KeyEvent var2) {
      boolean var4 = false;
      Menu var5 = this.getMenu();
      if (var5 != null) {
         int var3;
         if (var2 != null) {
            var3 = var2.getDeviceId();
         } else {
            var3 = -1;
         }

         if (KeyCharacterMap.load(var3).getKeyboardType() != 1) {
            var4 = true;
         } else {
            var4 = false;
         }

         var5.setQwertyMode(var4);
         var4 = var5.performShortcut(var1, var2, 0);
      }

      return var4;
   }

   @Override
   public boolean onMenuKeyEvent(KeyEvent var1) {
      if (var1.getAction() == 1) {
         this.openOptionsMenu();
      }

      return true;
   }

   @Override
   public boolean openOptionsMenu() {
      return this.mDecorToolbar.l();
   }

   void populateOptionsMenu() {
      Menu var2 = this.getMenu();
      MenuBuilder var1;
      if (var2 instanceof MenuBuilder) {
         var1 = (MenuBuilder)var2;
      } else {
         var1 = null;
      }

      if (var1 != null) {
         var1.g();
      }

      try {
         var2.clear();
         if (!this.mWindowCallback.onCreatePanelMenu(0, var2) || !this.mWindowCallback.onPreparePanel(0, null, var2)) {
            var2.clear();
         }
      } finally {
         if (var1 != null) {
            var1.h();
         }
      }
   }

   @Override
   public void removeAllTabs() {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener var1) {
      this.mMenuVisibilityListeners.remove(var1);
   }

   @Override
   public void removeTab(ActionBar.Tab var1) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public void removeTabAt(int var1) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public boolean requestFocus() {
      ViewGroup var2 = this.mDecorToolbar.a();
      boolean var1;
      if (var2 != null && !var2.hasFocus()) {
         var2.requestFocus();
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public void selectTab(ActionBar.Tab var1) {
      throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
   }

   @Override
   public void setBackgroundDrawable(Drawable var1) {
      this.mDecorToolbar.d(var1);
   }

   @Override
   public void setCustomView(int var1) {
      this.setCustomView(LayoutInflater.from(this.mDecorToolbar.b()).inflate(var1, this.mDecorToolbar.a(), false));
   }

   @Override
   public void setCustomView(View var1) {
      this.setCustomView(var1, new ActionBar.LayoutParams(-2, -2));
   }

   @Override
   public void setCustomView(View var1, ActionBar.LayoutParams var2) {
      if (var1 != null) {
         var1.setLayoutParams(var2);
      }

      this.mDecorToolbar.a(var1);
   }

   @Override
   public void setDefaultDisplayHomeAsUpEnabled(boolean var1) {
   }

   @Override
   public void setDisplayHomeAsUpEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 4;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 4);
   }

   @SuppressLint("WrongConstant")
   @Override
   public void setDisplayOptions(int var1) {
      this.setDisplayOptions(var1, -1);
   }

   @Override
   public void setDisplayOptions(int var1, int var2) {
      int var3 = this.mDecorToolbar.p();
      this.mDecorToolbar.c(var3 & ~var2 | var1 & var2);
   }

   @Override
   public void setDisplayShowCustomEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 16;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 16);
   }

   @Override
   public void setDisplayShowHomeEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 2;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 2);
   }

   @Override
   public void setDisplayShowTitleEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 8;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 8);
   }

   @Override
   public void setDisplayUseLogoEnabled(boolean var1) {
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.setDisplayOptions(var2, 1);
   }

   @Override
   public void setElevation(float var1) {
      ViewCompat.a(this.mDecorToolbar.a(), var1);
   }

   @Override
   public void setHomeActionContentDescription(int var1) {
      this.mDecorToolbar.g(var1);
   }

   @Override
   public void setHomeActionContentDescription(CharSequence var1) {
      this.mDecorToolbar.d(var1);
   }

   @Override
   public void setHomeAsUpIndicator(int var1) {
      this.mDecorToolbar.f(var1);
   }

   @Override
   public void setHomeAsUpIndicator(Drawable var1) {
      this.mDecorToolbar.c(var1);
   }

   @Override
   public void setHomeButtonEnabled(boolean var1) {
   }

   @Override
   public void setIcon(int var1) {
      this.mDecorToolbar.a(var1);
   }

   @Override
   public void setIcon(Drawable var1) {
      this.mDecorToolbar.a(var1);
   }

   @Override
   public void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar.OnNavigationListener var2) {
      this.mDecorToolbar.a(var1, new NavItemSelectedListener(var2));
   }

   @Override
   public void setLogo(int var1) {
      this.mDecorToolbar.b(var1);
   }

   @Override
   public void setLogo(Drawable var1) {
      this.mDecorToolbar.b(var1);
   }

   @Override
   public void setNavigationMode(int var1) {
      if (var1 == 2) {
         throw new IllegalArgumentException("Tabs not supported in this configuration");
      }

      this.mDecorToolbar.d(var1);
   }

   @Override
   public void setSelectedNavigationItem(int var1) {
      switch (this.mDecorToolbar.r()) {
         case 1:
            this.mDecorToolbar.e(var1);
            return;
         default:
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
      }
   }

   @Override
   public void setShowHideAnimationEnabled(boolean var1) {
   }

   @Override
   public void setSplitBackgroundDrawable(Drawable var1) {
   }

   @Override
   public void setStackedBackgroundDrawable(Drawable var1) {
   }

   @Override
   public void setSubtitle(int var1) {
      DecorToolbar var3 = this.mDecorToolbar;
      CharSequence var2;
      if (var1 != 0) {
         var2 = this.mDecorToolbar.b().getText(var1);
      } else {
         var2 = null;
      }

      var3.c(var2);
   }

   @Override
   public void setSubtitle(CharSequence var1) {
      this.mDecorToolbar.c(var1);
   }

   @Override
   public void setTitle(int var1) {
      DecorToolbar var3 = this.mDecorToolbar;
      CharSequence var2;
      if (var1 != 0) {
         var2 = this.mDecorToolbar.b().getText(var1);
      } else {
         var2 = null;
      }

      var3.b(var2);
   }

   @Override
   public void setTitle(CharSequence var1) {
      this.mDecorToolbar.b(var1);
   }

   @Override
   public void setWindowTitle(CharSequence var1) {
      this.mDecorToolbar.a(var1);
   }

   @Override
   public void show() {
      this.mDecorToolbar.h(0);
   }

   private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
      final ToolbarActionBar a;
      private boolean b;

      ActionMenuPresenterCallback(ToolbarActionBar var1) {
         this.a = var1;
      }

      @Override
      public void a(MenuBuilder var1, boolean var2) {
         if (!this.b) {
            this.b = true;
            this.a.mDecorToolbar.o();
            if (this.a.mWindowCallback != null) {
               this.a.mWindowCallback.onPanelClosed(108, var1);
            }

            this.b = false;
         }
      }

      @Override
      public boolean a(MenuBuilder var1) {
         boolean var2;
         if (this.a.mWindowCallback != null) {
            this.a.mWindowCallback.onMenuOpened(108, var1);
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }
   }

   private final class MenuBuilderCallback implements MenuBuilder.Callback {
      final ToolbarActionBar a;

      MenuBuilderCallback(ToolbarActionBar var1) {
         this.a = var1;
      }

      @Override
      public void a(MenuBuilder var1) {
         if (this.a.mWindowCallback != null) {
            if (this.a.mDecorToolbar.j()) {
               this.a.mWindowCallback.onPanelClosed(108, var1);
            } else if (this.a.mWindowCallback.onPreparePanel(0, null, var1)) {
               this.a.mWindowCallback.onMenuOpened(108, var1);
            }
         }
      }

      @Override
      public boolean a(MenuBuilder var1, MenuItem var2) {
         return false;
      }
   }

   private class ToolbarCallbackWrapper extends WindowCallbackWrapper {
      final ToolbarActionBar a;

      public ToolbarCallbackWrapper(ToolbarActionBar var1, Callback var2) {
         super(var2);
         this.a = var1;
      }

      @Override
      public View onCreatePanelView(int var1) {
         View var2;
         if (var1 == 0) {
            var2 = new View(this.a.mDecorToolbar.b());
         } else {
            var2 = super.onCreatePanelView(var1);
         }

         return var2;
      }

      @Override
      public boolean onPreparePanel(int var1, View var2, Menu var3) {
         boolean var4 = super.onPreparePanel(var1, var2, var3);
         if (var4 && !this.a.mToolbarMenuPrepared) {
            this.a.mDecorToolbar.n();
            this.a.mToolbarMenuPrepared = true;
         }

         return var4;
      }
   }
}
