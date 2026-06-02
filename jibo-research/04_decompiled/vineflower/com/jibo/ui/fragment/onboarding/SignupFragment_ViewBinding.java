package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SignupFragment_ViewBinding extends SocialMediaBaseFragment_ViewBinding {
   private SignupFragment b;
   private View c;

   public SignupFragment_ViewBinding(SignupFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 16908289, "field 'termsCheckbox' and method 'onTermsCheckboxClick'");
      var1.termsCheckbox = Utils.c(var3, 16908289, "field 'termsCheckbox'", CheckBox.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final SignupFragment b;
         final SignupFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onTermsCheckboxClick();
         }
      });
      var1.footerText = Utils.b(var2, 2131296569, "field 'footerText'", TextView.class);
      var1.validationFooterText = Utils.b(var2, 2131297058, "field 'validationFooterText'", TextView.class);
   }

   @Override
   public void unbind() {
      SignupFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.termsCheckbox = null;
      var1.footerText = null;
      var1.validationFooterText = null;
      this.c.setOnClickListener(null);
      this.c = null;
      super.unbind();
   }
}
