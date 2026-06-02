package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

final class NetHttpRequest extends LowLevelHttpRequest {
   private final HttpURLConnection connection;

   NetHttpRequest(HttpURLConnection var1) {
      this.connection = var1;
      var1.setInstanceFollowRedirects(false);
   }

   @Override
   public void addHeader(String var1, String var2) {
      this.connection.addRequestProperty(var1, var2);
   }

   @Override
   public LowLevelHttpResponse execute() throws IOException {
      HttpURLConnection var4 = this.connection;
      if (this.getStreamingContent() != null) {
         String var5 = this.getContentType();
         if (var5 != null) {
            this.addHeader("Content-Type", var5);
         }

         var5 = this.getContentEncoding();
         if (var5 != null) {
            this.addHeader("Content-Encoding", var5);
         }

         long var1 = this.getContentLength();
         if (var1 >= 0L) {
            this.addHeader("Content-Length", Long.toString(var1));
         }

         var5 = var4.getRequestMethod();
         if ("POST".equals(var5) || "PUT".equals(var5)) {
            var4.setDoOutput(true);
            if (var1 >= 0L && var1 <= 2147483647L) {
               var4.setFixedLengthStreamingMode((int)var1);
            } else {
               var4.setChunkedStreamingMode(0);
            }

            OutputStream var19 = var4.getOutputStream();

            try {
               this.getStreamingContent().writeTo(var19);
            } finally {
               try {
                  var19.close();
               } catch (IOException var14) {
               }
            }

            throw var4;
         }

         boolean var3;
         if (var1 == 0L) {
            var3 = true;
         } else {
            var3 = false;
         }

         Preconditions.checkArgument(var3, "%s with non-zero content length is not supported", var5);
      }

      try {
         var4.connect();
         return new NetHttpResponse(var4);
      } finally {
         var4.disconnect();
      }
   }

   @Override
   public void setTimeout(int var1, int var2) {
      this.connection.setReadTimeout(var2);
      this.connection.setConnectTimeout(var1);
   }
}
