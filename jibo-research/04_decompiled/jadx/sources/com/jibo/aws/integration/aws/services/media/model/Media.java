package com.jibo.aws.integration.aws.services.media.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Media implements Parcelable, Serializable {
    public static final Parcelable.Creator<Media> CREATOR = new Parcelable.Creator<Media>() { // from class: com.jibo.aws.integration.aws.services.media.model.Media.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Media createFromParcel(Parcel parcel) {
            return new Media(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Media[] newArray(int i) {
            return new Media[i];
        }
    };
    public static final String TYPE_AUDIO = "audio";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_RECORDING = "recording";
    public static final String TYPE_THUMBNAIL = "thumb";
    public static final String TYPE_THUMBNAIL_ROBOT = "thumb_robot";

    @Expose
    private String accountId;

    @Expose
    private Long created;

    @Expose
    private Boolean isEncrypted;

    @Expose
    private String loopId;

    @Expose
    private String path;

    @Expose
    private String reference;

    @Expose
    private String type;

    @Expose
    private String url;

    public Media() {
    }

    protected Media(Parcel parcel) {
        this.path = parcel.readString();
        this.accountId = parcel.readString();
        this.loopId = parcel.readString();
        this.url = parcel.readString();
        this.created = Long.valueOf(parcel.readLong());
        this.type = parcel.readString();
        this.reference = parcel.readString();
        this.isEncrypted = Boolean.valueOf(parcel.readByte() != 0);
    }

    public Media(String str, String str2, String str3, String str4, String str5, String str6, Long l, boolean z) {
        this.path = str;
        this.accountId = str2;
        this.loopId = str3;
        this.url = str4;
        this.type = str5;
        this.reference = str6;
        this.created = l;
        this.isEncrypted = Boolean.valueOf(z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Media)) {
            return false;
        }
        Media media = (Media) obj;
        if ((media.getPath() == null) ^ (getPath() == null)) {
            return false;
        }
        if (media.getPath() != null && !media.getPath().equals(getPath())) {
            return false;
        }
        if ((media.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        if (media.getAccountId() != null && !media.getAccountId().equals(getAccountId())) {
            return false;
        }
        if ((media.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (media.getLoopId() != null && !media.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((media.getCreated() == null) ^ (getCreated() == null)) {
            return false;
        }
        if (media.getCreated() != null && !media.getCreated().equals(getCreated())) {
            return false;
        }
        if ((media.getType() == null) ^ (getType() == null)) {
            return false;
        }
        if (media.getType() != null && !media.getType().equals(getType())) {
            return false;
        }
        if ((media.getReference() == null) ^ (getReference() == null)) {
            return false;
        }
        if (media.getReference() != null && !media.getReference().equals(getReference())) {
            return false;
        }
        if ((media.isEncrypted() == null) ^ (isEncrypted() == null)) {
            return false;
        }
        if (media.isEncrypted() != null && !media.isEncrypted().equals(isEncrypted())) {
            return false;
        }
        if ((media.getUrl() == null) ^ (getUrl() == null)) {
            return false;
        }
        return media.getUrl() == null || media.getUrl().equals(getUrl());
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Long getCreated() {
        return this.created;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getPath() {
        return this.path;
    }

    public String getReference() {
        return this.reference;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((getReference() == null ? 0 : getReference().hashCode()) + (((getType() == null ? 0 : getType().hashCode()) + (((getCreated() == null ? 0 : getCreated().hashCode()) + (((getUrl() == null ? 0 : getUrl().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getAccountId() == null ? 0 : getAccountId().hashCode()) + (((getPath() == null ? 0 : getPath().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + (isEncrypted() != null ? isEncrypted().hashCode() : 0);
    }

    public Boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setCreated(Long l) {
        this.created = l;
    }

    public void setEncrypted(Boolean bool) {
        this.isEncrypted = bool;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "Media {path='" + this.path + "'url='" + this.url + "'accountId='" + this.accountId + "'loopId='" + this.loopId + "'created='" + this.created + "'type='" + this.type + "'reference='" + this.reference + "'isEncrypted='" + this.isEncrypted + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.path);
        parcel.writeString(this.accountId);
        parcel.writeString(this.loopId);
        parcel.writeString(this.url);
        parcel.writeLong(this.created.longValue());
        parcel.writeString(this.type);
        parcel.writeString(this.reference);
        parcel.writeByte((byte) ((this.isEncrypted == null || !this.isEncrypted.booleanValue()) ? 0 : 1));
    }
}
