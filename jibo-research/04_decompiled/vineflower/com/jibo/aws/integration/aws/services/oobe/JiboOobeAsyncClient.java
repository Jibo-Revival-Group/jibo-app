package com.jibo.aws.integration.aws.services.oobe;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.oobe.model.KeysContainer;
import com.jibo.aws.integration.aws.services.oobe.model.PrepareRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.SetupRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.StatusContainer;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboOobeAsyncClient extends AbstractJiboAsyncClient {
   public JiboOobeAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboOobeAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboOobeAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboOobeAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboOobeClient getJiboClient() {
      return (JiboOobeClient)super.getJiboClient();
   }

   public StatusContainer getStatus(String var1) {
      return this.getJiboClient().getStatus(var1);
   }

   public Future<StatusContainer> getStatus(String var1, AsyncHandler<GetStatusRequest, StatusContainer> var2) {
      return this.c().submit(new Callable<StatusContainer>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboOobeAsyncClient c;

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

   public TokenContainer prepareRobot(String var1) {
      return this.getJiboClient().prepareRobot(var1);
   }

   public Future<TokenContainer> prepareRobot(String var1, AsyncHandler<PrepareRobotRequest, TokenContainer> var2) {
      return this.c().submit(new Callable<TokenContainer>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboOobeAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public TokenContainer a() {
            TokenContainer var1x;
            try {
               var1x = this.c.prepareRobot(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new PrepareRobotRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public KeysContainer setupRobot(String var1, String var2) {
      return this.getJiboClient().setupRobot(var1, var2);
   }

   public Future<KeysContainer> setupRobot(String var1, String var2, AsyncHandler<SetupRobotRequest, KeysContainer> var3) {
      return this.c().submit(new Callable<KeysContainer>(this, var1, var2, var3) {
         final String a;
         final String b;
         final AsyncHandler c;
         final JiboOobeAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public KeysContainer a() {
            KeysContainer var1x;
            try {
               var1x = this.d.setupRobot(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new SetupRobotRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }
}
