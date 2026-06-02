package com.jibo.ui.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ViewHolders$SuspendedJiboViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.SuspendedJiboViewHolder b;

   public ViewHolders$SuspendedJiboViewHolder_ViewBinding(ViewHolders.SuspendedJiboViewHolder var1, View var2) {
      this.b = var1;
      var1.avatar = Utils.b(var2, 16908294, "field 'avatar'", ImageView.class);
      var1.titleText = Utils.b(var2, 16908308, "field 'titleText'", TextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.SuspendedJiboViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
      var1.titleText = null;
   }
}
