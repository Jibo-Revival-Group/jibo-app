package com.jibo.aws.integration.aws.services.media.model;

import com.facebook.share.internal.ShareConstants;
import com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract;
import com.jibo.aws.integration.util.Commons;

/* JADX INFO: loaded from: classes.dex */
public abstract class JiboMediaRequest extends JiboRequestAbstract {
    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServiceAbbr() {
        return ShareConstants.WEB_DIALOG_PARAM_MEDIA;
    }

    @Override // com.jibo.aws.integration.aws.services.common.model.JiboRequestAbstract
    public String getServicePrefix() {
        return Commons.TARGET_PREFIX_MEDIA;
    }
}
