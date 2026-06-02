package com.jibo.aws.integration.aws.services.push.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.Device;

/* JADX INFO: loaded from: classes.dex */
public class CreateDeviceRequest extends JiboPushRequest {

    @Expose
    private String name;

    @Expose
    private String pushToken;

    @Expose
    private Device.Type type;

    public CreateDeviceRequest(Device device) {
        this.name = device.getName();
        this.pushToken = device.getPushToken();
        this.type = device.getType();
    }

    public String getName() {
        return this.name;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public Device.Type getType() {
        return this.type;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPushToken(String str) {
        this.pushToken = str;
    }

    public void setType(Device.Type type) {
        this.type = type;
    }
}
