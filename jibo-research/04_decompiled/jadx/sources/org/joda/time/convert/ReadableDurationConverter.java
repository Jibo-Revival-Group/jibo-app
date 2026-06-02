package org.joda.time.convert;

import org.joda.time.ReadableDuration;

/* JADX INFO: loaded from: classes2.dex */
class ReadableDurationConverter extends AbstractConverter implements DurationConverter, PeriodConverter {

    /* JADX INFO: renamed from: a */
    static final ReadableDurationConverter f15989a = new ReadableDurationConverter();

    protected ReadableDurationConverter() {
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return ReadableDuration.class;
    }
}
