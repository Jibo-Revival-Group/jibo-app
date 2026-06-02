package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class WiFiQRCodeFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private WiFiQRCodeFragment b;
   private View c;
   private View d;
   private View e;
   private View f;
   private View g;

   public WiFiQRCodeFragment_ViewBinding(WiFiQRCodeFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.singleCodeToolbar = Utils.a(var2, 2131296946, "field 'singleCodeToolbar'");
      var1.multiCodeToolbar = Utils.a(var2, 2131296744, "field 'multiCodeToolbar'");
      var1.txtSingleCodeTitle = Utils.a(var2, 2131297045, "field 'txtSingleCodeTitle'");
      View var3 = Utils.a(var2, 2131296385, "field 'btnPrevCode' and method 'onBtnPrevCodeClick'");
      var1.btnPrevCode = Utils.c(var3, 2131296385, "field 'btnPrevCode'", TextView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiQRCodeFragment b;
         final WiFiQRCodeFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnPrevCodeClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296377, "field 'btnNextCode' and method 'onBtnNextCodeClick'");
      var1.btnNextCode = Utils.c(var3, 2131296377, "field 'btnNextCode'", TextView.class);
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiQRCodeFragment b;
         final WiFiQRCodeFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnNextCodeClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296353, "field 'btnDone' and method 'onBtnDoneClick'");
      var1.btnDone = Utils.c(var3, 2131296353, "field 'btnDone'", ImageView.class);
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiQRCodeFragment b;
         final WiFiQRCodeFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnDoneClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296354, "field 'btnDone1' and method 'onBtnDoneClick'");
      var1.btnDone1 = Utils.c(var3, 2131296354, "field 'btnDone1'", ImageView.class);
      this.f = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiQRCodeFragment b;
         final WiFiQRCodeFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnDoneClick(var1);
         }
      });
      var1.txtProgress = Utils.b(var2, 16908301, "field 'txtProgress'", TextView.class);
      var1.buttonsPanel = Utils.a(var2, 2131296423, "field 'buttonsPanel'");
      var1.brightnessPanel = Utils.a(var2, 2131296344, "field 'brightnessPanel'");
      var1.brightnessSeekbar = Utils.b(var2, 2131296341, "field 'brightnessSeekbar'", SeekBar.class);
      var1.brightnessLess = Utils.a(var2, 2131296342, "field 'brightnessLess'");
      var1.brightnessMore = Utils.a(var2, 2131296343, "field 'brightnessMore'");
      var2 = Utils.a(var2, 16908327, "method 'onCloseClick'");
      this.g = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final WiFiQRCodeFragment b;
         final WiFiQRCodeFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onCloseClick();
         }
      });
   }

   @Override
   public void unbind() {
      WiFiQRCodeFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.singleCodeToolbar = null;
      var1.multiCodeToolbar = null;
      var1.txtSingleCodeTitle = null;
      var1.btnPrevCode = null;
      var1.btnNextCode = null;
      var1.btnDone = null;
      var1.btnDone1 = null;
      var1.txtProgress = null;
      var1.buttonsPanel = null;
      var1.brightnessPanel = null;
      var1.brightnessSeekbar = null;
      var1.brightnessLess = null;
      var1.brightnessMore = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
      this.f.setOnClickListener(null);
      this.f = null;
      this.g.setOnClickListener(null);
      this.g = null;
      super.unbind();
   }
}
