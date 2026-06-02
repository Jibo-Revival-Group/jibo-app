package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
final class GJDayOfWeekDateTimeField extends PreciseDurationDateTimeField {

    /* JADX INFO: renamed from: b */
    private final BasicChronology f15929b;

    GJDayOfWeekDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.m16497l(), durationField);
        this.f15929b = basicChronology;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15929b.m16661g(j);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public String mo16439a(int i, Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16700d(i);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public String mo16445b(int i, Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16701e(i);
    }

    @Override // org.joda.time.field.BaseDateTimeField
    /* JADX INFO: renamed from: a */
    protected int mo16682a(String str, Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16696c(str);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f15929b.mo16429w();
    }

    @Override // org.joda.time.field.PreciseDurationDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return 1;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return 7;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16435a(Locale locale) {
        return GJLocaleSymbols.m16683a(locale).m16695c();
    }
}
