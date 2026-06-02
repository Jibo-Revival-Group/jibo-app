package com.jibo.aws.integration.aws.services.key.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboKeyRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "key";
   }

   @Override
   public String getServicePrefix() {
      return "Key_20160201.";
   }
}
