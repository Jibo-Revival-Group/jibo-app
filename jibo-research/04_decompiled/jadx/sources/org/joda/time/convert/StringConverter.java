package org.joda.time.convert;

import org.joda.time.Chronology;
import org.joda.time.format.ISODateTimeFormat;

/* JADX INFO: loaded from: classes2.dex */
class StringConverter extends AbstractConverter implements DurationConverter, InstantConverter, IntervalConverter, PartialConverter, PeriodConverter {

    /* JADX INFO: renamed from: a */
    static final StringConverter f15994a = new StringConverter();

    protected StringConverter() {
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: a */
    public long mo16726a(Object obj, Chronology chronology) {
        return ISODateTimeFormat.m16904a().m16780a(chronology).m16777a((String) obj);
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return String.class;
    }
}
