package com.jibo.aws.integration.aws.services.accountAdmin;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.accountAdmin.model.ActivateByIdRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboAccountAdminAsyncClient extends AbstractJiboAsyncClient {
    public JiboAccountAdminAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboAccountAdminAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboAccountAdminAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboAccountAdminAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public Account activateById(String str) {
        return m17204getJiboClient().activateById(str);
    }

    public Future<Account> activateById(final String str, final AsyncHandler<ActivateByIdRequest, Account> asyncHandler) {
        return m9909c().submit(new Callable<Account>() { // from class: com.jibo.aws.integration.aws.services.accountAdmin.JiboAccountAdminAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Account call() throws Exception {
                try {
                    Account accountActivateById = JiboAccountAdminAsyncClient.this.activateById(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ActivateByIdRequest(str), accountActivateById);
                    }
                    return accountActivateById;
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
    public JiboAccountAdminClient m17204getJiboClient() {
        return (JiboAccountAdminClient) super.m17204getJiboClient();
    }
}
