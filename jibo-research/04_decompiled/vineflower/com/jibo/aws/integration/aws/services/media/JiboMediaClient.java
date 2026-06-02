package com.jibo.aws.integration.aws.services.media;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.media.model.CreateRequest;
import com.jibo.aws.integration.aws.services.media.model.GetRequest;
import com.jibo.aws.integration.aws.services.media.model.ListRequest;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.aws.services.media.model.RemoveRequest;
import com.jibo.aws.integration.aws.services.media.model.a.b;
import com.jibo.aws.integration.aws.services.media.model.a.c;
import com.jibo.aws.integration.util.a;
import java.io.File;
import java.util.List;

public class JiboMediaClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboMediaClient.class);

   public JiboMediaClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboMediaClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboMediaClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboMediaClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboMediaClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public Media create(String var1, String var2, String var3, String var4, File var5, Boolean var6) {
      return this.a(new CreateRequest(var1, var2, var3, var4, var5, var6), new com.jibo.aws.integration.aws.services.media.model.a.a(), new b())
         .getAwsResponse();
   }

   public List<Media> get(List<String> var1) {
      return this.a(new GetRequest(var1), null, new c()).getAwsResponse();
   }

   public List<Media> list(List<String> var1, Long var2, Long var3) {
      return this.a(new ListRequest(var1, var2, var3), null, new c()).getAwsResponse();
   }

   public List<Media> remove(List<String> var1) {
      return this.a(new RemoveRequest(var1), null, new c()).getAwsResponse();
   }
}
