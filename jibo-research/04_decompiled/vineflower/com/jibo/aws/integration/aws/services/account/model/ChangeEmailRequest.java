package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class ChangeEmailRequest extends JiboAccountRequest {
   @Expose
   private String email;
   @Expose
   private String password;

   public ChangeEmailRequest(String var1, String var2) {
      this.email = var1;
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
            if (var1 instanceof ChangeEmailRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getPassword() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

                  if (var1.getEmail() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getEmail() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getEmail() != null) {
                        var4 = var5;
                        if (!var1.getEmail().equals(this.getEmail())) {
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

   public String getEmail() {
      return this.email;
   }

   public String getPassword() {
      return this.password;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getPassword() == null) {
         var1 = 0;
      } else {
         var1 = this.getPassword().hashCode();
      }

      if (this.getEmail() != null) {
         var2 = this.getEmail().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "password='" + this.password + '\'' + ", email='" + this.email + '\'' + '}';
   }
}
