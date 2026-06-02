package com.salesforce.android.service.common.ui.internal.text;

import android.text.GetChars;
import android.text.Spannable;

public class SpannableString implements GetChars, Spannable, CharSequence {
   private android.text.SpannableString a;

   public SpannableString(CharSequence var1) {
      this.a = new android.text.SpannableString(var1);
   }

   @Override
   public char charAt(int var1) {
      return this.a.charAt(var1);
   }

   @Override
   public boolean equals(Object var1) {
      return this.a.equals(var1);
   }

   public void getChars(int var1, int var2, char[] var3, int var4) {
      this.a.getChars(var1, var2, var3, var4);
   }

   public int getSpanEnd(Object var1) {
      return this.a.getSpanEnd(var1);
   }

   public int getSpanFlags(Object var1) {
      return this.a.getSpanFlags(var1);
   }

   public int getSpanStart(Object var1) {
      return this.a.getSpanStart(var1);
   }

   public <T> T[] getSpans(int var1, int var2, Class<T> var3) {
      return (T[])this.a.getSpans(var1, var2, var3);
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }

   @Override
   public int length() {
      return this.a.length();
   }

   public int nextSpanTransition(int var1, int var2, Class var3) {
      return this.a.nextSpanTransition(var1, var2, var3);
   }

   public void removeSpan(Object var1) {
      this.a.removeSpan(var1);
   }

   public void setSpan(Object var1, int var2, int var3, int var4) {
      this.a.setSpan(var1, var2, var3, var4);
   }

   @Override
   public CharSequence subSequence(int var1, int var2) {
      return this.a.subSequence(var1, var2);
   }

   @Override
   public String toString() {
      return this.a.toString();
   }
}
