package com.salesforce.androidsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.widget.RadioButton;
import android.widget.TextView.BufferType;

public class SalesforceServerRadioButton extends RadioButton {
   private Context a;
   private String b;
   private String c;
   private boolean d;

   public SalesforceServerRadioButton(Context var1, String var2, String var3, boolean var4) {
      super(var1);
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.a();
   }

   public void a() {
      SpannableStringBuilder var2 = new SpannableStringBuilder();
      if (this.b != null && this.c != null) {
         SpannableString var3 = new SpannableString(this.b);
         var3.setSpan(new TextAppearanceSpan(this.a, 16973892), 0, this.b.length(), 33);
         SpannableString var1 = new SpannableString(this.c);
         var1.setSpan(new TextAppearanceSpan(this.a, 16973894), 0, this.c.length(), 33);
         var2.append(var3);
         var2.append(System.getProperty("line.separator"));
         var2.append(var1);
      }

      super.setText(var2, BufferType.SPANNABLE);
   }

   public boolean b() {
      return this.d;
   }

   public String getName() {
      return this.b;
   }

   public String getUrl() {
      return this.c;
   }
}
