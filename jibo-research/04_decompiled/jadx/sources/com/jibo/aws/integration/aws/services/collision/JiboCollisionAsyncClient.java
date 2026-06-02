package com.jibo.aws.integration.aws.services.collision;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.collision.model.CollisionCheckContainer;
import com.jibo.aws.integration.aws.services.collision.model.MatchRequest;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboCollisionAsyncClient extends AbstractJiboAsyncClient {
    public JiboCollisionAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboCollisionAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboCollisionAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboCollisionAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    @Override // com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient
    /* JADX INFO: renamed from: getJiboClient, reason: merged with bridge method [inline-methods] */
    public JiboCollisionClient m17205getJiboClient() {
        return (JiboCollisionClient) super.m17209getJiboClient();
    }

    public CollisionCheckContainer match(List<String> list, String str) {
        return m17209getJiboClient().match(list, str);
    }

    public Future<CollisionCheckContainer> match(final List<String> list, final String str, final AsyncHandler<MatchRequest, CollisionCheckContainer> asyncHandler) {
        return m9909c().submit(new Callable<CollisionCheckContainer>() { // from class: com.jibo.aws.integration.aws.services.collision.JiboCollisionAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CollisionCheckContainer call() throws Exception {
                try {
                    CollisionCheckContainer collisionCheckContainerMatch = JiboCollisionAsyncClient.this.match(list, str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new MatchRequest(list, str), collisionCheckContainerMatch);
                    }
                    return collisionCheckContainerMatch;
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
