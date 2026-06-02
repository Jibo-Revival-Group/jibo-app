package com.jibo.aws.integration.aws.services.binary.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.util.Commons;
import java.io.File;
import java.util.Map;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes.dex */
public class CreateBinaryRequest extends JiboRequestAbstract {

    @Expose
    protected File body;

    @Expose
    protected Map<String, String> meta;

    @Expose
    protected String path;

    public CreateBinaryRequest(String str, File file, Map<String, String> map) {
        this.path = str == null ? "" : str;
        this.body = file;
        this.meta = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateBinaryRequest)) {
            return false;
        }
        CreateBinaryRequest createBinaryRequest = (CreateBinaryRequest) obj;
        if ((createBinaryRequest.getPath() == null) ^ (getPath() == null)) {
            return false;
        }
        if (createBinaryRequest.getPath() != null && !createBinaryRequest.getPath().equals(getPath())) {
            return false;
        }
        if ((createBinaryRequest.getMeta() == null) ^ (getMeta() == null)) {
            return false;
        }
        if (createBinaryRequest.getMeta() != null && !createBinaryRequest.getMeta().equals(getPath())) {
            return false;
        }
        if ((createBinaryRequest.getBody() == null) ^ (getBody() == null)) {
            return false;
        }
        return createBinaryRequest.getBody() == null || createBinaryRequest.getBody().equals(getBody());
    }

    public File getBody() {
        return this.body;
    }

    public Map<String, String> getMeta() {
        return this.meta;
    }

    public String getPath() {
        return this.path;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return MIME.ENC_BINARY;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_BINARY;
    }

    public int hashCode() {
        return (((getBody() == null ? 0 : getBody().hashCode()) + (((getPath() == null ? 0 : getPath().hashCode()) + 31) * 31)) * 31) + (getMeta() != null ? getMeta().hashCode() : 0);
    }

    public void setBody(File file) {
        this.body = file;
    }

    public void setMeta(Map<String, String> map) {
        this.meta = map;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String toString() {
        return "CreateBinaryRequest {path='" + this.path + "', meta='" + this.meta + "', body='" + this.body + "'}";
    }
}
