package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class Gson {

    /* JADX INFO: renamed from: a */
    private static final TypeToken<?> f8784a = TypeToken.get(Object.class);

    /* JADX INFO: renamed from: b */
    private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> f8785b;

    /* JADX INFO: renamed from: c */
    private final Map<TypeToken<?>, TypeAdapter<?>> f8786c;

    /* JADX INFO: renamed from: d */
    private final List<TypeAdapterFactory> f8787d;

    /* JADX INFO: renamed from: e */
    private final ConstructorConstructor f8788e;

    /* JADX INFO: renamed from: f */
    private final Excluder f8789f;

    /* JADX INFO: renamed from: g */
    private final FieldNamingStrategy f8790g;

    /* JADX INFO: renamed from: h */
    private final boolean f8791h;

    /* JADX INFO: renamed from: i */
    private final boolean f8792i;

    /* JADX INFO: renamed from: j */
    private final boolean f8793j;

    /* JADX INFO: renamed from: k */
    private final boolean f8794k;

    /* JADX INFO: renamed from: l */
    private final boolean f8795l;

    /* JADX INFO: renamed from: m */
    private final JsonAdapterAnnotationTypeAdapterFactory f8796m;

    public Gson() {
        this(Excluder.f8855a, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map<Type, InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LongSerializationPolicy longSerializationPolicy, List<TypeAdapterFactory> list) {
        this.f8785b = new ThreadLocal<>();
        this.f8786c = new ConcurrentHashMap();
        this.f8788e = new ConstructorConstructor(map);
        this.f8789f = excluder;
        this.f8790g = fieldNamingStrategy;
        this.f8791h = z;
        this.f8793j = z3;
        this.f8792i = z4;
        this.f8794k = z5;
        this.f8795l = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.f8995Y);
        arrayList.add(ObjectTypeAdapter.f8932a);
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(TypeAdapters.f8974D);
        arrayList.add(TypeAdapters.f9009m);
        arrayList.add(TypeAdapters.f9003g);
        arrayList.add(TypeAdapters.f9005i);
        arrayList.add(TypeAdapters.f9007k);
        TypeAdapter<Number> typeAdapterM9336a = m9336a(longSerializationPolicy);
        arrayList.add(TypeAdapters.m9558a(Long.TYPE, Long.class, typeAdapterM9336a));
        arrayList.add(TypeAdapters.m9558a(Double.TYPE, Double.class, m9338a(z7)));
        arrayList.add(TypeAdapters.m9558a(Float.TYPE, Float.class, m9342b(z7)));
        arrayList.add(TypeAdapters.f9020x);
        arrayList.add(TypeAdapters.f9011o);
        arrayList.add(TypeAdapters.f9013q);
        arrayList.add(TypeAdapters.m9557a(AtomicLong.class, m9337a(typeAdapterM9336a)));
        arrayList.add(TypeAdapters.m9557a(AtomicLongArray.class, m9341b(typeAdapterM9336a)));
        arrayList.add(TypeAdapters.f9015s);
        arrayList.add(TypeAdapters.f9022z);
        arrayList.add(TypeAdapters.f8976F);
        arrayList.add(TypeAdapters.f8978H);
        arrayList.add(TypeAdapters.m9557a(BigDecimal.class, TypeAdapters.f8972B));
        arrayList.add(TypeAdapters.m9557a(BigInteger.class, TypeAdapters.f8973C));
        arrayList.add(TypeAdapters.f8980J);
        arrayList.add(TypeAdapters.f8982L);
        arrayList.add(TypeAdapters.f8986P);
        arrayList.add(TypeAdapters.f8988R);
        arrayList.add(TypeAdapters.f8993W);
        arrayList.add(TypeAdapters.f8984N);
        arrayList.add(TypeAdapters.f9000d);
        arrayList.add(DateTypeAdapter.f8911a);
        arrayList.add(TypeAdapters.f8991U);
        arrayList.add(TimeTypeAdapter.f8953a);
        arrayList.add(SqlDateTypeAdapter.f8951a);
        arrayList.add(TypeAdapters.f8989S);
        arrayList.add(ArrayTypeAdapter.f8905a);
        arrayList.add(TypeAdapters.f8998b);
        arrayList.add(new CollectionTypeAdapterFactory(this.f8788e));
        arrayList.add(new MapTypeAdapterFactory(this.f8788e, z2));
        this.f8796m = new JsonAdapterAnnotationTypeAdapterFactory(this.f8788e);
        arrayList.add(this.f8796m);
        arrayList.add(TypeAdapters.f8996Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(this.f8788e, fieldNamingStrategy, excluder, this.f8796m));
        this.f8787d = Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: a */
    private TypeAdapter<Number> m9338a(boolean z) {
        return z ? TypeAdapters.f9018v : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Double read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo9511f() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.mo9516k());
                }
                jsonReader.mo9515j();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.mo9535f();
                } else {
                    Gson.m9339a(number.doubleValue());
                    jsonWriter.mo9527a(number);
                }
            }
        };
    }

    /* JADX INFO: renamed from: b */
    private TypeAdapter<Number> m9342b(boolean z) {
        return z ? TypeAdapters.f9017u : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo9511f() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.mo9516k());
                }
                jsonReader.mo9515j();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.mo9535f();
                } else {
                    Gson.m9339a(number.floatValue());
                    jsonWriter.mo9527a(number);
                }
            }
        };
    }

    /* JADX INFO: renamed from: a */
    static void m9339a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* JADX INFO: renamed from: a */
    private static TypeAdapter<Number> m9336a(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? TypeAdapters.f9016t : new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.mo9511f() != JsonToken.NULL) {
                    return Long.valueOf(jsonReader.mo9517l());
                }
                jsonReader.mo9515j();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.mo9535f();
                } else {
                    jsonWriter.mo9531b(number.toString());
                }
            }
        };
    }

    /* JADX INFO: renamed from: a */
    private static TypeAdapter<AtomicLong> m9337a(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLong>() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                typeAdapter.write(jsonWriter, Long.valueOf(atomicLong.get()));
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                return new AtomicLong(((Number) typeAdapter.read(jsonReader)).longValue());
            }
        }.nullSafe();
    }

    /* JADX INFO: renamed from: b */
    private static TypeAdapter<AtomicLongArray> m9341b(final TypeAdapter<Number> typeAdapter) {
        return new TypeAdapter<AtomicLongArray>() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                jsonWriter.mo9530b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    typeAdapter.write(jsonWriter, Long.valueOf(atomicLongArray.get(i)));
                }
                jsonWriter.mo9532c();
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.mo9506a();
                while (jsonReader.mo9510e()) {
                    arrayList.add(Long.valueOf(((Number) typeAdapter.read(jsonReader)).longValue()));
                }
                jsonReader.mo9507b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe();
    }

    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> m9346a(TypeToken<T> typeToken) {
        Map map;
        TypeAdapter<T> typeAdapterMo9423a = (TypeAdapter) this.f8786c.get(typeToken == null ? f8784a : typeToken);
        if (typeAdapterMo9423a == null) {
            Map<TypeToken<?>, FutureTypeAdapter<?>> map2 = this.f8785b.get();
            boolean z = false;
            if (map2 == null) {
                HashMap map3 = new HashMap();
                this.f8785b.set(map3);
                map = map3;
                z = true;
            } else {
                map = map2;
            }
            typeAdapterMo9423a = (FutureTypeAdapter) map.get(typeToken);
            if (typeAdapterMo9423a == null) {
                try {
                    FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
                    map.put(typeToken, futureTypeAdapter);
                    Iterator<TypeAdapterFactory> it = this.f8787d.iterator();
                    while (it.hasNext()) {
                        typeAdapterMo9423a = it.next().mo9423a(this, typeToken);
                        if (typeAdapterMo9423a != null) {
                            futureTypeAdapter.m9374a(typeAdapterMo9423a);
                            this.f8786c.put(typeToken, typeAdapterMo9423a);
                            map.remove(typeToken);
                            if (z) {
                                this.f8785b.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + typeToken);
                } catch (Throwable th) {
                    map.remove(typeToken);
                    if (z) {
                        this.f8785b.remove();
                    }
                    throw th;
                }
            }
        }
        return typeAdapterMo9423a;
    }

    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> m9345a(TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken) {
        if (!this.f8787d.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.f8796m;
        }
        boolean z = false;
        for (TypeAdapterFactory typeAdapterFactory2 : this.f8787d) {
            if (!z) {
                if (typeAdapterFactory2 == typeAdapterFactory) {
                    z = true;
                }
            } else {
                TypeAdapter<T> typeAdapterMo9423a = typeAdapterFactory2.mo9423a(this, typeToken);
                if (typeAdapterMo9423a != null) {
                    return typeAdapterMo9423a;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> m9347a(Class<T> cls) {
        return m9346a((TypeToken) TypeToken.get((Class) cls));
    }

    /* JADX INFO: renamed from: a */
    public JsonElement m9343a(Object obj) {
        return obj == null ? JsonNull.f8819a : m9344a(obj, obj.getClass());
    }

    /* JADX INFO: renamed from: a */
    public JsonElement m9344a(Object obj, Type type) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        m9360a(obj, type, jsonTreeWriter);
        return jsonTreeWriter.m9524a();
    }

    /* JADX INFO: renamed from: b */
    public String m9362b(Object obj) {
        return obj == null ? m9357a((JsonElement) JsonNull.f8819a) : m9363b(obj, obj.getClass());
    }

    /* JADX INFO: renamed from: b */
    public String m9363b(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        m9361a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    /* JADX INFO: renamed from: a */
    public void m9361a(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            m9360a(obj, type, m9349a(Streams.m9490a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9360a(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter typeAdapterM9346a = m9346a((TypeToken) TypeToken.get(type));
        boolean zM9659g = jsonWriter.m9659g();
        jsonWriter.m9655b(true);
        boolean zM9660h = jsonWriter.m9660h();
        jsonWriter.m9657c(this.f8792i);
        boolean zM9661i = jsonWriter.m9661i();
        jsonWriter.m9658d(this.f8791h);
        try {
            try {
                typeAdapterM9346a.write(jsonWriter, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            jsonWriter.m9655b(zM9659g);
            jsonWriter.m9657c(zM9660h);
            jsonWriter.m9658d(zM9661i);
        }
    }

    /* JADX INFO: renamed from: a */
    public String m9357a(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        m9359a(jsonElement, stringWriter);
        return stringWriter.toString();
    }

    /* JADX INFO: renamed from: a */
    public void m9359a(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            m9358a(jsonElement, m9349a(Streams.m9490a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public JsonWriter m9349a(Writer writer) throws IOException {
        if (this.f8793j) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.f8794k) {
            jsonWriter.m9656c("  ");
        }
        jsonWriter.m9658d(this.f8791h);
        return jsonWriter;
    }

    /* JADX INFO: renamed from: a */
    public JsonReader m9348a(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.m9641a(this.f8795l);
        return jsonReader;
    }

    /* JADX INFO: renamed from: a */
    public void m9358a(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean zM9659g = jsonWriter.m9659g();
        jsonWriter.m9655b(true);
        boolean zM9660h = jsonWriter.m9660h();
        jsonWriter.m9657c(this.f8792i);
        boolean zM9661i = jsonWriter.m9661i();
        jsonWriter.m9658d(this.f8791h);
        try {
            try {
                Streams.m9491a(jsonElement, jsonWriter);
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        } finally {
            jsonWriter.m9655b(zM9659g);
            jsonWriter.m9657c(zM9660h);
            jsonWriter.m9658d(zM9661i);
        }
    }

    /* JADX INFO: renamed from: a */
    public <T> T m9355a(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) Primitives.m9486a((Class) cls).cast(m9356a(str, (Type) cls));
    }

    /* JADX INFO: renamed from: a */
    public <T> T m9356a(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) m9354a((Reader) new StringReader(str), type);
    }

    /* JADX INFO: renamed from: a */
    public <T> T m9353a(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReaderM9348a = m9348a(reader);
        Object objM9352a = m9352a(jsonReaderM9348a, (Type) cls);
        m9340a(objM9352a, jsonReaderM9348a);
        return (T) Primitives.m9486a((Class) cls).cast(objM9352a);
    }

    /* JADX INFO: renamed from: a */
    public <T> T m9354a(Reader reader, Type type) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReaderM9348a = m9348a(reader);
        T t = (T) m9352a(jsonReaderM9348a, type);
        m9340a(t, jsonReaderM9348a);
        return t;
    }

    /* JADX INFO: renamed from: a */
    private static void m9340a(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.mo9511f() != JsonToken.END_DOCUMENT) {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public <T> T m9352a(JsonReader jsonReader, Type type) throws JsonSyntaxException, JsonIOException {
        boolean z = true;
        boolean zM9642q = jsonReader.m9642q();
        jsonReader.m9641a(true);
        try {
            try {
                jsonReader.mo9511f();
                z = false;
                T t = m9346a((TypeToken) TypeToken.get(type)).read(jsonReader);
                jsonReader.m9641a(zM9642q);
                return t;
            } catch (EOFException e) {
                if (!z) {
                    throw new JsonSyntaxException(e);
                }
                jsonReader.m9641a(zM9642q);
                return null;
            } catch (IOException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        } catch (Throwable th) {
            jsonReader.m9641a(zM9642q);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public <T> T m9350a(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) Primitives.m9486a((Class) cls).cast(m9351a(jsonElement, (Type) cls));
    }

    /* JADX INFO: renamed from: a */
    public <T> T m9351a(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) m9352a((JsonReader) new JsonTreeReader(jsonElement), type);
    }

    static class FutureTypeAdapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a */
        private TypeAdapter<T> f8801a;

        FutureTypeAdapter() {
        }

        /* JADX INFO: renamed from: a */
        public void m9374a(TypeAdapter<T> typeAdapter) {
            if (this.f8801a != null) {
                throw new AssertionError();
            }
            this.f8801a = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (this.f8801a == null) {
                throw new IllegalStateException();
            }
            return this.f8801a.read(jsonReader);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (this.f8801a == null) {
                throw new IllegalStateException();
            }
            this.f8801a.write(jsonWriter, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f8791h + ",factories:" + this.f8787d + ",instanceCreators:" + this.f8788e + "}";
    }
}
