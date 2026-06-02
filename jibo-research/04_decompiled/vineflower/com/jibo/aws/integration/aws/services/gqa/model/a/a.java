package com.jibo.aws.integration.aws.services.gqa.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;

public class a implements Unmarshaller<GQAAttribution, JsonUnmarshallerContext> {
   public GQAAttribution a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), GQAAttribution.class);
   }
}
