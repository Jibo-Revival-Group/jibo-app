package com.salesforce.android.cases.p020ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "caseSubmissionEvents")
public class CaseSubmissionEvent extends BaseEvent {

    @SerializedName(m9428a = "caseBasicInfo")
    private final CaseBasicInfo caseBasicInfo;

    @SerializedName(m9428a = "caseId")
    private final String caseId;

    @SerializedName(m9428a = "eventType")
    private final String eventType;

    @SerializedName(m9428a = "result")
    private final String result;

    @SerializedName(m9428a = "wordCount")
    private final int wordCount;

    public CaseSubmissionEvent(CaseBasicInfo caseBasicInfo, String str, String str2, String str3, String str4, int i) {
        super("case", str);
        this.caseBasicInfo = caseBasicInfo;
        this.eventType = str2;
        this.result = str3;
        this.caseId = str4;
        this.wordCount = i;
    }
}
