package org.joda.time.convert;

import org.joda.time.Chronology;

/* JADX INFO: loaded from: classes2.dex */
class LongConverter extends AbstractConverter implements DurationConverter, InstantConverter, PartialConverter {

    /* JADX INFO: renamed from: a */
    static final LongConverter f15987a = new LongConverter();

    protected LongConverter() {
    }

    @Override // org.joda.time.convert.AbstractConverter, org.joda.time.convert.InstantConverter
    /* JADX INFO: renamed from: a */
    public long mo16726a(Object obj, Chronology chronology) {
        return ((Long) obj).longValue();
    }

    @Override // org.joda.time.convert.Converter
    /* JADX INFO: renamed from: a */
    public Class<?> mo16729a() {
        return Long.class;
    }
}
