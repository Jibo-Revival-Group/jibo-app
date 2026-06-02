package com.salesforce.android.cases.core.internal.http.response;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaseListRecordResponse {

    @SerializedName(m9428a = "done")
    private boolean done;

    @SerializedName(m9428a = "records")
    private List<CaseListRecord> records;

    @SerializedName(m9428a = "totalSize")
    private int totalSize;

    /* JADX INFO: renamed from: a */
    public List<CaseListRecord> m12313a() {
        return this.records == null ? Collections.emptyList() : Collections.unmodifiableList(this.records);
    }
}
