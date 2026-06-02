package com.jibo.aws.integration.aws.services.notification;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboNotificationAsyncClient extends AbstractJiboAsyncClient {
    public JiboNotificationAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboNotificationAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboNotificationAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboNotificationAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    @Override // com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient
    /* JADX INFO: renamed from: getJiboClient, reason: merged with bridge method [inline-methods] */
    public JiboNotificationClient m17211getJiboClient() {
        return (JiboNotificationClient) super.m17209getJiboClient();
    }

    public StatusContainer getStatus(String str) {
        return m17209getJiboClient().getStatus(str);
    }

    public Future<StatusContainer> getStatus(final String str, final AsyncHandler<GetStatusRequest, StatusContainer> asyncHandler) {
        return m9909c().submit(new Callable<StatusContainer>() { // from class: com.jibo.aws.integration.aws.services.notification.JiboNotificationAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public StatusContainer call() throws Exception {
                try {
                    StatusContainer status = JiboNotificationAsyncClient.this.getStatus(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetStatusRequest(str), status);
                    }
                    return status;
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
