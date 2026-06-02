package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ChangePasswordFragment_ViewBinding implements Unbinder {
   private ChangePasswordFragment b;

   public ChangePasswordFragment_ViewBinding(ChangePasswordFragment var1, View var2) {
      this.b = var1;
      var1.password = Utils.b(var2, 2131296773, "field 'password'", EditText.class);
      var1.footer = Utils.b(var2, 2131296570, "field 'footer'", TextView.class);
   }

   @Override
   public void unbind() {
      ChangePasswordFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.password = null;
      var1.footer = null;
   }
}
