package com.jibo.aws.integration.aws.services.media;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.media.model.CreateRequest;
import com.jibo.aws.integration.aws.services.media.model.GetRequest;
import com.jibo.aws.integration.aws.services.media.model.ListRequest;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.aws.services.media.model.RemoveRequest;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboMediaAsyncClient extends AbstractJiboAsyncClient {
   public JiboMediaAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboMediaAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboMediaAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboMediaAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public Media create(String var1, String var2, String var3, String var4, File var5, Boolean var6) {
      return this.getJiboClient().create(var1, var2, var3, var4, var5, var6);
   }

   public Future<Media> create(String var1, String var2, String var3, String var4, File var5, Boolean var6, AsyncHandler<CreateRequest, Media> var7) {
      return this.c().submit(new Callable<Media>(this, var1, var2, var3, var4, var5, var6, var7) {
         final String a;
         final String b;
         final String c;
         final String d;
         final File e;
         final Boolean f;
         final AsyncHandler g;
         final JiboMediaAsyncClient h;

         {
            this.h = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6x;
            this.f = var7x;
            this.g = var8;
         }

         public Media a() {
            Media var1x;
            try {
               var1x = this.h.create(this.a, this.b, this.c, this.d, this.e, this.f);
            } catch (Exception var2x) {
               if (this.g != null) {
                  this.g.onError(var2x);
               }

               throw var2x;
            }

            if (this.g != null) {
               this.g.onSuccess(new CreateRequest(this.a, this.b, this.c, this.d, this.e, this.f), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Media> get(List<String> var1) {
      return this.getJiboClient().get(var1);
   }

   public Future<List<Media>> get(List<String> var1, AsyncHandler<GetRequest, List<Media>> var2) {
      return this.c().submit(new Callable<List<Media>>(this, var1, var2) {
         final List a;
         final AsyncHandler b;
         final JiboMediaAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Media> a() {
            List var1x;
            try {
               var1x = this.c.get(this.a);
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

   public JiboMediaClient getJiboClient() {
      return (JiboMediaClient)super.getJiboClient();
   }

   public List<Media> list(List<String> var1, Long var2, Long var3) {
      return this.getJiboClient().list(var1, var2, var3);
   }

   public Future<List<Media>> list(List<String> var1, Long var2, Long var3, AsyncHandler<ListRequest, List<Media>> var4) {
      return this.c().submit(new Callable<List<Media>>(this, var1, var2, var3, var4) {
         final List a;
         final Long b;
         final Long c;
         final AsyncHandler d;
         final JiboMediaAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public List<Media> a() {
            List var1x;
            try {
               var1x = this.e.list(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new ListRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Media> remove(List<String> var1) {
      return this.getJiboClient().remove(var1);
   }

   public Future<List<Media>> remove(List<String> var1, AsyncHandler<RemoveRequest, List<Media>> var2) {
      return this.c().submit(new Callable<List<Media>>(this, var1, var2) {
         final List a;
         final AsyncHandler b;
         final JiboMediaAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Media> a() {
            List var1x;
            try {
               var1x = this.c.remove(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new RemoveRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }
}
