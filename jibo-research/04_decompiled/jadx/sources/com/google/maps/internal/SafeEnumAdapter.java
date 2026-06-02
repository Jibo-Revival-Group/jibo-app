package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Enum;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes.dex */
public class SafeEnumAdapter<E extends Enum<E>> extends TypeAdapter<E> {
    private static final Logger LOG = LoggerFactory.m17025a(SafeEnumAdapter.class.getName());
    private final Class<E> clazz;
    private final E unknownValue;

    public SafeEnumAdapter(E e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        this.unknownValue = e;
        this.clazz = e.getDeclaringClass();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, E e) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }

    @Override // com.google.gson.TypeAdapter
    public E read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        String strMo9513h = jsonReader.mo9513h();
        try {
            return (E) Enum.valueOf(this.clazz, strMo9513h.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException e) {
            LOG.mo17020a("Unknown type for enum {}: '{}'", this.clazz.getName(), strMo9513h);
            return this.unknownValue;
        }
    }
}
