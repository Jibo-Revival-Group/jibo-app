package com.jibo.ui.fragment.phone;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class PhoneConfirmFragment_ViewBinding implements Unbinder {
   private PhoneConfirmFragment b;
   private View c;

   public PhoneConfirmFragment_ViewBinding(PhoneConfirmFragment var1, View var2) {
      this.b = var1;
      var1.code = Utils.b(var2, 2131296462, "field 'code'", EditText.class);
      var1.footer_error = Utils.b(var2, 2131296571, "field 'footer_error'", TextView.class);
      var1.footer1 = Utils.b(var2, 2131296570, "field 'footer1'", TextView.class);
      var2 = Utils.a(var2, 2131296827, "method 'onResendCode'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final PhoneConfirmFragment b;
         final PhoneConfirmFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onResendCode(var1);
         }
      });
   }

   @Override
   public void unbind() {
      PhoneConfirmFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.code = null;
      var1.footer_error = null;
      var1.footer1 = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
