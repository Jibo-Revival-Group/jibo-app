package com.salesforce.androidsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.widget.RadioButton;
import android.widget.TextView.BufferType;
import com.salesforce.androidsdk.accounts.UserAccount;

public class SalesforceAccountRadioButton extends RadioButton {
   private Context a;
   private UserAccount b;

   public SalesforceAccountRadioButton(Context var1, UserAccount var2) {
      super(var1);
      this.a = var1;
      this.b = var2;
      this.a();
   }

   public void a() {
      SpannableStringBuilder var1 = new SpannableStringBuilder();
      if (this.b != null && this.b.h() != null && this.b.c() != null) {
         String var4 = this.b.h();
         String var3 = this.b.c();
         SpannableString var2 = new SpannableString(var4);
         var2.setSpan(new TextAppearanceSpan(this.a, 16973892), 0, var4.length(), 33);
         SpannableString var5 = new SpannableString(var3);
         var5.setSpan(new TextAppearanceSpan(this.a, 16973894), 0, var3.length(), 33);
         var1.append(var2);
         var1.append(System.getProperty("line.separator"));
         var1.append(var5);
      }

      super.setText(var1, BufferType.SPANNABLE);
   }

   public UserAccount getAccount() {
      return this.b;
   }
}
