package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends BaseMenuWrapper<SupportMenuItem> implements MenuItem {
   private Method c;

   MenuItemWrapperICS(Context var1, SupportMenuItem var2) {
      super(var1, var2);
   }

   MenuItemWrapperICS.ActionProviderWrapper a(ActionProvider var1) {
      return new MenuItemWrapperICS.ActionProviderWrapper(this, this.a, var1);
   }

   public void a(boolean var1) {
      try {
         if (this.c == null) {
            this.c = this.b.getClass().getDeclaredMethod("setExclusiveCheckable", boolean.class);
         }

         this.c.invoke(this.b, var1);
      } catch (Exception var3) {
         Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", var3);
      }
   }

   public boolean collapseActionView() {
      return this.b.collapseActionView();
   }

   public boolean expandActionView() {
      return this.b.expandActionView();
   }

   public ActionProvider getActionProvider() {
      android.support.v4.view.ActionProvider var1 = this.b.a();
      ActionProvider var2;
      if (var1 instanceof MenuItemWrapperICS.ActionProviderWrapper) {
         var2 = ((MenuItemWrapperICS.ActionProviderWrapper)var1).a;
      } else {
         var2 = null;
      }

      return var2;
   }

   public View getActionView() {
      View var2 = this.b.getActionView();
      View var1 = var2;
      if (var2 instanceof MenuItemWrapperICS.CollapsibleActionViewWrapper) {
         var1 = ((MenuItemWrapperICS.CollapsibleActionViewWrapper)var2).c();
      }

      return var1;
   }

   public int getAlphabeticModifiers() {
      return this.b.getAlphabeticModifiers();
   }

   public char getAlphabeticShortcut() {
      return this.b.getAlphabeticShortcut();
   }

   public CharSequence getContentDescription() {
      return this.b.getContentDescription();
   }

   public int getGroupId() {
      return this.b.getGroupId();
   }

   public Drawable getIcon() {
      return this.b.getIcon();
   }

   public ColorStateList getIconTintList() {
      return this.b.getIconTintList();
   }

   public Mode getIconTintMode() {
      return this.b.getIconTintMode();
   }

   public Intent getIntent() {
      return this.b.getIntent();
   }

   public int getItemId() {
      return this.b.getItemId();
   }

   public ContextMenuInfo getMenuInfo() {
      return this.b.getMenuInfo();
   }

   public int getNumericModifiers() {
      return this.b.getNumericModifiers();
   }

   public char getNumericShortcut() {
      return this.b.getNumericShortcut();
   }

   public int getOrder() {
      return this.b.getOrder();
   }

   public SubMenu getSubMenu() {
      return this.a(this.b.getSubMenu());
   }

   public CharSequence getTitle() {
      return this.b.getTitle();
   }

   public CharSequence getTitleCondensed() {
      return this.b.getTitleCondensed();
   }

   public CharSequence getTooltipText() {
      return this.b.getTooltipText();
   }

   public boolean hasSubMenu() {
      return this.b.hasSubMenu();
   }

   public boolean isActionViewExpanded() {
      return this.b.isActionViewExpanded();
   }

   public boolean isCheckable() {
      return this.b.isCheckable();
   }

   public boolean isChecked() {
      return this.b.isChecked();
   }

   public boolean isEnabled() {
      return this.b.isEnabled();
   }

   public boolean isVisible() {
      return this.b.isVisible();
   }

   public MenuItem setActionProvider(ActionProvider var1) {
      SupportMenuItem var2 = this.b;
      MenuItemWrapperICS.ActionProviderWrapper var3;
      if (var1 != null) {
         var3 = this.a(var1);
      } else {
         var3 = null;
      }

      var2.a(var3);
      return this;
   }

   public MenuItem setActionView(int var1) {
      this.b.setActionView(var1);
      View var2 = this.b.getActionView();
      if (var2 instanceof CollapsibleActionView) {
         this.b.setActionView(new MenuItemWrapperICS.CollapsibleActionViewWrapper(var2));
      }

      return this;
   }

   public MenuItem setActionView(View var1) {
      Object var2 = var1;
      if (var1 instanceof CollapsibleActionView) {
         var2 = new MenuItemWrapperICS.CollapsibleActionViewWrapper(var1);
      }

      this.b.setActionView((View)var2);
      return this;
   }

   public MenuItem setAlphabeticShortcut(char var1) {
      this.b.setAlphabeticShortcut(var1);
      return this;
   }

   public MenuItem setAlphabeticShortcut(char var1, int var2) {
      this.b.setAlphabeticShortcut(var1, var2);
      return this;
   }

   public MenuItem setCheckable(boolean var1) {
      this.b.setCheckable(var1);
      return this;
   }

   public MenuItem setChecked(boolean var1) {
      this.b.setChecked(var1);
      return this;
   }

   public MenuItem setContentDescription(CharSequence var1) {
      this.b.a(var1);
      return this;
   }

   public MenuItem setEnabled(boolean var1) {
      this.b.setEnabled(var1);
      return this;
   }

   public MenuItem setIcon(int var1) {
      this.b.setIcon(var1);
      return this;
   }

   public MenuItem setIcon(Drawable var1) {
      this.b.setIcon(var1);
      return this;
   }

   public MenuItem setIconTintList(ColorStateList var1) {
      this.b.setIconTintList(var1);
      return this;
   }

   public MenuItem setIconTintMode(Mode var1) {
      this.b.setIconTintMode(var1);
      return this;
   }

   public MenuItem setIntent(Intent var1) {
      this.b.setIntent(var1);
      return this;
   }

   public MenuItem setNumericShortcut(char var1) {
      this.b.setNumericShortcut(var1);
      return this;
   }

   public MenuItem setNumericShortcut(char var1, int var2) {
      this.b.setNumericShortcut(var1, var2);
      return this;
   }

   public MenuItem setOnActionExpandListener(OnActionExpandListener var1) {
      SupportMenuItem var2 = this.b;
      if (var1 != null) {
         var1 = new MenuItemWrapperICS.OnActionExpandListenerWrapper(this, var1);
      } else {
         var1 = null;
      }

      var2.setOnActionExpandListener(var1);
      return this;
   }

   public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener var1) {
      SupportMenuItem var2 = this.b;
      if (var1 != null) {
         var1 = new MenuItemWrapperICS.OnMenuItemClickListenerWrapper(this, var1);
      } else {
         var1 = null;
      }

      var2.setOnMenuItemClickListener(var1);
      return this;
   }

   public MenuItem setShortcut(char var1, char var2) {
      this.b.setShortcut(var1, var2);
      return this;
   }

   public MenuItem setShortcut(char var1, char var2, int var3, int var4) {
      this.b.setShortcut(var1, var2, var3, var4);
      return this;
   }

   public void setShowAsAction(int var1) {
      this.b.setShowAsAction(var1);
   }

   public MenuItem setShowAsActionFlags(int var1) {
      this.b.setShowAsActionFlags(var1);
      return this;
   }

   public MenuItem setTitle(int var1) {
      this.b.setTitle(var1);
      return this;
   }

   public MenuItem setTitle(CharSequence var1) {
      this.b.setTitle(var1);
      return this;
   }

   public MenuItem setTitleCondensed(CharSequence var1) {
      this.b.setTitleCondensed(var1);
      return this;
   }

   public MenuItem setTooltipText(CharSequence var1) {
      this.b.b(var1);
      return this;
   }

   public MenuItem setVisible(boolean var1) {
      return this.b.setVisible(var1);
   }

   class ActionProviderWrapper extends android.support.v4.view.ActionProvider {
      final ActionProvider a;
      final MenuItemWrapperICS b;

      public ActionProviderWrapper(MenuItemWrapperICS var1, Context var2, ActionProvider var3) {
         super(var2);
         this.b = var1;
         this.a = var3;
      }

      @Override
      public View a() {
         return this.a.onCreateActionView();
      }

      @Override
      public void a(SubMenu var1) {
         this.a.onPrepareSubMenu(this.b.a(var1));
      }

      @Override
      public boolean d() {
         return this.a.onPerformDefaultAction();
      }

      @Override
      public boolean e() {
         return this.a.hasSubMenu();
      }
   }

   static class CollapsibleActionViewWrapper extends FrameLayout implements android.support.v7.view.CollapsibleActionView {
      final CollapsibleActionView a;

      CollapsibleActionViewWrapper(View var1) {
         super(var1.getContext());
         this.a = (CollapsibleActionView)var1;
         this.addView(var1);
      }

      @Override
      public void a() {
         this.a.onActionViewExpanded();
      }

      @Override
      public void b() {
         this.a.onActionViewCollapsed();
      }

      View c() {
         return (View)this.a;
      }
   }

   private class OnActionExpandListenerWrapper extends BaseWrapper<OnActionExpandListener> implements OnActionExpandListener {
      final MenuItemWrapperICS a;

      OnActionExpandListenerWrapper(MenuItemWrapperICS var1, OnActionExpandListener var2) {
         super(var2);
         this.a = var1;
      }

      public boolean onMenuItemActionCollapse(MenuItem var1) {
         return this.b.onMenuItemActionCollapse(this.a.a(var1));
      }

      public boolean onMenuItemActionExpand(MenuItem var1) {
         return this.b.onMenuItemActionExpand(this.a.a(var1));
      }
   }

   private class OnMenuItemClickListenerWrapper extends BaseWrapper<OnMenuItemClickListener> implements OnMenuItemClickListener {
      final MenuItemWrapperICS a;

      OnMenuItemClickListenerWrapper(MenuItemWrapperICS var1, OnMenuItemClickListener var2) {
         super(var2);
         this.a = var1;
      }

      public boolean onMenuItemClick(MenuItem var1) {
         return this.b.onMenuItemClick(this.a.a(var1));
      }
   }
}
