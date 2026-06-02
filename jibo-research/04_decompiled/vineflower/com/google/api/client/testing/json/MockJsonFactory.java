package com.google.api.client.testing.json;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

@Beta
public class MockJsonFactory extends JsonFactory {
   @Override
   public JsonGenerator createJsonGenerator(OutputStream var1, Charset var2) throws IOException {
      return new MockJsonGenerator(this);
   }

   @Override
   public JsonGenerator createJsonGenerator(Writer var1) throws IOException {
      return new MockJsonGenerator(this);
   }

   @Override
   public JsonParser createJsonParser(InputStream var1) throws IOException {
      return new MockJsonParser(this);
   }

   @Override
   public JsonParser createJsonParser(InputStream var1, Charset var2) throws IOException {
      return new MockJsonParser(this);
   }

   @Override
   public JsonParser createJsonParser(Reader var1) throws IOException {
      return new MockJsonParser(this);
   }

   @Override
   public JsonParser createJsonParser(String var1) throws IOException {
      return new MockJsonParser(this);
   }
}
