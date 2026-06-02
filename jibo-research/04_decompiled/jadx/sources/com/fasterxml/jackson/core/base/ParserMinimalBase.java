package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ParserMinimalBase extends JsonParser {

    /* JADX INFO: renamed from: K */
    protected JsonToken f5463K;

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: a */
    public abstract JsonToken mo6061a() throws IOException;

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: f */
    public abstract String mo6067f() throws IOException;

    /* JADX INFO: renamed from: t */
    protected abstract void mo6122t() throws JsonParseException;

    protected ParserMinimalBase(int i) {
        super(i);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: c */
    public JsonToken mo6064c() {
        return this.f5463K;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    /* JADX INFO: renamed from: b */
    public JsonParser mo6063b() throws IOException {
        if (this.f5463K == JsonToken.START_OBJECT || this.f5463K == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken jsonTokenMo6061a = mo6061a();
                if (jsonTokenMo6061a == null) {
                    mo6122t();
                    break;
                }
                if (jsonTokenMo6061a.isStructStart()) {
                    i++;
                } else if (jsonTokenMo6061a.isStructEnd() && i - 1 == 0) {
                    break;
                }
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    protected void m6137b(int i, String str) throws JsonParseException {
        if (i < 0) {
            m6130E();
        }
        String str2 = "Unexpected character (" + m6129d(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        m6141d(str2);
    }

    /* JADX INFO: renamed from: E */
    protected void m6130E() throws JsonParseException {
        m6140c(" in " + this.f5463K);
    }

    /* JADX INFO: renamed from: c */
    protected void m6140c(String str) throws JsonParseException {
        m6141d("Unexpected end-of-input" + str);
    }

    /* JADX INFO: renamed from: F */
    protected void m6131F() throws JsonParseException {
        m6140c(" in a value");
    }

    /* JADX INFO: renamed from: b */
    protected void m6136b(int i) throws JsonParseException {
        m6137b(i, "Expected space separating root-level values");
    }

    /* JADX INFO: renamed from: c */
    protected void m6138c(int i) throws JsonParseException {
        m6141d("Illegal character (" + m6129d((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    /* JADX INFO: renamed from: c */
    protected void m6139c(int i, String str) throws JsonParseException {
        if (!m6062a(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i > 32) {
            m6141d("Illegal unquoted character (" + m6129d((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    /* JADX INFO: renamed from: a */
    protected char m6133a(char c) throws JsonProcessingException {
        if (!m6062a(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) && (c != '\'' || !m6062a(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
            m6141d("Unrecognized character escape " + m6129d(c));
        }
        return c;
    }

    /* JADX INFO: renamed from: d */
    protected static final String m6129d(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        }
        if (i > 255) {
            return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
        }
        return "'" + c + "' (code " + i + ")";
    }

    /* JADX INFO: renamed from: d */
    protected final void m6141d(String str) throws JsonParseException {
        throw m6060a(str);
    }

    /* JADX INFO: renamed from: a */
    protected final void m6134a(String str, Throwable th) throws JsonParseException {
        throw m6135b(str, th);
    }

    /* JADX INFO: renamed from: G */
    protected final void m6132G() {
        VersionUtil.m6494a();
    }

    /* JADX INFO: renamed from: b */
    protected final JsonParseException m6135b(String str, Throwable th) {
        return new JsonParseException(str, mo6066e(), th);
    }
}
