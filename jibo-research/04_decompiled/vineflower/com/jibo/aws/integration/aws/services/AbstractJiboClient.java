package com.jibo.aws.integration.aws.services;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.aws.services.exception.a.b;
import com.jibo.aws.integration.aws.services.exception.a.c;
import com.jibo.aws.integration.aws.services.exception.a.e;
import com.jibo.aws.integration.aws.services.exception.a.f;
import com.jibo.aws.integration.aws.services.exception.a.g;
import com.jibo.aws.integration.aws.services.exception.a.i;
import com.jibo.aws.integration.aws.services.exception.a.j;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.a;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJiboClient extends AmazonWebServiceClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(AbstractJiboClient.class);
   protected List<JsonErrorUnmarshaller> a;
   protected AWSCredentialsProvider b;

   public AbstractJiboClient(AWSCredentials var1) {
      this(var1, new ClientConfiguration());
   }

   public AbstractJiboClient(AWSCredentials var1, ClientConfiguration var2) {
      this(new StaticCredentialsProvider(var1), var2);
   }

   public AbstractJiboClient(AWSCredentialsProvider var1) {
      this(var1, new ClientConfiguration());
   }

   public AbstractJiboClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      this(var1, var2, new UrlHttpClient(var2));
   }

   public AbstractJiboClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(a(var2), var3);
      this.b = var1;
      this.a();
   }

   private static ClientConfiguration a(ClientConfiguration var0) {
      return var0;
   }

   private void a() {
      this.a = new ArrayList<>();
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

   protected <X, Y extends AmazonWebServiceRequest> Response<X> a(Request<Y> var1, HttpResponseHandler<AmazonWebServiceResponse<X>> var2, ExecutionContext var3) {
      var1.setEndpoint(this.endpoint);
      var1.setTimeOffset(this.timeOffset);
      AWSRequestMetrics var5 = var3.getAwsRequestMetrics();
      var5.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);

      AWSCredentials var4;
      try {
         var4 = this.b.getCredentials();
      } finally {
         var5.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
      }

      AmazonWebServiceRequest var6 = var1.getOriginalRequest();
      AWSCredentials var10 = var4;
      if (var6 != null) {
         var10 = var4;
         if (var6.getRequestCredentials() != null) {
            var10 = var6.getRequestCredentials();
         }
      }

      var3.setCredentials(var10);
      JsonErrorResponseHandler var9 = new JsonErrorResponseHandler(this.a);
      return this.client.execute(var1, var2, var9, var3);
   }

   protected <X, Y extends AmazonWebServiceRequest> Response<X> a(
      JiboRequestAbstract param1, com.jibo.aws.integration.aws.services.common.model.a.e param2, Unmarshaller<X, JsonUnmarshallerContext> param3
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokevirtual com/jibo/aws/integration/aws/services/AbstractJiboClient.createExecutionContext (Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
      // 05: astore 7
      // 07: aload 7
      // 09: invokevirtual com/amazonaws/http/ExecutionContext.getAwsRequestMetrics ()Lcom/amazonaws/util/AWSRequestMetrics;
      // 0c: astore 6
      // 0e: aload 6
      // 10: getstatic com/amazonaws/util/AWSRequestMetrics$Field.ClientExecuteTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 13: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 16: aload 6
      // 18: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 1b: invokevirtual com/amazonaws/util/AWSRequestMetrics.startEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 1e: aload 2
      // 1f: astore 4
      // 21: aload 2
      // 22: ifnonnull 2f
      // 25: new com/jibo/aws/integration/aws/services/common/model/a/e
      // 28: astore 4
      // 2a: aload 4
      // 2c: invokespecial com/jibo/aws/integration/aws/services/common/model/a/e.<init> ()V
      // 2f: aload 4
      // 31: aload 1
      // 32: invokevirtual com/jibo/aws/integration/aws/services/common/model/a/e.a (Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;)Lcom/amazonaws/Request;
      // 35: astore 2
      // 36: aload 2
      // 37: astore 4
      // 39: aload 2
      // 3a: aload 6
      // 3c: invokeinterface com/amazonaws/Request.setAWSRequestMetrics (Lcom/amazonaws/util/AWSRequestMetrics;)V 2
      // 41: aload 2
      // 42: astore 1
      // 43: aload 6
      // 45: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 48: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 4b: aload 2
      // 4c: astore 1
      // 4d: new com/amazonaws/http/JsonResponseHandler
      // 50: astore 4
      // 52: aload 2
      // 53: astore 1
      // 54: aload 4
      // 56: aload 3
      // 57: invokespecial com/amazonaws/http/JsonResponseHandler.<init> (Lcom/amazonaws/transform/Unmarshaller;)V
      // 5a: aload 2
      // 5b: astore 1
      // 5c: aload 0
      // 5d: aload 2
      // 5e: aload 4
      // 60: aload 7
      // 62: invokevirtual com/jibo/aws/integration/aws/services/AbstractJiboClient.a (Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
      // 65: astore 3
      // 66: aload 0
      // 67: aload 6
      // 69: aload 2
      // 6a: aload 3
      // 6b: bipush 1
      // 6c: invokevirtual com/jibo/aws/integration/aws/services/AbstractJiboClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // 6f: aload 3
      // 70: areturn
      // 71: astore 5
      // 73: aconst_null
      // 74: astore 2
      // 75: aload 2
      // 76: astore 4
      // 78: getstatic com/jibo/aws/integration/aws/services/AbstractJiboClient.TAG Ljava/lang/String;
      // 7b: aload 1
      // 7c: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 7f: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 82: aload 5
      // 84: invokestatic com/jibo/aws/integration/util/a.a (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 87: aload 2
      // 88: astore 1
      // 89: aload 6
      // 8b: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // 8e: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // 91: goto 4b
      // 94: astore 2
      // 95: aload 0
      // 96: aload 6
      // 98: aload 1
      // 99: aconst_null
      // 9a: bipush 1
      // 9b: invokevirtual com/jibo/aws/integration/aws/services/AbstractJiboClient.endClientExecution (Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
      // 9e: aload 2
      // 9f: athrow
      // a0: astore 2
      // a1: aconst_null
      // a2: astore 4
      // a4: aload 4
      // a6: astore 1
      // a7: aload 6
      // a9: getstatic com/amazonaws/util/AWSRequestMetrics$Field.RequestMarshallTime Lcom/amazonaws/util/AWSRequestMetrics$Field;
      // ac: invokevirtual com/amazonaws/util/AWSRequestMetrics.endEvent (Lcom/amazonaws/metrics/MetricType;)V
      // af: aload 4
      // b1: astore 1
      // b2: aload 2
      // b3: athrow
      // b4: astore 2
      // b5: aconst_null
      // b6: astore 1
      // b7: goto 95
      // ba: astore 2
      // bb: goto a4
      // be: astore 5
      // c0: goto 75
      // try (10 -> 13): 98 null
      // try (17 -> 21): 60 java/lang/Exception
      // try (17 -> 21): 86 null
      // try (21 -> 25): 60 java/lang/Exception
      // try (21 -> 25): 86 null
      // try (27 -> 30): 104 java/lang/Exception
      // try (27 -> 30): 102 null
      // try (32 -> 35): 77 null
      // try (37 -> 39): 77 null
      // try (41 -> 44): 77 null
      // try (46 -> 52): 77 null
      // try (65 -> 71): 102 null
      // try (73 -> 76): 77 null
      // try (91 -> 94): 77 null
      // try (96 -> 98): 77 null
   }

   public AWSCredentialsProvider getAwsCredentialsProvider() {
      return this.b;
   }

   @Override
   public void setEndpoint(String var1) {
      super.setEndpoint(var1);
   }

   @Override
   public void setRegion(Region var1) {
      super.setRegion(var1);
   }
}
