package com.jibo.aws.integration.aws.services.push.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class JotNotificationsModeResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<JotNotificationsModeResponse> CREATOR = new Parcelable.Creator<JotNotificationsModeResponse>() { // from class: com.jibo.aws.integration.aws.services.push.model.JotNotificationsModeResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JotNotificationsModeResponse createFromParcel(Parcel parcel) {
            return new JotNotificationsModeResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public JotNotificationsModeResponse[] newArray(int i) {
            return new JotNotificationsModeResponse[i];
        }
    };

    @Expose
    private String accountId;

    @Expose
    private JotPushNotificationsMode jotPushMode;

    public JotNotificationsModeResponse() {
    }

    protected JotNotificationsModeResponse(Parcel parcel) {
        this.jotPushMode = JotPushNotificationsMode.valueOf(parcel.readString());
        this.accountId = parcel.readString();
    }

    public JotNotificationsModeResponse(String str, JotPushNotificationsMode jotPushNotificationsMode) {
        this.accountId = str;
        this.jotPushMode = jotPushNotificationsMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof JotNotificationsModeResponse)) {
            return false;
        }
        JotNotificationsModeResponse jotNotificationsModeResponse = (JotNotificationsModeResponse) obj;
        if ((jotNotificationsModeResponse.getJotPushMode() == null) ^ (getJotPushMode() == null)) {
            return false;
        }
        if (jotNotificationsModeResponse.getJotPushMode() != null && !jotNotificationsModeResponse.getJotPushMode().equals(getJotPushMode())) {
            return false;
        }
        if ((jotNotificationsModeResponse.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        return jotNotificationsModeResponse.getAccountId() == null || jotNotificationsModeResponse.getAccountId().equals(getAccountId());
    }

    public String getAccountId() {
        return this.accountId;
    }

    public JotPushNotificationsMode getJotPushMode() {
        return this.jotPushMode;
    }

    public int hashCode() {
        return (((getJotPushMode() == null ? 0 : getJotPushMode().hashCode()) + 31) * 31) + (getAccountId() != null ? getAccountId().hashCode() : 0);
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setJotPushMode(JotPushNotificationsMode jotPushNotificationsMode) {
        this.jotPushMode = jotPushNotificationsMode;
    }

    public String toString() {
        return "JotNotificationsModeResponse {jotPushMode='" + this.jotPushMode + "'accountId='" + this.accountId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jotPushMode.getName());
        parcel.writeString(this.accountId);
    }
}
