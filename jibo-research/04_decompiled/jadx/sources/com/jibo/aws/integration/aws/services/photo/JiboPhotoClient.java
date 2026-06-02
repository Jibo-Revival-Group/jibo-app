package com.jibo.aws.integration.aws.services.photo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.amazonaws.metrics.RequestMetricCollector;
import com.facebook.internal.AnalyticsEvents;
import com.jibo.aws.integration.aws.services.file.JiboFileClient;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class JiboPhotoClient extends JiboFileClient {
    public JiboPhotoClient() {
        m10038a();
    }

    public JiboPhotoClient(ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        m10038a();
    }

    public JiboPhotoClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
        m10038a();
    }

    public JiboPhotoClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
        m10038a();
    }

    public JiboPhotoClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
        m10038a();
    }

    public JiboPhotoClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
        m10038a();
    }

    public JiboPhotoClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
        m10038a();
    }

    public JiboPhotoClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(aWSCredentialsProvider, clientConfiguration, requestMetricCollector);
        m10038a();
    }

    /* JADX INFO: renamed from: a */
    private void m10038a() {
        setServiceNameIntern(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
        setServiceType(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, Commons.TARGET_PREFIX_PHOTO);
    }
}
