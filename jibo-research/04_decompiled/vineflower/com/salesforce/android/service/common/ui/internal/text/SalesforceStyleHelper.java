package com.salesforce.android.service.common.ui.internal.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.salesforce.android.service.common.ui.R;

public class SalesforceStyleHelper {
   private final Context a;
   private final AttributeSet b;
   private final Typeface c;
   private StyleSpan d;

   SalesforceStyleHelper(Context var1, AttributeSet var2) {
      this.a = var1;
      this.b = var2;
      this.c = this.a();
   }

   public static SalesforceStyleHelper a(Context var0, AttributeSet var1) {
      return new SalesforceStyleHelper(var0, var1);
   }

   int a(TypedArray var1, int var2) {
      return var1.getInt(var2, 0);
   }

   Typeface a() {
      TypedArray var1 = this.c();
      TypedArray var2 = this.d();

      Typeface var4;
      try {
         var4 = this.a(var1);
         StyleSpan var3 = new StyleSpan(this.a(var2, this.e()));
         this.d = var3;
      } finally {
         var1.recycle();
         var2.recycle();
      }

      return var4;
   }

   Typeface a(TypedArray var1) {
      String var2 = var1.getString(R.styleable.SalesforceTextView_salesforceFont);
      Typeface var3;
      if (var2 != null && !var2.isEmpty()) {
         var3 = TypefaceFactory.a(this.a.getAssets(), var2);
      } else {
         var3 = null;
      }

      return var3;
   }

   public CharSequence a(CharSequence var1) {
      if (this.d != null && var1 != null && var1.length() >= 1) {
         if (!(var1 instanceof Spannable)) {
            var1 = new SpannableString(var1);
         }

         this.a((Spannable)var1, this.d);
      }

      return var1;
   }

   void a(Spannable var1, StyleSpan var2) {
      var1.setSpan(var2, 0, var1.length(), 33);
   }

   public Typeface b() {
      return this.c;
   }

   TypedArray c() {
      return this.a.getTheme().obtainStyledAttributes(this.b, R.styleable.SalesforceTextView, R.attr.salesforceFontStyle, 0);
   }

   TypedArray d() {
      return this.a.obtainStyledAttributes(this.b, new int[]{16842903});
   }

   int e() {
      TypedValue var1 = new TypedValue();
      this.a.getTheme().resolveAttribute(16842903, var1, true);
      return var1.data;
   }
}
