package com.jibo.ui.fragment.phone;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class PhoneFillFragment_ViewBinding implements Unbinder {
   private PhoneFillFragment b;
   private View c;

   public PhoneFillFragment_ViewBinding(PhoneFillFragment var1, View var2) {
      this.b = var1;
      var1.phone = Utils.b(var2, 2131296778, "field 'phone'", EditText.class);
      var2 = Utils.a(var2, 2131296376, "field 'btnNext' and method 'onNext'");
      var1.btnNext = var2;
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final PhoneFillFragment b;
         final PhoneFillFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onNext(var1);
         }
      });
   }

   @Override
   public void unbind() {
      PhoneFillFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.phone = null;
      var1.btnNext = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
