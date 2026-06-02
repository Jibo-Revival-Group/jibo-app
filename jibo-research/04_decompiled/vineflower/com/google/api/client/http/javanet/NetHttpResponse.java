package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

final class NetHttpResponse extends LowLevelHttpResponse {
   private final HttpURLConnection connection;
   private final ArrayList<String> headerNames = new ArrayList<>();
   private final ArrayList<String> headerValues = new ArrayList<>();
   private final int responseCode;
   private final String responseMessage;

   NetHttpResponse(HttpURLConnection var1) throws IOException {
      this.connection = var1;
      int var3 = var1.getResponseCode();
      int var2 = var3;
      if (var3 == -1) {
         var2 = 0;
      }

      this.responseCode = var2;
      this.responseMessage = var1.getResponseMessage();
      ArrayList var4 = this.headerNames;
      ArrayList var5 = this.headerValues;

      for (Entry var7 : var1.getHeaderFields().entrySet()) {
         String var9 = (String)var7.getKey();
         if (var9 != null) {
            for (String var8 : (List)var7.getValue()) {
               if (var8 != null) {
                  var4.add(var9);
                  var5.add(var8);
               }
            }
         }
      }
   }

   @Override
   public void disconnect() {
      this.connection.disconnect();
   }

   @Override
   public InputStream getContent() throws IOException {
      InputStream var1;
      try {
         var1 = this.connection.getInputStream();
      } catch (IOException var2) {
         var1 = this.connection.getErrorStream();
      }

      if (var1 == null) {
         var1 = null;
      } else {
         var1 = new NetHttpResponse.SizeValidatingInputStream(this, var1);
      }

      return var1;
   }

   @Override
   public String getContentEncoding() {
      return this.connection.getContentEncoding();
   }

   @Override
   public long getContentLength() {
      String var3 = this.connection.getHeaderField("Content-Length");
      long var1;
      if (var3 == null) {
         var1 = -1L;
      } else {
         var1 = Long.parseLong(var3);
      }

      return var1;
   }

   @Override
   public String getContentType() {
      return this.connection.getHeaderField("Content-Type");
   }

   @Override
   public int getHeaderCount() {
      return this.headerNames.size();
   }

   @Override
   public String getHeaderName(int var1) {
      return this.headerNames.get(var1);
   }

   @Override
   public String getHeaderValue(int var1) {
      return this.headerValues.get(var1);
   }

   @Override
   public String getReasonPhrase() {
      return this.responseMessage;
   }

   @Override
   public int getStatusCode() {
      return this.responseCode;
   }

   @Override
   public String getStatusLine() {
      String var1 = this.connection.getHeaderField(0);
      if (var1 == null || !var1.startsWith("HTTP/1.")) {
         var1 = null;
      }

      return var1;
   }

   private final class SizeValidatingInputStream extends FilterInputStream {
      private long bytesRead;
      final NetHttpResponse this$0;

      public SizeValidatingInputStream(NetHttpResponse var1, InputStream var2) {
         super(var2);
         this.this$0 = var1;
         this.bytesRead = 0L;
      }

      private void throwIfFalseEOF() throws IOException {
         long var3 = this.this$0.getContentLength();
         if (var3 != -1L && this.bytesRead != 0L && this.bytesRead < var3) {
            long var1 = this.bytesRead;
            throw new IOException(
               new StringBuilder(102).append("Connection closed prematurely: bytesRead = ").append(var1).append(", Content-Length = ").append(var3).toString()
            );
         }
      }

      @Override
      public int read() throws IOException {
         int var1 = this.in.read();
         if (var1 == -1) {
            this.throwIfFalseEOF();
         } else {
            this.bytesRead++;
         }

         return var1;
      }

      @Override
      public int read(byte[] var1, int var2, int var3) throws IOException {
         var2 = this.in.read(var1, var2, var3);
         if (var2 == -1) {
            this.throwIfFalseEOF();
         } else {
            this.bytesRead += var2;
         }

         return var2;
      }
   }
}
