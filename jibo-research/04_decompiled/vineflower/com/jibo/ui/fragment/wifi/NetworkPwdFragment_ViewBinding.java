package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class NetworkPwdFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private NetworkPwdFragment b;
   private View c;

   public NetworkPwdFragment_ViewBinding(NetworkPwdFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.editPassword = Utils.b(var2, 2131296539, "field 'editPassword'", EditText.class);
      var1.txtPasswordHint = Utils.b(var2, 2131297044, "field 'txtPasswordHint'", TextView.class);
      var2 = Utils.a(var2, 2131296403, "field 'btnStaticOptions' and method 'onStaticClick'");
      var1.btnStaticOptions = Utils.c(var2, 2131296403, "field 'btnStaticOptions'", TextView.class);
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NetworkPwdFragment b;
         final NetworkPwdFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onStaticClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      NetworkPwdFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.editPassword = null;
      var1.txtPasswordHint = null;
      var1.btnStaticOptions = null;
      this.c.setOnClickListener(null);
      this.c = null;
      super.unbind();
   }
}
