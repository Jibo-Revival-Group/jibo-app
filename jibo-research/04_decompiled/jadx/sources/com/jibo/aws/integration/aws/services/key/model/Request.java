package com.jibo.aws.integration.aws.services.key.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Request implements Serializable {

    @Expose
    private String accountId;

    @Expose
    private String encryptedKey;

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9483id;

    @Expose
    private String loopId;

    @Expose
    private String publicKey;

    public Request() {
    }

    public Request(String str, String str2, String str3, String str4, String str5) {
        this.f9483id = str;
        this.accountId = str2;
        this.loopId = str3;
        this.publicKey = str4;
        this.encryptedKey = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        if ((request.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        if (request.getAccountId() != null && !request.getAccountId().equals(getAccountId())) {
            return false;
        }
        if ((request.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        if (request.getLoopId() != null && !request.getLoopId().equals(getLoopId())) {
            return false;
        }
        if ((request.getEncryptedKey() == null) ^ (getEncryptedKey() == null)) {
            return false;
        }
        if (request.getEncryptedKey() != null && !request.getEncryptedKey().equals(getEncryptedKey())) {
            return false;
        }
        if ((request.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        return request.getPublicKey() == null || request.getPublicKey().equals(getPublicKey());
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getEncryptedKey() {
        return this.encryptedKey;
    }

    public String getId() {
        return this.f9483id;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        return (((getPublicKey() == null ? 0 : getPublicKey().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + (((getAccountId() == null ? 0 : getAccountId().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31) + (getEncryptedKey() != null ? getEncryptedKey().hashCode() : 0);
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setEncryptedKey(String str) {
        this.encryptedKey = str;
    }

    public void setId(String str) {
        this.f9483id = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public String toString() {
        return "Request {id='" + this.f9483id + "'accountId='" + this.accountId + "'loopId='" + this.loopId + "'publicKey='" + this.publicKey + "'\"publicKey='\" + publicKey + '\\'' +='" + this.encryptedKey + "'}";
    }
}
