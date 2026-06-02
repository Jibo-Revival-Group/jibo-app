package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import com.jibo.aws.integration.util.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AmazonHttpClient {
   public static final String TAG = a.a(AmazonHttpClient.class);
   final ClientConfiguration config;
   final HttpClient httpClient;
   private final HttpRequestFactory requestFactory = new HttpRequestFactory();
   private final RequestMetricCollector requestMetricCollector;

   public AmazonHttpClient(ClientConfiguration var1, HttpClient var2) {
      this.config = var1;
      this.httpClient = var2;
      this.requestMetricCollector = null;
   }

   @Deprecated
   public AmazonHttpClient(ClientConfiguration var1, HttpClient var2, RequestMetricCollector var3) {
      this.config = var1;
      this.httpClient = var2;
      this.requestMetricCollector = var3;
   }

   @Deprecated
   public AmazonHttpClient(ClientConfiguration var1, RequestMetricCollector var2) {
      this(var1, new UrlHttpClient(var1), var2);
   }

   static String createUserAgentString(String var0, String var1) {
      if (!var0.contains(var1)) {
         var0 = var0.trim() + " " + var1.trim();
      }

      return var0;
   }

   private String getServerDateFromException(String var1) {
      int var3 = var1.indexOf("(");
      int var2;
      if (var1.contains(" + 15")) {
         var2 = var1.indexOf(" + 15");
      } else {
         var2 = var1.indexOf(" - 15");
      }

      return var1.substring(var3 + 1, var2);
   }

   private <T extends Throwable> T handleUnexpectedFailure(T var1, AWSRequestMetrics var2) {
      var2.incrementCounter(AWSRequestMetrics.Field.Exception);
      var2.addProperty(AWSRequestMetrics.Field.Exception, var1);
      return (T)var1;
   }

   private boolean isRequestSuccessful(HttpResponse var1) {
      int var2 = var1.getStatusCode();
      boolean var3;
      if (var2 >= 200 && var2 < 300) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private static boolean isTemporaryRedirect(HttpResponse var0) {
      int var1 = var0.getStatusCode();
      String var3 = var0.getHeaders().get("Location");
      boolean var2;
      if (var1 == 307 && var3 != null && !var3.isEmpty()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private void pauseBeforeNextRetry(AmazonWebServiceRequest var1, AmazonClientException var2, int var3, RetryPolicy var4) {
      var3 = var3 - 1 - 1;
      long var5 = var4.getBackoffStrategy().delayBeforeNextRetry(var1, var2, var3);
      a.a(TAG, "Retriable error detected, will retry in " + var5 + "ms, attempt number: " + var3);

      try {
         Thread.sleep(var5);
      } catch (InterruptedException var7) {
         Thread.currentThread().interrupt();
         throw new AmazonClientException(var7.getMessage(), var7);
      }
   }

   private void setUserAgent(Request<?> var1) {
      String var3 = this.config.getUserAgent();
      String var2 = var3;
      if (!var3.equals(ClientConfiguration.DEFAULT_USER_AGENT)) {
         var2 = var3 + ", " + ClientConfiguration.DEFAULT_USER_AGENT;
      }

      if (var2 != null) {
         var1.addHeader("User-Agent", var2);
      }

      AmazonWebServiceRequest var4 = var1.getOriginalRequest();
      if (var4 != null) {
         RequestClientOptions var5 = var4.getRequestClientOptions();
         if (var5 != null) {
            var3 = var5.getClientMarker(RequestClientOptions.Marker.USER_AGENT);
            if (var3 != null) {
               var1.addHeader("User-Agent", createUserAgentString(var2, var3));
            }
         }
      }
   }

   private boolean shouldRetry(AmazonWebServiceRequest var1, InputStream var2, AmazonClientException var3, int var4, RetryPolicy var5) {
      boolean var7 = false;
      int var6 = var4 - 1;
      var4 = this.config.getMaxErrorRetry();
      if (var4 < 0 || !var5.isMaxErrorRetryInClientConfigHonored()) {
         var4 = var5.getMaxErrorRetry();
      }

      if (var6 < var4) {
         if (var2 != null && !var2.markSupported()) {
            a.a(TAG, "Content not repeatable");
         } else {
            var7 = var5.getRetryCondition().shouldRetry(var1, var3, var6);
         }
      }

      return var7;
   }

   void afterError(Request<?> var1, Response<?> var2, List<RequestHandler2> var3, AmazonClientException var4) {
      Iterator var5 = var3.iterator();

      while (var5.hasNext()) {
         ((RequestHandler2)var5.next()).afterError(var1, var2, var4);
      }
   }

   <T> void afterResponse(Request<?> var1, List<RequestHandler2> var2, Response<T> var3, TimingInfo var4) {
      Iterator var5 = var2.iterator();

      while (var5.hasNext()) {
         ((RequestHandler2)var5.next()).afterResponse(var1, var3);
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public <T> Response<T> execute(
      Request<?> var1, HttpResponseHandler<AmazonWebServiceResponse<T>> var2, HttpResponseHandler<AmazonServiceException> var3, ExecutionContext var4
   ) {
      if (var4 == null) {
         throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
      }

      List var6 = this.requestHandler2s(var1, var4);
      AWSRequestMetrics var7 = var4.getAwsRequestMetrics();
      Response var5 = null;

      try {
         var10 = this.executeHelper(var1, var2, var3, var4);
      } catch (AmazonClientException var9) {
         this.afterError(var1, var5, var6, var9);
         throw var9;
      }

      var5 = var10;

      try {
         this.afterResponse(var1, var6, var10, var7.getTimingInfo().endTiming());
         return var10;
      } catch (AmazonClientException var8) {
         this.afterError(var1, var5, var6, var8);
         throw var8;
      }
   }

   <T> Response<T> executeHelper(
      Request<?> param1, HttpResponseHandler<AmazonWebServiceResponse<T>> param2, HttpResponseHandler<AmazonServiceException> param3, ExecutionContext param4
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aload 4
      // 002: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 005: astore 21
      // 007: aload 21
      // 009: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ServiceName Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 00c: aload 1
      // 00d: invokeinterface com/amazonaws/Request.getServiceName ()Ljava/lang/String; 1
      // 012: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 015: aload 21
      // 017: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ServiceEndpoint Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 01a: aload 1
      // 01b: invokeinterface com/amazonaws/Request.getEndpoint ()Ljava/net/URI; 1
      // 020: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 023: aload 0
      // 024: aload 1
      // 025: invokespecial com/amazonaws/http/AmazonHttpClient.setUserAgent (Lcom/amazonaws/Request;)V
      // 028: bipush 0
      // 029: istore 5
      // 02b: aconst_null
      // 02c: astore 16
      // 02e: new java/util/LinkedHashMap
      // 031: dup
      // 032: invokespecial java/util/LinkedHashMap.<init> ()V
      // 035: astore 24
      // 037: aload 24
      // 039: aload 1
      // 03a: invokeinterface com/amazonaws/Request.getParameters ()Ljava/util/Map; 1
      // 03f: invokeinterface java/util/Map.putAll (Ljava/util/Map;)V 2
      // 044: new java/util/HashMap
      // 047: dup
      // 048: invokespecial java/util/HashMap.<init> ()V
      // 04b: astore 22
      // 04d: aload 22
      // 04f: aload 1
      // 050: invokeinterface com/amazonaws/Request.getHeaders ()Ljava/util/Map; 1
      // 055: invokeinterface java/util/Map.putAll (Ljava/util/Map;)V 2
      // 05a: aload 4
      // 05c: invokevirtual com/amazonaws/http/ExecutionContext.getCredentials ()Lcom/amazonaws/auth/AWSCredentials;
      // 05f: astore 23
      // 061: aconst_null
      // 062: astore 13
      // 064: aconst_null
      // 065: astore 11
      // 067: aconst_null
      // 068: astore 14
      // 06a: aconst_null
      // 06b: astore 15
      // 06d: bipush 0
      // 06e: istore 6
      // 070: iinc 5 1
      // 073: aload 21
      // 075: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestCount Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 078: iload 5
      // 07a: i2l
      // 07b: invokevirtual com/amazonaws/util/AWSRequestMetrics.setCounter (Lcom/amazonaws/metrics/MetricType;J)V
      // 07e: iload 5
      // 080: bipush 1
      // 081: if_icmple 094
      // 084: aload 1
      // 085: aload 24
      // 087: invokeinterface com/amazonaws/Request.setParameters (Ljava/util/Map;)V 2
      // 08c: aload 1
      // 08d: aload 22
      // 08f: invokeinterface com/amazonaws/Request.setHeaders (Ljava/util/Map;)V 2
      // 094: aload 13
      // 096: ifnonnull 94c
      // 099: aload 4
      // 09b: aload 1
      // 09c: invokeinterface com/amazonaws/Request.getEndpoint ()Ljava/net/URI; 1
      // 0a1: invokevirtual com/amazonaws/http/ExecutionContext.getSignerByURI (Ljava/net/URI;)Lcom/amazonaws/auth/Signer;
      // 0a4: astore 12
      // 0a6: aload 12
      // 0a8: ifnull 0ca
      // 0ab: aload 23
      // 0ad: ifnull 0ca
      // 0b0: aload 21
      // 0b2: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestSigningTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 0b5: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 0b8: aload 12
      // 0ba: aload 1
      // 0bb: aload 23
      // 0bd: invokeinterface com/amazonaws/auth/Signer.sign (Lcom/amazonaws/Request;Lcom/amazonaws/auth/AWSCredentials;)V 3
      // 0c2: aload 21
      // 0c4: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestSigningTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 0c7: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 0ca: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 0cd: astore 17
      // 0cf: new java/lang/StringBuilder
      // 0d2: astore 13
      // 0d4: aload 13
      // 0d6: invokespecial java/lang/StringBuilder.<init> ()V
      // 0d9: aload 17
      // 0db: aload 13
      // 0dd: ldc_w "Sending Request: "
      // 0e0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0e3: aload 1
      // 0e4: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 0e7: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 0ea: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 0ed: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;)V
      // 0f0: aload 1
      // 0f1: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 0f6: ifnull 14a
      // 0f9: aload 1
      // 0fa: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 0ff: invokevirtual java/io/InputStream.markSupported ()Z
      // 102: istore 7
      // 104: iload 7
      // 106: ifeq 14a
      // 109: aload 1
      // 10a: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 10f: bipush -1
      // 110: invokevirtual java/io/InputStream.mark (I)V
      // 113: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 116: astore 17
      // 118: new java/lang/StringBuilder
      // 11b: astore 13
      // 11d: aload 13
      // 11f: invokespecial java/lang/StringBuilder.<init> ()V
      // 122: aload 17
      // 124: aload 13
      // 126: ldc_w "Body: "
      // 129: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 12c: aload 1
      // 12d: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 132: sipush 1024
      // 135: invokestatic com/jibo/aws/integration/util/Commons.streamToString (Ljava/io/InputStream;I)Ljava/lang/String;
      // 138: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 13b: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 13e: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;)V
      // 141: aload 1
      // 142: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 147: invokevirtual java/io/InputStream.reset ()V
      // 14a: aload 0
      // 14b: getfield com/amazonaws/http/AmazonHttpClient.requestFactory Lcom/amazonaws/http/HttpRequestFactory;
      // 14e: aload 1
      // 14f: aload 0
      // 150: getfield com/amazonaws/http/AmazonHttpClient.config Lcom/amazonaws/ClientConfiguration;
      // 153: aload 4
      // 155: invokevirtual com/amazonaws/http/HttpRequestFactory.createHttpRequest (Lcom/amazonaws/Request;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/http/HttpRequest;
      // 158: astore 13
      // 15a: aload 15
      // 15c: ifnull 166
      // 15f: aload 13
      // 161: aload 15
      // 163: invokevirtual com/amazonaws/http/HttpRequest.setUri (Ljava/net/URI;)V
      // 166: iload 5
      // 168: bipush 1
      // 169: if_icmple 191
      // 16c: aload 21
      // 16e: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RetryPauseTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 171: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 174: aload 0
      // 175: aload 1
      // 176: invokeinterface com/amazonaws/Request.getOriginalRequest ()Lcom/amazonaws/AmazonWebServiceRequest; 1
      // 17b: aload 16
      // 17d: iload 5
      // 17f: aload 0
      // 180: getfield com/amazonaws/http/AmazonHttpClient.config Lcom/amazonaws/ClientConfiguration;
      // 183: invokevirtual com/amazonaws/ClientConfiguration.getRetryPolicy ()Lcom/amazonaws/retry/RetryPolicy;
      // 186: invokespecial com/amazonaws/http/AmazonHttpClient.pauseBeforeNextRetry (Lcom/amazonaws/AmazonWebServiceRequest;Lcom/amazonaws/AmazonClientException;ILcom/amazonaws/retry/RetryPolicy;)V
      // 189: aload 21
      // 18b: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RetryPauseTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 18e: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 191: aload 13
      // 193: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 196: astore 14
      // 198: aload 14
      // 19a: ifnull 1b6
      // 19d: iload 5
      // 19f: bipush 1
      // 1a0: if_icmple 4c0
      // 1a3: aload 14
      // 1a5: invokevirtual java/io/InputStream.markSupported ()Z
      // 1a8: ifeq 1b6
      // 1ab: aload 14
      // 1ad: invokevirtual java/io/InputStream.reset ()V
      // 1b0: aload 14
      // 1b2: bipush -1
      // 1b3: invokevirtual java/io/InputStream.mark (I)V
      // 1b6: aconst_null
      // 1b7: astore 20
      // 1b9: aload 21
      // 1bb: getstatic com/amazonaws/util/AWSRequestMetrics$Field.HttpRequestTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 1be: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 1c1: aload 0
      // 1c2: getfield com/amazonaws/http/AmazonHttpClient.httpClient Lcom/amazonaws/http/HttpClient;
      // 1c5: aload 13
      // 1c7: invokeinterface com/amazonaws/http/HttpClient.execute (Lcom/amazonaws/http/HttpRequest;)Lcom/amazonaws/http/HttpResponse; 2
      // 1cc: astore 14
      // 1ce: aload 14
      // 1d0: astore 11
      // 1d2: getstatic com/jibo/aws/integration/util/Commons._DEBUG_LOG_OUTPUT Z
      // 1d5: ifeq 282
      // 1d8: aload 11
      // 1da: invokevirtual com/amazonaws/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 1dd: ifnull 282
      // 1e0: ldc_w "application/json"
      // 1e3: aload 11
      // 1e5: invokevirtual com/amazonaws/http/HttpResponse.getHeaders ()Ljava/util/Map;
      // 1e8: ldc_w "Content-Type"
      // 1eb: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 1f0: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1f3: istore 7
      // 1f5: iload 7
      // 1f7: ifeq 282
      // 1fa: aload 11
      // 1fc: invokevirtual com/amazonaws/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 1ff: invokestatic com/amazonaws/util/IOUtils.toByteArray (Ljava/io/InputStream;)[B
      // 202: astore 14
      // 204: new java/io/ByteArrayInputStream
      // 207: astore 16
      // 209: aload 16
      // 20b: aload 14
      // 20d: invokespecial java/io/ByteArrayInputStream.<init> ([B)V
      // 210: aload 16
      // 212: astore 14
      // 214: aload 16
      // 216: invokevirtual java/io/ByteArrayInputStream.markSupported ()Z
      // 219: ifeq 26e
      // 21c: aload 16
      // 21e: astore 14
      // 220: aload 16
      // 222: bipush -1
      // 223: invokevirtual java/io/ByteArrayInputStream.mark (I)V
      // 226: aload 16
      // 228: astore 14
      // 22a: aload 16
      // 22c: invokestatic com/amazonaws/util/IOUtils.toString (Ljava/io/InputStream;)Ljava/lang/String;
      // 22f: astore 17
      // 231: aload 16
      // 233: astore 14
      // 235: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 238: astore 19
      // 23a: aload 16
      // 23c: astore 14
      // 23e: new java/lang/StringBuilder
      // 241: astore 18
      // 243: aload 16
      // 245: astore 14
      // 247: aload 18
      // 249: invokespecial java/lang/StringBuilder.<init> ()V
      // 24c: aload 16
      // 24e: astore 14
      // 250: aload 19
      // 252: aload 18
      // 254: ldc_w "Content: "
      // 257: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 25a: aload 17
      // 25c: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 25f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 262: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;)V
      // 265: aload 16
      // 267: astore 14
      // 269: aload 16
      // 26b: invokevirtual java/io/ByteArrayInputStream.reset ()V
      // 26e: aload 16
      // 270: ifnull 282
      // 273: aload 11
      // 275: invokevirtual com/amazonaws/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 278: invokevirtual java/io/InputStream.close ()V
      // 27b: aload 11
      // 27d: aload 16
      // 27f: invokevirtual com/amazonaws/http/HttpResponse.setContent (Ljava/io/InputStream;)V
      // 282: iload 6
      // 284: istore 7
      // 286: aload 11
      // 288: astore 14
      // 28a: aload 11
      // 28c: astore 19
      // 28e: aload 15
      // 290: astore 16
      // 292: iload 6
      // 294: istore 9
      // 296: aload 11
      // 298: astore 17
      // 29a: iload 6
      // 29c: istore 8
      // 29e: aload 11
      // 2a0: astore 18
      // 2a2: aload 21
      // 2a4: getstatic com/amazonaws/util/AWSRequestMetrics$Field.HttpRequestTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 2a7: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 2aa: iload 6
      // 2ac: istore 7
      // 2ae: aload 11
      // 2b0: astore 14
      // 2b2: aload 11
      // 2b4: astore 19
      // 2b6: aload 15
      // 2b8: astore 16
      // 2ba: iload 6
      // 2bc: istore 9
      // 2be: aload 11
      // 2c0: astore 17
      // 2c2: iload 6
      // 2c4: istore 8
      // 2c6: aload 11
      // 2c8: astore 18
      // 2ca: aload 0
      // 2cb: aload 11
      // 2cd: invokespecial com/amazonaws/http/AmazonHttpClient.isRequestSuccessful (Lcom/amazonaws/http/HttpResponse;)Z
      // 2d0: ifeq 583
      // 2d3: iload 6
      // 2d5: istore 7
      // 2d7: aload 11
      // 2d9: astore 14
      // 2db: aload 11
      // 2dd: astore 19
      // 2df: aload 15
      // 2e1: astore 16
      // 2e3: iload 6
      // 2e5: istore 9
      // 2e7: aload 11
      // 2e9: astore 17
      // 2eb: iload 6
      // 2ed: istore 8
      // 2ef: aload 11
      // 2f1: astore 18
      // 2f3: aload 21
      // 2f5: getstatic com/amazonaws/util/AWSRequestMetrics$Field.StatusCode Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 2f8: aload 11
      // 2fa: invokevirtual com/amazonaws/http/HttpResponse.getStatusCode ()I
      // 2fd: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 300: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 303: iload 6
      // 305: istore 7
      // 307: aload 11
      // 309: astore 14
      // 30b: aload 11
      // 30d: astore 19
      // 30f: aload 15
      // 311: astore 16
      // 313: iload 6
      // 315: istore 9
      // 317: aload 11
      // 319: astore 17
      // 31b: iload 6
      // 31d: istore 8
      // 31f: aload 11
      // 321: astore 18
      // 323: aload 2
      // 324: invokeinterface com/amazonaws/http/HttpResponseHandler.needsConnectionLeftOpen ()Z 1
      // 329: istore 10
      // 32b: iload 10
      // 32d: istore 6
      // 32f: iload 6
      // 331: istore 7
      // 333: aload 11
      // 335: astore 14
      // 337: iload 6
      // 339: istore 9
      // 33b: aload 11
      // 33d: astore 17
      // 33f: iload 6
      // 341: istore 8
      // 343: aload 11
      // 345: astore 18
      // 347: new com/amazonaws/Response
      // 34a: dup
      // 34b: aload 0
      // 34c: aload 1
      // 34d: aload 2
      // 34e: aload 11
      // 350: aload 4
      // 352: invokevirtual com/amazonaws/http/AmazonHttpClient.handleResponse (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/HttpResponse;Lcom/amazonaws/http/ExecutionContext;)Ljava/lang/Object;
      // 355: aload 11
      // 357: invokespecial com/amazonaws/Response.<init> (Ljava/lang/Object;Lcom/amazonaws/http/HttpResponse;)V
      // 35a: astore 16
      // 35c: iload 6
      // 35e: ifne 376
      // 361: aload 11
      // 363: ifnull 376
      // 366: aload 11
      // 368: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 36b: ifnull 376
      // 36e: aload 11
      // 370: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 373: invokevirtual java/io/InputStream.close ()V
      // 376: aload 1
      // 377: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 37c: ifnull 388
      // 37f: aload 1
      // 380: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 385: invokevirtual java/io/InputStream.close ()V
      // 388: aload 16
      // 38a: areturn
      // 38b: astore 13
      // 38d: aload 21
      // 38f: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestSigningTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 392: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 395: aload 13
      // 397: athrow
      // 398: astore 16
      // 39a: aload 14
      // 39c: astore 13
      // 39e: aload 16
      // 3a0: astore 14
      // 3a2: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 3a5: astore 16
      // 3a7: new java/lang/StringBuilder
      // 3aa: astore 17
      // 3ac: aload 17
      // 3ae: invokespecial java/lang/StringBuilder.<init> ()V
      // 3b1: aload 16
      // 3b3: aload 17
      // 3b5: ldc_w "Unable to execute HTTP request: "
      // 3b8: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3bb: aload 14
      // 3bd: invokevirtual java/io/IOException.getMessage ()Ljava/lang/String;
      // 3c0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3c3: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 3c6: aload 14
      // 3c8: invokestatic com/jibo/aws/integration/util/a.b (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 3cb: aload 21
      // 3cd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.Exception Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 3d0: invokevirtual com/amazonaws/util/AWSRequestMetrics.incrementCounter (Lcom/amazonaws/metrics/MetricType;)V
      // 3d3: aload 21
      // 3d5: getstatic com/amazonaws/util/AWSRequestMetrics$Field.Exception Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 3d8: aload 14
      // 3da: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 3dd: aload 21
      // 3df: getstatic com/amazonaws/util/AWSRequestMetrics$Field.AWSRequestID Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 3e2: aconst_null
      // 3e3: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 3e6: new com/amazonaws/AmazonClientException
      // 3e9: astore 18
      // 3eb: new java/lang/StringBuilder
      // 3ee: astore 16
      // 3f0: aload 16
      // 3f2: invokespecial java/lang/StringBuilder.<init> ()V
      // 3f5: aload 18
      // 3f7: aload 16
      // 3f9: ldc_w "Unable to execute HTTP request: "
      // 3fc: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 3ff: aload 14
      // 401: invokevirtual java/io/IOException.getMessage ()Ljava/lang/String;
      // 404: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 407: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 40a: aload 14
      // 40c: invokespecial com/amazonaws/AmazonClientException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 40f: aload 0
      // 410: aload 1
      // 411: invokeinterface com/amazonaws/Request.getOriginalRequest ()Lcom/amazonaws/AmazonWebServiceRequest; 1
      // 416: aload 13
      // 418: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 41b: aload 18
      // 41d: iload 5
      // 41f: aload 0
      // 420: getfield com/amazonaws/http/AmazonHttpClient.config Lcom/amazonaws/ClientConfiguration;
      // 423: invokevirtual com/amazonaws/ClientConfiguration.getRetryPolicy ()Lcom/amazonaws/retry/RetryPolicy;
      // 426: invokespecial com/amazonaws/http/AmazonHttpClient.shouldRetry (Lcom/amazonaws/AmazonWebServiceRequest;Ljava/io/InputStream;Lcom/amazonaws/AmazonClientException;ILcom/amazonaws/retry/RetryPolicy;)Z
      // 429: ifne 854
      // 42c: aload 18
      // 42e: athrow
      // 42f: astore 2
      // 430: iload 6
      // 432: ifne 44a
      // 435: aload 11
      // 437: ifnull 44a
      // 43a: aload 11
      // 43c: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 43f: ifnull 44a
      // 442: aload 11
      // 444: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 447: invokevirtual java/io/InputStream.close ()V
      // 44a: aload 1
      // 44b: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 450: ifnull 45c
      // 453: aload 1
      // 454: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 459: invokevirtual java/io/InputStream.close ()V
      // 45c: aload 2
      // 45d: athrow
      // 45e: astore 13
      // 460: aload 1
      // 461: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 466: invokevirtual java/io/InputStream.reset ()V
      // 469: goto 14a
      // 46c: astore 2
      // 46d: iload 6
      // 46f: istore 7
      // 471: aload 11
      // 473: astore 14
      // 475: aload 0
      // 476: aload 2
      // 477: aload 21
      // 479: invokespecial com/amazonaws/http/AmazonHttpClient.handleUnexpectedFailure (Ljava/lang/Throwable;Lcom/amazonaws/util/AWSRequestMetrics;)Ljava/lang/Throwable;
      // 47c: checkcast java/lang/RuntimeException
      // 47f: athrow
      // 480: astore 2
      // 481: iload 7
      // 483: istore 6
      // 485: aload 14
      // 487: astore 11
      // 489: goto 430
      // 48c: astore 13
      // 48e: aload 1
      // 48f: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 494: invokevirtual java/io/InputStream.reset ()V
      // 497: aload 13
      // 499: athrow
      // 49a: astore 2
      // 49b: iload 6
      // 49d: istore 7
      // 49f: aload 11
      // 4a1: astore 14
      // 4a3: aload 0
      // 4a4: aload 2
      // 4a5: aload 21
      // 4a7: invokespecial com/amazonaws/http/AmazonHttpClient.handleUnexpectedFailure (Ljava/lang/Throwable;Lcom/amazonaws/util/AWSRequestMetrics;)Ljava/lang/Throwable;
      // 4aa: checkcast java/lang/Error
      // 4ad: athrow
      // 4ae: astore 14
      // 4b0: aload 21
      // 4b2: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RetryPauseTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 4b5: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 4b8: aload 14
      // 4ba: athrow
      // 4bb: astore 14
      // 4bd: goto 3a2
      // 4c0: aload 14
      // 4c2: invokevirtual java/io/InputStream.markSupported ()Z
      // 4c5: ifeq 1b6
      // 4c8: aload 14
      // 4ca: bipush -1
      // 4cb: invokevirtual java/io/InputStream.mark (I)V
      // 4ce: goto 1b6
      // 4d1: astore 2
      // 4d2: goto 430
      // 4d5: astore 17
      // 4d7: aconst_null
      // 4d8: astore 14
      // 4da: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 4dd: ldc_w "executeHelper"
      // 4e0: aload 17
      // 4e2: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 4e5: bipush 0
      // 4e6: ifeq 282
      // 4e9: aload 11
      // 4eb: invokevirtual com/amazonaws/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 4ee: invokevirtual java/io/InputStream.close ()V
      // 4f1: aload 11
      // 4f3: aconst_null
      // 4f4: invokevirtual com/amazonaws/http/HttpResponse.setContent (Ljava/io/InputStream;)V
      // 4f7: goto 282
      // 4fa: astore 14
      // 4fc: goto 282
      // 4ff: astore 16
      // 501: aconst_null
      // 502: astore 14
      // 504: aload 14
      // 506: ifnull 518
      // 509: aload 11
      // 50b: invokevirtual com/amazonaws/http/HttpResponse.getContent ()Ljava/io/InputStream;
      // 50e: invokevirtual java/io/InputStream.close ()V
      // 511: aload 11
      // 513: aload 14
      // 515: invokevirtual com/amazonaws/http/HttpResponse.setContent (Ljava/io/InputStream;)V
      // 518: aload 16
      // 51a: athrow
      // 51b: astore 20
      // 51d: iload 6
      // 51f: istore 7
      // 521: aload 11
      // 523: astore 14
      // 525: aload 11
      // 527: astore 19
      // 529: aload 15
      // 52b: astore 16
      // 52d: iload 6
      // 52f: istore 9
      // 531: aload 11
      // 533: astore 17
      // 535: iload 6
      // 537: istore 8
      // 539: aload 11
      // 53b: astore 18
      // 53d: aload 21
      // 53f: getstatic com/amazonaws/util/AWSRequestMetrics$Field.HttpRequestTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 542: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 545: iload 6
      // 547: istore 7
      // 549: aload 11
      // 54b: astore 14
      // 54d: aload 11
      // 54f: astore 19
      // 551: aload 15
      // 553: astore 16
      // 555: iload 6
      // 557: istore 9
      // 559: aload 11
      // 55b: astore 17
      // 55d: iload 6
      // 55f: istore 8
      // 561: aload 11
      // 563: astore 18
      // 565: aload 20
      // 567: athrow
      // 568: astore 14
      // 56a: aload 19
      // 56c: astore 11
      // 56e: aload 16
      // 570: astore 15
      // 572: goto 3a2
      // 575: astore 2
      // 576: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 579: ldc_w "Cannot close the response content."
      // 57c: aload 2
      // 57d: invokestatic com/jibo/aws/integration/util/a.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 580: goto 376
      // 583: iload 6
      // 585: istore 7
      // 587: aload 11
      // 589: astore 14
      // 58b: aload 11
      // 58d: astore 19
      // 58f: aload 15
      // 591: astore 16
      // 593: iload 6
      // 595: istore 9
      // 597: aload 11
      // 599: astore 17
      // 59b: iload 6
      // 59d: istore 8
      // 59f: aload 11
      // 5a1: astore 18
      // 5a3: aload 11
      // 5a5: invokestatic com/amazonaws/http/AmazonHttpClient.isTemporaryRedirect (Lcom/amazonaws/http/HttpResponse;)Z
      // 5a8: ifeq 785
      // 5ab: iload 6
      // 5ad: istore 7
      // 5af: aload 11
      // 5b1: astore 14
      // 5b3: aload 11
      // 5b5: astore 19
      // 5b7: aload 15
      // 5b9: astore 16
      // 5bb: iload 6
      // 5bd: istore 9
      // 5bf: aload 11
      // 5c1: astore 17
      // 5c3: iload 6
      // 5c5: istore 8
      // 5c7: aload 11
      // 5c9: astore 18
      // 5cb: aload 11
      // 5cd: invokevirtual com/amazonaws/http/HttpResponse.getHeaders ()Ljava/util/Map;
      // 5d0: ldc "Location"
      // 5d2: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 5d7: checkcast java/lang/String
      // 5da: astore 25
      // 5dc: iload 6
      // 5de: istore 7
      // 5e0: aload 11
      // 5e2: astore 14
      // 5e4: aload 11
      // 5e6: astore 19
      // 5e8: aload 15
      // 5ea: astore 16
      // 5ec: iload 6
      // 5ee: istore 9
      // 5f0: aload 11
      // 5f2: astore 17
      // 5f4: iload 6
      // 5f6: istore 8
      // 5f8: aload 11
      // 5fa: astore 18
      // 5fc: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 5ff: astore 27
      // 601: iload 6
      // 603: istore 7
      // 605: aload 11
      // 607: astore 14
      // 609: aload 11
      // 60b: astore 19
      // 60d: aload 15
      // 60f: astore 16
      // 611: iload 6
      // 613: istore 9
      // 615: aload 11
      // 617: astore 17
      // 619: iload 6
      // 61b: istore 8
      // 61d: aload 11
      // 61f: astore 18
      // 621: new java/lang/StringBuilder
      // 624: astore 26
      // 626: iload 6
      // 628: istore 7
      // 62a: aload 11
      // 62c: astore 14
      // 62e: aload 11
      // 630: astore 19
      // 632: aload 15
      // 634: astore 16
      // 636: iload 6
      // 638: istore 9
      // 63a: aload 11
      // 63c: astore 17
      // 63e: iload 6
      // 640: istore 8
      // 642: aload 11
      // 644: astore 18
      // 646: aload 26
      // 648: invokespecial java/lang/StringBuilder.<init> ()V
      // 64b: iload 6
      // 64d: istore 7
      // 64f: aload 11
      // 651: astore 14
      // 653: aload 11
      // 655: astore 19
      // 657: aload 15
      // 659: astore 16
      // 65b: iload 6
      // 65d: istore 9
      // 65f: aload 11
      // 661: astore 17
      // 663: iload 6
      // 665: istore 8
      // 667: aload 11
      // 669: astore 18
      // 66b: aload 27
      // 66d: aload 26
      // 66f: ldc_w "Redirecting to: "
      // 672: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 675: aload 25
      // 677: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 67a: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 67d: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;)V
      // 680: iload 6
      // 682: istore 7
      // 684: aload 11
      // 686: astore 14
      // 688: aload 11
      // 68a: astore 19
      // 68c: aload 15
      // 68e: astore 16
      // 690: iload 6
      // 692: istore 9
      // 694: aload 11
      // 696: astore 17
      // 698: iload 6
      // 69a: istore 8
      // 69c: aload 11
      // 69e: astore 18
      // 6a0: aload 25
      // 6a2: invokestatic java/net/URI.create (Ljava/lang/String;)Ljava/net/URI;
      // 6a5: astore 15
      // 6a7: iload 6
      // 6a9: istore 7
      // 6ab: aload 11
      // 6ad: astore 14
      // 6af: aload 11
      // 6b1: astore 19
      // 6b3: aload 15
      // 6b5: astore 16
      // 6b7: iload 6
      // 6b9: istore 9
      // 6bb: aload 11
      // 6bd: astore 17
      // 6bf: iload 6
      // 6c1: istore 8
      // 6c3: aload 11
      // 6c5: astore 18
      // 6c7: aload 21
      // 6c9: getstatic com/amazonaws/util/AWSRequestMetrics$Field.StatusCode Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 6cc: aload 11
      // 6ce: invokevirtual com/amazonaws/http/HttpResponse.getStatusCode ()I
      // 6d1: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 6d4: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 6d7: iload 6
      // 6d9: istore 7
      // 6db: aload 11
      // 6dd: astore 14
      // 6df: aload 11
      // 6e1: astore 19
      // 6e3: aload 15
      // 6e5: astore 16
      // 6e7: iload 6
      // 6e9: istore 9
      // 6eb: aload 11
      // 6ed: astore 17
      // 6ef: iload 6
      // 6f1: istore 8
      // 6f3: aload 11
      // 6f5: astore 18
      // 6f7: aload 21
      // 6f9: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RedirectLocation Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 6fc: aload 25
      // 6fe: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 701: iload 6
      // 703: istore 7
      // 705: aload 11
      // 707: astore 14
      // 709: aload 11
      // 70b: astore 19
      // 70d: aload 15
      // 70f: astore 16
      // 711: iload 6
      // 713: istore 9
      // 715: aload 11
      // 717: astore 17
      // 719: iload 6
      // 71b: istore 8
      // 71d: aload 11
      // 71f: astore 18
      // 721: aload 21
      // 723: getstatic com/amazonaws/util/AWSRequestMetrics$Field.AWSRequestID Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 726: aconst_null
      // 727: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 72a: aload 15
      // 72c: astore 14
      // 72e: aload 20
      // 730: astore 15
      // 732: iload 6
      // 734: ifne 74c
      // 737: aload 11
      // 739: ifnull 74c
      // 73c: aload 11
      // 73e: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 741: ifnull 74c
      // 744: aload 11
      // 746: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 749: invokevirtual java/io/InputStream.close ()V
      // 74c: aload 1
      // 74d: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 752: ifnull 972
      // 755: aload 1
      // 756: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 75b: invokevirtual java/io/InputStream.close ()V
      // 75e: aload 13
      // 760: astore 16
      // 762: aload 12
      // 764: astore 13
      // 766: aload 11
      // 768: astore 12
      // 76a: aload 16
      // 76c: astore 11
      // 76e: aload 14
      // 770: astore 17
      // 772: aload 11
      // 774: astore 14
      // 776: aload 12
      // 778: astore 11
      // 77a: aload 15
      // 77c: astore 16
      // 77e: aload 17
      // 780: astore 15
      // 782: goto 070
      // 785: iload 6
      // 787: istore 7
      // 789: aload 11
      // 78b: astore 14
      // 78d: aload 11
      // 78f: astore 19
      // 791: aload 15
      // 793: astore 16
      // 795: iload 6
      // 797: istore 9
      // 799: aload 11
      // 79b: astore 17
      // 79d: iload 6
      // 79f: istore 8
      // 7a1: aload 11
      // 7a3: astore 18
      // 7a5: aload 3
      // 7a6: invokeinterface com/amazonaws/http/HttpResponseHandler.needsConnectionLeftOpen ()Z 1
      // 7ab: istore 10
      // 7ad: iload 10
      // 7af: istore 6
      // 7b1: aload 0
      // 7b2: aload 1
      // 7b3: aload 3
      // 7b4: aload 11
      // 7b6: invokevirtual com/amazonaws/http/AmazonHttpClient.handleErrorResponse (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/HttpResponse;)Lcom/amazonaws/AmazonServiceException;
      // 7b9: astore 16
      // 7bb: aload 21
      // 7bd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.AWSRequestID Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 7c0: aload 16
      // 7c2: invokevirtual com/amazonaws/AmazonServiceException.getRequestId ()Ljava/lang/String;
      // 7c5: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 7c8: aload 21
      // 7ca: getstatic com/amazonaws/util/AWSRequestMetrics$Field.AWSErrorCode Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 7cd: aload 16
      // 7cf: invokevirtual com/amazonaws/AmazonServiceException.getErrorCode ()Ljava/lang/String;
      // 7d2: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 7d5: aload 21
      // 7d7: getstatic com/amazonaws/util/AWSRequestMetrics$Field.StatusCode Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 7da: aload 16
      // 7dc: invokevirtual com/amazonaws/AmazonServiceException.getStatusCode ()I
      // 7df: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 7e2: invokevirtual com/amazonaws/util/AWSRequestMetrics.addProperty (Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
      // 7e5: aload 0
      // 7e6: aload 1
      // 7e7: invokeinterface com/amazonaws/Request.getOriginalRequest ()Lcom/amazonaws/AmazonWebServiceRequest; 1
      // 7ec: aload 13
      // 7ee: invokevirtual com/amazonaws/http/HttpRequest.getContent ()Ljava/io/InputStream;
      // 7f1: aload 16
      // 7f3: iload 5
      // 7f5: aload 0
      // 7f6: getfield com/amazonaws/http/AmazonHttpClient.config Lcom/amazonaws/ClientConfiguration;
      // 7f9: invokevirtual com/amazonaws/ClientConfiguration.getRetryPolicy ()Lcom/amazonaws/retry/RetryPolicy;
      // 7fc: invokespecial com/amazonaws/http/AmazonHttpClient.shouldRetry (Lcom/amazonaws/AmazonWebServiceRequest;Ljava/io/InputStream;Lcom/amazonaws/AmazonClientException;ILcom/amazonaws/retry/RetryPolicy;)Z
      // 7ff: ifne 80a
      // 802: aload 16
      // 804: athrow
      // 805: astore 14
      // 807: goto 3a2
      // 80a: aload 16
      // 80c: invokestatic com/amazonaws/retry/RetryUtils.isClockSkewError (Lcom/amazonaws/AmazonServiceException;)Z
      // 80f: ifeq 81d
      // 812: aload 0
      // 813: aload 11
      // 815: aload 16
      // 817: invokevirtual com/amazonaws/http/AmazonHttpClient.parseClockSkewOffset (Lcom/amazonaws/http/HttpResponse;Lcom/amazonaws/AmazonServiceException;)I
      // 81a: invokestatic com/amazonaws/SDKGlobalConfiguration.setGlobalTimeOffset (I)V
      // 81d: aload 0
      // 81e: aload 1
      // 81f: aload 16
      // 821: invokevirtual com/amazonaws/http/AmazonHttpClient.resetRequestAfterError (Lcom/amazonaws/Request;Ljava/lang/Exception;)V
      // 824: aload 15
      // 826: astore 14
      // 828: aload 16
      // 82a: astore 15
      // 82c: goto 732
      // 82f: astore 16
      // 831: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 834: ldc_w "Cannot close the response content."
      // 837: aload 16
      // 839: invokestatic com/jibo/aws/integration/util/a.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 83c: goto 74c
      // 83f: astore 16
      // 841: aload 12
      // 843: astore 16
      // 845: aload 11
      // 847: astore 12
      // 849: aload 13
      // 84b: astore 11
      // 84d: aload 16
      // 84f: astore 13
      // 851: goto 76e
      // 854: aload 0
      // 855: aload 1
      // 856: aload 14
      // 858: invokevirtual com/amazonaws/http/AmazonHttpClient.resetRequestAfterError (Lcom/amazonaws/Request;Ljava/lang/Exception;)V
      // 85b: iload 6
      // 85d: ifne 875
      // 860: aload 11
      // 862: ifnull 875
      // 865: aload 11
      // 867: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 86a: ifnull 875
      // 86d: aload 11
      // 86f: invokevirtual com/amazonaws/http/HttpResponse.getRawContent ()Ljava/io/InputStream;
      // 872: invokevirtual java/io/InputStream.close ()V
      // 875: aload 1
      // 876: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 87b: ifnull 953
      // 87e: aload 1
      // 87f: invokeinterface com/amazonaws/Request.getContent ()Ljava/io/InputStream; 1
      // 884: invokevirtual java/io/InputStream.close ()V
      // 887: aload 13
      // 889: astore 17
      // 88b: aload 11
      // 88d: astore 13
      // 88f: aload 12
      // 891: astore 16
      // 893: aload 15
      // 895: astore 14
      // 897: aload 17
      // 899: astore 11
      // 89b: aload 13
      // 89d: astore 12
      // 89f: aload 16
      // 8a1: astore 13
      // 8a3: aload 18
      // 8a5: astore 15
      // 8a7: goto 76e
      // 8aa: astore 14
      // 8ac: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 8af: ldc_w "Cannot close the response content."
      // 8b2: aload 14
      // 8b4: invokestatic com/jibo/aws/integration/util/a.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 8b7: goto 875
      // 8ba: astore 14
      // 8bc: aload 13
      // 8be: astore 17
      // 8c0: aload 11
      // 8c2: astore 13
      // 8c4: aload 12
      // 8c6: astore 16
      // 8c8: aload 15
      // 8ca: astore 14
      // 8cc: aload 17
      // 8ce: astore 11
      // 8d0: aload 13
      // 8d2: astore 12
      // 8d4: aload 16
      // 8d6: astore 13
      // 8d8: aload 18
      // 8da: astore 15
      // 8dc: goto 76e
      // 8df: astore 3
      // 8e0: getstatic com/amazonaws/http/AmazonHttpClient.TAG Ljava/lang/String;
      // 8e3: ldc_w "Cannot close the response content."
      // 8e6: aload 3
      // 8e7: invokestatic com/jibo/aws/integration/util/a.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 8ea: goto 44a
      // 8ed: astore 1
      // 8ee: goto 45c
      // 8f1: astore 2
      // 8f2: goto 430
      // 8f5: astore 2
      // 8f6: iload 9
      // 8f8: istore 6
      // 8fa: aload 17
      // 8fc: astore 11
      // 8fe: goto 49b
      // 901: astore 2
      // 902: goto 49b
      // 905: astore 2
      // 906: iload 8
      // 908: istore 6
      // 90a: aload 18
      // 90c: astore 11
      // 90e: goto 46d
      // 911: astore 2
      // 912: goto 46d
      // 915: astore 16
      // 917: aload 13
      // 919: astore 12
      // 91b: aload 14
      // 91d: astore 13
      // 91f: aload 16
      // 921: astore 14
      // 923: goto 3a2
      // 926: astore 14
      // 928: goto 3a2
      // 92b: astore 1
      // 92c: goto 388
      // 92f: astore 20
      // 931: goto 51d
      // 934: astore 14
      // 936: goto 518
      // 939: astore 16
      // 93b: goto 504
      // 93e: astore 17
      // 940: aload 16
      // 942: astore 14
      // 944: goto 4da
      // 947: astore 14
      // 949: goto 282
      // 94c: aload 13
      // 94e: astore 12
      // 950: goto 0a6
      // 953: aload 13
      // 955: astore 17
      // 957: aload 11
      // 959: astore 16
      // 95b: aload 12
      // 95d: astore 13
      // 95f: aload 15
      // 961: astore 14
      // 963: aload 17
      // 965: astore 11
      // 967: aload 16
      // 969: astore 12
      // 96b: aload 18
      // 96d: astore 15
      // 96f: goto 76e
      // 972: aload 12
      // 974: astore 16
      // 976: aload 11
      // 978: astore 12
      // 97a: aload 13
      // 97c: astore 11
      // 97e: aload 16
      // 980: astore 13
      // 982: goto 76e
      // try (66 -> 71): 1029 java/io/IOException
      // try (66 -> 71): 479 java/lang/RuntimeException
      // try (66 -> 71): 502 java/lang/Error
      // try (66 -> 71): 528 null
      // try (75 -> 78): 393 java/io/IOException
      // try (75 -> 78): 479 java/lang/RuntimeException
      // try (75 -> 78): 502 java/lang/Error
      // try (75 -> 78): 528 null
      // try (78 -> 82): 387 null
      // try (82 -> 85): 393 java/io/IOException
      // try (82 -> 85): 479 java/lang/RuntimeException
      // try (82 -> 85): 502 java/lang/Error
      // try (82 -> 85): 528 null
      // try (85 -> 107): 393 java/io/IOException
      // try (85 -> 107): 479 java/lang/RuntimeException
      // try (85 -> 107): 502 java/lang/Error
      // try (85 -> 107): 528 null
      // try (109 -> 130): 474 java/lang/Exception
      // try (109 -> 130): 496 null
      // try (130 -> 133): 393 java/io/IOException
      // try (130 -> 133): 479 java/lang/RuntimeException
      // try (130 -> 133): 502 java/lang/Error
      // try (130 -> 133): 528 null
      // try (133 -> 141): 393 java/io/IOException
      // try (133 -> 141): 479 java/lang/RuntimeException
      // try (133 -> 141): 502 java/lang/Error
      // try (133 -> 141): 528 null
      // try (143 -> 146): 519 java/io/IOException
      // try (143 -> 146): 479 java/lang/RuntimeException
      // try (143 -> 146): 502 java/lang/Error
      // try (143 -> 146): 528 null
      // try (149 -> 152): 519 java/io/IOException
      // try (149 -> 152): 479 java/lang/RuntimeException
      // try (149 -> 152): 502 java/lang/Error
      // try (149 -> 152): 528 null
      // try (152 -> 161): 513 null
      // try (161 -> 164): 519 java/io/IOException
      // try (161 -> 164): 479 java/lang/RuntimeException
      // try (161 -> 164): 502 java/lang/Error
      // try (161 -> 164): 528 null
      // try (164 -> 167): 519 java/io/IOException
      // try (164 -> 167): 479 java/lang/RuntimeException
      // try (164 -> 167): 502 java/lang/Error
      // try (164 -> 167): 528 null
      // try (172 -> 180): 519 java/io/IOException
      // try (172 -> 180): 479 java/lang/RuntimeException
      // try (172 -> 180): 502 java/lang/Error
      // try (172 -> 180): 528 null
      // try (182 -> 185): 519 java/io/IOException
      // try (182 -> 185): 479 java/lang/RuntimeException
      // try (182 -> 185): 502 java/lang/Error
      // try (182 -> 185): 528 null
      // try (185 -> 190): 1041 null
      // try (192 -> 204): 561 null
      // try (206 -> 215): 530 java/lang/Exception
      // try (206 -> 215): 548 null
      // try (217 -> 220): 1047 java/lang/Exception
      // try (217 -> 220): 1045 null
      // try (222 -> 225): 1047 java/lang/Exception
      // try (222 -> 225): 1045 null
      // try (227 -> 230): 1047 java/lang/Exception
      // try (227 -> 230): 1045 null
      // try (232 -> 234): 1047 java/lang/Exception
      // try (232 -> 234): 1045 null
      // try (236 -> 238): 1047 java/lang/Exception
      // try (236 -> 238): 1045 null
      // try (240 -> 242): 1047 java/lang/Exception
      // try (240 -> 242): 1045 null
      // try (244 -> 252): 1047 java/lang/Exception
      // try (244 -> 252): 1045 null
      // try (254 -> 256): 1047 java/lang/Exception
      // try (254 -> 256): 1045 null
      // try (258 -> 264): 1051 java/lang/Exception
      // try (258 -> 264): 561 null
      // try (280 -> 283): 599 java/io/IOException
      // try (280 -> 283): 1021 java/lang/RuntimeException
      // try (280 -> 283): 1013 java/lang/Error
      // try (280 -> 283): 490 null
      // try (299 -> 303): 599 java/io/IOException
      // try (299 -> 303): 1021 java/lang/RuntimeException
      // try (299 -> 303): 1013 java/lang/Error
      // try (299 -> 303): 490 null
      // try (319 -> 325): 599 java/io/IOException
      // try (319 -> 325): 1021 java/lang/RuntimeException
      // try (319 -> 325): 1013 java/lang/Error
      // try (319 -> 325): 490 null
      // try (341 -> 344): 599 java/io/IOException
      // try (341 -> 344): 1021 java/lang/RuntimeException
      // try (341 -> 344): 1013 java/lang/Error
      // try (341 -> 344): 490 null
      // try (358 -> 369): 1037 java/io/IOException
      // try (358 -> 369): 1021 java/lang/RuntimeException
      // try (358 -> 369): 1013 java/lang/Error
      // try (358 -> 369): 490 null
      // try (373 -> 379): 605 java/io/IOException
      // try (382 -> 385): 1039 java/lang/Exception
      // try (388 -> 393): 393 java/io/IOException
      // try (388 -> 393): 479 java/lang/RuntimeException
      // try (388 -> 393): 502 java/lang/Error
      // try (388 -> 393): 528 null
      // try (398 -> 455): 455 null
      // try (460 -> 466): 1003 java/io/IOException
      // try (469 -> 472): 1009 java/lang/Exception
      // try (475 -> 478): 393 java/io/IOException
      // try (475 -> 478): 479 java/lang/RuntimeException
      // try (475 -> 478): 502 java/lang/Error
      // try (475 -> 478): 528 null
      // try (484 -> 490): 490 null
      // try (497 -> 502): 393 java/io/IOException
      // try (497 -> 502): 479 java/lang/RuntimeException
      // try (497 -> 502): 502 java/lang/Error
      // try (497 -> 502): 528 null
      // try (507 -> 513): 490 null
      // try (514 -> 519): 519 java/io/IOException
      // try (514 -> 519): 479 java/lang/RuntimeException
      // try (514 -> 519): 502 java/lang/Error
      // try (514 -> 519): 528 null
      // try (521 -> 527): 519 java/io/IOException
      // try (521 -> 527): 479 java/lang/RuntimeException
      // try (521 -> 527): 502 java/lang/Error
      // try (521 -> 527): 528 null
      // try (533 -> 537): 1045 null
      // try (539 -> 545): 546 java/lang/Exception
      // try (539 -> 545): 561 null
      // try (553 -> 559): 1043 java/lang/Exception
      // try (553 -> 559): 561 null
      // try (559 -> 561): 561 null
      // try (578 -> 581): 599 java/io/IOException
      // try (578 -> 581): 1021 java/lang/RuntimeException
      // try (578 -> 581): 1013 java/lang/Error
      // try (578 -> 581): 490 null
      // try (597 -> 599): 599 java/io/IOException
      // try (597 -> 599): 1021 java/lang/RuntimeException
      // try (597 -> 599): 1013 java/lang/Error
      // try (597 -> 599): 490 null
      // try (627 -> 630): 599 java/io/IOException
      // try (627 -> 630): 1021 java/lang/RuntimeException
      // try (627 -> 630): 1013 java/lang/Error
      // try (627 -> 630): 490 null
      // try (646 -> 652): 599 java/io/IOException
      // try (646 -> 652): 1021 java/lang/RuntimeException
      // try (646 -> 652): 1013 java/lang/Error
      // try (646 -> 652): 490 null
      // try (668 -> 670): 599 java/io/IOException
      // try (668 -> 670): 1021 java/lang/RuntimeException
      // try (668 -> 670): 1013 java/lang/Error
      // try (668 -> 670): 490 null
      // try (686 -> 688): 599 java/io/IOException
      // try (686 -> 688): 1021 java/lang/RuntimeException
      // try (686 -> 688): 1013 java/lang/Error
      // try (686 -> 688): 490 null
      // try (704 -> 706): 599 java/io/IOException
      // try (704 -> 706): 1021 java/lang/RuntimeException
      // try (704 -> 706): 1013 java/lang/Error
      // try (704 -> 706): 490 null
      // try (722 -> 730): 599 java/io/IOException
      // try (722 -> 730): 1021 java/lang/RuntimeException
      // try (722 -> 730): 1013 java/lang/Error
      // try (722 -> 730): 490 null
      // try (746 -> 749): 599 java/io/IOException
      // try (746 -> 749): 1021 java/lang/RuntimeException
      // try (746 -> 749): 1013 java/lang/Error
      // try (746 -> 749): 490 null
      // try (765 -> 771): 599 java/io/IOException
      // try (765 -> 771): 1021 java/lang/RuntimeException
      // try (765 -> 771): 1013 java/lang/Error
      // try (765 -> 771): 490 null
      // try (787 -> 791): 599 java/io/IOException
      // try (787 -> 791): 1021 java/lang/RuntimeException
      // try (787 -> 791): 1013 java/lang/Error
      // try (787 -> 791): 490 null
      // try (807 -> 811): 599 java/io/IOException
      // try (807 -> 811): 1021 java/lang/RuntimeException
      // try (807 -> 811): 1013 java/lang/Error
      // try (807 -> 811): 490 null
      // try (819 -> 825): 926 java/io/IOException
      // try (828 -> 831): 932 java/lang/Exception
      // try (866 -> 869): 599 java/io/IOException
      // try (866 -> 869): 1021 java/lang/RuntimeException
      // try (866 -> 869): 1013 java/lang/Error
      // try (866 -> 869): 490 null
      // try (871 -> 907): 907 java/io/IOException
      // try (871 -> 907): 1027 java/lang/RuntimeException
      // try (871 -> 907): 1019 java/lang/Error
      // try (871 -> 907): 1011 null
      // try (909 -> 917): 907 java/io/IOException
      // try (909 -> 917): 1027 java/lang/RuntimeException
      // try (909 -> 917): 1019 java/lang/Error
      // try (909 -> 917): 1011 null
      // try (917 -> 921): 907 java/io/IOException
      // try (917 -> 921): 1027 java/lang/RuntimeException
      // try (917 -> 921): 1019 java/lang/Error
      // try (917 -> 921): 1011 null
      // try (942 -> 946): 455 null
      // try (950 -> 956): 979 java/io/IOException
      // try (959 -> 962): 985 java/lang/Exception
   }

   @Override
   protected void finalize() {
      this.shutdown();
      super.finalize();
   }

   public RequestMetricCollector getRequestMetricCollector() {
      return this.requestMetricCollector;
   }

   AmazonServiceException handleErrorResponse(Request<?> var1, HttpResponseHandler<AmazonServiceException> var2, HttpResponse var3) {
      int var4 = var3.getStatusCode();

      try {
         var8 = (AmazonServiceException)var2.handle(var3);
         String var6 = TAG;
         StringBuilder var5 = new StringBuilder();
         a.a(var6, var5.append("Received error response: ").append(var8.toString()).toString());
      } catch (Exception var7) {
         if (var4 == 413) {
            var8 = new AmazonServiceException("Request entity too large");
            var8.setServiceName(var1.getServiceName());
            var8.setStatusCode(413);
            var8.setErrorType(AmazonServiceException.ErrorType.Client);
            var8.setErrorCode("Request entity too large");
         } else {
            if (var4 != 503
               || !"Service Unavailable".equalsIgnoreCase(var3.getStatusText()) && !"Service Temporarily Unavailable".equalsIgnoreCase(var3.getStatusText())) {
               if (var7 instanceof IOException) {
                  throw (IOException)var7;
               }

               throw new AmazonClientException(
                  "Unable to unmarshall error response (" + var7.getMessage() + "). Response Code: " + var4 + ", Response Text: " + var3.getStatusText(), var7
               );
            }

            var8 = new AmazonServiceException("Service unavailable");
            var8.setServiceName(var1.getServiceName());
            var8.setStatusCode(503);
            var8.setErrorType(AmazonServiceException.ErrorType.Service);
            var8.setErrorCode("Service unavailable");
         }
      }

      var8.setStatusCode(var4);
      var8.setServiceName(var1.getServiceName());
      var8.fillInStackTrace();
      return var8;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   <T> T handleResponse(Request<?> var1, HttpResponseHandler<AmazonWebServiceResponse<T>> var2, HttpResponse var3, ExecutionContext var4) {
      try {
         var35 = var4.getAwsRequestMetrics();
         var35.startEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
      } catch (CRC32MismatchException var32) {
         throw var32;
      } catch (IOException var33) {
         throw var33;
      } catch (Exception var34) {
         throw new AmazonClientException(
            "Unable to unmarshall response (" + var34.getMessage() + "). Response Code: " + var3.getStatusCode() + ", Response Text: " + var3.getStatusText(),
            var34
         );
      }

      try {
         var37 = (AmazonWebServiceResponse)var2.handle(var3);
      } finally {
         try {
            var35.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
         } catch (CRC32MismatchException var22) {
            throw var22;
         } catch (IOException var23) {
            throw var23;
         } catch (Exception var24) {
            throw new AmazonClientException(
               "Unable to unmarshall response ("
                  + var24.getMessage()
                  + "). Response Code: "
                  + var3.getStatusCode()
                  + ", Response Text: "
                  + var3.getStatusText(),
               var24
            );
         }
      }

      if (var37 == null) {
         try {
            StringBuilder var36 = new StringBuilder();
            RuntimeException var38 = new RuntimeException(
               var36.append("Unable to unmarshall response metadata. Response Code: ")
                  .append(var3.getStatusCode())
                  .append(", Response Text: ")
                  .append(var3.getStatusText())
                  .toString()
            );
            throw var38;
         } catch (CRC32MismatchException var25) {
            throw var25;
         } catch (IOException var26) {
            throw var26;
         } catch (Exception var27) {
            throw new AmazonClientException(
               "Unable to unmarshall response ("
                  + var27.getMessage()
                  + "). Response Code: "
                  + var3.getStatusCode()
                  + ", Response Text: "
                  + var3.getStatusText(),
               var27
            );
         }
      } else {
         try {
            String var5 = TAG;
            StringBuilder var39 = new StringBuilder();
            a.a(
               var5,
               var39.append("Received successful response: ").append(var3.getStatusCode()).append(", AWS Request ID: ").append(var37.getRequestId()).toString()
            );
            var35.addProperty(AWSRequestMetrics.Field.AWSRequestID, var37.getRequestId());
            return (T)var37.getResult();
         } catch (CRC32MismatchException var28) {
            throw var28;
         } catch (IOException var29) {
            throw var29;
         } catch (Exception var30) {
            throw new AmazonClientException(
               "Unable to unmarshall response ("
                  + var30.getMessage()
                  + "). Response Code: "
                  + var3.getStatusCode()
                  + ", Response Text: "
                  + var3.getStatusText(),
               var30
            );
         }
      }
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   int parseClockSkewOffset(HttpResponse var1, AmazonServiceException var2) {
      label45: {
         String var4;
         Date var6;
         label59: {
            var6 = new Date();
            Object var5 = null;
            var4 = var1.getHeaders().get("Date");
            if (var4 != null) {
               var11 = (String)var5;

               try {
                  if (!var4.isEmpty()) {
                     break label59;
                  }
               } catch (RuntimeException var10) {
                  var13 = var10;
                  break label45;
               }
            }

            var11 = (String)var5;

            try {
               var14 = this.getServerDateFromException(var2.getMessage());
            } catch (RuntimeException var9) {
               var13 = var9;
               break label45;
            }

            var11 = var14;

            try {
               var15 = DateUtils.parseCompressedISO8601Date(var14);
            } catch (RuntimeException var8) {
               var13 = var8;
               break label45;
            }

            Date var12 = var15;
            return (int)((var6.getTime() - var12.getTime()) / 1000L);
         }

         try {
            Date var16 = DateUtils.parseRFC822Date(var4);
            return (int)((var6.getTime() - var16.getTime()) / 1000L);
         } catch (RuntimeException var7) {
            var13 = var7;
            var11 = var4;
         }
      }

      a.c(TAG, "Unable to parse clock skew offset from response: " + var11, var13);
      return 0;
   }

   List<RequestHandler2> requestHandler2s(Request<?> var1, ExecutionContext var2) {
      List var3 = var2.getRequestHandler2s();
      List var6;
      if (var3 == null) {
         var6 = Collections.emptyList();
      } else {
         for (RequestHandler2 var5 : var3) {
            if (var5 instanceof CredentialsRequestHandler) {
               ((CredentialsRequestHandler)var5).setCredentials(var2.getCredentials());
            }

            var5.beforeRequest(var1);
         }

         var6 = var3;
      }

      return var6;
   }

   void resetRequestAfterError(Request<?> var1, Exception var2) {
      if (var1.getContent() != null) {
         if (!var1.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", var2);
         }

         try {
            var1.getContent().reset();
         } catch (IOException var3) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", var2);
         }
      }
   }

   public void shutdown() {
      this.httpClient.shutdown();
   }
}
