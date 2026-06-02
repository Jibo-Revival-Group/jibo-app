package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class FacebookMobileConnectRequest extends JiboAccountRequest {
   @Expose
   private String token;

   public FacebookMobileConnectRequest(String var1) {
      this.token = var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var5 = false;
      boolean var4;
      if (this == var1) {
         var4 = true;
      } else {
         var4 = var5;
         if (var1 != null) {
            var4 = var5;
            if (var1 instanceof FacebookMobileConnectRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getToken() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getToken() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getToken() != null) {
                     var4 = var5;
                     if (!var1.getToken().equals(this.getToken())) {
                        return var4;
                     }
                  }

                  var4 = true;
               }
            }
         }
      }

      return var4;
   }

   public String getToken() {
      return this.token;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getToken() == null) {
         var1 = 0;
      } else {
         var1 = this.getToken().hashCode();
      }

      return var1 + 31;
   }

   public void setToken(String var1) {
      this.token = var1;
   }

   @Override
   public String toString() {
      return "FacebookConnectRequest {token='" + this.token + '\'' + '}';
   }
}
