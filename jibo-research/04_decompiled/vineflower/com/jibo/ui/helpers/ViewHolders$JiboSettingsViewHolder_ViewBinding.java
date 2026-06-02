package com.jibo.ui.helpers;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ViewHolders$JiboSettingsViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.JiboSettingsViewHolder b;

   public ViewHolders$JiboSettingsViewHolder_ViewBinding(ViewHolders.JiboSettingsViewHolder var1, View var2) {
      this.b = var1;
      var1.avatar = Utils.b(var2, 2131296588, "field 'avatar'", ImageView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.JiboSettingsViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
   }
}
