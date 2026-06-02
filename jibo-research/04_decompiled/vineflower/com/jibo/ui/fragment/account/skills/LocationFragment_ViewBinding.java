package com.jibo.ui.fragment.account.skills;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;

public class LocationFragment_ViewBinding extends com.jibo.ui.fragment.settings.LocationFragment_ViewBinding {
   private LocationFragment b;

   public LocationFragment_ViewBinding(LocationFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.txtLocation = Utils.a(var2, 2131297042, "field 'txtLocation'", TextView.class);
      var1.txtTimezone = Utils.a(var2, 2131297046, "field 'txtTimezone'", TextView.class);
   }

   @Override
   public void unbind() {
      LocationFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.txtLocation = null;
      var1.txtTimezone = null;
      super.unbind();
   }
}
