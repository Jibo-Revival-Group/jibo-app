package com.jibo.aws.integration.aws.services.media.model;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.util.Commons;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class CreateRequest extends CreateBinaryRequest {

    @Expose
    private Boolean isEncrypted;

    @Expose
    private String loopId;

    @Expose
    private String reference;

    @Expose
    private String type;

    public CreateRequest(String str, String str2, String str3, String str4, File file, Boolean bool) {
        super(str4, file, null);
        this.loopId = str;
        this.type = str2;
        this.reference = str3;
        this.isEncrypted = bool;
    }

    public String getLoopId() {
        return this.loopId;
    }

    public String getReference() {
        return this.reference;
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest, com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return ShareConstants.WEB_DIALOG_PARAM_MEDIA;
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest, com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_MEDIA;
    }

    public String getType() {
        return this.type;
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest
    public int hashCode() {
        return (((getReference() == null ? 0 : getReference().hashCode()) + (((getType() == null ? 0 : getType().hashCode()) + (((getLoopId() == null ? 0 : getLoopId().hashCode()) + 31) * 31)) * 31)) * 31) + (isEncrypted() != null ? isEncrypted().hashCode() : 0);
    }

    public Boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setEncrypted(Boolean bool) {
        this.isEncrypted = bool;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
