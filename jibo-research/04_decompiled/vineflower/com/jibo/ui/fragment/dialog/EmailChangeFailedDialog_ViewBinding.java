package com.jibo.ui.fragment.dialog;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class EmailChangeFailedDialog_ViewBinding implements Unbinder {
   private EmailChangeFailedDialog b;
   private View c;
   private View d;

   public EmailChangeFailedDialog_ViewBinding(EmailChangeFailedDialog var1, View var2) {
      this.b = var1;
      var1.textView = Utils.b(var2, 16908308, "field 'textView'", TextView.class);
      var1.email = Utils.b(var2, 2131296546, "field 'email'", TextView.class);
      var1.footer = Utils.b(var2, 2131296569, "field 'footer'", TextView.class);
      View var3 = Utils.a(var2, 2131296347, "method 'onCancelClicked'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EmailChangeFailedDialog b;
         final EmailChangeFailedDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCancelClicked(var1);
         }
      });
      var2 = Utils.a(var2, 2131296406, "method 'onTryAgainClicked'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final EmailChangeFailedDialog b;
         final EmailChangeFailedDialog_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onTryAgainClicked(var1);
         }
      });
   }

   @Override
   public void unbind() {
      EmailChangeFailedDialog var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.textView = null;
      var1.email = null;
      var1.footer = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
