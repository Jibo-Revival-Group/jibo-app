package com.jibo.ui.fragment.account;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class AccountDeleteConfirmFragment_ViewBinding implements Unbinder {
   private AccountDeleteConfirmFragment b;
   private View c;
   private View d;

   public AccountDeleteConfirmFragment_ViewBinding(AccountDeleteConfirmFragment var1, View var2) {
      this.b = var1;
      View var3 = Utils.a(var2, 16908327, "field 'closeButton' and method 'onCloseButtonClick'");
      var1.closeButton = Utils.c(var3, 16908327, "field 'closeButton'", ImageView.class);
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountDeleteConfirmFragment b;
         final AccountDeleteConfirmFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCloseButtonClick();
         }
      });
      var1.cross1 = Utils.b(var2, 2131296504, "field 'cross1'", ImageView.class);
      var1.cross2 = Utils.b(var2, 2131296505, "field 'cross2'", ImageView.class);
      var1.cross3 = Utils.b(var2, 2131296506, "field 'cross3'", ImageView.class);
      var1.cross4 = Utils.b(var2, 2131296507, "field 'cross4'", ImageView.class);
      var1.hideWarning = Utils.a(var2, 2131296581, "field 'hideWarning'");
      var1.title = Utils.b(var2, 2131297019, "field 'title'", CustomFontTextView.class);
      var1.warning1 = Utils.b(var2, 2131297071, "field 'warning1'", CustomFontTextView.class);
      var1.warning2 = Utils.b(var2, 2131297072, "field 'warning2'", CustomFontTextView.class);
      var1.warning3 = Utils.b(var2, 2131297073, "field 'warning3'", CustomFontTextView.class);
      var2 = Utils.a(var2, 2131296351, "method 'onBtnDelete'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountDeleteConfirmFragment b;
         final AccountDeleteConfirmFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnDelete();
         }
      });
   }

   @Override
   public void unbind() {
      AccountDeleteConfirmFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.closeButton = null;
      var1.cross1 = null;
      var1.cross2 = null;
      var1.cross3 = null;
      var1.cross4 = null;
      var1.hideWarning = null;
      var1.title = null;
      var1.warning1 = null;
      var1.warning2 = null;
      var1.warning3 = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
