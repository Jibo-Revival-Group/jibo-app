package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.ImageView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class JiboPreparationsFragment_ViewBinding extends WiFiBaseFragment_ViewBinding {
   private JiboPreparationsFragment b;
   private View c;
   private View d;
   private View e;
   private View f;
   private View g;

   public JiboPreparationsFragment_ViewBinding(JiboPreparationsFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 16908327, "field 'closeButton' and method 'onCloseClick'");
      var1.closeButton = Utils.c(var3, 16908327, "field 'closeButton'", ImageView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JiboPreparationsFragment b;
         final JiboPreparationsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCloseClick(var1);
         }
      });
      var1.progressView = Utils.a(var2, 16908301, "field 'progressView'");
      var1.checkmarkImage = Utils.b(var2, 16908294, "field 'checkmarkImage'", ImageView.class);
      var3 = Utils.a(var2, 2131296350, "method 'btnNextScreenClick'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JiboPreparationsFragment b;
         final JiboPreparationsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnNextScreenClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296382, "method 'btnNextScreenClick'");
      this.e = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JiboPreparationsFragment b;
         final JiboPreparationsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnNextScreenClick(var1);
         }
      });
      var3 = Utils.a(var2, 2131296383, "method 'btnNextScreenClick'");
      this.f = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JiboPreparationsFragment b;
         final JiboPreparationsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnNextScreenClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296364, "method 'btnNextScreenClick'");
      this.g = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JiboPreparationsFragment b;
         final JiboPreparationsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.btnNextScreenClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      JiboPreparationsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.closeButton = null;
      var1.progressView = null;
      var1.checkmarkImage = null;
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
