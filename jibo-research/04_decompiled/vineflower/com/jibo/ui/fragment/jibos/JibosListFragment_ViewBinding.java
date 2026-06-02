package com.jibo.ui.fragment.jibos;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class JibosListFragment_ViewBinding implements Unbinder {
   private JibosListFragment b;
   private View c;
   private View d;
   private View e;

   public JibosListFragment_ViewBinding(JibosListFragment var1, View var2) {
      this.b = var1;
      var1.swipeRefreshLayout = Utils.b(var2, 2131296971, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
      var1.emptyView = Utils.a(var2, 16908292, "field 'emptyView'");
      View var3 = Utils.a(var2, 2131296750, "field 'fab' and method 'setUpNewJibo'");
      var1.fab = var3;
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JibosListFragment b;
         final JibosListFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.setUpNewJibo(var1);
         }
      });
      var3 = Utils.a(var2, 2131296348, "method 'onConnectWifi'");
      this.d = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JibosListFragment b;
         final JibosListFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onConnectWifi(var1);
         }
      });
      var2 = Utils.a(var2, 2131296365, "method 'onInviteInfo'");
      this.e = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final JibosListFragment b;
         final JibosListFragment_ViewBinding c;

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
      JibosListFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.swipeRefreshLayout = null;
      var1.list = null;
      var1.emptyView = null;
      var1.fab = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      this.e.setOnClickListener(null);
      this.e = null;
   }
}
