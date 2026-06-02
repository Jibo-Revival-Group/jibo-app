package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;

/* JADX INFO: loaded from: classes2.dex */
class ReadablePartialConverter extends AbstractConverter implements PartialConverter {

    /* JADX INFO: renamed from: a */
    static final ReadablePartialConverter f15992a = new ReadablePartialConverter();

    protected ReadablePartialConverter() {
    }

    @Override // org.joda.time.convert.AbstractConverter
    /* JADX INFO: renamed from: a */
    public Chronology mo16727a(Object obj, DateTimeZone dateTimeZone) {
        return mo16728b(obj, (Chronology) null).mo16406a(dateTimeZone);
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: b */
    public Chronology mo16728b(Object obj, Chronology chronology) {
        if (chronology == null) {
            return DateTimeUtils.m16516a(((ReadablePartial) obj).mo16590c());
        }
        return chronology;
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return ReadablePartial.class;
    }
}
