package com.jibo.aws.integration.aws.services.push.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.push.model.JotNotificationsModeResponse;

public class b implements Unmarshaller<JotNotificationsModeResponse, JsonUnmarshallerContext> {
   public JotNotificationsModeResponse a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), JotNotificationsModeResponse.class);
   }
}
