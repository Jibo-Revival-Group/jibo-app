package com.fasterxml.jackson.core;

public class JsonParseException extends JsonProcessingException {
   public JsonParseException(String var1, JsonLocation var2) {
      super(var1, var2);
   }

   public JsonParseException(String var1, JsonLocation var2, Throwable var3) {
      super(var1, var2, var3);
   }
}
