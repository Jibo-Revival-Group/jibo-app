package com.jibo.aws.integration.aws.services.binary.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.binary.model.BinaryLink;

public class a implements Unmarshaller<BinaryLink, JsonUnmarshallerContext> {
   public BinaryLink a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), BinaryLink.class);
   }
}
