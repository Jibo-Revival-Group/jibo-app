package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public class JsonWriteContext extends JsonStreamContext {

    /* JADX INFO: renamed from: c */
    protected final JsonWriteContext f5554c;

    /* JADX INFO: renamed from: d */
    protected DupDetector f5555d;

    /* JADX INFO: renamed from: e */
    protected JsonWriteContext f5556e = null;

    /* JADX INFO: renamed from: f */
    protected String f5557f;

    /* JADX INFO: renamed from: g */
    protected Object f5558g;

    /* JADX INFO: renamed from: h */
    protected boolean f5559h;

    protected JsonWriteContext(int i, JsonWriteContext jsonWriteContext, DupDetector dupDetector) {
        this.f5414a = i;
        this.f5554c = jsonWriteContext;
        this.f5555d = dupDetector;
        this.f5415b = -1;
    }

    /* JADX INFO: renamed from: a */
    protected JsonWriteContext m6235a(int i) {
        this.f5414a = i;
        this.f5415b = -1;
        this.f5557f = null;
        this.f5559h = false;
        this.f5558g = null;
        if (this.f5555d != null) {
            this.f5555d.m6220b();
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public static JsonWriteContext m6232a(DupDetector dupDetector) {
        return new JsonWriteContext(0, null, dupDetector);
    }

    /* JADX INFO: renamed from: g */
    public JsonWriteContext m6237g() {
        JsonWriteContext jsonWriteContext = this.f5556e;
        if (jsonWriteContext == null) {
            JsonWriteContext jsonWriteContext2 = new JsonWriteContext(1, this, this.f5555d == null ? null : this.f5555d.m6218a());
            this.f5556e = jsonWriteContext2;
            return jsonWriteContext2;
        }
        return jsonWriteContext.m6235a(1);
    }

    /* JADX INFO: renamed from: h */
    public JsonWriteContext m6238h() {
        JsonWriteContext jsonWriteContext = this.f5556e;
        if (jsonWriteContext == null) {
            JsonWriteContext jsonWriteContext2 = new JsonWriteContext(2, this, this.f5555d == null ? null : this.f5555d.m6218a());
            this.f5556e = jsonWriteContext2;
            return jsonWriteContext2;
        }
        return jsonWriteContext.m6235a(2);
    }

    /* JADX INFO: renamed from: i */
    public final JsonWriteContext m6239i() {
        return this.f5554c;
    }

    /* JADX INFO: renamed from: a */
    public int m6234a(String str) throws JsonProcessingException {
        if (this.f5559h) {
            return 4;
        }
        this.f5559h = true;
        this.f5557f = str;
        if (this.f5555d != null) {
            m6233a(this.f5555d, str);
        }
        return this.f5415b < 0 ? 0 : 1;
    }

    /* JADX INFO: renamed from: a */
    private final void m6233a(DupDetector dupDetector, String str) throws JsonProcessingException {
        if (dupDetector.m6219a(str)) {
            throw new JsonGenerationException("Duplicate field '" + str + "'");
        }
    }

    /* JADX INFO: renamed from: j */
    public int m6240j() {
        if (this.f5414a == 2) {
            if (!this.f5559h) {
                return 5;
            }
            this.f5559h = false;
            this.f5415b++;
            return 2;
        }
        if (this.f5414a == 1) {
            int i = this.f5415b;
            this.f5415b++;
            return i >= 0 ? 1 : 0;
        }
        this.f5415b++;
        return this.f5415b != 0 ? 3 : 0;
    }

    /* JADX INFO: renamed from: a */
    protected void m6236a(StringBuilder sb) {
        if (this.f5414a == 2) {
            sb.append('{');
            if (this.f5557f != null) {
                sb.append(TokenParser.DQUOTE);
                sb.append(this.f5557f);
                sb.append(TokenParser.DQUOTE);
            } else {
                sb.append('?');
            }
            sb.append('}');
            return;
        }
        if (this.f5414a == 1) {
            sb.append('[');
            sb.append(m6083f());
            sb.append(']');
            return;
        }
        sb.append("/");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        m6236a(sb);
        return sb.toString();
    }
}
