package com.jibo.aws.integration.aws.services.photo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.facebook.internal.AnalyticsEvents;
import com.jibo.aws.integration.aws.services.file.JiboFileAsyncClient;
import com.jibo.aws.integration.util.Commons;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class JiboPhotoAsyncClient extends JiboFileAsyncClient {
    public JiboPhotoAsyncClient(ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        m10037a();
    }

    public JiboPhotoAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
        m10037a();
    }

    public JiboPhotoAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration, executorService);
        m10037a();
    }

    public JiboPhotoAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials, executorService);
        m10037a();
    }

    public JiboPhotoAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
        m10037a();
    }

    public JiboPhotoAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
        m10037a();
    }

    public JiboPhotoAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration, executorService);
        m10037a();
    }

    public JiboPhotoAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        super(aWSCredentialsProvider, executorService);
        m10037a();
    }

    /* JADX INFO: renamed from: a */
    protected void m10037a() {
        setServiceNameIntern(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
        setServiceType(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, Commons.TARGET_PREFIX_PHOTO);
    }
}
