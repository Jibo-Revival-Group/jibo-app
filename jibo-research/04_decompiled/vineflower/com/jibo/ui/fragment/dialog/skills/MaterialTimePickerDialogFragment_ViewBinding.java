package com.jibo.ui.fragment.dialog.skills;

import android.view.View;
import android.widget.TimePicker;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MaterialTimePickerDialogFragment_ViewBinding implements Unbinder {
   private MaterialTimePickerDialogFragment b;
   private View c;
   private View d;

   public MaterialTimePickerDialogFragment_ViewBinding(MaterialTimePickerDialogFragment var1, View var2) {
      this.b = var1;
      var1.simpleTimePicker = Utils.b(var2, 2131296945, "field 'simpleTimePicker'", TimePicker.class);
      View var3 = Utils.a(var2, 2131296347, "method 'onCancelClick'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final MaterialTimePickerDialogFragment b;
         final MaterialTimePickerDialogFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onCancelClick(var1);
         }
      });
      var2 = Utils.a(var2, 2131296397, "method 'onSetClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final MaterialTimePickerDialogFragment b;
         final MaterialTimePickerDialogFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onSetClick(var1);
         }
      });
   }

   @Override
   public void unbind() {
      MaterialTimePickerDialogFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.simpleTimePicker = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
