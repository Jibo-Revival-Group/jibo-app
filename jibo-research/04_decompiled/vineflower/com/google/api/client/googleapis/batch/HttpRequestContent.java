package com.google.api.client.googleapis.batch;

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

class HttpRequestContent extends AbstractHttpContent {
   private static final String HTTP_VERSION = "HTTP/1.1";
   static final String NEWLINE = "\r\n";
   private final HttpRequest request;

   HttpRequestContent(HttpRequest var1) {
      super("application/http");
      this.request = var1;
   }

   @Override
   public void writeTo(OutputStream var1) throws IOException {
      OutputStreamWriter var5 = new OutputStreamWriter(var1, this.getCharset());
      var5.write(this.request.getRequestMethod());
      var5.write(" ");
      var5.write(this.request.getUrl().build());
      var5.write(" ");
      var5.write("HTTP/1.1");
      var5.write("\r\n");
      HttpHeaders var4 = new HttpHeaders();
      var4.fromHttpHeaders(this.request.getHeaders());
      var4.setAcceptEncoding(null).setUserAgent(null).setContentEncoding(null).setContentType(null).setContentLength(null);
      HttpContent var6 = this.request.getContent();
      if (var6 != null) {
         var4.setContentType(var6.getType());
         long var2 = var6.getLength();
         if (var2 != -1L) {
            var4.setContentLength(var2);
         }
      }

      HttpHeaders.serializeHeadersForMultipartRequests(var4, null, null, var5);
      var5.write("\r\n");
      var5.flush();
      if (var6 != null) {
         var6.writeTo(var1);
      }
   }
}
