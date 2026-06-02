package com.jibo.ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class WiFiJiboConnectingFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private WiFiJiboConnectingFragment b;
   private View c;
   private View d;

   public WiFiJiboConnectingFragment_ViewBinding(WiFiJiboConnectingFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 2131296379, "method 'onBtnNoScreenClick'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiJiboConnectingFragment b;
         final WiFiJiboConnectingFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnNoScreenClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296356, "method 'onBtnEditWifiClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiJiboConnectingFragment b;
         final WiFiJiboConnectingFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnEditWifiClick(var1);
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
      this.d.setOnClickListener(null);
      this.d = null;
      super.unbind();
   }
}
