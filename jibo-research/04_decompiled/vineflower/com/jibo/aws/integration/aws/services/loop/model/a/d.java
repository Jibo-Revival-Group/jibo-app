package com.jibo.aws.integration.aws.services.loop.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import java.util.List;

public class d implements Unmarshaller<List<Member>, JsonUnmarshallerContext> {
   public List<Member> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<Member>>(this) {
         final d a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
