package com.jibo.aws.integration.aws.services.gqa;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.gqa.model.AttributionListResponse;
import com.jibo.aws.integration.aws.services.gqa.model.GQAAttribution;
import com.jibo.aws.integration.aws.services.gqa.model.ListAttributionRequest;
import com.jibo.aws.integration.aws.services.gqa.model.QuestionRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboGQAAsyncClient extends AbstractJiboAsyncClient {
    public JiboGQAAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboGQAAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboGQAAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboGQAAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    @Override // com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient
    /* JADX INFO: renamed from: getJiboClient, reason: merged with bridge method [inline-methods] */
    public JiboGQAClient m17206getJiboClient() {
        return (JiboGQAClient) super.m17204getJiboClient();
    }

    public AttributionListResponse listAttributions(String str, long j) {
        return m17204getJiboClient().listAttributions(str, j);
    }

    public Future<AttributionListResponse> listAttributions(final String str, final long j, final AsyncHandler<ListAttributionRequest, AttributionListResponse> asyncHandler) {
        return m9909c().submit(new Callable<AttributionListResponse>() { // from class: com.jibo.aws.integration.aws.services.gqa.JiboGQAAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AttributionListResponse call() throws Exception {
                try {
                    AttributionListResponse attributionListResponseListAttributions = JiboGQAAsyncClient.this.listAttributions(str, j);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListAttributionRequest(str, j), attributionListResponseListAttributions);
                    }
                    return attributionListResponseListAttributions;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public GQAAttribution sendQuestion(String str) {
        return m17204getJiboClient().sendQuestion(str);
    }

    public Future<GQAAttribution> sendQuestion(final String str, final AsyncHandler<QuestionRequest, GQAAttribution> asyncHandler) {
        return m9909c().submit(new Callable<GQAAttribution>() { // from class: com.jibo.aws.integration.aws.services.gqa.JiboGQAAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public GQAAttribution call() throws Exception {
                try {
                    GQAAttribution gQAAttributionSendQuestion = JiboGQAAsyncClient.this.sendQuestion(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new QuestionRequest(str), gQAAttributionSendQuestion);
                    }
                    return gQAAttributionSendQuestion;
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
