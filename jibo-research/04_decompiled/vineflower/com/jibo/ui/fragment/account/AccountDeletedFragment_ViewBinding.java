package com.jibo.ui.fragment.account;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AccountDeletedFragment_ViewBinding implements Unbinder {
   private AccountDeletedFragment b;
   private View c;

   public AccountDeletedFragment_ViewBinding(AccountDeletedFragment var1, View var2) {
      this.b = var1;
      var2 = Utils.a(var2, 16908327, "field 'closeButton' and method 'onCloseButtonClick'");
      var1.closeButton = Utils.c(var2, 16908327, "field 'closeButton'", ImageView.class);
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountDeletedFragment b;
         final AccountDeletedFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCloseButtonClick();
         }
      });
   }

   @Override
   public void unbind() {
      AccountDeletedFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.closeButton = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
