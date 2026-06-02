package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class WiFiError1Fragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private WiFiError1Fragment b;
   private View c;
   private View d;

   public WiFiError1Fragment_ViewBinding(WiFiError1Fragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.editSSID = Utils.b(var2, 2131296542, "field 'editSSID'", EditText.class);
      var1.editPassword = Utils.b(var2, 2131296539, "field 'editPassword'", EditText.class);
      var1.txtPasswordHint = Utils.b(var2, 2131297044, "field 'txtPasswordHint'", TextView.class);
      View var3 = Utils.a(var2, 2131296406, "field 'btnTryAgain' and method 'btnTryAgainClick'");
      var1.btnTryAgain = Utils.c(var3, 2131296406, "field 'btnTryAgain'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiError1Fragment b;
         final WiFiError1Fragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.btnTryAgainClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296404, "method 'btnSupportClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiError1Fragment b;
         final WiFiError1Fragment_ViewBinding c;

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
      WiFiError1Fragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.editSSID = null;
      var1.editPassword = null;
      var1.txtPasswordHint = null;
      var1.btnTryAgain = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      super.unbind();
   }
}
