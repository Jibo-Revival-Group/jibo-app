package com.salesforce.android.service.common.liveagentclient.json;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.salesforce.android.service.common.liveagentclient.LiveAgentMessageRegistry;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import com.salesforce.android.service.common.liveagentclient.response.message.UnregisteredMessage;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
class LiveAgentMessageDeserializer implements JsonDeserializer<LiveAgentMessage> {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13567a = ServiceLogging.m14203a((Class<?>) LiveAgentMessageDeserializer.class);

    /* JADX INFO: renamed from: b */
    private final LiveAgentMessageRegistry f13568b;

    public LiveAgentMessageDeserializer(LiveAgentMessageRegistry liveAgentMessageRegistry) {
        this.f13568b = liveAgentMessageRegistry;
    }

    @Override // com.google.gson.JsonDeserializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LiveAgentMessage deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            f13567a.mo14192d("Unable to deserialize LiveAgentMessage - Element is null");
            return null;
        }
        JsonObject jsonObjectM9395l = jsonElement.m9395l();
        String strMo9385c = jsonObjectM9395l.m9407c(ShareConstants.MEDIA_TYPE).mo9385c();
        JsonElement jsonElementM9407c = jsonObjectM9395l.m9407c(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Class clsM13800a = this.f13568b.m13800a(strMo9385c);
        if (clsM13800a == null) {
            f13567a.mo14195e("Unregistered LiveAgent Message encountered. Type[{}] - Content[{}] ", strMo9385c, jsonElementM9407c);
            return new UnregisteredMessage(strMo9385c, jsonElementM9407c);
        }
        f13567a.mo14187a("De-serializing LiveAgentMessage - Type[{}] - Class[{}] - Content[{}]", strMo9385c, clsM13800a.getSimpleName(), jsonElementM9407c);
        return new LiveAgentMessage(strMo9385c, jsonDeserializationContext.mo9390a(jsonElementM9407c, clsM13800a));
    }
}
