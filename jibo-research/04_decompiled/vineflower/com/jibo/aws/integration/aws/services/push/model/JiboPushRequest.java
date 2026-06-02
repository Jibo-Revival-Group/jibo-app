package com.jibo.aws.integration.aws.services.push.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboPushRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "push";
   }

   @Override
   public String getServicePrefix() {
      return "Push_20160729.";
   }
}
