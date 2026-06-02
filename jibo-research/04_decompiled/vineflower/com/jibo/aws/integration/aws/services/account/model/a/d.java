package com.jibo.aws.integration.aws.services.account.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.account.model.TokenContainer;

public class d implements Unmarshaller<TokenContainer, JsonUnmarshallerContext> {
   public TokenContainer a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), TokenContainer.class);
   }
}
