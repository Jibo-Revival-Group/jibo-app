package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public final class JsonNull extends JsonElement {

    /* JADX INFO: renamed from: a */
    public static final JsonNull f8819a = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof JsonNull);
    }
}
