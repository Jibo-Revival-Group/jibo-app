package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ChangeEmailSentFragment_ViewBinding implements Unbinder {
   private ChangeEmailSentFragment b;
   private View c;

   public ChangeEmailSentFragment_ViewBinding(ChangeEmailSentFragment var1, View var2) {
      this.b = var1;
      var1.text_instructions = Utils.b(var2, 2131296997, "field 'text_instructions'", TextView.class);
      var2 = Utils.a(var2, 2131296374, "method 'logout'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final ChangeEmailSentFragment b;
         final ChangeEmailSentFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.logout(var1);
         }
      });
   }

   @Override
   public void unbind() {
      ChangeEmailSentFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text_instructions = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
