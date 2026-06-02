package com.jibo.ui.helpers;

import android.view.View;
import android.widget.CompoundButton;
import butterknife.internal.Utils;

public class ViewHolders$SwitchStateViewHolder_ViewBinding extends ViewHolders$SimpleViewHolder_ViewBinding {
   private ViewHolders.SwitchStateViewHolder b;

   public ViewHolders$SwitchStateViewHolder_ViewBinding(ViewHolders.SwitchStateViewHolder var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.mCompoundButton = Utils.b(var2, 2131296486, "field 'mCompoundButton'", CompoundButton.class);
   }

   @Override
   public void unbind() {
      ViewHolders.SwitchStateViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mCompoundButton = null;
      super.unbind();
   }
}
