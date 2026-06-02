package com.jibo.aws.integration.aws.services.account.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.account.model.Account;

public class a implements Unmarshaller<Account, JsonUnmarshallerContext> {
   public Account a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), Account.class);
   }
}
