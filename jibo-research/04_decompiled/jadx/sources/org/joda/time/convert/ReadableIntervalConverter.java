package org.joda.time.convert;

import org.joda.time.ReadableInterval;

/* JADX INFO: loaded from: classes2.dex */
class ReadableIntervalConverter extends AbstractConverter implements DurationConverter, IntervalConverter, PeriodConverter {

    /* JADX INFO: renamed from: a */
    static final ReadableIntervalConverter f15991a = new ReadableIntervalConverter();

    protected ReadableIntervalConverter() {
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return ReadableInterval.class;
    }
}
