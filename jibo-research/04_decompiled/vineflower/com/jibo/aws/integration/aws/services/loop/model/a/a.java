package com.jibo.aws.integration.aws.services.loop.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.key.model.Backup;

public class a implements Unmarshaller<Backup, JsonUnmarshallerContext> {
   public Backup a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), Backup.class);
   }
}
