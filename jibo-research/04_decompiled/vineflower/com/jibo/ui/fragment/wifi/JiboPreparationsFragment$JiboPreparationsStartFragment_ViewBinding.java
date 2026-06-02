package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class JiboPreparationsFragment$JiboPreparationsStartFragment_ViewBinding implements Unbinder {
   private JiboPreparationsFragment.JiboPreparationsStartFragment b;

   public JiboPreparationsFragment$JiboPreparationsStartFragment_ViewBinding(JiboPreparationsFragment.JiboPreparationsStartFragment var1, View var2) {
      this.b = var1;
      var1.title = Utils.b(var2, 16908310, "field 'title'", TextView.class);
   }

   @Override
   public void unbind() {
      JiboPreparationsFragment.JiboPreparationsStartFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.title = null;
   }
}
