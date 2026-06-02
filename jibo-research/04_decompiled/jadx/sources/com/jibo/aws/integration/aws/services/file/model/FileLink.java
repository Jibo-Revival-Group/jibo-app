package com.jibo.aws.integration.aws.services.file.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class FileLink extends AmazonWebServiceRequest implements Serializable {

    @Expose
    private String accountId;

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9434id;

    @Expose
    private String key;

    @Expose
    private String url;

    public FileLink(String str, String str2, String str3, String str4) {
        this.key = str;
        this.url = str2;
        this.f9434id = str3;
        this.accountId = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FileLink)) {
            return false;
        }
        FileLink fileLink = (FileLink) obj;
        if ((fileLink.getUrl() == null) ^ (getUrl() == null)) {
            return false;
        }
        if (fileLink.getUrl() != null && !fileLink.getUrl().equals(getUrl())) {
            return false;
        }
        if ((fileLink.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (fileLink.getKey() != null && !fileLink.getKey().equals(getKey())) {
            return false;
        }
        if ((fileLink.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (fileLink.getId() != null && !fileLink.getId().equals(getId())) {
            return false;
        }
        if ((fileLink.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        return fileLink.getAccountId() == null || fileLink.getAccountId().equals(getAccountId());
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getId() {
        return this.f9434id;
    }

    public String getKey() {
        return this.key;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + (((getKey() == null ? 0 : getKey().hashCode()) + (((getUrl() == null ? 0 : getUrl().hashCode()) + 31) * 31)) * 31)) * 31) + (getAccountId() != null ? getAccountId().hashCode() : 0);
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setId(String str) {
        this.f9434id = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "FileLink {url='" + this.url + "', key='" + this.key + "', id='" + this.f9434id + "', accountId='" + this.accountId + "'}";
    }
}
