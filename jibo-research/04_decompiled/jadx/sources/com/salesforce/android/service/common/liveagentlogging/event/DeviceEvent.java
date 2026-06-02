package com.salesforce.android.service.common.liveagentlogging.event;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "deviceEvents")
public class DeviceEvent extends BaseEvent {

    @SerializedName(m9428a = "application")
    private final String mApplication;

    @SerializedName(m9428a = "applicationVersion")
    private final String mApplicationVersion;

    @SerializedName(m9428a = "device")
    private final String mDevice;

    @SerializedName(m9428a = "os")
    private final String mOsVersion;

    @SerializedName(m9428a = ServerProtocol.DIALOG_PARAM_SDK_VERSION)
    private final String mSdkVersion;

    public DeviceEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        super(str, str2);
        this.mDevice = str4;
        this.mSdkVersion = str3;
        this.mApplication = str5;
        this.mApplicationVersion = str6;
        this.mOsVersion = str7;
    }
}
