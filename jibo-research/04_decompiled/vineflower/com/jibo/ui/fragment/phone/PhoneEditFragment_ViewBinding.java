package com.jibo.ui.fragment.phone;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class PhoneEditFragment_ViewBinding implements Unbinder {
   private PhoneEditFragment b;

   public PhoneEditFragment_ViewBinding(PhoneEditFragment var1, View var2) {
      this.b = var1;
      var1.phone = Utils.b(var2, 2131296778, "field 'phone'", EditText.class);
   }

   @Override
   public void unbind() {
      PhoneEditFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.phone = null;
   }
}
