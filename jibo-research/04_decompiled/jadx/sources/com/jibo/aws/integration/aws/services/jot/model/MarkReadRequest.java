package com.jibo.aws.integration.aws.services.jot.model;

import com.jibo.aws.integration.aws.services.common.model.IdsRequestAbstract;
import com.jibo.aws.integration.util.Commons;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MarkReadRequest extends IdsRequestAbstract {
    public MarkReadRequest(List<String> list) {
        super(list);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "jot";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_JOT;
    }
}
