package com.jibo.ui.fragment.account.skills;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class StationsFragment_ViewBinding implements Unbinder {
   private StationsFragment b;

   public StationsFragment_ViewBinding(StationsFragment var1, View var2) {
      this.b = var1;
      var1.swipeRefreshLayout = Utils.b(var2, 2131296971, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
      var1.emptyView = Utils.a(var2, 16908292, "field 'emptyView'");
      var1.emptyViewTitle = Utils.b(var2, 16908310, "field 'emptyViewTitle'", TextView.class);
      var1.emptyViewIcon = Utils.b(var2, 16908294, "field 'emptyViewIcon'", ImageView.class);
      var1.emptyViewTextInfo = Utils.b(var2, 16908308, "field 'emptyViewTextInfo'", TextView.class);
   }

   @Override
   public void unbind() {
      StationsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.swipeRefreshLayout = null;
      var1.list = null;
      var1.emptyView = null;
      var1.emptyViewTitle = null;
      var1.emptyViewIcon = null;
      var1.emptyViewTextInfo = null;
   }
}
