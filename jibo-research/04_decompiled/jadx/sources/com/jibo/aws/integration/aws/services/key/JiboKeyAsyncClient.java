package com.jibo.aws.integration.aws.services.key;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.BackupRequest;
import com.jibo.aws.integration.aws.services.key.model.CreateRequest;
import com.jibo.aws.integration.aws.services.key.model.GetRequest;
import com.jibo.aws.integration.aws.services.key.model.ListIncomingRequest;
import com.jibo.aws.integration.aws.services.key.model.Request;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.key.model.ShareRequest;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboKeyAsyncClient extends AbstractJiboAsyncClient {
    public JiboKeyAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboKeyAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboKeyAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboKeyAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public CommandResponse backupEncryptedKey(String str, String str2, String str3) {
        return m17207getJiboClient().backupEncryptedKey(str, str2, str3);
    }

    public Future<CommandResponse> backupEncryptedKey(final String str, final String str2, final String str3, final AsyncHandler<BackupRequest, CommandResponse> asyncHandler) {
        return m9909c().submit(new Callable<CommandResponse>() { // from class: com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CommandResponse call() throws Exception {
                try {
                    CommandResponse commandResponseBackupEncryptedKey = JiboKeyAsyncClient.this.backupEncryptedKey(str, str2, str3);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new BackupRequest(str, str2, str3), commandResponseBackupEncryptedKey);
                    }
                    return commandResponseBackupEncryptedKey;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Request createRequest(String str, String str2) {
        return m17207getJiboClient().createRequest(str, str2);
    }

    public Future<Request> createRequest(final String str, final String str2, final AsyncHandler<CreateRequest, Request> asyncHandler) {
        return m9909c().submit(new Callable<Request>() { // from class: com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Request call() throws Exception {
                try {
                    Request requestCreateRequest = JiboKeyAsyncClient.this.createRequest(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateRequest(str, str2), requestCreateRequest);
                    }
                    return requestCreateRequest;
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
    public JiboKeyClient m17208getJiboClient() {
        return (JiboKeyClient) super.m17207getJiboClient();
    }

    public Request getRequest(String str) {
        return m17207getJiboClient().getRequest(str);
    }

    public Future<Request> getRequest(final String str, final AsyncHandler<GetRequest, Request> asyncHandler) {
        return m9909c().submit(new Callable<Request>() { // from class: com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Request call() throws Exception {
                try {
                    Request request = JiboKeyAsyncClient.this.getRequest(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetRequest(str), request);
                    }
                    return request;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Request> listIncomingRequests(String str) {
        return m17207getJiboClient().listIncomingRequests(str);
    }

    public Future<List<Request>> listIncomingRequests(final String str, final AsyncHandler<ListIncomingRequest, List<Request>> asyncHandler) {
        return m9909c().submit(new Callable<List<Request>>() { // from class: com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Request> call() throws Exception {
                try {
                    List<Request> listListIncomingRequests = JiboKeyAsyncClient.this.listIncomingRequests(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListIncomingRequest(str), listListIncomingRequests);
                    }
                    return listListIncomingRequests;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Backup restoreEncryptedKey(String str, String str2) {
        return m17207getJiboClient().restoreEncryptedKey(str, str2);
    }

    public Future<Backup> restoreEncryptedKey(final String str, final String str2, final AsyncHandler<RestoreRequest, Backup> asyncHandler) {
        return m9909c().submit(new Callable<Backup>() { // from class: com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Backup call() throws Exception {
                try {
                    Backup backupRestoreEncryptedKey = JiboKeyAsyncClient.this.restoreEncryptedKey(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RestoreRequest(str, str2), backupRestoreEncryptedKey);
                    }
                    return backupRestoreEncryptedKey;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Request share(String str, String str2) {
        return m17207getJiboClient().share(str, str2);
    }

    public Future<Request> share(final String str, final String str2, final AsyncHandler<ShareRequest, Request> asyncHandler) {
        return m9909c().submit(new Callable<Request>() { // from class: com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Request call() throws Exception {
                try {
                    Request requestShare = JiboKeyAsyncClient.this.share(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ShareRequest(str, str2), requestShare);
                    }
                    return requestShare;
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
