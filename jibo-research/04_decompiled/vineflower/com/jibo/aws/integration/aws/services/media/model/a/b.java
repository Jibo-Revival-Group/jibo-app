package com.jibo.aws.integration.aws.services.media.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.media.model.Media;

public class b implements Unmarshaller<Media, JsonUnmarshallerContext> {
   public Media a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), Media.class);
   }
}
