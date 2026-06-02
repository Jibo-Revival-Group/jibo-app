package com.salesforce.android.knowledge.ui.internal.toolbar;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.ViewBinder;

public abstract class ToolbarViewBinder extends ViewBinder implements ToolbarView {
   private final ToolbarPresenter a;

   protected ToolbarViewBinder(ToolbarPresenter var1) {
      this.a = var1;
   }

   @Override
   public void a(Menu var1, MenuInflater var2) {
      var2.inflate(R.menu.knowledge_menu, var1);
   }

   @Override
   public void a(boolean var1) {
      Toolbar var2 = this.d();
      if (var1) {
         var2.setNavigationIcon(R.drawable.knowledge_ic_home);
      } else {
         var2.setNavigationIcon(R.drawable.knowledge_ic_nav_back);
      }
   }

   @Override
   public boolean a(MenuItem var1) {
      boolean var3 = true;
      int var2 = var1.getItemId();
      if (var2 == R.id.knowledge_action_search) {
         this.a.d();
      } else if (var2 == 16908332) {
         this.a.e();
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public abstract Toolbar d();

   @Override
   public boolean t_() {
      return true;
   }
}
