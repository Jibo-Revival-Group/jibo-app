package com.jibo.aws.integration.aws.services.media;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.media.model.CreateRequest;
import com.jibo.aws.integration.aws.services.media.model.GetRequest;
import com.jibo.aws.integration.aws.services.media.model.ListRequest;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.aws.services.media.model.RemoveRequest;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboMediaAsyncClient extends AbstractJiboAsyncClient {
    public JiboMediaAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboMediaAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboMediaAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboMediaAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public Media create(String str, String str2, String str3, String str4, File file, Boolean bool) {
        return m17204getJiboClient().create(str, str2, str3, str4, file, bool);
    }

    public Future<Media> create(final String str, final String str2, final String str3, final String str4, final File file, final Boolean bool, final AsyncHandler<CreateRequest, Media> asyncHandler) {
        return m9909c().submit(new Callable<Media>() { // from class: com.jibo.aws.integration.aws.services.media.JiboMediaAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Media call() throws Exception {
                try {
                    Media mediaCreate = JiboMediaAsyncClient.this.create(str, str2, str3, str4, file, bool);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateRequest(str, str2, str3, str4, file, bool), mediaCreate);
                    }
                    return mediaCreate;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Media> get(List<String> list) {
        return m17204getJiboClient().get(list);
    }

    public Future<List<Media>> get(final List<String> list, final AsyncHandler<GetRequest, List<Media>> asyncHandler) {
        return m9909c().submit(new Callable<List<Media>>() { // from class: com.jibo.aws.integration.aws.services.media.JiboMediaAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Media> call() throws Exception {
                try {
                    List<Media> list2 = JiboMediaAsyncClient.this.get(list);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetRequest(list), list2);
                    }
                    return list2;
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
    public JiboMediaClient m17210getJiboClient() {
        return (JiboMediaClient) super.m17204getJiboClient();
    }

    public List<Media> list(List<String> list, Long l, Long l2) {
        return m17204getJiboClient().list(list, l, l2);
    }

    public Future<List<Media>> list(final List<String> list, final Long l, final Long l2, final AsyncHandler<ListRequest, List<Media>> asyncHandler) {
        return m9909c().submit(new Callable<List<Media>>() { // from class: com.jibo.aws.integration.aws.services.media.JiboMediaAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Media> call() throws Exception {
                try {
                    List<Media> list2 = JiboMediaAsyncClient.this.list(list, l, l2);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new ListRequest(list, l, l2), list2);
                    }
                    return list2;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Media> remove(List<String> list) {
        return m17204getJiboClient().remove(list);
    }

    public Future<List<Media>> remove(final List<String> list, final AsyncHandler<RemoveRequest, List<Media>> asyncHandler) {
        return m9909c().submit(new Callable<List<Media>>() { // from class: com.jibo.aws.integration.aws.services.media.JiboMediaAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Media> call() throws Exception {
                try {
                    List<Media> listRemove = JiboMediaAsyncClient.this.remove(list);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveRequest(list), listRemove);
                    }
                    return listRemove;
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
