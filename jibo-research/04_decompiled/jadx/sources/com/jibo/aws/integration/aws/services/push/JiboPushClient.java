package com.jibo.aws.integration.aws.services.push;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.Device;
import com.jibo.aws.integration.aws.services.common.model.p005a.C0855e;
import com.jibo.aws.integration.aws.services.push.model.CreateDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.GetJotNotificationsModeRequest;
import com.jibo.aws.integration.aws.services.push.model.JotNotificationsModeResponse;
import com.jibo.aws.integration.aws.services.push.model.JotPushNotificationsMode;
import com.jibo.aws.integration.aws.services.push.model.RemoveDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.UpdateJotNotificationsModeRequest;
import com.jibo.aws.integration.aws.services.push.model.p016a.C0961a;
import com.jibo.aws.integration.aws.services.push.model.p016a.C0962b;
import com.jibo.aws.integration.util.C0977a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JiboPushClient extends AbstractJiboClient {
    public static final String TAG = C0977a.m10070a(JiboPushClient.class);

    public JiboPushClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboPushClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboPushClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboPushClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public JiboPushClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(aWSCredentialsProvider, clientConfiguration, httpClient);
    }

    public List<Device> createDevice(Device device) {
        return (List) m9913a(new CreateDeviceRequest(device), (C0855e) null, new C0961a()).getAwsResponse();
    }

    public JotNotificationsModeResponse getJotNotificationsMode() {
        return (JotNotificationsModeResponse) m9913a(new GetJotNotificationsModeRequest(), (C0855e) null, new C0962b()).getAwsResponse();
    }

    public List<Device> removeDevice(String str) {
        return (List) m9913a(new RemoveDeviceRequest(str), (C0855e) null, new C0961a()).getAwsResponse();
    }

    public JotNotificationsModeResponse updateJotNotificationsMode(JotPushNotificationsMode jotPushNotificationsMode) {
        return (JotNotificationsModeResponse) m9913a(new UpdateJotNotificationsModeRequest(jotPushNotificationsMode), (C0855e) null, new C0962b()).getAwsResponse();
    }
}
