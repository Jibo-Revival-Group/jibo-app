package com.jibo.aws.integration.aws.services.person.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

public class a implements Unmarshaller<HashMap<String, JsonObject>, JsonUnmarshallerContext> {
   public HashMap<String, JsonObject> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<HashMap<String, JsonObject>>(this) {
         final a a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
