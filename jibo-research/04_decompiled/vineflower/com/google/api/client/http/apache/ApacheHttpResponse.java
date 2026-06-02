package com.google.api.client.http.apache;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;

final class ApacheHttpResponse extends LowLevelHttpResponse {
   private final Header[] allHeaders;
   private final HttpRequestBase request;
   private final HttpResponse response;

   ApacheHttpResponse(HttpRequestBase var1, HttpResponse var2) {
      this.request = var1;
      this.response = var2;
      this.allHeaders = var2.getAllHeaders();
   }

   @Override
   public void disconnect() {
      this.request.abort();
   }

   @Override
   public InputStream getContent() throws IOException {
      HttpEntity var1 = this.response.getEntity();
      InputStream var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.getContent();
      }

      return var2;
   }

   @Override
   public String getContentEncoding() {
      HttpEntity var1 = this.response.getEntity();
      if (var1 != null) {
         Header var2 = var1.getContentEncoding();
         if (var2 != null) {
            return var2.getValue();
         }
      }

      return null;
   }

   @Override
   public long getContentLength() {
      HttpEntity var3 = this.response.getEntity();
      long var1;
      if (var3 == null) {
         var1 = -1L;
      } else {
         var1 = var3.getContentLength();
      }

      return var1;
   }

   @Override
   public String getContentType() {
      HttpEntity var1 = this.response.getEntity();
      if (var1 != null) {
         Header var2 = var1.getContentType();
         if (var2 != null) {
            return var2.getValue();
         }
      }

      return null;
   }

   @Override
   public int getHeaderCount() {
      return this.allHeaders.length;
   }

   @Override
   public String getHeaderName(int var1) {
      return this.allHeaders[var1].getName();
   }

   @Override
   public String getHeaderValue(int var1) {
      return this.allHeaders[var1].getValue();
   }

   public String getHeaderValue(String var1) {
      return this.response.getLastHeader(var1).getValue();
   }

   @Override
   public String getReasonPhrase() {
      StatusLine var1 = this.response.getStatusLine();
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.getReasonPhrase();
      }

      return var2;
   }

   @Override
   public int getStatusCode() {
      StatusLine var2 = this.response.getStatusLine();
      int var1;
      if (var2 == null) {
         var1 = 0;
      } else {
         var1 = var2.getStatusCode();
      }

      return var1;
   }

   @Override
   public String getStatusLine() {
      StatusLine var1 = this.response.getStatusLine();
      String var2;
      if (var1 == null) {
         var2 = null;
      } else {
         var2 = var1.toString();
      }

      return var2;
   }
}
