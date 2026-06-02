package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class WelcomeFragment_ViewBinding implements Unbinder {
   private WelcomeFragment b;
   private View c;
   private View d;
   private View e;

   public WelcomeFragment_ViewBinding(WelcomeFragment var1, View var2) {
      this.b = var1;
      View var3 = Utils.a(var2, 2131296373, "field 'btnLogin' and method 'openLoginScreen'");
      var1.btnLogin = Utils.c(var3, 2131296373, "field 'btnLogin'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WelcomeFragment b;
         final WelcomeFragment_ViewBinding c;

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
         final WelcomeFragment b;
         final WelcomeFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.openSignupScreen(var1);
         }
      });
      var2 = Utils.a(var2, 2131296352, "method 'onDevSettings'");
      this.e = var2;
      var2.setOnLongClickListener(new OnLongClickListener(this, var1) {
         final WelcomeFragment a;
         final WelcomeFragment_ViewBinding b;

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
      WelcomeFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.btnLogin = null;
      var1.btnSignUp = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnLongClickListener(null);
      this.e = null;
   }
}
