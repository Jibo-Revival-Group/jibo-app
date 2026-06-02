package com.jibo.aws.integration.aws.services.jot;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.jot.model.CreateMessageRequest;
import com.jibo.aws.integration.aws.services.jot.model.ListMessagesRequest;
import com.jibo.aws.integration.aws.services.jot.model.MarkReadRequest;
import com.jibo.aws.integration.aws.services.jot.model.Message;
import com.jibo.aws.integration.aws.services.jot.model.MessagePart;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class JiboJotAsyncClient extends AbstractJiboAsyncClient {
   public JiboJotAsyncClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboJotAsyncClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboJotAsyncClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboJotAsyncClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public Message createMessage(String var1, String var2, List<MessagePart> var3, List<String> var4) {
      return this.getJiboClient().createMessage(var1, var2, var3, var4);
   }

   public Future<Message> createMessage(String var1, String var2, List<MessagePart> var3, List<String> var4, AsyncHandler<CreateMessageRequest, Message> var5) {
      return this.c().submit(new Callable<Message>(this, var1, var2, var3, var4, var5) {
         final String a;
         final String b;
         final List c;
         final List d;
         final AsyncHandler e;
         final JiboJotAsyncClient f;

         {
            this.f = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5x;
            this.e = var6;
         }

         public Message a() {
            Message var1x;
            try {
               var1x = this.f.createMessage(this.a, this.b, this.c, this.d);
            } catch (Exception var2x) {
               if (this.e != null) {
                  this.e.onError(var2x);
               }

               throw var2x;
            }

            if (this.e != null) {
               this.e.onSuccess(new CreateMessageRequest(this.a, this.b, this.c, this.d), var1x);
            }

            return var1x;
         }
      });
   }

   public JiboJotClient getJiboClient() {
      return (JiboJotClient)super.getJiboClient();
   }

   public List<Message> listMessages(String var1, Long var2, Long var3) {
      return this.getJiboClient().listMessages(var1, var2, var3);
   }

   public Future<List<Message>> listMessages(String var1, Long var2, Long var3, AsyncHandler<ListMessagesRequest, List<Message>> var4) {
      return this.c().submit(new Callable<List<Message>>(this, var1, var2, var3, var4) {
         final String a;
         final Long b;
         final Long c;
         final AsyncHandler d;
         final JiboJotAsyncClient e;

         {
            this.e = var1;
            this.a = var2x;
            this.b = var3x;
            this.c = var4x;
            this.d = var5;
         }

         public List<Message> a() {
            List var1x;
            try {
               var1x = this.e.listMessages(this.a, this.b, this.c);
            } catch (Exception var2x) {
               if (this.d != null) {
                  this.d.onError(var2x);
               }

               throw var2x;
            }

            if (this.d != null) {
               this.d.onSuccess(new ListMessagesRequest(this.a, this.b, this.c), var1x);
            }

            return var1x;
         }
      });
   }

   public CommandResponse markRead(List<String> var1) {
      return this.getJiboClient().markRead(var1);
   }

   public Future<CommandResponse> markRead(List<String> var1, AsyncHandler<MarkReadRequest, CommandResponse> var2) {
      return this.c().submit(new Callable<CommandResponse>(this, var1, var2) {
         final List a;
         final AsyncHandler b;
         final JiboJotAsyncClient c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3;
         }

         public CommandResponse a() {
            CommandResponse var1x;
            try {
               var1x = this.c.markRead(this.a);
            } catch (Exception var2x) {
               if (this.b != null) {
                  this.b.onError(var2x);
               }

               throw var2x;
            }

            if (this.b != null) {
               this.b.onSuccess(new MarkReadRequest(this.a), var1x);
            }

            return var1x;
         }
      });
   }
}
