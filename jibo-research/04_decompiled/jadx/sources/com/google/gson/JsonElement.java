package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonElement {
    /* JADX INFO: renamed from: h */
    public boolean m9391h() {
        return this instanceof JsonArray;
    }

    /* JADX INFO: renamed from: i */
    public boolean m9392i() {
        return this instanceof JsonObject;
    }

    /* JADX INFO: renamed from: j */
    public boolean m9393j() {
        return this instanceof JsonPrimitive;
    }

    /* JADX INFO: renamed from: k */
    public boolean m9394k() {
        return this instanceof JsonNull;
    }

    /* JADX INFO: renamed from: l */
    public JsonObject m9395l() {
        if (m9392i()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    /* JADX INFO: renamed from: m */
    public JsonArray m9396m() {
        if (m9391h()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    /* JADX INFO: renamed from: n */
    public JsonPrimitive m9397n() {
        if (m9393j()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    /* JADX INFO: renamed from: g */
    public boolean mo9389g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: o */
    Boolean mo9398o() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: b */
    public Number mo9384b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: c */
    public String mo9385c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: d */
    public double mo9386d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: e */
    public long mo9387e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: f */
    public int mo9388f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.m9655b(true);
            Streams.m9491a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
