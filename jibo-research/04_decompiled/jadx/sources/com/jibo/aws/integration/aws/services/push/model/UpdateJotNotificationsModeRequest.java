package com.jibo.aws.integration.aws.services.push.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class UpdateJotNotificationsModeRequest extends JiboPushRequest {

    @Expose
    protected JotPushNotificationsMode jotPushMode;

    public UpdateJotNotificationsModeRequest(JotPushNotificationsMode jotPushNotificationsMode) {
        this.jotPushMode = jotPushNotificationsMode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !super.equals(obj) || !(obj instanceof UpdateJotNotificationsModeRequest)) {
            return false;
        }
        UpdateJotNotificationsModeRequest updateJotNotificationsModeRequest = (UpdateJotNotificationsModeRequest) obj;
        if ((updateJotNotificationsModeRequest.getJotPushMode() == null) ^ (getJotPushMode() == null)) {
            return false;
        }
        return updateJotNotificationsModeRequest.getJotPushMode() == null || updateJotNotificationsModeRequest.getJotPushMode().equals(getJotPushMode());
    }

    public JotPushNotificationsMode getJotPushMode() {
        return this.jotPushMode;
    }

    public int hashCode() {
        return (getJotPushMode() == null ? 0 : getJotPushMode().hashCode()) + (super.hashCode() * 31);
    }

    public void setJotPushMode(JotPushNotificationsMode jotPushNotificationsMode) {
        this.jotPushMode = this.jotPushMode;
    }

    public String toString() {
        return "UpdateJotNotificationsModeRequest {, jotPushMode='" + this.jotPushMode + "'}";
    }
}
