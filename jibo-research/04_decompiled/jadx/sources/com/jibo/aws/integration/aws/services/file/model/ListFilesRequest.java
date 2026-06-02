package com.jibo.aws.integration.aws.services.file.model;

import com.facebook.internal.AnalyticsEvents;
import com.jibo.aws.integration.aws.services.common.model.EmptyRequest;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public class ListFilesRequest extends EmptyRequest {
    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_PLACEHOLDER;
    }
}
