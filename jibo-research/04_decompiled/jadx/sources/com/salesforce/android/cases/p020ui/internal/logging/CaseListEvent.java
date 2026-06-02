package com.salesforce.android.cases.p020ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "caseListEvents")
public class CaseListEvent extends BaseEvent {

    @SerializedName(m9428a = "caseBasicInfo")
    private final CaseBasicInfo caseBasicInfo;

    @SerializedName(m9428a = "caseCount")
    private final int caseCount;

    @SerializedName(m9428a = "eventType")
    private final String eventType;

    public CaseListEvent(CaseBasicInfo caseBasicInfo, String str, String str2, int i) {
        super("case", str);
        this.caseBasicInfo = caseBasicInfo;
        this.eventType = str2;
        this.caseCount = i;
    }
}
