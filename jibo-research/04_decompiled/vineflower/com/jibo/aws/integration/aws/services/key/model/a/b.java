package com.jibo.aws.integration.aws.services.key.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.key.model.Request;

public class b implements Unmarshaller<Request, JsonUnmarshallerContext> {
   public Request a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), Request.class);
   }
}
