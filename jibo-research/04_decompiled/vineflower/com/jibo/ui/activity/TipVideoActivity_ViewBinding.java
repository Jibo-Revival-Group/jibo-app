package com.jibo.ui.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import butterknife.internal.Utils;

public final class TipVideoActivity_ViewBinding extends BaseActivity_ViewBinding {
   private TipVideoActivity b;

   public TipVideoActivity_ViewBinding(TipVideoActivity var1) {
      this(var1, var1.getWindow().getDecorView());
   }

   public TipVideoActivity_ViewBinding(TipVideoActivity var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.wvWistia = Utils.b(var2, 2131297075, "field 'wvWistia'", WebView.class);
      var1.pbLoader = Utils.b(var2, 16908301, "field 'pbLoader'", ProgressBar.class);
   }

   @Override
   public void unbind() {
      TipVideoActivity var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.wvWistia = null;
      var1.pbLoader = null;
      super.unbind();
   }
}
