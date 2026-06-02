package com.jibo.ui.fragment.guided;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class WelcomeSlideFragment_ViewBinding implements Unbinder {
   private WelcomeSlideFragment b;

   public WelcomeSlideFragment_ViewBinding(WelcomeSlideFragment var1, View var2) {
      this.b = var1;
      var1.avatar = Utils.b(var2, 2131296330, "field 'avatar'", ImageView.class);
   }

   @Override
   public void unbind() {
      WelcomeSlideFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.avatar = null;
   }
}
