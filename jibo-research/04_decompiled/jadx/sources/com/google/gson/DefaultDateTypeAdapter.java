package com.google.gson;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class DefaultDateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: a */
    private final Class<? extends Date> f8780a;

    /* JADX INFO: renamed from: b */
    private final DateFormat f8781b;

    /* JADX INFO: renamed from: c */
    private final DateFormat f8782c;

    DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        this(cls, new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        this(cls, DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, DateFormat dateFormat, DateFormat dateFormat2) {
        if (cls != Date.class && cls != java.sql.Date.class && cls != Timestamp.class) {
            throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
        }
        this.f8780a = cls;
        this.f8781b = dateFormat;
        this.f8782c = dateFormat2;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.mo9535f();
            return;
        }
        synchronized (this.f8782c) {
            jsonWriter.mo9531b(this.f8781b.format(date));
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        Date dateM9331a = m9331a(jsonReader.mo9513h());
        if (this.f8780a != Date.class) {
            if (this.f8780a == Timestamp.class) {
                return new Timestamp(dateM9331a.getTime());
            }
            if (this.f8780a == java.sql.Date.class) {
                return new java.sql.Date(dateM9331a.getTime());
            }
            throw new AssertionError();
        }
        return dateM9331a;
    }

    /* JADX INFO: renamed from: a */
    private Date m9331a(String str) {
        Date dateM9623a;
        synchronized (this.f8782c) {
            try {
                dateM9623a = this.f8782c.parse(str);
            } catch (ParseException e) {
                try {
                    dateM9623a = this.f8781b.parse(str);
                } catch (ParseException e2) {
                    try {
                        dateM9623a = ISO8601Utils.m9623a(str, new ParsePosition(0));
                    } catch (ParseException e3) {
                        throw new JsonSyntaxException(str, e3);
                    }
                }
            }
        }
        return dateM9623a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DefaultDateTypeAdapter");
        sb.append('(').append(this.f8782c.getClass().getSimpleName()).append(')');
        return sb.toString();
    }
}
