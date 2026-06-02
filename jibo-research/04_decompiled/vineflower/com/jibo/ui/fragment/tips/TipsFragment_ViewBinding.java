package com.jibo.ui.fragment.tips;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class TipsFragment_ViewBinding implements Unbinder {
   private TipsFragment b;

   public TipsFragment_ViewBinding(TipsFragment var1, View var2) {
      this.b = var1;
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
   }

   @Override
   public void unbind() {
      TipsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
   }
}
