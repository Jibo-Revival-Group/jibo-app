package com.jibo.aws.integration.aws.services.loop.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import java.util.List;

public class c implements Unmarshaller<List<Loop>, JsonUnmarshallerContext> {
   public List<Loop> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<Loop>>(this) {
         final c a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
