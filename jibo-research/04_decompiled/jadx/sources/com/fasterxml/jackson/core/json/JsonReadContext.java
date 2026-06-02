package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.p000io.CharTypes;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class JsonReadContext extends JsonStreamContext {

    /* JADX INFO: renamed from: c */
    protected final JsonReadContext f5547c;

    /* JADX INFO: renamed from: d */
    protected DupDetector f5548d;

    /* JADX INFO: renamed from: e */
    protected JsonReadContext f5549e = null;

    /* JADX INFO: renamed from: f */
    protected String f5550f;

    /* JADX INFO: renamed from: g */
    protected Object f5551g;

    /* JADX INFO: renamed from: h */
    protected int f5552h;

    /* JADX INFO: renamed from: i */
    protected int f5553i;

    public JsonReadContext(JsonReadContext jsonReadContext, DupDetector dupDetector, int i, int i2, int i3) {
        this.f5547c = jsonReadContext;
        this.f5548d = dupDetector;
        this.f5414a = i;
        this.f5552h = i2;
        this.f5553i = i3;
        this.f5415b = -1;
    }

    /* JADX INFO: renamed from: a */
    protected void m6226a(int i, int i2, int i3) {
        this.f5414a = i;
        this.f5415b = -1;
        this.f5552h = i2;
        this.f5553i = i3;
        this.f5550f = null;
        this.f5551g = null;
        if (this.f5548d != null) {
            this.f5548d.m6220b();
        }
    }

    /* JADX INFO: renamed from: a */
    public static JsonReadContext m6222a(DupDetector dupDetector) {
        return new JsonReadContext(null, dupDetector, 0, 1, 0);
    }

    /* JADX INFO: renamed from: a */
    public JsonReadContext m6225a(int i, int i2) {
        JsonReadContext jsonReadContext = this.f5549e;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, this.f5548d == null ? null : this.f5548d.m6218a(), 1, i, i2);
            this.f5549e = jsonReadContext;
        } else {
            jsonReadContext.m6226a(1, i, i2);
        }
        return jsonReadContext;
    }

    /* JADX INFO: renamed from: b */
    public JsonReadContext m6228b(int i, int i2) {
        JsonReadContext jsonReadContext = this.f5549e;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, this.f5548d == null ? null : this.f5548d.m6218a(), 2, i, i2);
            this.f5549e = jsonReadContext;
        } else {
            jsonReadContext.m6226a(2, i, i2);
        }
        return jsonReadContext;
    }

    /* JADX INFO: renamed from: g */
    public String m6229g() {
        return this.f5550f;
    }

    /* JADX INFO: renamed from: h */
    public JsonReadContext m6230h() {
        return this.f5547c;
    }

    /* JADX INFO: renamed from: a */
    public JsonLocation m6224a(Object obj) {
        return new JsonLocation(obj, -1L, this.f5552h, this.f5553i);
    }

    /* JADX INFO: renamed from: i */
    public boolean m6231i() {
        int i = this.f5415b + 1;
        this.f5415b = i;
        return this.f5414a != 0 && i > 0;
    }

    /* JADX INFO: renamed from: a */
    public void m6227a(String str) throws JsonProcessingException {
        this.f5550f = str;
        if (this.f5548d != null) {
            m6223a(this.f5548d, str);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6223a(DupDetector dupDetector, String str) throws JsonProcessingException {
        if (dupDetector.m6219a(str)) {
            throw new JsonParseException("Duplicate field '" + str + "'", dupDetector.m6221c());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        switch (this.f5414a) {
            case 0:
                sb.append("/");
                break;
            case 1:
                sb.append('[');
                sb.append(m6083f());
                sb.append(']');
                break;
            case 2:
                sb.append('{');
                if (this.f5550f != null) {
                    sb.append(TokenParser.DQUOTE);
                    CharTypes.m6143a(sb, this.f5550f);
                    sb.append(TokenParser.DQUOTE);
                } else {
                    sb.append('?');
                }
                sb.append('}');
                break;
        }
        return sb.toString();
    }
}
