package com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException extends IOException {
   protected JsonLocation a;

   protected JsonProcessingException(String var1, JsonLocation var2) {
      this(var1, var2, null);
   }

   protected JsonProcessingException(String var1, JsonLocation var2, Throwable var3) {
      super(var1);
      if (var3 != null) {
         this.initCause(var3);
      }

      this.a = var2;
   }

   public JsonLocation a() {
      return this.a;
   }

   protected String b() {
      return null;
   }

   @Override
   public String getMessage() {
      String var2 = super.getMessage();
      String var1 = var2;
      if (var2 == null) {
         var1 = "N/A";
      }

      JsonLocation var3 = this.a();
      String var4 = this.b();
      if (var3 == null) {
         var2 = var1;
         if (var4 == null) {
            return var2;
         }
      }

      StringBuilder var6 = new StringBuilder(100);
      var6.append(var1);
      if (var4 != null) {
         var6.append(var4);
      }

      if (var3 != null) {
         var6.append('\n');
         var6.append(" at ");
         var6.append(var3.toString());
      }

      return var6.toString();
   }

   @Override
   public String toString() {
      return this.getClass().getName() + ": " + this.getMessage();
   }
}
