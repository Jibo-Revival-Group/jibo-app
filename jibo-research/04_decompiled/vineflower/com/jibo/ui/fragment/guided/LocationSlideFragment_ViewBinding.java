package com.jibo.ui.fragment.guided;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.fragment.settings.LocationFragment_ViewBinding;

public class LocationSlideFragment_ViewBinding extends LocationFragment_ViewBinding {
   private LocationSlideFragment b;
   private View c;

   public LocationSlideFragment_ViewBinding(LocationSlideFragment var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.topText = Utils.b(var2, 2131296982, "field 'topText'", TextView.class);
      var1.text2 = Utils.b(var2, 2131296983, "field 'text2'", TextView.class);
      var2 = Utils.a(var2, 2131296399, "method 'btnSetLocationClick'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LocationSlideFragment b;
         final LocationSlideFragment_ViewBinding c;

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

   @Override
   public void unbind() {
      LocationSlideFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.topText = null;
      var1.text2 = null;
      this.c.setOnClickListener(null);
      this.c = null;
      super.unbind();
   }
}
