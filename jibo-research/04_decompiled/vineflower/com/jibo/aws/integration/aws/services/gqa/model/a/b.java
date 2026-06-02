package com.jibo.aws.integration.aws.services.gqa.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;

public class b implements Unmarshaller<AttributionListResponse, JsonUnmarshallerContext> {
   public AttributionListResponse a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), AttributionListResponse.class);
   }
}
