package com.google.android.gms.common.api;

public class ApiException extends Exception {
   protected final Status a;

   public ApiException(Status var1) {
      int var2 = var1.d();
      String var3;
      if (var1.b() != null) {
         var3 = var1.b();
      } else {
         var3 = "";
      }

      super(new StringBuilder(String.valueOf(var3).length() + 13).append(var2).append(": ").append(var3).toString());
      this.a = var1;
   }
}
