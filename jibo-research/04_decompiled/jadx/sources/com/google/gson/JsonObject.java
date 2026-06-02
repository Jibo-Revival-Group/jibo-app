package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class JsonObject extends JsonElement {

    /* JADX INFO: renamed from: a */
    private final LinkedTreeMap<String, JsonElement> f8820a = new LinkedTreeMap<>();

    /* JADX INFO: renamed from: a */
    public void m9402a(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f8819a;
        }
        this.f8820a.put(str, jsonElement);
    }

    /* JADX INFO: renamed from: a */
    public JsonElement m9400a(String str) {
        return this.f8820a.remove(str);
    }

    /* JADX INFO: renamed from: a */
    public void m9405a(String str, String str2) {
        m9402a(str, m9399a((Object) str2));
    }

    /* JADX INFO: renamed from: a */
    public void m9404a(String str, Number number) {
        m9402a(str, m9399a(number));
    }

    /* JADX INFO: renamed from: a */
    public void m9403a(String str, Boolean bool) {
        m9402a(str, m9399a(bool));
    }

    /* JADX INFO: renamed from: a */
    private JsonElement m9399a(Object obj) {
        return obj == null ? JsonNull.f8819a : new JsonPrimitive(obj);
    }

    /* JADX INFO: renamed from: a */
    public Set<Map.Entry<String, JsonElement>> m9401a() {
        return this.f8820a.entrySet();
    }

    /* JADX INFO: renamed from: p */
    public int m9410p() {
        return this.f8820a.size();
    }

    /* JADX INFO: renamed from: b */
    public boolean m9406b(String str) {
        return this.f8820a.containsKey(str);
    }

    /* JADX INFO: renamed from: c */
    public JsonElement m9407c(String str) {
        return this.f8820a.get(str);
    }

    /* JADX INFO: renamed from: d */
    public JsonArray m9408d(String str) {
        return (JsonArray) this.f8820a.get(str);
    }

    /* JADX INFO: renamed from: e */
    public JsonObject m9409e(String str) {
        return (JsonObject) this.f8820a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).f8820a.equals(this.f8820a));
    }

    public int hashCode() {
        return this.f8820a.hashCode();
    }
}
