package com.jibo.aws.integration.aws.services.gqa.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class GQABaseRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "gqa";
   }

   @Override
   public String getServicePrefix() {
      return "GQA_20160930s.";
   }
}
