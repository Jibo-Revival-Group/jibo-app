package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractConverter implements Converter {
    protected AbstractConverter() {
    }

    /* JADX INFO: renamed from: a */
    public long mo16726a(Object obj, Chronology chronology) {
        return DateTimeUtils.m16513a();
    }

    /* JADX INFO: renamed from: a */
    public Chronology mo16727a(Object obj, DateTimeZone dateTimeZone) {
        return ISOChronology.m16708b(dateTimeZone);
    }

    /* JADX INFO: renamed from: b */
    public Chronology mo16728b(Object obj, Chronology chronology) {
        return DateTimeUtils.m16516a(chronology);
    }

    public String toString() {
        return "Converter[" + (mo16729a() == null ? "null" : mo16729a().getName()) + "]";
    }
}
