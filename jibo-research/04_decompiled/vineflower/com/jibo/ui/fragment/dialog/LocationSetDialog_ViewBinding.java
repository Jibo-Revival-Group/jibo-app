package com.jibo.ui.fragment.dialog;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LocationSetDialog_ViewBinding implements Unbinder {
   private LocationSetDialog b;
   private View c;

   public LocationSetDialog_ViewBinding(LocationSetDialog var1, View var2) {
      this.b = var1;
      var1.location = Utils.b(var2, 2131296712, "field 'location'", TextView.class);
      var1.timezone = Utils.b(var2, 2131297004, "field 'timezone'", TextView.class);
      var2 = Utils.a(var2, 2131296397, "method 'onBtnSetClicked'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LocationSetDialog b;
         final LocationSetDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnSetClicked(var1);
         }
      });
   }

   @Override
   public void unbind() {
      LocationSetDialog var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.location = null;
      var1.timezone = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
