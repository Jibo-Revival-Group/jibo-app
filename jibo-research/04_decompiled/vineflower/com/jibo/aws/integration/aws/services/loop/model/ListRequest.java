package com.jibo.aws.integration.aws.services.loop.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public class ListRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "loop";
   }

   @Override
   public String getServiceMethodName() {
      return "ListLoops";
   }

   @Override
   public String getServicePrefix() {
      return "Loop_20160324.";
   }
}
