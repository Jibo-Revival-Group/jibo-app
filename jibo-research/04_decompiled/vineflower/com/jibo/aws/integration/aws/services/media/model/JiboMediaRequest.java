package com.jibo.aws.integration.aws.services.media.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboMediaRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "media";
   }

   @Override
   public String getServicePrefix() {
      return "Media_20160725.";
   }
}
