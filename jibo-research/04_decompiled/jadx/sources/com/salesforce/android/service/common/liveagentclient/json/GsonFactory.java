package com.salesforce.android.service.common.liveagentclient.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class GsonFactory {
    /* JADX INFO: renamed from: a */
    public static Gson m13856a(GsonBuilder gsonBuilder, LiveAgentMessageRegistry liveAgentMessageRegistry, boolean z) {
        if (z) {
            gsonBuilder.m9378a(Collection.class, (Object) new CollectionSerializer());
        }
        return gsonBuilder.m9380a(LiveAgentStringResponse.class, new LiveAgentStringResponseDeserializer()).m9378a(LiveAgentMessage.class, (Object) new LiveAgentMessageDeserializer(liveAgentMessageRegistry)).m9376a();
    }
}
