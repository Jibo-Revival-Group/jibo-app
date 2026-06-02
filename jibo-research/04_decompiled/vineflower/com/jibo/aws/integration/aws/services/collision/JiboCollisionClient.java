package com.jibo.aws.integration.aws.services.collision;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;
import com.jibo.aws.integration.aws.services.collision.model.MatchRequest;
import com.jibo.aws.integration.util.a;
import java.util.List;

public class JiboCollisionClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboCollisionClient.class);

   public JiboCollisionClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboCollisionClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboCollisionClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboCollisionClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboCollisionClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public CollisionCheckContainer match(List<String> var1, String var2) {
      return this.a(new MatchRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.collision.model.a.a()).getAwsResponse();
   }
}
