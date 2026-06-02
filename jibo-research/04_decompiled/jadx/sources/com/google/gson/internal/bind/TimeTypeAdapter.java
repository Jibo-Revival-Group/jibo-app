package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {

    /* JADX INFO: renamed from: a */
    public static final TypeAdapterFactory f8953a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b */
    private final DateFormat f8954b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Time read(JsonReader jsonReader) throws IOException {
        Time time;
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            time = null;
        } else {
            try {
                time = new Time(this.f8954b.parse(jsonReader.mo9513h()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void write(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.mo9531b(time == null ? null : this.f8954b.format((Date) time));
    }
}
