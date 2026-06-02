package com.jibo.aws.integration.aws.services.notification.model;

import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public abstract class JiboNotificationRequest extends JiboRequestAbstract {
    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return "notification";
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_NOTIFICATION;
    }
}
