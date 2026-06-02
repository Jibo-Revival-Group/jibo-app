package com.jibo.ui.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.Utils;

public class TipsActivity_ViewBinding extends BaseActivity_ViewBinding {
   private TipsActivity b;

   public TipsActivity_ViewBinding(TipsActivity var1) {
      this(var1, var1.getWindow().getDecorView());
   }

   public TipsActivity_ViewBinding(TipsActivity var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.collapsingToolbar = Utils.b(var2, 2131296464, "field 'collapsingToolbar'", CollapsingToolbarLayout.class);
      var1.appBarLayout = Utils.b(var2, 2131296322, "field 'appBarLayout'", AppBarLayout.class);
      var1.toolbarContainer = Utils.a(var2, 2131297012, "field 'toolbarContainer'");
      var1.toolbar = Utils.b(var2, 2131297022, "field 'toolbar'", Toolbar.class);
      var1.image = Utils.b(var2, 2131296596, "field 'image'", ImageView.class);
      var1.text = Utils.b(var2, 16908308, "field 'text'", TextView.class);
      var1.title = Utils.b(var2, 16908310, "field 'title'", TextView.class);
   }

   @Override
   public void unbind() {
      TipsActivity var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.collapsingToolbar = null;
      var1.appBarLayout = null;
      var1.toolbarContainer = null;
      var1.toolbar = null;
      var1.image = null;
      var1.text = null;
      var1.title = null;
      super.unbind();
   }
}
