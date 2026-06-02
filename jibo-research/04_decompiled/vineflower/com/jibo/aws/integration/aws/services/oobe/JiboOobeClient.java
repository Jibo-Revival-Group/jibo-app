package com.jibo.aws.integration.aws.services.oobe;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.oobe.model.KeysContainer;
import com.jibo.aws.integration.aws.services.oobe.model.PrepareRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.SetupRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.StatusContainer;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import com.jibo.aws.integration.aws.services.oobe.model.a.b;
import com.jibo.aws.integration.aws.services.oobe.model.a.c;
import com.jibo.aws.integration.util.a;

public class JiboOobeClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboOobeClient.class);

   public JiboOobeClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboOobeClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboOobeClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboOobeClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboOobeClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public StatusContainer getStatus(String var1) {
      return this.a(new GetStatusRequest(var1), null, new b()).getAwsResponse();
   }

   public TokenContainer prepareRobot(String var1) {
      return this.a(new PrepareRobotRequest(var1), null, new c()).getAwsResponse();
   }

   public KeysContainer setupRobot(String var1, String var2) {
      return this.a(new SetupRobotRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.oobe.model.a.a()).getAwsResponse();
   }
}
