package com.google.api.client.json.jackson2;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

final class JacksonParser extends JsonParser {
   private final JacksonFactory factory;
   private final com.fasterxml.jackson.core.JsonParser parser;

   JacksonParser(JacksonFactory var1, com.fasterxml.jackson.core.JsonParser var2) {
      this.factory = var1;
      this.parser = var2;
   }

   @Override
   public void close() throws IOException {
      this.parser.close();
   }

   @Override
   public BigInteger getBigIntegerValue() throws IOException {
      return this.parser.k();
   }

   @Override
   public byte getByteValue() throws IOException {
      return this.parser.g();
   }

   @Override
   public String getCurrentName() throws IOException {
      return this.parser.d();
   }

   @Override
   public JsonToken getCurrentToken() {
      return JacksonFactory.convert(this.parser.c());
   }

   @Override
   public BigDecimal getDecimalValue() throws IOException {
      return this.parser.n();
   }

   @Override
   public double getDoubleValue() throws IOException {
      return this.parser.m();
   }

   public JacksonFactory getFactory() {
      return this.factory;
   }

   @Override
   public float getFloatValue() throws IOException {
      return this.parser.l();
   }

   @Override
   public int getIntValue() throws IOException {
      return this.parser.i();
   }

   @Override
   public long getLongValue() throws IOException {
      return this.parser.j();
   }

   @Override
   public short getShortValue() throws IOException {
      return this.parser.h();
   }

   @Override
   public String getText() throws IOException {
      return this.parser.f();
   }

   @Override
   public JsonToken nextToken() throws IOException {
      return JacksonFactory.convert(this.parser.a());
   }

   @Override
   public JsonParser skipChildren() throws IOException {
      this.parser.b();
      return this;
   }
}
