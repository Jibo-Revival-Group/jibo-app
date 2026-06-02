package com.jibo.ui.helpers;

import android.view.View;
import butterknife.internal.Utils;

public class ViewHolders$InviteMemberViewHolder_ViewBinding extends ViewHolders$SimpleViewHolder_ViewBinding {
   private ViewHolders.InviteMemberViewHolder b;

   public ViewHolders$InviteMemberViewHolder_ViewBinding(ViewHolders.InviteMemberViewHolder var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.pulseView = Utils.a(var2, 2131296816, "field 'pulseView'");
   }

   @Override
   public void unbind() {
      ViewHolders.InviteMemberViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.pulseView = null;
      super.unbind();
   }
}
