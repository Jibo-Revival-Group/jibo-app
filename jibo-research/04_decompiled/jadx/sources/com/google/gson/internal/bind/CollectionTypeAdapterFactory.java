package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a */
    private final ConstructorConstructor f8908a;

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f8908a = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeM9439a = C$Gson$Types.m9439a(type, (Class<?>) rawType);
        return new Adapter(gson, typeM9439a, gson.m9346a((TypeToken) TypeToken.get(typeM9439a)), this.f8908a.m9458a(typeToken));
    }

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* JADX INFO: renamed from: a */
        private final TypeAdapter<E> f8909a;

        /* JADX INFO: renamed from: b */
        private final ObjectConstructor<? extends Collection<E>> f8910b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.f8909a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f8910b = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<E> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            Collection<E> collectionMo9459a = this.f8910b.mo9459a();
            jsonReader.mo9506a();
            while (jsonReader.mo9510e()) {
                collectionMo9459a.add(this.f8909a.read(jsonReader));
            }
            jsonReader.mo9507b();
            return collectionMo9459a;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.mo9535f();
                return;
            }
            jsonWriter.mo9530b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f8909a.write(jsonWriter, it.next());
            }
            jsonWriter.mo9532c();
        }
    }
}
