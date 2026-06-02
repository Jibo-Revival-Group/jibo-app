package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.Utils;

public class NetworkNameFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private NetworkNameFragment b;

   public NetworkNameFragment_ViewBinding(NetworkNameFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.editSSID = Utils.b(var2, 2131296542, "field 'editSSID'", EditText.class);
      var1.footer = Utils.b(var2, 2131296569, "field 'footer'", TextView.class);
   }

   @Override
   public void unbind() {
      NetworkNameFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.editSSID = null;
      var1.footer = null;
      super.unbind();
   }
}
