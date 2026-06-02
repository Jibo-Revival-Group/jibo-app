package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class HolidaysListFragment$HolidayViewHolder_ViewBinding implements Unbinder {
   private HolidaysListFragment.HolidayViewHolder b;

   public HolidaysListFragment$HolidayViewHolder_ViewBinding(HolidaysListFragment.HolidayViewHolder var1, View var2) {
      this.b = var1;
      var1.text1 = Utils.b(var2, 16908308, "field 'text1'", TextView.class);
      var1.checkbox = Utils.b(var2, 16908289, "field 'checkbox'", CheckBox.class);
   }

   @Override
   public void unbind() {
      HolidaysListFragment.HolidayViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text1 = null;
      var1.checkbox = null;
   }
}
