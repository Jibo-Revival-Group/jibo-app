package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.jibo.aws.integration.util.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AmazonWebServiceClient {
   public static final boolean LOGGING_AWS_REQUEST_METRIC = true;
   public static final String TAG = a.a(AmazonWebServiceClient.class);
   protected AmazonHttpClient client;
   protected ClientConfiguration clientConfiguration;
   protected volatile URI endpoint;
   protected final List<RequestHandler2> requestHandler2s;
   private volatile String serviceName;
   private volatile Signer signer;
   private volatile String signerRegionOverride;
   protected int timeOffset;

   protected AmazonWebServiceClient(ClientConfiguration var1, HttpClient var2) {
      this.clientConfiguration = var1;
      this.client = new AmazonHttpClient(var1, var2);
      this.requestHandler2s = new CopyOnWriteArrayList<>();
   }

   @Deprecated
   protected AmazonWebServiceClient(ClientConfiguration var1, HttpClient var2, RequestMetricCollector var3) {
      this.clientConfiguration = var1;
      this.client = new AmazonHttpClient(var1, var2, var3);
      this.requestHandler2s = new CopyOnWriteArrayList<>();
   }

   @Deprecated
   protected AmazonWebServiceClient(ClientConfiguration var1, RequestMetricCollector var2) {
      this(var1, new UrlHttpClient(var1), null);
   }

   private String computeServiceName() {
      String var5 = Classes.childClassOf(AmazonWebServiceClient.class, this).getSimpleName();
      String var4 = ServiceNameFactory.getServiceName(var5);
      if (var4 == null) {
         int var2 = var5.indexOf("JavaClient");
         int var1 = var2;
         if (var2 == -1) {
            var2 = var5.indexOf("Client");
            var1 = var2;
            if (var2 == -1) {
               throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + var5);
            }
         }

         var2 = var5.indexOf("Jibo");
         int var3;
         if (var2 == -1) {
            var2 = var5.indexOf("AWS");
            if (var2 == -1) {
               throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + var5);
            }

            var3 = "AWS".length();
         } else {
            var3 = "Jibo".length();
         }

         if (var2 >= var1) {
            throw new IllegalStateException("Unrecognized AWS http client class name " + var5);
         }

         var4 = var5.substring(var3 + var2, var1).toLowerCase();
      }

      return var4;
   }

   private Signer computeSignerByServiceRegion(String var1, String var2, String var3, boolean var4) {
      String var5 = this.clientConfiguration.getSignerOverride();
      Signer var6;
      if (var5 == null) {
         var6 = SignerFactory.getSigner(var1, var2);
      } else {
         var6 = SignerFactory.getSignerByTypeAndService(var5, var1);
      }

      if (var6 instanceof RegionAwareSigner) {
         RegionAwareSigner var7 = (RegionAwareSigner)var6;
         if (var3 != null) {
            var7.setRegionName(var3);
         } else if (var2 != null && var4) {
            var7.setRegionName(var2);
         }
      }

      return var6;
   }

   private Signer computeSignerByURI(URI var1, String var2, boolean var3) {
      if (var1 == null) {
         throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
      }

      String var4 = this.getServiceNameIntern();
      return this.computeSignerByServiceRegion(var4, AwsHostNameUtils.parseRegionName(var1.getHost(), var4), var2, var3);
   }

   @Deprecated
   protected static boolean isProfilingEnabled() {
      boolean var0;
      if (System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }

   @Deprecated
   private boolean isRMCEnabledAtClientOrSdkLevel() {
      RequestMetricCollector var2 = this.requestMetricCollector();
      boolean var1;
      if (var2 != null && var2.isEnabled()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private URI toURI(String var1) {
      String var2 = var1;
      if (!var1.contains("://")) {
         var2 = this.clientConfiguration.getProtocol().toString() + "://" + var1;
      }

      try {
         return new URI(var2);
      } catch (URISyntaxException var3) {
         throw new IllegalArgumentException(var3);
      }
   }

   public void addRequestHandler(RequestHandler2 var1) {
      this.requestHandler2s.add(var1);
   }

   @Deprecated
   public void addRequestHandler(RequestHandler var1) {
      this.requestHandler2s.add(RequestHandler2.adapt(var1));
   }

   protected ExecutionContext createExecutionContext(AmazonWebServiceRequest var1) {
      boolean var2;
      if (!this.isRequestMetricsEnabled(var1) && !isProfilingEnabled()) {
         var2 = false;
      } else {
         var2 = true;
      }

      return new ExecutionContext(this.requestHandler2s, var2, this);
   }

   @Deprecated
   protected final void endClientExecution(AWSRequestMetrics var1, Request<?> var2, Response<?> var3, boolean var4) {
      if (var2 != null) {
         var1.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
         var1.getTimingInfo().endTiming();
         this.findRequestMetricCollector(var2).collectMetrics(var2, var3);
      }

      if (var4) {
         var1.log();
      }
   }

   @Deprecated
   protected final RequestMetricCollector findRequestMetricCollector(Request<?> var1) {
      RequestMetricCollector var3 = var1.getOriginalRequest().getRequestMetricCollector();
      if (var3 == null) {
         RequestMetricCollector var2 = this.getRequestMetricsCollector();
         var3 = var2;
         if (var2 == null) {
            var3 = AwsSdkMetrics.getRequestMetricCollector();
         }
      }

      return var3;
   }

   @Deprecated
   public RequestMetricCollector getRequestMetricsCollector() {
      return this.client.getRequestMetricCollector();
   }

   public String getServiceName() {
      return this.getServiceNameIntern();
   }

   protected String getServiceNameIntern() {
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
      // 01: getfield com/amazonaws/AmazonWebServiceClient.serviceName Ljava/lang/String;
      // 04: ifnonnull 20
      // 07: aload 0
      // 08: monitorenter
      // 09: aload 0
      // 0a: getfield com/amazonaws/AmazonWebServiceClient.serviceName Ljava/lang/String;
      // 0d: ifnonnull 1e
      // 10: aload 0
      // 11: invokespecial com/amazonaws/AmazonWebServiceClient.computeServiceName ()Ljava/lang/String;
      // 14: astore 1
      // 15: aload 0
      // 16: aload 1
      // 17: putfield com/amazonaws/AmazonWebServiceClient.serviceName Ljava/lang/String;
      // 1a: aload 0
      // 1b: monitorexit
      // 1c: aload 1
      // 1d: areturn
      // 1e: aload 0
      // 1f: monitorexit
      // 20: aload 0
      // 21: getfield com/amazonaws/AmazonWebServiceClient.serviceName Ljava/lang/String;
      // 24: astore 1
      // 25: goto 1c
      // 28: astore 1
      // 29: aload 0
      // 2a: monitorexit
      // 2b: aload 1
      // 2c: athrow
      // try (5 -> 16): 24 null
      // try (18 -> 20): 24 null
      // try (25 -> 27): 24 null
   }

   public Signer getSignerByURI(URI var1) {
      return this.computeSignerByURI(var1, this.signerRegionOverride, true);
   }

   public final String getSignerRegionOverride() {
      return this.signerRegionOverride;
   }

   public int getTimeOffset() {
      return this.timeOffset;
   }

   @Deprecated
   protected final boolean isRequestMetricsEnabled(AmazonWebServiceRequest var1) {
      RequestMetricCollector var3 = var1.getRequestMetricCollector();
      boolean var2;
      if (var3 != null && var3.isEnabled()) {
         var2 = true;
      } else {
         var2 = this.isRMCEnabledAtClientOrSdkLevel();
      }

      return var2;
   }

   public void removeRequestHandler(RequestHandler2 var1) {
      this.requestHandler2s.remove(var1);
   }

   @Deprecated
   public void removeRequestHandler(RequestHandler var1) {
      this.requestHandler2s.remove(RequestHandler2.adapt(var1));
   }

   @Deprecated
   protected RequestMetricCollector requestMetricCollector() {
      RequestMetricCollector var2 = this.client.getRequestMetricCollector();
      RequestMetricCollector var1 = var2;
      if (var2 == null) {
         var1 = AwsSdkMetrics.getRequestMetricCollector();
      }

      return var1;
   }

   @Deprecated
   public void setConfiguration(ClientConfiguration var1) {
      AmazonHttpClient var3 = this.client;
      RequestMetricCollector var2 = null;
      if (var3 != null) {
         var2 = var3.getRequestMetricCollector();
         var3.shutdown();
      }

      this.clientConfiguration = var1;
      this.client = new AmazonHttpClient(var1, var2);
   }

   public void setEndpoint(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokespecial com/amazonaws/AmazonWebServiceClient.toURI (Ljava/lang/String;)Ljava/net/URI;
      // 05: astore 1
      // 06: aload 0
      // 07: aload 1
      // 08: aload 0
      // 09: getfield com/amazonaws/AmazonWebServiceClient.signerRegionOverride Ljava/lang/String;
      // 0c: bipush 0
      // 0d: invokespecial com/amazonaws/AmazonWebServiceClient.computeSignerByURI (Ljava/net/URI;Ljava/lang/String;Z)Lcom/amazonaws/auth/Signer;
      // 10: astore 2
      // 11: aload 0
      // 12: monitorenter
      // 13: aload 0
      // 14: aload 1
      // 15: putfield com/amazonaws/AmazonWebServiceClient.endpoint Ljava/net/URI;
      // 18: aload 0
      // 19: aload 2
      // 1a: putfield com/amazonaws/AmazonWebServiceClient.signer Lcom/amazonaws/auth/Signer;
      // 1d: aload 0
      // 1e: monitorexit
      // 1f: return
      // 20: astore 1
      // 21: aload 0
      // 22: monitorexit
      // 23: aload 1
      // 24: athrow
      // try (13 -> 21): 22 null
      // try (23 -> 25): 22 null
   }

   @Deprecated
   public void setEndpoint(String param1, String param2, String param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: invokespecial com/amazonaws/AmazonWebServiceClient.toURI (Ljava/lang/String;)Ljava/net/URI;
      // 05: astore 1
      // 06: aload 0
      // 07: aload 2
      // 08: aload 3
      // 09: aload 3
      // 0a: bipush 1
      // 0b: invokespecial com/amazonaws/AmazonWebServiceClient.computeSignerByServiceRegion (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/amazonaws/auth/Signer;
      // 0e: astore 2
      // 0f: aload 0
      // 10: monitorenter
      // 11: aload 0
      // 12: aload 2
      // 13: putfield com/amazonaws/AmazonWebServiceClient.signer Lcom/amazonaws/auth/Signer;
      // 16: aload 0
      // 17: aload 1
      // 18: putfield com/amazonaws/AmazonWebServiceClient.endpoint Ljava/net/URI;
      // 1b: aload 0
      // 1c: aload 3
      // 1d: putfield com/amazonaws/AmazonWebServiceClient.signerRegionOverride Ljava/lang/String;
      // 20: aload 0
      // 21: monitorexit
      // 22: return
      // 23: astore 1
      // 24: aload 0
      // 25: monitorexit
      // 26: aload 1
      // 27: athrow
      // try (13 -> 24): 25 null
      // try (26 -> 28): 25 null
   }

   public void setRegion(Region param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ifnonnull 0f
      // 04: new java/lang/IllegalArgumentException
      // 07: dup
      // 08: ldc_w "No region provided"
      // 0b: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 0e: athrow
      // 0f: aload 0
      // 10: invokevirtual com/amazonaws/AmazonWebServiceClient.getServiceNameIntern ()Ljava/lang/String;
      // 13: astore 5
      // 15: aload 1
      // 16: aload 5
      // 18: invokevirtual com/amazonaws/regions/Region.isServiceSupported (Ljava/lang/String;)Z
      // 1b: ifeq 67
      // 1e: aload 1
      // 1f: aload 5
      // 21: invokevirtual com/amazonaws/regions/Region.getServiceEndpoint (Ljava/lang/String;)Ljava/lang/String;
      // 24: astore 4
      // 26: aload 4
      // 28: ldc "://"
      // 2a: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 2d: istore 2
      // 2e: aload 4
      // 30: astore 3
      // 31: iload 2
      // 32: iflt 42
      // 35: aload 4
      // 37: iload 2
      // 38: ldc "://"
      // 3a: invokevirtual java/lang/String.length ()I
      // 3d: iadd
      // 3e: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 41: astore 3
      // 42: aload 0
      // 43: aload 3
      // 44: invokespecial com/amazonaws/AmazonWebServiceClient.toURI (Ljava/lang/String;)Ljava/net/URI;
      // 47: astore 3
      // 48: aload 0
      // 49: aload 5
      // 4b: aload 1
      // 4c: invokevirtual com/amazonaws/regions/Region.getName ()Ljava/lang/String;
      // 4f: aload 0
      // 50: getfield com/amazonaws/AmazonWebServiceClient.signerRegionOverride Ljava/lang/String;
      // 53: bipush 0
      // 54: invokespecial com/amazonaws/AmazonWebServiceClient.computeSignerByServiceRegion (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/amazonaws/auth/Signer;
      // 57: astore 1
      // 58: aload 0
      // 59: monitorenter
      // 5a: aload 0
      // 5b: aload 3
      // 5c: putfield com/amazonaws/AmazonWebServiceClient.endpoint Ljava/net/URI;
      // 5f: aload 0
      // 60: aload 1
      // 61: putfield com/amazonaws/AmazonWebServiceClient.signer Lcom/amazonaws/auth/Signer;
      // 64: aload 0
      // 65: monitorexit
      // 66: return
      // 67: ldc_w "%s.%s.%s"
      // 6a: bipush 3
      // 6b: anewarray 4
      // 6e: dup
      // 6f: bipush 0
      // 70: aload 5
      // 72: aastore
      // 73: dup
      // 74: bipush 1
      // 75: aload 1
      // 76: invokevirtual com/amazonaws/regions/Region.getName ()Ljava/lang/String;
      // 79: aastore
      // 7a: dup
      // 7b: bipush 2
      // 7c: aload 1
      // 7d: invokevirtual com/amazonaws/regions/Region.getDomain ()Ljava/lang/String;
      // 80: aastore
      // 81: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 84: astore 3
      // 85: getstatic com/amazonaws/AmazonWebServiceClient.TAG Ljava/lang/String;
      // 88: new java/lang/StringBuilder
      // 8b: dup
      // 8c: invokespecial java/lang/StringBuilder.<init> ()V
      // 8f: ldc_w "{"
      // 92: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 95: aload 5
      // 97: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 9a: ldc_w ", "
      // 9d: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a0: aload 1
      // a1: invokevirtual com/amazonaws/regions/Region.getName ()Ljava/lang/String;
      // a4: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // a7: ldc_w "} was not "
      // aa: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // ad: ldc_w "found in region metadata, trying to construct an "
      // b0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // b3: ldc_w "endpoint using the standard pattern for this region: '"
      // b6: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // b9: aload 3
      // ba: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // bd: ldc_w "'."
      // c0: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // c3: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // c6: invokestatic com/jibo/aws/integration/util/a.b (Ljava/lang/String;Ljava/lang/String;)V
      // c9: goto 42
      // cc: astore 1
      // cd: aload 0
      // ce: monitorexit
      // cf: aload 1
      // d0: athrow
      // try (48 -> 56): 102 null
      // try (103 -> 105): 102 null
   }

   public final void setServiceNameIntern(String var1) {
      this.serviceName = var1;
   }

   public final void setSignerRegionOverride(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.processStatement(ExprProcessor.java:119)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.getFinallyInformation(FinallyProcessor.java:136)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:84)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 0
      // 02: getfield com/amazonaws/AmazonWebServiceClient.endpoint Ljava/net/URI;
      // 05: aload 1
      // 06: bipush 1
      // 07: invokespecial com/amazonaws/AmazonWebServiceClient.computeSignerByURI (Ljava/net/URI;Ljava/lang/String;Z)Lcom/amazonaws/auth/Signer;
      // 0a: astore 2
      // 0b: aload 0
      // 0c: monitorenter
      // 0d: aload 0
      // 0e: aload 2
      // 0f: putfield com/amazonaws/AmazonWebServiceClient.signer Lcom/amazonaws/auth/Signer;
      // 12: aload 0
      // 13: aload 1
      // 14: putfield com/amazonaws/AmazonWebServiceClient.signerRegionOverride Ljava/lang/String;
      // 17: aload 0
      // 18: monitorexit
      // 19: return
      // 1a: astore 1
      // 1b: aload 0
      // 1c: monitorexit
      // 1d: aload 1
      // 1e: athrow
      // try (9 -> 17): 18 null
      // try (19 -> 21): 18 null
   }

   public void setTimeOffset(int var1) {
      this.timeOffset = var1;
   }

   public void shutdown() {
      this.client.shutdown();
   }

   public AmazonWebServiceClient withTimeOffset(int var1) {
      this.setTimeOffset(var1);
      return this;
   }
}
