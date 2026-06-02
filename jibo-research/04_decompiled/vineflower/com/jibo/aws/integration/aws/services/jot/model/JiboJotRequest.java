package com.jibo.aws.integration.aws.services.jot.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboJotRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "jot";
   }

   @Override
   public String getServicePrefix() {
      return "Jot_20160126.";
   }
}
