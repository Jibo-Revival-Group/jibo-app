package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.text.SalesforceStyleHelper;

public class SalesforceEditText extends TextInputEditText {
   public SalesforceEditText(Context var1) {
      super(var1);
   }

   public SalesforceEditText(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.editTextStyle);
   }

   public SalesforceEditText(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      SalesforceStyleHelper var4 = SalesforceStyleHelper.a(var1, var2);
      this.setTypeface(var4.b());
      this.setText(var4.a(this.getText()));
      this.addTextChangedListener(new TextWatcher(this, var4) {
         final SalesforceStyleHelper a;
         final SalesforceEditText b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void afterTextChanged(Editable var1) {
            this.a.a(var1);
         }

         public void beforeTextChanged(CharSequence var1, int var2x, int var3x, int var4x) {
         }

         public void onTextChanged(CharSequence var1, int var2x, int var3x, int var4x) {
         }
      });
   }
}
