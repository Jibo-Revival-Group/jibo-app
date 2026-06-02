package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

@Beta
public class MockJsonGenerator extends JsonGenerator {
   private final JsonFactory factory;

   MockJsonGenerator(JsonFactory var1) {
      this.factory = var1;
   }

   @Override
   public void close() throws IOException {
   }

   @Override
   public void flush() throws IOException {
   }

   @Override
   public JsonFactory getFactory() {
      return this.factory;
   }

   @Override
   public void writeBoolean(boolean var1) throws IOException {
   }

   @Override
   public void writeEndArray() throws IOException {
   }

   @Override
   public void writeEndObject() throws IOException {
   }

   @Override
   public void writeFieldName(String var1) throws IOException {
   }

   @Override
   public void writeNull() throws IOException {
   }

   @Override
   public void writeNumber(double var1) throws IOException {
   }

   @Override
   public void writeNumber(float var1) throws IOException {
   }

   @Override
   public void writeNumber(int var1) throws IOException {
   }

   @Override
   public void writeNumber(long var1) throws IOException {
   }

   @Override
   public void writeNumber(String var1) throws IOException {
   }

   @Override
   public void writeNumber(BigDecimal var1) throws IOException {
   }

   @Override
   public void writeNumber(BigInteger var1) throws IOException {
   }

   @Override
   public void writeStartArray() throws IOException {
   }

   @Override
   public void writeStartObject() throws IOException {
   }

   @Override
   public void writeString(String var1) throws IOException {
   }
}
