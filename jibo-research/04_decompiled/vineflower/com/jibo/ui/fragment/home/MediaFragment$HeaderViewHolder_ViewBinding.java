package com.jibo.ui.fragment.home;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MediaFragment$HeaderViewHolder_ViewBinding implements Unbinder {
   private MediaFragment.HeaderViewHolder b;

   public MediaFragment$HeaderViewHolder_ViewBinding(MediaFragment.HeaderViewHolder var1, View var2) {
      this.b = var1;
      var1.text1 = Utils.b(var2, 16908308, "field 'text1'", TextView.class);
      var1.selectAll = Utils.b(var2, 2131296393, "field 'selectAll'", TextView.class);
   }

   @Override
   public void unbind() {
      MediaFragment.HeaderViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text1 = null;
      var1.selectAll = null;
   }
}
