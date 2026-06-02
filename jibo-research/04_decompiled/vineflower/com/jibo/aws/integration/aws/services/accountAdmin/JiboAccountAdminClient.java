package com.jibo.aws.integration.aws.services.accountAdmin;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.accountAdmin.model.ActivateByIdRequest;
import com.jibo.aws.integration.util.a;

public class JiboAccountAdminClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboAccountAdminClient.class);

   public JiboAccountAdminClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboAccountAdminClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboAccountAdminClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboAccountAdminClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboAccountAdminClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public Account activateById(String var1) {
      return this.a(new ActivateByIdRequest(var1), null, new com.jibo.aws.integration.aws.services.account.model.a.a()).getAwsResponse();
   }
}
