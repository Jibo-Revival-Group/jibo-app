package com.jibo.aws.integration.aws.services.accountAdmin;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.accountAdmin.model.ActivateByIdRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboAccountAdminAsyncClient extends AbstractJiboAsyncClient {
   public JiboAccountAdminAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboAccountAdminAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboAccountAdminAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboAccountAdminAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public Account activateById(String var1) {
      return this.getJiboClient().activateById(var1);
   }

   public Future<Account> activateById(String var1, AsyncHandler<ActivateByIdRequest, Account> var2) {
      return this.c().submit(new Callable<Account>(this, var1, var2) {
         final String a;
         final AsyncHandler b;
         final JiboAccountAdminAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public Account a() {
            Account var1x;
            try {
               var1x = this.c.activateById(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new ActivateByIdRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboAccountAdminClient getJiboClient() {
      return (JiboAccountAdminClient)super.getJiboClient();
   }
}
