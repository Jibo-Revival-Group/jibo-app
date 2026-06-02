package com.jibo.aws.integration.aws.services.loop.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class RobotAccount implements Parcelable, Serializable {
    public static final Parcelable.Creator<RobotAccount> CREATOR = new Parcelable.Creator<RobotAccount>() { // from class: com.jibo.aws.integration.aws.services.loop.model.RobotAccount.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RobotAccount createFromParcel(Parcel parcel) {
            return new RobotAccount(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RobotAccount[] newArray(int i) {
            return new RobotAccount[i];
        }
    };
    private String accessKeyId;
    private String friendlyId;
    private String secretAccessKey;

    public RobotAccount() {
    }

    protected RobotAccount(Parcel parcel) {
        this.accessKeyId = parcel.readString();
        this.secretAccessKey = parcel.readString();
        this.friendlyId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RobotAccount)) {
            return false;
        }
        RobotAccount robotAccount = (RobotAccount) obj;
        if (getAccessKeyId().equals(robotAccount.getAccessKeyId()) && getSecretAccessKey().equals(robotAccount.getSecretAccessKey())) {
            return getFriendlyId().equals(robotAccount.getFriendlyId());
        }
        return false;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getFriendlyId() {
        return this.friendlyId;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public int hashCode() {
        return (((getAccessKeyId().hashCode() * 31) + getSecretAccessKey().hashCode()) * 31) + getFriendlyId().hashCode();
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setFriendlyId(String str) {
        this.friendlyId = str;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public String toString() {
        return "RobotAccount{accessKeyId='" + this.accessKeyId + "', secretAccessKey='" + this.secretAccessKey + "', friendlyId='" + this.friendlyId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.accessKeyId);
        parcel.writeString(this.secretAccessKey);
        parcel.writeString(this.friendlyId);
    }
}
