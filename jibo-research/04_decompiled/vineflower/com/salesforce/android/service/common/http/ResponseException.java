package com.salesforce.android.service.common.http;

public class ResponseException extends Exception {
   final int a;
   final String b;

   public ResponseException(String var1, int var2, String var3) {
      super(var1);
      this.a = var2;
      this.b = var3;
   }

   public int a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }
}
