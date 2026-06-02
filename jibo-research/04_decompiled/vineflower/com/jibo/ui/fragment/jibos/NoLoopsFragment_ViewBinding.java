package com.jibo.ui.fragment.jibos;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class NoLoopsFragment_ViewBinding implements Unbinder {
   private NoLoopsFragment b;
   private View c;
   private View d;

   public NoLoopsFragment_ViewBinding(NoLoopsFragment var1, View var2) {
      this.b = var1;
      var1.icon = Utils.a(var2, 16908294, "field 'icon'");
      View var3 = Utils.a(var2, 2131296348, "method 'onConnectWifi'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NoLoopsFragment b;
         final NoLoopsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onConnectWifi(var1);
         }
      });
      var2 = Utils.a(var2, 2131296365, "method 'onInviteInfo'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final NoLoopsFragment b;
         final NoLoopsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onInviteInfo(var1);
         }
      });
   }

   @Override
   public void unbind() {
      NoLoopsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.icon = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
