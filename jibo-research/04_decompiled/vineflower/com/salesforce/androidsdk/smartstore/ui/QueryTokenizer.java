package com.salesforce.androidsdk.smartstore.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView.Tokenizer;

class QueryTokenizer implements Tokenizer {
   public int findTokenEnd(CharSequence var1, int var2) {
      int var3 = var1.length();

      while (true) {
         if (var2 >= var3) {
            var2 = var3;
            break;
         }

         if (var1.charAt(var2) == ' ') {
            break;
         }

         var2++;
      }

      return var2;
   }

   public int findTokenStart(CharSequence var1, int var2) {
      while (var2 > 0 && var1.charAt(var2 - 1) != ' ') {
         var2--;
      }

      return var2;
   }

   public CharSequence terminateToken(CharSequence var1) {
      int var2 = var1.length();

      while (var2 > 0 && var1.charAt(var2 - 1) == ' ') {
         var2--;
      }

      Object var3;
      if (var2 > 0 && var1.charAt(var2 - 1) == ' ') {
         var3 = var1;
      } else {
         var3 = var1;
         if (var1 instanceof Spanned) {
            var3 = new SpannableString(var1 + " ");
            TextUtils.copySpansFrom((Spanned)var1, 0, var1.length(), Object.class, (Spannable)var3, 0);
         }
      }

      return (CharSequence)var3;
   }
}
