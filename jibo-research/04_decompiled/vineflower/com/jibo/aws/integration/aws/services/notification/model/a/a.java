package com.jibo.aws.integration.aws.services.notification.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;

public class a implements Unmarshaller<StatusContainer, JsonUnmarshallerContext> {
   public StatusContainer a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), StatusContainer.class);
   }
}
