package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.maps.model.Distance;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DistanceAdapter extends TypeAdapter<Distance> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Distance read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        Distance distance = new Distance();
        jsonReader.mo9508c();
        while (jsonReader.mo9510e()) {
            String strMo9512g = jsonReader.mo9512g();
            if (strMo9512g.equals("text")) {
                distance.humanReadable = jsonReader.mo9513h();
            } else if (strMo9512g.equals("value")) {
                distance.inMeters = jsonReader.mo9517l();
            }
        }
        jsonReader.mo9509d();
        return distance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Distance distance) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}
