package com.jibo.ui.fragment.tips;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class TipsFragment$TipVideoViewHolder_ViewBinding implements Unbinder {
   private TipsFragment.TipVideoViewHolder b;

   public TipsFragment$TipVideoViewHolder_ViewBinding(TipsFragment.TipVideoViewHolder var1, View var2) {
      this.b = var1;
      var1.text = Utils.b(var2, 16908308, "field 'text'", TextView.class);
      var1.contentImage = Utils.b(var2, 2131296491, "field 'contentImage'", RelativeLayout.class);
      var1.image = Utils.b(var2, 2131296596, "field 'image'", ImageView.class);
   }

   @Override
   public void unbind() {
      TipsFragment.TipVideoViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text = null;
      var1.contentImage = null;
      var1.image = null;
   }
}
