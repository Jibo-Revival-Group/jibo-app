package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a */
    final boolean f8926a;

    /* JADX INFO: renamed from: b */
    private final ConstructorConstructor f8927b;

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z) {
        this.f8927b = constructorConstructor;
        this.f8926a = z;
    }

    @Override // com.google.gson.TypeAdapterFactory
    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] typeArrM9448b = C$Gson$Types.m9448b(type, C$Gson$Types.m9451e(type));
        return new Adapter(gson, typeArrM9448b[0], m9536a(gson, typeArrM9448b[0]), typeArrM9448b[1], gson.m9346a((TypeToken) TypeToken.get(typeArrM9448b[1])), this.f8927b.m9458a(typeToken));
    }

    /* JADX INFO: renamed from: a */
    private TypeAdapter<?> m9536a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f9002f : gson.m9346a((TypeToken) TypeToken.get(type));
    }

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* JADX INFO: renamed from: b */
        private final TypeAdapter<K> f8929b;

        /* JADX INFO: renamed from: c */
        private final TypeAdapter<V> f8930c;

        /* JADX INFO: renamed from: d */
        private final ObjectConstructor<? extends Map<K, V>> f8931d;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.f8929b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f8930c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f8931d = objectConstructor;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<K, V> read(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenMo9511f = jsonReader.mo9511f();
            if (jsonTokenMo9511f == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            Map<K, V> mapMo9459a = this.f8931d.mo9459a();
            if (jsonTokenMo9511f == JsonToken.BEGIN_ARRAY) {
                jsonReader.mo9506a();
                while (jsonReader.mo9510e()) {
                    jsonReader.mo9506a();
                    K k = this.f8929b.read(jsonReader);
                    if (mapMo9459a.put(k, this.f8930c.read(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + k);
                    }
                    jsonReader.mo9507b();
                }
                jsonReader.mo9507b();
                return mapMo9459a;
            }
            jsonReader.mo9508c();
            while (jsonReader.mo9510e()) {
                JsonReaderInternalAccess.f8868a.mo9470a(jsonReader);
                K k2 = this.f8929b.read(jsonReader);
                if (mapMo9459a.put(k2, this.f8930c.read(jsonReader)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + k2);
                }
            }
            jsonReader.mo9509d();
            return mapMo9459a;
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(JsonWriter jsonWriter, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                jsonWriter.mo9535f();
                return;
            }
            if (!MapTypeAdapterFactory.this.f8926a) {
                jsonWriter.mo9533d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.mo9528a(String.valueOf(entry.getKey()));
                    this.f8930c.write(jsonWriter, entry.getValue());
                }
                jsonWriter.mo9534e();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                JsonElement jsonTree = this.f8929b.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z = (jsonTree.m9391h() || jsonTree.m9392i()) | z;
            }
            if (z) {
                jsonWriter.mo9530b();
                int size = arrayList.size();
                while (i < size) {
                    jsonWriter.mo9530b();
                    Streams.m9491a((JsonElement) arrayList.get(i), jsonWriter);
                    this.f8930c.write(jsonWriter, (V) arrayList2.get(i));
                    jsonWriter.mo9532c();
                    i++;
                }
                jsonWriter.mo9532c();
                return;
            }
            jsonWriter.mo9533d();
            int size2 = arrayList.size();
            while (i < size2) {
                jsonWriter.mo9528a(m9537a((JsonElement) arrayList.get(i)));
                this.f8930c.write(jsonWriter, (V) arrayList2.get(i));
                i++;
            }
            jsonWriter.mo9534e();
        }

        /* JADX INFO: renamed from: a */
        private String m9537a(JsonElement jsonElement) {
            if (jsonElement.m9393j()) {
                JsonPrimitive jsonPrimitiveM9397n = jsonElement.m9397n();
                if (jsonPrimitiveM9397n.m9418p()) {
                    return String.valueOf(jsonPrimitiveM9397n.mo9384b());
                }
                if (jsonPrimitiveM9397n.m9417a()) {
                    return Boolean.toString(jsonPrimitiveM9397n.mo9389g());
                }
                if (jsonPrimitiveM9397n.m9419q()) {
                    return jsonPrimitiveM9397n.mo9385c();
                }
                throw new AssertionError();
            }
            if (jsonElement.m9394k()) {
                return "null";
            }
            throw new AssertionError();
        }
    }
}
