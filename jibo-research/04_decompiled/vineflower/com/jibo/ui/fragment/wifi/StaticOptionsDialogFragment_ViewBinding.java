package com.jibo.ui.fragment.wifi;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class StaticOptionsDialogFragment_ViewBinding implements Unbinder {
   private StaticOptionsDialogFragment b;
   private View c;
   private View d;

   public StaticOptionsDialogFragment_ViewBinding(StaticOptionsDialogFragment var1, View var2) {
      this.b = var1;
      var1.editIpAddress = Utils.b(var2, 2131296538, "field 'editIpAddress'", EditText.class);
      var1.editSubnetMask = Utils.b(var2, 2131296543, "field 'editSubnetMask'", EditText.class);
      var1.editRouter = Utils.b(var2, 2131296541, "field 'editRouter'", EditText.class);
      var1.editDns1 = Utils.b(var2, 2131296536, "field 'editDns1'", EditText.class);
      var1.editDns2 = Utils.b(var2, 2131296537, "field 'editDns2'", EditText.class);
      View var3 = Utils.a(var2, 2131296424, "method 'onCancelClicked'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final StaticOptionsDialogFragment b;
         final StaticOptionsDialogFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCancelClicked(var1);
         }
      });
      var2 = Utils.a(var2, 2131296885, "method 'onSetClicked'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final StaticOptionsDialogFragment b;
         final StaticOptionsDialogFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onSetClicked(var1);
         }
      });
   }

   @Override
   public void unbind() {
      StaticOptionsDialogFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.editIpAddress = null;
      var1.editSubnetMask = null;
      var1.editRouter = null;
      var1.editDns1 = null;
      var1.editDns2 = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
