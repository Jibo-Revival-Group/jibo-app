package com.jibo.aws.integration.aws.services.binary;

import android.content.Context;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.binary.model.BinaryLink;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.GetBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.ListBinaryRequest;
import com.jibo.aws.integration.aws.services.binary.model.RemoveBinaryRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboBinaryAsyncClient extends JiboBinaryClient {

    /* JADX INFO: renamed from: d */
    private ExecutorService f9379d;

    @Deprecated
    public JiboBinaryAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public JiboBinaryAsyncClient(ClientConfiguration clientConfiguration) {
        this(new BasicAWSCredentials("", ""), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public JiboBinaryAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newFixedThreadPool(10));
    }

    public JiboBinaryAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.f9379d = executorService;
    }

    public JiboBinaryAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.f9379d = executorService;
    }

    public JiboBinaryAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newFixedThreadPool(10));
    }

    public JiboBinaryAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public JiboBinaryAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.f9379d = executorService;
    }

    public JiboBinaryAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<BinaryLink> create(final String str, final File file, final Map<String, String> map, final AsyncHandler<CreateBinaryRequest, BinaryLink> asyncHandler) {
        return this.f9379d.submit(new Callable<BinaryLink>() { // from class: com.jibo.aws.integration.aws.services.binary.JiboBinaryAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BinaryLink call() throws Exception {
                try {
                    BinaryLink binaryLinkCreate = JiboBinaryAsyncClient.this.create(str, file, map);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateBinaryRequest(str, file, map), binaryLinkCreate);
                    }
                    return binaryLinkCreate;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Future<BinaryLink> get(final Context context, final String str, final AsyncHandler<GetBinaryRequest, BinaryLink> asyncHandler) {
        return this.f9379d.submit(new Callable<BinaryLink>() { // from class: com.jibo.aws.integration.aws.services.binary.JiboBinaryAsyncClient.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BinaryLink call() throws Exception {
                try {
                    BinaryLink binaryLink = JiboBinaryAsyncClient.this.get(context, str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetBinaryRequest(str), binaryLink);
                    }
                    return binaryLink;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Future<BinaryLink> get(final String str, final AsyncHandler<GetBinaryRequest, BinaryLink> asyncHandler) {
        return this.f9379d.submit(new Callable<BinaryLink>() { // from class: com.jibo.aws.integration.aws.services.binary.JiboBinaryAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BinaryLink call() throws Exception {
                try {
                    BinaryLink binaryLink = JiboBinaryAsyncClient.this.get(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetBinaryRequest(str), binaryLink);
                    }
                    return binaryLink;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Future<BinaryLink> get(final String str, final String str2, final AsyncHandler<GetBinaryRequest, BinaryLink> asyncHandler) {
        return this.f9379d.submit(new Callable<BinaryLink>() { // from class: com.jibo.aws.integration.aws.services.binary.JiboBinaryAsyncClient.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BinaryLink call() throws Exception {
                try {
                    BinaryLink binaryLink = JiboBinaryAsyncClient.this.get(str, str2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetBinaryRequest(str), binaryLink);
                    }
                    return binaryLink;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public ExecutorService getExecutorService() {
        return this.f9379d;
    }

    public Future<List<BinaryLink>> list(final String str, final AsyncHandler<ListBinaryRequest, List<BinaryLink>> asyncHandler) {
        return this.f9379d.submit(new Callable<List<BinaryLink>>() { // from class: com.jibo.aws.integration.aws.services.binary.JiboBinaryAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<BinaryLink> call() throws Exception {
                try {
                    List<BinaryLink> list = JiboBinaryAsyncClient.this.list(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListBinaryRequest(str), list);
                    }
                    return list;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Future<BinaryLink> remove(final String str, final AsyncHandler<RemoveBinaryRequest, BinaryLink> asyncHandler) {
        return this.f9379d.submit(new Callable<BinaryLink>() { // from class: com.jibo.aws.integration.aws.services.binary.JiboBinaryAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BinaryLink call() throws Exception {
                try {
                    BinaryLink binaryLinkRemove = JiboBinaryAsyncClient.this.remove(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveBinaryRequest(str), binaryLinkRemove);
                    }
                    return binaryLinkRemove;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    @Override // com.amazonaws.AmazonWebServiceClient
    public void shutdown() {
        super.shutdown();
        this.f9379d.shutdownNow();
    }
}
