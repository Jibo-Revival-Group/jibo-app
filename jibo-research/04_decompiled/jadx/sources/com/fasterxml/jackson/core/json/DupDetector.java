package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class DupDetector {

    /* JADX INFO: renamed from: a */
    protected final Object f5537a;

    /* JADX INFO: renamed from: b */
    protected String f5538b;

    /* JADX INFO: renamed from: c */
    protected String f5539c;

    /* JADX INFO: renamed from: d */
    protected HashSet<String> f5540d;

    private DupDetector(Object obj) {
        this.f5537a = obj;
    }

    /* JADX INFO: renamed from: a */
    public static DupDetector m6217a(JsonParser jsonParser) {
        return new DupDetector(jsonParser);
    }

    /* JADX INFO: renamed from: a */
    public static DupDetector m6216a(JsonGenerator jsonGenerator) {
        return new DupDetector(jsonGenerator);
    }

    /* JADX INFO: renamed from: a */
    public DupDetector m6218a() {
        return new DupDetector(this.f5537a);
    }

    /* JADX INFO: renamed from: b */
    public void m6220b() {
        this.f5538b = null;
        this.f5539c = null;
        this.f5540d = null;
    }

    /* JADX INFO: renamed from: c */
    public JsonLocation m6221c() {
        if (this.f5537a instanceof JsonParser) {
            return ((JsonParser) this.f5537a).mo6066e();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6219a(String str) throws JsonParseException {
        if (this.f5538b == null) {
            this.f5538b = str;
            return false;
        }
        if (str.equals(this.f5538b)) {
            return true;
        }
        if (this.f5539c == null) {
            this.f5539c = str;
            return false;
        }
        if (str.equals(this.f5539c)) {
            return true;
        }
        if (this.f5540d == null) {
            this.f5540d = new HashSet<>(16);
            this.f5540d.add(this.f5538b);
            this.f5540d.add(this.f5539c);
        }
        return !this.f5540d.add(str);
    }
}
