package com.salesforce.android.cases.p020ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

/* JADX INFO: loaded from: classes.dex */
@BatchedEvent(m13878a = "caseDataEnteredEvents")
public class CaseDataEnteredEvent extends BaseEvent {

    @SerializedName(m9428a = "caseBasicInfo")
    private final CaseBasicInfo caseBasicInfo;

    @SerializedName(m9428a = "wordCount")
    private final int wordCount;

    public CaseDataEnteredEvent(CaseBasicInfo caseBasicInfo, String str, int i) {
        super("case", str);
        this.caseBasicInfo = caseBasicInfo;
        this.wordCount = i;
    }
}
