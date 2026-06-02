package com.jibo.aws.integration.aws.services.collision.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboCollisionRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "collision";
   }

   @Override
   public String getServicePrefix() {
      return "Collision_20161126.";
   }
}
