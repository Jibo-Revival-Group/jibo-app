package com.jibo.aws.integration.aws.services.file;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.file.model.FileLink;
import com.jibo.aws.integration.aws.services.file.model.GetFileRequest;
import com.jibo.aws.integration.aws.services.file.model.ListFilesRequest;
import com.jibo.aws.integration.aws.services.file.model.RemoveFileRequest;
import com.jibo.aws.integration.aws.services.file.model.UploadFileRequest;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JiboFileAsyncClient extends JiboFileClient {
   private ExecutorService d;

   @Deprecated
   public JiboFileAsyncClient() {
      this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
   }

   @Deprecated
   public JiboFileAsyncClient(ClientConfiguration var1) {
      this(new BasicAWSCredentials("", ""), var1, Executors.newFixedThreadPool(var1.getMaxConnections()));
   }

   public JiboFileAsyncClient(AWSCredentials var1) {
      this(var1, Executors.newFixedThreadPool(10));
   }

   public JiboFileAsyncClient(AWSCredentials var1, ClientConfiguration var2, ExecutorService var3) {
      super(var1, var2);
      this.d = var3;
   }

   public JiboFileAsyncClient(AWSCredentials var1, ExecutorService var2) {
      super(var1);
      this.d = var2;
   }

   public JiboFileAsyncClient(AWSCredentialsProvider var1) {
      this(var1, Executors.newFixedThreadPool(10));
   }

   public JiboFileAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      this(var1, var2, Executors.newFixedThreadPool(var2.getMaxConnections()));
   }

   public JiboFileAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2, ExecutorService var3) {
      super(var1, var2);
      this.d = var3;
   }

   public JiboFileAsyncClient(AWSCredentialsProvider var1, ExecutorService var2) {
      this(var1, new ClientConfiguration(), var2);
   }

   public ExecutorService getExecutorService() {
      return this.d;
   }

   public Future<FileLink> getFile(String var1, AsyncHandler<GetFileRequest, FileLink> var2) {
      return this.d.submit(new Callable<FileLink>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboFileAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public FileLink a() {
            FileLink var1x;
            try {
               var1x = this.c.getFile(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetFileRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Future<List<FileLink>> listFiles(AsyncHandler<ListFilesRequest, List<FileLink>> var1) {
      return this.d.submit(new Callable<List<FileLink>>(this, var1) {
         final AsyncHandler a;
         final JiboFileAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public List<FileLink> a() {
            List var1x;
            try {
               var1x = this.b.listFiles();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new ListFilesRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public Future<FileLink> removeFile(String var1, AsyncHandler<RemoveFileRequest, FileLink> var2) {
      return this.d.submit(new Callable<FileLink>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboFileAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public FileLink a() {
            FileLink var1x;
            try {
               var1x = this.c.removeFile(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new RemoveFileRequest(this.a), var1x);
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

   public Future<FileLink> uploadFile(String var1, File var2, AsyncHandler<UploadFileRequest, FileLink> var3) {
      return this.d.submit(new Callable<FileLink>(this, var1, var2, var3) {
         final String a;
         final File b;
         final AsyncHandler c;
         final JiboFileAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public FileLink a() {
            FileLink var1x;
            try {
               var1x = this.d.uploadFile(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new UploadFileRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }
}
