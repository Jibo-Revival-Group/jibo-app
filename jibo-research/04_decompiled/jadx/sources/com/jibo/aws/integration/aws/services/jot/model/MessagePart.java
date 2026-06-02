package com.jibo.aws.integration.aws.services.jot.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MessagePart implements Parcelable, Serializable {
    public static final Parcelable.Creator<MessagePart> CREATOR = new Parcelable.Creator<MessagePart>() { // from class: com.jibo.aws.integration.aws.services.jot.model.MessagePart.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePart createFromParcel(Parcel parcel) {
            return new MessagePart(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessagePart[] newArray(int i) {
            return new MessagePart[i];
        }
    };

    @Expose
    private JsonObject meta;

    @Expose
    private String path;

    @Expose
    private String type;

    @Expose
    private String url;

    public MessagePart() {
    }

    protected MessagePart(Parcel parcel) {
        this.path = parcel.readString();
        this.url = parcel.readString();
        try {
            this.meta = (JsonObject) new JsonParser().m9413a(parcel.readString());
        } catch (Exception e) {
            this.meta = new JsonObject();
        }
        this.type = parcel.readString();
    }

    public MessagePart(String str, String str2, JsonObject jsonObject, String str3) {
        this.path = str;
        this.url = str2;
        this.meta = jsonObject;
        this.type = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MessagePart)) {
            return false;
        }
        MessagePart messagePart = (MessagePart) obj;
        if ((messagePart.getPath() == null) ^ (getPath() == null)) {
            return false;
        }
        if (messagePart.getPath() != null && !messagePart.getPath().equals(getPath())) {
            return false;
        }
        if ((messagePart.getMeta() == null) ^ (getMeta() == null)) {
            return false;
        }
        if (messagePart.getMeta() != null && !messagePart.getMeta().equals(getMeta())) {
            return false;
        }
        if ((messagePart.getType() == null) ^ (getType() == null)) {
            return false;
        }
        if (messagePart.getType() != null && !messagePart.getType().equals(getType())) {
            return false;
        }
        if ((messagePart.getUrl() == null) ^ (getUrl() == null)) {
            return false;
        }
        return messagePart.getUrl() == null || messagePart.getUrl().equals(getUrl());
    }

    public JsonObject getMeta() {
        return this.meta;
    }

    public String getPath() {
        return this.path;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((getMeta() == null ? 0 : getMeta().hashCode()) + (((getUrl() == null ? 0 : getUrl().hashCode()) + (((getPath() == null ? 0 : getPath().hashCode()) + 31) * 31)) * 31)) * 31) + (getType() != null ? getType().hashCode() : 0);
    }

    public void setMeta(JsonObject jsonObject) {
        this.meta = jsonObject;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "MessagePart {path='" + this.path + "'url='" + this.url + "'meta='" + this.meta + "'type='" + this.type + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.url);
        parcel.writeString(this.meta != null ? this.meta.toString() : new JsonObject().toString());
        parcel.writeString(this.type);
    }
}
