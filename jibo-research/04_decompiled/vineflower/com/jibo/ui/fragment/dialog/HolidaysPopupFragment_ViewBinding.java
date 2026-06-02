package com.jibo.ui.fragment.dialog;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

public class HolidaysPopupFragment_ViewBinding implements Unbinder {
   private HolidaysPopupFragment b;
   private View c;
   private View d;

   public HolidaysPopupFragment_ViewBinding(HolidaysPopupFragment var1, View var2) {
      this.b = var1;
      View var3 = Utils.a(var2, 2131296346, "method 'onBtnAddHolidaysClick'");
      this.c = var3;
      var3.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final HolidaysPopupFragment b;
         final HolidaysPopupFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2x;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnAddHolidaysClick();
         }
      });
      var2 = Utils.a(var2, 2131296347, "method 'onBtnCancelClick'");
      this.d = var2;
      var2.setOnClickListener(new DebouncingOnClickListener(this, var1) {
         final HolidaysPopupFragment b;
         final HolidaysPopupFragment_ViewBinding c;

         {
            this.c = var1;
            this.b = var2;
         }

         @Override
         public void a(View var1) {
            this.b.onBtnCancelClick();
         }
      });
   }

   @Override
   public void unbind() {
      if (this.b == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      this.c.setOnClickListener(null);
      this.c = null;
      this.d.setOnClickListener(null);
      this.d = null;
   }
}
