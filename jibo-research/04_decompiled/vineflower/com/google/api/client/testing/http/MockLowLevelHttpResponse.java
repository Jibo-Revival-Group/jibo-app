package com.google.api.client.testing.http;

import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.util.TestableByteArrayInputStream;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Beta
public class MockLowLevelHttpResponse extends LowLevelHttpResponse {
   private InputStream content;
   private String contentEncoding;
   private long contentLength;
   private String contentType;
   private List<String> headerNames;
   private List<String> headerValues;
   private boolean isDisconnected;
   private String reasonPhrase;
   private int statusCode = 200;

   public MockLowLevelHttpResponse() {
      this.headerNames = new ArrayList<>();
      this.headerValues = new ArrayList<>();
      this.contentLength = -1L;
   }

   public MockLowLevelHttpResponse addHeader(String var1, String var2) {
      this.headerNames.add(Preconditions.checkNotNull(var1));
      this.headerValues.add(Preconditions.checkNotNull(var2));
      return this;
   }

   @Override
   public void disconnect() throws IOException {
      this.isDisconnected = true;
      super.disconnect();
   }

   @Override
   public InputStream getContent() throws IOException {
      return this.content;
   }

   @Override
   public String getContentEncoding() {
      return this.contentEncoding;
   }

   @Override
   public long getContentLength() {
      return this.contentLength;
   }

   @Override
   public final String getContentType() {
      return this.contentType;
   }

   @Override
   public int getHeaderCount() {
      return this.headerNames.size();
   }

   @Override
   public String getHeaderName(int var1) {
      return this.headerNames.get(var1);
   }

   public final List<String> getHeaderNames() {
      return this.headerNames;
   }

   @Override
   public String getHeaderValue(int var1) {
      return this.headerValues.get(var1);
   }

   public final List<String> getHeaderValues() {
      return this.headerValues;
   }

   @Override
   public String getReasonPhrase() {
      return this.reasonPhrase;
   }

   @Override
   public int getStatusCode() {
      return this.statusCode;
   }

   @Override
   public String getStatusLine() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.statusCode);
      if (this.reasonPhrase != null) {
         var1.append(this.reasonPhrase);
      }

      return var1.toString();
   }

   public boolean isDisconnected() {
      return this.isDisconnected;
   }

   public MockLowLevelHttpResponse setContent(InputStream var1) {
      this.content = var1;
      return this;
   }

   public MockLowLevelHttpResponse setContent(String var1) {
      MockLowLevelHttpResponse var2;
      if (var1 == null) {
         var2 = this.setZeroContent();
      } else {
         var2 = this.setContent(StringUtils.getBytesUtf8(var1));
      }

      return var2;
   }

   public MockLowLevelHttpResponse setContent(byte[] var1) {
      MockLowLevelHttpResponse var2;
      if (var1 == null) {
         var2 = this.setZeroContent();
      } else {
         this.content = new TestableByteArrayInputStream(var1);
         this.setContentLength(var1.length);
         var2 = this;
      }

      return var2;
   }

   public MockLowLevelHttpResponse setContentEncoding(String var1) {
      this.contentEncoding = var1;
      return this;
   }

   public MockLowLevelHttpResponse setContentLength(long var1) {
      this.contentLength = var1;
      boolean var3;
      if (var1 >= -1L) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      return this;
   }

   public MockLowLevelHttpResponse setContentType(String var1) {
      this.contentType = var1;
      return this;
   }

   public MockLowLevelHttpResponse setHeaderNames(List<String> var1) {
      this.headerNames = Preconditions.checkNotNull(var1);
      return this;
   }

   public MockLowLevelHttpResponse setHeaderValues(List<String> var1) {
      this.headerValues = Preconditions.checkNotNull(var1);
      return this;
   }

   public MockLowLevelHttpResponse setReasonPhrase(String var1) {
      this.reasonPhrase = var1;
      return this;
   }

   public MockLowLevelHttpResponse setStatusCode(int var1) {
      this.statusCode = var1;
      return this;
   }

   public MockLowLevelHttpResponse setZeroContent() {
      this.content = null;
      this.setContentLength(0L);
      return this;
   }
}
