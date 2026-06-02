package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SignupCompleteFragment_ViewBinding implements Unbinder {
   private SignupCompleteFragment b;
   private View c;
   private View d;

   public SignupCompleteFragment_ViewBinding(SignupCompleteFragment var1, View var2) {
      this.b = var1;
      View var3 = Utils.a(var2, 2131296380, "field 'btnOpenEmailApp' and method 'onOpenEmailAppClick'");
      var1.btnOpenEmailApp = Utils.c(var3, 2131296380, "field 'btnOpenEmailApp'", Button.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final SignupCompleteFragment b;
         final SignupCompleteFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onOpenEmailAppClick(var1);
         }
      });
      var1.text_instructions = Utils.b(var2, 2131296997, "field 'text_instructions'", TextView.class);
      var2 = Utils.a(var2, 2131296391, "method 'onResendVerificationEmailClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final SignupCompleteFragment b;
         final SignupCompleteFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onResendVerificationEmailClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      SignupCompleteFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.btnOpenEmailApp = null;
      var1.text_instructions = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
