package com.jibo.aws.integration.aws.services.binary.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BinaryLink extends AmazonWebServiceRequest implements Parcelable, Serializable {
    public static final Parcelable.Creator<BinaryLink> CREATOR = new Parcelable.Creator<BinaryLink>() { // from class: com.jibo.aws.integration.aws.services.binary.model.BinaryLink.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BinaryLink createFromParcel(Parcel parcel) {
            return new BinaryLink(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BinaryLink[] newArray(int i) {
            return new BinaryLink[i];
        }
    };

    @Expose
    protected String accountId;

    @SerializedName(m9428a = "created")
    @Expose
    protected Long createdMilliseconds;
    protected transient File file;

    @Expose
    protected Map<String, String> meta;

    @Expose
    protected String path;

    @Expose
    protected String url;

    protected BinaryLink(Parcel parcel) {
        this.createdMilliseconds = Long.valueOf(parcel.readLong());
        this.accountId = parcel.readString();
        this.path = parcel.readString();
        this.url = parcel.readString();
        this.meta = new HashMap();
        parcel.readMap(this.meta, this.meta.getClass().getClassLoader());
        String string = parcel.readString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.file = new File(string);
    }

    public BinaryLink(String str, String str2, String str3, Long l, Map<String, String> map) {
        this.path = str;
        this.url = str2;
        this.createdMilliseconds = l;
        this.accountId = str3;
        this.meta = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BinaryLink)) {
            return false;
        }
        BinaryLink binaryLink = (BinaryLink) obj;
        if ((binaryLink.getUrl() == null) ^ (getUrl() == null)) {
            return false;
        }
        if (binaryLink.getUrl() != null && !binaryLink.getUrl().equals(getUrl())) {
            return false;
        }
        if ((binaryLink.getPath() == null) ^ (getPath() == null)) {
            return false;
        }
        if (binaryLink.getPath() != null && !binaryLink.getPath().equals(getPath())) {
            return false;
        }
        if ((binaryLink.getCreatedMilliseconds() == null) ^ (getCreatedMilliseconds() == null)) {
            return false;
        }
        if (binaryLink.getCreatedMilliseconds() != null && !binaryLink.getCreatedMilliseconds().equals(getCreatedMilliseconds())) {
            return false;
        }
        if ((binaryLink.getMeta() == null) ^ (getMeta() == null)) {
            return false;
        }
        if (binaryLink.getMeta() != null && !binaryLink.getMeta().equals(getMeta())) {
            return false;
        }
        if ((binaryLink.getFile() == null) ^ (getFile() == null)) {
            return false;
        }
        if (binaryLink.getFile() != null && !binaryLink.getFile().equals(getFile())) {
            return false;
        }
        if ((binaryLink.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        return binaryLink.getAccountId() == null || binaryLink.getAccountId().equals(getAccountId());
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Long getCreatedMilliseconds() {
        return this.createdMilliseconds;
    }

    public File getFile() {
        return this.file;
    }

    public Map<String, String> getMeta() {
        return this.meta;
    }

    public String getPath() {
        return this.path;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((getMeta() == null ? 0 : getMeta().hashCode()) + (((getAccountId() == null ? 0 : getAccountId().hashCode()) + (((getCreatedMilliseconds() == null ? 0 : getCreatedMilliseconds().hashCode()) + (((getPath() == null ? 0 : getPath().hashCode()) + (((getUrl() == null ? 0 : getUrl().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31) + (getFile() != null ? getFile().hashCode() : 0);
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setCreatedMilliseconds(Long l) {
        this.createdMilliseconds = l;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setMeta(Map<String, String> map) {
        this.meta = map;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "BinaryLink {url='" + this.url + "', path='" + this.path + "', createdMilliseconds='" + this.createdMilliseconds + "', accountId='" + this.accountId + "', meta='" + this.meta + "', file='" + this.file + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.createdMilliseconds == null ? 0L : this.createdMilliseconds.longValue());
        parcel.writeString(this.accountId);
        parcel.writeString(this.path);
        parcel.writeString(this.url);
        parcel.writeMap(this.meta);
        parcel.writeString(this.file == null ? null : this.file.getAbsolutePath());
    }
}
