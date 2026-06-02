package com.jibo.aws.integration.aws.services.push;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.AbstractJiboAsyncClient;
import com.jibo.aws.integration.aws.services.common.model.Device;
import com.jibo.aws.integration.aws.services.push.model.CreateDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.GetJotNotificationsModeRequest;
import com.jibo.aws.integration.aws.services.push.model.JotNotificationsModeResponse;
import com.jibo.aws.integration.aws.services.push.model.JotPushNotificationsMode;
import com.jibo.aws.integration.aws.services.push.model.RemoveDeviceRequest;
import com.jibo.aws.integration.aws.services.push.model.UpdateJotNotificationsModeRequest;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class JiboPushAsyncClient extends AbstractJiboAsyncClient {
    public JiboPushAsyncClient(AWSCredentials aWSCredentials) {
        super(aWSCredentials);
    }

    public JiboPushAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(aWSCredentials, clientConfiguration);
    }

    public JiboPushAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        super(aWSCredentialsProvider);
    }

    public JiboPushAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(aWSCredentialsProvider, clientConfiguration);
    }

    public List<Device> createDevice(Device device) {
        return m17205getJiboClient().createDevice(device);
    }

    public Future<List<Device>> createDevice(final Device device, final AsyncHandler<CreateDeviceRequest, List<Device>> asyncHandler) {
        return m9909c().submit(new Callable<List<Device>>() { // from class: com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Device> call() throws Exception {
                try {
                    List<Device> listCreateDevice = JiboPushAsyncClient.this.createDevice(device);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new CreateDeviceRequest(device), listCreateDevice);
                    }
                    return listCreateDevice;
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
    public JiboPushClient m17214getJiboClient() {
        return (JiboPushClient) super.m17205getJiboClient();
    }

    public JotNotificationsModeResponse getJotNotificationsMode() {
        return m17205getJiboClient().getJotNotificationsMode();
    }

    public Future<JotNotificationsModeResponse> getJotNotificationsMode(final AsyncHandler<GetJotNotificationsModeRequest, JotNotificationsModeResponse> asyncHandler) {
        return m9909c().submit(new Callable<JotNotificationsModeResponse>() { // from class: com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public JotNotificationsModeResponse call() throws Exception {
                try {
                    JotNotificationsModeResponse jotNotificationsMode = JiboPushAsyncClient.this.getJotNotificationsMode();
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new GetJotNotificationsModeRequest(), jotNotificationsMode);
                    }
                    return jotNotificationsMode;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public List<Device> removeDevice(String str) {
        return m17205getJiboClient().removeDevice(str);
    }

    public Future<List<Device>> removeDevice(final String str, final AsyncHandler<RemoveDeviceRequest, List<Device>> asyncHandler) {
        return m9909c().submit(new Callable<List<Device>>() { // from class: com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<Device> call() throws Exception {
                try {
                    List<Device> listRemoveDevice = JiboPushAsyncClient.this.removeDevice(str);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new RemoveDeviceRequest(str), listRemoveDevice);
                    }
                    return listRemoveDevice;
                } catch (Exception e) {
                    if (asyncHandler != null) {
                        asyncHandler.onError(e);
                    }
                    throw e;
                }
            }
        });
    }

    public JotNotificationsModeResponse updateJotNotificationsMode(JotPushNotificationsMode jotPushNotificationsMode) {
        return m17205getJiboClient().updateJotNotificationsMode(jotPushNotificationsMode);
    }

    public Future<JotNotificationsModeResponse> updateJotNotificationsMode(final JotPushNotificationsMode jotPushNotificationsMode, final AsyncHandler<UpdateJotNotificationsModeRequest, JotNotificationsModeResponse> asyncHandler) {
        return m9909c().submit(new Callable<JotNotificationsModeResponse>() { // from class: com.jibo.aws.integration.aws.services.push.JiboPushAsyncClient.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public JotNotificationsModeResponse call() throws Exception {
                try {
                    JotNotificationsModeResponse jotNotificationsModeResponseUpdateJotNotificationsMode = JiboPushAsyncClient.this.updateJotNotificationsMode(jotPushNotificationsMode);
                    if (asyncHandler != null) {
                        asyncHandler.onSuccess(new UpdateJotNotificationsModeRequest(jotPushNotificationsMode), jotNotificationsModeResponseUpdateJotNotificationsMode);
                    }
                    return jotNotificationsModeResponseUpdateJotNotificationsMode;
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
