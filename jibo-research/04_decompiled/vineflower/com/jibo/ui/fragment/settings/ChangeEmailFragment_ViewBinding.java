package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ChangeEmailFragment_ViewBinding implements Unbinder {
   private ChangeEmailFragment b;

   public ChangeEmailFragment_ViewBinding(ChangeEmailFragment var1, View var2) {
      this.b = var1;
      var1.email = Utils.b(var2, 2131296546, "field 'email'", EditText.class);
      var1.footer = Utils.b(var2, 2131296570, "field 'footer'", TextView.class);
      var1.footerError = Utils.b(var2, 2131296571, "field 'footerError'", TextView.class);
   }

   @Override
   public void unbind() {
      ChangeEmailFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.email = null;
      var1.footer = null;
      var1.footerError = null;
   }
}
