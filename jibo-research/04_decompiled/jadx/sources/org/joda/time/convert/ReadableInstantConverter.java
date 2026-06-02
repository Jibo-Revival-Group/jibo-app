package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;
import org.joda.time.chrono.ISOChronology;

/* JADX INFO: loaded from: classes2.dex */
class ReadableInstantConverter extends AbstractConverter implements InstantConverter, PartialConverter {

    /* JADX INFO: renamed from: a */
    static final ReadableInstantConverter f15990a = new ReadableInstantConverter();

    protected ReadableInstantConverter() {
    }

    @Override // org.joda.time.convert.AbstractConverter
    /* JADX INFO: renamed from: a */
    public Chronology mo16727a(Object obj, DateTimeZone dateTimeZone) {
        Chronology chronologyMo16581d = ((ReadableInstant) obj).mo16581d();
        if (chronologyMo16581d == null) {
            return ISOChronology.m16708b(dateTimeZone);
        }
        if (chronologyMo16581d.mo16407a() != dateTimeZone) {
            Chronology chronologyMo16406a = chronologyMo16581d.mo16406a(dateTimeZone);
            if (chronologyMo16406a == null) {
                return ISOChronology.m16708b(dateTimeZone);
            }
            return chronologyMo16406a;
        }
        return chronologyMo16581d;
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: b */
    public Chronology mo16728b(Object obj, Chronology chronology) {
        if (chronology == null) {
            return DateTimeUtils.m16516a(((ReadableInstant) obj).mo16581d());
        }
        return chronology;
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: a */
    public long mo16726a(Object obj, Chronology chronology) {
        return ((ReadableInstant) obj).mo16580c();
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return ReadableInstant.class;
    }
}
