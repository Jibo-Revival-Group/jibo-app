package com.jibo.aws.integration.aws.services.jot;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.jot.model.CreateMessageRequest;
import com.jibo.aws.integration.aws.services.jot.model.ListMessagesRequest;
import com.jibo.aws.integration.aws.services.jot.model.MarkReadRequest;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import com.jibo.aws.integration.aws.services.jot.model.a.b;
import com.jibo.aws.integration.util.a;
import java.util.List;

public class JiboJotClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboJotClient.class);

   public JiboJotClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboJotClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboJotClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboJotClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboJotClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public Message createMessage(String var1, String var2, List<MessagePart> var3, List<String> var4) {
      return this.a(new CreateMessageRequest(var1, var2, var3, var4), null, new com.jibo.aws.integration.aws.services.jot.model.a.a()).getAwsResponse();
   }

   public List<Message> listMessages(String var1, Long var2, Long var3) {
      return this.a(new ListMessagesRequest(var1, var2, var3), null, new b()).getAwsResponse();
   }

   public CommandResponse markRead(List<String> var1) {
      return this.a(new MarkReadRequest(var1), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }
}
