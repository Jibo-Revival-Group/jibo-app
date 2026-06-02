package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

final class JacksonGenerator extends JsonGenerator {
   private final JacksonFactory factory;
   private final com.fasterxml.jackson.core.JsonGenerator generator;

   JacksonGenerator(JacksonFactory var1, com.fasterxml.jackson.core.JsonGenerator var2) {
      this.factory = var1;
      this.generator = var2;
   }

   @Override
   public void close() throws IOException {
      this.generator.close();
   }

   @Override
   public void enablePrettyPrint() throws IOException {
      this.generator.b();
   }

   @Override
   public void flush() throws IOException {
      this.generator.flush();
   }

   public JacksonFactory getFactory() {
      return this.factory;
   }

   @Override
   public void writeBoolean(boolean var1) throws IOException {
      this.generator.a(var1);
   }

   @Override
   public void writeEndArray() throws IOException {
      this.generator.d();
   }

   @Override
   public void writeEndObject() throws IOException {
      this.generator.f();
   }

   @Override
   public void writeFieldName(String var1) throws IOException {
      this.generator.a(var1);
   }

   @Override
   public void writeNull() throws IOException {
      this.generator.g();
   }

   @Override
   public void writeNumber(double var1) throws IOException {
      this.generator.a(var1);
   }

   @Override
   public void writeNumber(float var1) throws IOException {
      this.generator.a(var1);
   }

   @Override
   public void writeNumber(int var1) throws IOException {
      this.generator.b(var1);
   }

   @Override
   public void writeNumber(long var1) throws IOException {
      this.generator.a(var1);
   }

   @Override
   public void writeNumber(String var1) throws IOException {
      this.generator.d(var1);
   }

   @Override
   public void writeNumber(BigDecimal var1) throws IOException {
      this.generator.a(var1);
   }

   @Override
   public void writeNumber(BigInteger var1) throws IOException {
      this.generator.a(var1);
   }

   @Override
   public void writeStartArray() throws IOException {
      this.generator.c();
   }

   @Override
   public void writeStartObject() throws IOException {
      this.generator.e();
   }

   @Override
   public void writeString(String var1) throws IOException {
      this.generator.b(var1);
   }
}
