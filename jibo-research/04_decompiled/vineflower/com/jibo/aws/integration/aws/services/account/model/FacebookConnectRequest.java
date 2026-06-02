package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class FacebookConnectRequest extends JiboAccountRequest {
   @Expose
   private String state;
   @Expose
   private String token;

   public FacebookConnectRequest(String var1, String var2) {
      this.state = var1;
      this.token = var2;
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
            if (var1 instanceof FacebookConnectRequest) {
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

                  if (var1.getState() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getState() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getState() != null) {
                        var4 = var5;
                        if (!var1.getState().equals(this.getState())) {
                           return var4;
                        }
                     }

                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   public String getState() {
      return this.state;
   }

   public String getToken() {
      return this.token;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getState() == null) {
         var1 = 0;
      } else {
         var1 = this.getState().hashCode();
      }

      if (this.getToken() != null) {
         var2 = this.getToken().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setState(String var1) {
      this.state = var1;
   }

   public void setToken(String var1) {
      this.token = var1;
   }

   @Override
   public String toString() {
      return "FacebookConnectRequest {state='" + this.state + '\'' + ", token='" + this.token + '\'' + '}';
   }
}
