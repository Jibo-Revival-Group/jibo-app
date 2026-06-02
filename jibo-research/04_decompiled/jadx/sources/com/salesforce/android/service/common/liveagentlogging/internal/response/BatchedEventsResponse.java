package com.salesforce.android.service.common.liveagentlogging.internal.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BatchedEventsResponse {

    @SerializedName(m9428a = "messages")
    private List<Object> mMessages;

    public String toString() {
        return String.format(Locale.getDefault(), "%s: %s", getClass().getSimpleName(), this.mMessages.toString());
    }
}
