package com.google.api.client.json.jackson2;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public final class JacksonFactory extends JsonFactory {
   private final com.fasterxml.jackson.core.JsonFactory factory = new com.fasterxml.jackson.core.JsonFactory();

   public JacksonFactory() {
      this.factory.a(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);
   }

   static JsonToken convert(com.fasterxml.jackson.core.JsonToken var0) {
      JsonToken var1;
      if (var0 == null) {
         var1 = null;
      } else {
         switch (<unrepresentable>.$SwitchMap$com$fasterxml$jackson$core$JsonToken[var0.ordinal()]) {
            case 1:
               var1 = JsonToken.END_ARRAY;
               break;
            case 2:
               var1 = JsonToken.START_ARRAY;
               break;
            case 3:
               var1 = JsonToken.END_OBJECT;
               break;
            case 4:
               var1 = JsonToken.START_OBJECT;
               break;
            case 5:
               var1 = JsonToken.VALUE_FALSE;
               break;
            case 6:
               var1 = JsonToken.VALUE_TRUE;
               break;
            case 7:
               var1 = JsonToken.VALUE_NULL;
               break;
            case 8:
               var1 = JsonToken.VALUE_STRING;
               break;
            case 9:
               var1 = JsonToken.VALUE_NUMBER_FLOAT;
               break;
            case 10:
               var1 = JsonToken.VALUE_NUMBER_INT;
               break;
            case 11:
               var1 = JsonToken.FIELD_NAME;
               break;
            default:
               var1 = JsonToken.NOT_AVAILABLE;
         }
      }

      return var1;
   }

   public static JacksonFactory getDefaultInstance() {
      return JacksonFactory.InstanceHolder.INSTANCE;
   }

   @Override
   public com.google.api.client.json.JsonGenerator createJsonGenerator(OutputStream var1, Charset var2) throws IOException {
      return new JacksonGenerator(this, this.factory.b(var1, JsonEncoding.UTF8));
   }

   @Override
   public com.google.api.client.json.JsonGenerator createJsonGenerator(Writer var1) throws IOException {
      return new JacksonGenerator(this, this.factory.b(var1));
   }

   @Override
   public JsonParser createJsonParser(InputStream var1) throws IOException {
      Preconditions.checkNotNull(var1);
      return new JacksonParser(this, this.factory.b(var1));
   }

   @Override
   public JsonParser createJsonParser(InputStream var1, Charset var2) throws IOException {
      Preconditions.checkNotNull(var1);
      return new JacksonParser(this, this.factory.b(var1));
   }

   @Override
   public JsonParser createJsonParser(Reader var1) throws IOException {
      Preconditions.checkNotNull(var1);
      return new JacksonParser(this, this.factory.b(var1));
   }

   @Override
   public JsonParser createJsonParser(String var1) throws IOException {
      Preconditions.checkNotNull(var1);
      return new JacksonParser(this, this.factory.b(var1));
   }

   static class InstanceHolder {
      static final JacksonFactory INSTANCE = new JacksonFactory();
   }
}
