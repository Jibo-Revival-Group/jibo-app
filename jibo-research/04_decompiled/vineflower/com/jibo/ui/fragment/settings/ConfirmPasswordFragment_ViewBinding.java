package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ConfirmPasswordFragment_ViewBinding implements Unbinder {
   private ConfirmPasswordFragment b;
   private View c;

   public ConfirmPasswordFragment_ViewBinding(ConfirmPasswordFragment var1, View var2) {
      this.b = var1;
      var1.password = Utils.b(var2, 2131296773, "field 'password'", EditText.class);
      var1.footer = Utils.b(var2, 2131296570, "field 'footer'", TextView.class);
      var1.footerError = Utils.b(var2, 2131296571, "field 'footerError'", TextView.class);
      var2 = Utils.a(var2, 2131296828, "method 'onForgotPasswordClick'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final ConfirmPasswordFragment b;
         final ConfirmPasswordFragment_ViewBinding c;

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
      ConfirmPasswordFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.password = null;
      var1.footer = null;
      var1.footerError = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
