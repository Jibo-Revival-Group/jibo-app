package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.p000io.CharacterEscapes;
import com.fasterxml.jackson.core.p000io.IOContext;
import com.fasterxml.jackson.core.p000io.InputDecorator;
import com.fasterxml.jackson.core.p000io.OutputDecorator;
import com.fasterxml.jackson.core.p000io.UTF8Writer;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
public class JsonFactory implements Serializable {

    /* JADX INFO: renamed from: e */
    protected final transient CharsToNameCanonicalizer f5394e;

    /* JADX INFO: renamed from: f */
    protected final transient ByteQuadsCanonicalizer f5395f;

    /* JADX INFO: renamed from: g */
    @Deprecated
    protected final transient BytesToNameCanonicalizer f5396g;

    /* JADX INFO: renamed from: h */
    protected ObjectCodec f5397h;

    /* JADX INFO: renamed from: i */
    protected int f5398i;

    /* JADX INFO: renamed from: j */
    protected int f5399j;

    /* JADX INFO: renamed from: k */
    protected int f5400k;

    /* JADX INFO: renamed from: l */
    protected CharacterEscapes f5401l;

    /* JADX INFO: renamed from: m */
    protected InputDecorator f5402m;

    /* JADX INFO: renamed from: n */
    protected OutputDecorator f5403n;

    /* JADX INFO: renamed from: o */
    protected SerializableString f5404o;

    /* JADX INFO: renamed from: a */
    protected static final int f5389a = Feature.collectDefaults();

    /* JADX INFO: renamed from: b */
    protected static final int f5390b = JsonParser.Feature.collectDefaults();

    /* JADX INFO: renamed from: c */
    protected static final int f5391c = JsonGenerator.Feature.collectDefaults();

    /* JADX INFO: renamed from: p */
    private static final SerializableString f5393p = DefaultPrettyPrinter.f5668a;

    /* JADX INFO: renamed from: d */
    protected static final ThreadLocal<SoftReference<BufferRecycler>> f5392d = new ThreadLocal<>();

    public enum Feature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

        private final boolean _defaultState;

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
            return (getMask() & i) != 0;
        }

        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    public JsonFactory(ObjectCodec objectCodec) {
        this.f5394e = CharsToNameCanonicalizer.m6426a();
        this.f5395f = ByteQuadsCanonicalizer.m6386a();
        this.f5396g = BytesToNameCanonicalizer.m6423a();
        this.f5398i = f5389a;
        this.f5399j = f5390b;
        this.f5400k = f5391c;
        this.f5404o = f5393p;
        this.f5397h = objectCodec;
    }

    protected JsonFactory(JsonFactory jsonFactory, ObjectCodec objectCodec) {
        this.f5394e = CharsToNameCanonicalizer.m6426a();
        this.f5395f = ByteQuadsCanonicalizer.m6386a();
        this.f5396g = BytesToNameCanonicalizer.m6423a();
        this.f5398i = f5389a;
        this.f5399j = f5390b;
        this.f5400k = f5391c;
        this.f5404o = f5393p;
        this.f5397h = null;
        this.f5398i = jsonFactory.f5398i;
        this.f5399j = jsonFactory.f5399j;
        this.f5400k = jsonFactory.f5400k;
        this.f5401l = jsonFactory.f5401l;
        this.f5402m = jsonFactory.f5402m;
        this.f5403n = jsonFactory.f5403n;
        this.f5404o = jsonFactory.f5404o;
    }

    protected Object readResolve() {
        return new JsonFactory(this, this.f5397h);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6019a() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6020a(Feature feature) {
        return (this.f5398i & feature.getMask()) != 0;
    }

    /* JADX INFO: renamed from: a */
    public final JsonFactory m6006a(JsonGenerator.Feature feature, boolean z) {
        return z ? m6005a(feature) : m6021b(feature);
    }

    /* JADX INFO: renamed from: a */
    public JsonFactory m6005a(JsonGenerator.Feature feature) {
        this.f5400k |= feature.getMask();
        return this;
    }

    /* JADX INFO: renamed from: b */
    public JsonFactory m6021b(JsonGenerator.Feature feature) {
        this.f5400k &= feature.getMask() ^ (-1);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public JsonParser m6011a(InputStream inputStream) throws IOException {
        IOContext iOContextM6017a = m6017a((Object) inputStream, false);
        return m6012a(m6028b(inputStream, iOContextM6017a), iOContextM6017a);
    }

    /* JADX INFO: renamed from: a */
    public JsonParser m6013a(Reader reader) throws IOException {
        IOContext iOContextM6017a = m6017a((Object) reader, false);
        return m6014a(m6030b(reader, iOContextM6017a), iOContextM6017a);
    }

    /* JADX INFO: renamed from: a */
    public JsonParser m6015a(String str) throws IOException {
        int length = str.length();
        if (this.f5402m != null || length > 32768 || !m6019a()) {
            return m6013a(new StringReader(str));
        }
        IOContext iOContextM6017a = m6017a((Object) str, true);
        char[] cArrM6162a = iOContextM6017a.m6162a(length);
        str.getChars(0, length, cArrM6162a, 0);
        return m6016a(cArrM6162a, 0, length, iOContextM6017a, true);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public JsonParser m6024b(InputStream inputStream) throws IOException {
        return m6011a(inputStream);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public JsonParser m6025b(Reader reader) throws IOException {
        return m6013a(reader);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public JsonParser m6026b(String str) throws IOException {
        return m6015a(str);
    }

    /* JADX INFO: renamed from: a */
    public JsonGenerator m6007a(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        IOContext iOContextM6017a = m6017a((Object) outputStream, false);
        iOContextM6017a.m6156a(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return m6008a(m6029b(outputStream, iOContextM6017a), iOContextM6017a);
        }
        return m6010a(m6031b(m6018a(outputStream, jsonEncoding, iOContextM6017a), iOContextM6017a), iOContextM6017a);
    }

    /* JADX INFO: renamed from: a */
    public JsonGenerator m6009a(Writer writer) throws IOException {
        IOContext iOContextM6017a = m6017a((Object) writer, false);
        return m6010a(m6031b(writer, iOContextM6017a), iOContextM6017a);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public JsonGenerator m6022b(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        return m6007a(outputStream, jsonEncoding);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public JsonGenerator m6023b(Writer writer) throws IOException {
        return m6009a(writer);
    }

    /* JADX INFO: renamed from: a */
    protected JsonParser m6012a(InputStream inputStream, IOContext iOContext) throws IOException {
        return new ByteSourceJsonBootstrapper(iOContext, inputStream).m6213a(this.f5399j, this.f5397h, this.f5395f, this.f5394e, this.f5398i);
    }

    /* JADX INFO: renamed from: a */
    protected JsonParser m6014a(Reader reader, IOContext iOContext) throws IOException {
        return new ReaderBasedJsonParser(iOContext, this.f5399j, reader, this.f5397h, this.f5394e.m6440b(this.f5398i));
    }

    /* JADX INFO: renamed from: a */
    protected JsonParser m6016a(char[] cArr, int i, int i2, IOContext iOContext, boolean z) throws IOException {
        return new ReaderBasedJsonParser(iOContext, this.f5399j, null, this.f5397h, this.f5394e.m6440b(this.f5398i), cArr, i, i + i2, z);
    }

    /* JADX INFO: renamed from: a */
    protected JsonGenerator m6010a(Writer writer, IOContext iOContext) throws IOException {
        WriterBasedJsonGenerator writerBasedJsonGenerator = new WriterBasedJsonGenerator(iOContext, this.f5400k, this.f5397h, writer);
        if (this.f5401l != null) {
            writerBasedJsonGenerator.mo6035a(this.f5401l);
        }
        SerializableString serializableString = this.f5404o;
        if (serializableString != f5393p) {
            writerBasedJsonGenerator.mo6034a(serializableString);
        }
        return writerBasedJsonGenerator;
    }

    /* JADX INFO: renamed from: a */
    protected JsonGenerator m6008a(OutputStream outputStream, IOContext iOContext) throws IOException {
        UTF8JsonGenerator uTF8JsonGenerator = new UTF8JsonGenerator(iOContext, this.f5400k, this.f5397h, outputStream);
        if (this.f5401l != null) {
            uTF8JsonGenerator.mo6035a(this.f5401l);
        }
        SerializableString serializableString = this.f5404o;
        if (serializableString != f5393p) {
            uTF8JsonGenerator.mo6034a(serializableString);
        }
        return uTF8JsonGenerator;
    }

    /* JADX INFO: renamed from: a */
    protected Writer m6018a(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        return jsonEncoding == JsonEncoding.UTF8 ? new UTF8Writer(iOContext, outputStream) : new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    /* JADX INFO: renamed from: b */
    protected final InputStream m6028b(InputStream inputStream, IOContext iOContext) throws IOException {
        InputStream inputStreamM6173a;
        return (this.f5402m == null || (inputStreamM6173a = this.f5402m.m6173a(iOContext, inputStream)) == null) ? inputStream : inputStreamM6173a;
    }

    /* JADX INFO: renamed from: b */
    protected final Reader m6030b(Reader reader, IOContext iOContext) throws IOException {
        Reader readerM6174a;
        return (this.f5402m == null || (readerM6174a = this.f5402m.m6174a(iOContext, reader)) == null) ? reader : readerM6174a;
    }

    /* JADX INFO: renamed from: b */
    protected final OutputStream m6029b(OutputStream outputStream, IOContext iOContext) throws IOException {
        OutputStream outputStreamM6197a;
        return (this.f5403n == null || (outputStreamM6197a = this.f5403n.m6197a(iOContext, outputStream)) == null) ? outputStream : outputStreamM6197a;
    }

    /* JADX INFO: renamed from: b */
    protected final Writer m6031b(Writer writer, IOContext iOContext) throws IOException {
        Writer writerM6198a;
        return (this.f5403n == null || (writerM6198a = this.f5403n.m6198a(iOContext, writer)) == null) ? writer : writerM6198a;
    }

    /* JADX INFO: renamed from: b */
    public BufferRecycler m6027b() {
        if (m6020a(Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING)) {
            SoftReference<BufferRecycler> softReference = f5392d.get();
            BufferRecycler bufferRecycler = softReference == null ? null : softReference.get();
            if (bufferRecycler == null) {
                BufferRecycler bufferRecycler2 = new BufferRecycler();
                f5392d.set(new SoftReference<>(bufferRecycler2));
                return bufferRecycler2;
            }
            return bufferRecycler;
        }
        return new BufferRecycler();
    }

    /* JADX INFO: renamed from: a */
    protected IOContext m6017a(Object obj, boolean z) {
        return new IOContext(m6027b(), obj, z);
    }
}
