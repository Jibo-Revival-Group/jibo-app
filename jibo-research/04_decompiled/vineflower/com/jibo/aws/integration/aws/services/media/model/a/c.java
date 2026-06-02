package com.jibo.aws.integration.aws.services.media.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.media.model.Media;
import java.util.List;

public class c implements Unmarshaller<List<Media>, JsonUnmarshallerContext> {
   public List<Media> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<Media>>(this) {
         final c a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
