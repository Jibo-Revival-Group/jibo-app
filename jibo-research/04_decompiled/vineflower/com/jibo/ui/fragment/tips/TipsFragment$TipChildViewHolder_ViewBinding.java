package com.jibo.ui.fragment.tips;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class TipsFragment$TipChildViewHolder_ViewBinding implements Unbinder {
   private TipsFragment.TipChildViewHolder b;

   public TipsFragment$TipChildViewHolder_ViewBinding(TipsFragment.TipChildViewHolder var1, View var2) {
      this.b = var1;
      var1.text = Utils.b(var2, 16908308, "field 'text'", TextView.class);
   }

   @Override
   public void unbind() {
      TipsFragment.TipChildViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text = null;
   }
}
