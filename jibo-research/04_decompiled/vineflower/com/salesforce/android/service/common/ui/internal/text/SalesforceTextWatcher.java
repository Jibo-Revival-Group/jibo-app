package com.salesforce.android.service.common.ui.internal.text;

import android.text.Editable;
import android.text.TextWatcher;

public class SalesforceTextWatcher implements TextWatcher {
   private SalesforceTextWatcher.OnBeforeTextChangedListener a;
   private SalesforceTextWatcher.OnTextChangedListener b;
   private SalesforceTextWatcher.OnAfterTextChangedListener c;

   public void a(SalesforceTextWatcher.OnAfterTextChangedListener var1) {
      this.c = var1;
   }

   public void afterTextChanged(Editable var1) {
      if (this.c != null) {
         this.c.a(var1);
      }
   }

   public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      if (this.a != null) {
         this.a.a(var1, var2, var3, var4);
      }
   }

   public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      if (this.b != null) {
         this.b.a(var1, var2, var3, var4);
      }
   }

   public interface OnAfterTextChangedListener {
      void a(Editable var1);
   }

   public interface OnBeforeTextChangedListener {
      void a(CharSequence var1, int var2, int var3, int var4);
   }

   public interface OnTextChangedListener {
      void a(CharSequence var1, int var2, int var3, int var4);
   }
}
