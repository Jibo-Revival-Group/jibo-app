package com.jibo.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.jibo.R;
import java.lang.reflect.Field;

public class MaterialNumberPicker extends NumberPicker {
   private int a;
   private float b;

   public MaterialNumberPicker(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a();
      TypedArray var5 = var1.obtainStyledAttributes(var2, R.styleable.MaterialNumberPicker);

      for (int var3 = 0; var3 < var5.getIndexCount(); var3++) {
         int var4 = var5.getIndex(var3);
         if (var4 == 1) {
            this.setTextSize(var5.getDimension(var4, 18.0F));
         } else if (var4 == 0) {
            this.setTextColor(var5.getColor(var4, var1.getColor(2131099679)));
         }
      }

      var5.recycle();
   }

   private float a(Context var1, float var2) {
      return var1.getResources().getDisplayMetrics().scaledDensity * var2;
   }

   private void a() {
      this.setSeparatorColor(0);
      this.setTextColor(this.getContext().getResources().getColor(2131099679));
      this.setTextSize(18.0F);
      this.setWrapSelectorWheel(false);
      this.setFocusability(false);

      try {
         Field var1 = NumberPicker.class.getDeclaredField("mInputText");
         var1.setAccessible(true);
         EditText var5 = (EditText)var1.get(this);
         var5.setTextColor(this.a);
         var5.setTextSize(this.b);
         var5.setFilters(new InputFilter[0]);
      } catch (NoSuchFieldException var2) {
      } catch (IllegalAccessException var3) {
      } catch (IllegalArgumentException var4) {
      }
   }

   private void b() {
      for (int var1 = 0; var1 < this.getChildCount(); var1++) {
         View var2 = this.getChildAt(var1);
         if (var2 instanceof EditText) {
            try {
               Field var3 = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
               var3.setAccessible(true);
               Paint var8 = (Paint)var3.get(this);
               var8.setColor(this.a);
               var8.setTextSize(this.a(this.getContext(), this.b));
               EditText var7 = (EditText)var2;
               var7.setTextColor(this.a);
               var7.setTextSize(this.b);
               this.invalidate();
               break;
            } catch (NoSuchFieldException var4) {
            } catch (IllegalAccessException var5) {
            } catch (IllegalArgumentException var6) {
            }
         }
      }
   }

   private void setFocusability(boolean var1) {
      int var2;
      if (var1) {
         var2 = 262144;
      } else {
         var2 = 393216;
      }

      this.setDescendantFocusability(var2);
   }

   public void setSeparatorColor(int var1) {
      for (Field var4 : NumberPicker.class.getDeclaredFields()) {
         if (var4.getName().equals("mSelectionDivider")) {
            var4.setAccessible(true);

            try {
               ColorDrawable var8 = new ColorDrawable(var1);
               var4.set(this, var8);
            } catch (IllegalAccessException var6) {
            } catch (IllegalArgumentException var7) {
            }
            break;
         }
      }
   }

   public void setTextColor(int var1) {
      this.a = var1;
      this.b();
   }

   public void setTextSize(float var1) {
      this.b = var1;
      this.b();
   }
}
