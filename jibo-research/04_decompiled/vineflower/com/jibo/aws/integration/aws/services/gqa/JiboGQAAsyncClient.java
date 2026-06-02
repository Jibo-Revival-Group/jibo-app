package com.jibo.aws.integration.aws.services.gqa;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;
import com.jibo.aws.integration.aws.services.gqa.model.ListAttributionRequest;
import com.jibo.aws.integration.aws.services.gqa.model.QuestionRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboGQAAsyncClient extends AbstractJiboAsyncClient {
   public JiboGQAAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboGQAAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboGQAAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboGQAAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboGQAClient getJiboClient() {
      return (JiboGQAClient)super.getJiboClient();
   }

   public AttributionListResponse listAttributions(String var1, long var2) {
      return this.getJiboClient().listAttributions(var1, var2);
   }

   public Future<AttributionListResponse> listAttributions(String var1, long var2, AsyncHandler<ListAttributionRequest, AttributionListResponse> var4) {
      return this.c().submit(new Callable<AttributionListResponse>(this, var1, var2, var4) {
         final String a;
         final long b;
         final AsyncHandler c;
         final JiboGQAAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3;
            this.c = var5;
         }

         public AttributionListResponse a() {
            AttributionListResponse var1x;
            try {
               var1x = this.d.listAttributions(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new ListAttributionRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public GQAAttribution sendQuestion(String var1) {
      return this.getJiboClient().sendQuestion(var1);
   }

   public Future<GQAAttribution> sendQuestion(String var1, AsyncHandler<QuestionRequest, GQAAttribution> var2) {
      return this.c().submit(new Callable<GQAAttribution>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboGQAAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public GQAAttribution a() {
            GQAAttribution var1x;
            try {
               var1x = this.c.sendQuestion(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new QuestionRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }
}
