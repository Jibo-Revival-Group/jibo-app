package com.google.gson.stream;

public enum JsonToken {
   BEGIN_ARRAY,
   BEGIN_OBJECT,
   BOOLEAN,
   END_ARRAY,
   END_DOCUMENT,
   END_OBJECT,
   NAME,
   NULL,
   NUMBER,
   STRING;

   private static final JsonToken[] $VALUES = new JsonToken[]{
      JsonToken.BEGIN_ARRAY,
      JsonToken.END_ARRAY,
      JsonToken.BEGIN_OBJECT,
      JsonToken.END_OBJECT,
      JsonToken.NAME,
      JsonToken.STRING,
      JsonToken.NUMBER,
      JsonToken.BOOLEAN,
      JsonToken.NULL,
      JsonToken.END_DOCUMENT
   };
}
