package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class JsonTreeReader extends JsonReader {

    /* JADX INFO: renamed from: b */
    private static final Reader f8915b = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* JADX INFO: renamed from: c */
    private static final Object f8916c = new Object();

    /* JADX INFO: renamed from: d */
    private Object[] f8917d;

    /* JADX INFO: renamed from: e */
    private int f8918e;

    /* JADX INFO: renamed from: f */
    private String[] f8919f;

    /* JADX INFO: renamed from: g */
    private int[] f8920g;

    public JsonTreeReader(JsonElement jsonElement) {
        super(f8915b);
        this.f8917d = new Object[32];
        this.f8918e = 0;
        this.f8919f = new String[32];
        this.f8920g = new int[32];
        m9502a(jsonElement);
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: a */
    public void mo9506a() throws IOException {
        m9501a(JsonToken.BEGIN_ARRAY);
        m9502a(((JsonArray) m9503t()).iterator());
        this.f8920g[this.f8918e - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: b */
    public void mo9507b() throws IOException {
        m9501a(JsonToken.END_ARRAY);
        m9504u();
        m9504u();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: c */
    public void mo9508c() throws IOException {
        m9501a(JsonToken.BEGIN_OBJECT);
        m9502a(((JsonObject) m9503t()).m9401a().iterator());
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: d */
    public void mo9509d() throws IOException {
        m9501a(JsonToken.END_OBJECT);
        m9504u();
        m9504u();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: e */
    public boolean mo9510e() throws IOException {
        JsonToken jsonTokenMo9511f = mo9511f();
        return (jsonTokenMo9511f == JsonToken.END_OBJECT || jsonTokenMo9511f == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: f */
    public JsonToken mo9511f() throws IOException {
        if (this.f8918e == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object objM9503t = m9503t();
        if (objM9503t instanceof Iterator) {
            boolean z = this.f8917d[this.f8918e - 2] instanceof JsonObject;
            Iterator it = (Iterator) objM9503t;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            m9502a(it.next());
            return mo9511f();
        }
        if (objM9503t instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (objM9503t instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (objM9503t instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) objM9503t;
            if (jsonPrimitive.m9419q()) {
                return JsonToken.STRING;
            }
            if (jsonPrimitive.m9417a()) {
                return JsonToken.BOOLEAN;
            }
            if (jsonPrimitive.m9418p()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (objM9503t instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (objM9503t == f8916c) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: t */
    private Object m9503t() {
        return this.f8917d[this.f8918e - 1];
    }

    /* JADX INFO: renamed from: u */
    private Object m9504u() {
        Object[] objArr = this.f8917d;
        int i = this.f8918e - 1;
        this.f8918e = i;
        Object obj = objArr[i];
        this.f8917d[this.f8918e] = null;
        return obj;
    }

    /* JADX INFO: renamed from: a */
    private void m9501a(JsonToken jsonToken) throws IOException {
        if (mo9511f() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + mo9511f() + m9505v());
        }
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: g */
    public String mo9512g() throws IOException {
        m9501a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m9503t()).next();
        String str = (String) entry.getKey();
        this.f8919f[this.f8918e - 1] = str;
        m9502a(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: h */
    public String mo9513h() throws IOException {
        JsonToken jsonTokenMo9511f = mo9511f();
        if (jsonTokenMo9511f != JsonToken.STRING && jsonTokenMo9511f != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + jsonTokenMo9511f + m9505v());
        }
        String strMo9385c = ((JsonPrimitive) m9504u()).mo9385c();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return strMo9385c;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: i */
    public boolean mo9514i() throws IOException {
        m9501a(JsonToken.BOOLEAN);
        boolean zMo9389g = ((JsonPrimitive) m9504u()).mo9389g();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return zMo9389g;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: j */
    public void mo9515j() throws IOException {
        m9501a(JsonToken.NULL);
        m9504u();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: k */
    public double mo9516k() throws IOException {
        JsonToken jsonTokenMo9511f = mo9511f();
        if (jsonTokenMo9511f != JsonToken.NUMBER && jsonTokenMo9511f != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonTokenMo9511f + m9505v());
        }
        double dMo9386d = ((JsonPrimitive) m9503t()).mo9386d();
        if (!m9642q() && (Double.isNaN(dMo9386d) || Double.isInfinite(dMo9386d))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dMo9386d);
        }
        m9504u();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return dMo9386d;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: l */
    public long mo9517l() throws IOException {
        JsonToken jsonTokenMo9511f = mo9511f();
        if (jsonTokenMo9511f != JsonToken.NUMBER && jsonTokenMo9511f != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonTokenMo9511f + m9505v());
        }
        long jMo9387e = ((JsonPrimitive) m9503t()).mo9387e();
        m9504u();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return jMo9387e;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: m */
    public int mo9518m() throws IOException {
        JsonToken jsonTokenMo9511f = mo9511f();
        if (jsonTokenMo9511f != JsonToken.NUMBER && jsonTokenMo9511f != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonTokenMo9511f + m9505v());
        }
        int iMo9388f = ((JsonPrimitive) m9503t()).mo9388f();
        m9504u();
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return iMo9388f;
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8917d = new Object[]{f8916c};
        this.f8918e = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: n */
    public void mo9519n() throws IOException {
        if (mo9511f() == JsonToken.NAME) {
            mo9512g();
            this.f8919f[this.f8918e - 2] = "null";
        } else {
            m9504u();
            if (this.f8918e > 0) {
                this.f8919f[this.f8918e - 1] = "null";
            }
        }
        if (this.f8918e > 0) {
            int[] iArr = this.f8920g;
            int i = this.f8918e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: renamed from: o */
    public void m9520o() throws IOException {
        m9501a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m9503t()).next();
        m9502a(entry.getValue());
        m9502a(new JsonPrimitive((String) entry.getKey()));
    }

    /* JADX INFO: renamed from: a */
    private void m9502a(Object obj) {
        if (this.f8918e == this.f8917d.length) {
            Object[] objArr = new Object[this.f8918e * 2];
            int[] iArr = new int[this.f8918e * 2];
            String[] strArr = new String[this.f8918e * 2];
            System.arraycopy(this.f8917d, 0, objArr, 0, this.f8918e);
            System.arraycopy(this.f8920g, 0, iArr, 0, this.f8918e);
            System.arraycopy(this.f8919f, 0, strArr, 0, this.f8918e);
            this.f8917d = objArr;
            this.f8920g = iArr;
            this.f8919f = strArr;
        }
        Object[] objArr2 = this.f8917d;
        int i = this.f8918e;
        this.f8918e = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    /* JADX INFO: renamed from: p */
    public String mo9521p() {
        StringBuilder sbAppend = new StringBuilder().append('$');
        int i = 0;
        while (i < this.f8918e) {
            if (this.f8917d[i] instanceof JsonArray) {
                i++;
                if (this.f8917d[i] instanceof Iterator) {
                    sbAppend.append('[').append(this.f8920g[i]).append(']');
                }
            } else if (this.f8917d[i] instanceof JsonObject) {
                i++;
                if (this.f8917d[i] instanceof Iterator) {
                    sbAppend.append('.');
                    if (this.f8919f[i] != null) {
                        sbAppend.append(this.f8919f[i]);
                    }
                }
            }
            i++;
        }
        return sbAppend.toString();
    }

    /* JADX INFO: renamed from: v */
    private String m9505v() {
        return " at path " + mo9521p();
    }
}
