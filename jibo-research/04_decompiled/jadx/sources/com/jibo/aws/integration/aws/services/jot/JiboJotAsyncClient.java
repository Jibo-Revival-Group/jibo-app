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

/* JADX INFO: loaded from: classes.dex */
public class JiboJotAsyncClient extends AbstractJiboAsyncClient {
    public JiboJotAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboJotAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboJotAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboJotAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public Message createMessage(String str, String str2, List<MessagePart> list, List<String> list2) {
        return m17207getJiboClient().createMessage(str, str2, list, list2);
    }

    public Future<Message> createMessage(final String str, final String str2, final List<MessagePart> list, final List<String> list2, final AsyncHandler<CreateMessageRequest, Message> asyncHandler) {
        return m9909c().submit(new Callable<Message>() { // from class: com.jibo.aws.integration.aws.services.jot.JiboJotAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Message call() throws Exception {
                try {
                    Message messageCreateMessage = JiboJotAsyncClient.this.createMessage(str, str2, list, list2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateMessageRequest(str, str2, list, list2), messageCreateMessage);
                    }
                    return messageCreateMessage;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    @Override // com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient
    /* JADX INFO: renamed from: getJiboClient, reason: merged with bridge method [inline-methods] */
    public JiboJotClient m17207getJiboClient() {
        return (JiboJotClient) super.m17207getJiboClient();
    }

    public List<Message> listMessages(String str, Long l, Long l2) {
        return m17207getJiboClient().listMessages(str, l, l2);
    }

    public Future<List<Message>> listMessages(final String str, final Long l, final Long l2, final AsyncHandler<ListMessagesRequest, List<Message>> asyncHandler) {
        return m9909c().submit(new Callable<List<Message>>() { // from class: com.jibo.aws.integration.aws.services.jot.JiboJotAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Message> call() throws Exception {
                try {
                    List<Message> listListMessages = JiboJotAsyncClient.this.listMessages(str, l, l2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListMessagesRequest(str, l, l2), listListMessages);
                    }
                    return listListMessages;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public CommandResponse markRead(List<String> list) {
        return m17207getJiboClient().markRead(list);
    }

    public Future<CommandResponse> markRead(final List<String> list, final AsyncHandler<MarkReadRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.jot.JiboJotAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseMarkRead = JiboJotAsyncClient.this.markRead(list);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new MarkReadRequest(list), commandResponseMarkRead);
                    }
                    return commandResponseMarkRead;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }
}
