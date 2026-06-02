package com.jibo.aws.integration.aws.services.binary;

import android.content.Context;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.binary.model.BinaryLink;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.GetBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.ListBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.RemoveBinaryRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JiboBinaryAsyncClient extends JiboBinaryClient {
   private ExecutorService d;

   @Deprecated
   public JiboBinaryAsyncClient() {
      this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
   }

   @Deprecated
   public JiboBinaryAsyncClient(ClientConfiguration var1) {
      this(new BasicAWSCredentials("", ""), var1, Executors.newFixedThreadPool(var1.getMaxConnections()));
   }

   public JiboBinaryAsyncClient(AWSCredentials var1) {
      this(var1, Executors.newFixedThreadPool(10));
   }

   public JiboBinaryAsyncClient(AWSCredentials var1, ClientConfiguration var2, ExecutorService var3) {
      super(var1, var2);
      this.d = var3;
   }

   public JiboBinaryAsyncClient(AWSCredentials var1, ExecutorService var2) {
      super(var1);
      this.d = var2;
   }

   public JiboBinaryAsyncClient(AWSCredentialsProvider var1) {
      this(var1, Executors.newFixedThreadPool(10));
   }

   public JiboBinaryAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      this(var1, var2, Executors.newFixedThreadPool(var2.getMaxConnections()));
   }

   public JiboBinaryAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2, ExecutorService var3) {
      super(var1, var2);
      this.d = var3;
   }

   public JiboBinaryAsyncClient(AWSCredentialsProvider var1, ExecutorService var2) {
      this(var1, new ClientConfiguration(), var2);
   }

   public Future<BinaryLink> create(String var1, File var2, Map<String, String> var3, AsyncHandler<CreateBinaryRequest, BinaryLink> var4) {
      return this.d.submit(new Callable<BinaryLink>(this, var1, var2, var3, var4) {
         final String a;
         final File b;
         final Map c;
         final AsyncHandler d;
         final JiboBinaryAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public BinaryLink a() {
            BinaryLink var1x;
            try {
               var1x = this.e.create(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new CreateBinaryRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }

   public Future<BinaryLink> get(Context var1, String var2, AsyncHandler<GetBinaryRequest, BinaryLink> var3) {
      return this.d.submit(new Callable<BinaryLink>(this, var1, var2, var3) {
         final Context a;
         final String b;
         final AsyncHandler c;
         final JiboBinaryAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public BinaryLink a() {
            BinaryLink var1x;
            try {
               var1x = this.d.get(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new GetBinaryRequest(this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Future<BinaryLink> get(String var1, AsyncHandler<GetBinaryRequest, BinaryLink> var2) {
      return this.d.submit(new Callable<BinaryLink>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboBinaryAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public BinaryLink a() {
            BinaryLink var1x;
            try {
               var1x = this.c.get(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetBinaryRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Future<BinaryLink> get(String var1, String var2, AsyncHandler<GetBinaryRequest, BinaryLink> var3) {
      return this.d.submit(new Callable<BinaryLink>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboBinaryAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public BinaryLink a() {
            BinaryLink var1x;
            try {
               var1x = this.d.get(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new GetBinaryRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public ExecutorService getExecutorService() {
      return this.d;
   }

   public Future<List<BinaryLink>> list(String var1, AsyncHandler<ListBinaryRequest, List<BinaryLink>> var2) {
      return this.d.submit(new Callable<List<BinaryLink>>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboBinaryAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<BinaryLink> a() {
            List var1x;
            try {
               var1x = this.c.list(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new ListBinaryRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Future<BinaryLink> remove(String var1, AsyncHandler<RemoveBinaryRequest, BinaryLink> var2) {
      return this.d.submit(new Callable<BinaryLink>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboBinaryAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public BinaryLink a() {
            BinaryLink var1x;
            try {
               var1x = this.c.remove(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new RemoveBinaryRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   @Override
   public void shutdown() {
      super.shutdown();
      this.d.shutdownNow();
   }
}
