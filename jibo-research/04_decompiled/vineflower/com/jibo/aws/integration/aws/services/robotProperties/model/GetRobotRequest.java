package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.jibo.aws.integration.aws.services.common.model.IdRequest;

public class GetRobotRequest extends IdRequest {
   public GetRobotRequest(String var1) {
      super(var1);
   }

   @Override
   public String getServiceAbbr() {
      return "robotproperties";
   }

   @Override
   public String getServicePrefix() {
      return "RobotProperties_20160225.";
   }
}
