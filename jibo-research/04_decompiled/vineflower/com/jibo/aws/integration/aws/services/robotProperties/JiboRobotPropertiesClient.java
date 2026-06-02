package com.jibo.aws.integration.aws.services.robotProperties;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.common.model.a.c;
import com.jibo.aws.integration.aws.services.robotProperties.model.CreateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetFriendlyIdsRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.GetRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.IdPair;
import com.jibo.aws.integration.aws.services.robotProperties.model.RemoveRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.Robot;
import com.jibo.aws.integration.aws.services.robotProperties.model.UpdateRobotRequest;
import com.jibo.aws.integration.aws.services.robotProperties.model.a.b;
import com.jibo.aws.integration.util.a;
import java.util.List;

public class JiboRobotPropertiesClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboRobotPropertiesClient.class);

   public JiboRobotPropertiesClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboRobotPropertiesClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboRobotPropertiesClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboRobotPropertiesClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboRobotPropertiesClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public CommandResponse createRobot(Robot var1) {
      return this.a(new CreateRobotRequest(var1), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public List<IdPair> getFriendlyIds(int var1) {
      return this.a(new GetFriendlyIdsRequest(var1), null, new com.jibo.aws.integration.aws.services.robotProperties.model.a.a()).getAwsResponse();
   }

   public Robot getRobot(String var1) {
      return this.a(new GetRobotRequest(var1), new c(), new b()).getAwsResponse();
   }

   public CommandResponse removeRobot(String var1) {
      return this.a(new RemoveRobotRequest(var1), new c(), new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public CommandResponse updateRobot(Robot var1) {
      return this.a(new UpdateRobotRequest(var1), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }
}
