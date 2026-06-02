package com.jibo.ui.helpers;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ViewHolders$WifiSettingsViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.WifiSettingsViewHolder b;

   public ViewHolders$WifiSettingsViewHolder_ViewBinding(ViewHolders.WifiSettingsViewHolder var1, View var2) {
      this.b = var1;
      var1.name = Utils.b(var2, 16908308, "field 'name'", TextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.WifiSettingsViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.name = null;
   }
}
