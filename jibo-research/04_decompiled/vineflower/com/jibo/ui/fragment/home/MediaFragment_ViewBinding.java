package com.jibo.ui.fragment.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class MediaFragment_ViewBinding implements Unbinder {
   private MediaFragment b;

   public MediaFragment_ViewBinding(MediaFragment var1, View var2) {
      this.b = var1;
      var1.swipeRefreshLayout = Utils.b(var2, 2131296971, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
      var1.emptyView = Utils.a(var2, 16908292, "field 'emptyView'");
      var1.viewNoKey = Utils.a(var2, 2131297064, "field 'viewNoKey'");
      var1.progressView = Utils.a(var2, 16908301, "field 'progressView'");
   }

   @Override
   public void unbind() {
      MediaFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.swipeRefreshLayout = null;
      var1.list = null;
      var1.emptyView = null;
      var1.viewNoKey = null;
      var1.progressView = null;
   }
}
