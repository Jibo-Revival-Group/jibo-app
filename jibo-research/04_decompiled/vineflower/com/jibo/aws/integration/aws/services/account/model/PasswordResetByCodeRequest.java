package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class PasswordResetByCodeRequest extends JiboAccountRequest {
   @Expose
   private String code;
   @Expose
   private String password;

   public PasswordResetByCodeRequest(String var1, String var2) {
      this.code = var1;
      this.password = var2;
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
            if (var1 instanceof PasswordResetByCodeRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getCode() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getCode() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getCode() != null) {
                     var4 = var5;
                     if (!var1.getCode().equals(this.getCode())) {
                        return var4;
                     }
                  }

                  if (var1.getPassword() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getPassword() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getPassword() != null) {
                        var4 = var5;
                        if (!var1.getPassword().equals(this.getPassword())) {
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

   public String getCode() {
      return this.code;
   }

   public String getPassword() {
      return this.password;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getCode() == null) {
         var1 = 0;
      } else {
         var1 = this.getCode().hashCode();
      }

      if (this.getPassword() != null) {
         var2 = this.getPassword().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "code='" + this.code + '\'' + "password='" + this.password + '\'' + '}';
   }
}
