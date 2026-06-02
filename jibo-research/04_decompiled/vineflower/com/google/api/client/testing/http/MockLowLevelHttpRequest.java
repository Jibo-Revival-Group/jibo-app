package com.google.api.client.testing.http;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@Beta
public class MockLowLevelHttpRequest extends LowLevelHttpRequest {
   private final Map<String, List<String>> headersMap = new HashMap<>();
   private MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
   private String url;

   public MockLowLevelHttpRequest() {
   }

   public MockLowLevelHttpRequest(String var1) {
      this.url = var1;
   }

   @Override
   public void addHeader(String var1, String var2) throws IOException {
      String var4 = var1.toLowerCase();
      List var3 = this.headersMap.get(var4);
      List var5 = var3;
      if (var3 == null) {
         var5 = new ArrayList();
         this.headersMap.put(var4, var5);
      }

      var5.add(var2);
   }

   @Override
   public LowLevelHttpResponse execute() throws IOException {
      return this.response;
   }

   public String getContentAsString() throws IOException {
      String var1;
      if (this.getStreamingContent() == null) {
         var1 = "";
      } else {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         this.getStreamingContent().writeTo(var2);
         String var3 = this.getContentEncoding();
         ByteArrayOutputStream var4 = var2;
         if (var3 != null) {
            var4 = var2;
            if (var3.contains("gzip")) {
               GZIPInputStream var5 = new GZIPInputStream(new ByteArrayInputStream(var2.toByteArray()));
               var4 = new ByteArrayOutputStream();
               IOUtils.copy(var5, var4);
            }
         }

         String var6 = this.getContentType();
         HttpMediaType var7;
         if (var6 != null) {
            var7 = new HttpMediaType(var6);
         } else {
            var7 = null;
         }

         Charset var8;
         if (var7 != null && var7.getCharsetParameter() != null) {
            var8 = var7.getCharsetParameter();
         } else {
            var8 = Charsets.ISO_8859_1;
         }

         var1 = var4.toString(var8.name());
      }

      return var1;
   }

   public String getFirstHeaderValue(String var1) {
      List var2 = this.headersMap.get(var1.toLowerCase());
      if (var2 == null) {
         var1 = null;
      } else {
         var1 = (String)var2.get(0);
      }

      return var1;
   }

   public List<String> getHeaderValues(String var1) {
      List var2 = this.headersMap.get(var1.toLowerCase());
      List var3;
      if (var2 == null) {
         var3 = Collections.emptyList();
      } else {
         var3 = Collections.unmodifiableList(var2);
      }

      return var3;
   }

   public Map<String, List<String>> getHeaders() {
      return Collections.unmodifiableMap(this.headersMap);
   }

   public MockLowLevelHttpResponse getResponse() {
      return this.response;
   }

   public String getUrl() {
      return this.url;
   }

   public MockLowLevelHttpRequest setResponse(MockLowLevelHttpResponse var1) {
      this.response = var1;
      return this;
   }

   public MockLowLevelHttpRequest setUrl(String var1) {
      this.url = var1;
      return this;
   }
}
