package com.jibo.aws.integration.aws.services.common.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;

public class d implements Unmarshaller<IdResponse, JsonUnmarshallerContext> {
   public IdResponse a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), IdResponse.class);
   }
}
