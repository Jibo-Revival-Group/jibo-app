package com.jibo.ui.fragment.settings;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.ui.view.RecyclerViewFastScroller;

public class HolidaySettingsFragment_ViewBinding implements Unbinder {
   private HolidaySettingsFragment b;

   public HolidaySettingsFragment_ViewBinding(HolidaySettingsFragment var1, View var2) {
      this.b = var1;
      var1.list = Utils.b(var2, 16908298, "field 'list'", RecyclerView.class);
      var1.fastScroller = Utils.b(var2, 2131296559, "field 'fastScroller'", RecyclerViewFastScroller.class);
   }

   @Override
   public void unbind() {
      HolidaySettingsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.list = null;
      var1.fastScroller = null;
   }
}
