package com.jibo.ui.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.jibo.ui.view.proxima.ProximaHelper;
import com.jibo.utils.ImageUtils;
import java.lang.reflect.Field;

public class MaterialDatePicker extends DatePicker {
   public MaterialDatePicker(Context var1, AttributeSet var2) {
      Object var5 = null;
      super(var1, var2);

      Class var3;
      try {
         var3 = Class.forName("com.android.internal.R$id");
      } catch (ClassNotFoundException var20) {
         var3 = null;
      }

      try {
         var21 = var3.getField("month");
      } catch (NoSuchFieldException var19) {
         var21 = null;
      }

      try {
         var22 = (NumberPicker)this.findViewById(var21.getInt(null));
      } catch (IllegalArgumentException var17) {
         var22 = null;
      } catch (IllegalAccessException var18) {
         var22 = null;
      }

      try {
         var23 = var3.getField("day");
      } catch (NoSuchFieldException var16) {
         var23 = null;
      }

      try {
         var24 = (NumberPicker)this.findViewById(var23.getInt(null));
      } catch (IllegalArgumentException var14) {
         var24 = null;
      } catch (IllegalAccessException var15) {
         var24 = null;
      }

      try {
         var25 = var3.getField("year");
      } catch (NoSuchFieldException var13) {
         var25 = null;
      }

      try {
         var26 = (NumberPicker)this.findViewById(var25.getInt(null));
      } catch (IllegalArgumentException var11) {
         var26 = null;
      } catch (IllegalAccessException var12) {
         var26 = null;
      }

      Class var4;
      try {
         var4 = Class.forName("android.widget.NumberPicker");
      } catch (ClassNotFoundException var10) {
         var4 = null;
      }

      try {
         var27 = var4.getDeclaredField("mSelectionDivider");
      } catch (NoSuchFieldException var9) {
         var27 = (Field)var5;
      }

      try {
         var27.setAccessible(true);
         var5 = new ColorDrawable(0);
         var27.set(var22, var5);
         var5 = new ColorDrawable(0);
         var27.set(var24, var5);
         var5 = new ColorDrawable(0);
         var27.set(var26, var5);
         this.a(var24);
         this.a(var22);
         this.a(var26);
      } catch (IllegalArgumentException var6) {
      } catch (NotFoundException var7) {
      } catch (IllegalAccessException var8) {
      }
   }

   private float a(Context var1, float var2) {
      return var1.getResources().getDisplayMetrics().scaledDensity * var2;
   }

   private void a(NumberPicker var1) {
      var1.setDescendantFocusability(393216);

      for (int var2 = 0; var2 < this.getChildCount(); var2++) {
         View var3 = var1.getChildAt(var2);
         if (var3 instanceof EditText) {
            try {
               Field var4 = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
               var4.setAccessible(true);
               Paint var9 = (Paint)var4.get(var1);
               var9.setColor(ImageUtils.b(this.getContext(), 17170444));
               var9.setTextSize(this.a(this.getContext(), 18.0F));
               var9.setTypeface(ProximaHelper.a);
               EditText var8 = (EditText)var3;
               var8.setTextColor(ImageUtils.b(this.getContext(), 17170444));
               var8.setTextSize(18.0F);
               var9.setTypeface(ProximaHelper.a);
               var1.invalidate();
               break;
            } catch (NoSuchFieldException var5) {
            } catch (IllegalAccessException var6) {
            } catch (IllegalArgumentException var7) {
            }
         }
      }
   }
}
