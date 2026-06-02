package com.salesforce.android.cases.p020ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "caseNotificationEvents")
public class CaseNotificationEvent extends BaseEvent {

    @SerializedName(m9428a = "caseBasicInfo")
    private final CaseBasicInfo caseBasicInfo;

    @SerializedName(m9428a = "sender")
    private final String caseId;

    public CaseNotificationEvent(CaseBasicInfo caseBasicInfo, String str, String str2) {
        super("case", str);
        this.caseBasicInfo = caseBasicInfo;
        this.caseId = str2;
    }
}
