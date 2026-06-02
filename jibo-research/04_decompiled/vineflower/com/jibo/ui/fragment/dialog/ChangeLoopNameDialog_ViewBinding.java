package com.jibo.ui.fragment.dialog;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class ChangeLoopNameDialog_ViewBinding implements Unbinder {
   private ChangeLoopNameDialog b;
   private View c;
   private View d;

   public ChangeLoopNameDialog_ViewBinding(ChangeLoopNameDialog var1, View var2) {
      this.b = var1;
      var1.nameEdit = Utils.b(var2, 2131296746, "field 'nameEdit'", EditText.class);
      var1.tipText = Utils.b(var2, 2131297005, "field 'tipText'", TextView.class);
      View var3 = Utils.a(var2, 2131296424, "method 'onCancelClicked'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final ChangeLoopNameDialog b;
         final ChangeLoopNameDialog_ViewBinding c;

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
         final ChangeLoopNameDialog b;
         final ChangeLoopNameDialog_ViewBinding c;

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
      ChangeLoopNameDialog var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.nameEdit = null;
      var1.tipText = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
