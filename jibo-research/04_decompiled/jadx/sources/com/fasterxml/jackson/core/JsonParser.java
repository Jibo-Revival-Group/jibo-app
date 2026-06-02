package com.fasterxml.jackson.core;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonParser implements Closeable {

    /* JADX INFO: renamed from: a */
    protected int f5412a;

    /* JADX INFO: renamed from: a */
    public abstract JsonToken mo6061a() throws IOException;

    /* JADX INFO: renamed from: b */
    public abstract JsonParser mo6063b() throws IOException;

    /* JADX INFO: renamed from: c */
    public abstract JsonToken mo6064c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    /* JADX INFO: renamed from: d */
    public abstract String mo6065d() throws IOException;

    /* JADX INFO: renamed from: e */
    public abstract JsonLocation mo6066e();

    /* JADX INFO: renamed from: f */
    public abstract String mo6067f() throws IOException;

    /* JADX INFO: renamed from: i */
    public abstract int mo6070i() throws IOException;

    /* JADX INFO: renamed from: j */
    public abstract long mo6071j() throws IOException;

    /* JADX INFO: renamed from: k */
    public abstract BigInteger mo6072k() throws IOException;

    /* JADX INFO: renamed from: l */
    public abstract float mo6073l() throws IOException;

    /* JADX INFO: renamed from: m */
    public abstract double mo6074m() throws IOException;

    /* JADX INFO: renamed from: n */
    public abstract BigDecimal mo6075n() throws IOException;

    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false);

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

    protected JsonParser() {
    }

    protected JsonParser(int i) {
        this.f5412a = i;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6062a(Feature feature) {
        return feature.enabledIn(this.f5412a);
    }

    /* JADX INFO: renamed from: g */
    public byte m6068g() throws IOException {
        int iMo6070i = mo6070i();
        if (iMo6070i < -128 || iMo6070i > 255) {
            throw m6060a("Numeric value (" + mo6067f() + ") out of range of Java byte");
        }
        return (byte) iMo6070i;
    }

    /* JADX INFO: renamed from: h */
    public short m6069h() throws IOException {
        int iMo6070i = mo6070i();
        if (iMo6070i < -32768 || iMo6070i > 32767) {
            throw m6060a("Numeric value (" + mo6067f() + ") out of range of Java short");
        }
        return (short) iMo6070i;
    }

    /* JADX INFO: renamed from: a */
    protected JsonParseException m6060a(String str) {
        return new JsonParseException(str, mo6066e());
    }
}
