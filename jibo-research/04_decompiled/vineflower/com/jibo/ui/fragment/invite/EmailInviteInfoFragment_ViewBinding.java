package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class EmailInviteInfoFragment_ViewBinding implements Unbinder {
   private EmailInviteInfoFragment b;
   private View c;
   private View d;

   public EmailInviteInfoFragment_ViewBinding(EmailInviteInfoFragment var1, View var2) {
      this.b = var1;
      var1.title = Utils.b(var2, 2131297019, "field 'title'", TextView.class);
      var1.text = Utils.b(var2, 2131296982, "field 'text'", TextView.class);
      View var3 = Utils.a(var2, 2131296413, "method 'goToEmail'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EmailInviteInfoFragment b;
         final EmailInviteInfoFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.goToEmail(var1);
         }
      });
      var2 = Utils.a(var2, 2131296378, "method 'dontGoToEMail'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EmailInviteInfoFragment b;
         final EmailInviteInfoFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.dontGoToEMail(var1);
         }
      });
   }

   @Override
   public void unbind() {
      EmailInviteInfoFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.title = null;
      var1.text = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
