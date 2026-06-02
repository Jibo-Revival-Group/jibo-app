package com.jibo.ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.jibo.R;

public class CustomFontAutoCompleteTextView extends AutoCompleteTextView {
   private static final String a = CustomFontAutoCompleteTextView.class.getSimpleName();

   public CustomFontAutoCompleteTextView(Context var1) {
      super(var1);
   }

   public CustomFontAutoCompleteTextView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2);
   }

   public CustomFontAutoCompleteTextView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2);
   }

   private void a(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.CustomFont);
      ProximaHelper.a(this, var3.getString(0));
      var3.recycle();
   }
}
