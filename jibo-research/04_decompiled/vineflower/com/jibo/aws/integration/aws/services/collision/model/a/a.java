package com.jibo.aws.integration.aws.services.collision.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;

public class a implements Unmarshaller<CollisionCheckContainer, JsonUnmarshallerContext> {
   public CollisionCheckContainer a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), CollisionCheckContainer.class);
   }
}
