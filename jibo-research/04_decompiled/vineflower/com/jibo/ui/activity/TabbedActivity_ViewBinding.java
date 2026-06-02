package com.jibo.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.internal.Utils;

public class TabbedActivity_ViewBinding extends BaseActivity_ViewBinding {
   private TabbedActivity b;

   public TabbedActivity_ViewBinding(TabbedActivity var1) {
      this(var1, var1.getWindow().getDecorView());
   }

   public TabbedActivity_ViewBinding(TabbedActivity var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.jiboListContainer = Utils.a(var2, 2131296621, "field 'jiboListContainer'");
      var1.jiboList = Utils.b(var2, 2131296620, "field 'jiboList'", RecyclerView.class);
      var1.tabs = Utils.b(var2, 16908307, "field 'tabs'", LinearLayout.class);
      var1.mSelectorDimmer = Utils.a(var2, 2131296881, "field 'mSelectorDimmer'");
   }

   @Override
   public void unbind() {
      TabbedActivity var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.jiboListContainer = null;
      var1.jiboList = null;
      var1.tabs = null;
      var1.mSelectorDimmer = null;
      super.unbind();
   }
}
