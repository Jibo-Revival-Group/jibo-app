package com.jibo.ui.activity;

import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class BaseActivity_ViewBinding implements Unbinder {
   private BaseActivity b;

   public BaseActivity_ViewBinding(BaseActivity var1) {
      this(var1, var1.getWindow().getDecorView());
   }

   public BaseActivity_ViewBinding(BaseActivity var1, View var2) {
      this.b = var1;
      var1.mProgressBar = Utils.a(var2, 2131296805, "field 'mProgressBar'", ProgressBar.class);
      var1.mDimmer = var2.findViewById(2131296530);
      var1.viewNetworkDown = var2.findViewById(2131297063);
   }

   @Override
   public void unbind() {
      BaseActivity var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mProgressBar = null;
      var1.mDimmer = null;
      var1.viewNetworkDown = null;
   }
}
