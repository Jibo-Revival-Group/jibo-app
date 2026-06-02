package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LegalGuardianFragment_ViewBinding implements Unbinder {
   private LegalGuardianFragment b;

   public LegalGuardianFragment_ViewBinding(LegalGuardianFragment var1, View var2) {
      this.b = var1;
      var1.name = Utils.b(var2, 16908308, "field 'name'", TextView.class);
      var1.email = Utils.b(var2, 16908309, "field 'email'", TextView.class);
      var1.avatar = Utils.b(var2, 16908294, "field 'avatar'", ImageView.class);
      var1.legalGuardianInfo = Utils.b(var2, 2131296694, "field 'legalGuardianInfo'", TextView.class);
      var1.legalGuardianTitle = Utils.b(var2, 2131296696, "field 'legalGuardianTitle'", TextView.class);
   }

   @Override
   public void unbind() {
      LegalGuardianFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.name = null;
      var1.email = null;
      var1.avatar = null;
      var1.legalGuardianInfo = null;
      var1.legalGuardianTitle = null;
   }
}
