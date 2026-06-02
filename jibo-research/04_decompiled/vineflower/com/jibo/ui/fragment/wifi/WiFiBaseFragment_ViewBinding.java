package com.jibo.ui.fragment.wifi;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;

public class WiFiBaseFragment_ViewBinding implements Unbinder {
   private WiFiBaseFragment b;
   private View c;
   private View d;

   public WiFiBaseFragment_ViewBinding(WiFiBaseFragment var1, View var2) {
      this.b = var1;
      View var3 = var2.findViewById(2131296361);
      if (var3 != null) {
         this.c = var3;
         var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
            final WiFiBaseFragment b;
            final WiFiBaseFragment_ViewBinding c;

            {
               this.c = var1;
               this.b = var2x;
            }

            @Override
            public void a(View var1) {
               this.b.onBtnHelpClick(var1);
            }
         });
      }

      var2 = var2.findViewById(2131296362);
      if (var2 != null) {
         this.d = var2;
         var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
            final WiFiBaseFragment b;
            final WiFiBaseFragment_ViewBinding c;

            {
               this.c = var1;
               this.b = var2;
            }

            @Override
            public void a(View var1) {
               this.b.onBtnHelpClick(var1);
            }
         });
      }
   }

   @Override
   public void unbind() {
      if (this.b == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      if (this.c != null) {
         this.c.setOnClickListener(null);
         this.c = null;
      }

      if (this.d != null) {
         this.d.setOnClickListener(null);
         this.d = null;
      }
   }
}
