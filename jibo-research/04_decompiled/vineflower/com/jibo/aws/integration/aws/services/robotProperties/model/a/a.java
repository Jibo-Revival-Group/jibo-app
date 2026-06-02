package com.jibo.aws.integration.aws.services.robotProperties.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.robotProperties.model.IdPair;
import java.util.List;

public class a implements Unmarshaller<List<IdPair>, JsonUnmarshallerContext> {
   public List<IdPair> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<IdPair>>(this) {
         final a a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
