package com.jibo.ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class WiFiHelpFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private WiFiHelpFragment b;
   private View c;
   private View d;
   private View e;
   private View f;

   public WiFiHelpFragment_ViewBinding(WiFiHelpFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 2131296408, "method 'btnWiFiError1Click'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiHelpFragment b;
         final WiFiHelpFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.btnWiFiError1Click(var1);
         }
      });
      var3 = Utils.a(var2, 2131296409, "method 'btnWiFiError2Click'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiHelpFragment b;
         final WiFiHelpFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnWiFiError2Click(var1);
         }
      });
      var3 = Utils.a(var2, 2131296410, "method 'btnWiFiError3Click'");
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiHelpFragment b;
         final WiFiHelpFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnWiFiError3Click(var1);
         }
      });
      var2 = Utils.a(var2, 2131296411, "method 'btnWiFiError4Click'");
      this.f = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiHelpFragment b;
         final WiFiHelpFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnWiFiError4Click(var1);
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
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      super.unbind();
   }
}
