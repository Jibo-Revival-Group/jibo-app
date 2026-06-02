package com.jibo.ui.fragment.tips;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class TipsFragment$NextButtonViewHolder_ViewBinding implements Unbinder {
   private TipsFragment.NextButtonViewHolder b;
   private View c;

   public TipsFragment$NextButtonViewHolder_ViewBinding(TipsFragment.NextButtonViewHolder var1, View var2) {
      this.b = var1;
      var2 = Utils.a(var2, 2131296376, "field 'nextButton' and method 'next'");
      var1.nextButton = Utils.c(var2, 2131296376, "field 'nextButton'", Button.class);
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final TipsFragment.NextButtonViewHolder b;
         final TipsFragment$NextButtonViewHolder_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.next(var1);
         }
      });
   }

   @Override
   public void unbind() {
      TipsFragment.NextButtonViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.nextButton = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
