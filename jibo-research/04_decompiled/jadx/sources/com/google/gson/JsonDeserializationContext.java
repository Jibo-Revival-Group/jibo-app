package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface JsonDeserializationContext {
    /* JADX INFO: renamed from: a */
    <T> T mo9390a(JsonElement jsonElement, Type type) throws JsonParseException;
}
