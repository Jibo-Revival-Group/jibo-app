package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a */
    private final ConstructorConstructor f8914a;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f8914a = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) m9500a(this.f8914a, gson, typeToken, jsonAdapter);
    }

    /* JADX INFO: renamed from: a */
    TypeAdapter<?> m9500a(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> treeTypeAdapter;
        Object objMo9459a = constructorConstructor.m9458a(TypeToken.get((Class) jsonAdapter.m9426a())).mo9459a();
        if (objMo9459a instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) objMo9459a;
        } else if (objMo9459a instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) objMo9459a).mo9423a(gson, typeToken);
        } else if ((objMo9459a instanceof JsonSerializer) || (objMo9459a instanceof JsonDeserializer)) {
            treeTypeAdapter = new TreeTypeAdapter<>(objMo9459a instanceof JsonSerializer ? (JsonSerializer) objMo9459a : null, objMo9459a instanceof JsonDeserializer ? (JsonDeserializer) objMo9459a : null, gson, typeToken, null);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objMo9459a.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (treeTypeAdapter != null && jsonAdapter.m9427b()) {
            return treeTypeAdapter.nullSafe();
        }
        return treeTypeAdapter;
    }
}
