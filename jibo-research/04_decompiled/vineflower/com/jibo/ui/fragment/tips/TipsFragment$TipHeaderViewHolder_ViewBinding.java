package com.jibo.ui.fragment.tips;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class TipsFragment$TipHeaderViewHolder_ViewBinding implements Unbinder {
   private TipsFragment.TipHeaderViewHolder b;

   public TipsFragment$TipHeaderViewHolder_ViewBinding(TipsFragment.TipHeaderViewHolder var1, View var2) {
      this.b = var1;
      var1.icon = Utils.b(var2, 2131296588, "field 'icon'", ImageView.class);
      var1.title = Utils.b(var2, 2131297019, "field 'title'", TextView.class);
      var1.subtitle = Utils.b(var2, 2131296969, "field 'subtitle'", TextView.class);
   }

   @Override
   public void unbind() {
      TipsFragment.TipHeaderViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.icon = null;
      var1.title = null;
      var1.subtitle = null;
   }
}
