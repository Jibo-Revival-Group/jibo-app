package com.jibo.aws.integration.aws.services.account.model;

import com.google.gson.annotations.Expose;

public class ChangePasswordRequest extends JiboAccountRequest {
   @Expose
   private String newPassword;
   @Expose
   private String oldPassword;

   public ChangePasswordRequest(String var1, String var2) {
      this.oldPassword = var1;
      this.newPassword = var2;
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
            if (var1 instanceof ChangePasswordRequest) {
               var1 = var1;
               boolean var2;
               if (var1.getOldPassword() == null) {
                  var2 = true;
               } else {
                  var2 = false;
               }

               boolean var3;
               if (this.getOldPassword() == null) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var4 = var5;
               if (!(var2 ^ var3)) {
                  if (var1.getOldPassword() != null) {
                     var4 = var5;
                     if (!var1.getOldPassword().equals(this.getOldPassword())) {
                        return var4;
                     }
                  }

                  if (var1.getNewPassword() == null) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  if (this.getNewPassword() == null) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  var4 = var5;
                  if (!(var2 ^ var3)) {
                     if (var1.getNewPassword() != null) {
                        var4 = var5;
                        if (!var1.getNewPassword().equals(this.getNewPassword())) {
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

   public String getNewPassword() {
      return this.newPassword;
   }

   public String getOldPassword() {
      return this.oldPassword;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.getOldPassword() == null) {
         var1 = 0;
      } else {
         var1 = this.getOldPassword().hashCode();
      }

      if (this.getNewPassword() != null) {
         var2 = this.getNewPassword().hashCode();
      }

      return (var1 + 31) * 31 + var2;
   }

   public void setNewPassword(String var1) {
      this.newPassword = var1;
   }

   public void setOldPassword(String var1) {
      this.oldPassword = var1;
   }

   @Override
   public String toString() {
      return this.getClass().getSimpleName() + " {" + "oldPassword='" + this.oldPassword + '\'' + ", newPassword='" + this.newPassword + '\'' + '}';
   }
}
