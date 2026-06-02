package com.jibo.ui.fragment.dialog.passphrase;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LoopPassphraseInfoDialog_ViewBinding extends LoopPassphraseBaseDialog_ViewBinding {
   private LoopPassphraseInfoDialog b;
   private View c;
   private View d;

   public LoopPassphraseInfoDialog_ViewBinding(LoopPassphraseInfoDialog var1, View var2) {
      super(var1, var2);
      this.b = var1;
      var1.passphrase = Utils.b(var2, 2131296771, "field 'passphrase'", TextView.class);
      View var3 = Utils.a(var2, 2131296397, "method 'okayClicked'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoopPassphraseInfoDialog b;
         final LoopPassphraseInfoDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.okayClicked(var1);
         }
      });
      var2 = Utils.a(var2, 2131296347, "method 'cancelClicked'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoopPassphraseInfoDialog b;
         final LoopPassphraseInfoDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.cancelClicked(var1);
         }
      });
   }

   @Override
   public void unbind() {
      LoopPassphraseInfoDialog var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.passphrase = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      super.unbind();
   }
}
