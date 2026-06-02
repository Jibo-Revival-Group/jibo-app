package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

/* JADX INFO: loaded from: classes2.dex */
final class BasicWeekyearDateTimeField extends ImpreciseDateTimeField {

    /* JADX INFO: renamed from: a */
    private final BasicChronology f15905a;

    BasicWeekyearDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.m16501p(), basicChronology.mo16632T());
        this.f15905a = basicChronology;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public int mo16434a(long j) {
        return this.f15905a.m16654e(j);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16436a(long j, int i) {
        return i == 0 ? j : mo16443b(j, mo16434a(j) + i);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: a */
    public long mo16437a(long j, long j2) {
        return mo16436a(j, FieldUtils.m16752a(j2));
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public long mo16443b(long j, int i) {
        FieldUtils.m16755a(this, Math.abs(i), this.f15905a.mo16629Q(), this.f15905a.mo16630R());
        int iMo16434a = mo16434a(j);
        if (iMo16434a != i) {
            int iM16661g = this.f15905a.m16661g(j);
            int iM16642b = this.f15905a.m16642b(iMo16434a);
            int iM16642b2 = this.f15905a.m16642b(i);
            if (iM16642b2 >= iM16642b) {
                iM16642b2 = iM16642b;
            }
            int iM16657f = this.f15905a.m16657f(j);
            if (iM16657f <= iM16642b2) {
                iM16642b2 = iM16657f;
            }
            long jMo16659f = this.f15905a.mo16659f(j, i);
            int iMo16434a2 = mo16434a(jMo16659f);
            if (iMo16434a2 < i) {
                jMo16659f += 604800000;
            } else if (iMo16434a2 > i) {
                jMo16659f -= 604800000;
            }
            return this.f15905a.mo16426t().mo16443b((((long) (iM16642b2 - this.f15905a.m16657f(jMo16659f))) * 604800000) + jMo16659f, iM16661g);
        }
        return j;
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: e */
    public DurationField mo16455e() {
        return null;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: b */
    public boolean mo16448b(long j) {
        return this.f15905a.m16642b(this.f15905a.m16654e(j)) > 52;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: f */
    public DurationField mo16457f() {
        return this.f15905a.mo16429w();
    }

    @Override // org.joda.time.DateTimeField
    /* JADX INFO: renamed from: g */
    public int mo16458g() {
        return this.f15905a.mo16629Q();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: h */
    public int mo16460h() {
        return this.f15905a.mo16630R();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: d */
    public long mo16452d(long j) {
        long jMo16452d = this.f15905a.mo16430x().mo16452d(j);
        int iM16657f = this.f15905a.m16657f(jMo16452d);
        if (iM16657f > 1) {
            return jMo16452d - (((long) (iM16657f - 1)) * 604800000);
        }
        return jMo16452d;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    /* JADX INFO: renamed from: i */
    public long mo16462i(long j) {
        return j - mo16452d(j);
    }
}
