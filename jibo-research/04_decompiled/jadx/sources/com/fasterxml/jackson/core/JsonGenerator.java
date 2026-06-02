package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p000io.CharacterEscapes;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonGenerator implements Closeable, Flushable {

    /* JADX INFO: renamed from: a */
    protected PrettyPrinter f5405a;

    /* JADX INFO: renamed from: a */
    public abstract void mo6037a(char c) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6038a(double d) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6039a(float f) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6040a(long j) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6041a(String str) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6042a(BigDecimal bigDecimal) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6043a(BigInteger bigInteger) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6044a(boolean z) throws IOException;

    /* JADX INFO: renamed from: a */
    public abstract void mo6045a(char[] cArr, int i, int i2) throws IOException;

    /* JADX INFO: renamed from: b */
    public abstract JsonGenerator mo6046b();

    /* JADX INFO: renamed from: b */
    public abstract void mo6047b(int i) throws IOException;

    /* JADX INFO: renamed from: b */
    public abstract void mo6049b(String str) throws IOException;

    /* JADX INFO: renamed from: c */
    public abstract void mo6050c() throws IOException;

    /* JADX INFO: renamed from: c */
    public abstract void mo6051c(String str) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    /* JADX INFO: renamed from: d */
    public abstract void mo6052d() throws IOException;

    /* JADX INFO: renamed from: d */
    public abstract void mo6053d(String str) throws IOException;

    /* JADX INFO: renamed from: e */
    public abstract void mo6054e() throws IOException;

    /* JADX INFO: renamed from: f */
    public abstract void mo6056f() throws IOException;

    @Override // java.io.Flushable
    public abstract void flush() throws IOException;

    /* JADX INFO: renamed from: g */
    public abstract void mo6057g() throws IOException;

    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        ESCAPE_NON_ASCII(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        Feature(boolean z) {
            this._defaultState = z;
        }

        public boolean enabledByDefault() {
            return this._defaultState;
        }

        public boolean enabledIn(int i) {
            return (this._mask & i) != 0;
        }

        public int getMask() {
            return this._mask;
        }
    }

    protected JsonGenerator() {
    }

    /* JADX INFO: renamed from: a */
    public JsonGenerator m6033a(PrettyPrinter prettyPrinter) {
        this.f5405a = prettyPrinter;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public PrettyPrinter m6036a() {
        return this.f5405a;
    }

    /* JADX INFO: renamed from: a */
    public JsonGenerator mo6032a(int i) {
        return this;
    }

    /* JADX INFO: renamed from: a */
    public JsonGenerator mo6035a(CharacterEscapes characterEscapes) {
        return this;
    }

    /* JADX INFO: renamed from: a */
    public JsonGenerator mo6034a(SerializableString serializableString) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: b */
    public void mo6048b(SerializableString serializableString) throws IOException {
        mo6051c(serializableString.mo6095a());
    }

    /* JADX INFO: renamed from: e */
    protected void m6055e(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str);
    }

    /* JADX INFO: renamed from: h */
    protected final void m6058h() {
        VersionUtil.m6494a();
    }
}
