package com.jibo.ui.helpers;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class ViewHolders$SimpleViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.SimpleViewHolder b;

   public ViewHolders$SimpleViewHolder_ViewBinding(ViewHolders.SimpleViewHolder var1, View var2) {
      this.b = var1;
      var1.text = Utils.b(var2, 16908308, "field 'text'", CustomFontTextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.SimpleViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text = null;
   }
}
