package com.jibo.aws.integration.aws.services.person;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.person.model.GetAccountPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.aws.integration.aws.services.person.model.ListHolidaysRequest;
import com.jibo.aws.integration.aws.services.person.model.SetAccountPropertyRequest;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboPersonAsyncClient extends AbstractJiboAsyncClient {
   public JiboPersonAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboPersonAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboPersonAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboPersonAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public HashMap<String, JsonObject> getAccountProperties(List<String> var1) {
      return this.getJiboClient().getAccountProperties(var1);
   }

   public Future<HashMap<String, JsonObject>> getAccountProperties(
      List<String> var1, AsyncHandler<GetAccountPropertiesRequest, HashMap<String, JsonObject>> var2
   ) {
      return this.c().submit(new Callable<HashMap<String, JsonObject>>(this, var1, var2) {
         final List a;
         final AsyncHandler b;
         final JiboPersonAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public HashMap<String, JsonObject> a() {
            HashMap var1x;
            try {
               var1x = this.c.getAccountProperties(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new GetAccountPropertiesRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboPersonClient getJiboClient() {
      return (JiboPersonClient)super.getJiboClient();
   }

   public HashMap<String, JsonObject> getLoopProperties(String var1, List<String> var2) {
      return this.getJiboClient().getLoopProperties(var1, var2);
   }

   public Future<HashMap<String, JsonObject>> getLoopProperties(
      String var1, List<String> var2, AsyncHandler<GetLoopPropertiesRequest, HashMap<String, JsonObject>> var3
   ) {
      return this.c().submit(new Callable<HashMap<String, JsonObject>>(this, var1, var2, var3) {
         final String a;
         final List b;
         final AsyncHandler c;
         final JiboPersonAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public HashMap<String, JsonObject> a() {
            HashMap var1x;
            try {
               var1x = this.d.getLoopProperties(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new GetLoopPropertiesRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public List<Holiday> listHolidays(String var1) {
      return this.getJiboClient().listHolidays(var1);
   }

   public Future<List<Holiday>> listHolidays(String var1, AsyncHandler<ListHolidaysRequest, List<Holiday>> var2) {
      return this.c().submit(new Callable<List<Holiday>>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboPersonAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public List<Holiday> a() {
            List var1x;
            try {
               var1x = this.c.listHolidays(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new ListHolidaysRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse setAccountProperty(String var1, JsonObject var2) {
      return this.getJiboClient().setAccountProperty(var1, var2);
   }

   public Future<CommandResponse> setAccountProperty(String var1, JsonObject var2, AsyncHandler<SetAccountPropertyRequest, CommandResponse> var3) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3) {
         final String a;
         final JsonObject b;
         final AsyncHandler c;
         final JiboPersonAsyncClient d;

         {
            this.d = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.d.setAccountProperty(this.a, this.b);
            } catch (Exception var2x) {
               if (this.c != null) {
                  this.c.onError(var2x);
               }

               throw var2x;
            }

            if (this.c != null) {
               this.c.onSuccess(new SetAccountPropertyRequest(this.a, this.b), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse setLoopProperty(String var1, String var2, JsonObject var3) {
      return this.getJiboClient().setLoopProperty(var1, var2, var3);
   }

   public Future<CommandResponse> setLoopProperty(String var1, String var2, JsonObject var3, AsyncHandler<SetLoopPropertyRequest, CommandResponse> var4) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3, var4) {
         final String a;
         final String b;
         final JsonObject c;
         final AsyncHandler d;
         final JiboPersonAsyncClient e;

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
               var1x = this.e.setLoopProperty(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new SetLoopPropertyRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse switchHolidays(boolean var1, List<String> var2, String var3) {
      return this.getJiboClient().switchHolidays(var1, var2, var3);
   }

   public Future<CommandResponse> switchHolidays(boolean var1, List<String> var2, String var3, AsyncHandler<HolidaysSwitchRequest, CommandResponse> var4) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2, var3, var4) {
         final boolean a;
         final List b;
         final String c;
         final AsyncHandler d;
         final JiboPersonAsyncClient e;

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
               var1x = this.e.switchHolidays(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new HolidaysSwitchRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }
}
