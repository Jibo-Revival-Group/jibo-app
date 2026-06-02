package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import com.salesforce.android.service.common.ui.R;

public class SalesforceTextInputLayout extends TextInputLayout {
   private EditText e;

   public SalesforceTextInputLayout(Context var1) {
      this(var1, null);
   }

   public SalesforceTextInputLayout(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.salesforceTextInputLayoutStyle);
   }

   public SalesforceTextInputLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
   }

   private void a() {
      LayoutInflater.from(this.getContext()).inflate(R.layout.salesforce_text_input_layout_edit_text, this, true);
      this.e = (EditText)this.findViewById(R.id.text_input_layout_edit_text);
   }

   @Override
   public EditText getEditText() {
      return this.e;
   }

   @Override
   public void setHint(CharSequence var1) {
      super.setHint(var1);
      if (this.e != null) {
         this.e.setHint(var1);
      }
   }
}
