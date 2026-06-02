package com.jibo.ui.fragment.avatar;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class AvatarViewHolder_ViewBinding implements Unbinder {
   private AvatarViewHolder b;

   public AvatarViewHolder_ViewBinding(AvatarViewHolder var1, View var2) {
      this.b = var1;
      var1.avatar = Utils.b(var2, 16908294, "field 'avatar'", ImageView.class);
   }

   @Override
   public void unbind() {
      AvatarViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
   }
}
