package com.jibo.ui.helpers;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ViewHolders$JiboHeaderViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.JiboHeaderViewHolder b;

   public ViewHolders$JiboHeaderViewHolder_ViewBinding(ViewHolders.JiboHeaderViewHolder var1, View var2) {
      this.b = var1;
      var1.name = Utils.b(var2, 16908308, "field 'name'", TextView.class);
      var1.status = Utils.b(var2, 16908309, "field 'status'", TextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.JiboHeaderViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.name = null;
      var1.status = null;
   }
}
