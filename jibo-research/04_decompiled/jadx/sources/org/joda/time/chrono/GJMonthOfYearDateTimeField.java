package org.joda.time.chrono;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class GJMonthOfYearDateTimeField extends BasicMonthOfYearDateTimeField {
    GJMonthOfYearDateTimeField(BasicChronology basicChronology) {
        super(basicChronology, 2);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16439a(int i, Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16694b(i);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16445b(int i, Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16697c(i);
    }

    @Override // org.joda.time.field.BaseDateTimeField
    /* JADX INFO: renamed from: a */
    protected int mo16682a(String str, Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16693b(str);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16435a(Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16692b();
    }
}
