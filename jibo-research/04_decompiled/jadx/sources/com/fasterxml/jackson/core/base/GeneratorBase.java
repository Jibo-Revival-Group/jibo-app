package com.fasterxml.jackson.core.base;

import com.facebook.internal.NativeProtocol;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class GeneratorBase extends JsonGenerator {

    /* JADX INFO: renamed from: b */
    protected static final int f5416b = (JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.getMask() | JsonGenerator.Feature.ESCAPE_NON_ASCII.getMask()) | JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.getMask();

    /* JADX INFO: renamed from: c */
    protected final String f5417c = "write a binary value";

    /* JADX INFO: renamed from: d */
    protected final String f5418d = "write a boolean value";

    /* JADX INFO: renamed from: e */
    protected final String f5419e = "write a null";

    /* JADX INFO: renamed from: f */
    protected final String f5420f = "write a number";

    /* JADX INFO: renamed from: g */
    protected final String f5421g = "write a raw (unencoded) value";

    /* JADX INFO: renamed from: h */
    protected final String f5422h = "write a string";

    /* JADX INFO: renamed from: i */
    protected ObjectCodec f5423i;

    /* JADX INFO: renamed from: j */
    protected int f5424j;

    /* JADX INFO: renamed from: k */
    protected boolean f5425k;

    /* JADX INFO: renamed from: l */
    protected JsonWriteContext f5426l;

    /* JADX INFO: renamed from: m */
    protected boolean f5427m;

    /* JADX INFO: renamed from: f */
    protected abstract void mo6099f(String str) throws IOException;

    /* JADX INFO: renamed from: j */
    protected abstract void mo6101j();

    protected GeneratorBase(int i, ObjectCodec objectCodec) {
        this.f5424j = i;
        this.f5423i = objectCodec;
        this.f5426l = JsonWriteContext.m6232a(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? DupDetector.m6216a(this) : null);
        this.f5425k = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(i);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6098a(JsonGenerator.Feature feature) {
        return (this.f5424j & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    /* JADX INFO: renamed from: b */
    public JsonGenerator mo6046b() {
        return m6036a() != null ? this : m6033a(m6102k());
    }

    /* JADX INFO: renamed from: i */
    public final JsonWriteContext m6100i() {
        return this.f5426l;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5427m = true;
    }

    /* JADX INFO: renamed from: k */
    protected PrettyPrinter m6102k() {
        return new DefaultPrettyPrinter();
    }

    /* JADX INFO: renamed from: a */
    protected final int m6097a(int i, int i2) throws IOException {
        if (i2 < 56320 || i2 > 57343) {
            m6055e("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + ((i - 55296) << 10) + (i2 - 56320);
    }
}
