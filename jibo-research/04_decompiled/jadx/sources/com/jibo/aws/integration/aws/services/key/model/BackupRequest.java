package com.jibo.aws.integration.aws.services.key.model;

import android.os.Parcel;
import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class BackupRequest extends JiboKeyRequest {

    @Expose
    private String encryptedKey;

    @Expose
    private String loopId;

    @Expose
    private String passwordHash;

    public BackupRequest() {
    }

    protected BackupRequest(Parcel parcel) {
        this.loopId = parcel.readString();
        this.encryptedKey = parcel.readString();
        this.passwordHash = parcel.readString();
    }

    public BackupRequest(String str, String str2, String str3) {
        this.loopId = str;
        this.encryptedKey = str2;
        this.passwordHash = str3;
    }

    public boolean equals(Object obj) {
        boolean zEquals = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupRequest)) {
            return false;
        }
        BackupRequest backupRequest = (BackupRequest) obj;
        if (!getLoopId().equals(backupRequest.getLoopId()) || !getEncryptedKey().equals(backupRequest.getEncryptedKey())) {
            return false;
        }
        if (getPasswordHash() != null) {
            zEquals = getPasswordHash().equals(backupRequest.getPasswordHash());
        } else if (backupRequest.getPasswordHash() != null) {
            zEquals = false;
        }
        return zEquals;
    }

    public String getEncryptedKey() {
        return this.encryptedKey;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public int hashCode() {
        return (getPasswordHash() != null ? getPasswordHash().hashCode() : 0) + (((getLoopId().hashCode() * 31) + getEncryptedKey().hashCode()) * 31);
    }

    public void setEncryptedKey(String str) {
        this.encryptedKey = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setPasswordHash(String str) {
        this.passwordHash = str;
    }

    public String toString() {
        return "BackupRequest{loopId='" + this.loopId + "', encryptedKey='" + this.encryptedKey + "', passwordHash='" + this.passwordHash + "'}";
    }
}
