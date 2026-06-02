package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.AutoCompleteTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class ManualLocationFragment_ViewBinding implements Unbinder {
   private ManualLocationFragment b;

   public ManualLocationFragment_ViewBinding(ManualLocationFragment var1, View var2) {
      this.b = var1;
      var1.locationEdit = Utils.b(var2, 2131296712, "field 'locationEdit'", AutoCompleteTextView.class);
   }

   @Override
   public void unbind() {
      ManualLocationFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.locationEdit = null;
   }
}
