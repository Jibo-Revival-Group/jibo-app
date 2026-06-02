package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes.dex */
public final class TypeAdapters {

    /* JADX INFO: renamed from: a */
    public static final TypeAdapter<Class> f8997a = new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }.nullSafe();

    /* JADX INFO: renamed from: b */
    public static final TypeAdapterFactory f8998b = m9557a(Class.class, f8997a);

    /* JADX INFO: renamed from: c */
    public static final TypeAdapter<BitSet> f8999c = new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BitSet read(JsonReader jsonReader) throws IOException {
            boolean zMo9514i;
            BitSet bitSet = new BitSet();
            jsonReader.mo9506a();
            JsonToken jsonTokenMo9511f = jsonReader.mo9511f();
            int i = 0;
            while (jsonTokenMo9511f != JsonToken.END_ARRAY) {
                switch (C077936.f9039a[jsonTokenMo9511f.ordinal()]) {
                    case 1:
                        zMo9514i = jsonReader.mo9518m() != 0;
                        break;
                    case 2:
                        zMo9514i = jsonReader.mo9514i();
                        break;
                    case 3:
                        String strMo9513h = jsonReader.mo9513h();
                        try {
                            zMo9514i = Integer.parseInt(strMo9513h) != 0;
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + strMo9513h);
                        }
                        break;
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenMo9511f);
                }
                if (zMo9514i) {
                    bitSet.set(i);
                }
                i++;
                jsonTokenMo9511f = jsonReader.mo9511f();
            }
            jsonReader.mo9507b();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            jsonWriter.mo9530b();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.mo9525a(bitSet.get(i) ? 1 : 0);
            }
            jsonWriter.mo9532c();
        }
    }.nullSafe();

    /* JADX INFO: renamed from: d */
    public static final TypeAdapterFactory f9000d = m9557a(BitSet.class, f8999c);

    /* JADX INFO: renamed from: e */
    public static final TypeAdapter<Boolean> f9001e = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            if (jsonReader.mo9511f() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.mo9513h()));
            }
            return Boolean.valueOf(jsonReader.mo9514i());
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.mo9526a(bool);
        }
    };

    /* JADX INFO: renamed from: f */
    public static final TypeAdapter<Boolean> f9002f = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.mo9513h());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            jsonWriter.mo9531b(bool == null ? "null" : bool.toString());
        }
    };

    /* JADX INFO: renamed from: g */
    public static final TypeAdapterFactory f9003g = m9558a(Boolean.TYPE, Boolean.class, f9001e);

    /* JADX INFO: renamed from: h */
    public static final TypeAdapter<Number> f9004h = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.mo9518m());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.mo9527a(number);
        }
    };

    /* JADX INFO: renamed from: i */
    public static final TypeAdapterFactory f9005i = m9558a(Byte.TYPE, Byte.class, f9004h);

    /* JADX INFO: renamed from: j */
    public static final TypeAdapter<Number> f9006j = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.mo9518m());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.mo9527a(number);
        }
    };

    /* JADX INFO: renamed from: k */
    public static final TypeAdapterFactory f9007k = m9558a(Short.TYPE, Short.class, f9006j);

    /* JADX INFO: renamed from: l */
    public static final TypeAdapter<Number> f9008l = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.mo9518m());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.mo9527a(number);
        }
    };

    /* JADX INFO: renamed from: m */
    public static final TypeAdapterFactory f9009m = m9558a(Integer.TYPE, Integer.class, f9008l);

    /* JADX INFO: renamed from: n */
    public static final TypeAdapter<AtomicInteger> f9010n = new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicInteger read(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.mo9518m());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.mo9525a(atomicInteger.get());
        }
    }.nullSafe();

    /* JADX INFO: renamed from: o */
    public static final TypeAdapterFactory f9011o = m9557a(AtomicInteger.class, f9010n);

    /* JADX INFO: renamed from: p */
    public static final TypeAdapter<AtomicBoolean> f9012p = new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean read(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.mo9514i());
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.mo9529a(atomicBoolean.get());
        }
    }.nullSafe();

    /* JADX INFO: renamed from: q */
    public static final TypeAdapterFactory f9013q = m9557a(AtomicBoolean.class, f9012p);

    /* JADX INFO: renamed from: r */
    public static final TypeAdapter<AtomicIntegerArray> f9014r = new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
            ArrayList arrayList = new ArrayList();
            jsonReader.mo9506a();
            while (jsonReader.mo9510e()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.mo9518m()));
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }
            jsonReader.mo9507b();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.mo9530b();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.mo9525a(atomicIntegerArray.get(i));
            }
            jsonWriter.mo9532c();
        }
    }.nullSafe();

    /* JADX INFO: renamed from: s */
    public static final TypeAdapterFactory f9015s = m9557a(AtomicIntegerArray.class, f9014r);

    /* JADX INFO: renamed from: t */
    public static final TypeAdapter<Number> f9016t = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.mo9517l());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.mo9527a(number);
        }
    };

    /* JADX INFO: renamed from: u */
    public static final TypeAdapter<Number> f9017u = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.mo9516k());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.mo9527a(number);
        }
    };

    /* JADX INFO: renamed from: v */
    public static final TypeAdapter<Number> f9018v = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.mo9516k());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.mo9527a(number);
        }
    };

    /* JADX INFO: renamed from: w */
    public static final TypeAdapter<Number> f9019w = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Number read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenMo9511f = jsonReader.mo9511f();
            switch (C077936.f9039a[jsonTokenMo9511f.ordinal()]) {
                case 1:
                case 3:
                    return new LazilyParsedNumber(jsonReader.mo9513h());
                case 2:
                default:
                    throw new JsonSyntaxException("Expecting number, got: " + jsonTokenMo9511f);
                case 4:
                    jsonReader.mo9515j();
                    return null;
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.mo9527a(number);
        }
    };

    /* JADX INFO: renamed from: x */
    public static final TypeAdapterFactory f9020x = m9557a(Number.class, f9019w);

    /* JADX INFO: renamed from: y */
    public static final TypeAdapter<Character> f9021y = new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            String strMo9513h = jsonReader.mo9513h();
            if (strMo9513h.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + strMo9513h);
            }
            return Character.valueOf(strMo9513h.charAt(0));
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.mo9531b(ch == null ? null : String.valueOf(ch));
        }
    };

    /* JADX INFO: renamed from: z */
    public static final TypeAdapterFactory f9022z = m9558a(Character.TYPE, Character.class, f9021y);

    /* JADX INFO: renamed from: A */
    public static final TypeAdapter<String> f8971A = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenMo9511f = jsonReader.mo9511f();
            if (jsonTokenMo9511f == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            if (jsonTokenMo9511f == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.mo9514i());
            }
            return jsonReader.mo9513h();
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.mo9531b(str);
        }
    };

    /* JADX INFO: renamed from: B */
    public static final TypeAdapter<BigDecimal> f8972B = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigDecimal read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            try {
                return new BigDecimal(jsonReader.mo9513h());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.mo9527a(bigDecimal);
        }
    };

    /* JADX INFO: renamed from: C */
    public static final TypeAdapter<BigInteger> f8973C = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BigInteger read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            try {
                return new BigInteger(jsonReader.mo9513h());
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.mo9527a(bigInteger);
        }
    };

    /* JADX INFO: renamed from: D */
    public static final TypeAdapterFactory f8974D = m9557a(String.class, f8971A);

    /* JADX INFO: renamed from: E */
    public static final TypeAdapter<StringBuilder> f8975E = new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.mo9513h());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            jsonWriter.mo9531b(sb == null ? null : sb.toString());
        }
    };

    /* JADX INFO: renamed from: F */
    public static final TypeAdapterFactory f8976F = m9557a(StringBuilder.class, f8975E);

    /* JADX INFO: renamed from: G */
    public static final TypeAdapter<StringBuffer> f8977G = new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.mo9513h());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.mo9531b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };

    /* JADX INFO: renamed from: H */
    public static final TypeAdapterFactory f8978H = m9557a(StringBuffer.class, f8977G);

    /* JADX INFO: renamed from: I */
    public static final TypeAdapter<URL> f8979I = new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URL read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            String strMo9513h = jsonReader.mo9513h();
            if ("null".equals(strMo9513h)) {
                return null;
            }
            return new URL(strMo9513h);
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.mo9531b(url == null ? null : url.toExternalForm());
        }
    };

    /* JADX INFO: renamed from: J */
    public static final TypeAdapterFactory f8980J = m9557a(URL.class, f8979I);

    /* JADX INFO: renamed from: K */
    public static final TypeAdapter<URI> f8981K = new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public URI read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            try {
                String strMo9513h = jsonReader.mo9513h();
                if ("null".equals(strMo9513h)) {
                    return null;
                }
                return new URI(strMo9513h);
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.mo9531b(uri == null ? null : uri.toASCIIString());
        }
    };

    /* JADX INFO: renamed from: L */
    public static final TypeAdapterFactory f8982L = m9557a(URI.class, f8981K);

    /* JADX INFO: renamed from: M */
    public static final TypeAdapter<InetAddress> f8983M = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InetAddress read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.mo9513h());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.mo9531b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };

    /* JADX INFO: renamed from: N */
    public static final TypeAdapterFactory f8984N = m9559b(InetAddress.class, f8983M);

    /* JADX INFO: renamed from: O */
    public static final TypeAdapter<UUID> f8985O = new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.mo9513h());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.mo9531b(uuid == null ? null : uuid.toString());
        }
    };

    /* JADX INFO: renamed from: P */
    public static final TypeAdapterFactory f8986P = m9557a(UUID.class, f8985O);

    /* JADX INFO: renamed from: Q */
    public static final TypeAdapter<Currency> f8987Q = new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Currency read(JsonReader jsonReader) throws IOException {
            return Currency.getInstance(jsonReader.mo9513h());
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.mo9531b(currency.getCurrencyCode());
        }
    }.nullSafe();

    /* JADX INFO: renamed from: R */
    public static final TypeAdapterFactory f8988R = m9557a(Currency.class, f8987Q);

    /* JADX INFO: renamed from: S */
    public static final TypeAdapterFactory f8989S = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            final TypeAdapter<T> typeAdapterM9347a = gson.m9347a((Class) Date.class);
            return (TypeAdapter<T>) new TypeAdapter<Timestamp>() { // from class: com.google.gson.internal.bind.TypeAdapters.26.1
                @Override // com.google.gson.TypeAdapter
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Timestamp read(JsonReader jsonReader) throws IOException {
                    Date date = (Date) typeAdapterM9347a.read(jsonReader);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                    typeAdapterM9347a.write(jsonWriter, timestamp);
                }
            };
        }
    };

    /* JADX INFO: renamed from: T */
    public static final TypeAdapter<Calendar> f8990T = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar read(JsonReader jsonReader) throws IOException {
            int i = 0;
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            jsonReader.mo9508c();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (jsonReader.mo9511f() != JsonToken.END_OBJECT) {
                String strMo9512g = jsonReader.mo9512g();
                int iMo9518m = jsonReader.mo9518m();
                if ("year".equals(strMo9512g)) {
                    i6 = iMo9518m;
                } else if ("month".equals(strMo9512g)) {
                    i5 = iMo9518m;
                } else if ("dayOfMonth".equals(strMo9512g)) {
                    i4 = iMo9518m;
                } else if ("hourOfDay".equals(strMo9512g)) {
                    i3 = iMo9518m;
                } else if ("minute".equals(strMo9512g)) {
                    i2 = iMo9518m;
                } else if ("second".equals(strMo9512g)) {
                    i = iMo9518m;
                }
            }
            jsonReader.mo9509d();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            if (calendar == null) {
                jsonWriter.mo9535f();
                return;
            }
            jsonWriter.mo9533d();
            jsonWriter.mo9528a("year");
            jsonWriter.mo9525a(calendar.get(1));
            jsonWriter.mo9528a("month");
            jsonWriter.mo9525a(calendar.get(2));
            jsonWriter.mo9528a("dayOfMonth");
            jsonWriter.mo9525a(calendar.get(5));
            jsonWriter.mo9528a("hourOfDay");
            jsonWriter.mo9525a(calendar.get(11));
            jsonWriter.mo9528a("minute");
            jsonWriter.mo9525a(calendar.get(12));
            jsonWriter.mo9528a("second");
            jsonWriter.mo9525a(calendar.get(13));
            jsonWriter.mo9534e();
        }
    };

    /* JADX INFO: renamed from: U */
    public static final TypeAdapterFactory f8991U = m9560b(Calendar.class, GregorianCalendar.class, f8990T);

    /* JADX INFO: renamed from: V */
    public static final TypeAdapter<Locale> f8992V = new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Locale read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.mo9513h(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            if (strNextToken3 == null) {
                return new Locale(strNextToken, strNextToken2);
            }
            return new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.mo9531b(locale == null ? null : locale.toString());
        }
    };

    /* JADX INFO: renamed from: W */
    public static final TypeAdapterFactory f8993W = m9557a(Locale.class, f8992V);

    /* JADX INFO: renamed from: X */
    public static final TypeAdapter<JsonElement> f8994X = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.29
        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public JsonElement read(JsonReader jsonReader) throws IOException {
            switch (C077936.f9039a[jsonReader.mo9511f().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(jsonReader.mo9513h()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.mo9514i()));
                case 3:
                    return new JsonPrimitive(jsonReader.mo9513h());
                case 4:
                    jsonReader.mo9515j();
                    return JsonNull.f8819a;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    jsonReader.mo9506a();
                    while (jsonReader.mo9510e()) {
                        jsonArray.m9383a(read(jsonReader));
                    }
                    jsonReader.mo9507b();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.mo9508c();
                    while (jsonReader.mo9510e()) {
                        jsonObject.m9402a(jsonReader.mo9512g(), read(jsonReader));
                    }
                    jsonReader.mo9509d();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.m9394k()) {
                jsonWriter.mo9535f();
                return;
            }
            if (jsonElement.m9393j()) {
                JsonPrimitive jsonPrimitiveM9397n = jsonElement.m9397n();
                if (jsonPrimitiveM9397n.m9418p()) {
                    jsonWriter.mo9527a(jsonPrimitiveM9397n.mo9384b());
                    return;
                } else if (jsonPrimitiveM9397n.m9417a()) {
                    jsonWriter.mo9529a(jsonPrimitiveM9397n.mo9389g());
                    return;
                } else {
                    jsonWriter.mo9531b(jsonPrimitiveM9397n.mo9385c());
                    return;
                }
            }
            if (jsonElement.m9391h()) {
                jsonWriter.mo9530b();
                Iterator<JsonElement> it = jsonElement.m9396m().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.mo9532c();
                return;
            }
            if (jsonElement.m9392i()) {
                jsonWriter.mo9533d();
                for (Map.Entry<String, JsonElement> entry : jsonElement.m9395l().m9401a()) {
                    jsonWriter.mo9528a(entry.getKey());
                    write(jsonWriter, entry.getValue());
                }
                jsonWriter.mo9534e();
                return;
            }
            throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
        }
    };

    /* JADX INFO: renamed from: Y */
    public static final TypeAdapterFactory f8995Y = m9559b(JsonElement.class, f8994X);

    /* JADX INFO: renamed from: Z */
    public static final TypeAdapterFactory f8996Z = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new EnumTypeAdapter(rawType);
        }
    };

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$36 */
    static /* synthetic */ class C077936 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f9039a = new int[JsonToken.values().length];

        static {
            try {
                f9039a[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9039a[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9039a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9039a[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9039a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9039a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9039a[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f9039a[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f9039a[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f9039a[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a */
        private final Map<String, T> f9040a = new HashMap();

        /* JADX INFO: renamed from: b */
        private final Map<T, String> f9041b = new HashMap();

        public EnumTypeAdapter(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String strName = t.name();
                    SerializedName serializedName = (SerializedName) cls.getField(strName).getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.m9428a();
                        String[] strArrM9429b = serializedName.m9429b();
                        for (String str : strArrM9429b) {
                            this.f9040a.put(str, t);
                        }
                    }
                    String str2 = strName;
                    this.f9040a.put(str2, t);
                    this.f9041b.put(t, str2);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() != JsonToken.NULL) {
                return this.f9040a.get(jsonReader.mo9513h());
            }
            jsonReader.mo9515j();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            jsonWriter.mo9531b(t == null ? null : this.f9041b.get(t));
        }
    }

    /* JADX INFO: renamed from: a */
    public static <TT> TypeAdapterFactory m9556a(final TypeToken<TT> typeToken, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.TypeAdapterFactory
            /* JADX INFO: renamed from: a */
            public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken2) {
                if (typeToken2.equals(typeToken)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static <TT> TypeAdapterFactory m9557a(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.TypeAdapterFactory
            /* JADX INFO: renamed from: a */
            public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    /* JADX INFO: renamed from: a */
    public static <TT> TypeAdapterFactory m9558a(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.TypeAdapterFactory
            /* JADX INFO: renamed from: a */
            public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    /* JADX INFO: renamed from: b */
    public static <TT> TypeAdapterFactory m9560b(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.TypeAdapterFactory
            /* JADX INFO: renamed from: a */
            public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    /* JADX INFO: renamed from: b */
    public static <T1> TypeAdapterFactory m9559b(final Class<T1> cls, final TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.35
            @Override // com.google.gson.TypeAdapterFactory
            /* JADX INFO: renamed from: a */
            public <T2> TypeAdapter<T2> mo9423a(Gson gson, TypeToken<T2> typeToken) {
                final Class<? super T2> rawType = typeToken.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return (TypeAdapter<T2>) new TypeAdapter<T1>() { // from class: com.google.gson.internal.bind.TypeAdapters.35.1
                        @Override // com.google.gson.TypeAdapter
                        public void write(JsonWriter jsonWriter, T1 t1) throws IOException {
                            typeAdapter.write(jsonWriter, t1);
                        }

                        @Override // com.google.gson.TypeAdapter
                        public T1 read(JsonReader jsonReader) throws IOException {
                            T1 t1 = (T1) typeAdapter.read(jsonReader);
                            if (t1 != null && !rawType.isInstance(t1)) {
                                throw new JsonSyntaxException("Expected a " + rawType.getName() + " but was " + t1.getClass().getName());
                            }
                            return t1;
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
