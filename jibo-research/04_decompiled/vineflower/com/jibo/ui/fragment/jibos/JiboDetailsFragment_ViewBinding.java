package com.jibo.ui.fragment.jibos;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class JiboDetailsFragment_ViewBinding implements Unbinder {
   private JiboDetailsFragment b;
   private View c;
   private View d;

   public JiboDetailsFragment_ViewBinding(JiboDetailsFragment var1, View var2) {
      this.b = var1;
      var1.swipeRefreshLayout = Utils.b(var2, 2131296971, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
      var1.loopSuspendedView = Utils.a(var2, 2131296716, "field 'loopSuspendedView'");
      View var3 = Utils.a(var2, 2131296386, "field 'btnReconnectToJibo' and method 'reconnectToJiboClick'");
      var1.btnReconnectToJibo = var3;
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JiboDetailsFragment b;
         final JiboDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.reconnectToJiboClick();
         }
      });
      var1.tutorialTitleContainer = Utils.a(var2, 2131297035, "field 'tutorialTitleContainer'");
      var1.tutorialTitle = Utils.b(var2, 2131297034, "field 'tutorialTitle'", TextView.class);
      var2 = Utils.a(var2, 2131296511, "method 'onCustomerCareClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JiboDetailsFragment b;
         final JiboDetailsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onCustomerCareClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      JiboDetailsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.swipeRefreshLayout = null;
      var1.list = null;
      var1.loopSuspendedView = null;
      var1.btnReconnectToJibo = null;
      var1.tutorialTitleContainer = null;
      var1.tutorialTitle = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
