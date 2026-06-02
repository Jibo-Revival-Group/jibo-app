package com.jibo.ui.fragment.wifi;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class WiFiTokenGetterFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private WiFiTokenGetterFragment b;
   private View c;
   private View d;
   private View e;

   public WiFiTokenGetterFragment_ViewBinding(WiFiTokenGetterFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 16908327, "method 'onCloseClick'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiTokenGetterFragment b;
         final WiFiTokenGetterFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCloseClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296361, "method 'onBtnHelpClick'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiTokenGetterFragment b;
         final WiFiTokenGetterFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnHelpClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296349, "method 'onBtnContinueClick'");
      this.e = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiTokenGetterFragment b;
         final WiFiTokenGetterFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnContinueClick(var1);
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
