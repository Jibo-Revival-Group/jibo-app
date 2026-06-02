package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HttpResponse {
   private InputStream content;
   private final String contentEncoding;
   private int contentLoggingLimit;
   private boolean contentRead;
   private final String contentType;
   private boolean loggingEnabled;
   private final HttpMediaType mediaType;
   private final HttpRequest request;
   LowLevelHttpResponse response;
   private final int statusCode;
   private final String statusMessage;

   HttpResponse(HttpRequest var1, LowLevelHttpResponse var2) throws IOException {
      Object var7 = null;
      super();
      this.request = var1;
      this.contentLoggingLimit = var1.getContentLoggingLimit();
      this.loggingEnabled = var1.isLoggingEnabled();
      this.response = var2;
      this.contentEncoding = var2.getContentEncoding();
      int var4 = var2.getStatusCode();
      int var3 = var4;
      if (var4 < 0) {
         var3 = 0;
      }

      this.statusCode = var3;
      String var6 = var2.getReasonPhrase();
      this.statusMessage = var6;
      Logger var8 = HttpTransport.LOGGER;
      boolean var12;
      if (this.loggingEnabled && var8.isLoggable(Level.CONFIG)) {
         var12 = true;
      } else {
         var12 = false;
      }

      StringBuilder var5;
      if (var12) {
         var5 = new StringBuilder();
         var5.append("-------------- RESPONSE --------------").append(StringUtils.LINE_SEPARATOR);
         String var9 = var2.getStatusLine();
         if (var9 != null) {
            var5.append(var9);
         } else {
            var5.append(this.statusCode);
            if (var6 != null) {
               var5.append(' ').append(var6);
            }
         }

         var5.append(StringUtils.LINE_SEPARATOR);
      } else {
         var5 = null;
      }

      HttpHeaders var15 = var1.getResponseHeaders();
      StringBuilder var13;
      if (var12) {
         var13 = var5;
      } else {
         var13 = null;
      }

      var15.fromHttpResponse(var2, var13);
      var6 = var2.getContentType();
      String var11 = var6;
      if (var6 == null) {
         var11 = var1.getResponseHeaders().getContentType();
      }

      this.contentType = var11;
      HttpMediaType var10;
      if (var11 == null) {
         var10 = (HttpMediaType)var7;
      } else {
         var10 = new HttpMediaType(var11);
      }

      this.mediaType = var10;
      if (var12) {
         var8.config(var5.toString());
      }
   }

   private boolean hasMessageBody() throws IOException {
      boolean var2 = true;
      int var1 = this.getStatusCode();
      if (this.getRequest().getRequestMethod().equals("HEAD") || var1 / 100 == 1 || var1 == 204 || var1 == 304) {
         this.ignore();
         var2 = false;
      }

      return var2;
   }

   public void disconnect() throws IOException {
      this.ignore();
      this.response.disconnect();
   }

   public void download(OutputStream var1) throws IOException {
      IOUtils.copy(this.getContent(), var1);
   }

   public InputStream getContent() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/google/api/client/http/HttpResponse.contentRead Z
      // 04: ifne 92
      // 07: aload 0
      // 08: getfield com/google/api/client/http/HttpResponse.response Lcom/google/api/client/http/LowLevelHttpResponse;
      // 0b: invokevirtual com/google/api/client/http/LowLevelHttpResponse.getContent ()Ljava/io/InputStream;
      // 0e: astore 2
      // 0f: aload 2
      // 10: ifnull 8d
      // 13: aload 2
      // 14: astore 3
      // 15: aload 0
      // 16: getfield com/google/api/client/http/HttpResponse.contentEncoding Ljava/lang/String;
      // 19: astore 4
      // 1b: aload 2
      // 1c: astore 1
      // 1d: aload 4
      // 1f: ifnull 3d
      // 22: aload 2
      // 23: astore 1
      // 24: aload 2
      // 25: astore 3
      // 26: aload 4
      // 28: ldc "gzip"
      // 2a: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 2d: ifeq 3d
      // 30: aload 2
      // 31: astore 3
      // 32: new java/util/zip/GZIPInputStream
      // 35: astore 1
      // 36: aload 2
      // 37: astore 3
      // 38: aload 1
      // 39: aload 2
      // 3a: invokespecial java/util/zip/GZIPInputStream.<init> (Ljava/io/InputStream;)V
      // 3d: aload 1
      // 3e: astore 3
      // 3f: aload 1
      // 40: astore 4
      // 42: getstatic com/google/api/client/http/HttpTransport.LOGGER Ljava/util/logging/Logger;
      // 45: astore 5
      // 47: aload 1
      // 48: astore 2
      // 49: aload 1
      // 4a: astore 3
      // 4b: aload 1
      // 4c: astore 4
      // 4e: aload 0
      // 4f: getfield com/google/api/client/http/HttpResponse.loggingEnabled Z
      // 52: ifeq 83
      // 55: aload 1
      // 56: astore 2
      // 57: aload 1
      // 58: astore 3
      // 59: aload 1
      // 5a: astore 4
      // 5c: aload 5
      // 5e: getstatic java/util/logging/Level.CONFIG Ljava/util/logging/Level;
      // 61: invokevirtual java/util/logging/Logger.isLoggable (Ljava/util/logging/Level;)Z
      // 64: ifeq 83
      // 67: aload 1
      // 68: astore 3
      // 69: aload 1
      // 6a: astore 4
      // 6c: new com/google/api/client/util/LoggingInputStream
      // 6f: astore 2
      // 70: aload 1
      // 71: astore 3
      // 72: aload 1
      // 73: astore 4
      // 75: aload 2
      // 76: aload 1
      // 77: aload 5
      // 79: getstatic java/util/logging/Level.CONFIG Ljava/util/logging/Level;
      // 7c: aload 0
      // 7d: getfield com/google/api/client/http/HttpResponse.contentLoggingLimit I
      // 80: invokespecial com/google/api/client/util/LoggingInputStream.<init> (Ljava/io/InputStream;Ljava/util/logging/Logger;Ljava/util/logging/Level;I)V
      // 83: aload 2
      // 84: astore 3
      // 85: aload 2
      // 86: astore 4
      // 88: aload 0
      // 89: aload 2
      // 8a: putfield com/google/api/client/http/HttpResponse.content Ljava/io/InputStream;
      // 8d: aload 0
      // 8e: bipush 1
      // 8f: putfield com/google/api/client/http/HttpResponse.contentRead Z
      // 92: aload 0
      // 93: getfield com/google/api/client/http/HttpResponse.content Ljava/io/InputStream;
      // 96: areturn
      // 97: astore 1
      // 98: aload 3
      // 99: invokevirtual java/io/InputStream.close ()V
      // 9c: goto 8d
      // 9f: astore 1
      // a0: aload 2
      // a1: invokevirtual java/io/InputStream.close ()V
      // a4: aload 1
      // a5: athrow
      // a6: astore 1
      // a7: aload 4
      // a9: astore 2
      // aa: goto a0
      // try (11 -> 14): 90 java/io/EOFException
      // try (11 -> 14): 94 null
      // try (22 -> 26): 90 java/io/EOFException
      // try (22 -> 26): 94 null
      // try (28 -> 30): 90 java/io/EOFException
      // try (28 -> 30): 94 null
      // try (32 -> 35): 90 java/io/EOFException
      // try (32 -> 35): 94 null
      // try (39 -> 41): 90 java/io/EOFException
      // try (39 -> 41): 99 null
      // try (47 -> 50): 90 java/io/EOFException
      // try (47 -> 50): 99 null
      // try (56 -> 60): 90 java/io/EOFException
      // try (56 -> 60): 99 null
      // try (64 -> 66): 90 java/io/EOFException
      // try (64 -> 66): 99 null
      // try (70 -> 77): 90 java/io/EOFException
      // try (70 -> 77): 99 null
      // try (81 -> 84): 90 java/io/EOFException
      // try (81 -> 84): 99 null
   }

   public Charset getContentCharset() {
      Charset var1;
      if (this.mediaType != null && this.mediaType.getCharsetParameter() != null) {
         var1 = this.mediaType.getCharsetParameter();
      } else {
         var1 = Charsets.ISO_8859_1;
      }

      return var1;
   }

   public String getContentEncoding() {
      return this.contentEncoding;
   }

   public int getContentLoggingLimit() {
      return this.contentLoggingLimit;
   }

   public String getContentType() {
      return this.contentType;
   }

   public HttpHeaders getHeaders() {
      return this.request.getResponseHeaders();
   }

   public HttpMediaType getMediaType() {
      return this.mediaType;
   }

   public HttpRequest getRequest() {
      return this.request;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String getStatusMessage() {
      return this.statusMessage;
   }

   public HttpTransport getTransport() {
      return this.request.getTransport();
   }

   public void ignore() throws IOException {
      InputStream var1 = this.getContent();
      if (var1 != null) {
         var1.close();
      }
   }

   public boolean isLoggingEnabled() {
      return this.loggingEnabled;
   }

   public boolean isSuccessStatusCode() {
      return HttpStatusCodes.isSuccess(this.statusCode);
   }

   public <T> T parseAs(Class<T> var1) throws IOException {
      Object var2;
      if (!this.hasMessageBody()) {
         var2 = null;
      } else {
         var2 = this.request.getParser().parseAndClose(this.getContent(), this.getContentCharset(), var1);
      }

      return (T)var2;
   }

   public Object parseAs(Type var1) throws IOException {
      Object var2;
      if (!this.hasMessageBody()) {
         var2 = null;
      } else {
         var2 = this.request.getParser().parseAndClose(this.getContent(), this.getContentCharset(), var1);
      }

      return var2;
   }

   public String parseAsString() throws IOException {
      InputStream var2 = this.getContent();
      String var1;
      if (var2 == null) {
         var1 = "";
      } else {
         ByteArrayOutputStream var3 = new ByteArrayOutputStream();
         IOUtils.copy(var2, var3);
         var1 = var3.toString(this.getContentCharset().name());
      }

      return var1;
   }

   public HttpResponse setContentLoggingLimit(int var1) {
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "The content logging limit must be non-negative.");
      this.contentLoggingLimit = var1;
      return this;
   }

   public HttpResponse setLoggingEnabled(boolean var1) {
      this.loggingEnabled = var1;
      return this;
   }
}
