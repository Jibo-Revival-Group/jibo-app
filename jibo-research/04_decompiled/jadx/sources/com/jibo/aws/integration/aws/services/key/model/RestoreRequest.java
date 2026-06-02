package com.jibo.aws.integration.aws.services.key.model;

import android.os.Parcel;
import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class RestoreRequest extends JiboKeyRequest {

    @Expose
    private String loopId;

    @Expose
    private String passwordHash;

    public RestoreRequest() {
    }

    protected RestoreRequest(Parcel parcel) {
        this.loopId = parcel.readString();
        this.passwordHash = parcel.readString();
    }

    public RestoreRequest(String str, String str2) {
        this.loopId = str;
        this.passwordHash = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestoreRequest)) {
            return false;
        }
        RestoreRequest restoreRequest = (RestoreRequest) obj;
        if (getLoopId().equals(restoreRequest.getLoopId())) {
            return getPasswordHash() != null ? getPasswordHash().equals(restoreRequest.getPasswordHash()) : restoreRequest.getPasswordHash() == null;
        }
        return false;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public int hashCode() {
        return (getPasswordHash() != null ? getPasswordHash().hashCode() : 0) + (getLoopId().hashCode() * 31);
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setPasswordHash(String str) {
        this.passwordHash = str;
    }

    public String toString() {
        return "RestoreRequest{loopId='" + this.loopId + "', passwordHash='" + this.passwordHash + "'}";
    }
}
