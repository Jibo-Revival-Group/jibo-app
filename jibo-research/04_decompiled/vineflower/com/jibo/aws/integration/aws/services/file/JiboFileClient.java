package com.jibo.aws.integration.aws.services.file;

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
import com.jibo.aws.integration.aws.services.exception.a.b;
import com.jibo.aws.integration.aws.services.exception.a.c;
import com.jibo.aws.integration.aws.services.exception.a.d;
import com.jibo.aws.integration.aws.services.exception.a.e;
import com.jibo.aws.integration.aws.services.exception.a.f;
import com.jibo.aws.integration.aws.services.exception.a.g;
import com.jibo.aws.integration.aws.services.exception.a.h;
import com.jibo.aws.integration.aws.services.exception.a.i;
import com.jibo.aws.integration.aws.services.exception.a.j;
import com.jibo.aws.integration.aws.services.file.model.FileLink;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JiboFileClient extends AmazonWebServiceClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboFileClient.class);
   protected List<JsonErrorUnmarshaller> a;
   protected String b;
   protected String c;
   private AWSCredentialsProvider d;

   @Deprecated
   public JiboFileClient() {
      this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
   }

   @Deprecated
   public JiboFileClient(ClientConfiguration var1) {
      this(new DefaultAWSCredentialsProviderChain(), var1);
   }

   public JiboFileClient(AWSCredentials var1) {
      this(var1, new ClientConfiguration());
   }

   public JiboFileClient(AWSCredentials var1, ClientConfiguration var2) {
      this(new StaticCredentialsProvider(var1), var2);
   }

   public JiboFileClient(AWSCredentialsProvider var1) {
      this(var1, new ClientConfiguration());
   }

   public JiboFileClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      this(var1, var2, new UrlHttpClient(var2));
   }

   public JiboFileClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(a(var2), var3);
      this.d = var1;
      this.a();
   }

   @Deprecated
   public JiboFileClient(AWSCredentialsProvider var1, ClientConfiguration var2, RequestMetricCollector var3) {
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

   public FileLink getFile(String param1) {
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
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 5
      // 05: new com/jibo/aws/integration/aws/services/file/model/GetFileRequest
      // 08: dup
      // 09: aload 1
      // 0a: invokespecial com/jibo/aws/integration/aws/services/file/model/GetFileRequest.<init> (Ljava/lang/String;)V
      // 0d: astore 1
      // 0e: aload 0
      // 0f: aload 1
      // 10: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
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
      // 2c: new com/jibo/aws/integration/aws/services/file/model/a/c
      // 2f: astore 2
      // 30: aload 2
      // 31: invokespecial com/jibo/aws/integration/aws/services/file/model/a/c.<init> ()V
      // 34: aload 2
      // 35: aload 1
      // 36: invokevirtual com/jibo/aws/integration/aws/services/file/model/a/c.a (Lcom/jibo/aws/integration/aws/services/file/model/KeyRequest;)Lcom/amazonaws/Request;
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
      // 56: new com/jibo/aws/integration/aws/services/file/model/a/a
      // 59: astore 8
      // 5b: aload 2
      // 5c: astore 1
      // 5d: aload 5
      // 5f: astore 3
      // 60: aload 8
      // 62: invokespecial com/jibo/aws/integration/aws/services/file/model/a/a.<init> ()V
      // 65: aload 2
      // 66: astore 1
      // 67: aload 5
      // 69: astore 3
      // 6a: new com/amazonaws/http/JsonResponseHandler
      // 6d: astore 7
      // 6f: aload 2
      // 70: astore 1
      // 71: aload 5
      // 73: astore 3
      // 74: aload 7
      // 76: aload 8
      // 78: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 7b: aload 2
      // 7c: astore 1
      // 7d: aload 5
      // 7f: astore 3
      // 80: aload 0
      // 81: aload 2
      // 82: aload 7
      // 84: aload 4
      // 86: invokespecial com/jibo/aws/integration/aws/services/file/JiboFileClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 89: astore 4
      // 8b: aload 2
      // 8c: astore 1
      // 8d: aload 4
      // 8f: astore 3
      // 90: aload 4
      // 92: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 95: checkcast com/jibo/aws/integration/aws/services/file/model/FileLink
      // 98: astore 5
      // 9a: aload 0
      // 9b: aload 6
      // 9d: aload 2
      // 9e: aload 4
      // a0: bipush 1
      // a1: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // a4: aload 5
      // a6: areturn
      // a7: astore 3
      // a8: aconst_null
      // a9: astore 2
      // aa: aload 2
      // ab: astore 1
      // ac: getstatic com/jibo/aws/integration/aws/services/file/JiboFileClient.TAG Ljava/lang/String;
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
      // c6: astore 4
      // c8: aload 1
      // c9: astore 2
      // ca: aload 4
      // cc: astore 1
      // cd: aload 0
      // ce: aload 6
      // d0: aload 2
      // d1: aload 3
      // d2: bipush 1
      // d3: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // d6: aload 1
      // d7: athrow
      // d8: astore 4
      // da: aconst_null
      // db: astore 2
      // dc: aload 2
      // dd: astore 1
      // de: aload 5
      // e0: astore 3
      // e1: aload 6
      // e3: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // e6: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // e9: aload 2
      // ea: astore 1
      // eb: aload 5
      // ed: astore 3
      // ee: aload 4
      // f0: athrow
      // f1: astore 1
      // f2: aconst_null
      // f3: astore 2
      // f4: goto cd
      // f7: astore 4
      // f9: aload 1
      // fa: astore 2
      // fb: goto dc
      // fe: astore 3
      // ff: goto aa
      // try (19 -> 22): 139 null
      // try (22 -> 30): 93 java/lang/Exception
      // try (22 -> 30): 123 null
      // try (32 -> 35): 147 java/lang/Exception
      // try (32 -> 35): 143 null
      // try (39 -> 42): 110 null
      // try (46 -> 48): 110 null
      // try (52 -> 54): 110 null
      // try (58 -> 60): 110 null
      // try (64 -> 67): 110 null
      // try (71 -> 77): 110 null
      // try (81 -> 85): 110 null
      // try (98 -> 102): 143 null
      // try (106 -> 109): 110 null
      // try (130 -> 133): 110 null
      // try (137 -> 139): 110 null
   }

   public List<FileLink> listFiles() {
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
      // 05: new com/jibo/aws/integration/aws/services/file/model/ListFilesRequest
      // 08: dup
      // 09: invokespecial com/jibo/aws/integration/aws/services/file/model/ListFilesRequest.<init> ()V
      // 0c: astore 1
      // 0d: aload 0
      // 0e: aload 1
      // 0f: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
      // 12: astore 4
      // 14: aload 4
      // 16: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 19: astore 6
      // 1b: aload 6
      // 1d: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ClientExecuteTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 20: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 23: aload 6
      // 25: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 28: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 2b: new com/jibo/aws/integration/aws/services/common/model/a/b
      // 2e: astore 2
      // 2f: aload 2
      // 30: invokespecial com/jibo/aws/integration/aws/services/common/model/a/b.<init> ()V
      // 33: aload 2
      // 34: aload 1
      // 35: invokevirtual com/jibo/aws/integration/aws/services/common/model/a/b.a (Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;)Lcom/amazonaws/Request;
      // 38: astore 2
      // 39: aload 2
      // 3a: astore 1
      // 3b: aload 2
      // 3c: aload 6
      // 3e: invokeinterface com/amazonaws/Request.setAWSRequestMetrics (Lcom/amazonaws/util/AWSRequestMetrics;)V 2
      // 43: aload 2
      // 44: astore 1
      // 45: aload 5
      // 47: astore 3
      // 48: aload 6
      // 4a: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 4d: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 50: aload 2
      // 51: astore 1
      // 52: aload 5
      // 54: astore 3
      // 55: new com/jibo/aws/integration/aws/services/file/model/a/b
      // 58: astore 8
      // 5a: aload 2
      // 5b: astore 1
      // 5c: aload 5
      // 5e: astore 3
      // 5f: aload 8
      // 61: invokespecial com/jibo/aws/integration/aws/services/file/model/a/b.<init> ()V
      // 64: aload 2
      // 65: astore 1
      // 66: aload 5
      // 68: astore 3
      // 69: new com/amazonaws/http/JsonResponseHandler
      // 6c: astore 7
      // 6e: aload 2
      // 6f: astore 1
      // 70: aload 5
      // 72: astore 3
      // 73: aload 7
      // 75: aload 8
      // 77: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 7a: aload 2
      // 7b: astore 1
      // 7c: aload 5
      // 7e: astore 3
      // 7f: aload 0
      // 80: aload 2
      // 81: aload 7
      // 83: aload 4
      // 85: invokespecial com/jibo/aws/integration/aws/services/file/JiboFileClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 88: astore 4
      // 8a: aload 2
      // 8b: astore 1
      // 8c: aload 4
      // 8e: astore 3
      // 8f: aload 4
      // 91: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 94: checkcast java/util/List
      // 97: astore 5
      // 99: aload 0
      // 9a: aload 6
      // 9c: aload 2
      // 9d: aload 4
      // 9f: bipush 1
      // a0: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // a3: aload 5
      // a5: areturn
      // a6: astore 3
      // a7: aconst_null
      // a8: astore 2
      // a9: aload 2
      // aa: astore 1
      // ab: getstatic com/jibo/aws/integration/aws/services/file/JiboFileClient.TAG Ljava/lang/String;
      // ae: ldc_w "listFiles"
      // b1: aload 3
      // b2: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // b5: aload 2
      // b6: astore 1
      // b7: aload 5
      // b9: astore 3
      // ba: aload 6
      // bc: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // bf: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // c2: goto 50
      // c5: astore 2
      // c6: aload 0
      // c7: aload 6
      // c9: aload 1
      // ca: aload 3
      // cb: bipush 1
      // cc: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // cf: aload 2
      // d0: athrow
      // d1: astore 4
      // d3: aconst_null
      // d4: astore 2
      // d5: aload 2
      // d6: astore 1
      // d7: aload 5
      // d9: astore 3
      // da: aload 6
      // dc: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // df: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // e2: aload 2
      // e3: astore 1
      // e4: aload 5
      // e6: astore 3
      // e7: aload 4
      // e9: athrow
      // ea: astore 2
      // eb: aconst_null
      // ec: astore 1
      // ed: goto c6
      // f0: astore 4
      // f2: aload 1
      // f3: astore 2
      // f4: goto d5
      // f7: astore 3
      // f8: goto a9
      // try (18 -> 21): 134 null
      // try (21 -> 29): 92 java/lang/Exception
      // try (21 -> 29): 118 null
      // try (31 -> 34): 142 java/lang/Exception
      // try (31 -> 34): 138 null
      // try (38 -> 41): 109 null
      // try (45 -> 47): 109 null
      // try (51 -> 53): 109 null
      // try (57 -> 59): 109 null
      // try (63 -> 66): 109 null
      // try (70 -> 76): 109 null
      // try (80 -> 84): 109 null
      // try (97 -> 101): 138 null
      // try (105 -> 108): 109 null
      // try (125 -> 128): 109 null
      // try (132 -> 134): 109 null
   }

   public FileLink removeFile(String param1) {
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
      // 05: new com/jibo/aws/integration/aws/services/file/model/RemoveFileRequest
      // 08: dup
      // 09: aload 1
      // 0a: invokespecial com/jibo/aws/integration/aws/services/file/model/RemoveFileRequest.<init> (Ljava/lang/String;)V
      // 0d: astore 1
      // 0e: aload 0
      // 0f: aload 1
      // 10: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
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
      // 2c: new com/jibo/aws/integration/aws/services/file/model/a/c
      // 2f: astore 2
      // 30: aload 2
      // 31: invokespecial com/jibo/aws/integration/aws/services/file/model/a/c.<init> ()V
      // 34: aload 2
      // 35: aload 1
      // 36: invokevirtual com/jibo/aws/integration/aws/services/file/model/a/c.a (Lcom/jibo/aws/integration/aws/services/file/model/KeyRequest;)Lcom/amazonaws/Request;
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
      // 56: new com/jibo/aws/integration/aws/services/file/model/a/a
      // 59: astore 7
      // 5b: aload 2
      // 5c: astore 1
      // 5d: aload 5
      // 5f: astore 3
      // 60: aload 7
      // 62: invokespecial com/jibo/aws/integration/aws/services/file/model/a/a.<init> ()V
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
      // 86: invokespecial com/jibo/aws/integration/aws/services/file/JiboFileClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 89: astore 4
      // 8b: aload 2
      // 8c: astore 1
      // 8d: aload 4
      // 8f: astore 3
      // 90: aload 4
      // 92: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 95: checkcast com/jibo/aws/integration/aws/services/file/model/FileLink
      // 98: astore 5
      // 9a: aload 0
      // 9b: aload 6
      // 9d: aload 2
      // 9e: aload 4
      // a0: bipush 1
      // a1: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // a4: aload 5
      // a6: areturn
      // a7: astore 3
      // a8: aconst_null
      // a9: astore 2
      // aa: aload 2
      // ab: astore 1
      // ac: getstatic com/jibo/aws/integration/aws/services/file/JiboFileClient.TAG Ljava/lang/String;
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
      // cd: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
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

   public FileLink uploadFile(String param1, File param2) {
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
      // 05: new com/jibo/aws/integration/aws/services/file/model/UploadFileRequest
      // 08: dup
      // 09: aload 1
      // 0a: aload 2
      // 0b: invokespecial com/jibo/aws/integration/aws/services/file/model/UploadFileRequest.<init> (Ljava/lang/String;Ljava/io/File;)V
      // 0e: astore 1
      // 0f: aload 0
      // 10: aload 1
      // 11: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
      // 14: astore 4
      // 16: aload 4
      // 18: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 1b: astore 6
      // 1d: aload 6
      // 1f: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ClientExecuteTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 22: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 25: aload 6
      // 27: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 2a: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 2d: new com/jibo/aws/integration/aws/services/file/model/a/d
      // 30: astore 2
      // 31: aload 2
      // 32: invokespecial com/jibo/aws/integration/aws/services/file/model/a/d.<init> ()V
      // 35: aload 2
      // 36: aload 1
      // 37: invokevirtual com/jibo/aws/integration/aws/services/file/model/a/d.a (Lcom/jibo/aws/integration/aws/services/file/model/UploadFileRequest;)Lcom/amazonaws/Request;
      // 3a: astore 2
      // 3b: aload 2
      // 3c: astore 1
      // 3d: aload 2
      // 3e: aload 6
      // 40: invokeinterface com/amazonaws/Request.setAWSRequestMetrics (Lcom/amazonaws/util/AWSRequestMetrics;)V 2
      // 45: aload 2
      // 46: astore 1
      // 47: aload 5
      // 49: astore 3
      // 4a: aload 6
      // 4c: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 4f: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 52: aload 2
      // 53: astore 1
      // 54: aload 5
      // 56: astore 3
      // 57: new com/jibo/aws/integration/aws/services/file/model/a/a
      // 5a: astore 7
      // 5c: aload 2
      // 5d: astore 1
      // 5e: aload 5
      // 60: astore 3
      // 61: aload 7
      // 63: invokespecial com/jibo/aws/integration/aws/services/file/model/a/a.<init> ()V
      // 66: aload 2
      // 67: astore 1
      // 68: aload 5
      // 6a: astore 3
      // 6b: new com/amazonaws/http/JsonResponseHandler
      // 6e: astore 8
      // 70: aload 2
      // 71: astore 1
      // 72: aload 5
      // 74: astore 3
      // 75: aload 8
      // 77: aload 7
      // 79: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 7c: aload 2
      // 7d: astore 1
      // 7e: aload 5
      // 80: astore 3
      // 81: aload 0
      // 82: aload 2
      // 83: aload 8
      // 85: aload 4
      // 87: invokespecial com/jibo/aws/integration/aws/services/file/JiboFileClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 8a: astore 4
      // 8c: aload 2
      // 8d: astore 1
      // 8e: aload 4
      // 90: astore 3
      // 91: aload 4
      // 93: invokevirtual com/amazonaws/Response.getAwsResponse ()Ljava/lang/Object;
      // 96: checkcast com/jibo/aws/integration/aws/services/file/model/FileLink
      // 99: astore 5
      // 9b: aload 0
      // 9c: aload 6
      // 9e: aload 2
      // 9f: aload 4
      // a1: bipush 1
      // a2: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // a5: aload 5
      // a7: areturn
      // a8: astore 3
      // a9: aconst_null
      // aa: astore 2
      // ab: aload 2
      // ac: astore 1
      // ad: getstatic com/jibo/aws/integration/aws/services/file/JiboFileClient.TAG Ljava/lang/String;
      // b0: ldc_w "uploadFile"
      // b3: aload 3
      // b4: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // b7: aload 2
      // b8: astore 1
      // b9: aload 5
      // bb: astore 3
      // bc: aload 6
      // be: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // c1: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // c4: goto 52
      // c7: astore 2
      // c8: aload 0
      // c9: aload 6
      // cb: aload 1
      // cc: aload 3
      // cd: bipush 1
      // ce: invokevirtual com/jibo/aws/integration/aws/services/file/JiboFileClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // d1: aload 2
      // d2: athrow
      // d3: astore 4
      // d5: aconst_null
      // d6: astore 2
      // d7: aload 2
      // d8: astore 1
      // d9: aload 5
      // db: astore 3
      // dc: aload 6
      // de: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // e1: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // e4: aload 2
      // e5: astore 1
      // e6: aload 5
      // e8: astore 3
      // e9: aload 4
      // eb: athrow
      // ec: astore 2
      // ed: aconst_null
      // ee: astore 1
      // ef: goto c8
      // f2: astore 4
      // f4: aload 1
      // f5: astore 2
      // f6: goto d7
      // f9: astore 3
      // fa: goto ab
      // try (20 -> 23): 136 null
      // try (23 -> 31): 94 java/lang/Exception
      // try (23 -> 31): 120 null
      // try (33 -> 36): 144 java/lang/Exception
      // try (33 -> 36): 140 null
      // try (40 -> 43): 111 null
      // try (47 -> 49): 111 null
      // try (53 -> 55): 111 null
      // try (59 -> 61): 111 null
      // try (65 -> 68): 111 null
      // try (72 -> 78): 111 null
      // try (82 -> 86): 111 null
      // try (99 -> 103): 140 null
      // try (107 -> 110): 111 null
      // try (127 -> 130): 111 null
      // try (134 -> 136): 111 null
   }
}
