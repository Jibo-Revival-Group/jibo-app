package com.jibo.aws.integration.aws.services.loop.model;

import com.google.gson.annotations.Expose;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class JiboLoopRequest extends JiboRequestAbstract {

    @Expose
    protected String loopId;

    public JiboLoopRequest(String str) {
        this.loopId = str;
    }

    public String getLoopId() {
        return this.loopId;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "loop";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_LOOP;
    }

    public void setLoopId(String str) {
        this.loopId = str;
    }

    public String toString() {
        return "LoopIdRequest {loopId='" + this.loopId + "'}";
    }
}
