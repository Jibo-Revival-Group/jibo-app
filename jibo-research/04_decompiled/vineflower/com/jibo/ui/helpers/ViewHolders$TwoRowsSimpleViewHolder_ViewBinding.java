package com.jibo.ui.helpers;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class ViewHolders$TwoRowsSimpleViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.TwoRowsSimpleViewHolder b;

   public ViewHolders$TwoRowsSimpleViewHolder_ViewBinding(ViewHolders.TwoRowsSimpleViewHolder var1, View var2) {
      this.b = var1;
      var1.title = Utils.b(var2, 16908308, "field 'title'", CustomFontTextView.class);
      var1.subtitle = Utils.b(var2, 16908309, "field 'subtitle'", CustomFontTextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.TwoRowsSimpleViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.title = null;
      var1.subtitle = null;
   }
}
