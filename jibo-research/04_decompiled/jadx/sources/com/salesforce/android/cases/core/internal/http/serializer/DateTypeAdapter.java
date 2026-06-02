package com.salesforce.android.cases.core.internal.http.serializer;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: a */
    private final Class<? extends Date> f12326a;

    /* JADX INFO: renamed from: b */
    private final DateFormat f12327b;

    /* JADX INFO: renamed from: c */
    private final DateFormat f12328c;

    public DateTypeAdapter(Class<? extends Date> cls) {
        this(cls, DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    private DateTypeAdapter(Class<? extends Date> cls, DateFormat dateFormat, DateFormat dateFormat2) {
        if (cls != Date.class && cls != java.sql.Date.class && cls != Timestamp.class) {
            throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
        }
        this.f12326a = cls;
        this.f12327b = dateFormat;
        this.f12328c = dateFormat2;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.mo9535f();
            return;
        }
        synchronized (this.f12328c) {
            jsonWriter.mo9531b(this.f12327b.format(date));
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo9511f() == JsonToken.NULL) {
            jsonReader.mo9515j();
            return null;
        }
        Date dateM12360a = m12360a(jsonReader.mo9513h());
        if (this.f12326a != Date.class) {
            if (this.f12326a == Timestamp.class) {
                return new Timestamp(dateM12360a.getTime());
            }
            if (this.f12326a == java.sql.Date.class) {
                return new java.sql.Date(dateM12360a.getTime());
            }
            throw new AssertionError();
        }
        return dateM12360a;
    }

    /* JADX INFO: renamed from: a */
    private Date m12360a(String str) {
        Date dateM9623a;
        synchronized (this.f12328c) {
            try {
                dateM9623a = this.f12328c.parse(str);
            } catch (ParseException e) {
                try {
                    dateM9623a = this.f12327b.parse(str);
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
        return "DateTypeAdapter(" + this.f12328c.getClass().getSimpleName() + ')';
    }
}
