package com.jibo.aws.integration.aws.services.robotProperties.model;

import com.google.gson.JsonObject;

public class UpdateRobotRequest extends RobotRequest {
   public UpdateRobotRequest(Robot var1) {
      super(var1);
   }

   public UpdateRobotRequest(String var1, String var2, JsonObject var3, long var4, long var6) {
      super(var1, var2, var3, var4, var6);
   }
}
