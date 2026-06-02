package com.jibo.aws.integration.aws.services.robotProperties.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;

public class b implements Unmarshaller<Robot, JsonUnmarshallerContext> {
   public Robot a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), Robot.class);
   }
}
