package com.jibo.ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class WiFiError2Fragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private WiFiError2Fragment b;
   private View c;
   private View d;
   private View e;

   public WiFiError2Fragment_ViewBinding(WiFiError2Fragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 2131296401, "method 'btnSetupStaticClick'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiError2Fragment b;
         final WiFiError2Fragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.btnSetupStaticClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296375, "method 'btnMacFilteringClick'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiError2Fragment b;
         final WiFiError2Fragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnMacFilteringClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296404, "method 'btnSupportClick'");
      this.e = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiError2Fragment b;
         final WiFiError2Fragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnSupportClick(var1);
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
      super.unbind();
   }
}
