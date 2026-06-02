package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.RadioButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class AgeFragment_ViewBinding implements Unbinder {
   private AgeFragment b;

   public AgeFragment_ViewBinding(AgeFragment var1, View var2) {
      this.b = var1;
      var1.mTeenageOrAdult = Utils.b(var2, 2131296819, "field 'mTeenageOrAdult'", RadioButton.class);
      var1.mChild = Utils.b(var2, 2131296820, "field 'mChild'", RadioButton.class);
   }

   @Override
   public void unbind() {
      AgeFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mTeenageOrAdult = null;
      var1.mChild = null;
   }
}
