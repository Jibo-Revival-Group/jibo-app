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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: a */
    public static final TypeAdapterFactory f8951a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b */
    private final DateFormat f8952b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized Date read(JsonReader jsonReader) throws IOException {
        Date date;
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            date = null;
        } else {
            try {
                date = new Date(this.f8952b.parse(jsonReader.mo9513h()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void write(JsonWriter jsonWriter, Date date) throws IOException {
        jsonWriter.mo9531b(date == null ? null : this.f8952b.format((java.util.Date) date));
    }
}
