package com.jibo.aws.integration.aws.services.push.model;

import com.jibo.aws.integration.aws.services.common.model.NameRequestAbstract;

public class NameRequest extends NameRequestAbstract {
   public NameRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServiceAbbr() {
      return "push";
   }

   @Override
   public String getServicePrefix() {
      return "Push_20160729.";
   }
}
