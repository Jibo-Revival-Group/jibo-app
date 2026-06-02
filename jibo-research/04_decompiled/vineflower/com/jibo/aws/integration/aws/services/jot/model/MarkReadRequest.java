package com.jibo.aws.integration.aws.services.jot.model;

import com.jibo.aws.integration.aws.services.common.model.IdsRequestAbstract;
import java.util.List;

public class MarkReadRequest extends IdsRequestAbstract {
   public MarkReadRequest(List<String> var1) {
      super(var1);
   }

   @Override
   public String getServiceAbbr() {
      return "jot";
   }

   @Override
   public String getServicePrefix() {
      return "Jot_20160126.";
   }
}
