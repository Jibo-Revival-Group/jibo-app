package org.joda.time.convert;

import java.util.Date;
import org.joda.time.Chronology;

/* JADX INFO: loaded from: classes2.dex */
final class DateConverter extends AbstractConverter implements InstantConverter, PartialConverter {

    /* JADX INFO: renamed from: a */
    static final DateConverter f15986a = new DateConverter();

    protected DateConverter() {
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: a */
    public long mo16726a(Object obj, Chronology chronology) {
        return ((Date) obj).getTime();
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return Date.class;
    }
}
