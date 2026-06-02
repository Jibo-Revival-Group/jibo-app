package com.jibo.aws.integration.aws.services.key;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.common.model.a.c;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.BackupRequest;
import com.jibo.aws.integration.aws.services.key.model.CreateRequest;
import com.jibo.aws.integration.aws.services.key.model.GetRequest;
import com.jibo.aws.integration.aws.services.key.model.ListIncomingRequest;
import com.jibo.aws.integration.aws.services.key.model.Request;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.key.model.ShareRequest;
import com.jibo.aws.integration.aws.services.key.model.a.b;
import com.jibo.aws.integration.util.a;
import java.util.List;

public class JiboKeyClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboKeyClient.class);

   public JiboKeyClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboKeyClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboKeyClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboKeyClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboKeyClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public CommandResponse backupEncryptedKey(String var1, String var2, String var3) {
      return this.a(new BackupRequest(var1, var2, var3), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public Request createRequest(String var1, String var2) {
      return this.a(new CreateRequest(var1, var2), null, new b()).getAwsResponse();
   }

   public Request getRequest(String var1) {
      return this.a(new GetRequest(var1), new c(), new b()).getAwsResponse();
   }

   public List<Request> listIncomingRequests(String var1) {
      return this.a(new ListIncomingRequest(var1), null, new com.jibo.aws.integration.aws.services.key.model.a.a()).getAwsResponse();
   }

   public Backup restoreEncryptedKey(String var1, String var2) {
      return this.a(new RestoreRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.loop.model.a.a()).getAwsResponse();
   }

   public Request share(String var1, String var2) {
      return this.a(new ShareRequest(var1, var2), null, new b()).getAwsResponse();
   }
}
