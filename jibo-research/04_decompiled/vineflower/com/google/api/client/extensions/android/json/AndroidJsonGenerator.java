package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonWriter;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@TargetApi(11)
@Beta
class AndroidJsonGenerator extends JsonGenerator {
   private final AndroidJsonFactory factory;
   private final JsonWriter writer;

   AndroidJsonGenerator(AndroidJsonFactory var1, JsonWriter var2) {
      this.factory = var1;
      this.writer = var2;
      var2.setLenient(true);
   }

   @Override
   public void close() throws IOException {
      this.writer.close();
   }

   @Override
   public void enablePrettyPrint() throws IOException {
      this.writer.setIndent("  ");
   }

   @Override
   public void flush() throws IOException {
      this.writer.flush();
   }

   @Override
   public JsonFactory getFactory() {
      return this.factory;
   }

   @Override
   public void writeBoolean(boolean var1) throws IOException {
      this.writer.value(var1);
   }

   @Override
   public void writeEndArray() throws IOException {
      this.writer.endArray();
   }

   @Override
   public void writeEndObject() throws IOException {
      this.writer.endObject();
   }

   @Override
   public void writeFieldName(String var1) throws IOException {
      this.writer.name(var1);
   }

   @Override
   public void writeNull() throws IOException {
      this.writer.nullValue();
   }

   @Override
   public void writeNumber(double var1) throws IOException {
      this.writer.value(var1);
   }

   @Override
   public void writeNumber(float var1) throws IOException {
      this.writer.value(var1);
   }

   @Override
   public void writeNumber(int var1) throws IOException {
      this.writer.value(var1);
   }

   @Override
   public void writeNumber(long var1) throws IOException {
      this.writer.value(var1);
   }

   @Override
   public void writeNumber(String var1) throws IOException {
      this.writer.value(new AndroidJsonGenerator.StringNumber(var1));
   }

   @Override
   public void writeNumber(BigDecimal var1) throws IOException {
      this.writer.value(var1);
   }

   @Override
   public void writeNumber(BigInteger var1) throws IOException {
      this.writer.value(var1);
   }

   @Override
   public void writeStartArray() throws IOException {
      this.writer.beginArray();
   }

   @Override
   public void writeStartObject() throws IOException {
      this.writer.beginObject();
   }

   @Override
   public void writeString(String var1) throws IOException {
      this.writer.value(var1);
   }

   static final class StringNumber extends Number {
      private static final long serialVersionUID = 1L;
      private final String encodedValue;

      StringNumber(String var1) {
         this.encodedValue = var1;
      }

      @Override
      public double doubleValue() {
         return 0.0;
      }

      @Override
      public float floatValue() {
         return 0.0F;
      }

      @Override
      public int intValue() {
         return 0;
      }

      @Override
      public long longValue() {
         return 0L;
      }

      @Override
      public String toString() {
         return this.encodedValue;
      }
   }
}
