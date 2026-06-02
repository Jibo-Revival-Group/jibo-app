package com.jibo.ui.fragment.onboarding;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ResetPasswordSentFragment_ViewBinding implements Unbinder {
   private ResetPasswordSentFragment b;
   private View c;
   private View d;

   public ResetPasswordSentFragment_ViewBinding(ResetPasswordSentFragment var1, View var2) {
      this.b = var1;
      var1.text_instructions = Utils.b(var2, 2131296997, "field 'text_instructions'", TextView.class);
      View var3 = Utils.a(var2, 2131296390, "method 'onResendPasswordResetEmailClick'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final ResetPasswordSentFragment b;
         final ResetPasswordSentFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onResendPasswordResetEmailClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296380, "method 'onOpenEmailAppClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final ResetPasswordSentFragment b;
         final ResetPasswordSentFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onOpenEmailAppClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      ResetPasswordSentFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text_instructions = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
