package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LoginFragment_ViewBinding extends SocialMediaBaseFragment_ViewBinding {
   private LoginFragment b;
   private View c;

   public LoginFragment_ViewBinding(LoginFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.validationMessagePassword = Utils.b(var2, 2131297059, "field 'validationMessagePassword'", TextView.class);
      var2 = Utils.a(var2, 2131296359, "method 'onForgotPasswordClick'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoginFragment b;
         final LoginFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onForgotPasswordClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      LoginFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.validationMessagePassword = null;
      this.c.setOnClickListener(null);
      this.c = null;
      super.unbind();
   }
}
