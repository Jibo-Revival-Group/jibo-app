package com.jibo.ui.helpers.skills;

import android.view.View;
import android.widget.CompoundButton;
import butterknife.internal.Utils;

public class ViewHolders$AbstractStateViewHolder_ViewBinding extends ViewHolders$AbstractSkillViewHolder_ViewBinding {
   private ViewHolders.AbstractStateViewHolder target;

   public ViewHolders$AbstractStateViewHolder_ViewBinding(ViewHolders.AbstractStateViewHolder var1, View var2) {
      super(var1, var2);
      this.target = var1;
      var1.compoundButton = Utils.b(var2, 2131296486, "field 'compoundButton'", CompoundButton.class);
   }

   @Override
   public void unbind() {
      ViewHolders.AbstractStateViewHolder var1 = this.target;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.target = null;
      var1.compoundButton = null;
      super.unbind();
   }
}
