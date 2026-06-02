package com.jibo.aws.integration.aws.services.notification;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboNotificationAsyncClient extends AbstractJiboAsyncClient {
   public JiboNotificationAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboNotificationAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboNotificationAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboNotificationAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboNotificationClient getJiboClient() {
      return (JiboNotificationClient)super.getJiboClient();
   }

   public StatusContainer getStatus(String var1) {
      return this.getJiboClient().getStatus(var1);
   }

   public Future<StatusContainer> getStatus(String var1, AsyncHandler<GetStatusRequest, StatusContainer> var2) {
      return this.c().submit(new Callable<StatusContainer>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboNotificationAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public StatusContainer a() {
            StatusContainer var1x;
            try {
               var1x = this.c.getStatus(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetStatusRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }
}
