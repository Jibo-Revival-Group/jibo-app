package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a */
    private final Gson f8968a;

    /* JADX INFO: renamed from: b */
    private final TypeAdapter<T> f8969b;

    /* JADX INFO: renamed from: c */
    private final Type f8970c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f8968a = gson;
        this.f8969b = typeAdapter;
        this.f8970c = type;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        return this.f8969b.read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapterM9346a = this.f8969b;
        Type typeM9555a = m9555a(this.f8970c, t);
        if (typeM9555a != this.f8970c) {
            typeAdapterM9346a = this.f8968a.m9346a((TypeToken) TypeToken.get(typeM9555a));
            if ((typeAdapterM9346a instanceof ReflectiveTypeAdapterFactory.Adapter) && !(this.f8969b instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                typeAdapterM9346a = this.f8969b;
            }
        }
        typeAdapterM9346a.write(jsonWriter, t);
    }

    /* JADX INFO: renamed from: a */
    private Type m9555a(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return obj.getClass();
        }
        return type;
    }
}
