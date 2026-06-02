package com.jibo.ui.helpers;

import android.view.View;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class ViewHolders$SwitchStateWithDateViewHolder_ViewBinding extends ViewHolders$SwitchStateViewHolder_ViewBinding {
   private ViewHolders.SwitchStateWithDateViewHolder b;

   public ViewHolders$SwitchStateWithDateViewHolder_ViewBinding(ViewHolders.SwitchStateWithDateViewHolder var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.dateText = Utils.b(var2, 16908309, "field 'dateText'", CustomFontTextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.SwitchStateWithDateViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.dateText = null;
      super.unbind();
   }
}
