package com.amazonaws.http;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
   private InputStream content;
   private final Map<String, String> headers;
   private final InputStream rawContent;
   private final int statusCode;
   private final String statusText;

   private HttpResponse(String var1, int var2, Map<String, String> var3, InputStream var4) {
      this.statusText = var1;
      this.statusCode = var2;
      this.headers = var3;
      this.rawContent = var4;
   }

   public static HttpResponse.Builder builder() {
      return new HttpResponse.Builder();
   }

   public InputStream getContent() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:573)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield com/amazonaws/http/HttpResponse.content Ljava/io/InputStream;
      // 04: ifnonnull 4f
      // 07: aload 0
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/amazonaws/http/HttpResponse.rawContent Ljava/io/InputStream;
      // 0d: ifnull 54
      // 10: ldc "gzip"
      // 12: aload 0
      // 13: getfield com/amazonaws/http/HttpResponse.headers Ljava/util/Map;
      // 16: ldc "Content-Encoding"
      // 18: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1d: checkcast java/lang/String
      // 20: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 23: ifne 3c
      // 26: ldc "gzip"
      // 28: aload 0
      // 29: getfield com/amazonaws/http/HttpResponse.headers Ljava/util/Map;
      // 2c: ldc "content-encoding"
      // 2e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 33: checkcast java/lang/String
      // 36: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 39: ifeq 54
      // 3c: new java/util/zip/GZIPInputStream
      // 3f: astore 1
      // 40: aload 1
      // 41: aload 0
      // 42: getfield com/amazonaws/http/HttpResponse.rawContent Ljava/io/InputStream;
      // 45: invokespecial java/util/zip/GZIPInputStream.<init> (Ljava/io/InputStream;)V
      // 48: aload 0
      // 49: aload 1
      // 4a: putfield com/amazonaws/http/HttpResponse.content Ljava/io/InputStream;
      // 4d: aload 0
      // 4e: monitorexit
      // 4f: aload 0
      // 50: getfield com/amazonaws/http/HttpResponse.content Ljava/io/InputStream;
      // 53: areturn
      // 54: aload 0
      // 55: aload 0
      // 56: getfield com/amazonaws/http/HttpResponse.rawContent Ljava/io/InputStream;
      // 59: putfield com/amazonaws/http/HttpResponse.content Ljava/io/InputStream;
      // 5c: goto 4d
      // 5f: astore 1
      // 60: aload 0
      // 61: monitorexit
      // 62: aload 1
      // 63: athrow
      // try (5 -> 24): 43 null
      // try (24 -> 33): 43 null
      // try (33 -> 35): 43 null
      // try (38 -> 42): 43 null
      // try (44 -> 46): 43 null
   }

   public Map<String, String> getHeaders() {
      return this.headers;
   }

   public InputStream getRawContent() {
      return this.rawContent;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public String getStatusText() {
      return this.statusText;
   }

   public void setContent(InputStream var1) {
      this.content = var1;
   }

   public static class Builder {
      private InputStream content;
      private final Map<String, String> headers = new HashMap<>();
      private int statusCode;
      private String statusText;

      public HttpResponse build() {
         return new HttpResponse(this.statusText, this.statusCode, Collections.unmodifiableMap(this.headers), this.content);
      }

      public HttpResponse.Builder content(InputStream var1) {
         this.content = var1;
         return this;
      }

      public HttpResponse.Builder header(String var1, String var2) {
         this.headers.put(var1, var2);
         return this;
      }

      public HttpResponse.Builder statusCode(int var1) {
         this.statusCode = var1;
         return this;
      }

      public HttpResponse.Builder statusText(String var1) {
         this.statusText = var1;
         return this;
      }
   }
}
