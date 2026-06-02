package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
class BasicYearDateTimeField extends ImpreciseDateTimeField {

    /* JADX INFO: renamed from: a */
    protected final BasicChronology f15906a;

    BasicYearDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.m16504s(), basicChronology.mo16632T());
        this.f15906a = basicChronology;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15906a.m16637a(j);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16436a(long j, int i) {
        return i == 0 ? j : mo16443b(j, FieldUtils.m16751a(mo16434a(j), i));
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16437a(long j, long j2) {
        return mo16436a(j, FieldUtils.m16752a(j2));
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, i, this.f15906a.mo16629Q(), this.f15906a.mo16630R());
        return this.f15906a.mo16659f(j, i);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: c */
    public long mo16450c(long j, int i) {
        FieldUtils.m16755a(this, i, this.f15906a.mo16629Q() - 1, this.f15906a.mo16630R() + 1);
        return this.f15906a.mo16659f(j, i);
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return null;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        return this.f15906a.mo16656e(mo16434a(j));
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public DurationField mo16457f() {
        return this.f15906a.mo16425s();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return this.f15906a.mo16629Q();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f15906a.mo16630R();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        return this.f15906a.m16653d(mo16434a(j));
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public long mo16454e(long j) {
        int iMo16434a = mo16434a(j);
        if (j != this.f15906a.m16653d(iMo16434a)) {
            return this.f15906a.m16653d(iMo16434a + 1);
        }
        return j;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return j - mo16452d(j);
    }
}
