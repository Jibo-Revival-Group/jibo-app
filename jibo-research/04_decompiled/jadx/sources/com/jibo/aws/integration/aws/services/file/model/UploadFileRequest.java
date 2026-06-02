package com.jibo.aws.integration.aws.services.file.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.google.gson.annotations.Expose;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class UploadFileRequest extends AmazonWebServiceRequest implements Serializable {

    @Expose
    private File body;

    @Expose
    private String key;

    public UploadFileRequest(String str, File file) {
        this.key = str;
        this.body = file;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UploadFileRequest)) {
            return false;
        }
        UploadFileRequest uploadFileRequest = (UploadFileRequest) obj;
        if ((uploadFileRequest.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (uploadFileRequest.getKey() != null && !uploadFileRequest.getKey().equals(getKey())) {
            return false;
        }
        if ((uploadFileRequest.getBody() == null) ^ (getBody() == null)) {
            return false;
        }
        return uploadFileRequest.getBody() == null || uploadFileRequest.getBody().equals(getBody());
    }

    public File getBody() {
        return this.body;
    }

    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        return (((getKey() == null ? 0 : getKey().hashCode()) + 31) * 31) + (getBody() != null ? getBody().hashCode() : 0);
    }

    public void setBody(File file) {
        this.body = file;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String toString() {
        return "UploadVoiceTrainingRequest {key='" + this.key + "', body='" + this.body + "'}";
    }
}
