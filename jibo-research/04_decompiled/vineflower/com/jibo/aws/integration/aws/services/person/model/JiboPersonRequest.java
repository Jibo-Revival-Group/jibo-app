package com.jibo.aws.integration.aws.services.person.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboPersonRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "person";
   }

   @Override
   public String getServicePrefix() {
      return "Person_20160801.";
   }
}
