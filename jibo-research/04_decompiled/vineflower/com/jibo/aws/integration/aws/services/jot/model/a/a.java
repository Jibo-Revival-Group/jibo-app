package com.jibo.aws.integration.aws.services.jot.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.jot.model.Message;

public class a implements Unmarshaller<Message, JsonUnmarshallerContext> {
   public Message a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), Message.class);
   }
}
