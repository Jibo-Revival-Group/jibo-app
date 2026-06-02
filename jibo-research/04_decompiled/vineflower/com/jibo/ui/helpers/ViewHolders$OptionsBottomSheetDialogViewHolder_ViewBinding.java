package com.jibo.ui.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ViewHolders$OptionsBottomSheetDialogViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.OptionsBottomSheetDialogViewHolder b;

   public ViewHolders$OptionsBottomSheetDialogViewHolder_ViewBinding(ViewHolders.OptionsBottomSheetDialogViewHolder var1, View var2) {
      this.b = var1;
      var1.item = Utils.a(var2, 2131296614, "field 'item'");
      var1.tvItem = Utils.b(var2, 2131297036, "field 'tvItem'", TextView.class);
      var1.ivItem = Utils.b(var2, 2131296616, "field 'ivItem'", ImageView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.OptionsBottomSheetDialogViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.item = null;
      var1.tvItem = null;
      var1.ivItem = null;
   }
}
