package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a */
    public static final TypeAdapterFactory f8905a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeM9453g = C$Gson$Types.m9453g(type);
            return new ArrayTypeAdapter(gson, gson.m9346a((TypeToken) TypeToken.get(typeM9453g)), C$Gson$Types.m9451e(typeM9453g));
        }
    };

    /* JADX INFO: renamed from: b */
    private final Class<E> f8906b;

    /* JADX INFO: renamed from: c */
    private final TypeAdapter<E> f8907c;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f8907c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f8906b = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.mo9506a();
        while (jsonReader.mo9510e()) {
            arrayList.add(this.f8907c.read(jsonReader));
        }
        jsonReader.mo9507b();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f8906b, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo9535f();
            return;
        }
        jsonWriter.mo9530b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f8907c.write(jsonWriter, (E) Array.get(obj, i));
        }
        jsonWriter.mo9532c();
    }
}
