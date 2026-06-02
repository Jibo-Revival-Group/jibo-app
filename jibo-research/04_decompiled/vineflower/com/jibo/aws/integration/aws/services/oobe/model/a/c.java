package com.jibo.aws.integration.aws.services.oobe.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;

public class c implements Unmarshaller<TokenContainer, JsonUnmarshallerContext> {
   public TokenContainer a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), TokenContainer.class);
   }
}
