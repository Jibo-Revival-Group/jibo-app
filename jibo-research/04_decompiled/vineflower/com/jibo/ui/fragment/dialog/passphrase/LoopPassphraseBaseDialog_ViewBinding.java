package com.jibo.ui.fragment.dialog.passphrase;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LoopPassphraseBaseDialog_ViewBinding implements Unbinder {
   private LoopPassphraseBaseDialog b;

   public LoopPassphraseBaseDialog_ViewBinding(LoopPassphraseBaseDialog var1, View var2) {
      this.b = var1;
      var1.passphraseEdit = Utils.a(var2, 2131296993, "field 'passphraseEdit'", EditText.class);
      var1.text = Utils.b(var2, 16908308, "field 'text'", TextView.class);
      var1.title = Utils.b(var2, 16908310, "field 'title'", TextView.class);
      var1.footer = Utils.a(var2, 2131296569, "field 'footer'", TextView.class);
      var1.btnSet = Utils.b(var2, 2131296397, "field 'btnSet'", TextView.class);
      var1.btnCancel = Utils.b(var2, 2131296347, "field 'btnCancel'", TextView.class);
   }

   @Override
   public void unbind() {
      LoopPassphraseBaseDialog var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.passphraseEdit = null;
      var1.text = null;
      var1.title = null;
      var1.footer = null;
      var1.btnSet = null;
      var1.btnCancel = null;
   }
}
