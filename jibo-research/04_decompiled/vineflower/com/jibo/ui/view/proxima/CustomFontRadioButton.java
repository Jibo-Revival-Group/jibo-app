package com.jibo.ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.jibo.R;

public class CustomFontRadioButton extends AppCompatRadioButton {
   private static final String a = CustomFontRadioButton.class.getSimpleName();

   public CustomFontRadioButton(Context var1) {
      super(var1);
   }

   public CustomFontRadioButton(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var1, var2);
   }

   public CustomFontRadioButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2);
   }

   private void a(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.CustomFont);
      ProximaHelper.a(this, var3.getString(0));
      var3.recycle();
   }

   public void setOnCheckedChangeListener(OnCheckedChangeListener var1) {
      super.setOnCheckedChangeListener(var1);
   }
}
