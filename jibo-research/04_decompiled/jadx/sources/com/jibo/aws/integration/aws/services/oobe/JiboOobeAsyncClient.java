package com.jibo.aws.integration.aws.services.oobe;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.oobe.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.oobe.model.KeysContainer;
import com.jibo.aws.integration.aws.services.oobe.model.PrepareRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.SetupRobotRequest;
import com.jibo.aws.integration.aws.services.oobe.model.StatusContainer;
import com.jibo.aws.integration.aws.services.oobe.model.TokenContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboOobeAsyncClient extends AbstractJiboAsyncClient {
    public JiboOobeAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboOobeAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboOobeAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboOobeAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    @Override // com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient
    /* JADX INFO: renamed from: getJiboClient, reason: merged with bridge method [inline-methods] */
    public JiboOobeClient m17212getJiboClient() {
        return (JiboOobeClient) super.m17212getJiboClient();
    }

    public StatusContainer getStatus(String str) {
        return m17212getJiboClient().getStatus(str);
    }

    public Future<StatusContainer> getStatus(final String str, final AsyncHandler<GetStatusRequest, StatusContainer> asyncHandler) {
        return m9909c().submit(new Callable<StatusContainer>() { // from class: com.jibo.aws.integration.aws.services.oobe.JiboOobeAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public StatusContainer call() throws Exception {
                try {
                    StatusContainer status = JiboOobeAsyncClient.this.getStatus(str);
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

    public TokenContainer prepareRobot(String str) {
        return m17212getJiboClient().prepareRobot(str);
    }

    public Future<TokenContainer> prepareRobot(final String str, final AsyncHandler<PrepareRobotRequest, TokenContainer> asyncHandler) {
        return m9909c().submit(new Callable<TokenContainer>() { // from class: com.jibo.aws.integration.aws.services.oobe.JiboOobeAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public TokenContainer call() throws Exception {
                try {
                    TokenContainer tokenContainerPrepareRobot = JiboOobeAsyncClient.this.prepareRobot(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new PrepareRobotRequest(str), tokenContainerPrepareRobot);
                    }
                    return tokenContainerPrepareRobot;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public KeysContainer setupRobot(String str, String str2) {
        return m17212getJiboClient().setupRobot(str, str2);
    }

    public Future<KeysContainer> setupRobot(final String str, final String str2, final AsyncHandler<SetupRobotRequest, KeysContainer> asyncHandler) {
        return m9909c().submit(new Callable<KeysContainer>() { // from class: com.jibo.aws.integration.aws.services.oobe.JiboOobeAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public KeysContainer call() throws Exception {
                try {
                    KeysContainer keysContainer = JiboOobeAsyncClient.this.setupRobot(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new SetupRobotRequest(str, str2), keysContainer);
                    }
                    return keysContainer;
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
