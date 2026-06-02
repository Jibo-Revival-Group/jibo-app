package com.jibo.aws.integration.aws.services.collision;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;
import com.jibo.aws.integration.aws.services.collision.model.MatchRequest;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboCollisionAsyncClient extends AbstractJiboAsyncClient {
   public JiboCollisionAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboCollisionAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboCollisionAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboCollisionAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboCollisionClient getJiboClient() {
      return (JiboCollisionClient)super.getJiboClient();
   }

   public CollisionCheckContainer match(List<String> var1, String var2) {
      return this.getJiboClient().match(var1, var2);
   }

   public Future<CollisionCheckContainer> match(List<String> var1, String var2, AsyncHandler<MatchRequest, CollisionCheckContainer> var3) {
      return this.c().submit(new Callable<CollisionCheckContainer>(this, var1, var2, var3) {
         final List a;
         final String b;
         final AsyncHandler c;
         final JiboCollisionAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public CollisionCheckContainer a() {
            CollisionCheckContainer var1x;
            try {
               var1x = this.d.match(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new MatchRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }
}
