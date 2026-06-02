package com.jibo.aws.integration.aws.services.binary;

import android.content.Context;
import android.text.TextUtils;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.jibo.aws.integration.aws.services.binary.model.BinaryLink;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
import com.jibo.aws.integration.aws.services.exception.a.b;
import com.jibo.aws.integration.aws.services.exception.a.c;
import com.jibo.aws.integration.aws.services.exception.a.d;
import com.jibo.aws.integration.aws.services.exception.a.e;
import com.jibo.aws.integration.aws.services.exception.a.f;
import com.jibo.aws.integration.aws.services.exception.a.g;
import com.jibo.aws.integration.aws.services.exception.a.h;
import com.jibo.aws.integration.aws.services.exception.a.i;
import com.jibo.aws.integration.aws.services.exception.a.j;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JiboBinaryClient extends AmazonWebServiceClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboBinaryClient.class);
   protected List<JsonErrorUnmarshaller> a;
   protected String b = "binary";
   protected String c = "Binary_20151201.";
   private AWSCredentialsProvider d;

   @Deprecated
   public JiboBinaryClient() {
      this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
   }

   @Deprecated
   public JiboBinaryClient(ClientConfiguration var1) {
      this(new DefaultAWSCredentialsProviderChain(), var1);
   }

   public JiboBinaryClient(AWSCredentials var1) {
      this(var1, new ClientConfiguration());
   }

   public JiboBinaryClient(AWSCredentials var1, ClientConfiguration var2) {
      this(new StaticCredentialsProvider(var1), var2);
   }

   public JiboBinaryClient(AWSCredentialsProvider var1) {
      this(var1, new ClientConfiguration());
   }

   public JiboBinaryClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      this(var1, var2, new UrlHttpClient(var2));
   }

   public JiboBinaryClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(a(var2), var3);
      this.d = var1;
      this.a();
   }

   @Deprecated
   public JiboBinaryClient(AWSCredentialsProvider var1, ClientConfiguration var2, RequestMetricCollector var3) {
      super(a(var2), var3);
      this.d = var1;
      this.a();
   }

   private static ClientConfiguration a(ClientConfiguration var0) {
      return var0;
   }

   private <X, Y extends AmazonWebServiceRequest> Response<X> a(Request<Y> var1, HttpResponseHandler<AmazonWebServiceResponse<X>> var2, ExecutionContext var3) {
      var1.setEndpoint(this.endpoint);
      var1.setTimeOffset(this.timeOffset);
      if (!TextUtils.isEmpty(this.c)) {
         String var4 = var1.getHeaders().get("X-Amz-Target");
         if (!TextUtils.isEmpty(var4)) {
            var1.getHeaders().put("X-Amz-Target", var4.replace("$TARGET$.", this.c));
         }
      }

      if (!TextUtils.isEmpty(this.b)) {
         var1.setServiceName(this.b);
      }

      AWSRequestMetrics var5 = var3.getAwsRequestMetrics();
      var5.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);

      AWSCredentials var9;
      try {
         var9 = this.d.getCredentials();
      } finally {
         var5.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
      }

      AmazonWebServiceRequest var6 = var1.getOriginalRequest();
      AWSCredentials var11 = var9;
      if (var6 != null) {
         var11 = var9;
         if (var6.getRequestCredentials() != null) {
            var11 = var6.getRequestCredentials();
         }
      }

      var3.setCredentials(var11);
      JsonErrorResponseHandler var10 = new JsonErrorResponseHandler(this.a);
      return this.client.execute(var1, var2, var10, var3);
   }

   private void a() {
      this.a = new ArrayList<>();
      this.a.add(new h());
      this.a.add(new d());
      this.a.add(new com.jibo.aws.integration.aws.services.exception.a.a());
      this.a.add(new b());
      this.a.add(new c());
      this.a.add(new e());
      this.a.add(new f());
      this.a.add(new g());
      this.a.add(new i());
      this.a.add(new j());
      this.a.add(new j());
      this.a.add(new JsonErrorUnmarshaller());
      this.setEndpoint(Commons.ROOT_ENDPOINT);
      new HandlerChainFactory();
   }

   public static File downloadFileFromUrl(String param0, File param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 11
      // 003: aconst_null
      // 004: astore 10
      // 006: getstatic com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.TAG Ljava/lang/String;
      // 009: new java/lang/StringBuilder
      // 00c: dup
      // 00d: invokespecial java/lang/StringBuilder.<init> ()V
      // 010: ldc "downloadFileFromUrl: "
      // 012: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 015: aload 0
      // 016: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 019: ldc " to "
      // 01b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 01e: aload 1
      // 01f: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 022: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 025: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 028: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;)V
      // 02b: invokestatic android/os/SystemClock.uptimeMillis ()J
      // 02e: lstore 5
      // 030: new java/net/URL
      // 033: astore 7
      // 035: aload 7
      // 037: aload 0
      // 038: invokespecial java/net/URL.<init> (Ljava/lang/String;)V
      // 03b: aload 7
      // 03d: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 040: invokestatic com/google/firebase/perf/network/FirebasePerfUrlConnection.instrument (Ljava/lang/Object;)Ljava/lang/Object;
      // 043: checkcast java/net/URLConnection
      // 046: checkcast java/net/HttpURLConnection
      // 049: astore 7
      // 04b: aload 7
      // 04d: invokevirtual java/net/HttpURLConnection.connect ()V
      // 050: aload 7
      // 052: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 055: sipush 200
      // 058: if_icmpeq 0ba
      // 05b: new com/jibo/aws/integration/aws/services/exception/ResourceNotFoundException
      // 05e: astore 1
      // 05f: aload 1
      // 060: aload 0
      // 061: invokespecial com/jibo/aws/integration/aws/services/exception/ResourceNotFoundException.<init> (Ljava/lang/String;)V
      // 064: aload 1
      // 065: athrow
      // 066: astore 9
      // 068: aconst_null
      // 069: astore 1
      // 06a: aload 7
      // 06c: astore 0
      // 06d: aload 10
      // 06f: astore 8
      // 071: aload 9
      // 073: astore 7
      // 075: getstatic com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.TAG Ljava/lang/String;
      // 078: ldc_w "downloadFileFromUrl"
      // 07b: aload 7
      // 07d: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 080: new com/jibo/aws/integration/aws/services/exception/ServiceException
      // 083: astore 9
      // 085: aload 9
      // 087: aload 7
      // 089: invokevirtual java/lang/Exception.toString ()Ljava/lang/String;
      // 08c: invokespecial com/jibo/aws/integration/aws/services/exception/ServiceException.<init> (Ljava/lang/String;)V
      // 08f: aload 9
      // 091: athrow
      // 092: astore 9
      // 094: aload 1
      // 095: astore 7
      // 097: aload 0
      // 098: astore 1
      // 099: aload 9
      // 09b: astore 0
      // 09c: aload 8
      // 09e: ifnull 0a6
      // 0a1: aload 8
      // 0a3: invokevirtual java/io/OutputStream.close ()V
      // 0a6: aload 7
      // 0a8: ifnull 0b0
      // 0ab: aload 7
      // 0ad: invokevirtual java/io/InputStream.close ()V
      // 0b0: aload 1
      // 0b1: ifnull 0b8
      // 0b4: aload 1
      // 0b5: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 0b8: aload 0
      // 0b9: athrow
      // 0ba: aload 7
      // 0bc: invokevirtual java/net/HttpURLConnection.getContentLength ()I
      // 0bf: pop
      // 0c0: aload 7
      // 0c2: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 0c5: astore 0
      // 0c6: new java/io/FileOutputStream
      // 0c9: astore 8
      // 0cb: aload 8
      // 0cd: aload 1
      // 0ce: invokevirtual java/io/File.getAbsoluteFile ()Ljava/io/File;
      // 0d1: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 0d4: ldc_w 65535
      // 0d7: newarray 8
      // 0d9: astore 9
      // 0db: lconst_0
      // 0dc: lstore 3
      // 0dd: aload 0
      // 0de: aload 9
      // 0e0: invokevirtual java/io/InputStream.read ([B)I
      // 0e3: istore 2
      // 0e4: iload 2
      // 0e5: bipush -1
      // 0e6: if_icmpeq 108
      // 0e9: lload 3
      // 0ea: iload 2
      // 0eb: i2l
      // 0ec: ladd
      // 0ed: lstore 3
      // 0ee: aload 8
      // 0f0: aload 9
      // 0f2: bipush 0
      // 0f3: iload 2
      // 0f4: invokevirtual java/io/OutputStream.write ([BII)V
      // 0f7: goto 0dd
      // 0fa: astore 9
      // 0fc: aload 0
      // 0fd: astore 1
      // 0fe: aload 7
      // 100: astore 0
      // 101: aload 9
      // 103: astore 7
      // 105: goto 075
      // 108: aload 8
      // 10a: ifnull 112
      // 10d: aload 8
      // 10f: invokevirtual java/io/OutputStream.close ()V
      // 112: aload 0
      // 113: ifnull 11a
      // 116: aload 0
      // 117: invokevirtual java/io/InputStream.close ()V
      // 11a: aload 7
      // 11c: ifnull 124
      // 11f: aload 7
      // 121: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 124: getstatic com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.TAG Ljava/lang/String;
      // 127: new java/lang/StringBuilder
      // 12a: dup
      // 12b: invokespecial java/lang/StringBuilder.<init> ()V
      // 12e: ldc_w "downloadFileFromUrl elapsed: "
      // 131: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 134: invokestatic android/os/SystemClock.uptimeMillis ()J
      // 137: lload 5
      // 139: lsub
      // 13a: invokevirtual java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
      // 13d: ldc_w " ms result "
      // 140: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 143: aload 1
      // 144: invokevirtual java/lang/StringBuilder.append (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      // 147: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 14a: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;)V
      // 14d: aload 1
      // 14e: areturn
      // 14f: astore 7
      // 151: goto 0b0
      // 154: astore 0
      // 155: aconst_null
      // 156: astore 1
      // 157: aconst_null
      // 158: astore 7
      // 15a: aload 11
      // 15c: astore 8
      // 15e: goto 09c
      // 161: astore 0
      // 162: aconst_null
      // 163: astore 9
      // 165: aload 7
      // 167: astore 1
      // 168: aload 11
      // 16a: astore 8
      // 16c: aload 9
      // 16e: astore 7
      // 170: goto 09c
      // 173: astore 1
      // 174: aload 0
      // 175: astore 9
      // 177: aload 1
      // 178: astore 0
      // 179: aload 7
      // 17b: astore 1
      // 17c: aload 11
      // 17e: astore 8
      // 180: aload 9
      // 182: astore 7
      // 184: goto 09c
      // 187: astore 10
      // 189: aload 0
      // 18a: astore 9
      // 18c: aload 7
      // 18e: astore 1
      // 18f: aload 10
      // 191: astore 0
      // 192: aload 9
      // 194: astore 7
      // 196: goto 09c
      // 199: astore 7
      // 19b: aconst_null
      // 19c: astore 0
      // 19d: aconst_null
      // 19e: astore 1
      // 19f: aload 10
      // 1a1: astore 8
      // 1a3: goto 075
      // 1a6: astore 8
      // 1a8: aload 0
      // 1a9: astore 1
      // 1aa: aload 8
      // 1ac: astore 0
      // 1ad: aload 7
      // 1af: astore 8
      // 1b1: aload 0
      // 1b2: astore 7
      // 1b4: aload 8
      // 1b6: astore 0
      // 1b7: aload 10
      // 1b9: astore 8
      // 1bb: goto 075
      // 1be: astore 0
      // 1bf: goto 11a
      // try (21 -> 32): 202 java/lang/Exception
      // try (21 -> 32): 162 null
      // try (32 -> 45): 45 java/lang/Exception
      // try (32 -> 45): 170 null
      // try (54 -> 66): 66 null
      // try (75 -> 77): 160 java/io/IOException
      // try (79 -> 81): 160 java/io/IOException
      // try (87 -> 93): 45 java/lang/Exception
      // try (87 -> 93): 170 null
      // try (93 -> 99): 210 java/lang/Exception
      // try (93 -> 99): 180 null
      // try (99 -> 102): 122 java/lang/Exception
      // try (99 -> 102): 192 null
      // try (104 -> 108): 122 java/lang/Exception
      // try (104 -> 108): 192 null
      // try (116 -> 121): 122 java/lang/Exception
      // try (116 -> 121): 192 null
      // try (132 -> 134): 224 java/io/IOException
      // try (136 -> 138): 224 java/io/IOException
   }

   public BinaryLink create(String param1, File param2, Map<String, String> param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1052)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:502)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 4
      // 003: aconst_null
      // 004: astore 5
      // 006: new com/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest
      // 009: dup
      // 00a: aload 1
      // 00b: aload 2
      // 00c: aload 3
      // 00d: invokespecial com/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest.<init> (Ljava/lang/String;Ljava/io/File;Ljava/util/Map;)V
      // 010: astore 1
      // 011: aload 0
      // 012: aload 1
      // 013: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
      // 016: astore 7
      // 018: aload 7
      // 01a: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 01d: astore 6
      // 01f: aload 6
      // 021: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ClientExecuteTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 024: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 027: aload 6
      // 029: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 02c: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 02f: new com/jibo/aws/integration/aws/services/binary/model/a/c
      // 032: astore 2
      // 033: aload 2
      // 034: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/c.<init> ()V
      // 037: aload 2
      // 038: aload 1
      // 039: invokevirtual com/jibo/aws/integration/aws/services/binary/model/a/c.a (Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;)Lcom/amazonaws/Request;
      // 03c: astore 2
      // 03d: aload 2
      // 03e: astore 1
      // 03f: aload 2
      // 040: aload 6
      // 042: invokeinterface com/amazonaws/Request.setAWSRequestMetrics (Lcom/amazonaws/util/AWSRequestMetrics;)V 2
      // 047: aload 2
      // 048: astore 1
      // 049: aload 5
      // 04b: astore 3
      // 04c: aload 6
      // 04e: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 051: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 054: aload 2
      // 055: astore 1
      // 056: aload 5
      // 058: astore 3
      // 059: new com/jibo/aws/integration/aws/services/binary/model/a/a
      // 05c: astore 4
      // 05e: aload 2
      // 05f: astore 1
      // 060: aload 5
      // 062: astore 3
      // 063: aload 4
      // 065: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/a.<init> ()V
      // 068: aload 2
      // 069: astore 1
      // 06a: aload 5
      // 06c: astore 3
      // 06d: new com/amazonaws/http/JsonResponseHandler
      // 070: astore 8
      // 072: aload 2
      // 073: astore 1
      // 074: aload 5
      // 076: astore 3
      // 077: aload 8
      // 079: aload 4
      // 07b: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 07e: aload 2
      // 07f: astore 1
      // 080: aload 5
      // 082: astore 3
      // 083: aload 0
      // 084: aload 2
      // 085: aload 8
      // 087: aload 7
      // 089: invokespecial com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 08c: astore 4
      // 08e: aload 2
      // 08f: astore 1
      // 090: aload 4
      // 092: astore 3
      // 093: aload 4
      // 095: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 098: checkcast com/jibo/aws/integration/aws/services/binary/model/BinaryLink
      // 09b: astore 5
      // 09d: aload 0
      // 09e: aload 6
      // 0a0: aload 2
      // 0a1: aload 4
      // 0a3: bipush 1
      // 0a4: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // 0a7: aload 5
      // 0a9: areturn
      // 0aa: astore 3
      // 0ab: aconst_null
      // 0ac: astore 2
      // 0ad: aload 2
      // 0ae: astore 1
      // 0af: getstatic com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.TAG Ljava/lang/String;
      // 0b2: ldc_w "uploadFile"
      // 0b5: aload 3
      // 0b6: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0b9: aload 2
      // 0ba: astore 1
      // 0bb: aload 5
      // 0bd: astore 3
      // 0be: aload 6
      // 0c0: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 0c3: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 0c6: goto 054
      // 0c9: astore 2
      // 0ca: aload 3
      // 0cb: astore 4
      // 0cd: aload 1
      // 0ce: astore 3
      // 0cf: aload 2
      // 0d0: astore 1
      // 0d1: aload 0
      // 0d2: aload 6
      // 0d4: aload 3
      // 0d5: aload 4
      // 0d7: bipush 1
      // 0d8: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // 0db: aload 1
      // 0dc: athrow
      // 0dd: astore 4
      // 0df: aconst_null
      // 0e0: astore 2
      // 0e1: aload 2
      // 0e2: astore 1
      // 0e3: aload 5
      // 0e5: astore 3
      // 0e6: aload 6
      // 0e8: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 0eb: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 0ee: aload 2
      // 0ef: astore 1
      // 0f0: aload 5
      // 0f2: astore 3
      // 0f3: aload 4
      // 0f5: athrow
      // 0f6: astore 1
      // 0f7: aconst_null
      // 0f8: astore 3
      // 0f9: goto 0d1
      // 0fc: astore 4
      // 0fe: aload 1
      // 0ff: astore 2
      // 100: goto 0e1
      // 103: astore 3
      // 104: goto 0ad
      // try (21 -> 24): 143 null
      // try (24 -> 32): 95 java/lang/Exception
      // try (24 -> 32): 127 null
      // try (34 -> 37): 151 java/lang/Exception
      // try (34 -> 37): 147 null
      // try (41 -> 44): 112 null
      // try (48 -> 50): 112 null
      // try (54 -> 56): 112 null
      // try (60 -> 62): 112 null
      // try (66 -> 69): 112 null
      // try (73 -> 79): 112 null
      // try (83 -> 87): 112 null
      // try (100 -> 104): 147 null
      // try (108 -> 111): 112 null
      // try (134 -> 137): 112 null
      // try (141 -> 143): 112 null
   }

   public BinaryLink get(Context var1, String var2) {
      BinaryLink var3 = this.get(var2);
      if (var3 != null && !TextUtils.isEmpty(var3.getUrl())) {
         try {
            var3.setFile(downloadFileFromUrl(var3.getUrl(), File.createTempFile("BIN", "bin", var1.getCacheDir())));
            return var3;
         } catch (Exception var4) {
            throw new ResourceNotFoundException(var2);
         }
      } else {
         throw new ResourceNotFoundException(var2);
      }
   }

   public BinaryLink get(String param1) {
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
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 5
      // 05: new com/jibo/aws/integration/aws/services/binary/model/GetBinaryRequest
      // 08: dup
      // 09: aload 1
      // 0a: invokespecial com/jibo/aws/integration/aws/services/binary/model/GetBinaryRequest.<init> (Ljava/lang/String;)V
      // 0d: astore 1
      // 0e: aload 0
      // 0f: aload 1
      // 10: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
      // 13: astore 4
      // 15: aload 4
      // 17: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 1a: astore 6
      // 1c: aload 6
      // 1e: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ClientExecuteTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 21: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 24: aload 6
      // 26: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 29: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 2c: new com/jibo/aws/integration/aws/services/binary/model/a/d
      // 2f: astore 2
      // 30: aload 2
      // 31: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/d.<init> ()V
      // 34: aload 2
      // 35: aload 1
      // 36: invokevirtual com/jibo/aws/integration/aws/services/binary/model/a/d.a (Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;)Lcom/amazonaws/Request;
      // 39: astore 2
      // 3a: aload 2
      // 3b: astore 1
      // 3c: aload 2
      // 3d: aload 6
      // 3f: invokeinterface com/amazonaws/Request.setAWSRequestMetrics (Lcom/amazonaws/util/AWSRequestMetrics;)V 2
      // 44: aload 2
      // 45: astore 1
      // 46: aload 5
      // 48: astore 3
      // 49: aload 6
      // 4b: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 4e: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 51: aload 2
      // 52: astore 1
      // 53: aload 5
      // 55: astore 3
      // 56: new com/jibo/aws/integration/aws/services/binary/model/a/a
      // 59: astore 7
      // 5b: aload 2
      // 5c: astore 1
      // 5d: aload 5
      // 5f: astore 3
      // 60: aload 7
      // 62: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/a.<init> ()V
      // 65: aload 2
      // 66: astore 1
      // 67: aload 5
      // 69: astore 3
      // 6a: new com/amazonaws/http/JsonResponseHandler
      // 6d: astore 8
      // 6f: aload 2
      // 70: astore 1
      // 71: aload 5
      // 73: astore 3
      // 74: aload 8
      // 76: aload 7
      // 78: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 7b: aload 2
      // 7c: astore 1
      // 7d: aload 5
      // 7f: astore 3
      // 80: aload 0
      // 81: aload 2
      // 82: aload 8
      // 84: aload 4
      // 86: invokespecial com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 89: astore 4
      // 8b: aload 2
      // 8c: astore 1
      // 8d: aload 4
      // 8f: astore 3
      // 90: aload 4
      // 92: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 95: checkcast com/jibo/aws/integration/aws/services/binary/model/BinaryLink
      // 98: astore 5
      // 9a: aload 0
      // 9b: aload 6
      // 9d: aload 2
      // 9e: aload 4
      // a0: bipush 1
      // a1: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // a4: aload 5
      // a6: areturn
      // a7: astore 3
      // a8: aconst_null
      // a9: astore 2
      // aa: aload 2
      // ab: astore 1
      // ac: getstatic com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.TAG Ljava/lang/String;
      // af: ldc_w "removeFile"
      // b2: aload 3
      // b3: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // b6: aload 2
      // b7: astore 1
      // b8: aload 5
      // ba: astore 3
      // bb: aload 6
      // bd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // c0: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // c3: goto 51
      // c6: astore 2
      // c7: aload 0
      // c8: aload 6
      // ca: aload 1
      // cb: aload 3
      // cc: bipush 1
      // cd: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // d0: aload 2
      // d1: athrow
      // d2: astore 4
      // d4: aconst_null
      // d5: astore 2
      // d6: aload 2
      // d7: astore 1
      // d8: aload 5
      // da: astore 3
      // db: aload 6
      // dd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // e0: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // e3: aload 2
      // e4: astore 1
      // e5: aload 5
      // e7: astore 3
      // e8: aload 4
      // ea: athrow
      // eb: astore 2
      // ec: aconst_null
      // ed: astore 1
      // ee: goto c7
      // f1: astore 4
      // f3: aload 1
      // f4: astore 2
      // f5: goto d6
      // f8: astore 3
      // f9: goto aa
      // try (19 -> 22): 135 null
      // try (22 -> 30): 93 java/lang/Exception
      // try (22 -> 30): 119 null
      // try (32 -> 35): 143 java/lang/Exception
      // try (32 -> 35): 139 null
      // try (39 -> 42): 110 null
      // try (46 -> 48): 110 null
      // try (52 -> 54): 110 null
      // try (58 -> 60): 110 null
      // try (64 -> 67): 110 null
      // try (71 -> 77): 110 null
      // try (81 -> 85): 110 null
      // try (98 -> 102): 139 null
      // try (106 -> 109): 110 null
      // try (126 -> 129): 110 null
      // try (133 -> 135): 110 null
   }

   public BinaryLink get(String var1, String var2) {
      BinaryLink var3 = this.get(var1);
      if (var3 != null && !TextUtils.isEmpty(var3.getUrl())) {
         try {
            String var4 = var3.getUrl();
            File var5 = new File(var2);
            var3.setFile(downloadFileFromUrl(var4, var5));
            return var3;
         } catch (Exception var6) {
            throw new ResourceNotFoundException(var1);
         }
      } else {
         throw new ResourceNotFoundException(var1);
      }
   }

   public List<BinaryLink> list(String param1) {
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
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 5
      // 05: new com/jibo/aws/integration/aws/services/binary/model/ListBinaryRequest
      // 08: dup
      // 09: aload 1
      // 0a: invokespecial com/jibo/aws/integration/aws/services/binary/model/ListBinaryRequest.<init> (Ljava/lang/String;)V
      // 0d: astore 1
      // 0e: aload 0
      // 0f: aload 1
      // 10: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
      // 13: astore 4
      // 15: aload 4
      // 17: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 1a: astore 6
      // 1c: aload 6
      // 1e: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ClientExecuteTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 21: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 24: aload 6
      // 26: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 29: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 2c: new com/jibo/aws/integration/aws/services/binary/model/a/d
      // 2f: astore 2
      // 30: aload 2
      // 31: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/d.<init> ()V
      // 34: aload 2
      // 35: aload 1
      // 36: invokevirtual com/jibo/aws/integration/aws/services/binary/model/a/d.a (Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;)Lcom/amazonaws/Request;
      // 39: astore 2
      // 3a: aload 2
      // 3b: astore 1
      // 3c: aload 2
      // 3d: aload 6
      // 3f: invokeinterface com/amazonaws/Request.setAWSRequestMetrics (Lcom/amazonaws/util/AWSRequestMetrics;)V 2
      // 44: aload 2
      // 45: astore 1
      // 46: aload 5
      // 48: astore 3
      // 49: aload 6
      // 4b: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 4e: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 51: aload 2
      // 52: astore 1
      // 53: aload 5
      // 55: astore 3
      // 56: new com/jibo/aws/integration/aws/services/binary/model/a/b
      // 59: astore 7
      // 5b: aload 2
      // 5c: astore 1
      // 5d: aload 5
      // 5f: astore 3
      // 60: aload 7
      // 62: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/b.<init> ()V
      // 65: aload 2
      // 66: astore 1
      // 67: aload 5
      // 69: astore 3
      // 6a: new com/amazonaws/http/JsonResponseHandler
      // 6d: astore 8
      // 6f: aload 2
      // 70: astore 1
      // 71: aload 5
      // 73: astore 3
      // 74: aload 8
      // 76: aload 7
      // 78: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 7b: aload 2
      // 7c: astore 1
      // 7d: aload 5
      // 7f: astore 3
      // 80: aload 0
      // 81: aload 2
      // 82: aload 8
      // 84: aload 4
      // 86: invokespecial com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 89: astore 4
      // 8b: aload 2
      // 8c: astore 1
      // 8d: aload 4
      // 8f: astore 3
      // 90: aload 4
      // 92: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 95: checkcast java/util/List
      // 98: astore 5
      // 9a: aload 0
      // 9b: aload 6
      // 9d: aload 2
      // 9e: aload 4
      // a0: bipush 1
      // a1: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // a4: aload 5
      // a6: areturn
      // a7: astore 3
      // a8: aconst_null
      // a9: astore 2
      // aa: aload 2
      // ab: astore 1
      // ac: getstatic com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.TAG Ljava/lang/String;
      // af: ldc_w "listFiles"
      // b2: aload 3
      // b3: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // b6: aload 2
      // b7: astore 1
      // b8: aload 5
      // ba: astore 3
      // bb: aload 6
      // bd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // c0: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // c3: goto 51
      // c6: astore 2
      // c7: aload 0
      // c8: aload 6
      // ca: aload 1
      // cb: aload 3
      // cc: bipush 1
      // cd: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // d0: aload 2
      // d1: athrow
      // d2: astore 4
      // d4: aconst_null
      // d5: astore 2
      // d6: aload 2
      // d7: astore 1
      // d8: aload 5
      // da: astore 3
      // db: aload 6
      // dd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // e0: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // e3: aload 2
      // e4: astore 1
      // e5: aload 5
      // e7: astore 3
      // e8: aload 4
      // ea: athrow
      // eb: astore 2
      // ec: aconst_null
      // ed: astore 1
      // ee: goto c7
      // f1: astore 4
      // f3: aload 1
      // f4: astore 2
      // f5: goto d6
      // f8: astore 3
      // f9: goto aa
      // try (19 -> 22): 135 null
      // try (22 -> 30): 93 java/lang/Exception
      // try (22 -> 30): 119 null
      // try (32 -> 35): 143 java/lang/Exception
      // try (32 -> 35): 139 null
      // try (39 -> 42): 110 null
      // try (46 -> 48): 110 null
      // try (52 -> 54): 110 null
      // try (58 -> 60): 110 null
      // try (64 -> 67): 110 null
      // try (71 -> 77): 110 null
      // try (81 -> 85): 110 null
      // try (98 -> 102): 139 null
      // try (106 -> 109): 110 null
      // try (126 -> 129): 110 null
      // try (133 -> 135): 110 null
   }

   public BinaryLink remove(String param1) {
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
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 5
      // 05: new com/jibo/aws/integration/aws/services/binary/model/RemoveBinaryRequest
      // 08: dup
      // 09: aload 1
      // 0a: invokespecial com/jibo/aws/integration/aws/services/binary/model/RemoveBinaryRequest.<init> (Ljava/lang/String;)V
      // 0d: astore 1
      // 0e: aload 0
      // 0f: aload 1
      // 10: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
      // 13: astore 4
      // 15: aload 4
      // 17: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 1a: astore 6
      // 1c: aload 6
      // 1e: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ClientExecuteTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 21: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 24: aload 6
      // 26: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 29: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 2c: new com/jibo/aws/integration/aws/services/binary/model/a/d
      // 2f: astore 2
      // 30: aload 2
      // 31: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/d.<init> ()V
      // 34: aload 2
      // 35: aload 1
      // 36: invokevirtual com/jibo/aws/integration/aws/services/binary/model/a/d.a (Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;)Lcom/amazonaws/Request;
      // 39: astore 2
      // 3a: aload 2
      // 3b: astore 1
      // 3c: aload 2
      // 3d: aload 6
      // 3f: invokeinterface com/amazonaws/Request.setAWSRequestMetrics (Lcom/amazonaws/util/AWSRequestMetrics;)V 2
      // 44: aload 2
      // 45: astore 1
      // 46: aload 5
      // 48: astore 3
      // 49: aload 6
      // 4b: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 4e: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 51: aload 2
      // 52: astore 1
      // 53: aload 5
      // 55: astore 3
      // 56: new com/jibo/aws/integration/aws/services/binary/model/a/a
      // 59: astore 7
      // 5b: aload 2
      // 5c: astore 1
      // 5d: aload 5
      // 5f: astore 3
      // 60: aload 7
      // 62: invokespecial com/jibo/aws/integration/aws/services/binary/model/a/a.<init> ()V
      // 65: aload 2
      // 66: astore 1
      // 67: aload 5
      // 69: astore 3
      // 6a: new com/amazonaws/http/JsonResponseHandler
      // 6d: astore 8
      // 6f: aload 2
      // 70: astore 1
      // 71: aload 5
      // 73: astore 3
      // 74: aload 8
      // 76: aload 7
      // 78: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 7b: aload 2
      // 7c: astore 1
      // 7d: aload 5
      // 7f: astore 3
      // 80: aload 0
      // 81: aload 2
      // 82: aload 8
      // 84: aload 4
      // 86: invokespecial com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 89: astore 4
      // 8b: aload 2
      // 8c: astore 1
      // 8d: aload 4
      // 8f: astore 3
      // 90: aload 4
      // 92: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 95: checkcast com/jibo/aws/integration/aws/services/binary/model/BinaryLink
      // 98: astore 5
      // 9a: aload 0
      // 9b: aload 6
      // 9d: aload 2
      // 9e: aload 4
      // a0: bipush 1
      // a1: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // a4: aload 5
      // a6: areturn
      // a7: astore 3
      // a8: aconst_null
      // a9: astore 2
      // aa: aload 2
      // ab: astore 1
      // ac: getstatic com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.TAG Ljava/lang/String;
      // af: ldc_w "removeFile"
      // b2: aload 3
      // b3: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // b6: aload 2
      // b7: astore 1
      // b8: aload 5
      // ba: astore 3
      // bb: aload 6
      // bd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // c0: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // c3: goto 51
      // c6: astore 2
      // c7: aload 0
      // c8: aload 6
      // ca: aload 1
      // cb: aload 3
      // cc: bipush 1
      // cd: invokevirtual com/jibo/aws/integration/aws/services/binary/JiboBinaryClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // d0: aload 2
      // d1: athrow
      // d2: astore 4
      // d4: aconst_null
      // d5: astore 2
      // d6: aload 2
      // d7: astore 1
      // d8: aload 5
      // da: astore 3
      // db: aload 6
      // dd: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // e0: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // e3: aload 2
      // e4: astore 1
      // e5: aload 5
      // e7: astore 3
      // e8: aload 4
      // ea: athrow
      // eb: astore 2
      // ec: aconst_null
      // ed: astore 1
      // ee: goto c7
      // f1: astore 4
      // f3: aload 1
      // f4: astore 2
      // f5: goto d6
      // f8: astore 3
      // f9: goto aa
      // try (19 -> 22): 135 null
      // try (22 -> 30): 93 java/lang/Exception
      // try (22 -> 30): 119 null
      // try (32 -> 35): 143 java/lang/Exception
      // try (32 -> 35): 139 null
      // try (39 -> 42): 110 null
      // try (46 -> 48): 110 null
      // try (52 -> 54): 110 null
      // try (58 -> 60): 110 null
      // try (64 -> 67): 110 null
      // try (71 -> 77): 110 null
      // try (81 -> 85): 110 null
      // try (98 -> 102): 139 null
      // try (106 -> 109): 110 null
      // try (126 -> 129): 110 null
      // try (133 -> 135): 110 null
   }

   public void setServiceType(String var1, String var2) {
      this.b = var1;
      this.c = var2;
   }
}
