package com.jibo.aws.integration.aws.services.jot.model;

import com.google.gson.annotations.Expose;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class CreateBinaryPartRequest extends JiboJotRequest {

    @Expose
    protected File body;

    public CreateBinaryPartRequest(File file) {
        this.body = file;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !super.equals(obj) || !(obj instanceof CreateBinaryPartRequest)) {
            return false;
        }
        CreateBinaryPartRequest createBinaryPartRequest = (CreateBinaryPartRequest) obj;
        if ((createBinaryPartRequest.getBody() == null) ^ (getBody() == null)) {
            return false;
        }
        return createBinaryPartRequest.getBody() == null || createBinaryPartRequest.getBody().equals(getBody());
    }

    public File getBody() {
        return this.body;
    }

    public int hashCode() {
        return (getBody() == null ? 0 : getBody().hashCode()) + (super.hashCode() * 31);
    }

    public void setBody(File file) {
        this.body = file;
    }

    public String toString() {
        return "CreatePartRequest {, body='" + this.body + "'}";
    }
}
