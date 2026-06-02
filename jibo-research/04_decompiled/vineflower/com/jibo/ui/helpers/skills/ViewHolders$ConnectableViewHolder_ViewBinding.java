package com.jibo.ui.helpers.skills;

import android.view.View;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class ViewHolders$ConnectableViewHolder_ViewBinding extends ViewHolders$AbstractSkillViewHolder_ViewBinding {
   private ViewHolders.ConnectableViewHolder target;

   public ViewHolders$ConnectableViewHolder_ViewBinding(ViewHolders.ConnectableViewHolder var1, View var2) {
      super(var1, var2);
      this.target = var1;
      var1.summary = Utils.b(var2, 16908304, "field 'summary'", CustomFontTextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.ConnectableViewHolder var1 = this.target;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.target = null;
      var1.summary = null;
      super.unbind();
   }
}
