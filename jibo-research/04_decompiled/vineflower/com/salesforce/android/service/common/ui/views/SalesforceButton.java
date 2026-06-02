package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.text.SalesforceStyleHelper;

public class SalesforceButton extends AppCompatButton {
   private final SalesforceStyleHelper b;

   public SalesforceButton(Context var1) {
      super(var1);
      this.b = null;
   }

   public SalesforceButton(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.buttonStyle);
   }

   public SalesforceButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.b = SalesforceStyleHelper.a(var1, var2);
      this.setTypeface(this.b.b());
      super.setText(this.b.a(this.getText()));
   }

   public void setText(CharSequence var1, BufferType var2) {
      CharSequence var3 = var1;
      if (this.b != null) {
         var3 = this.b.a(var1);
      }

      super.setText(var3, var2);
   }
}
