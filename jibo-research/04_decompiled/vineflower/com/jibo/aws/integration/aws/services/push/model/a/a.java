package com.jibo.aws.integration.aws.services.push.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.common.model.Device;
import java.util.List;

public class a implements Unmarshaller<List<Device>, JsonUnmarshallerContext> {
   public List<Device> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<Device>>(this) {
         final a a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
