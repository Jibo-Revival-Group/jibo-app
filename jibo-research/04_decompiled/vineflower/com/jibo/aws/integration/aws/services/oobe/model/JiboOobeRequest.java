package com.jibo.aws.integration.aws.services.oobe.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboOobeRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "oobe";
   }

   @Override
   public String getServicePrefix() {
      return "OOBE_20161026.";
   }
}
