package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ResetPasswordNewPasswordFragment_ViewBinding implements Unbinder {
   private ResetPasswordNewPasswordFragment b;

   public ResetPasswordNewPasswordFragment_ViewBinding(ResetPasswordNewPasswordFragment var1, View var2) {
      this.b = var1;
      var1.passwordEdit = Utils.b(var2, 2131296773, "field 'passwordEdit'", EditText.class);
      var1.footer = Utils.b(var2, 2131296569, "field 'footer'", TextView.class);
   }

   @Override
   public void unbind() {
      ResetPasswordNewPasswordFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.passwordEdit = null;
      var1.footer = null;
   }
}
