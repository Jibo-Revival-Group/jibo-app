package com.jibo.aws.integration.aws.services.push.model;

import com.jibo.aws.integration.aws.services.common.model.NameRequestAbstract;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class NameRequest extends NameRequestAbstract {
    public NameRequest(String str) {
        super(str);
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "push";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_PUSH;
    }
}
