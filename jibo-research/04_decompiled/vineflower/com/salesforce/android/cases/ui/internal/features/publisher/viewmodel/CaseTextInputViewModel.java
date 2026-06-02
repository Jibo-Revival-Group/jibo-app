package com.salesforce.android.cases.ui.internal.features.publisher.viewmodel;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseFieldType;
import com.salesforce.android.cases.ui.internal.utils.ViewUtils;
import com.salesforce.android.service.common.ui.views.SalesforceTextInputLayout;

public class CaseTextInputViewModel implements TextWatcher, OnFocusChangeListener, CaseFieldViewModel<SalesforceTextInputLayout> {
   private SalesforceTextInputLayout a;
   private EditText b;
   private CaseField c;
   private String d = "";
   private boolean e;

   public CaseTextInputViewModel(SalesforceTextInputLayout var1, CaseField var2) {
      CaseFieldType var3 = var2.f();
      if (var3 != CaseFieldType.TEXT && var3 != CaseFieldType.EMAIL && var3 != CaseFieldType.TEXT_AREA) {
         throw new IllegalArgumentException("CaseField must be of type CaseFieldType.TEXT, CaseFieldType.EMAIL or CaseFieldType.TEXT_AREA.");
      }

      this.a = var1;
      this.c = var2;
      String var4 = var2.b();
      String var6 = var4;
      if (var2.d()) {
         var6 = var4 + "*";
      }

      var1.setHint(var6);
      var1.setCounterMaxLength(var2.g());
      this.b = var1.getEditText();
      this.b.setId(var2.a().hashCode());
      String var5 = var2.h();
      if (StringUtils.b(var5)) {
         this.b.setText(var5);
         this.d = var5;
      }

      this.b.setOnFocusChangeListener(this);
      this.b.addTextChangedListener(this);
      if (CaseFieldType.EMAIL == var2.f()) {
         this.b.setInputType(209);
         this.b.setMaxLines(1);
      } else if (CaseFieldType.TEXT_AREA == var2.f()) {
         this.b.setInputType(147457);
      } else {
         this.b.setInputType(16385);
         this.b.setMaxLines(1);
      }
   }

   public void afterTextChanged(Editable var1) {
      CharSequence var2 = this.a.getError();
      if (var2 != null && !StringUtils.a(var2.toString())) {
         this.a.setError(null);
         this.a.setErrorEnabled(false);
      }

      if (!this.d.equals(var1.toString())) {
         this.e = true;
      }

      this.d = var1.toString();
   }

   @Override
   public boolean b() {
      return this.b.isFocused();
   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }

   @Override
   public void c() {
      ViewUtils.d(this.b);
   }

   @Override
   public CaseField d() {
      return this.c;
   }

   @Override
   public boolean e() {
      boolean var1 = false;
      boolean var2 = this.c.d();
      String var3 = this.f();
      Resources var4 = this.b.getResources();
      if (StringUtils.a(var3)) {
         if (var2) {
            this.a.setError(var4.getString(R.string.cases_validation_error_field_required_text, new Object[]{this.c.b()}));
            return var1;
         }
      } else {
         if (CaseFieldType.EMAIL == this.c.f() && !Patterns.EMAIL_ADDRESS.matcher(var3).matches()) {
            this.a.setError(var4.getString(R.string.cases_validation_error_invalid_field_text, new Object[]{this.c.b()}));
            return var1;
         }

         if (var3.length() > this.c.g()) {
            this.a.setError(var4.getString(R.string.cases_validation_error_length_invalid_text));
            return var1;
         }
      }

      return true;
   }

   @Override
   public String f() {
      return this.b.getText().toString().trim();
   }

   @Override
   public boolean g() {
      return this.e;
   }

   public SalesforceTextInputLayout h() {
      return this.a;
   }

   public void onFocusChange(View var1, boolean var2) {
      this.a.setCounterEnabled(var2);
   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
   }
}
