package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public final class WiFiQRCodeFragment$QrCodeFragment_ViewBinding implements Unbinder {
   private WiFiQRCodeFragment.QrCodeFragment b;

   public WiFiQRCodeFragment$QrCodeFragment_ViewBinding(WiFiQRCodeFragment.QrCodeFragment var1, View var2) {
      this.b = var1;
      var1.text1 = Utils.b(var2, 16908308, "field 'text1'", TextView.class);
      var1.imageQRCode = Utils.b(var2, 2131296600, "field 'imageQRCode'", ImageView.class);
      var1.placeholder = Utils.a(var2, 2131296797, "field 'placeholder'");
   }

   @Override
   public void unbind() {
      WiFiQRCodeFragment.QrCodeFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text1 = null;
      var1.imageQRCode = null;
      var1.placeholder = null;
   }
}
