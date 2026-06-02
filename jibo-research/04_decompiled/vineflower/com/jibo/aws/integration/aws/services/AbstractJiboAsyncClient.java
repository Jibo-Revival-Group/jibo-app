package com.jibo.aws.integration.aws.services;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractJiboAsyncClient {
   protected AbstractJiboClient a;
   private ExecutorService b;

   public AbstractJiboAsyncClient() {
      this(new BasicAWSCredentials("", ""), new ClientConfiguration());
   }

   public AbstractJiboAsyncClient(AWSCredentials var1) {
      this.a(var1);
      this.b = this.c();
   }

   public AbstractJiboAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      this.a(var1, var2);
      this.b = this.c();
   }

   public AbstractJiboAsyncClient(AWSCredentialsProvider var1) {
      this.a(var1);
      this.b = this.c();
   }

   public AbstractJiboAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      this.a(var1, var2);
      this.b = this.c();
   }

   private void a(AWSCredentials var1) {
      try {
         this.a = (AbstractJiboClient)Class.forName(this.a()).getConstructor(AWSCredentials.class).newInstance(var1);
      } catch (InstantiationException var2) {
         var2.printStackTrace();
      } catch (IllegalAccessException var3) {
         var3.printStackTrace();
      } catch (InvocationTargetException var4) {
         var4.printStackTrace();
      } catch (NoSuchMethodException var5) {
         var5.printStackTrace();
      } catch (ClassNotFoundException var6) {
         var6.printStackTrace();
      }
   }

   private void a(AWSCredentials var1, ClientConfiguration var2) {
      try {
         this.a = (AbstractJiboClient)Class.forName(this.a()).getConstructor(AWSCredentials.class, ClientConfiguration.class).newInstance(var1, var2);
      } catch (InstantiationException var3) {
         var3.printStackTrace();
      } catch (IllegalAccessException var4) {
         var4.printStackTrace();
      } catch (InvocationTargetException var5) {
         var5.printStackTrace();
      } catch (NoSuchMethodException var6) {
         var6.printStackTrace();
      } catch (ClassNotFoundException var7) {
         var7.printStackTrace();
      }
   }

   private void a(AWSCredentialsProvider var1) {
      try {
         this.a = (AbstractJiboClient)Class.forName(this.a()).getConstructor(AWSCredentialsProvider.class).newInstance(var1);
      } catch (InstantiationException var2) {
         var2.printStackTrace();
      } catch (IllegalAccessException var3) {
         var3.printStackTrace();
      } catch (InvocationTargetException var4) {
         var4.printStackTrace();
      } catch (NoSuchMethodException var5) {
         var5.printStackTrace();
      } catch (ClassNotFoundException var6) {
         var6.printStackTrace();
      }
   }

   private void a(AWSCredentialsProvider var1, ClientConfiguration var2) {
      try {
         this.a = (AbstractJiboClient)Class.forName(this.a()).getConstructor(AWSCredentialsProvider.class, ClientConfiguration.class).newInstance(var1, var2);
      } catch (InstantiationException var3) {
         var3.printStackTrace();
      } catch (IllegalAccessException var4) {
         var4.printStackTrace();
      } catch (InvocationTargetException var5) {
         var5.printStackTrace();
      } catch (NoSuchMethodException var6) {
         var6.printStackTrace();
      } catch (ClassNotFoundException var7) {
         var7.printStackTrace();
      }
   }

   protected String a() {
      return this.getClass().getName().replace("Async", "");
   }

   protected ExecutorService b() {
      return Executors.newCachedThreadPool();
   }

   protected ExecutorService c() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot read field "id" because the return value of "org.jetbrains.java.decompiler.modules.decompiler.flow.FlattenStatementsHelper.getDirectNode(org.jetbrains.java.decompiler.modules.decompiler.stats.Statement)" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:186)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.collectCatchVars(ExprProcessor.java:191)
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
      // 01: invokevirtual com/jibo/aws/integration/aws/services/AbstractJiboAsyncClient.isTerminated ()Z
      // 04: ifeq 15
      // 07: ldc com/jibo/aws/integration/aws/services/AbstractJiboAsyncClient
      // 09: monitorenter
      // 0a: aload 0
      // 0b: aload 0
      // 0c: invokevirtual com/jibo/aws/integration/aws/services/AbstractJiboAsyncClient.b ()Ljava/util/concurrent/ExecutorService;
      // 0f: putfield com/jibo/aws/integration/aws/services/AbstractJiboAsyncClient.b Ljava/util/concurrent/ExecutorService;
      // 12: ldc com/jibo/aws/integration/aws/services/AbstractJiboAsyncClient
      // 14: monitorexit
      // 15: aload 0
      // 16: getfield com/jibo/aws/integration/aws/services/AbstractJiboAsyncClient.b Ljava/util/concurrent/ExecutorService;
      // 19: areturn
      // 1a: astore 1
      // 1b: ldc com/jibo/aws/integration/aws/services/AbstractJiboAsyncClient
      // 1d: monitorexit
      // 1e: aload 1
      // 1f: athrow
      // try (5 -> 11): 14 null
      // try (15 -> 17): 14 null
   }

   protected AbstractJiboClient getJiboClient() {
      if (this.a == null) {
         throw new NullPointerException();
      } else {
         return this.a;
      }
   }

   public boolean isTerminated() {
      boolean var1;
      if (this.b != null && !this.b.isTerminated() && !this.b.isShutdown()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public void setEndpoint(String var1) {
      this.getJiboClient().setEndpoint(var1);
   }

   public void setRegion(Region var1) {
      this.getJiboClient().setRegion(var1);
   }

   public void shutdown() {
      if (this.a != null) {
         this.a.shutdown();
      }

      if (!this.isTerminated()) {
         this.b.shutdownNow();
      }
   }
}
