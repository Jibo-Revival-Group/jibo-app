package com.jibo.aws.integration.aws.services.jot.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import java.util.List;

public class b implements Unmarshaller<List<Message>, JsonUnmarshallerContext> {
   public List<Message> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<Message>>(this) {
         final b a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
