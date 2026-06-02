package com.jibo.aws.integration.aws.services.oobe.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.oobe.model.KeysContainer;

public class a implements Unmarshaller<KeysContainer, JsonUnmarshallerContext> {
   public KeysContainer a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), KeysContainer.class);
   }
}
