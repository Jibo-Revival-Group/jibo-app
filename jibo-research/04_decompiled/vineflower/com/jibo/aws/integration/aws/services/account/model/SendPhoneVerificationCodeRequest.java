package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class SendPhoneVerificationCodeRequest extends JiboAccountRequest {
   @Expose
   private String phoneNumber;

   public SendPhoneVerificationCodeRequest(String var1) {
      this.phoneNumber = var1;
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
            if (var1 instanceof SendPhoneVerificationCodeRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getPhoneNumber() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getPhoneNumber() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getPhoneNumber() != null) {
                     var4 = var5;
                     if (!var1.getPhoneNumber().equals(this.getPhoneNumber())) {
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

   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getPhoneNumber() == null) {
         var1 = 0;
      } else {
         var1 = this.getPhoneNumber().hashCode();
      }

      return var1 + 31;
   }

   public void setPhoneNumber(String var1) {
      this.phoneNumber = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "phoneNumber='" + this.phoneNumber + '\'' + '}';
   }
}
