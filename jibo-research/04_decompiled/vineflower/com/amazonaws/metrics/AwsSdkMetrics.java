package com.amazonaws.metrics;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSServiceMetrics;
import com.jibo.aws.integration.util.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum AwsSdkMetrics {
   private static final AwsSdkMetrics[] $VALUES = new AwsSdkMetrics[0];
   private static final String MBEAN_OBJECT_NAME = "com.amazonaws.management:type=" + AwsSdkMetrics.class.getSimpleName();
   private static volatile String credentialFile;
   private static volatile AWSCredentialsProvider credentialProvider;
   private static final boolean defaultMetricsEnabled;
   private static boolean dirtyEnabling;
   private static volatile String hostMetricName;
   private static volatile String jvmMetricName;
   private static volatile boolean machineMetricsExcluded;
   private static volatile MetricCollector mc;
   private static volatile String metricNameSpace = "AWSSDK/Java";
   private static volatile Integer metricQueueSize;
   private static volatile boolean perHostMetricsIncluded;
   private static volatile Long queuePollTimeoutMilli;
   private static volatile Regions region;
   private static final AwsSdkMetrics.MetricRegistry registry;
   private static volatile boolean singleMetricNamespace;

   static {
      String var8 = System.getProperty("com.amazonaws.sdk.enableDefaultMetrics");
      boolean var2;
      if (var8 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      defaultMetricsEnabled = var2;
      if (defaultMetricsEnabled) {
         String[] var14 = var8.split(",");
         int var1 = var14.length;
         int var0 = 0;
         boolean var4 = false;
         boolean var3 = false;
         var2 = false;

         while (var0 < var1) {
            String var9 = var14[var0].trim();
            boolean var5;
            boolean var6;
            boolean var7;
            if (!var2 && "excludeMachineMetrics".equals(var9)) {
               var6 = true;
               var7 = var3;
               var5 = var4;
            } else if (!var3 && "includePerHostMetrics".equals(var9)) {
               var7 = true;
               var5 = var4;
               var6 = var2;
            } else if (!var4 && "useSingleMetricNamespace".equals(var9)) {
               var5 = true;
               var7 = var3;
               var6 = var2;
            } else {
               String[] var10 = var9.split("=");
               var5 = var4;
               var7 = var3;
               var6 = var2;
               label72:
               if (var10.length == 2) {
                  String var11 = var10[0].trim();
                  String var19 = var10[1].trim();

                  label113: {
                     label112: {
                        label111: {
                           label110: {
                              label109: {
                                 label108: {
                                    label107: {
                                       try {
                                          if ("credentialFile".equals(var11)) {
                                             setCredentialFile0(var19);
                                             break label113;
                                          }

                                          if ("cloudwatchRegion".equals(var11)) {
                                             region = Regions.fromName(var19);
                                             break label112;
                                          }

                                          if ("metricQueueSize".equals(var11)) {
                                             Integer var17 = new Integer(var19);
                                             if (var17 < 1) {
                                                IllegalArgumentException var18 = new IllegalArgumentException("metricQueueSize must be at least 1");
                                                throw var18;
                                             }

                                             metricQueueSize = var17;
                                             break label111;
                                          }

                                          if ("getQueuePollTimeoutMilli".equals(var11)) {
                                             Long var15 = new Long(var19);
                                             if (var15.intValue() < 1000) {
                                                IllegalArgumentException var16 = new IllegalArgumentException("getQueuePollTimeoutMilli must be at least 1000");
                                                throw var16;
                                             }

                                             queuePollTimeoutMilli = var15;
                                             break label110;
                                          }

                                          if ("metricNameSpace".equals(var11)) {
                                             metricNameSpace = var19;
                                             break label109;
                                          }

                                          if ("jvmMetricName".equals(var11)) {
                                             jvmMetricName = var19;
                                             break label108;
                                          }

                                          if ("hostMetricName".equals(var11)) {
                                             hostMetricName = var19;
                                             break label107;
                                          }

                                          var11 = AwsSdkMetrics.class.getSimpleName();
                                          StringBuilder var20 = new StringBuilder();
                                          a.a(var11, var20.append("Ignoring unrecognized parameter: ").append(var9).toString());
                                       } catch (Exception var12) {
                                          a.a(AwsSdkMetrics.class.getSimpleName(), "Ignoring failure", var12);
                                          var5 = var4;
                                          var7 = var3;
                                          var6 = var2;
                                          break label72;
                                       }

                                       var5 = var4;
                                       var7 = var3;
                                       var6 = var2;
                                       break label72;
                                    }

                                    var5 = var4;
                                    var7 = var3;
                                    var6 = var2;
                                    break label72;
                                 }

                                 var5 = var4;
                                 var7 = var3;
                                 var6 = var2;
                                 break label72;
                              }

                              var5 = var4;
                              var7 = var3;
                              var6 = var2;
                              break label72;
                           }

                           var5 = var4;
                           var7 = var3;
                           var6 = var2;
                           break label72;
                        }

                        var5 = var4;
                        var7 = var3;
                        var6 = var2;
                        break label72;
                     }

                     var5 = var4;
                     var7 = var3;
                     var6 = var2;
                     break label72;
                  }

                  var5 = var4;
                  var7 = var3;
                  var6 = var2;
               }
            }

            var0++;
            var4 = var5;
            var3 = var7;
            var2 = var6;
         }

         machineMetricsExcluded = var2;
         perHostMetricsIncluded = var3;
         singleMetricNamespace = var4;
      }

      registry = new AwsSdkMetrics.MetricRegistry();
   }

   public static boolean enableDefaultMetrics() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 02: monitorenter
      // 03: getstatic com/amazonaws/metrics/AwsSdkMetrics.mc Lcom/amazonaws/metrics/MetricCollector;
      // 06: ifnull 12
      // 09: getstatic com/amazonaws/metrics/AwsSdkMetrics.mc Lcom/amazonaws/metrics/MetricCollector;
      // 0c: invokevirtual com/amazonaws/metrics/MetricCollector.isEnabled ()Z
      // 0f: ifne 56
      // 12: getstatic com/amazonaws/metrics/AwsSdkMetrics.dirtyEnabling Z
      // 15: ifeq 2a
      // 18: new java/lang/IllegalStateException
      // 1b: astore 1
      // 1c: aload 1
      // 1d: ldc "Reentrancy is not allowed"
      // 1f: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 22: aload 1
      // 23: athrow
      // 24: astore 1
      // 25: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 27: monitorexit
      // 28: aload 1
      // 29: athrow
      // 2a: bipush 1
      // 2b: putstatic com/amazonaws/metrics/AwsSdkMetrics.dirtyEnabling Z
      // 2e: ldc "com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory"
      // 30: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 33: invokevirtual java/lang/Class.newInstance ()Ljava/lang/Object;
      // 36: checkcast com/amazonaws/metrics/MetricCollector$Factory
      // 39: invokeinterface com/amazonaws/metrics/MetricCollector$Factory.getInstance ()Lcom/amazonaws/metrics/MetricCollector; 1
      // 3e: astore 1
      // 3f: aload 1
      // 40: ifnull 52
      // 43: aload 1
      // 44: invokestatic com/amazonaws/metrics/AwsSdkMetrics.setMetricCollector (Lcom/amazonaws/metrics/MetricCollector;)V
      // 47: bipush 0
      // 48: putstatic com/amazonaws/metrics/AwsSdkMetrics.dirtyEnabling Z
      // 4b: bipush 1
      // 4c: istore 0
      // 4d: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 4f: monitorexit
      // 50: iload 0
      // 51: ireturn
      // 52: bipush 0
      // 53: putstatic com/amazonaws/metrics/AwsSdkMetrics.dirtyEnabling Z
      // 56: bipush 0
      // 57: istore 0
      // 58: goto 4d
      // 5b: astore 1
      // 5c: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 5e: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 61: ldc "Failed to enable the default metrics"
      // 63: aload 1
      // 64: invokestatic com/jibo/aws/integration/util/a.c (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 67: bipush 0
      // 68: putstatic com/amazonaws/metrics/AwsSdkMetrics.dirtyEnabling Z
      // 6b: goto 56
      // 6e: astore 1
      // 6f: bipush 0
      // 70: putstatic com/amazonaws/metrics/AwsSdkMetrics.dirtyEnabling Z
      // 73: aload 1
      // 74: athrow
      // try (2 -> 7): 16 null
      // try (7 -> 16): 16 null
      // try (21 -> 23): 16 null
      // try (23 -> 29): 46 java/lang/Exception
      // try (23 -> 29): 55 null
      // try (31 -> 33): 46 java/lang/Exception
      // try (31 -> 33): 55 null
      // try (33 -> 35): 16 null
      // try (41 -> 43): 16 null
      // try (47 -> 52): 55 null
      // try (52 -> 54): 16 null
      // try (56 -> 60): 16 null
   }

   public static <T extends RequestMetricCollector> T getRequestMetricCollector() {
      if (mc == null && isDefaultMetricsEnabled()) {
         enableDefaultMetrics();
      }

      RequestMetricCollector var0;
      if (mc == null) {
         var0 = RequestMetricCollector.NONE;
      } else {
         var0 = mc.getRequestMetricCollector();
      }

      return (T)var0;
   }

   public static boolean isDefaultMetricsEnabled() {
      return defaultMetricsEnabled;
   }

   private static void setCredentialFile0(String param0) {
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
      // 00: new com/amazonaws/auth/PropertiesCredentials
      // 03: dup
      // 04: new java/io/File
      // 07: dup
      // 08: aload 0
      // 09: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 0c: invokespecial com/amazonaws/auth/PropertiesCredentials.<init> (Ljava/io/File;)V
      // 0f: astore 2
      // 10: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 12: monitorenter
      // 13: new com/amazonaws/metrics/AwsSdkMetrics$1
      // 16: astore 1
      // 17: aload 1
      // 18: aload 2
      // 19: invokespecial com/amazonaws/metrics/AwsSdkMetrics$1.<init> (Lcom/amazonaws/auth/PropertiesCredentials;)V
      // 1c: aload 1
      // 1d: putstatic com/amazonaws/metrics/AwsSdkMetrics.credentialProvider Lcom/amazonaws/auth/AWSCredentialsProvider;
      // 20: aload 0
      // 21: putstatic com/amazonaws/metrics/AwsSdkMetrics.credentialFile Ljava/lang/String;
      // 24: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 26: monitorexit
      // 27: return
      // 28: astore 0
      // 29: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 2b: monitorexit
      // 2c: aload 0
      // 2d: athrow
      // try (10 -> 21): 22 null
      // try (23 -> 25): 22 null
   }

   public static void setMetricCollector(MetricCollector param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 02: monitorenter
      // 03: getstatic com/amazonaws/metrics/AwsSdkMetrics.mc Lcom/amazonaws/metrics/MetricCollector;
      // 06: astore 1
      // 07: aload 0
      // 08: putstatic com/amazonaws/metrics/AwsSdkMetrics.mc Lcom/amazonaws/metrics/MetricCollector;
      // 0b: aload 1
      // 0c: ifnull 14
      // 0f: aload 1
      // 10: invokevirtual com/amazonaws/metrics/MetricCollector.stop ()Z
      // 13: pop
      // 14: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 16: monitorexit
      // 17: return
      // 18: astore 0
      // 19: ldc com/amazonaws/metrics/AwsSdkMetrics
      // 1b: monitorexit
      // 1c: aload 0
      // 1d: athrow
      // try (2 -> 6): 14 null
      // try (8 -> 11): 14 null
   }

   private static class MetricRegistry {
      private final Set<MetricType> metricTypes = new HashSet<>();
      private volatile Set<MetricType> readOnly;

      MetricRegistry() {
         this.metricTypes.add(AWSRequestMetrics.Field.ClientExecuteTime);
         this.metricTypes.add(AWSRequestMetrics.Field.Exception);
         this.metricTypes.add(AWSRequestMetrics.Field.HttpClientRetryCount);
         this.metricTypes.add(AWSRequestMetrics.Field.HttpRequestTime);
         this.metricTypes.add(AWSRequestMetrics.Field.RequestCount);
         this.metricTypes.add(AWSRequestMetrics.Field.RetryCount);
         this.metricTypes.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
         this.metricTypes.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
         this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolAvailableCount);
         this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolLeasedCount);
         this.metricTypes.add(AWSRequestMetrics.Field.HttpClientPoolPendingCount);
         this.metricTypes.add(AWSServiceMetrics.HttpClientGetConnectionTime);
         this.syncReadOnly();
      }

      private void syncReadOnly() {
         this.readOnly = Collections.unmodifiableSet(new HashSet<>(this.metricTypes));
      }
   }
}
