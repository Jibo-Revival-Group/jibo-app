package com.jibo.aws.integration.aws.services.key;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.BackupRequest;
import com.jibo.aws.integration.aws.services.key.model.CreateRequest;
import com.jibo.aws.integration.aws.services.key.model.GetRequest;
import com.jibo.aws.integration.aws.services.key.model.ListIncomingRequest;
import com.jibo.aws.integration.aws.services.key.model.Request;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.key.model.ShareRequest;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboKeyAsyncClient extends AbstractJiboAsyncClient {
   public JiboKeyAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboKeyAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboKeyAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboKeyAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public CommandResponse backupEncryptedKey(String var1, String var2, String var3) {
      return this.getJiboClient().backupEncryptedKey(var1, var2, var3);
   }

   public Future<CommandResponse> backupEncryptedKey(String var1, String var2, String var3, AsyncHandler<BackupRequest, CommandResponse> var4) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3, var4) {
         final String a;
         final String b;
         final String c;
         final AsyncHandler d;
         final JiboKeyAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.e.backupEncryptedKey(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new BackupRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }

   public Request createRequest(String var1, String var2) {
      return this.getJiboClient().createRequest(var1, var2);
   }

   public Future<Request> createRequest(String var1, String var2, AsyncHandler<CreateRequest, Request> var3) {
      return this.c().submit(new Callable<Request>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboKeyAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Request a() {
            Request var1x;
            try {
               var1x = this.d.createRequest(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new CreateRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboKeyClient getJiboClient() {
      return (JiboKeyClient)super.getJiboClient();
   }

   public Request getRequest(String var1) {
      return this.getJiboClient().getRequest(var1);
   }

   public Future<Request> getRequest(String var1, AsyncHandler<GetRequest, Request> var2) {
      return this.c().submit(new Callable<Request>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboKeyAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Request a() {
            Request var1x;
            try {
               var1x = this.c.getRequest(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Request> listIncomingRequests(String var1) {
      return this.getJiboClient().listIncomingRequests(var1);
   }

   public Future<List<Request>> listIncomingRequests(String var1, AsyncHandler<ListIncomingRequest, List<Request>> var2) {
      return this.c().submit(new Callable<List<Request>>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboKeyAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Request> a() {
            List var1x;
            try {
               var1x = this.c.listIncomingRequests(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new ListIncomingRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public Backup restoreEncryptedKey(String var1, String var2) {
      return this.getJiboClient().restoreEncryptedKey(var1, var2);
   }

   public Future<Backup> restoreEncryptedKey(String var1, String var2, AsyncHandler<RestoreRequest, Backup> var3) {
      return this.c().submit(new Callable<Backup>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboKeyAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Backup a() {
            Backup var1x;
            try {
               var1x = this.d.restoreEncryptedKey(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new RestoreRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public Request share(String var1, String var2) {
      return this.getJiboClient().share(var1, var2);
   }

   public Future<Request> share(String var1, String var2, AsyncHandler<ShareRequest, Request> var3) {
      return this.c().submit(new Callable<Request>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboKeyAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public Request a() {
            Request var1x;
            try {
               var1x = this.d.share(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new ShareRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }
}
