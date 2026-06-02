package com.amazonaws.http;

import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

public class HttpRequest {
   private final InputStream content;
   private final Map<String, String> headers;
   private final String method;
   private URI uri;

   public HttpRequest(String var1, URI var2, Map<String, String> var3, InputStream var4) {
      this.method = var1.toUpperCase();
      this.uri = var2;
      Map var5;
      if (var3 == null) {
         var5 = Collections.EMPTY_MAP;
      } else {
         var5 = Collections.unmodifiableMap(var3);
      }

      this.headers = var5;
      this.content = var4;
   }

   public InputStream getContent() {
      return this.content;
   }

   public long getContentLength() {
      long var1;
      if (this.headers == null) {
         var1 = 0L;
      } else {
         String var3 = this.headers.get("Content-Length");
         if (var3 != null && !var3.isEmpty()) {
            var1 = Long.valueOf(var3);
         } else {
            var1 = 0L;
         }
      }

      return var1;
   }

   public Map<String, String> getHeaders() {
      return this.headers;
   }

   public String getMethod() {
      return this.method;
   }

   public URI getUri() {
      return this.uri;
   }

   void setUri(URI var1) {
      this.uri = var1;
   }
}
