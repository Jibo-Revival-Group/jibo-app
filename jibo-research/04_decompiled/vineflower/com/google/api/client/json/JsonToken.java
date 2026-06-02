package com.google.api.client.json;

public enum JsonToken {
   END_ARRAY,
   END_OBJECT,
   FIELD_NAME,
   NOT_AVAILABLE,
   START_ARRAY,
   START_OBJECT,
   VALUE_FALSE,
   VALUE_NULL,
   VALUE_NUMBER_FLOAT,
   VALUE_NUMBER_INT,
   VALUE_STRING,
   VALUE_TRUE;

   private static final JsonToken[] $VALUES = new JsonToken[]{
      JsonToken.START_ARRAY,
      JsonToken.END_ARRAY,
      JsonToken.START_OBJECT,
      JsonToken.END_OBJECT,
      JsonToken.FIELD_NAME,
      JsonToken.VALUE_STRING,
      JsonToken.VALUE_NUMBER_INT,
      JsonToken.VALUE_NUMBER_FLOAT,
      JsonToken.VALUE_TRUE,
      JsonToken.VALUE_FALSE,
      JsonToken.VALUE_NULL,
      JsonToken.NOT_AVAILABLE
   };
}
