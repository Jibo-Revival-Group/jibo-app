package com.jibo.aws.integration.aws.services.file.model.a;

import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.google.gson.Gson;
import com.jibo.aws.integration.aws.services.file.model.FileLink;

public class a implements Unmarshaller<FileLink, JsonUnmarshallerContext> {
   public FileLink a(JsonUnmarshallerContext var1) {
      return new Gson().a(var1.getReader().getReader(), FileLink.class);
   }
}
