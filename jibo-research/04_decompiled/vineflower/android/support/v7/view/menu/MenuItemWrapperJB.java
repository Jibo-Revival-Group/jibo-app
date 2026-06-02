package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class MenuItemWrapperJB extends MenuItemWrapperICS {
   MenuItemWrapperJB(Context var1, SupportMenuItem var2) {
      super(var1, var2);
   }

   @Override
   MenuItemWrapperICS.ActionProviderWrapper a(ActionProvider var1) {
      return new MenuItemWrapperJB.ActionProviderWrapperJB(this, this.a, var1);
   }

   class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper implements android.view.ActionProvider.VisibilityListener {
      android.support.v4.view.ActionProvider.VisibilityListener c;
      final MenuItemWrapperJB d;

      public ActionProviderWrapperJB(MenuItemWrapperJB var1, Context var2, ActionProvider var3) {
         super(var1, var2, var3);
         this.d = var1;
      }

      @Override
      public View a(MenuItem var1) {
         return this.a.onCreateActionView(var1);
      }

      @Override
      public void a(android.support.v4.view.ActionProvider.VisibilityListener var1) {
         this.c = var1;
         ActionProvider var2 = this.a;
         MenuItemWrapperJB.ActionProviderWrapperJB var3;
         if (var1 != null) {
            var3 = this;
         } else {
            var3 = null;
         }

         var2.setVisibilityListener(var3);
      }

      @Override
      public boolean b() {
         return this.a.overridesItemVisibility();
      }

      @Override
      public boolean c() {
         return this.a.isVisible();
      }

      public void onActionProviderVisibilityChanged(boolean var1) {
         if (this.c != null) {
            this.c.a(var1);
         }
      }
   }
}
