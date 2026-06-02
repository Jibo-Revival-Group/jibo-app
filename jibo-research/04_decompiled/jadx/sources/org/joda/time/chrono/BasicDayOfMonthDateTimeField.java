package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
final class BasicDayOfMonthDateTimeField extends PreciseDurationDateTimeField {

    /* JADX INFO: renamed from: b */
    private final BasicChronology f15894b;

    BasicDayOfMonthDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.m16498m(), durationField);
        this.f15894b = basicChronology;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15894b.m16647c(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f15894b.mo16392B();
    }

    @Override // org.joda.time.field.PreciseDurationDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return 1;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f15894b.m16628P();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public int mo16449c(long j) {
        return this.f15894b.m16663i(j);
    }

    @Override // org.joda.time.field.PreciseDurationDateTimeField
    /* JADX INFO: renamed from: d */
    protected int mo16665d(long j, int i) {
        return this.f15894b.mo16655e(j, i);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        return this.f15894b.mo16664j(j);
    }
}
