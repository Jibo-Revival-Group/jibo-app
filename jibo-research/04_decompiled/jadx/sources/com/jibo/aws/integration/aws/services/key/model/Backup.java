package com.jibo.aws.integration.aws.services.key.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class Backup implements Parcelable {
    public static final Parcelable.Creator<Backup> CREATOR = new Parcelable.Creator<Backup>() { // from class: com.jibo.aws.integration.aws.services.key.model.Backup.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Backup createFromParcel(Parcel parcel) {
            return new Backup(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Backup[] newArray(int i) {
            return new Backup[i];
        }
    };

    @Expose
    private String accountId;

    @Expose
    private String encryptedKey;

    @Expose
    private String loopId;

    public Backup() {
    }

    protected Backup(Parcel parcel) {
        this.loopId = parcel.readString();
        this.accountId = parcel.readString();
        this.encryptedKey = parcel.readString();
    }

    public Backup(String str, String str2, String str3) {
        this.loopId = str;
        this.accountId = str3;
        this.encryptedKey = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Backup)) {
            return false;
        }
        Backup backup = (Backup) obj;
        if (!getLoopId().equals(backup.getLoopId())) {
            return false;
        }
        if (getAccountId() != null) {
            if (!getAccountId().equals(backup.getAccountId())) {
                return false;
            }
        } else if (backup.getAccountId() != null) {
            return false;
        }
        return getEncryptedKey().equals(backup.getEncryptedKey());
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getEncryptedKey() {
        return this.encryptedKey;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public int hashCode() {
        return (((getAccountId() != null ? getAccountId().hashCode() : 0) + (getLoopId().hashCode() * 31)) * 31) + getEncryptedKey().hashCode();
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setEncryptedKey(String str) {
        this.encryptedKey = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public String toString() {
        return "Backup{loopId='" + this.loopId + "', accountId='" + this.accountId + "', encryptedKey='" + this.encryptedKey + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.loopId);
        parcel.writeString(this.accountId);
        parcel.writeString(this.encryptedKey);
    }
}
