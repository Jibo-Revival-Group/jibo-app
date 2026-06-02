package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a */
    final Gson f8955a;

    /* JADX INFO: renamed from: b */
    private final JsonSerializer<T> f8956b;

    /* JADX INFO: renamed from: c */
    private final JsonDeserializer<T> f8957c;

    /* JADX INFO: renamed from: d */
    private final TypeToken<T> f8958d;

    /* JADX INFO: renamed from: e */
    private final TypeAdapterFactory f8959e;

    /* JADX INFO: renamed from: f */
    private final TreeTypeAdapter<T>.GsonContextImpl f8960f = new GsonContextImpl();

    /* JADX INFO: renamed from: g */
    private TypeAdapter<T> f8961g;

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory typeAdapterFactory) {
        this.f8956b = jsonSerializer;
        this.f8957c = jsonDeserializer;
        this.f8955a = gson;
        this.f8958d = typeToken;
        this.f8959e = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.f8957c == null) {
            return m9552a().read(jsonReader);
        }
        JsonElement jsonElementM9489a = Streams.m9489a(jsonReader);
        if (jsonElementM9489a.m9394k()) {
            return null;
        }
        return this.f8957c.deserialize(jsonElementM9489a, this.f8958d.getType(), this.f8960f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        if (this.f8956b == null) {
            m9552a().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.mo9535f();
        } else {
            Streams.m9491a(this.f8956b.mo9422a(t, this.f8958d.getType(), this.f8960f), jsonWriter);
        }
    }

    /* JADX INFO: renamed from: a */
    private TypeAdapter<T> m9552a() {
        TypeAdapter<T> typeAdapter = this.f8961g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> typeAdapterM9345a = this.f8955a.m9345a(this.f8959e, this.f8958d);
        this.f8961g = typeAdapterM9345a;
        return typeAdapterM9345a;
    }

    /* JADX INFO: renamed from: a */
    public static TypeAdapterFactory m9553a(TypeToken<?> typeToken, Object obj) {
        return new SingleTypeFactory(obj, typeToken, typeToken.getType() == typeToken.getRawType(), null);
    }

    /* JADX INFO: renamed from: a */
    public static TypeAdapterFactory m9554a(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    private static final class SingleTypeFactory implements TypeAdapterFactory {

        /* JADX INFO: renamed from: a */
        private final TypeToken<?> f8963a;

        /* JADX INFO: renamed from: b */
        private final boolean f8964b;

        /* JADX INFO: renamed from: c */
        private final Class<?> f8965c;

        /* JADX INFO: renamed from: d */
        private final JsonSerializer<?> f8966d;

        /* JADX INFO: renamed from: e */
        private final JsonDeserializer<?> f8967e;

        SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            this.f8966d = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.f8967e = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            C$Gson$Preconditions.m9433a((this.f8966d == null && this.f8967e == null) ? false : true);
            this.f8963a = typeToken;
            this.f8964b = z;
            this.f8965c = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            boolean zIsAssignableFrom;
            if (this.f8963a != null) {
                zIsAssignableFrom = this.f8963a.equals(typeToken) || (this.f8964b && this.f8963a.getType() == typeToken.getRawType());
            } else {
                zIsAssignableFrom = this.f8965c.isAssignableFrom(typeToken.getRawType());
            }
            if (zIsAssignableFrom) {
                return new TreeTypeAdapter(this.f8966d, this.f8967e, gson, typeToken, this);
            }
            return null;
        }
    }

    private final class GsonContextImpl implements JsonDeserializationContext, JsonSerializationContext {
        private GsonContextImpl() {
        }

        @Override // com.google.gson.JsonSerializationContext
        /* JADX INFO: renamed from: a */
        public JsonElement mo9420a(Object obj) {
            return TreeTypeAdapter.this.f8955a.m9343a(obj);
        }

        @Override // com.google.gson.JsonSerializationContext
        /* JADX INFO: renamed from: a */
        public JsonElement mo9421a(Object obj, Type type) {
            return TreeTypeAdapter.this.f8955a.m9344a(obj, type);
        }

        @Override // com.google.gson.JsonDeserializationContext
        /* JADX INFO: renamed from: a */
        public <R> R mo9390a(JsonElement jsonElement, Type type) throws JsonParseException {
            return (R) TreeTypeAdapter.this.f8955a.m9351a(jsonElement, type);
        }
    }
}
