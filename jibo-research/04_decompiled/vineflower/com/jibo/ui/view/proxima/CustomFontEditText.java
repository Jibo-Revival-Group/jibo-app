package com.jibo.ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import com.jibo.R;

public class CustomFontEditText extends EditText {
   private static final String a = CustomFontEditText.class.getSimpleName();

   public CustomFontEditText(Context var1) {
      super(var1);
   }

   public CustomFontEditText(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2);
   }

   public CustomFontEditText(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2);
   }

   private void a(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.CustomFont);
      ProximaHelper.a(this, var3.getString(0));
      var3.recycle();
   }

   public static class NameInputFilter implements InputFilter {
      private boolean a(char var1) {
         boolean var2;
         if ((var1 < 'A' || var1 > 'Z') && (var1 < 'a' || var1 > 'z')) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      public CharSequence filter(CharSequence var1, int var2, int var3, Spanned var4, int var5, int var6) {
         CharSequence var10;
         if (var1 instanceof SpannableStringBuilder) {
            SpannableStringBuilder var8 = (SpannableStringBuilder)var1;
            var3--;

            while (true) {
               var10 = var1;
               if (var3 < var2) {
                  break;
               }

               char var7 = var1.charAt(var3);
               if (!this.a(var7) && !Character.isSpaceChar(var7) && var7 != '-' && var7 != '\'') {
                  var8.delete(var3, var3 + 1);
               }

               var3--;
            }
         } else {
            StringBuilder var11 = new StringBuilder();

            while (var2 < var3) {
               char var12 = var1.charAt(var2);
               if (this.a(var12) || Character.isSpaceChar(var12) || var12 == '-' || var12 == '\'') {
                  var11.append(var12);
               }

               var2++;
            }

            var10 = var11.toString();
         }

         return var10;
      }
   }
}
