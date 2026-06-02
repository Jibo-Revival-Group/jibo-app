package com.jibo.ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MacAddressFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private MacAddressFragment b;
   private View c;

   public MacAddressFragment_ViewBinding(MacAddressFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var2 = Utils.a(var2, 2131296392, "method 'btnRestartSetup'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final MacAddressFragment b;
         final MacAddressFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.btnRestartSetup(var1);
         }
      });
   }

   @Override
   public void unbind() {
      if (this.b == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      super.unbind();
   }
}
