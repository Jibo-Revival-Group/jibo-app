package com.jibo.aws.integration.aws.services.loop.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.loop.model.Loop;

public class b implements Unmarshaller<Loop, JsonUnmarshallerContext> {
   public Loop a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), Loop.class);
   }
}
