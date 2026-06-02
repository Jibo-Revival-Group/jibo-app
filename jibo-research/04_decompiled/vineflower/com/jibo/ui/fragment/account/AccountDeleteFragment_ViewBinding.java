package com.jibo.ui.fragment.account;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class AccountDeleteFragment_ViewBinding implements Unbinder {
   private AccountDeleteFragment b;
   private View c;

   public AccountDeleteFragment_ViewBinding(AccountDeleteFragment var1, View var2) {
      this.b = var1;
      var1.mLeaveReasonGroup = Utils.b(var2, 2131296691, "field 'mLeaveReasonGroup'", RadioGroup.class);
      var1.reason1 = Utils.b(var2, 2131296520, "field 'reason1'", RadioButton.class);
      var1.reason2 = Utils.b(var2, 2131296521, "field 'reason2'", RadioButton.class);
      var1.reason3 = Utils.b(var2, 2131296522, "field 'reason3'", RadioButton.class);
      var1.reason4 = Utils.b(var2, 2131296523, "field 'reason4'", RadioButton.class);
      var1.footer = Utils.b(var2, 2131296569, "field 'footer'", TextView.class);
      var2 = Utils.a(var2, 2131296351, "field 'btnDelete' and method 'onBtnDelete'");
      var1.btnDelete = var2;
      this.c = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final AccountDeleteFragment b;
         final AccountDeleteFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnDelete();
         }
      });
   }

   @Override
   public void unbind() {
      AccountDeleteFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.mLeaveReasonGroup = null;
      var1.reason1 = null;
      var1.reason2 = null;
      var1.reason3 = null;
      var1.reason4 = null;
      var1.footer = null;
      var1.btnDelete = null;
      this.c.setOnClickListener(null);
      this.c = null;
   }
}
