package com.jibo.aws.integration.aws.services.jot.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MessagePartResponse implements Parcelable, Serializable {
    public static final Parcelable.Creator<MessagePartResponse> CREATOR = new Parcelable.Creator<MessagePartResponse>() { // from class: com.jibo.aws.integration.aws.services.jot.model.MessagePartResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePartResponse createFromParcel(Parcel parcel) {
            return new MessagePartResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePartResponse[] newArray(int i) {
            return new MessagePartResponse[i];
        }
    };

    @Expose
    private String path;

    @Expose
    private String url;

    public MessagePartResponse() {
    }

    protected MessagePartResponse(Parcel parcel) {
        this.path = parcel.readString();
        this.url = parcel.readString();
    }

    public MessagePartResponse(String str, String str2) {
        this.path = str;
        this.url = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MessagePartResponse)) {
            return false;
        }
        MessagePartResponse messagePartResponse = (MessagePartResponse) obj;
        if ((messagePartResponse.getPath() == null) ^ (getPath() == null)) {
            return false;
        }
        if (messagePartResponse.getPath() != null && !messagePartResponse.getPath().equals(getPath())) {
            return false;
        }
        if ((messagePartResponse.getUrl() == null) ^ (getUrl() == null)) {
            return false;
        }
        return messagePartResponse.getUrl() == null || messagePartResponse.getUrl().equals(getUrl());
    }

    public String getPath() {
        return this.path;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((getPath() == null ? 0 : getPath().hashCode()) + 31) * 31) + (getUrl() != null ? getUrl().hashCode() : 0);
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "Message {path='" + this.path + "'url='" + this.url + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.url);
    }
}
