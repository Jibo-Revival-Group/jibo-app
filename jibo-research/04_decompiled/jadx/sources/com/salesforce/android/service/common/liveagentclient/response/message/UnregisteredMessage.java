package com.salesforce.android.service.common.liveagentclient.response.message;

import com.google.gson.JsonElement;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class UnregisteredMessage extends LiveAgentMessage {

    /* JADX INFO: renamed from: a */
    private final String f13578a;

    public UnregisteredMessage(String str, JsonElement jsonElement) {
        super("UNKNOWN", jsonElement);
        this.f13578a = str;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Unregistered Live Agent Message. Type[%s] - Content[%s]", this.f13578a, m13874a(JsonElement.class));
    }
}
