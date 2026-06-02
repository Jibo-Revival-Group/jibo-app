package com.salesforce.android.service.common.http.okhttp;

import com.salesforce.android.service.common.http.HttpUrl;

public class SalesforceHttpUrl implements HttpUrl {
   private okhttp3.HttpUrl a;

   protected SalesforceHttpUrl(okhttp3.HttpUrl var1) {
      this.a = var1;
   }

   public static SalesforceHttpUrl a(okhttp3.HttpUrl var0) {
      return new SalesforceHttpUrl(var0);
   }

   @Override
   public okhttp3.HttpUrl a() {
      return this.a;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (var1 instanceof HttpUrl && this.a.equals(((HttpUrl)var1).a())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }

   @Override
   public String toString() {
      return this.a.toString();
   }
}
