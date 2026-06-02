package com.jibo.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class PhotoViewerActivity_ViewBinding implements Unbinder {
   private PhotoViewerActivity b;

   public PhotoViewerActivity_ViewBinding(PhotoViewerActivity var1) {
      this(var1, var1.getWindow().getDecorView());
   }

   public PhotoViewerActivity_ViewBinding(PhotoViewerActivity var1, View var2) {
      this.b = var1;
      var1.toolbar = Utils.b(var2, 2131297022, "field 'toolbar'", Toolbar.class);
      var1.pager = Utils.b(var2, 2131296766, "field 'pager'", ViewPager.class);
      var1.footer = Utils.a(var2, 2131296569, "field 'footer'");
      var1.photoDateText = Utils.b(var2, 16908308, "field 'photoDateText'", TextView.class);
      var1.transitionImage = Utils.b(var2, 2131297028, "field 'transitionImage'", ImageView.class);
      var1.viewNetworkDown = Utils.a(var2, 2131297063, "field 'viewNetworkDown'");
   }

   @Override
   public void unbind() {
      PhotoViewerActivity var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.toolbar = null;
      var1.pager = null;
      var1.footer = null;
      var1.photoDateText = null;
      var1.transitionImage = null;
      var1.viewNetworkDown = null;
   }
}
