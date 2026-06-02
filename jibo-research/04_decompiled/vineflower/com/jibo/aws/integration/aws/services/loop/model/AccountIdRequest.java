package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.IdRequestAbstract;

public class AccountIdRequest extends IdRequestAbstract {
   @Expose
   private String accountId;

   public AccountIdRequest(String var1) {
      super(var1);
   }

   @Override
   public String getId() {
      return this.accountId;
   }

   @Override
   public String getServiceAbbr() {
      return "loop";
   }

   @Override
   public String getServicePrefix() {
      return "Loop_20160324.";
   }

   @Override
   public void setId(String var1) {
      this.accountId = var1;
   }

   @Override
   public String toString() {
      return "AccountIdRequest {accountId='" + this.accountId + '\'' + '}';
   }
}
