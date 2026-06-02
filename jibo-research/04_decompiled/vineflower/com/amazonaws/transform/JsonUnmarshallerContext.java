package com.amazonaws.transform;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.json.AwsJsonReader;

public class JsonUnmarshallerContext {
   private final HttpResponse httpResponse;
   private final AwsJsonReader reader;

   public JsonUnmarshallerContext(AwsJsonReader var1, HttpResponse var2) {
      this.reader = var1;
      this.httpResponse = var2;
   }

   public AwsJsonReader getReader() {
      return this.reader;
   }
}
