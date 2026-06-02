package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest;
import com.jibo.aws.integration.util.Commons;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UpdateMemberPhotoRequest extends CreateBinaryRequest {

    /* JADX INFO: renamed from: id */
    @Expose
    private String f9571id;

    @Expose
    private String loopId;

    public UpdateMemberPhotoRequest(String str, String str2, File file, Map<String, String> map) {
        super(null, file, map);
        this.loopId = str;
        this.f9571id = str2;
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RemoveMemberRequest)) {
            return false;
        }
        RemoveMemberRequest removeMemberRequest = (RemoveMemberRequest) obj;
        if ((removeMemberRequest.getId() == null) ^ (getId() == null)) {
            return false;
        }
        if (removeMemberRequest.getId() != null && !removeMemberRequest.getId().equals(getId())) {
            return false;
        }
        if ((removeMemberRequest.getLoopId() == null) ^ (getLoopId() == null)) {
            return false;
        }
        return removeMemberRequest.getLoopId() == null || removeMemberRequest.getLoopId().equals(getLoopId());
    }

    public String getId() {
        return this.f9571id;
    }

    public String getLoopId() {
        return this.loopId;
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest, com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "loop";
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest, com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_LOOP;
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest
    public int hashCode() {
        return (((getId() == null ? 0 : getId().hashCode()) + 31) * 31) + (getLoopId() != null ? getLoopId().hashCode() : 0);
    }

    public void setId(String str) {
        this.f9571id = str;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    @Override // com.jibo.aws.integration.aws.services.binary.model.CreateBinaryRequest
    public String toString() {
        return "UpdateMemberPhotoRequest {, body='" + this.body + "', meta='" + this.meta + "'}";
    }
}
