package com.jibo.ui.fragment.dialog.passphrase;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LoopPassphraseRestoreDialog_ViewBinding extends LoopPassphraseBaseDialog_ViewBinding {
   private LoopPassphraseRestoreDialog b;
   private View c;
   private View d;

   public LoopPassphraseRestoreDialog_ViewBinding(LoopPassphraseRestoreDialog var1, View var2) {
      super(var1, var2);
      this.b = var1;
      View var3 = Utils.a(var2, 2131296397, "method 'onSetClicked'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoopPassphraseRestoreDialog b;
         final LoopPassphraseRestoreDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onSetClicked(var1);
         }
      });
      var2 = Utils.a(var2, 2131296347, "method 'onCancelClicked'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoopPassphraseRestoreDialog b;
         final LoopPassphraseRestoreDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onCancelClicked(var1);
         }
      });
   }

   @Override
   public void unbind() {
      if (this.b == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
      super.unbind();
   }
}
