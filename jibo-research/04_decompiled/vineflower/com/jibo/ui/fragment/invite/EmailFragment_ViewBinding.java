package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class EmailFragment_ViewBinding implements Unbinder {
   private EmailFragment b;

   public EmailFragment_ViewBinding(EmailFragment var1, View var2) {
      this.b = var1;
      var1.email = Utils.b(var2, 2131296546, "field 'email'", AutoCompleteTextView.class);
      var1.title = Utils.b(var2, 2131297019, "field 'title'", TextView.class);
      var1.footer = Utils.b(var2, 2131296569, "field 'footer'", TextView.class);
   }

   @Override
   public void unbind() {
      EmailFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.email = null;
      var1.title = null;
      var1.footer = null;
   }
}
