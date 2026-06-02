package com.jibo.ui.fragment.settings;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontAutoCompleteTextView;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class CustomHolidaySettingsFragment_ViewBinding implements Unbinder {
   private CustomHolidaySettingsFragment b;
   private View c;

   public CustomHolidaySettingsFragment_ViewBinding(CustomHolidaySettingsFragment var1, View var2) {
      this.b = var1;
      var1.holidayName = Utils.b(var2, 2131296582, "field 'holidayName'", CustomFontAutoCompleteTextView.class);
      var2 = Utils.a(var2, 2131296513, "field 'date' and method 'selectDate'");
      var1.date = Utils.c(var2, 2131296513, "field 'date'", CustomFontTextView.class);
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final CustomHolidaySettingsFragment b;
         final CustomHolidaySettingsFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.selectDate(var1);
         }
      });
   }

   @Override
   public void unbind() {
      CustomHolidaySettingsFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.holidayName = null;
      var1.date = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
