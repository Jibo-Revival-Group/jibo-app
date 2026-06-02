package com.jibo.ui.fragment.dialog;

import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class MaterialDatePickerDialogFragment_ViewBinding implements Unbinder {
   private MaterialDatePickerDialogFragment b;
   private View c;
   private View d;

   public MaterialDatePickerDialogFragment_ViewBinding(MaterialDatePickerDialogFragment var1, View var2) {
      this.b = var1;
      var1.textDayOfMonth = Utils.b(var2, 2131296984, "field 'textDayOfMonth'", TextView.class);
      var1.textMonthYear = Utils.b(var2, 2131296985, "field 'textMonthYear'", TextView.class);
      var1.datePicker = Utils.b(var2, 2131296515, "field 'datePicker'", DatePicker.class);
      var1.textTitle = Utils.b(var2, 2131296990, "field 'textTitle'", TextView.class);
      View var3 = Utils.a(var2, 2131296347, "method 'onCancelClick'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final MaterialDatePickerDialogFragment b;
         final MaterialDatePickerDialogFragment_ViewBinding c;

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
         final MaterialDatePickerDialogFragment b;
         final MaterialDatePickerDialogFragment_ViewBinding c;

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
      MaterialDatePickerDialogFragment var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.textDayOfMonth = null;
      var1.textMonthYear = null;
      var1.datePicker = null;
      var1.textTitle = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
