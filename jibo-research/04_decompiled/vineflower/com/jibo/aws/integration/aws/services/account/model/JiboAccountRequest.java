package com.jibo.aws.integration.aws.services.account.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboAccountRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "account";
   }

   @Override
   public String getServicePrefix() {
      return "Account_20151111.";
   }
}
