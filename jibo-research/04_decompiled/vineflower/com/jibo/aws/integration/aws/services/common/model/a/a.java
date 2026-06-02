package com.jibo.aws.integration.aws.services.common.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;

public class a implements Unmarshaller<CommandResponse, JsonUnmarshallerContext> {
   public CommandResponse a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), CommandResponse.class);
   }
}
