package com.jibo.aws.integration.aws.services.gqa;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.a.e;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;
import com.jibo.aws.integration.aws.services.gqa.model.ListAttributionRequest;
import com.jibo.aws.integration.aws.services.gqa.model.QuestionRequest;
import com.jibo.aws.integration.aws.services.gqa.model.a.b;
import com.jibo.aws.integration.util.a;

public class JiboGQAClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboGQAClient.class);

   public JiboGQAClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboGQAClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboGQAClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboGQAClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboGQAClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public AttributionListResponse listAttributions(String var1, long var2) {
      return this.a(new ListAttributionRequest(var1, var2), new e(), new b()).getAwsResponse();
   }

   public GQAAttribution sendQuestion(String var1) {
      return this.a(new QuestionRequest(var1), new e(), new com.jibo.aws.integration.aws.services.gqa.model.a.a()).getAwsResponse();
   }
}
