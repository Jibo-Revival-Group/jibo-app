package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ResetPasswordFragment_ViewBinding implements Unbinder {
   private ResetPasswordFragment b;

   public ResetPasswordFragment_ViewBinding(ResetPasswordFragment var1, View var2) {
      this.b = var1;
      var1.emailEditText = Utils.b(var2, 2131296546, "field 'emailEditText'", EditText.class);
   }

   @Override
   public void unbind() {
      ResetPasswordFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.emailEditText = null;
   }
}
