package com.jibo.ui.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.ui.view.RoundedImageView;

public class ViewHolders$LoopMemberViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.LoopMemberViewHolder b;

   public ViewHolders$LoopMemberViewHolder_ViewBinding(ViewHolders.LoopMemberViewHolder var1, View var2) {
      this.b = var1;
      var1.avatar = Utils.b(var2, 16908294, "field 'avatar'", RoundedImageView.class);
      var1.name = Utils.b(var2, 16908308, "field 'name'", TextView.class);
      var1.nickName = Utils.b(var2, 16908309, "field 'nickName'", TextView.class);
      var1.textStatus = Utils.b(var2, 2131296988, "field 'textStatus'", TextView.class);
      var1.smartphone = Utils.a(var2, 16908295, "field 'smartphone'", ImageView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.LoopMemberViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
      var1.name = null;
      var1.nickName = null;
      var1.textStatus = null;
      var1.smartphone = null;
   }
}
