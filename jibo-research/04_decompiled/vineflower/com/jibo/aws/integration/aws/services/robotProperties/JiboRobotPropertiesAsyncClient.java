package com.jibo.aws.integration.aws.services.robotProperties;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetFriendlyIdsRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.IdPair;
import com.jibo.aws.integration.aws.services.robotProperties.model.RemoveRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboRobotPropertiesAsyncClient extends AbstractJiboAsyncClient {
   public JiboRobotPropertiesAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboRobotPropertiesAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboRobotPropertiesAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboRobotPropertiesAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public CommandResponse createRobot(Robot var1) {
      return this.getJiboClient().createRobot(var1);
   }

   public Future<CommandResponse> createRobot(Robot var1, AsyncHandler<CreateRobotRequest, CommandResponse> var2) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2) {
         final Robot a;
         final AsyncHandler b;
         final JiboRobotPropertiesAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.c.createRobot(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new CreateRobotRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public List<IdPair> getFriendlyIds(int var1) {
      return this.getJiboClient().getFriendlyIds(var1);
   }

   public Future<List<IdPair>> getFriendlyIds(int var1, AsyncHandler<GetFriendlyIdsRequest, List<IdPair>> var2) {
      return this.c().submit(new Callable<List<IdPair>>(this, var1, var2) {
         final int a;
         final AsyncHandler b;
         final JiboRobotPropertiesAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<IdPair> a() {
            List var1x;
            try {
               var1x = this.c.getFriendlyIds(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetFriendlyIdsRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboRobotPropertiesClient getJiboClient() {
      return (JiboRobotPropertiesClient)super.getJiboClient();
   }

   public Robot getRobot(String var1) {
      return this.getJiboClient().getRobot(var1);
   }

   public Future<Robot> getRobot(String var1, AsyncHandler<GetRobotRequest, Robot> var2) {
      return this.c().submit(new Callable<Robot>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboRobotPropertiesAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Robot a() {
            Robot var1x;
            try {
               var1x = this.c.getRobot(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetRobotRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse removeRobot(String var1) {
      return this.getJiboClient().removeRobot(var1);
   }

   public Future<CommandResponse> removeRobot(String var1, AsyncHandler<RemoveRobotRequest, CommandResponse> var2) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboRobotPropertiesAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.c.removeRobot(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new RemoveRobotRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse updateRobot(Robot var1) {
      return this.getJiboClient().updateRobot(var1);
   }

   public Future<CommandResponse> updateRobot(Robot var1, AsyncHandler<CreateRobotRequest, CommandResponse> var2) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2) {
         final Robot a;
         final AsyncHandler b;
         final JiboRobotPropertiesAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.c.updateRobot(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new CreateRobotRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }
}
