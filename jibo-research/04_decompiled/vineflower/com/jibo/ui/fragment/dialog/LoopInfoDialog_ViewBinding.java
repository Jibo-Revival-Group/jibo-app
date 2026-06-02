package com.jibo.ui.fragment.dialog;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class LoopInfoDialog_ViewBinding implements Unbinder {
   private LoopInfoDialog b;
   private View c;

   public LoopInfoDialog_ViewBinding(LoopInfoDialog var1, View var2) {
      this.b = var1;
      var1.text = Utils.b(var2, 16908308, "field 'text'", TextView.class);
      var1.peopleCountMessage = Utils.b(var2, 2131296774, "field 'peopleCountMessage'", TextView.class);
      var2 = Utils.a(var2, 2131296397, "method 'okayClicked'");
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final LoopInfoDialog b;
         final LoopInfoDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.okayClicked(var1);
         }
      });
   }

   @Override
   public void unbind() {
      LoopInfoDialog var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.text = null;
      var1.peopleCountMessage = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
