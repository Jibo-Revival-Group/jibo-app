package com.jibo.aws.integration.aws.services.oobe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class KeysContainer implements Parcelable, Serializable {
    public static final Parcelable.Creator<KeysContainer> CREATOR = new Parcelable.Creator<KeysContainer>() { // from class: com.jibo.aws.integration.aws.services.oobe.model.KeysContainer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeysContainer createFromParcel(Parcel parcel) {
            return new KeysContainer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public KeysContainer[] newArray(int i) {
            return new KeysContainer[i];
        }
    };

    @Expose
    private String accessKeyId;

    @Expose
    private String secretAccessKey;

    private KeysContainer(Parcel parcel) {
        this.accessKeyId = parcel.readString();
        this.secretAccessKey = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeysContainer)) {
            return false;
        }
        KeysContainer keysContainer = (KeysContainer) obj;
        if ((keysContainer.getAccessKeyId() == null) ^ (getAccessKeyId() == null)) {
            return false;
        }
        return keysContainer.getAccessKeyId() == null || keysContainer.getAccessKeyId().equals(getAccessKeyId());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public int hashCode() {
        return (((getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode()) + 31) * 31) + (getSecretAccessKey() != null ? getSecretAccessKey().hashCode() : 0);
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public String toString() {
        return "KeysContainer {accessKeyId='" + this.accessKeyId + "', secretAccessKey='" + this.secretAccessKey + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.accessKeyId);
        parcel.writeString(this.secretAccessKey);
    }
}
