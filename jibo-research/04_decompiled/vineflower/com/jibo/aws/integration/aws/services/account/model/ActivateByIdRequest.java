package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.common.model.IdRequest;

public class ActivateByIdRequest extends IdRequest {
   public ActivateByIdRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServiceAbbr() {
      return "account";
   }

   @Override
   public String getServicePrefix() {
      return "Account_20151111.";
   }
}
