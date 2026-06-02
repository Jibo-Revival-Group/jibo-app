package com.jibo.aws.integration.aws.services.loop.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.loop.model.RobotAccount;

public class e implements Unmarshaller<RobotAccount, JsonUnmarshallerContext> {
   public RobotAccount a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), RobotAccount.class);
   }
}
