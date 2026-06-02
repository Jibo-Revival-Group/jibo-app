package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class SocialMediaBaseFragment_ViewBinding implements Unbinder {
   private SocialMediaBaseFragment b;

   public SocialMediaBaseFragment_ViewBinding(SocialMediaBaseFragment var1, View var2) {
      this.b = var1;
      var1.emailEditText = Utils.b(var2, 2131296546, "field 'emailEditText'", EditText.class);
      var1.passwordEditText = Utils.b(var2, 2131296773, "field 'passwordEditText'", EditText.class);
   }

   @Override
   public void unbind() {
      SocialMediaBaseFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.emailEditText = null;
      var1.passwordEditText = null;
   }
}
