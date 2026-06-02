package com.jibo.ui.helpers;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;

public class ViewHolders$AvatarTwoRowsSimpleViewHolder_ViewBinding extends ViewHolders$TwoRowsSimpleViewHolder_ViewBinding {
   private ViewHolders.AvatarTwoRowsSimpleViewHolder b;

   public ViewHolders$AvatarTwoRowsSimpleViewHolder_ViewBinding(ViewHolders.AvatarTwoRowsSimpleViewHolder var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.icon = Utils.b(var2, 16908294, "field 'icon'", ImageView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.AvatarTwoRowsSimpleViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.icon = null;
      super.unbind();
   }
}
