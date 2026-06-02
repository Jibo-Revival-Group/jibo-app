package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.PreciseDurationDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
final class BasicDayOfYearDateTimeField extends PreciseDurationDateTimeField {

    /* JADX INFO: renamed from: b */
    private final BasicChronology f15895b;

    BasicDayOfYearDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.m16499n(), durationField);
        this.f15895b = basicChronology;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15895b.m16651d(j);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return this.f15895b.mo16394D();
    }

    @Override // org.joda.time.field.PreciseDurationDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return 1;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f15895b.m16627O();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public int mo16449c(long j) {
        return this.f15895b.m16636a(this.f15895b.m16637a(j));
    }

    @Override // org.joda.time.field.PreciseDurationDateTimeField
    /* JADX INFO: renamed from: d */
    protected int mo16665d(long j, int i) {
        int iM16627O = this.f15895b.m16627O() - 1;
        return (i > iM16627O || i < 1) ? mo16449c(j) : iM16627O;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        return this.f15895b.mo16664j(j);
    }
}
