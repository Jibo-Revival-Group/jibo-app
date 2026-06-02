package com.jibo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class MessageInputEditText extends EditText {
   public MessageInputEditText(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public MessageInputEditText(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public InputConnection onCreateInputConnection(EditorInfo var1) {
      InputConnection var3 = super.onCreateInputConnection(var1);
      int var2 = var1.imeOptions & 0xFF;
      if ((var2 & 4) != 0) {
         var1.imeOptions ^= var2;
         var1.imeOptions |= 4;
      }

      if ((var1.imeOptions & 1073741824) != 0) {
         var1.imeOptions &= -1073741825;
      }

      return var3;
   }
}
