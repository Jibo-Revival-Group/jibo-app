package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontButton;

public class WiFiSuccessFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private WiFiSuccessFragment b;
   private View c;

   public WiFiSuccessFragment_ViewBinding(WiFiSuccessFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.txtTitle = Utils.b(var2, 16908310, "field 'txtTitle'", TextView.class);
      var1.txtInfo = Utils.b(var2, 2131297038, "field 'txtInfo'", TextView.class);
      View var3 = Utils.a(var2, 2131296349, "field 'btnContinue' and method 'onBtnContinueClick'");
      var1.btnContinue = Utils.c(var3, 2131296349, "field 'btnContinue'", CustomFontButton.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiSuccessFragment b;
         final WiFiSuccessFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnContinueClick(var1);
         }
      });
      var1.jiboImage = Utils.b(var2, 2131296624, "field 'jiboImage'", ImageView.class);
   }

   @Override
   public void unbind() {
      WiFiSuccessFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.txtTitle = null;
      var1.txtInfo = null;
      var1.btnContinue = null;
      var1.jiboImage = null;
      this.c.setOnClickListener(null);
      this.c = null;
      super.unbind();
   }
}
