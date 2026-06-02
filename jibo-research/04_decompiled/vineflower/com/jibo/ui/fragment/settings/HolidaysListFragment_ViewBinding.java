package com.jibo.ui.fragment.settings;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class HolidaysListFragment_ViewBinding implements Unbinder {
   private HolidaysListFragment b;

   public HolidaysListFragment_ViewBinding(HolidaysListFragment var1, View var2) {
      this.b = var1;
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
   }

   @Override
   public void unbind() {
      HolidaysListFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
   }
}
