package com.jibo.aws.integration.aws.services.push;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.Device;
import com.jibo.aws.integration.aws.services.push.model.CreateDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.GetJotNotificationsModeRequest;
import com.jibo.aws.integration.aws.services.push.model.JotNotificationsModeResponse;
import com.jibo.aws.integration.aws.services.push.model.JotPushNotificationsMode;
import com.jibo.aws.integration.aws.services.push.model.RemoveDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.UpdateJotNotificationsModeRequest;
import com.jibo.aws.integration.aws.services.push.model.a.b;
import com.jibo.aws.integration.util.a;
import java.util.List;

public class JiboPushClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboPushClient.class);

   public JiboPushClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboPushClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboPushClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboPushClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboPushClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public List<Device> createDevice(Device var1) {
      return this.a(new CreateDeviceRequest(var1), null, new com.jibo.aws.integration.aws.services.push.model.a.a()).getAwsResponse();
   }

   public JotNotificationsModeResponse getJotNotificationsMode() {
      return this.a(new GetJotNotificationsModeRequest(), null, new b()).getAwsResponse();
   }

   public List<Device> removeDevice(String var1) {
      return this.a(new RemoveDeviceRequest(var1), null, new com.jibo.aws.integration.aws.services.push.model.a.a()).getAwsResponse();
   }

   public JotNotificationsModeResponse updateJotNotificationsMode(JotPushNotificationsMode var1) {
      return this.a(new UpdateJotNotificationsModeRequest(var1), null, new b()).getAwsResponse();
   }
}
