package com.jibo.ui.fragment.jibos.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class JibosListAdapter$JiboViewHolder_ViewBinding implements Unbinder {
   private JibosListAdapter.JiboViewHolder b;

   public JibosListAdapter$JiboViewHolder_ViewBinding(JibosListAdapter.JiboViewHolder var1, View var2) {
      this.b = var1;
      var1.avatar = Utils.b(var2, 16908294, "field 'avatar'", ImageView.class);
      var1.titleText = Utils.b(var2, 16908308, "field 'titleText'", TextView.class);
      var1.ownerText = Utils.b(var2, 16908309, "field 'ownerText'", TextView.class);
      var1.loopSuspended = Utils.a(var2, 2131296715, "field 'loopSuspended'", TextView.class);
      var1.checkbox = Utils.a(var2, 2131296451, "field 'checkbox'", ImageView.class);
   }

   @Override
   public void unbind() {
      JibosListAdapter.JiboViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
      var1.titleText = null;
      var1.ownerText = null;
      var1.loopSuspended = null;
      var1.checkbox = null;
   }
}
