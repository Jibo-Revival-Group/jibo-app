package com.jibo.aws.integration.aws.services.key.model;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes.dex */
public class ShareRequest extends JiboKeyRequest {

    @Expose
    private String encryptedKey;

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9484id;

    public ShareRequest(String str, String str2) {
        this.f9484id = str;
        this.encryptedKey = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ShareRequest)) {
            return false;
        }
        ShareRequest shareRequest = (ShareRequest) obj;
        if ((shareRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (shareRequest.getId() != null && !shareRequest.getId().equals(getId())) {
            return false;
        }
        if ((shareRequest.getEncryptedKey() == null) ^ (getEncryptedKey() == null)) {
            return false;
        }
        return shareRequest.getEncryptedKey() == null || shareRequest.getEncryptedKey().equals(getEncryptedKey());
    }

    public String getEncryptedKey() {
        return this.encryptedKey;
    }

    public String getId() {
        return this.f9484id;
    }

    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + 31) * 31) + (getEncryptedKey() != null ? getEncryptedKey().hashCode() : 0);
    }

    public void setEncryptedKey(String str) {
        this.encryptedKey = str;
    }

    public void setId(String str) {
        this.f9484id = str;
    }

    public String toString() {
        return "ShareRequest {id='" + this.f9484id + "'encryptedKey='" + this.encryptedKey + "'}";
    }
}
