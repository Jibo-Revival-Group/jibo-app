package com.jibo.ui.helpers;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ViewHolders$FooterViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.FooterViewHolder b;

   public ViewHolders$FooterViewHolder_ViewBinding(ViewHolders.FooterViewHolder var1, View var2) {
      this.b = var1;
      var1.footer = Utils.b(var2, 16908308, "field 'footer'", TextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.FooterViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.footer = null;
   }
}
