package com.jibo.ui.fragment.tips;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class TipsFragment$TipViewHolder_ViewBinding implements Unbinder {
   private TipsFragment.TipViewHolder b;

   public TipsFragment$TipViewHolder_ViewBinding(TipsFragment.TipViewHolder var1, View var2) {
      this.b = var1;
      var1.image = Utils.b(var2, 2131296596, "field 'image'", ImageView.class);
      var1.text = Utils.b(var2, 16908308, "field 'text'", TextView.class);
      var1.title = Utils.b(var2, 16908310, "field 'title'", TextView.class);
      var1.imageAboveTitle = Utils.b(var2, 2131296597, "field 'imageAboveTitle'", ImageView.class);
   }

   @Override
   public void unbind() {
      TipsFragment.TipViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.image = null;
      var1.text = null;
      var1.title = null;
      var1.imageAboveTitle = null;
   }
}
