package com.salesforce.android.service.common.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.salesforce.android.service.common.ui.R;

public class SalesforceTitleTextToolbar extends Toolbar {
   private SalesforceTextView a;

   public SalesforceTitleTextToolbar(Context var1) {
      this(var1, null);
   }

   public SalesforceTitleTextToolbar(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.toolbarStyle);
   }

   public SalesforceTitleTextToolbar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var1, var2, var3);
   }

   private void a(Context var1, AttributeSet var2, int var3) {
      LayoutInflater.from(this.getContext()).inflate(R.layout.salesforce_toolbar_title_text_view, this, true);
      this.a = (SalesforceTextView)this.findViewById(R.id.salesforce_toolbar_title);
      TypedArray var4 = var1.getTheme().obtainStyledAttributes(var2, R.styleable.SalesforceTitleTextToolbar, var3, 0);
      CharSequence var5 = var4.getText(R.styleable.SalesforceTitleTextToolbar_salesforce_title_text);
      if (!TextUtils.isEmpty(var5)) {
         this.setTitleText(var5);
      }

      var4.recycle();
   }

   public void setTitleText(int var1) {
      this.a.setText(var1);
   }

   public void setTitleText(CharSequence var1) {
      this.a.setText(var1);
   }
}
