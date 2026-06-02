package com.jibo.aws.integration.aws.services.notification;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.util.a;

public class JiboNotificationClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboNotificationClient.class);

   public JiboNotificationClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboNotificationClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboNotificationClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboNotificationClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboNotificationClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public StatusContainer getStatus(String var1) {
      return this.a(new GetStatusRequest(var1), null, new com.jibo.aws.integration.aws.services.notification.model.a.a()).getAwsResponse();
   }
}
