package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: a */
    public static final TypeAdapterFactory f8911a = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        /* JADX INFO: renamed from: a */
        public <T> TypeAdapter<T> mo9423a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b */
    private final DateFormat f8912b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* JADX INFO: renamed from: c */
    private final DateFormat f8913c = DateFormat.getDateTimeInstance(2, 2);

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() != JsonToken.NULL) {
            return m9497a(jsonReader.mo9513h());
        }
        jsonReader.mo9515j();
        return null;
    }

    /* JADX INFO: renamed from: a */
    private synchronized Date m9497a(String str) {
        Date dateM9623a;
        try {
            dateM9623a = this.f8913c.parse(str);
        } catch (ParseException e) {
            try {
                dateM9623a = this.f8912b.parse(str);
            } catch (ParseException e2) {
                try {
                    dateM9623a = ISO8601Utils.m9623a(str, new ParsePosition(0));
                } catch (ParseException e3) {
                    throw new JsonSyntaxException(str, e3);
                }
            }
        }
        return dateM9623a;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.mo9535f();
        } else {
            jsonWriter.mo9531b(this.f8912b.format(date));
        }
    }
}
