package com.jibo.aws.integration.aws.services.file;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.file.model.FileLink;
import com.jibo.aws.integration.aws.services.file.model.GetFileRequest;
import com.jibo.aws.integration.aws.services.file.model.ListFilesRequest;
import com.jibo.aws.integration.aws.services.file.model.RemoveFileRequest;
import com.jibo.aws.integration.aws.services.file.model.UploadFileRequest;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboFileAsyncClient extends JiboFileClient {

    /* JADX INFO: renamed from: d */
    private ExecutorService f9417d;

    @Deprecated
    public JiboFileAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public JiboFileAsyncClient(ClientConfiguration clientConfiguration) {
        this(new BasicAWSCredentials("", ""), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public JiboFileAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newFixedThreadPool(10));
    }

    public JiboFileAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.f9417d = executorService;
    }

    public JiboFileAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.f9417d = executorService;
    }

    public JiboFileAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newFixedThreadPool(10));
    }

    public JiboFileAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
    }

    public JiboFileAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.f9417d = executorService;
    }

    public JiboFileAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public ExecutorService getExecutorService() {
        return this.f9417d;
    }

    public Future<FileLink> getFile(final String str, final AsyncHandler<GetFileRequest, FileLink> asyncHandler) {
        return this.f9417d.submit(new Callable<FileLink>() { // from class: com.jibo.aws.integration.aws.services.file.JiboFileAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FileLink call() throws Exception {
                try {
                    FileLink file = JiboFileAsyncClient.this.getFile(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetFileRequest(str), file);
                    }
                    return file;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Future<List<FileLink>> listFiles(final AsyncHandler<ListFilesRequest, List<FileLink>> asyncHandler) {
        return this.f9417d.submit(new Callable<List<FileLink>>() { // from class: com.jibo.aws.integration.aws.services.file.JiboFileAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<FileLink> call() throws Exception {
                try {
                    List<FileLink> listListFiles = JiboFileAsyncClient.this.listFiles();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListFilesRequest(), listListFiles);
                    }
                    return listListFiles;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public Future<FileLink> removeFile(final String str, final AsyncHandler<RemoveFileRequest, FileLink> asyncHandler) {
        return this.f9417d.submit(new Callable<FileLink>() { // from class: com.jibo.aws.integration.aws.services.file.JiboFileAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FileLink call() throws Exception {
                try {
                    FileLink fileLinkRemoveFile = JiboFileAsyncClient.this.removeFile(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveFileRequest(str), fileLinkRemoveFile);
                    }
                    return fileLinkRemoveFile;
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
        this.f9417d.shutdownNow();
    }

    public Future<FileLink> uploadFile(final String str, final File file, final AsyncHandler<UploadFileRequest, FileLink> asyncHandler) {
        return this.f9417d.submit(new Callable<FileLink>() { // from class: com.jibo.aws.integration.aws.services.file.JiboFileAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FileLink call() throws Exception {
                try {
                    FileLink fileLinkUploadFile = JiboFileAsyncClient.this.uploadFile(str, file);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UploadFileRequest(str, file), fileLinkUploadFile);
                    }
                    return fileLinkUploadFile;
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
