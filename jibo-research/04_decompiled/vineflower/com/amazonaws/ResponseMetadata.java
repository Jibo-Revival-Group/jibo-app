package com.amazonaws;

import java.util.Map;

public class ResponseMetadata {
   protected final Map<String, String> metadata;

   public ResponseMetadata(Map<String, String> var1) {
      this.metadata = var1;
   }

   public String getRequestId() {
      return this.metadata.get("AWS_REQUEST_ID");
   }

   @Override
   public String toString() {
      String var1;
      if (this.metadata == null) {
         var1 = "{}";
      } else {
         var1 = this.metadata.toString();
      }

      return var1;
   }
}
