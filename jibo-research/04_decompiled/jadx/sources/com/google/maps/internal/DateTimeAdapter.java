package com.google.maps.internal;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/* JADX INFO: loaded from: classes.dex */
public class DateTimeAdapter extends TypeAdapter<DateTime> {
    @Override // com.google.gson.TypeAdapter
    public DateTime read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        String strMo9513h = "";
        long jMo9517l = 0;
        jsonReader.mo9508c();
        while (jsonReader.mo9510e()) {
            String strMo9512g = jsonReader.mo9512g();
            if (strMo9512g.equals("text")) {
                jsonReader.mo9513h();
            } else if (strMo9512g.equals("time_zone")) {
                strMo9513h = jsonReader.mo9513h();
            } else if (strMo9512g.equals("value")) {
                jMo9517l = jsonReader.mo9517l();
            }
        }
        jsonReader.mo9509d();
        return new DateTime(jMo9517l * 1000, DateTimeZone.m16525a(strMo9513h));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, DateTime dateTime) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}
