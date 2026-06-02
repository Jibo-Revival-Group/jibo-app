package com.jibo.ui.helpers;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;

public class ViewHolders$HeaderButtonViewHolder_ViewBinding extends ViewHolders$SimpleViewHolder_ViewBinding {
   private ViewHolders.HeaderButtonViewHolder b;

   public ViewHolders$HeaderButtonViewHolder_ViewBinding(ViewHolders.HeaderButtonViewHolder var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.button = Utils.b(var2, 16908313, "field 'button'", TextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.HeaderButtonViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.button = null;
      super.unbind();
   }
}
