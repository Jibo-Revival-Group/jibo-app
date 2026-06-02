package com.jibo.ui.helpers;

import android.view.View;
import android.widget.CompoundButton;
import butterknife.internal.Utils;

public class ViewHolders$AvatarRadioTwoRowsSimpleViewHolder_ViewBinding extends ViewHolders$AvatarTwoRowsSimpleViewHolder_ViewBinding {
   private ViewHolders.AvatarRadioTwoRowsSimpleViewHolder b;

   public ViewHolders$AvatarRadioTwoRowsSimpleViewHolder_ViewBinding(ViewHolders.AvatarRadioTwoRowsSimpleViewHolder var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.mCompoundButton = Utils.b(var2, 2131296486, "field 'mCompoundButton'", CompoundButton.class);
   }

   @Override
   public void unbind() {
      ViewHolders.AvatarRadioTwoRowsSimpleViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mCompoundButton = null;
      super.unbind();
   }
}
