package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.common.model.EmptyRequest;

public class RemovePhotoRequest extends EmptyRequest {
   @Override
   public String getServiceAbbr() {
      return "account";
   }

   @Override
   public String getServicePrefix() {
      return "Account_20151111.";
   }
}
