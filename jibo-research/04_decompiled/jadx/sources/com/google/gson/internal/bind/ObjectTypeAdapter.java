package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a */
    public static final TypeAdapterFactory f8932a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b */
    private final Gson f8933b;

    ObjectTypeAdapter(Gson gson) {
        this.f8933b = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        switch (jsonReader.mo9511f()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                jsonReader.mo9506a();
                while (jsonReader.mo9510e()) {
                    arrayList.add(read(jsonReader));
                }
                jsonReader.mo9507b();
                return arrayList;
            case BEGIN_OBJECT:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.mo9508c();
                while (jsonReader.mo9510e()) {
                    linkedTreeMap.put(jsonReader.mo9512g(), read(jsonReader));
                }
                jsonReader.mo9509d();
                return linkedTreeMap;
            case STRING:
                return jsonReader.mo9513h();
            case NUMBER:
                return Double.valueOf(jsonReader.mo9516k());
            case BOOLEAN:
                return Boolean.valueOf(jsonReader.mo9514i());
            case NULL:
                jsonReader.mo9515j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo9535f();
            return;
        }
        TypeAdapter typeAdapterM9347a = this.f8933b.m9347a((Class) obj.getClass());
        if (typeAdapterM9347a instanceof ObjectTypeAdapter) {
            jsonWriter.mo9533d();
            jsonWriter.mo9534e();
        } else {
            typeAdapterM9347a.write(jsonWriter, obj);
        }
    }
}
