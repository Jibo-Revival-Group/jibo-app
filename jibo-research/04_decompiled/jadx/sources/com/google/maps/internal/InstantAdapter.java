package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.joda.time.Instant;

/* JADX INFO: loaded from: classes.dex */
public class InstantAdapter extends TypeAdapter<Instant> {
    @Override // com.google.gson.TypeAdapter
    public Instant read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        if (jsonReader.mo9511f() == JsonToken.NUMBER) {
            return new Instant(jsonReader.mo9517l() * 1000);
        }
        throw new UnsupportedOperationException("Unsupported format");
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Instant instant) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}
