package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class HttpRequest {
   public static final int DEFAULT_NUMBER_OF_RETRIES = 10;
   public static final String USER_AGENT_SUFFIX = "Google-HTTP-Java-Client/1.23.0 (gzip)";
   public static final String VERSION = "1.23.0";
   @Deprecated
   @Beta
   private BackOffPolicy backOffPolicy;
   private int connectTimeout;
   private HttpContent content;
   private int contentLoggingLimit;
   private boolean curlLoggingEnabled;
   private HttpEncoding encoding;
   private HttpExecuteInterceptor executeInterceptor;
   private boolean followRedirects;
   private HttpHeaders headers = new HttpHeaders();
   @Beta
   private HttpIOExceptionHandler ioExceptionHandler;
   private boolean loggingEnabled;
   private int numRetries;
   private ObjectParser objectParser;
   private int readTimeout;
   private String requestMethod;
   private HttpHeaders responseHeaders = new HttpHeaders();
   private HttpResponseInterceptor responseInterceptor;
   @Deprecated
   @Beta
   private boolean retryOnExecuteIOException;
   private Sleeper sleeper;
   private boolean suppressUserAgentSuffix;
   private boolean throwExceptionOnExecuteError;
   private final HttpTransport transport;
   private HttpUnsuccessfulResponseHandler unsuccessfulResponseHandler;
   private GenericUrl url;

   HttpRequest(HttpTransport var1, String var2) {
      this.numRetries = 10;
      this.contentLoggingLimit = 16384;
      this.loggingEnabled = true;
      this.curlLoggingEnabled = true;
      this.connectTimeout = 20000;
      this.readTimeout = 20000;
      this.followRedirects = true;
      this.throwExceptionOnExecuteError = true;
      this.retryOnExecuteIOException = false;
      this.sleeper = Sleeper.DEFAULT;
      this.transport = var1;
      this.setRequestMethod(var2);
   }

   public HttpResponse execute() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield com/google/api/client/http/HttpRequest.numRetries I
      // 004: iflt 3a3
      // 007: bipush 1
      // 008: istore 4
      // 00a: iload 4
      // 00c: invokestatic com/google/api/client/util/Preconditions.checkArgument (Z)V
      // 00f: aload 0
      // 010: getfield com/google/api/client/http/HttpRequest.numRetries I
      // 013: istore 1
      // 014: aload 0
      // 015: getfield com/google/api/client/http/HttpRequest.backOffPolicy Lcom/google/api/client/http/BackOffPolicy;
      // 018: ifnull 024
      // 01b: aload 0
      // 01c: getfield com/google/api/client/http/HttpRequest.backOffPolicy Lcom/google/api/client/http/BackOffPolicy;
      // 01f: invokeinterface com/google/api/client/http/BackOffPolicy.reset ()V 1
      // 024: aconst_null
      // 025: astore 9
      // 027: aload 0
      // 028: getfield com/google/api/client/http/HttpRequest.requestMethod Ljava/lang/String;
      // 02b: invokestatic com/google/api/client/util/Preconditions.checkNotNull (Ljava/lang/Object;)Ljava/lang/Object;
      // 02e: pop
      // 02f: aload 0
      // 030: getfield com/google/api/client/http/HttpRequest.url Lcom/google/api/client/http/GenericUrl;
      // 033: invokestatic com/google/api/client/util/Preconditions.checkNotNull (Ljava/lang/Object;)Ljava/lang/Object;
      // 036: pop
      // 037: aload 9
      // 039: ifnull 041
      // 03c: aload 9
      // 03e: invokevirtual com/google/api/client/http/HttpResponse.ignore ()V
      // 041: aload 0
      // 042: getfield com/google/api/client/http/HttpRequest.executeInterceptor Lcom/google/api/client/http/HttpExecuteInterceptor;
      // 045: ifnull 052
      // 048: aload 0
      // 049: getfield com/google/api/client/http/HttpRequest.executeInterceptor Lcom/google/api/client/http/HttpExecuteInterceptor;
      // 04c: aload 0
      // 04d: invokeinterface com/google/api/client/http/HttpExecuteInterceptor.intercept (Lcom/google/api/client/http/HttpRequest;)V 2
      // 052: aload 0
      // 053: getfield com/google/api/client/http/HttpRequest.url Lcom/google/api/client/http/GenericUrl;
      // 056: invokevirtual com/google/api/client/http/GenericUrl.build ()Ljava/lang/String;
      // 059: astore 16
      // 05b: aload 0
      // 05c: getfield com/google/api/client/http/HttpRequest.transport Lcom/google/api/client/http/HttpTransport;
      // 05f: aload 0
      // 060: getfield com/google/api/client/http/HttpRequest.requestMethod Ljava/lang/String;
      // 063: aload 16
      // 065: invokevirtual com/google/api/client/http/HttpTransport.buildRequest (Ljava/lang/String;Ljava/lang/String;)Lcom/google/api/client/http/LowLevelHttpRequest;
      // 068: astore 15
      // 06a: getstatic com/google/api/client/http/HttpTransport.LOGGER Ljava/util/logging/Logger;
      // 06d: astore 14
      // 06f: aload 0
      // 070: getfield com/google/api/client/http/HttpRequest.loggingEnabled Z
      // 073: ifeq 3a9
      // 076: aload 14
      // 078: getstatic java/util/logging/Level.CONFIG Ljava/util/logging/Level;
      // 07b: invokevirtual java/util/logging/Logger.isLoggable (Ljava/util/logging/Level;)Z
      // 07e: ifeq 3a9
      // 081: bipush 1
      // 082: istore 2
      // 083: aconst_null
      // 084: astore 11
      // 086: aconst_null
      // 087: astore 9
      // 089: aload 9
      // 08b: astore 10
      // 08d: iload 2
      // 08e: ifeq 107
      // 091: new java/lang/StringBuilder
      // 094: dup
      // 095: invokespecial java/lang/StringBuilder.<init> ()V
      // 098: astore 12
      // 09a: aload 12
      // 09c: ldc "-------------- REQUEST  --------------"
      // 09e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a1: getstatic com/google/api/client/util/StringUtils.LINE_SEPARATOR Ljava/lang/String;
      // 0a4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0a7: pop
      // 0a8: aload 12
      // 0aa: aload 0
      // 0ab: getfield com/google/api/client/http/HttpRequest.requestMethod Ljava/lang/String;
      // 0ae: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0b1: bipush 32
      // 0b3: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 0b6: aload 16
      // 0b8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0bb: getstatic com/google/api/client/util/StringUtils.LINE_SEPARATOR Ljava/lang/String;
      // 0be: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0c1: pop
      // 0c2: aload 9
      // 0c4: astore 10
      // 0c6: aload 12
      // 0c8: astore 11
      // 0ca: aload 0
      // 0cb: getfield com/google/api/client/http/HttpRequest.curlLoggingEnabled Z
      // 0ce: ifeq 107
      // 0d1: new java/lang/StringBuilder
      // 0d4: dup
      // 0d5: ldc "curl -v --compressed"
      // 0d7: invokespecial java/lang/StringBuilder.<init> (Ljava/lang/String;)V
      // 0da: astore 9
      // 0dc: aload 9
      // 0de: astore 10
      // 0e0: aload 12
      // 0e2: astore 11
      // 0e4: aload 0
      // 0e5: getfield com/google/api/client/http/HttpRequest.requestMethod Ljava/lang/String;
      // 0e8: ldc "GET"
      // 0ea: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0ed: ifne 107
      // 0f0: aload 9
      // 0f2: ldc " -X "
      // 0f4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0f7: aload 0
      // 0f8: getfield com/google/api/client/http/HttpRequest.requestMethod Ljava/lang/String;
      // 0fb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0fe: pop
      // 0ff: aload 12
      // 101: astore 11
      // 103: aload 9
      // 105: astore 10
      // 107: aload 0
      // 108: getfield com/google/api/client/http/HttpRequest.headers Lcom/google/api/client/http/HttpHeaders;
      // 10b: invokevirtual com/google/api/client/http/HttpHeaders.getUserAgent ()Ljava/lang/String;
      // 10e: astore 9
      // 110: aload 0
      // 111: getfield com/google/api/client/http/HttpRequest.suppressUserAgentSuffix Z
      // 114: ifne 126
      // 117: aload 9
      // 119: ifnonnull 3ae
      // 11c: aload 0
      // 11d: getfield com/google/api/client/http/HttpRequest.headers Lcom/google/api/client/http/HttpHeaders;
      // 120: ldc "Google-HTTP-Java-Client/1.23.0 (gzip)"
      // 122: invokevirtual com/google/api/client/http/HttpHeaders.setUserAgent (Ljava/lang/String;)Lcom/google/api/client/http/HttpHeaders;
      // 125: pop
      // 126: aload 0
      // 127: getfield com/google/api/client/http/HttpRequest.headers Lcom/google/api/client/http/HttpHeaders;
      // 12a: aload 11
      // 12c: aload 10
      // 12e: aload 14
      // 130: aload 15
      // 132: invokestatic com/google/api/client/http/HttpHeaders.serializeHeaders (Lcom/google/api/client/http/HttpHeaders;Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;Ljava/util/logging/Logger;Lcom/google/api/client/http/LowLevelHttpRequest;)V
      // 135: aload 0
      // 136: getfield com/google/api/client/http/HttpRequest.suppressUserAgentSuffix Z
      // 139: ifne 146
      // 13c: aload 0
      // 13d: getfield com/google/api/client/http/HttpRequest.headers Lcom/google/api/client/http/HttpHeaders;
      // 140: aload 9
      // 142: invokevirtual com/google/api/client/http/HttpHeaders.setUserAgent (Ljava/lang/String;)Lcom/google/api/client/http/HttpHeaders;
      // 145: pop
      // 146: aload 0
      // 147: getfield com/google/api/client/http/HttpRequest.content Lcom/google/api/client/http/HttpContent;
      // 14a: astore 9
      // 14c: aload 9
      // 14e: ifnull 15d
      // 151: aload 0
      // 152: getfield com/google/api/client/http/HttpRequest.content Lcom/google/api/client/http/HttpContent;
      // 155: invokeinterface com/google/api/client/http/HttpContent.retrySupported ()Z 1
      // 15a: ifeq 3f8
      // 15d: bipush 1
      // 15e: istore 3
      // 15f: aload 9
      // 161: astore 12
      // 163: aload 9
      // 165: ifnull 2c0
      // 168: aload 0
      // 169: getfield com/google/api/client/http/HttpRequest.content Lcom/google/api/client/http/HttpContent;
      // 16c: invokeinterface com/google/api/client/http/HttpContent.getType ()Ljava/lang/String; 1
      // 171: astore 17
      // 173: iload 2
      // 174: ifeq 558
      // 177: new com/google/api/client/util/LoggingStreamingContent
      // 17a: dup
      // 17b: aload 9
      // 17d: getstatic com/google/api/client/http/HttpTransport.LOGGER Ljava/util/logging/Logger;
      // 180: getstatic java/util/logging/Level.CONFIG Ljava/util/logging/Level;
      // 183: aload 0
      // 184: getfield com/google/api/client/http/HttpRequest.contentLoggingLimit I
      // 187: invokespecial com/google/api/client/util/LoggingStreamingContent.<init> (Lcom/google/api/client/util/StreamingContent;Ljava/util/logging/Logger;Ljava/util/logging/Level;I)V
      // 18a: astore 9
      // 18c: aload 0
      // 18d: getfield com/google/api/client/http/HttpRequest.encoding Lcom/google/api/client/http/HttpEncoding;
      // 190: ifnonnull 3fd
      // 193: aload 0
      // 194: getfield com/google/api/client/http/HttpRequest.content Lcom/google/api/client/http/HttpContent;
      // 197: invokeinterface com/google/api/client/http/HttpContent.getLength ()J 1
      // 19c: lstore 7
      // 19e: aconst_null
      // 19f: astore 12
      // 1a1: iload 2
      // 1a2: ifeq 292
      // 1a5: aload 17
      // 1a7: ifnull 206
      // 1aa: aload 17
      // 1ac: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1af: astore 13
      // 1b1: aload 13
      // 1b3: invokevirtual java/lang/String.length ()I
      // 1b6: ifeq 42d
      // 1b9: ldc "Content-Type: "
      // 1bb: aload 13
      // 1bd: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 1c0: astore 13
      // 1c2: aload 11
      // 1c4: aload 13
      // 1c6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1c9: getstatic com/google/api/client/util/StringUtils.LINE_SEPARATOR Ljava/lang/String;
      // 1cc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1cf: pop
      // 1d0: aload 10
      // 1d2: ifnull 206
      // 1d5: aload 13
      // 1d7: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1da: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1dd: astore 13
      // 1df: aload 10
      // 1e1: new java/lang/StringBuilder
      // 1e4: dup
      // 1e5: aload 13
      // 1e7: invokevirtual java/lang/String.length ()I
      // 1ea: bipush 6
      // 1ec: iadd
      // 1ed: invokespecial java/lang/StringBuilder.<init> (I)V
      // 1f0: ldc " -H '"
      // 1f2: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1f5: aload 13
      // 1f7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1fa: ldc "'"
      // 1fc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 1ff: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 202: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 205: pop
      // 206: aload 12
      // 208: ifnull 268
      // 20b: aload 12
      // 20d: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 210: astore 13
      // 212: aload 13
      // 214: invokevirtual java/lang/String.length ()I
      // 217: ifeq 43b
      // 21a: ldc_w "Content-Encoding: "
      // 21d: aload 13
      // 21f: invokevirtual java/lang/String.concat (Ljava/lang/String;)Ljava/lang/String;
      // 222: astore 13
      // 224: aload 11
      // 226: aload 13
      // 228: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 22b: getstatic com/google/api/client/util/StringUtils.LINE_SEPARATOR Ljava/lang/String;
      // 22e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 231: pop
      // 232: aload 10
      // 234: ifnull 268
      // 237: aload 13
      // 239: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 23c: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 23f: astore 13
      // 241: aload 10
      // 243: new java/lang/StringBuilder
      // 246: dup
      // 247: aload 13
      // 249: invokevirtual java/lang/String.length ()I
      // 24c: bipush 6
      // 24e: iadd
      // 24f: invokespecial java/lang/StringBuilder.<init> (I)V
      // 252: ldc " -H '"
      // 254: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 257: aload 13
      // 259: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 25c: ldc "'"
      // 25e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 261: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 264: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 267: pop
      // 268: lload 7
      // 26a: lconst_0
      // 26b: lcmp
      // 26c: iflt 292
      // 26f: aload 11
      // 271: new java/lang/StringBuilder
      // 274: dup
      // 275: bipush 36
      // 277: invokespecial java/lang/StringBuilder.<init> (I)V
      // 27a: ldc_w "Content-Length: "
      // 27d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 280: lload 7
      // 282: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 285: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 288: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 28b: getstatic com/google/api/client/util/StringUtils.LINE_SEPARATOR Ljava/lang/String;
      // 28e: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 291: pop
      // 292: aload 10
      // 294: ifnull 2a0
      // 297: aload 10
      // 299: ldc_w " -d '@-'"
      // 29c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 29f: pop
      // 2a0: aload 15
      // 2a2: aload 17
      // 2a4: invokevirtual com/google/api/client/http/LowLevelHttpRequest.setContentType (Ljava/lang/String;)V
      // 2a7: aload 15
      // 2a9: aload 12
      // 2ab: invokevirtual com/google/api/client/http/LowLevelHttpRequest.setContentEncoding (Ljava/lang/String;)V
      // 2ae: aload 15
      // 2b0: lload 7
      // 2b2: invokevirtual com/google/api/client/http/LowLevelHttpRequest.setContentLength (J)V
      // 2b5: aload 15
      // 2b7: aload 9
      // 2b9: invokevirtual com/google/api/client/http/LowLevelHttpRequest.setStreamingContent (Lcom/google/api/client/util/StreamingContent;)V
      // 2bc: aload 9
      // 2be: astore 12
      // 2c0: iload 2
      // 2c1: ifeq 30c
      // 2c4: aload 14
      // 2c6: aload 11
      // 2c8: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 2cb: invokevirtual java/util/logging/Logger.config (Ljava/lang/String;)V
      // 2ce: aload 10
      // 2d0: ifnull 30c
      // 2d3: aload 10
      // 2d5: ldc_w " -- '"
      // 2d8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2db: pop
      // 2dc: aload 10
      // 2de: aload 16
      // 2e0: ldc "'"
      // 2e2: ldc_w "'\"'\"'"
      // 2e5: invokevirtual java/lang/String.replaceAll (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 2e8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2eb: pop
      // 2ec: aload 10
      // 2ee: ldc "'"
      // 2f0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 2f3: pop
      // 2f4: aload 12
      // 2f6: ifnull 302
      // 2f9: aload 10
      // 2fb: ldc_w " << $$$"
      // 2fe: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 301: pop
      // 302: aload 14
      // 304: aload 10
      // 306: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 309: invokevirtual java/util/logging/Logger.config (Ljava/lang/String;)V
      // 30c: iload 3
      // 30d: ifeq 44a
      // 310: iload 1
      // 311: ifle 44a
      // 314: bipush 1
      // 315: istore 6
      // 317: aload 15
      // 319: aload 0
      // 31a: getfield com/google/api/client/http/HttpRequest.connectTimeout I
      // 31d: aload 0
      // 31e: getfield com/google/api/client/http/HttpRequest.readTimeout I
      // 321: invokevirtual com/google/api/client/http/LowLevelHttpRequest.setTimeout (II)V
      // 324: aload 15
      // 326: invokevirtual com/google/api/client/http/LowLevelHttpRequest.execute ()Lcom/google/api/client/http/LowLevelHttpResponse;
      // 329: astore 10
      // 32b: new com/google/api/client/http/HttpResponse
      // 32e: astore 9
      // 330: aload 9
      // 332: aload 0
      // 333: aload 10
      // 335: invokespecial com/google/api/client/http/HttpResponse.<init> (Lcom/google/api/client/http/HttpRequest;Lcom/google/api/client/http/LowLevelHttpResponse;)V
      // 338: aconst_null
      // 339: astore 10
      // 33b: aload 9
      // 33d: ifnull 4ed
      // 340: aload 9
      // 342: invokevirtual com/google/api/client/http/HttpResponse.isSuccessStatusCode ()Z
      // 345: ifne 4ed
      // 348: bipush 0
      // 349: istore 4
      // 34b: aload 0
      // 34c: getfield com/google/api/client/http/HttpRequest.unsuccessfulResponseHandler Lcom/google/api/client/http/HttpUnsuccessfulResponseHandler;
      // 34f: ifnull 362
      // 352: aload 0
      // 353: getfield com/google/api/client/http/HttpRequest.unsuccessfulResponseHandler Lcom/google/api/client/http/HttpUnsuccessfulResponseHandler;
      // 356: aload 0
      // 357: aload 9
      // 359: iload 6
      // 35b: invokeinterface com/google/api/client/http/HttpUnsuccessfulResponseHandler.handleResponse (Lcom/google/api/client/http/HttpRequest;Lcom/google/api/client/http/HttpResponse;Z)Z 4
      // 360: istore 4
      // 362: iload 4
      // 364: istore 5
      // 366: iload 4
      // 368: ifne 37f
      // 36b: aload 0
      // 36c: aload 9
      // 36e: invokevirtual com/google/api/client/http/HttpResponse.getStatusCode ()I
      // 371: aload 9
      // 373: invokevirtual com/google/api/client/http/HttpResponse.getHeaders ()Lcom/google/api/client/http/HttpHeaders;
      // 376: invokevirtual com/google/api/client/http/HttpRequest.handleRedirect (ILcom/google/api/client/http/HttpHeaders;)Z
      // 379: ifeq 49b
      // 37c: bipush 1
      // 37d: istore 5
      // 37f: iload 6
      // 381: iload 5
      // 383: iand
      // 384: istore 3
      // 385: iload 3
      // 386: istore 2
      // 387: iload 3
      // 388: ifeq 392
      // 38b: aload 9
      // 38d: invokevirtual com/google/api/client/http/HttpResponse.ignore ()V
      // 390: iload 3
      // 391: istore 2
      // 392: aload 9
      // 394: ifnull 397
      // 397: iload 2
      // 398: ifne 552
      // 39b: aload 9
      // 39d: ifnonnull 510
      // 3a0: aload 10
      // 3a2: athrow
      // 3a3: bipush 0
      // 3a4: istore 4
      // 3a6: goto 00a
      // 3a9: bipush 0
      // 3aa: istore 2
      // 3ab: goto 083
      // 3ae: aload 0
      // 3af: getfield com/google/api/client/http/HttpRequest.headers Lcom/google/api/client/http/HttpHeaders;
      // 3b2: astore 17
      // 3b4: aload 9
      // 3b6: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 3b9: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 3bc: astore 13
      // 3be: ldc "Google-HTTP-Java-Client/1.23.0 (gzip)"
      // 3c0: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 3c3: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 3c6: astore 12
      // 3c8: aload 17
      // 3ca: new java/lang/StringBuilder
      // 3cd: dup
      // 3ce: aload 13
      // 3d0: invokevirtual java/lang/String.length ()I
      // 3d3: bipush 1
      // 3d4: iadd
      // 3d5: aload 12
      // 3d7: invokevirtual java/lang/String.length ()I
      // 3da: iadd
      // 3db: invokespecial java/lang/StringBuilder.<init> (I)V
      // 3de: aload 13
      // 3e0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3e3: ldc_w " "
      // 3e6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3e9: aload 12
      // 3eb: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3ee: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3f1: invokevirtual com/google/api/client/http/HttpHeaders.setUserAgent (Ljava/lang/String;)Lcom/google/api/client/http/HttpHeaders;
      // 3f4: pop
      // 3f5: goto 126
      // 3f8: bipush 0
      // 3f9: istore 3
      // 3fa: goto 15f
      // 3fd: aload 0
      // 3fe: getfield com/google/api/client/http/HttpRequest.encoding Lcom/google/api/client/http/HttpEncoding;
      // 401: invokeinterface com/google/api/client/http/HttpEncoding.getName ()Ljava/lang/String; 1
      // 406: astore 12
      // 408: new com/google/api/client/http/HttpEncodingStreamingContent
      // 40b: dup
      // 40c: aload 9
      // 40e: aload 0
      // 40f: getfield com/google/api/client/http/HttpRequest.encoding Lcom/google/api/client/http/HttpEncoding;
      // 412: invokespecial com/google/api/client/http/HttpEncodingStreamingContent.<init> (Lcom/google/api/client/util/StreamingContent;Lcom/google/api/client/http/HttpEncoding;)V
      // 415: astore 9
      // 417: iload 3
      // 418: ifeq 425
      // 41b: aload 9
      // 41d: invokestatic com/google/api/client/util/IOUtils.computeLength (Lcom/google/api/client/util/StreamingContent;)J
      // 420: lstore 7
      // 422: goto 1a1
      // 425: ldc2_w -1
      // 428: lstore 7
      // 42a: goto 422
      // 42d: new java/lang/String
      // 430: dup
      // 431: ldc "Content-Type: "
      // 433: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 436: astore 13
      // 438: goto 1c2
      // 43b: new java/lang/String
      // 43e: dup
      // 43f: ldc_w "Content-Encoding: "
      // 442: invokespecial java/lang/String.<init> (Ljava/lang/String;)V
      // 445: astore 13
      // 447: goto 224
      // 44a: bipush 0
      // 44b: istore 6
      // 44d: goto 317
      // 450: astore 9
      // 452: aload 10
      // 454: invokevirtual com/google/api/client/http/LowLevelHttpResponse.getContent ()Ljava/io/InputStream;
      // 457: astore 10
      // 459: aload 10
      // 45b: ifnull 463
      // 45e: aload 10
      // 460: invokevirtual java/io/InputStream.close ()V
      // 463: aload 9
      // 465: athrow
      // 466: astore 10
      // 468: aconst_null
      // 469: astore 9
      // 46b: aload 0
      // 46c: getfield com/google/api/client/http/HttpRequest.retryOnExecuteIOException Z
      // 46f: ifne 48b
      // 472: aload 0
      // 473: getfield com/google/api/client/http/HttpRequest.ioExceptionHandler Lcom/google/api/client/http/HttpIOExceptionHandler;
      // 476: ifnull 488
      // 479: aload 0
      // 47a: getfield com/google/api/client/http/HttpRequest.ioExceptionHandler Lcom/google/api/client/http/HttpIOExceptionHandler;
      // 47d: aload 0
      // 47e: iload 6
      // 480: invokeinterface com/google/api/client/http/HttpIOExceptionHandler.handleIOException (Lcom/google/api/client/http/HttpRequest;Z)Z 3
      // 485: ifne 48b
      // 488: aload 10
      // 48a: athrow
      // 48b: aload 14
      // 48d: getstatic java/util/logging/Level.WARNING Ljava/util/logging/Level;
      // 490: ldc_w "exception thrown while executing request"
      // 493: aload 10
      // 495: invokevirtual java/util/logging/Logger.log (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 498: goto 33b
      // 49b: iload 4
      // 49d: istore 5
      // 49f: iload 6
      // 4a1: ifeq 37f
      // 4a4: iload 4
      // 4a6: istore 5
      // 4a8: aload 0
      // 4a9: getfield com/google/api/client/http/HttpRequest.backOffPolicy Lcom/google/api/client/http/BackOffPolicy;
      // 4ac: ifnull 37f
      // 4af: iload 4
      // 4b1: istore 5
      // 4b3: aload 0
      // 4b4: getfield com/google/api/client/http/HttpRequest.backOffPolicy Lcom/google/api/client/http/BackOffPolicy;
      // 4b7: aload 9
      // 4b9: invokevirtual com/google/api/client/http/HttpResponse.getStatusCode ()I
      // 4bc: invokeinterface com/google/api/client/http/BackOffPolicy.isBackOffRequired (I)Z 2
      // 4c1: ifeq 37f
      // 4c4: aload 0
      // 4c5: getfield com/google/api/client/http/HttpRequest.backOffPolicy Lcom/google/api/client/http/BackOffPolicy;
      // 4c8: invokeinterface com/google/api/client/http/BackOffPolicy.getNextBackOffMillis ()J 1
      // 4cd: lstore 7
      // 4cf: iload 4
      // 4d1: istore 5
      // 4d3: lload 7
      // 4d5: ldc2_w -1
      // 4d8: lcmp
      // 4d9: ifeq 37f
      // 4dc: aload 0
      // 4dd: getfield com/google/api/client/http/HttpRequest.sleeper Lcom/google/api/client/util/Sleeper;
      // 4e0: lload 7
      // 4e2: invokeinterface com/google/api/client/util/Sleeper.sleep (J)V 3
      // 4e7: bipush 1
      // 4e8: istore 5
      // 4ea: goto 37f
      // 4ed: aload 9
      // 4ef: ifnonnull 4fc
      // 4f2: bipush 1
      // 4f3: istore 2
      // 4f4: iload 6
      // 4f6: iload 2
      // 4f7: iand
      // 4f8: istore 2
      // 4f9: goto 392
      // 4fc: bipush 0
      // 4fd: istore 2
      // 4fe: goto 4f4
      // 501: astore 10
      // 503: aload 9
      // 505: ifnull 50d
      // 508: aload 9
      // 50a: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 50d: aload 10
      // 50f: athrow
      // 510: aload 0
      // 511: getfield com/google/api/client/http/HttpRequest.responseInterceptor Lcom/google/api/client/http/HttpResponseInterceptor;
      // 514: ifnull 522
      // 517: aload 0
      // 518: getfield com/google/api/client/http/HttpRequest.responseInterceptor Lcom/google/api/client/http/HttpResponseInterceptor;
      // 51b: aload 9
      // 51d: invokeinterface com/google/api/client/http/HttpResponseInterceptor.interceptResponse (Lcom/google/api/client/http/HttpResponse;)V 2
      // 522: aload 0
      // 523: getfield com/google/api/client/http/HttpRequest.throwExceptionOnExecuteError Z
      // 526: ifeq 54a
      // 529: aload 9
      // 52b: invokevirtual com/google/api/client/http/HttpResponse.isSuccessStatusCode ()Z
      // 52e: ifne 54a
      // 531: new com/google/api/client/http/HttpResponseException
      // 534: astore 10
      // 536: aload 10
      // 538: aload 9
      // 53a: invokespecial com/google/api/client/http/HttpResponseException.<init> (Lcom/google/api/client/http/HttpResponse;)V
      // 53d: aload 10
      // 53f: athrow
      // 540: astore 10
      // 542: aload 9
      // 544: invokevirtual com/google/api/client/http/HttpResponse.disconnect ()V
      // 547: aload 10
      // 549: athrow
      // 54a: aload 9
      // 54c: areturn
      // 54d: astore 11
      // 54f: goto 4e7
      // 552: iinc 1 -1
      // 555: goto 037
      // 558: goto 18c
      // try (355 -> 358): 502 java/io/IOException
      // try (358 -> 364): 492 null
      // try (368 -> 371): 571 null
      // try (373 -> 383): 571 null
      // try (387 -> 394): 571 null
      // try (404 -> 406): 571 null
      // try (493 -> 496): 502 java/io/IOException
      // try (498 -> 500): 502 java/io/IOException
      // try (500 -> 502): 502 java/io/IOException
      // try (531 -> 534): 571 null
      // try (536 -> 546): 571 null
      // try (552 -> 556): 605 java/lang/InterruptedException
      // try (552 -> 556): 571 null
      // try (591 -> 598): 598 null
   }

   @Beta
   public Future<HttpResponse> executeAsync() {
      return this.executeAsync(Executors.newSingleThreadExecutor());
   }

   @Beta
   public Future<HttpResponse> executeAsync(Executor var1) {
      FutureTask var2 = new FutureTask<>(new Callable<HttpResponse>(this) {
         final HttpRequest this$0;

         {
            this.this$0 = var1;
         }

         public HttpResponse call() throws Exception {
            return this.this$0.execute();
         }
      });
      var1.execute(var2);
      return var2;
   }

   @Deprecated
   @Beta
   public BackOffPolicy getBackOffPolicy() {
      return this.backOffPolicy;
   }

   public int getConnectTimeout() {
      return this.connectTimeout;
   }

   public HttpContent getContent() {
      return this.content;
   }

   public int getContentLoggingLimit() {
      return this.contentLoggingLimit;
   }

   public HttpEncoding getEncoding() {
      return this.encoding;
   }

   public boolean getFollowRedirects() {
      return this.followRedirects;
   }

   public HttpHeaders getHeaders() {
      return this.headers;
   }

   @Beta
   public HttpIOExceptionHandler getIOExceptionHandler() {
      return this.ioExceptionHandler;
   }

   public HttpExecuteInterceptor getInterceptor() {
      return this.executeInterceptor;
   }

   public int getNumberOfRetries() {
      return this.numRetries;
   }

   public final ObjectParser getParser() {
      return this.objectParser;
   }

   public int getReadTimeout() {
      return this.readTimeout;
   }

   public String getRequestMethod() {
      return this.requestMethod;
   }

   public HttpHeaders getResponseHeaders() {
      return this.responseHeaders;
   }

   public HttpResponseInterceptor getResponseInterceptor() {
      return this.responseInterceptor;
   }

   @Deprecated
   @Beta
   public boolean getRetryOnExecuteIOException() {
      return this.retryOnExecuteIOException;
   }

   public Sleeper getSleeper() {
      return this.sleeper;
   }

   public boolean getSuppressUserAgentSuffix() {
      return this.suppressUserAgentSuffix;
   }

   public boolean getThrowExceptionOnExecuteError() {
      return this.throwExceptionOnExecuteError;
   }

   public HttpTransport getTransport() {
      return this.transport;
   }

   public HttpUnsuccessfulResponseHandler getUnsuccessfulResponseHandler() {
      return this.unsuccessfulResponseHandler;
   }

   public GenericUrl getUrl() {
      return this.url;
   }

   public boolean handleRedirect(int var1, HttpHeaders var2) {
      String var4 = var2.getLocation();
      boolean var3;
      if (this.getFollowRedirects() && HttpStatusCodes.isRedirect(var1) && var4 != null) {
         this.setUrl(new GenericUrl(this.url.toURL(var4)));
         if (var1 == 303) {
            this.setRequestMethod("GET");
            this.setContent(null);
         }

         this.headers.setAuthorization((String)null);
         this.headers.setIfMatch((String)null);
         this.headers.setIfNoneMatch((String)null);
         this.headers.setIfModifiedSince((String)null);
         this.headers.setIfUnmodifiedSince((String)null);
         this.headers.setIfRange((String)null);
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public boolean isCurlLoggingEnabled() {
      return this.curlLoggingEnabled;
   }

   public boolean isLoggingEnabled() {
      return this.loggingEnabled;
   }

   @Deprecated
   @Beta
   public HttpRequest setBackOffPolicy(BackOffPolicy var1) {
      this.backOffPolicy = var1;
      return this;
   }

   public HttpRequest setConnectTimeout(int var1) {
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.connectTimeout = var1;
      return this;
   }

   public HttpRequest setContent(HttpContent var1) {
      this.content = var1;
      return this;
   }

   public HttpRequest setContentLoggingLimit(int var1) {
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

   public HttpRequest setCurlLoggingEnabled(boolean var1) {
      this.curlLoggingEnabled = var1;
      return this;
   }

   public HttpRequest setEncoding(HttpEncoding var1) {
      this.encoding = var1;
      return this;
   }

   public HttpRequest setFollowRedirects(boolean var1) {
      this.followRedirects = var1;
      return this;
   }

   public HttpRequest setHeaders(HttpHeaders var1) {
      this.headers = Preconditions.checkNotNull(var1);
      return this;
   }

   @Beta
   public HttpRequest setIOExceptionHandler(HttpIOExceptionHandler var1) {
      this.ioExceptionHandler = var1;
      return this;
   }

   public HttpRequest setInterceptor(HttpExecuteInterceptor var1) {
      this.executeInterceptor = var1;
      return this;
   }

   public HttpRequest setLoggingEnabled(boolean var1) {
      this.loggingEnabled = var1;
      return this;
   }

   public HttpRequest setNumberOfRetries(int var1) {
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.numRetries = var1;
      return this;
   }

   public HttpRequest setParser(ObjectParser var1) {
      this.objectParser = var1;
      return this;
   }

   public HttpRequest setReadTimeout(int var1) {
      boolean var2;
      if (var1 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.readTimeout = var1;
      return this;
   }

   public HttpRequest setRequestMethod(String var1) {
      boolean var2;
      if (var1 != null && !HttpMediaType.matchesToken(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      Preconditions.checkArgument(var2);
      this.requestMethod = var1;
      return this;
   }

   public HttpRequest setResponseHeaders(HttpHeaders var1) {
      this.responseHeaders = Preconditions.checkNotNull(var1);
      return this;
   }

   public HttpRequest setResponseInterceptor(HttpResponseInterceptor var1) {
      this.responseInterceptor = var1;
      return this;
   }

   @Deprecated
   @Beta
   public HttpRequest setRetryOnExecuteIOException(boolean var1) {
      this.retryOnExecuteIOException = var1;
      return this;
   }

   public HttpRequest setSleeper(Sleeper var1) {
      this.sleeper = Preconditions.checkNotNull(var1);
      return this;
   }

   public HttpRequest setSuppressUserAgentSuffix(boolean var1) {
      this.suppressUserAgentSuffix = var1;
      return this;
   }

   public HttpRequest setThrowExceptionOnExecuteError(boolean var1) {
      this.throwExceptionOnExecuteError = var1;
      return this;
   }

   public HttpRequest setUnsuccessfulResponseHandler(HttpUnsuccessfulResponseHandler var1) {
      this.unsuccessfulResponseHandler = var1;
      return this;
   }

   public HttpRequest setUrl(GenericUrl var1) {
      this.url = Preconditions.checkNotNull(var1);
      return this;
   }
}
