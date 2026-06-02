package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class JsonTreeWriter extends JsonWriter {

    /* JADX INFO: renamed from: a */
    private static final Writer f8921a = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* JADX INFO: renamed from: b */
    private static final JsonPrimitive f8922b = new JsonPrimitive("closed");

    /* JADX INFO: renamed from: c */
    private final List<JsonElement> f8923c;

    /* JADX INFO: renamed from: d */
    private String f8924d;

    /* JADX INFO: renamed from: e */
    private JsonElement f8925e;

    public JsonTreeWriter() {
        super(f8921a);
        this.f8923c = new ArrayList();
        this.f8925e = JsonNull.f8819a;
    }

    /* JADX INFO: renamed from: a */
    public JsonElement m9524a() {
        if (!this.f8923c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.f8923c);
        }
        return this.f8925e;
    }

    /* JADX INFO: renamed from: j */
    private JsonElement m9523j() {
        return this.f8923c.get(this.f8923c.size() - 1);
    }

    /* JADX INFO: renamed from: a */
    private void m9522a(JsonElement jsonElement) {
        if (this.f8924d != null) {
            if (!jsonElement.m9394k() || m9661i()) {
                ((JsonObject) m9523j()).m9402a(this.f8924d, jsonElement);
            }
            this.f8924d = null;
            return;
        }
        if (this.f8923c.isEmpty()) {
            this.f8925e = jsonElement;
            return;
        }
        JsonElement jsonElementM9523j = m9523j();
        if (jsonElementM9523j instanceof JsonArray) {
            ((JsonArray) jsonElementM9523j).m9383a(jsonElement);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: b */
    public JsonWriter mo9530b() throws IOException {
        JsonArray jsonArray = new JsonArray();
        m9522a(jsonArray);
        this.f8923c.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: c */
    public JsonWriter mo9532c() throws IOException {
        if (this.f8923c.isEmpty() || this.f8924d != null) {
            throw new IllegalStateException();
        }
        if (m9523j() instanceof JsonArray) {
            this.f8923c.remove(this.f8923c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: d */
    public JsonWriter mo9533d() throws IOException {
        JsonObject jsonObject = new JsonObject();
        m9522a(jsonObject);
        this.f8923c.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: e */
    public JsonWriter mo9534e() throws IOException {
        if (this.f8923c.isEmpty() || this.f8924d != null) {
            throw new IllegalStateException();
        }
        if (m9523j() instanceof JsonObject) {
            this.f8923c.remove(this.f8923c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: a */
    public JsonWriter mo9528a(String str) throws IOException {
        if (this.f8923c.isEmpty() || this.f8924d != null) {
            throw new IllegalStateException();
        }
        if (m9523j() instanceof JsonObject) {
            this.f8924d = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: b */
    public JsonWriter mo9531b(String str) throws IOException {
        if (str == null) {
            return mo9535f();
        }
        m9522a(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: f */
    public JsonWriter mo9535f() throws IOException {
        m9522a(JsonNull.f8819a);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: a */
    public JsonWriter mo9529a(boolean z) throws IOException {
        m9522a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: a */
    public JsonWriter mo9526a(Boolean bool) throws IOException {
        if (bool == null) {
            return mo9535f();
        }
        m9522a(new JsonPrimitive(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: a */
    public JsonWriter mo9525a(long j) throws IOException {
        m9522a(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    /* JADX INFO: renamed from: a */
    public JsonWriter mo9527a(Number number) throws IOException {
        if (number == null) {
            return mo9535f();
        }
        if (!m9659g()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m9522a(new JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f8923c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f8923c.add(f8922b);
    }
}
