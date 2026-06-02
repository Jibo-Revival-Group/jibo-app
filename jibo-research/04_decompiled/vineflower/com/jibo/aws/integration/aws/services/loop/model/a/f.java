package com.jibo.aws.integration.aws.services.loop.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.loop.model.Robot;
import java.util.List;

public class f implements Unmarshaller<List<Robot>, JsonUnmarshallerContext> {
   public List<Robot> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<Robot>>(this) {
         final f a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
