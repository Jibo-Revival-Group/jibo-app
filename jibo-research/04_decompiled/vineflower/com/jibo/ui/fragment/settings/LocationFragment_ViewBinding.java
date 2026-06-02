package com.jibo.ui.fragment.settings;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LocationFragment_ViewBinding implements Unbinder {
   private LocationFragment b;
   private View c;
   private View d;

   public LocationFragment_ViewBinding(LocationFragment var1, View var2) {
      this.b = var1;
      var1.txtLocation = Utils.a(var2, 2131297042, "field 'txtLocation'", TextView.class);
      var1.txtTimezone = Utils.a(var2, 2131297046, "field 'txtTimezone'", TextView.class);
      View var3 = var2.findViewById(2131296399);
      if (var3 != null) {
         this.c = var3;
         var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
            final LocationFragment b;
            final LocationFragment_ViewBinding c;

            {
               this.c = var1;
               this.b = var2x;
            }

            @Override
            public void a(View var1) {
               this.b.btnSetLocationClick(var1);
            }
         });
      }

      var2 = var2.findViewById(2131296400);
      if (var2 != null) {
         this.d = var2;
         var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
            final LocationFragment b;
            final LocationFragment_ViewBinding c;

            {
               this.c = var1;
               this.b = var2;
            }

            @Override
            public void a(View var1) {
               this.b.setManuallyClick(var1);
            }
         });
      }
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
      if (this.c != null) {
         this.c.setOnClickListener(null);
         this.c = null;
      }

      if (this.d != null) {
         this.d.setOnClickListener(null);
         this.d = null;
      }
   }
}
