package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;

public abstract class JiboRobotPropertiesRequest extends JiboRequestAbstract {
   @Override
   public String getServiceAbbr() {
      return "robotproperties";
   }

   @Override
   public String getServicePrefix() {
      return "RobotProperties_20160225.";
   }
}
