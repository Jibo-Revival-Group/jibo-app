package com.jibo.ui.helpers.skills;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;

public class ViewHolders$OauthViewHolder_ViewBinding extends ViewHolders$AbstractSkillViewHolder_ViewBinding {
   private ViewHolders.OauthViewHolder target;

   public ViewHolders$OauthViewHolder_ViewBinding(ViewHolders.OauthViewHolder var1, View var2) {
      super(var1, var2);
      this.target = var1;
      var1.icon = Utils.b(var2, 16908294, "field 'icon'", ImageView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.OauthViewHolder var1 = this.target;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.target = null;
      var1.icon = null;
      super.unbind();
   }
}
