package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class RobotAboutFragment_ViewBinding implements Unbinder {
   private RobotAboutFragment b;

   public RobotAboutFragment_ViewBinding(RobotAboutFragment var1, View var2) {
      this.b = var1;
      var1.ownerName = Utils.b(var2, 2131296763, "field 'ownerName'", TextView.class);
      var1.ownerEmail = Utils.b(var2, 2131296762, "field 'ownerEmail'", TextView.class);
      var1.osVersion = Utils.b(var2, 2131296759, "field 'osVersion'", TextView.class);
      var1.serialName = Utils.b(var2, 2131296883, "field 'serialName'", TextView.class);
   }

   @Override
   public void unbind() {
      RobotAboutFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.ownerName = null;
      var1.ownerEmail = null;
      var1.osVersion = null;
      var1.serialName = null;
   }
}
