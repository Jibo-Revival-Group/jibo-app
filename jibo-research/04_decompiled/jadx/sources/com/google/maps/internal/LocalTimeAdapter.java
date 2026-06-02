package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

/* JADX INFO: loaded from: classes.dex */
public class LocalTimeAdapter extends TypeAdapter<LocalTime> {
    @Override // com.google.gson.TypeAdapter
    public LocalTime read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        if (jsonReader.mo9511f() == JsonToken.STRING) {
            return LocalTime.m16593a(jsonReader.mo9513h(), DateTimeFormat.m16769a("HHmm"));
        }
        throw new UnsupportedOperationException("Unsupported format");
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, LocalTime localTime) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}
