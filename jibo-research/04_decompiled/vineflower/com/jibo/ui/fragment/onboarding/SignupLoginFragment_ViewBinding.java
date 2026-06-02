package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class SignupLoginFragment_ViewBinding implements Unbinder {
   private SignupLoginFragment b;
   private View c;
   private View d;
   private View e;
   private View f;

   public SignupLoginFragment_ViewBinding(SignupLoginFragment var1, View var2) {
      this.b = var1;
      View var3 = Utils.a(var2, 2131296373, "field 'btnLogin' and method 'openLoginScreen'");
      var1.btnLogin = Utils.c(var3, 2131296373, "field 'btnLogin'", Button.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final SignupLoginFragment b;
         final SignupLoginFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.openLoginScreen(var1);
         }
      });
      var3 = Utils.a(var2, 2131296402, "field 'btnSignUp' and method 'openSignupScreen'");
      var1.btnSignUp = Utils.c(var3, 2131296402, "field 'btnSignUp'", Button.class);
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final SignupLoginFragment b;
         final SignupLoginFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.openSignupScreen(var1);
         }
      });
      var3 = Utils.a(var2, 2131296370, "field 'btnLearnMore' and method 'openLearnMoreLink'");
      var1.btnLearnMore = var3;
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final SignupLoginFragment b;
         final SignupLoginFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.openLearnMoreLink(var1);
         }
      });
      var2 = Utils.a(var2, 2131296352, "method 'onDevSettings'");
      this.f = var2;
      var2.setOnLongClickListener(new OnLongClickListener(this, var1) {
         final SignupLoginFragment a;
         final SignupLoginFragment_ViewBinding b;

         {
            this.b = var1;
            this.a = var2;
         }

         public boolean onLongClick(View var1) {
            return this.a.onDevSettings(var1);
         }
      });
   }

   @Override
   public void unbind() {
      SignupLoginFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.btnLogin = null;
      var1.btnSignUp = null;
      var1.btnLearnMore = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnLongClickListener(null);
      this.f = null;
   }
}
