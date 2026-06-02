package com.jibo.aws.integration.aws.services.push;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.Device;
import com.jibo.aws.integration.aws.services.push.model.CreateDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.GetJotNotificationsModeRequest;
import com.jibo.aws.integration.aws.services.push.model.JotNotificationsModeResponse;
import com.jibo.aws.integration.aws.services.push.model.JotPushNotificationsMode;
import com.jibo.aws.integration.aws.services.push.model.RemoveDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.UpdateJotNotificationsModeRequest;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboPushAsyncClient extends AbstractJiboAsyncClient {
   public JiboPushAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboPushAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboPushAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboPushAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public List<Device> createDevice(Device var1) {
      return this.getJiboClient().createDevice(var1);
   }

   public Future<List<Device>> createDevice(Device var1, AsyncHandler<CreateDeviceRequest, List<Device>> var2) {
      return this.c().submit(new Callable<List<Device>>(this, var1, var2) {
         final Device a;
         final AsyncHandler b;
         final JiboPushAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Device> a() {
            List var1x;
            try {
               var1x = this.c.createDevice(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new CreateDeviceRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboPushClient getJiboClient() {
      return (JiboPushClient)super.getJiboClient();
   }

   public JotNotificationsModeResponse getJotNotificationsMode() {
      return this.getJiboClient().getJotNotificationsMode();
   }

   public Future<JotNotificationsModeResponse> getJotNotificationsMode(AsyncHandler<GetJotNotificationsModeRequest, JotNotificationsModeResponse> var1) {
      return this.c().submit(new Callable<JotNotificationsModeResponse>(this, var1) {
         final AsyncHandler a;
         final JiboPushAsyncClient b;

         {
            this.b = var1;
            this.a = var2;
         }

         public JotNotificationsModeResponse a() {
            JotNotificationsModeResponse var1x;
            try {
               var1x = this.b.getJotNotificationsMode();
            } catch (Exception var2) {
               if (this.a != null) {
                  this.a.onError(var2);
               }

               throw var2;
            }

            if (this.a != null) {
               this.a.onSuccess(new GetJotNotificationsModeRequest(), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Device> removeDevice(String var1) {
      return this.getJiboClient().removeDevice(var1);
   }

   public Future<List<Device>> removeDevice(String var1, AsyncHandler<RemoveDeviceRequest, List<Device>> var2) {
      return this.c().submit(new Callable<List<Device>>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboPushAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Device> a() {
            List var1x;
            try {
               var1x = this.c.removeDevice(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new RemoveDeviceRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public JotNotificationsModeResponse updateJotNotificationsMode(JotPushNotificationsMode var1) {
      return this.getJiboClient().updateJotNotificationsMode(var1);
   }

   public Future<JotNotificationsModeResponse> updateJotNotificationsMode(
      JotPushNotificationsMode var1, AsyncHandler<UpdateJotNotificationsModeRequest, JotNotificationsModeResponse> var2
   ) {
      return this.c().submit(new Callable<JotNotificationsModeResponse>(this, var1, var2) {
         final JotPushNotificationsMode a;
         final AsyncHandler b;
         final JiboPushAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public JotNotificationsModeResponse a() {
            JotNotificationsModeResponse var1x;
            try {
               var1x = this.c.updateJotNotificationsMode(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new UpdateJotNotificationsModeRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }
}
