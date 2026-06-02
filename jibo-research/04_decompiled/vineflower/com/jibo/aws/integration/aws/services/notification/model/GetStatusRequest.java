package com.jibo.aws.integration.aws.services.notification.model;

import com.google.gson.annotations.Expose;

public class GetStatusRequest extends JiboNotificationRequest {
   @Expose
   private String accountId;

   public GetStatusRequest(String var1) {
      this.accountId = var1;
   }

   public String getAccountId() {
      return this.accountId;
   }

   @Override
   public int hashCode() {
      int var1;
      if (this.getAccountId() == null) {
         var1 = 0;
      } else {
         var1 = this.getAccountId().hashCode();
      }

      return var1 + 31;
   }

   public void setAccountId(String var1) {
      this.accountId = var1;
   }
}
