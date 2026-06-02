package com.salesforce.android.service.common.liveagentclient.response;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MessagesResponse {

    /* JADX INFO: renamed from: a */
    public static final MessagesResponse f13575a = new MessagesResponse(0, new LiveAgentMessage[0]);

    @SerializedName(m9428a = "messages")
    private List<LiveAgentMessage> mMessages;

    @SerializedName(m9428a = "sequence")
    private Integer mSequence;

    public MessagesResponse(Integer num, LiveAgentMessage... liveAgentMessageArr) {
        this.mMessages = Arrays.asList(liveAgentMessageArr);
        this.mSequence = num;
    }

    /* JADX INFO: renamed from: a */
    public List<LiveAgentMessage> m13871a() {
        return this.mMessages;
    }
}
