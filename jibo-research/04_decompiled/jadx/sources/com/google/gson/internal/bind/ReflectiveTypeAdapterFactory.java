package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a */
    private final ConstructorConstructor f8935a;

    /* JADX INFO: renamed from: b */
    private final FieldNamingStrategy f8936b;

    /* JADX INFO: renamed from: c */
    private final Excluder f8937c;

    /* JADX INFO: renamed from: d */
    private final JsonAdapterAnnotationTypeAdapterFactory f8938d;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f8935a = constructorConstructor;
        this.f8936b = fieldNamingStrategy;
        this.f8937c = excluder;
        this.f8938d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9544a(Field field, boolean z) {
        return m9543a(field, z, this.f8937c);
    }

    /* JADX INFO: renamed from: a */
    static boolean m9543a(Field field, boolean z, Excluder excluder) {
        return (excluder.m9467a(field.getType(), z) || excluder.m9468a(field, z)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private List<String> m9541a(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.f8936b.translateName(field));
        }
        String strM9428a = serializedName.m9428a();
        String[] strArrM9429b = serializedName.m9429b();
        if (strArrM9429b.length == 0) {
            return Collections.singletonList(strM9428a);
        }
        ArrayList arrayList = new ArrayList(strArrM9429b.length + 1);
        arrayList.add(strM9428a);
        for (String str : strArrM9429b) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    /* JADX INFO: renamed from: a */
    public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new Adapter(this.f8935a.m9458a(typeToken), m9542a(gson, (TypeToken<?>) typeToken, (Class<?>) rawType));
    }

    /* JADX INFO: renamed from: a */
    private BoundField m9540a(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z, boolean z2) {
        final boolean zM9488a = Primitives.m9488a((Type) typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        final TypeAdapter<?> typeAdapterM9346a = null;
        if (jsonAdapter != null) {
            typeAdapterM9346a = this.f8938d.m9500a(this.f8935a, gson, typeToken, jsonAdapter);
        }
        final boolean z3 = typeAdapterM9346a != null;
        if (typeAdapterM9346a == null) {
            typeAdapterM9346a = gson.m9346a((TypeToken) typeToken);
        }
        return new BoundField(str, z, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            /* JADX INFO: renamed from: a */
            void mo9546a(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
                (z3 ? typeAdapterM9346a : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapterM9346a, typeToken.getType())).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            /* JADX INFO: renamed from: a */
            void mo9545a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException {
                Object obj2 = typeAdapterM9346a.read(jsonReader);
                if (obj2 != null || !zM9488a) {
                    field.set(obj, obj2);
                }
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            /* JADX INFO: renamed from: a */
            public boolean mo9547a(Object obj) throws IllegalAccessException, IOException {
                return this.f8949i && field.get(obj) != obj;
            }
        };
    }

    /* JADX INFO: renamed from: a */
    private Map<String, BoundField> m9542a(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean zM9544a = m9544a(field, true);
                boolean zM9544a2 = m9544a(field, false);
                if (zM9544a || zM9544a2) {
                    field.setAccessible(true);
                    Type typeM9441a = C$Gson$Types.m9441a(typeToken.getType(), cls, field.getGenericType());
                    List<String> listM9541a = m9541a(field);
                    BoundField boundField = null;
                    int size = listM9541a.size();
                    int i = 0;
                    while (i < size) {
                        String str = listM9541a.get(i);
                        if (i != 0) {
                            zM9544a = false;
                        }
                        BoundField boundField2 = (BoundField) linkedHashMap.put(str, m9540a(gson, field, str, TypeToken.get(typeM9441a), zM9544a, zM9544a2));
                        if (boundField != null) {
                            boundField2 = boundField;
                        }
                        i++;
                        boundField = boundField2;
                    }
                    if (boundField != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.f8948h);
                    }
                }
            }
            typeToken = TypeToken.get(C$Gson$Types.m9441a(typeToken.getType(), cls, cls.getGenericSuperclass()));
            cls = typeToken.getRawType();
        }
        return linkedHashMap;
    }

    static abstract class BoundField {

        /* JADX INFO: renamed from: h */
        final String f8948h;

        /* JADX INFO: renamed from: i */
        final boolean f8949i;

        /* JADX INFO: renamed from: j */
        final boolean f8950j;

        /* JADX INFO: renamed from: a */
        abstract void mo9545a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        /* JADX INFO: renamed from: a */
        abstract void mo9546a(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

        /* JADX INFO: renamed from: a */
        abstract boolean mo9547a(Object obj) throws IllegalAccessException, IOException;

        protected BoundField(String str, boolean z, boolean z2) {
            this.f8948h = str;
            this.f8949i = z;
            this.f8950j = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a */
        private final ObjectConstructor<T> f8946a;

        /* JADX INFO: renamed from: b */
        private final Map<String, BoundField> f8947b;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.f8946a = objectConstructor;
            this.f8947b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo9511f() == JsonToken.NULL) {
                jsonReader.mo9515j();
                return null;
            }
            T tMo9459a = this.f8946a.mo9459a();
            try {
                jsonReader.mo9508c();
                while (jsonReader.mo9510e()) {
                    BoundField boundField = this.f8947b.get(jsonReader.mo9512g());
                    if (boundField == null || !boundField.f8950j) {
                        jsonReader.mo9519n();
                    } else {
                        boundField.mo9545a(jsonReader, tMo9459a);
                    }
                }
                jsonReader.mo9509d();
                return tMo9459a;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.mo9535f();
                return;
            }
            jsonWriter.mo9533d();
            try {
                for (BoundField boundField : this.f8947b.values()) {
                    if (boundField.mo9547a(t)) {
                        jsonWriter.mo9528a(boundField.f8948h);
                        boundField.mo9546a(jsonWriter, t);
                    }
                }
                jsonWriter.mo9534e();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
