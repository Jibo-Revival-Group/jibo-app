package com.jibo.aws.integration.aws.services.notification;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.notification.model.GetStatusRequest;
import com.jibo.aws.integration.aws.services.notification.model.StatusContainer;
import com.jibo.aws.integration.aws.services.notification.model.p013a.C0938a;
import com.jibo.aws.integration.util.C0977a;

/* JADX INFO: loaded from: classes.dex */
public class JiboNotificationClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboNotificationClient.class);

    public JiboNotificationClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboNotificationClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboNotificationClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboNotificationClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboNotificationClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public StatusContainer getStatus(String str) {
        return (StatusContainer) m9913a(new GetStatusRequest(str), (C0855e) null, new C0938a()).getAwsResponse();
    }
}
