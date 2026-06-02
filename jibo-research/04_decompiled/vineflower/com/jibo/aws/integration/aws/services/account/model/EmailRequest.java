package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class EmailRequest extends JiboAccountRequest {
   @Expose
   private String email;

   public EmailRequest(String var1) {
      this.email = var1;
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
            if (var1 instanceof EmailRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getEmail() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
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

      return var4;
   }

   public String getEmail() {
      return this.email;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getEmail() == null) {
         var1 = 0;
      } else {
         var1 = this.getEmail().hashCode();
      }

      return var1 + 31;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "email='" + this.email + '\'' + '}';
   }
}
