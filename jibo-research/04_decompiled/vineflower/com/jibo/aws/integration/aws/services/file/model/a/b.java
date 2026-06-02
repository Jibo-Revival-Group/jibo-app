package com.jibo.aws.integration.aws.services.file.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jibo.aws.integration.aws.services.file.model.FileLink;
import java.util.List;

public class b implements Unmarshaller<List<FileLink>, JsonUnmarshallerContext> {
   public List<FileLink> a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), (new TypeToken<List<FileLink>>(this) {
         final b a;

         {
            this.a = var1;
         }
      }).getType());
   }
}
